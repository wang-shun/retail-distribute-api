package cn.wonhigh.retail.scheduler.distribute.convert;

import java.util.List;

import cn.wonhigh.retail.distribute.common.constans.PublicConstans;
import cn.wonhigh.retail.distribute.common.model.BizNoTransform;
import cn.wonhigh.retail.distribute.common.utils.ContextUtils;
import cn.wonhigh.retail.scheduler.distribute.Constant;
import cn.wonhigh.retail.scheduler.distribute.SystemParamUtils;
import cn.wonhigh.retail.scheduler.distribute.mail.SendInfoUtils;
import cn.wonhigh.retail.uc.common.api.utils.CommonUtil;

import com.yougou.bi.mdm.api.vo.ProProductDto;

public class ColorConvert {

	/**
	 * 颜色转换
	 * @param proDto
	 * @param colorList
	 * @return
	 */
	public static String convent(ProProductDto pro) throws Exception{
		List<BizNoTransform> colorList= SystemParamUtils.getBizNoTransforms(Constant.TRANSFORM.COLOR,
				pro.getBrandNo(), pro.getColorNo());
		if(CommonUtil.hasValue(colorList)){
			if(colorList.size()>1){
				ContextUtils.setParam(PublicConstans.EXCHAGE_RESULT, false);
				SendInfoUtils.addErrorInfo("颜色编码color=["+pro.getColorNo()+"],从转换表中找到多条数据");
			}
			return colorList.get(0).getResponseNo();
		} else {
			ContextUtils.setParam(PublicConstans.EXCHAGE_RESULT, false);
			SendInfoUtils.addErrorInfo("颜色编码color=["+pro.getColorNo()+"],在转换表中不存在");
		}
		return null;
	}

}
