package cn.wonhigh.retail.distribute.common.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品颜色及SIZE
 * @author user
 *
 */
public class DistributeColoth implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 序号
	 */
	private Integer recno;
	
	/**
	 * 货号
	 */
	private String colthno;
	
	/**
	 * 规格 mcolor-msize
	 */
	private String colorNos;
	
	/**
	 * 名称
	 */
	private String colthname;
	
	/**
	 * 条码
	 */
	private String words;
	
	/**
	 * 尺寸
	 */
	private String msize;
	
	/**
	 * 颜色
	 */
	private String mcolor;
	
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

	public Integer getRecno() {
		return recno;
	}

	public void setRecno(Integer recno) {
		this.recno = recno;
	}

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

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public String getMsize() {
		return msize;
	}

	public void setMsize(String msize) {
		this.msize = msize;
	}

	public String getMcolor() {
		return mcolor;
	}

	public void setMcolor(String mcolor) {
		this.mcolor = mcolor;
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

	public String getColorNos() {
		return colorNos;
	}

	public void setColorNos(String colorNos) {
		this.colorNos = colorNos;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colthno == null) ? 0 : colthno.hashCode());
		result = prime * result + ((msize == null) ? 0 : msize.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DistributeColoth other = (DistributeColoth) obj;
		if (colthno == null) {
			if (other.colthno != null)
				return false;
		} else if (!colthno.equals(other.colthno))
			return false;
		if (msize == null) {
			if (other.msize != null)
				return false;
		} else if (!msize.equals(other.msize))
			return false;
		return true;
	}

}
