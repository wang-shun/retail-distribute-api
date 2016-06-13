package cn.wonhigh.retail.api.other.Distribute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.util.Assert;

import cn.wonhigh.retail.distribute.common.model.SystemParam;
import cn.wonhigh.retail.distribute.common.utils.JsonUtils;
import cn.wonhigh.retail.distribute.dal.database.SystemParamMapper;

public class SystemParamTest extends BaseDalTest{

	@Resource
	SystemParamMapper systemParamMapper;
	
	Log LOG = LogFactory.getLog(SystemParamTest.class);
	@Test
	public void testSelectByParams(){
		Map<String,Object> param = new HashMap<>();
		param.put("paramType", "SYNC_TIME");
		List<SystemParam> blist = systemParamMapper.selectByParams(null, param);
		LOG.info(JsonUtils.toJson(blist));
		Assert.notNull(blist);
	}
}
