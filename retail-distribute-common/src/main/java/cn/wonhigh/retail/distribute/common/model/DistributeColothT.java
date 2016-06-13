package cn.wonhigh.retail.distribute.common.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品主档
 * @author user
 *
 */
public class DistributeColothT implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 货号
	 */
	private String colthno;
	
	/**
	 * 名称
	 */
	private String colthname;
	
	/**
	 * 全称
	 */
	private String colthname3;
	
	/**
	 * 英文名称
	 */
	private String colthname2;
	
	/**
	 * 楦型
	 */
	private String location;
	
	/**
	 * 板单号
	 */
	private String styleno;
	
	/**
	 * 货号2
	 */
	private String originhh;
	
	/**
	 * 品牌
	 */
	private String sizekind2;
	
	/**
	 * 厂商代号
	 */
	private String cusno;
	
	/**
	 * 工厂货号
	 */
	private String colthnob;
	
	/**
	 * 面料
	 */
	private String mainqdb;
	
	/**
	 * 类别  新品 0/普通 1/三线 2/废品 3/物料 4/临时 5/挂失 6/
	 */
	private String valids;
	
	/**
	 * 尺寸类别
	 */
	private String sizekind;
	
	/**
	 * 牌价
	 */
	private BigDecimal sprice = new BigDecimal(1.0);
	
	/**
	 * 成本
	 */
	private BigDecimal price = new BigDecimal(1.0);
	
	/**
	 * 工价
	 */
	private BigDecimal gprice = new BigDecimal(1.0);
	
	/**
	 * 修改日期
	 */
	private Date gxrq;
	
	/**
	 * 修改人
	 */
	private String yhid;

	private boolean isExchangeSuccess;
	
	public String getColthno() {
		return colthno;
	}

	public void setColthno(String colthno) {
		this.colthno = colthno;
	}

	public String getColthname() {
		return colthname;
	}

	public void setColthname(String colthname) {
		this.colthname = colthname;
	}

	public String getColthname3() {
		return colthname3;
	}

	public void setColthname3(String colthname3) {
		this.colthname3 = colthname3;
	}

	public String getColthname2() {
		return colthname2;
	}

	public void setColthname2(String colthname2) {
		this.colthname2 = colthname2;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStyleno() {
		return styleno;
	}

	public void setStyleno(String styleno) {
		this.styleno = styleno;
	}

	public String getOriginhh() {
		return originhh;
	}

	public void setOriginhh(String originhh) {
		this.originhh = originhh;
	}

	public String getSizekind2() {
		return sizekind2;
	}

	public void setSizekind2(String sizekind2) {
		this.sizekind2 = sizekind2;
	}

	public String getCusno() {
		return cusno;
	}

	public void setCusno(String cusno) {
		this.cusno = cusno;
	}

	public String getColthnob() {
		return colthnob;
	}

	public void setColthnob(String colthnob) {
		this.colthnob = colthnob;
	}

	public String getMainqdb() {
		return mainqdb;
	}

	public void setMainqdb(String mainqdb) {
		this.mainqdb = mainqdb;
	}

	public String getValids() {
		return valids;
	}

	public void setValids(String valids) {
		this.valids = valids;
	}

	public String getSizekind() {
		return sizekind;
	}

	public void setSizekind(String sizekind) {
		this.sizekind = sizekind;
	}

	public Date getGxrq() {
		return gxrq;
	}

	public void setGxrq(Date gxrq) {
		this.gxrq = gxrq;
	}

	public String getYhid() {
		return yhid;
	}

	public void setYhid(String yhid) {
		this.yhid = yhid;
	}

	public BigDecimal getSprice() {
		return sprice;
	}

	public void setSprice(BigDecimal sprice) {
		this.sprice = sprice;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getGprice() {
		return gprice;
	}

	public void setGprice(BigDecimal gprice) {
		this.gprice = gprice;
	}

	public boolean isExchangeSuccess() {
		return isExchangeSuccess;
	}

	public void setExchangeSuccess(boolean isExchangeSuccess) {
		this.isExchangeSuccess = isExchangeSuccess;
	}

}
