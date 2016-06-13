package cn.wonhigh.retail.distribute.common.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 集团属性
 * @author user
 *
 */
public class DistributeCltypep implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public DistributeCltypep(){};
	
	public DistributeCltypep(String typeno, String classno) {
		this.typeno = typeno;
		this.classno = classno;
	}


	public DistributeCltypep(String typeno, String colthno, String classno,
		 Date gxrq, String yhid) {
		this.typeno = typeno;
		this.colthno = colthno;
		this.classno = classno;
		this.gxrq = gxrq;
		this.yhid = yhid;
	}


	/**
	 * 属性编码
	 */
	private String typeno;
	
	/**
	 * 货号
	 */
	private String colthno;
	
	/**
	 * 属性值编码
	 */
	private String classno;
	
	/**
	 * 属性值名称
	 */
	private String classname;

	/**
	 * 修改日期
	 */
	private Date gxrq;
	
	/**
	 * 修改人
	 */
	private String yhid;

	public String getTypeno() {
		return typeno;
	}

	public void setTypeno(String typeno) {
		this.typeno = typeno;
	}

	public String getColthno() {
		return colthno;
	}

	public void setColthno(String colthno) {
		this.colthno = colthno;
	}

	public String getClassno() {
		return classno;
	}

	public void setClassno(String classno) {
		this.classno = classno;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colthno == null) ? 0 : colthno.hashCode());
		result = prime * result + ((typeno == null) ? 0 : typeno.hashCode());
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
		DistributeCltypep other = (DistributeCltypep) obj;
		if (colthno == null) {
			if (other.colthno != null)
				return false;
		} else if (!colthno.equals(other.colthno))
			return false;
		if (typeno == null) {
			if (other.typeno != null)
				return false;
		} else if (!typeno.equals(other.typeno))
			return false;
		return true;
	}

}
