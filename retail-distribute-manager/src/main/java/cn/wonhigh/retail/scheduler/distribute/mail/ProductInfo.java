package cn.wonhigh.retail.scheduler.distribute.mail;

import java.util.ArrayList;
import java.util.List;

import cn.wonhigh.retail.distribute.common.JsonUtils;

public class ProductInfo {

	private String productCode;//货号
	
	private List<String> sizeCode;//尺码
	
	private List<String> unSynSizeCode;//不需要同步的尺码
	
	private String errorInfo;//错误信息
	
	private String warnInfo;//警告信息
	
	private String brandDetailNo;//子品牌
	
	private String brandNo;//品牌
	
	private String updateTime;//更新时间
	
	private boolean isSuccess = true;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public List<String> getSizeCode() {
		return sizeCode;
	}
	
	/**
	 * freemark使用
	 * @return
	 */
	public String getSizeCodeStr() {
		return JsonUtils.toJson(this.sizeCode);
	}

	public void setSizeCode(List<String> sizeCode) {
		this.sizeCode = sizeCode;
	}
	
	public void addSizeCode(String sizeCode){
		if(this.sizeCode == null){
			this.sizeCode = new ArrayList<>();
		}
		this.sizeCode.add(sizeCode);
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	public String getBrandDetailNo() {
		return brandDetailNo;
	}

	public void setBrandDetailNo(String brandDetailNo) {
		this.brandDetailNo = brandDetailNo;
	}

	public String getBrandNo() {
		return brandNo;
	}

	public void setBrandNo(String brandNo) {
		this.brandNo = brandNo;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	/**
	 * freemark需要用到
	 * @return
	 */
	public boolean getSuccess() {
		return isSuccess;
	}
	
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public List<String> getUnSynSizeCode() {
		return unSynSizeCode;
	}
	
	/**
	 * freemark使用
	 * @return
	 */
	public String getUnSynSizeCodeStr() {
		return JsonUtils.toJson(this.unSynSizeCode);
	}

	public void setUnSynSizeCode(List<String> unSynSizeCode) {
		this.unSynSizeCode = unSynSizeCode;
	}

	public void addUnSynSizeCode(String sizeCode){
		if(this.unSynSizeCode == null){
			this.unSynSizeCode = new ArrayList<>();
		}
		this.unSynSizeCode.add(sizeCode);
	}

	public String getWarnInfo() {
		return warnInfo;
	}

	public void setWarnInfo(String warnInfo) {
		this.warnInfo = warnInfo;
	}
}
