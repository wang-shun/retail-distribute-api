package cn.wonhigh.retail.scheduler.distribute.dataSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.wonhigh.retail.distribute.common.JsonUtils;
import cn.wonhigh.retail.distribute.common.distribute.DistributeLog;
import cn.wonhigh.retail.distribute.common.model.DistributeCltypebNew;
import cn.wonhigh.retail.distribute.service.DistributeCltypebNewService;

/**
 * 测试多数据源
 * @author user
 *
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/META-INF/spring-api-other-manager.xml")
public class CltypebNewTest{

	@Resource
	DistributeCltypebNewService cltypebNewService;
	
	@Test
	public void test从JP库查(){
		Map<String,Object> params = new HashMap<>();
		params.put("typename", "子品牌");
		//params.put("classname", "前后空");
		List<DistributeCltypebNew> jps = cltypebNewService.getDistributeCltypebNewList(params);
		List<DistributeCltypebNew> bss = cltypebNewService.getDistributeCltypebNewList(params);
		DistributeLog.info(JsonUtils.toJson(jps));
		DistributeLog.info(JsonUtils.toJson(bss));
	}
}
