package cn.wonhigh.retail.distribute.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class ContextUtils {

	private static ThreadLocal<Map<String,Object>> th = new ThreadLocal<>();
	
	public static Map<String,Object> getMap(){
		Map<String,Object> map = th.get();
		if(map == null){
			map = new HashMap<>();
			th.set(map);
		}
		return map;
	}
	
	public static void setParam(String key,Object value){
		getMap().put(key, value);
	}
	
	public static Object getParam(String key){
		return getMap().get(key);
	}
	
}
