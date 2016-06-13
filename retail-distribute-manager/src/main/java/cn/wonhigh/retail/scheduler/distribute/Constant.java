package cn.wonhigh.retail.scheduler.distribute;

public interface Constant {

	/**
	 * 品牌部
	 * @author user
	 *
	 */
	interface BRAND{
		String BRAND = "brand";//品牌部
		String BRAND_NO = "brandNo";//子品牌
		String JP = "JP";
	}
	
	interface TRANSFORM{
		String SUPPLY = "SUPPLY";//供应商
		String STATUS = "STATUS";//状态
		String SIZETYPE = "SIZETYPE";//尺寸类别
		String SIZE = "SIZE"; //尺寸
		String COLOR = "COLOR";//颜色
		String BIGTYPE = "BIGTYPE";//大类
		String BRAND_DETAIL = "BRAND_DETAIL";//子品牌
	}
}
