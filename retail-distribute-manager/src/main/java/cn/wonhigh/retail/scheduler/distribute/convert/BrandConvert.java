package cn.wonhigh.retail.scheduler.distribute.convert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.wonhigh.retail.distribute.common.constans.PublicConstans;
import cn.wonhigh.retail.distribute.common.model.BizNoTransform;
import cn.wonhigh.retail.distribute.common.model.DistributeCltypeNew;
import cn.wonhigh.retail.distribute.common.utils.ContextUtils;
import cn.wonhigh.retail.distribute.service.DistributeCltypeNewService;
import cn.wonhigh.retail.scheduler.distribute.Constant;
import cn.wonhigh.retail.scheduler.distribute.SystemParamUtils;
import cn.wonhigh.retail.scheduler.distribute.mail.SendInfoUtils;
import cn.wonhigh.retail.uc.common.api.utils.CommonUtil;

import com.yougou.bi.mdm.api.vo.ProProductDto;

@Component
public class BrandConvert {

	private static Map<String,String> brand = new HashMap<>();
	
	private static DistributeCltypeNewService cltypeNewService;
	
	static {
		brand.put("JP01", "020001");
	
	}
	
	public static String getBrandDetail(ProProductDto pro){
		//String brandDetail = brand.get(brandDetailNo);
		List<BizNoTransform> brandDetail = SystemParamUtils.getBizNoTransforms(Constant.TRANSFORM.BRAND_DETAIL,
				pro.getBrandNo(), pro.getBrandDetailNo());
		if(CommonUtil.hasValue(brandDetail)){
			if(brandDetail.size()>1){
				ContextUtils.setParam(PublicConstans.EXCHAGE_RESULT, false);
				SendInfoUtils.addErrorInfo("子品牌["+pro.getBrandDetailNo()+"],从转换表中找到多条数据");
			}
			return brandDetail.get(0).getResponseNo();
		} else {
			ContextUtils.setParam(PublicConstans.EXCHAGE_RESULT, false);
			SendInfoUtils.addErrorInfo("子品牌["+pro.getBrandDetailNo()+"],在转换表中不存在");
			return null;
		}
	}
	
	public static String getTypeNo(String brandNo){
		String typeno = brand.get(brandNo);
		if(typeno == null){
			Map<String,Object> params = new HashMap<>();
			params.put("typename", "子品牌");
			List<DistributeCltypeNew> cls = cltypeNewService.selectByParams(params);
			if(null == cls || cls.size() == 0){
				ContextUtils.setParam(PublicConstans.EXCHAGE_RESULT, false);
				SendInfoUtils.addErrorInfo("品牌["+brandNo+"],在分销库中不存在子品牌");
				return null;
			}
			typeno = cls.get(0).getTypeno();
			brand.put(brandNo, typeno);
		}
		return typeno;
	}

	@Resource
	public void setCltypeNewService(
			DistributeCltypeNewService cltypeNewService) {
		BrandConvert.cltypeNewService = cltypeNewService;
	}
	
}
