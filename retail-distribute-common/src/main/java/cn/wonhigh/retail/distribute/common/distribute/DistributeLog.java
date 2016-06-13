package cn.wonhigh.retail.distribute.common.distribute;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.wonhigh.retail.distribute.common.constans.PublicConstans;

public class DistributeLog {
	private static Log log = LogFactory.getLog(DistributeLog.class);

	public static void debug(String info){
		if(log.isDebugEnabled()){
			log.debug(getMessage(info));
		}
	}
	
	public static void debug(String info,Throwable t){
		if(log.isDebugEnabled()){
			log.debug(getMessage(info),t);
		}
	}
	
	public static void info(String info){
		if(log.isInfoEnabled()){
			log.info(getMessage(info));
		}
	}
	
	public static void info(String info,Throwable t){
		if(log.isInfoEnabled()){
			log.info(getMessage(info),t);
		}
	}
	public static void warn(String info){
		log.warn(getMessage(info));
	}
	
	public static void warn(String info,Throwable t){
		log.warn(getMessage(info),t);
	}
	
	public static void error(String info){
		log.error(getMessage(info));
	}
	
	public static void error(String info,Throwable t){
		log.error(getMessage(info),t);
	}
	private static String getMessage(String info){
		return "["+Thread.currentThread().getId()+"-"+PublicConstans.DISTRIBUTE_VERSION +"]" + info;
	}
	
}
