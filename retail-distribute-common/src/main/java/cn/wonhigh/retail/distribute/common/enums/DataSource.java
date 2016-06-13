package cn.wonhigh.retail.distribute.common.enums;

public enum DataSource {

	JP("JP","dataSourceJP"),BS("BS","dataSourceBS"),BL("BL","dataSourceBL"),
	TT("TT","dataSourceTT"),TM("TM","dataSourceTM"),ST("ST","dataSourceST"),
	SD("SD","dataSourceSD");
	
	private String dataSource;
	private String brandNo;
	
	DataSource(String brandNo,String dataSource){
		this.brandNo = brandNo;
		this.dataSource = dataSource;
	}
	
	public String getDataSource(){
		return this.dataSource;
	}

	public String getBrandNo() {
		return brandNo;
	}

}
