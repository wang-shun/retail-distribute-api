package cn.wonhigh.retail.scheduler.distribute.mail.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import cn.wonhigh.retail.distribute.common.JsonUtils;
import cn.wonhigh.retail.distribute.common.distribute.DistributeLog;
import cn.wonhigh.retail.distribute.common.model.SystemParam;
import cn.wonhigh.retail.distribute.service.SystemParamService;
import cn.wonhigh.retail.uc.common.api.utils.CommonUtil;

@Service("distributeMail")
@Scope("prototype")
public class Mail {
	
	private static Properties props = new Properties();
	private static Session session;
	
	@Resource
	private SystemParamService systemParamService;

	private static String PARAM_TYPE = "MAIL";
	private static String PARAM_FROM = "FROM";//发件人
	private static String PARAM_TO = "TO";//收件人
	private static String PARAM_CCTO= "CCTO";//抄送人
	private static String PARAM_BCCTO= "BCCTO";//密送人
	private static String PARAM_USER = "USERNAME";//用户名
	private static String PARAM_PASS = "PASSWORD";//密码
	private static String PARAM_HOST = "HOST";//主机
	private static String PARAM_PORT = "PORT";//端口
	
	private List<SystemParam> paramList = null;
	
	static{
		props.setProperty("mail.smtp.host", "smtp.wonhigh.cn");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.port", "25");
		props.setProperty("mail.transport.protocol", "smtp");

	}
	
	@PostConstruct
	public void init(){
		//覆盖默认的邮箱信息
		String host = getParamString(PARAM_HOST);
		if(CommonUtil.hasValue(host)){
			props.setProperty("mail.smtp.host", host);
		}
		String port = getParamString(PARAM_PORT);
		if(CommonUtil.hasValue(host)){
			props.setProperty("mail.smtp.port", port);
		}
		//初台会话
		session = getSession();
	}
	
	private Session getSession(){
		DistributeLog.info("构建SESSION:"+JsonUtils.toJson(props));
		Session session = Session.getDefaultInstance(props,new MyAuthenticator(getParamString(PARAM_USER),getParamString(PARAM_PASS)));
		return session;
	}
	
	
	public void sendTextMail(String subject,String content) throws MessagingException{
		MimeMessage msg = buildMessage(true,true,true);
		DistributeLog.info("发送文本邮件，主题:"+subject+"内容:"+content);
		msg.setSubject(subject);
		msg.setText(content);
		msg.saveChanges();
		Transport.send(msg);
		DistributeLog.info("邮件发送成功^_^****************************");
	}


	public void sendHtmlMail(String subject,String content) throws MessagingException{
		MimeMessage msg = buildMessage(true,true,true);
		DistributeLog.info("发送HTML邮件，主题:"+subject+"内容:"+content);
		msg.setSubject(subject);
		msg.setContent(content, "text/html;charset=utf-8");
		msg.saveChanges();
		Transport.send(msg);
		DistributeLog.info("邮件发送成功^_^****************************");
	}
	
	public void sendMailToBcc(String subject,String content) throws MessagingException{
		MimeMessage msg = buildMessage(false,false,true);
		DistributeLog.info("发送文本邮件，主题:"+subject+"内容:"+content);
		msg.setSubject(subject);
		msg.setContent(content, "text/html;charset=utf-8");
		msg.saveChanges();
		Transport.send(msg);
		DistributeLog.info("邮件发送成功^_^****************************");
	}
	
	private MimeMessage buildMessage(boolean isTo,boolean isCcTo,boolean isBccTo) throws MessagingException{
		MimeMessage mes = new MimeMessage(session);
		String from = getParamString(PARAM_FROM);
		String[] to = null;
		if(isTo) to = getParamStringList(PARAM_TO);
		String[] ccTo = null;
		if(isCcTo) ccTo = getParamStringList(PARAM_CCTO);
		String[] bccTo = null;
		if(isBccTo) bccTo = getParamStringList(PARAM_BCCTO);
		DistributeLog.info("发件人:"+from+"收件人:"+JsonUtils.toJson(to)+"抄送人:"+JsonUtils.toJson(ccTo)+"密送人:"+JsonUtils.toJson(bccTo));
		mes.setFrom(new InternetAddress(from));
		mes.setRecipients(RecipientType.TO,getAddress(to));
		mes.setRecipients(RecipientType.CC, getAddress(ccTo));
		mes.setRecipients(RecipientType.BCC, getAddress(bccTo));
		mes.setSentDate(new Date());
		return mes;
	}
	
	private InternetAddress[] getAddress(String[] ss) throws AddressException{
		if(ss == null || ss.length == 0){
			return null;
		}
		InternetAddress[] is = new InternetAddress[ss.length];
		for(int i = 0;i<ss.length;i++){
			is[i] = new InternetAddress(ss[i]);
		}
		return is;
	};
	
	private String getParamString(String paramId){
		Map<String,Object> params = new HashMap<>();
		params.put("paramType", PARAM_TYPE);
		paramList = systemParamService.getSystemParam(params);
		return getParamStringList(paramId)[0];
	}
	
	private String[] getParamStringList(String paramId){
		ArrayList<String> list = new ArrayList<>();
		for(SystemParam sp : paramList){
			if(StringUtils.equals(paramId, sp.getParamId())){
				list.add(sp.getParamValue());
			}
		}
		String[] strs = new String[list.size()];
		return list.toArray(strs);
	}
}
