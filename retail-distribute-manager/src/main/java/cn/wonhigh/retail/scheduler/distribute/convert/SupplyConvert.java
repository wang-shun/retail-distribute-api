package cn.wonhigh.retail.scheduler.distribute.convert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wonhigh.retail.distribute.common.constans.PublicConstans;
import cn.wonhigh.retail.distribute.common.model.BizNoTransform;
import cn.wonhigh.retail.distribute.common.model.DistributeCnfn;
import cn.wonhigh.retail.distribute.common.utils.ContextUtils;
import cn.wonhigh.retail.distribute.service.BizNoTransformService;
import cn.wonhigh.retail.distribute.service.DistributeCnfnService;
import cn.wonhigh.retail.scheduler.distribute.Constant;
import cn.wonhigh.retail.scheduler.distribute.mail.SendInfoUtils;
import cn.wonhigh.retail.uc.common.api.utils.CommonUtil;

import com.yougou.logistics.base.common.exception.ServiceException;

/**
 * 转供应商
 * @author user
 *
 */
@Service
public class SupplyConvert {

	private static BizNoTransformService bizNoTransformService;
	
	private static DistributeCnfnService distributeCnfnService;
	
	public static String convert(String supplyNo,String brand) throws ServiceException{
		if(!CommonUtil.hasValue(supplyNo)){
			return supplyNo;
		}
		Map<String,Object> params = new HashMap<>();
		params.put("type", Constant.TRANSFORM.SUPPLY);
		params.put("brandNo", brand);
		params.put("requestNo", supplyNo);
		List<BizNoTransform> list = bizNoTransformService.findByBiz(null, params);
		if(CommonUtil.hasValue(list)){
			//如果有多个，转换失败
			
			if(list.size()>1){
				ContextUtils.setParam(PublicConstans.EXCHAGE_RESULT, false);
				SendInfoUtils.addErrorInfo("供应商cusno=["+supplyNo+"]转换失败,从转换表中找到多条数据");
			}
			supplyNo =  list.get(0).getResponseNo();
		}
		if(!checkIsInDatabase(supplyNo)){
			//找不到供应商，也算成功，给出提示信息就OK
			//ContextUtils.setParam(PublicConstans.EXCHAGE_RESULT, false);
			SendInfoUtils.addWarnInfo("供应商cusno=["+supplyNo+"]在分库库中不存在");
		} 
		//校验供应商是否在分销库中存在
		return supplyNo;
	}
	
	public static boolean checkIsInDatabase(String cusno){
		DistributeCnfn cnfn = distributeCnfnService.getDistributeCnfn(cusno);
		if(null == cnfn)return false;
		return true;
	}

	@Resource
	public void setBizNoTransformService(
			BizNoTransformService bizNoTransformService) {
		SupplyConvert.bizNoTransformService = bizNoTransformService;
	}

	@Resource
	public void setDistributeCnfnService(
			DistributeCnfnService distributeCnfnService) {
		SupplyConvert.distributeCnfnService = distributeCnfnService;
	}

}
