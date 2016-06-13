package cn.wonhigh.retail.scheduler.distribute.mail;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

import freemarker.template.TemplateException;

public class FreemarkTest {

	
	@Test
	public void test解析FTL邮件模版() throws IOException, TemplateException, URISyntaxException {
		
		MailSendInfo in = getSendInfo();
		System.out.println(FreemarkParse.getMailInfo(MailTemplate.getMailMap(in)));
	}
	
	
	private static MailSendInfo getSendInfo(){
		MailSendInfo si = new MailSendInfo();
		si.setBrandNo("JP");
		si.setProductCode("JP0000001");
		si.addSizeCode("250");
		si.addSizeCode("260");
		si.addErrorInfo("同步失败");
		si.setProductCode("JP0000002");
		si.addSizeCode("250");
		si.addSizeCode("260");
		si.addErrorInfo("同步失败");
		si.setBrandNo("BS");
		si.setProductCode("BS0000001");
		si.addSizeCode("250");
		si.addSizeCode("260");
		si.addErrorInfo("同步失败");
		si.setProductCode("BS0000002");
		si.addSizeCode("250");
		si.addSizeCode("260");
		//si.addErrorInfo("");
		return si;
	}
}
