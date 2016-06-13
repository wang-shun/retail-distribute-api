package cn.wonhigh.retail.distribute.common.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StopWatch {

private long start;
	
	static Log LOG = LogFactory.getLog(StopWatch.class);

	public StopWatch() {
		start = System.currentTimeMillis();
	}
	
	public void printExecuteTime(String name) {
		double ms = (System.currentTimeMillis() - start);
		LOG.info(name + " execute {} ms="+ ms);
		start = System.currentTimeMillis();
	}
}
