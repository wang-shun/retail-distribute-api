package cn.wonhigh.retail.distribute.dal.distribute.inteceptor;

import cn.wonhigh.retail.distribute.common.enums.DataSource;

public class DataSourceHolder {

	private static ThreadLocal<String> BRAND_NO = new ThreadLocal<>();
	
	public static void set(String brandNo){
		BRAND_NO.set(brandNo);
	}
	
	public static String get(){
		String brandNo = BRAND_NO.get();
		//Assert.notNull(brandNo,"当前线程中品牌部编码为空");
		return brandNo;
	}
	
	public static DataSource getDataSource(){
		String brandNo = get();
		if(null == brandNo)return null;
		return DataSource.valueOf(brandNo);
	}
}
