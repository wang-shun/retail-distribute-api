package cn.wonhigh.retail.other.manager.mdm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import cn.wonhigh.retail.distribute.common.JsonUtils;

import com.yougou.bi.mdm.api.service.ProCategoryApi;
import com.yougou.bi.mdm.api.vo.ProCategory;
import com.yougou.logistics.base.common.utils.SimplePage;

public class TestProCategoryApi extends BaseTest{


	private static ProCategoryApi api;
	
	@Test
	public void test(){
		Map<String,Object> params = new HashMap<>();
		params.put("categoryNo", "010302");
		SimplePage sp = new SimplePage(1, 5000, 5000);
		List<ProCategory> list = api.getProCategory(sp, null, null, params, null);
		System.out.println(JsonUtils.toJson(list));
	}

	@Resource
	public void setApi(ProCategoryApi api) {
		TestProCategoryApi.api = api;
	}
	
}
