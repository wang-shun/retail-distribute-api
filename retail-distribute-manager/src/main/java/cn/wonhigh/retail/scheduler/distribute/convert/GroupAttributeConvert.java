package cn.wonhigh.retail.scheduler.distribute.convert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import cn.wonhigh.retail.distribute.common.constans.PublicConstans;
import cn.wonhigh.retail.distribute.common.distribute.DistributeLog;
import cn.wonhigh.retail.distribute.common.model.DistributeCltypebNew;
import cn.wonhigh.retail.distribute.common.model.DistributeCltypep;
import cn.wonhigh.retail.distribute.common.utils.ContextUtils;
import cn.wonhigh.retail.distribute.service.DistributeCltypebNewService;
import cn.wonhigh.retail.scheduler.distribute.ProductApi;
import cn.wonhigh.retail.scheduler.distribute.mail.SendInfoUtils;
import cn.wonhigh.retail.uc.common.api.utils.CommonUtil;

import com.yougou.bi.mdm.api.vo.ProAttributeDetail;

@Component
public class GroupAttributeConvert {


	private static ProductApi productApi;
	
	private static DistributeCltypebNewService distributeCltypebNewService;
	
	public static DistributeCltypep convertGroupAttribute(String brandNo,String typeName,String attributeDetailNo){
		if(!CommonUtil.hasValue(attributeDetailNo)){
			DistributeLog.warn("typeName="+typeName+",主数据未设置值");
			return null;
		}
		Map<String,Object> params = new HashMap<>();
		params.put("brandNo", brandNo);
		params.put("attributeDetailNo", attributeDetailNo);
		List<ProAttributeDetail> dlist = productApi.getProAttributeDetail(params);
		if(CommonUtil.hasValue(dlist)){
			String classname = dlist.get(0).getAttributeDetailName();
			params.put("typename", typeName);
			params.put("classname", classname);
			List<DistributeCltypebNew> blist = distributeCltypebNewService.getDistributeCltypebNewList(params);
			if(CommonUtil.hasValue(blist)){
				DistributeCltypebNew b = blist.get(0);
				DistributeCltypep p = new DistributeCltypep(b.getTypeno(),b.getClassno());
				p.setClassname(classname);
				return p;
			} else {
				//如果值是~线，就直接忽略
				if(StringUtils.equals("~", classname)){
					SendInfoUtils.addWarnInfo(typeName+","+classname+"在分销库中不存在,直接忽略该属性");
				} else {
					ContextUtils.setParam(PublicConstans.EXCHAGE_RESULT, false);
					SendInfoUtils.addErrorInfo(typeName+","+classname+"在分销库中不存在");

				}
				return null;
			
			}
		}
		DistributeLog.error("brandNo="+brandNo+",attributeDetailNo="+attributeDetailNo+",从BI-MDM返回数据为空");
		return null;
	}

	@Resource
	public void setProductApi(ProductApi productApi) {
		GroupAttributeConvert.productApi = productApi;
	}

	@Resource
	public void setDistributeCltypebNewService(
			DistributeCltypebNewService distributeCltypebNewService) {
		GroupAttributeConvert.distributeCltypebNewService = distributeCltypebNewService;
	}
	
}
