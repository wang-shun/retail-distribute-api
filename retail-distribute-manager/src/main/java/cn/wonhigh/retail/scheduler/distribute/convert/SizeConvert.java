package cn.wonhigh.retail.scheduler.distribute.convert;

import java.util.List;

import cn.wonhigh.retail.distribute.common.constans.PublicConstans;
import cn.wonhigh.retail.distribute.common.model.BizNoTransform;
import cn.wonhigh.retail.distribute.common.utils.ContextUtils;
import cn.wonhigh.retail.scheduler.distribute.Constant;
import cn.wonhigh.retail.scheduler.distribute.SystemParamUtils;
import cn.wonhigh.retail.scheduler.distribute.mail.SendInfoUtils;
import cn.wonhigh.retail.uc.common.api.utils.CommonUtil;

import com.yougou.bi.mdm.api.vo.ProBarcode;
import com.yougou.bi.mdm.api.vo.ProProductDto;

public class SizeConvert {

	
	/**
	 * 尺码转换
	 * @param pro
	 * @param sizeList
	 * @return
	 */
	public static String convert(ProBarcode bar,ProProductDto pro) throws Exception{

		String sizeTypeCode = pro.getSizeTypeCode();
		if(SizeTypeConvert.isSpecail(pro)){
			String sexName = SizeTypeConvert.getSex(pro.getGenderNo());
			if(null == sexName) return null;
			sizeTypeCode = sizeTypeCode+"_"+sexName;
		}
		BizNoTransform biz = SystemParamUtils.getSizeCode(Constant.TRANSFORM.SIZE, 
				pro.getBrandNo(), bar.getSizeCode(), sizeTypeCode);
		if(null != biz && CommonUtil.hasValue(biz.getResponseNo())){
			return biz.getResponseNo();
		}
		return null;
	}
	
	public static void specialSizeCodeD(List<ProBarcode> proList){
		if(CommonUtil.hasValue(proList)){
			//是否只存在F码
			int fcount = 0;
			for(ProBarcode bar : proList){
				if("F".equals(bar.getSizeCode())){
					fcount++;
				}
			}
			//只存在F码
			if(fcount == proList.size()&& proList.size() == 1){
				ContextUtils.setParam("sizeTypeCode", "D");
				SendInfoUtils.addWarnInfo("该货号为F码，尺码类型转为D");
			} else if(fcount == 0){
				return;
			} else {
				ContextUtils.setParam(PublicConstans.EXCHAGE_RESULT, false);
				SendInfoUtils.addErrorInfo("同时存在F码与其它尺码");
			}
		}
	}
}
