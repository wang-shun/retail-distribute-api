package cn.wonhigh.retail.other.manager.mdm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import cn.wonhigh.retail.distribute.common.JsonUtils;

import com.yougou.bi.mdm.api.service.ProBarcodeApi;
import com.yougou.bi.mdm.api.vo.ProBarcode;
import com.yougou.logistics.base.common.utils.SimplePage;

public class TestProBarcodeApi extends BaseTest {

	@Resource(name="ProBarcodeApi")
	ProBarcodeApi api;

	@Test
	public void test(){
		String productNo = "20141206210486";
		
		Map<String,Object> params = new HashMap<>();
		//params.put("productNo", productNo);
		//params.put("edittm", "2015-06-11 13:00:12");
		params.put("defaultValue", "Y");
		SimplePage sp = new SimplePage(1, 3, 3);
		List<ProBarcode> list = api.getProBarcode(sp, null, null, params, null);
		System.out.println(JsonUtils.toJson(list));
	
	}
}
