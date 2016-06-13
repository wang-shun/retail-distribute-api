package cn.wonhigh.retail.distribute.common.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品鞋型
 * @author user
 *
 */
public class DistributeColothTB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 货号
	 */
	private String colthno;
	
	/**
	 * 款型
	 */
	private String shoestyle;
	
	/**
	 * 工厂名称
	 */
	private String colthname4;
	
	/**
	 * 主体颜色
	 */
	private String bz1;
	
	/**
	 * 衬里/内垫
	 */
	private String bz2;
	
	/**
	 * 外底
	 */
	private String bz3;
	
	/**
	 * 修改日期
	 */
	private Date gxrq;
	
	/**
	 * 修改人
	 */
	private String yhid;

	public String getColthno() {
		return colthno;
	}

	public void setColthno(String colthno) {
		this.colthno = colthno;
	}

	public String getShoestyle() {
		return shoestyle;
	}

	public void setShoestyle(String shoestyle) {
		this.shoestyle = shoestyle;
	}

	public String getColthname4() {
		return colthname4;
	}

	public void setColthname4(String colthname4) {
		this.colthname4 = colthname4;
	}

	public String getBz1() {
		return bz1;
	}

	public void setBz1(String bz1) {
		this.bz1 = bz1;
	}

	public String getBz2() {
		return bz2;
	}

	public void setBz2(String bz2) {
		this.bz2 = bz2;
	}

	public String getBz3() {
		return bz3;
	}

	public void setBz3(String bz3) {
		this.bz3 = bz3;
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

}
