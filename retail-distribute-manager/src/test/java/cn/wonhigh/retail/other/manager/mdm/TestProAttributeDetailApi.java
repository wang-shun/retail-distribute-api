package cn.wonhigh.retail.other.manager.mdm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import cn.wonhigh.retail.distribute.common.JsonUtils;

import com.yougou.bi.mdm.api.service.ProAttributeDetailApi;
import com.yougou.bi.mdm.api.vo.ProAttributeDetail;
import com.yougou.logistics.base.common.utils.SimplePage;

public class TestProAttributeDetailApi extends BaseTest{

	@Resource(name="ProAttributeDetailApi")
	ProAttributeDetailApi api;

	@Test
	public void test(){
		
		Map<String,Object> params = new HashMap<>();
	//	params.put("attributeNo", "20141203000213");
		params.put("brandNo", "JP");
		params.put("attributeDetailNo", "20141017000012");
		SimplePage sp = new SimplePage(1, 5000, 5000);
		List<ProAttributeDetail> list = api.getProAttributeDetail(sp, null, null, params, null);
		System.out.println(JsonUtils.toJson(list));
	
	}
}
