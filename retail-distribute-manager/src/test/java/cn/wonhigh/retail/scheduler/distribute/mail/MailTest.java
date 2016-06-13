package cn.wonhigh.retail.scheduler.distribute.mail;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.wonhigh.retail.scheduler.distribute.mail.impl.Mail;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/META-INF/spring-api-other-manager.xml")
public class MailTest {

	@Resource
	private Mail mail;
	
	@Test
	public void test发文本文件() throws MessagingException{
		mail.sendTextMail("测试", "aaa\tbbb\t<color red>dd</color>");
	}
	
	@Test
	public void test网页() throws MessagingException{
		mail.sendHtmlMail("html邮件主题", "<span style='color:red;'>html邮件测试...</span>");
	}
	
	@Test
	public void test从FTL解析发送网页() throws MessagingException{
		MailSendInfo sendInfo = getSendInfo();
		String content = FreemarkParse.getMailInfo(MailTemplate.getMailMap(sendInfo));
		mail.sendHtmlMail("html邮件主题", content);
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
