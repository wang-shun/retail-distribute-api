package cn.wonhigh.retail.scheduler.distribute.convert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import cn.wonhigh.retail.distribute.common.constans.PublicConstans;
import cn.wonhigh.retail.distribute.common.distribute.DistributeLog;
import cn.wonhigh.retail.distribute.common.model.DistributeCltypeNew;
import cn.wonhigh.retail.distribute.common.model.DistributeCltypebNew;
import cn.wonhigh.retail.distribute.common.model.DistributeCltypep;
import cn.wonhigh.retail.distribute.common.utils.ContextUtils;
import cn.wonhigh.retail.distribute.service.DistributeCltypeNewService;
import cn.wonhigh.retail.distribute.service.DistributeCltypebNewService;
import cn.wonhigh.retail.scheduler.distribute.ProductApi;
import cn.wonhigh.retail.scheduler.distribute.mail.SendInfoUtils;
import cn.wonhigh.retail.uc.common.api.utils.CommonUtil;

import com.yougou.bi.mdm.api.vo.ProAttribute;
import com.yougou.bi.mdm.api.vo.ProAttributeDetail;
import com.yougou.bi.mdm.api.vo.ProProductDto;
import com.yougou.bi.mdm.api.vo.ProProductExtension;

/**
 * 品牌级属性转换
 * @author user
 *
 */
@Component
public class BrandAttributeConvert {


	private static ProductApi productApi;
	

	private static DistributeCltypebNewService distributeCltypebNewService;
	

	private static DistributeCltypeNewService distributeCltypeNewService;


	public static List<DistributeCltypep> convert(ProProductDto pro){
		Map<String,Object> params = new HashMap<>();
		params.put("productNo", pro.getProductNo());
		List<ProProductExtension> plist = productApi.getProProductExtension(params);
		return convert(plist,pro);
	}
	
	public static List<DistributeCltypep> convert(List<ProProductExtension> plist,ProProductDto pro){
		
		if(null == plist || plist.size() == 0){
			return null;
		} else {
			//移除非品牌属性
			Iterator<ProProductExtension> it = plist.iterator();
			while(it.hasNext()){
				ProProductExtension extension = it.next();
				if(extension.getAttributeFlag() != 1){
					it.remove();
				}
			}
			//获取
			Map<String,Object> params = new HashMap<>();
			params.put("brandDetailNo", pro.getBrandDetailNo());
			List<ProAttribute> alist = productApi.getProAttribute(params);
			List<DistributeCltypep> blist = new ArrayList<>();
			for(ProProductExtension ext : plist){
				//查找typename
				String typename = null;
				for(ProAttribute attr : alist){
					if(attr.getAttributeNo().equals(ext.getAttributeNo())){
						typename = attr.getAttributeName();
					}
				}
				if(null == typename){
					continue;
				}
				//查找classname
				String classname = null;
				params.put("attributeNo", ext.getAttributeNo());
				params.put("attributeDetailNo", ext.getAttributeDetailNo());
				List<ProAttributeDetail> dlist = productApi.getProAttributeDetail(params);
				if(!CommonUtil.hasValue(dlist)){
					continue;
				}
				classname = dlist.get(0).getAttributeDetailName();
				DistributeCltypep p = buildCltypep(typename,classname);
				if(null == p){
					continue;
				}
				p.setGxrq(ext.getEdittm());
				p.setYhid(ext.getEditor());
				p.setClassname(classname);
				blist.add(p);
			}
			return blist;
		}
	}
	
	private static DistributeCltypep buildCltypep(String typename,String classname){
		if(null == typename || classname == null){
			DistributeLog.warn("构建品牌属性出错，typename或者classname为空");
			return null;
		}
		Map<String,Object> params = new HashMap<>();
		params.put("typename", typename);
		params.put("classname", classname);
		List<DistributeCltypebNew> blist = distributeCltypebNewService.getDistributeCltypebNewList(params);
		if(CommonUtil.hasValue(blist)){
			DistributeCltypebNew b = blist.get(0);
			DistributeCltypep p = new DistributeCltypep(b.getTypeno(),b.getClassno());
			return p;
		} else {
			//如果找不到，校验typename是否存，如果不存在，直接跳过该属性
			List<DistributeCltypeNew> list = distributeCltypeNewService.selectByParams(params);
			if(!CommonUtil.hasValue(list)){
				SendInfoUtils.addWarnInfo("品牌属性["+typename+"="+classname+"]在分销库中不存在，跳过该属性");
				return null;
			} else {
				//如果值是~线，就直接忽略
				if(StringUtils.equals("~", classname)){
					SendInfoUtils.addWarnInfo(typename+","+classname+"在分销库中不存在,直接忽略该属性");
				} else {
					ContextUtils.setParam(PublicConstans.EXCHAGE_RESULT, false);
					SendInfoUtils.addErrorInfo(typename+","+classname+"在分销库中不存在");
				}
				return null;
			}

		}
	}
	

	@Resource
	public void setDistributeCltypebNewService(
			DistributeCltypebNewService distributeCltypebNewService) {
		BrandAttributeConvert.distributeCltypebNewService = distributeCltypebNewService;
	}
	
	@Resource
	public void setDistributeCltypeNewService(
			DistributeCltypeNewService distributeCltypeNewService) {
		BrandAttributeConvert.distributeCltypeNewService = distributeCltypeNewService;
	}
	
	@Resource
	public  void setProductApi(ProductApi productApi) {
		BrandAttributeConvert.productApi = productApi;
	}
}
