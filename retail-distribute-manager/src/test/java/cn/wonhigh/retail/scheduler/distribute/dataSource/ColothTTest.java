package cn.wonhigh.retail.scheduler.distribute.dataSource;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.wonhigh.retail.distribute.common.JsonUtils;
import cn.wonhigh.retail.distribute.common.distribute.DistributeLog;
import cn.wonhigh.retail.distribute.common.model.DistributeColothT;
import cn.wonhigh.retail.distribute.service.DistributeColothTService;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/META-INF/spring-api-other-manager.xml")
public class ColothTTest {

	@Resource
	DistributeColothTService colothTService;
	
	@Test
	public void test产品从分库库查(){
		//String colthno="J3A00121*02EY3";//JP
		String colthno="R3CFA8202C1AX3";//BST
		DistributeColothT ct = colothTService.getDistributeColothT(colthno);
		DistributeColothT ct2 = colothTService.getDistributeColothT(colthno);
		DistributeLog.info(JsonUtils.toJson(ct));
		DistributeLog.info(JsonUtils.toJson(ct2));
	}
}
