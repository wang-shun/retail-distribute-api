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
import cn.wonhigh.retail.distribute.common.model.DistributeColothTB;
import cn.wonhigh.retail.distribute.common.utils.JsonUtils;
import cn.wonhigh.retail.distribute.dal.distribute.jp.database.DistributeColothTBMapper;

public class TestColothTBMapper extends BaseDalTest {
	
	@Resource
	DistributeColothTBMapper distributeColothTBMapper;
	
	Log LOG = LogFactory.getLog(TestColothTBMapper.class);
	
	@Test
	public void testSelectByParams(){
		Map<String,Object> params = new HashMap<>();
		params.put("colthno", "J3A00111*00EY4");
		List<DistributeColothTB> blist = distributeColothTBMapper.selectByParams(null, params);
		LOG.info(JsonUtils.toJson(blist));
		Assert.notNull(blist);
	}
	
	@Test
	public void testSelectByPrimaryKey(){
		DistributeColothTB p = new DistributeColothTB();
		p.setColthno("J3A00111*00EY4");
		p = distributeColothTBMapper.selectByPrimaryKey(p);
		LOG.info(JsonUtils.toJson(p));
		Assert.notNull(p.getShoestyle());
	}
	
	@Test
	public void testInsert(){
		DistributeColothTB p = new DistributeColothTB();
		p.setColthno("J3A00111*00EY4A");
		p.setShoestyle("1");
		p.setColthname4("");
		p.setBz1("1");
		p.setBz2("2");
		p.setBz3("3");
		p.setGxrq(new Date());
		p.setYhid("api");
		int n = distributeColothTBMapper.insert(p);
		Assert.isTrue(n>0);
	}
	
	@Test
	public void testUpdateByPrimaryKey(){
		DistributeColothTB p = new DistributeColothTB();
		p.setColthno("J3A00111*00EY4A");
		p.setShoestyle("1.5");
		p.setGxrq(new Date());
		p.setYhid("api");
		int n = distributeColothTBMapper.updateByPrimaryKey(p);
		Assert.isTrue(n>0);
	}
	
	@Test
	public void testDeleteByPrimarayKeyForModel(){
		DistributeColothTB p = new DistributeColothTB();
		p.setColthno("J3A00111*00EY4A");
		int n = distributeColothTBMapper.deleteByPrimarayKeyForModel(p);
		Assert.isTrue(n>0);
	}
}
