package cn.wonhigh.retail.scheduler.distribute;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yougou.logistics.base.common.interfaces.RemoteJobServiceExtWithParams;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-retail-api-other-mdm-scheduler-client-test.xml")
public class DistributeSyncJmxClientTest {

	@Resource(name="proxy")
	private RemoteJobServiceExtWithParams param;
	
	@Test
	public void test(){
		param.executeJobWithParams("", "", "", null);
	}
}
