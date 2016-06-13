package cn.wonhigh.retail.api.other.Distribute.jp.database;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.util.Assert;

import cn.wonhigh.retail.api.other.Distribute.BaseDalTest;
import cn.wonhigh.retail.distribute.common.model.DistributeCltypep;
import cn.wonhigh.retail.distribute.common.utils.JsonUtils;
import cn.wonhigh.retail.distribute.dal.distribute.jp.database.DistributeCltypepMapper;

public class TestCltypepMapper extends BaseDalTest{

	@Resource
	DistributeCltypepMapper distributeCltypepMapper;
	
	Log LOG = LogFactory.getLog(TestCltypeNewMapper.class);
	
	@Test
	public void testSelectByParams(){
		Map<String,Object> params = new HashMap<>();
		params.put("colthno", "J3A00111*00EY4");
		List<DistributeCltypep> blist = distributeCltypepMapper.selectByParams(null, params);
		LOG.info(JsonUtils.toJson(blist));
		Assert.notNull(blist);
	}
	
	@Test
	public void testInsert(){
		DistributeCltypep p = new DistributeCltypep();
		p.setColthno("J3A00111*00EY4");
		p.setTypeno("111");
		p.setClassno("111");
		p.setClassname("测试1");
		p.setGxrq(new Date());
		p.setYhid("api");
		int n = distributeCltypepMapper.insert(p);
		Assert.isTrue(n>0);
	}
	
	@Test
	public void testUpdateByPrimaryKey(){
		DistributeCltypep p = new DistributeCltypep();
		p.setColthno("J3A00111*00EY4");
		p.setTypeno("111");
		p.setClassno("111");
		p.setClassname("测试2");
		p.setGxrq(new Date());
		p.setYhid("api");
		int n = distributeCltypepMapper.updateByPrimaryKey(p);
		Assert.isTrue(n>0);
	}
	
	@Test
	public void testDeleteByPrimarayKeyForModel(){
		DistributeCltypep p = new DistributeCltypep();
		p.setColthno("J3A00111*00EY4");
		p.setTypeno("111");
		p.setGxrq(new Date());
		p.setYhid("api");
		int n = distributeCltypepMapper.deleteByPrimarayKeyForModel(p);
		Assert.isTrue(n>0);
	}
}
