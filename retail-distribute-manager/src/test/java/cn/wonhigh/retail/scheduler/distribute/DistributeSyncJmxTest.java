package cn.wonhigh.retail.scheduler.distribute;

import javax.annotation.Resource;

import org.junit.Test;

public class DistributeSyncJmxTest extends BaseTest{

	@Resource
	private DistributeSyncJmx distributeSyncJmx;
	
	@Test
	public void testSync(){
		distributeSyncJmx.sync();
	}
}
