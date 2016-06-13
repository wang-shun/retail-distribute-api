package cn.wonhigh.retail.distribute.common.model;

import java.io.Serializable;

/**
 * 分销类别
 * @author user
 *
 */
public class DistributeCltypeNew implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 属性编码
	 */
	private String typeno;
	
	/**
	 * 名称 
	 */
	private String typename;

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
	
	

}
