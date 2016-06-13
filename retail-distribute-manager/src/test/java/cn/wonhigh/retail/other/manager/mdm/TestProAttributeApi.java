package cn.wonhigh.retail.other.manager.mdm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import cn.wonhigh.retail.distribute.common.JsonUtils;

import com.yougou.bi.mdm.api.service.ProAttributeApi;
import com.yougou.bi.mdm.api.vo.ProAttribute;
import com.yougou.logistics.base.common.utils.SimplePage;

public class TestProAttributeApi extends BaseTest{

	@Resource(name="ProAttributeApi")
	ProAttributeApi api;

	@Test
	public void test(){
		
		Map<String,Object> params = new HashMap<>();
		params.put("brandDetailNo", "JP01");
		//params.put("attributeNo", "20141017000003");
		SimplePage sp = new SimplePage(1, 5000, 5000);
		List<ProAttribute> list = api.getProAttribute(sp, null, null, params, null);
		System.out.println(JsonUtils.toJson(list));
	}
}
