package com.wonhigh.listen;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyListen implements ServletContextListener{

	static Log log = LogFactory.getLog(MyListen.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		log.debug("启动debug");
		log.info("启动info");
		log.error("启动error");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		log.debug("催毁debug");
		log.info("催毁info");
		log.error("催毁error");
	}

}
