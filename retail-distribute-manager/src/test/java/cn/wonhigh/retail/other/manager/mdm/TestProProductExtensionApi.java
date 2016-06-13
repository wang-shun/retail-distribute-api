package cn.wonhigh.retail.other.manager.mdm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import cn.wonhigh.retail.distribute.common.JsonUtils;

import com.yougou.bi.mdm.api.service.ProProductExtensionApi;
import com.yougou.bi.mdm.api.vo.ProProductExtension;
import com.yougou.logistics.base.common.utils.SimplePage;

public class TestProProductExtensionApi extends BaseTest{
	
	@Resource(name="ProProductExtensionApi")
	ProProductExtensionApi api;

	@Test
	public void test(){
		String productNo = "20150612054367";
		
		Map<String,Object> params = new HashMap<>();
		params.put("productNo", productNo);
		SimplePage sp = new SimplePage(1, 5000, 5000);
		List<ProProductExtension> list = api.getProProductExtension(sp, null, null, params, null);
		System.out.println(JsonUtils.toJson(list));
	
	}
}
