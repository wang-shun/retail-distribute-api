package cn.wonhigh.retail.distribute.common.model;

import java.io.Serializable;

public class DistributeCltypebNew implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 属性编码
	 */
	private String typeno;
	
	/**
	 * 名称 
	 */
	private String typename;
	
	
	/**
	 * 类编码
	 */
	private String classno;
	
	/**
	 * 类名称
	 */
	private String classname;

	public String getTypeno() {
		return typeno;
	}

	public void setTypeno(String typeno) {
		this.typeno = typeno;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
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
	
}
