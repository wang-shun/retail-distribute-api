package cn.wonhigh.retail.api.other.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class CaixuTest {
	
	
	public static void main(String[] args) {
		String str = String.format("R%08d", 100);     
		System.out.println(str);
		
		try {
			
			Date date = DateFormat.getDateInstance().parse("20090808 21:15:12");
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			System.out.println(df.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
