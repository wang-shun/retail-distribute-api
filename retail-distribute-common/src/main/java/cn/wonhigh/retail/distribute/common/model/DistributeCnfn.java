package cn.wonhigh.retail.distribute.common.model;

import java.io.Serializable;

/**
 * 分销供应商
 * @author user
 *
 */
public class DistributeCnfn implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cusno;//供应商编码
	
	private String names;//供应商名称

	public String getCusno() {
		return cusno;
	}

	public void setCusno(String cusno) {
		this.cusno = cusno;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}
	
	
}
