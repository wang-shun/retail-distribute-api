package cn.wonhigh.retail.api.other.Distribute.jp.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

import cn.wonhigh.retail.api.other.Distribute.BaseDalTest;
import cn.wonhigh.retail.distribute.common.model.DistributeCltypeNew;
import cn.wonhigh.retail.distribute.common.utils.JsonUtils;
import cn.wonhigh.retail.distribute.dal.distribute.jp.database.DistributeCltypeNewMapper;

public class TestCltypeNewMapper extends BaseDalTest{

	private Log LOG = LogFactory.getLog(TestCltypeNewMapper.class);
	
	@Resource
	DistributeCltypeNewMapper distributeCltypeNewMapper;
	
	@Test
	public void testSelectByPrimaryKey(){
		DistributeCltypeNew b = new DistributeCltypeNew();
		b.setTypeno("005");
		b = distributeCltypeNewMapper.selectByPrimaryKey(b);
		LOG.info(JsonUtils.toJson(b));
		Assert.assertNotNull(b.getTypename());
	}
	
	@Test
	public void testSelectByParams(){
		Map<String,Object> params = new HashMap<>();
		params.put("typeno", "005");
		List<DistributeCltypeNew> blist = distributeCltypeNewMapper.selectByParams(null, params);
		LOG.info(JsonUtils.toJson(blist));
		Assert.assertNotNull(blist);
	}
}
