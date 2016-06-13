package cn.wonhigh.retail.scheduler.distribute.convert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wonhigh.retail.distribute.common.constans.PublicConstans;
import cn.wonhigh.retail.distribute.common.distribute.DistributeLog;
import cn.wonhigh.retail.distribute.common.model.BizNoTransform;
import cn.wonhigh.retail.distribute.common.model.DistributeColothT;
import cn.wonhigh.retail.distribute.common.utils.ContextUtils;
import cn.wonhigh.retail.distribute.manager.BizNoTransformManager;
import cn.wonhigh.retail.scheduler.distribute.Constant;
import cn.wonhigh.retail.scheduler.distribute.ProductApi;
import cn.wonhigh.retail.scheduler.distribute.mail.SendInfoUtils;
import cn.wonhigh.retail.uc.common.api.utils.CommonUtil;

import com.yougou.bi.mdm.api.vo.ProAttributeDetail;
import com.yougou.bi.mdm.api.vo.ProProductDto;
@Service
public class SizeTypeConvert {
	
	private static ProductApi productApi;
	
	private static BizNoTransformManager bizNoTransformManager;
	
	private static Map<String,String> SEX_NAME = new HashMap<>();//小类存，存放性别名称
	
	/**
	 * 从MDM的尺寸类别到分销的尺寸类别
	 * @param brand
	 * @param sizeKind
	 * @return
	 */
	public static String convert(ProProductDto pro) throws Exception{
		//根据品牌和类别过滤出尺寸类别,如果是TT品牌并且尺寸类别是A1，特殊处理
		String sizeTypeCode = pro.getSizeTypeCode();
		String brandNo = pro.getBrandNo();
		if(isSpecail(pro)){
			String sexName = getSex(pro.getGenderNo());
			if(null == sexName) return null;
			sizeTypeCode = sizeTypeCode+"_"+sexName;
		}
		Map<String,Object> sizeTypeParam=new HashMap<String,Object>();
		sizeTypeParam.put("brandNo", brandNo);
		sizeTypeParam.put("type",Constant.TRANSFORM.SIZETYPE);
		sizeTypeParam.put("requestNo",sizeTypeCode);
		List<BizNoTransform> sizeTypeList=bizNoTransformManager.findByBiz(null, sizeTypeParam);
		if(CommonUtil.hasValue(sizeTypeList)){
			if(sizeTypeList.size()>1){
				ContextUtils.setParam(PublicConstans.EXCHAGE_RESULT, false);
				SendInfoUtils.addErrorInfo("尺码类型sizeType=["+sizeTypeCode+"],从转换表中找到多条数据");
			}
			return sizeTypeList.get(0).getResponseNo();
		} else {
			ContextUtils.setParam(PublicConstans.EXCHAGE_RESULT, false);
			SendInfoUtils.addErrorInfo("尺码类型sizeType=["+sizeTypeCode+"],在转换表中不存在");
		}
		return null;
	}
	
	public static boolean isSpecail(ProProductDto pro){
		if("TT".equals(pro.getBrandNo()) && "A1".equals(pro.getSizeTypeCode())){
			return true;
		}
		return false;
	}
	
	/**
	 * TT品牌特殊处理
	 * @return
	 */
	public static String getSex(String genderNo){
		if(null == genderNo){
			ContextUtils.setParam(PublicConstans.EXCHAGE_RESULT, false);
			SendInfoUtils.addErrorInfo("TT品牌，尺寸类别为A1,该货号性别不能为空");
			return null;
		}
		String sexName = SEX_NAME.get(genderNo);
		if(null == sexName){
			Map<String,Object> params = new HashMap<>();
			params.put("attributeDetailNo", genderNo);
			List<ProAttributeDetail> ds = productApi.getProAttributeDetail(params);
			sexName = ds.get(0).getAttributeDetailName();
			SEX_NAME.put(genderNo, sexName);
		}
		
		return sexName;
	}
	
	public static void replaceSizeTypeCode(DistributeColothT colothT){
		String sizeTypeCode = (String)ContextUtils.getParam("sizeTypeCode");
		if(sizeTypeCode == null){
			return;
		} else {
			//清除sizeTypeCode
			ContextUtils.setParam("sizeTypeCode", null);
			colothT.setSizekind(sizeTypeCode);
			DistributeLog.info("清除sizeTypeCode成功");
		}
	}
	
	
	@Resource
	public void setBizNoTransformManager(
			BizNoTransformManager bizNoTransformManager) {
		SizeTypeConvert.bizNoTransformManager = bizNoTransformManager;
	}
	
	@Resource
	public void setProductApi(ProductApi productApi) {
		SizeTypeConvert.productApi = productApi;
	}
	
}
