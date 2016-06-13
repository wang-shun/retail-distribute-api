package cn.wonhigh.retail.distribute.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String getDateTime(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
		
	}
}
