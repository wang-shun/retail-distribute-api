package cn.wonhigh.retail.distribute.common.utils;

import java.io.IOException;

public class JsonUtils{

	public static String toJson(Object obj){
		try {
			return cn.wonhigh.retail.backend.utils.JsonUtils.toJson(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return obj.toString();
		}
	}
}
