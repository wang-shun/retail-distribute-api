package cn.wonhigh.retail.scheduler.distribute.convert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.wonhigh.retail.distribute.common.constans.PublicConstans;
import cn.wonhigh.retail.distribute.common.model.BizNoTransform;
import cn.wonhigh.retail.distribute.common.utils.ContextUtils;
import cn.wonhigh.retail.distribute.service.BizNoTransformService;
import cn.wonhigh.retail.scheduler.distribute.Constant;
import cn.wonhigh.retail.scheduler.distribute.mail.SendInfoUtils;
import cn.wonhigh.retail.uc.common.api.utils.CommonUtil;

import com.yougou.logistics.base.common.exception.ServiceException;

/**
 * 转状态
 * @author user
 *
 */
@Component
public class StatusConvert {

	private static BizNoTransformService bizNoTransformService;
	
	public static String convert(byte status,String brand) throws ServiceException{
		Map<String,Object> params = new HashMap<>();
		params.put("type", Constant.TRANSFORM.STATUS);
		//params.put("brandNo", brand);
		params.put("requestNo", status+"");
		List<BizNoTransform> list = bizNoTransformService.findByBiz(null, params);
		if(CommonUtil.hasValue(list)){
			//如果有多个，直接报错
			if(list.size()>1){
				ContextUtils.setParam(PublicConstans.EXCHAGE_RESULT, false);
				SendInfoUtils.addErrorInfo("状态status=["+status+"],从转换表中找到多条数据");
			}
			return list.get(0).getResponseNo();
		}
		return "0";
	}

	@Resource
	public void setBizNoTransformService(
			BizNoTransformService bizNoTransformService) {
		StatusConvert.bizNoTransformService = bizNoTransformService;
	}
}
