package cn.wonhigh.retail.api.other.Distribute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.util.Assert;

import cn.wonhigh.retail.distribute.common.distribute.DistributeLog;
import cn.wonhigh.retail.distribute.common.model.BizNoTransform;
import cn.wonhigh.retail.distribute.common.utils.JsonUtils;
import cn.wonhigh.retail.distribute.dal.database.BizNoTransformMapper;

public class BizNoTransformTest extends BaseDalTest{
	
	@Resource
	BizNoTransformMapper mapper;
	
	@Test
	public void testSelectByParams(){
		Map<String,Object> param = new HashMap<>();
		param.put("type", "SUPPLY");
		List<BizNoTransform> blist = mapper.selectByParams(null, param);
		DistributeLog.info(JsonUtils.toJson(blist));
		Assert.notNull(blist);
	}
}
