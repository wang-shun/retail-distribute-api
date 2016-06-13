package cn.wonhigh.retail.api.other.Distribute.jp.database;

import java.math.BigDecimal;
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
import cn.wonhigh.retail.distribute.common.model.DistributeColothT;
import cn.wonhigh.retail.distribute.common.utils.JsonUtils;
import cn.wonhigh.retail.distribute.dal.distribute.jp.database.DistributeColothTMapper;

public class TestColothTMapper extends BaseDalTest{

	@Resource
	DistributeColothTMapper distributeColothTMapper;
	
	Log LOG = LogFactory.getLog(TestColothTMapper.class);
	
	@Test
	public void testSelectByParams(){
		Map<String,Object> params = new HashMap<>();
		params.put("colthno", "J3A00111*00EY4");
		List<DistributeColothT> blist = distributeColothTMapper.selectByParams(null, params);
		LOG.info(JsonUtils.toJson(blist));
		Assert.notNull(blist);
	}
	
	@Test
	public void testSelectByPrimaryKey(){
		DistributeColothT p = new DistributeColothT();
		p.setColthno("J3A00111*00EY4");
		p = distributeColothTMapper.selectByPrimaryKey(p);
		LOG.info(JsonUtils.toJson(p));
		Assert.notNull(p.getColthname());
	}
	
	@Test
	public void testInsert(){
		DistributeColothT p = new DistributeColothT();
		p.setColthno("J3A00111*00EY4A");
		p.setColthname("测试1");
		p.setColthname3("测试1");
		p.setLocation("F");
		p.setStyleno("0000000000");
		p.setSizekind2("J");
		p.setCusno("003A");
		p.setMainqdb("");
		p.setValids("0");
		p.setSizekind("D");
		
		p.setSprice(new BigDecimal(1.0));
		p.setPrice(new BigDecimal(1.0));
		p.setGprice(new BigDecimal(1.0));
		p.setGxrq(new Date());
		p.setYhid("api");
		int n = distributeColothTMapper.insert(p);
		Assert.isTrue(n>0);
	}
	
	@Test
	public void testUpdateByPrimaryKey(){
		DistributeColothT p = new DistributeColothT();
		p.setColthno("J3A00111*00EY4A");
		p.setColthname("测试2");
		p.setGxrq(new Date());
		p.setYhid("api");
		int n = distributeColothTMapper.updateByPrimaryKey(p);
		Assert.isTrue(n>0);
	}
	
	@Test
	public void testDeleteByPrimarayKeyForModel(){
		DistributeColothT p = new DistributeColothT();
		p.setColthno("J3A00111*00EY4A");
		int n = distributeColothTMapper.deleteByPrimarayKeyForModel(p);
		Assert.isTrue(n>0);
	}
}
