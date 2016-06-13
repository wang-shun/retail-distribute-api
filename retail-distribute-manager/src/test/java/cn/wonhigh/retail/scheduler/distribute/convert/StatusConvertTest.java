package cn.wonhigh.retail.scheduler.distribute.convert;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.stereotype.Component;

import cn.wonhigh.retail.scheduler.distribute.BaseTest;

@Component
public class StatusConvertTest extends BaseTest{


	@Test
	public void  testConvert(){
		byte req = 0;
		String res = "5";
		String brand = "SD";
		try {
			String res1 = StatusConvert.convert(req,brand);
			Assert.assertEquals("错误", res, res1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}
}
