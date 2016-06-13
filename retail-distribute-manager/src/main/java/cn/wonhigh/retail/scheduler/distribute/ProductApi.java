package cn.wonhigh.retail.scheduler.distribute;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wonhigh.retail.distribute.common.JsonUtils;
import cn.wonhigh.retail.distribute.common.distribute.DistributeLog;

import com.yougou.bi.mdm.api.service.ProAttributeApi;
import com.yougou.bi.mdm.api.service.ProAttributeDetailApi;
import com.yougou.bi.mdm.api.service.ProBarcodeApi;
import com.yougou.bi.mdm.api.service.ProCategoryApi;
import com.yougou.bi.mdm.api.service.ProProductApi;
import com.yougou.bi.mdm.api.service.ProProductExtensionApi;
import com.yougou.bi.mdm.api.vo.ProAttribute;
import com.yougou.bi.mdm.api.vo.ProAttributeDetail;
import com.yougou.bi.mdm.api.vo.ProBarcode;
import com.yougou.bi.mdm.api.vo.ProCategory;
import com.yougou.bi.mdm.api.vo.ProProductDto;
import com.yougou.bi.mdm.api.vo.ProProductExtension;
import com.yougou.logistics.base.common.utils.SimplePage;

/**
 * 封装主数据API
 * @author user
 *
 */
@Service
public class ProductApi {

	@Resource(name="ProProductApi")
	private ProProductApi proProductApi;
	
	@Resource(name="ProBarcodeApi")
	private ProBarcodeApi proBarcodeApi;
	
	@Resource(name="ProAttributeApi")
	private ProAttributeApi proAttributeApi;
	
	@Resource(name="ProAttributeDetailApi")
	private ProAttributeDetailApi proAttributeDetailApi;
	
	@Resource(name="ProProductExtensionApi")
	private ProProductExtensionApi proProductExtensionApi;
	
	@Resource(name="ProCategoryApi")
	private ProCategoryApi proCategoryApi;
	
	public int getCountProProduct(Map<String,Object> params){
		DistributeLog.info("调用MDM产品接口,入参 :"+JsonUtils.toJson(params));
		int count = proProductApi.findCount(params);
		DistributeLog.info("调用MDM产品接口,出参 :"+count);
		return count;
	}
	
	public List<ProProductDto> getProProduct(Map<String,Object> params,SimplePage pg){
		DistributeLog.info("调用MDM产品接口,入参 :"+JsonUtils.toJson(pg)+","+JsonUtils.toJson(params));
		List<ProProductDto> proList = proProductApi.getProProduct(pg, null,null,params,null);
		DistributeLog.info("调用MDM产品接口,出参 :"+JsonUtils.toJson(proList));
		return proList;
	}
	
	public List<ProBarcode> getProBarcode(Map<String,Object> params){
		DistributeLog.info("调用MDM产品条码接口,入参 :"+JsonUtils.toJson(params));
		SimplePage pg = new SimplePage(1,5000,5000);
		List<ProBarcode> proList = proBarcodeApi.getProBarcode(pg, null,null,params,null);
		DistributeLog.info("调用MDM产品条码接口,出参 :"+JsonUtils.toJson(proList));
		return proList;
	}
	
	public List<ProAttribute> getProAttribute(Map<String,Object> params){
		DistributeLog.info("调用MDM产品属性接口,入参 :"+JsonUtils.toJson(params));
		SimplePage pg = new SimplePage(1,5000,5000);
		List<ProAttribute> proList = proAttributeApi.getProAttribute(pg, null,null,params,null);
		DistributeLog.info("调用MDM产品属性接口,出参 :"+JsonUtils.toJson(proList));
		return proList;
	}
	
	public List<ProAttributeDetail> getProAttributeDetail(Map<String,Object> params){
		DistributeLog.info("调用MDM产品属性明细接口,入参 :"+JsonUtils.toJson(params));
		SimplePage pg = new SimplePage(1,5000,5000);
		List<ProAttributeDetail> proList = proAttributeDetailApi.getProAttributeDetail(pg, null,null,params,null);
		DistributeLog.info("调用MDM产品属性明细接口,出参 :"+JsonUtils.toJson(proList));
		return proList;
	}
	
	public List<ProProductExtension> getProProductExtension(Map<String,Object> params){
		DistributeLog.info("调用MDM产品扩展接口,入参 :"+JsonUtils.toJson(params));
		SimplePage pg = new SimplePage(1,5000,5000);
		List<ProProductExtension> proList = proProductExtensionApi.getProProductExtension(pg, null,null,params,null);
		DistributeLog.info("调用MDM产品扩展接口,出参 :"+JsonUtils.toJson(proList));
		return proList;
	}
	
	public List<ProCategory> getProCategory(Map<String,Object> params){
		DistributeLog.info("调用MDM产品大类接口,入参 :"+JsonUtils.toJson(params));
		SimplePage pg = new SimplePage(1,5000,5000);
		List<ProCategory> proList = proCategoryApi.getProCategory(pg, null,null,params,null);
		DistributeLog.info("调用MDM产品大类接口,出参 :"+JsonUtils.toJson(proList));
		return proList;
	}
}
