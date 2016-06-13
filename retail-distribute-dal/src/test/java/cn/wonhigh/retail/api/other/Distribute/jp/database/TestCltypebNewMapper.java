package cn.wonhigh.retail.api.other.Distribute.jp.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.util.Assert;

import cn.wonhigh.retail.api.other.Distribute.BaseDalTest;
import cn.wonhigh.retail.distribute.common.model.DistributeCltypebNew;
import cn.wonhigh.retail.distribute.common.utils.JsonUtils;
import cn.wonhigh.retail.distribute.dal.distribute.jp.database.DistributeCltypebNewMapper;

public class TestCltypebNewMapper extends BaseDalTest{

	@Resource
	DistributeCltypebNewMapper distributeCltypebNewMapper;
	
	Log LOG = LogFactory.getLog(TestCltypeNewMapper.class);
	
	@Test
	public void testSelectByParams(){
		Map<String,Object> param = new HashMap<>();
		param.put("typeno", "005");
		List<DistributeCltypebNew> blist = distributeCltypebNewMapper.selectByParams(null, param);
		LOG.info(JsonUtils.toJson(blist));
		Assert.notNull(blist);
	}
}
