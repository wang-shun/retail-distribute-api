package cn.wonhigh.retail.other.manager.mdm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import cn.wonhigh.retail.distribute.common.JsonUtils;

import com.yougou.bi.mdm.api.service.ProProductApi;
import com.yougou.bi.mdm.api.vo.ProProductDto;
import com.yougou.logistics.base.common.utils.SimplePage;

public class TestProProductApi extends BaseTest{

	@Resource(name="ProProductApi")
	ProProductApi api;

	@Test
	public void test(){
		String productNo = "20150612054367";
		
		Map<String,Object> params = new HashMap<>();
		//params.put("edittm", "2014-01-01 00:00:00");
		params.put("brandNo", "JP");
		params.put("productNo", "20150612054367");
		SimplePage sp = new SimplePage(1, 3, 3);
		List<ProProductDto> list = api.getProProduct(sp, null, null, params, null);
		System.out.println(JsonUtils.toJson(list));
	
	}
}
