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
import cn.wonhigh.retail.distribute.common.model.DistributeColoth;
import cn.wonhigh.retail.distribute.common.utils.JsonUtils;
import cn.wonhigh.retail.distribute.dal.distribute.jp.database.DistributeColothMapper;

public class TestColothMapper extends BaseDalTest{

	@Resource
	DistributeColothMapper distributeColothMapper;
	
	Log LOG = LogFactory.getLog(DistributeColothMapper.class);
	@Test
	public void testSelectByParams(){
		Map<String,Object> params = new HashMap<>();
		params.put("colthno", "R8516A21DL7AQ6");
		List<DistributeColoth> blist = distributeColothMapper.selectByParams(null, params);
		LOG.info(JsonUtils.toJson(blist));
		Assert.notNull(blist);
	}
	
	@Test
	public void testInsert(){
		DistributeColoth p = new DistributeColoth();
		p.setColthno("J3A00111*00EY4");
		p.setRecno(3);
		p.setColorNos("00-G");
		p.setWords("2844200111998");
		p.setMsize("G");
		p.setMcolor("00");
		p.setSprice(new BigDecimal(1.0));
		p.setPrice(new BigDecimal(1.0));
		p.setGprice(new BigDecimal(1.0));
		p.setGxrq(new Date());
		p.setYhid("api");
		int n = distributeColothMapper.insert(p);
		Assert.isTrue(n>0);
	}
	
	@Test
	public void testUpdateByPrimaryKey(){
		DistributeColoth p = new DistributeColoth();
		p.setColthno("J3A00111*00EY4");
		p.setRecno(4);
		p.setColorNos("00-G");
		p.setMsize("G");
		p.setGxrq(new Date());
		p.setYhid("api");
		int n = distributeColothMapper.updateByPrimaryKey(p);
		Assert.isTrue(n>0);
	}
	
	@Test
	public void testDeleteByPrimarayKeyForModel(){
		DistributeColoth p = new DistributeColoth();
		p.setColthno("J3A00111*00EY4");
		p.setMsize("G");
		int n = distributeColothMapper.deleteByPrimarayKeyForModel(p);
		Assert.isTrue(n>0);
	}
}
