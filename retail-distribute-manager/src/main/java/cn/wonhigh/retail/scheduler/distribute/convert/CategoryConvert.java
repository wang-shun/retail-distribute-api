package cn.wonhigh.retail.scheduler.distribute.convert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wonhigh.retail.distribute.common.constans.PublicConstans;
import cn.wonhigh.retail.distribute.common.distribute.DistributeLog;
import cn.wonhigh.retail.distribute.common.model.BizNoTransform;
import cn.wonhigh.retail.distribute.common.model.DistributeCltypebNew;
import cn.wonhigh.retail.distribute.common.model.DistributeCltypep;
import cn.wonhigh.retail.distribute.common.utils.ContextUtils;
import cn.wonhigh.retail.distribute.manager.BizNoTransformManager;
import cn.wonhigh.retail.distribute.service.DistributeCltypebNewService;
import cn.wonhigh.retail.scheduler.distribute.Constant;
import cn.wonhigh.retail.scheduler.distribute.ProductApi;
import cn.wonhigh.retail.scheduler.distribute.mail.SendInfoUtils;
import cn.wonhigh.retail.uc.common.api.utils.CommonUtil;

import com.yougou.bi.mdm.api.vo.ProCategory;
import com.yougou.bi.mdm.api.vo.ProProductDto;
import com.yougou.logistics.base.common.exception.ManagerException;

/**
 * 大类转换
 * @author user
 *
 */
@Service
public class CategoryConvert {


	private static ProductApi productApi;
	
	private static DistributeCltypebNewService distributeCltypebNewService;
	
	private static BizNoTransformManager bizNoTransformManager;
	
	public static DistributeCltypep convertCategory(ProProductDto pro) throws ManagerException{
		String className = convert(pro.getCategoriesNo(), pro.getBrandNo());
		// 根据大类名称从分销库中查取大类编码
		if(className == null){
			return null;
		}
		Map<String,Object> params2 = new HashMap<>();
		params2.put("typename", "大类");
		params2.put("classname", className);
		
		//对类名称作转换
		List<DistributeCltypebNew> list2 =  distributeCltypebNewService.getDistributeCltypebNewList(params2);
		
		if(null == list2 || list2.size() == 0){
			ContextUtils.setParam(PublicConstans.EXCHAGE_RESULT, false);
			SendInfoUtils.addErrorInfo("大类,"+className+"在分销库中不存在");
			return null;
		}
		DistributeCltypebNew b = list2.get(0);
		DistributeCltypep p2 = new DistributeCltypep(b.getTypeno(),//001
				b.getClassno());
		return p2;
	}
	
	
	public static String convert(String categoryNo,String brandNo) throws ManagerException{
		if(!CommonUtil.hasValue(categoryNo)){
			DistributeLog.warn("大类,在主数据未设置值");
			return null;
		}
		//从BI-MDM 根据品牌和类别过滤出大类
		Map<String,Object> bigTypeParam=new HashMap<String,Object>();
		bigTypeParam.put("brandNo", brandNo);
		bigTypeParam.put("categoryNo", categoryNo);
		List<ProCategory> list = productApi.getProCategory(bigTypeParam);
		if(null == list || list.size() == 0){
			ContextUtils.setParam(PublicConstans.EXCHAGE_RESULT, false);
			SendInfoUtils.addErrorInfo("大类编码["+categoryNo+"],在BI-MDM中不存在");
			return null;
		}
		//从转换表中转换
		bigTypeParam=new HashMap<String,Object>();
		bigTypeParam.put("type",Constant.TRANSFORM.BIGTYPE);
		bigTypeParam.put("brandNo", brandNo);
		bigTypeParam.put("requestNo", list.get(0).getCategoryName());
		List<BizNoTransform> bigTypeList=bizNoTransformManager.findByBiz(null, bigTypeParam);
		if(CommonUtil.hasValue(bigTypeList)){
			if(bigTypeList.size()>1){
				ContextUtils.setParam(PublicConstans.EXCHAGE_RESULT, false);
				SendInfoUtils.addErrorInfo("大类["+bigTypeList.get(0).getResponseNo()+"],从转换表中找到多条数据");
			}
			return bigTypeList.get(0).getResponseNo();
		} else {
			ContextUtils.setParam(PublicConstans.EXCHAGE_RESULT, false);
			SendInfoUtils.addErrorInfo("大类["+list.get(0).getCategoryName()+"],在转换表中不存在");
			return null;
		}
	}
	
	@Resource
	public void setBizNoTransformManager(
			BizNoTransformManager bizNoTransformManager) {
		CategoryConvert.bizNoTransformManager = bizNoTransformManager;
	}

	@Resource
	public  void setProductApi(ProductApi productApi) {
		CategoryConvert.productApi = productApi;
	}

	@Resource
	public void setDistributeCltypebNewService(
			DistributeCltypebNewService distributeCltypebNewService) {
		CategoryConvert.distributeCltypebNewService = distributeCltypebNewService;
	}

}
