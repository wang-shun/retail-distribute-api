package cn.wonhigh.retail.scheduler.distribute.mail;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cn.wonhigh.retail.distribute.common.utils.DateUtil;

public class MailSendInfo {
	
	private String brandNo;
	
	private String productCode;

	private static String PRODUCT = "PRODUCT";
	private static String RESULT = "RESULT";
	private static String ERROR_CODE = "ERROR_CODE";
	//private static String ERROR_INFO = "ERROR_INFO";
	
	private static String EXCEPTION_CODE = "2000";//异常导致的失败
	private static String EXCHANGE_CODE = "3000";//转换导致的失败
	private static String SUCCESS_CODE = "1000";//成功
	
	//private Map<String,ProductInfo> product;品牌下的产品信息
	//private Map<String,String> result;//品牌下面同步产品的所有结果信息
	private Map<String/**品牌部*/,Object> result = new HashMap<>();
	
	/**
	 * 添加转换失败的错误信息
	 * @param errorInfo
	 */
	public void addErrorInfo(String errorInfo){
		ProductInfo p = getProduct();
		String err = p.getErrorInfo();
		if(null == err){
			p.setErrorInfo(errorInfo);
		} else {
			p.setErrorInfo(err+";"+errorInfo);
		}
		p.setSuccess(false);
		//设置转换失败
		getProductResult().put(ERROR_CODE, EXCHANGE_CODE);
	}
	
	/**
	 * 添加警告信息
	 * @param errorInfo
	 */
	public void addWarnInfo(String warnInfo){
		ProductInfo p = getProduct();
		String war = p.getWarnInfo();
		if(null == war){
			p.setWarnInfo(warnInfo);
		} else {
			p.setWarnInfo(war+";"+warnInfo);
		}
	}
	
	/**
	 * 同步的尺码
	 * @param sizeCode
	 */
	public void addSizeCode(String sizeCode){
		ProductInfo p = getProduct();
		p.addSizeCode(sizeCode);
	}
	
	/**
	 * 不需要同步的尺码
	 * @param sizeCode
	 */
	public void addUnSynSizeCode(String sizeCode){
		ProductInfo p = getProduct();
		p.addUnSynSizeCode(sizeCode);
	}
	

	@SuppressWarnings("unchecked")
	private Map<String,ProductInfo> getProductMap(){
		Map<String,Object> om = getBrandMap();
		Map<String,ProductInfo> pm = (Map<String, ProductInfo>) om.get(PRODUCT);
		if(null == pm){
			pm = new HashMap<>();
			om.put(PRODUCT, pm);
		}
		return pm;
	}
	
	@SuppressWarnings("unchecked")
	private Map<String,String> getProductResult(){
		Map<String,Object> om = getBrandMap();
		Map<String,String> pm = (Map<String, String>) om.get(RESULT);
		if(null == pm){
			pm = new HashMap<>();
			result.put(RESULT, pm);
		}
		return pm;
	}
	
	
	@SuppressWarnings("unchecked")
	private Map<String,Object> getBrandMap(){
		Map<String,Object> pm = (Map<String, Object>) result.get(brandNo);
		if(null == pm){
			pm = new HashMap<>();
			//获取品牌信息时，设置该品牌默契认同步成功
			Map<String,String> re = new HashMap<>();
			re.put(ERROR_CODE, SUCCESS_CODE);
			pm.put(RESULT, re);
			result.put(brandNo, pm);
		}
		return pm;
	}
	
	/**
	 * 根据产品货号获取产品信息
	 * @return
	 */
	private ProductInfo getProduct(){
		Map<String,ProductInfo> pm = getProductMap();
		ProductInfo p = pm.get(productCode);
		if(null == p){
			p = new ProductInfo();
			pm.put(productCode, p);
			p.setBrandNo(brandNo);
			p.setProductCode(productCode);
			p.setUpdateTime(DateUtil.getDateTime(new Date()));
		}
		return p;
	}
	
	/**
	 * 添加异常错误信息
	 */
	public void setExcetionError(){
		Map<String,String> pm = getProductResult();
		pm.put(ERROR_CODE, EXCEPTION_CODE);
	} 

	public String getBrandNo() {
		return brandNo;
	}

	public void setBrandNo(String brandNo) {
		this.brandNo = brandNo;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Map<String, Object> getResult() {
		return result;
	}

}
