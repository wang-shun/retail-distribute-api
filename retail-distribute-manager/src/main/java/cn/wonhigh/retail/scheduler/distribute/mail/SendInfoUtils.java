package cn.wonhigh.retail.scheduler.distribute.mail;

import cn.wonhigh.retail.backend.core.SpringContext;
import cn.wonhigh.retail.distribute.common.distribute.DistributeLog;
import cn.wonhigh.retail.scheduler.distribute.mail.impl.Mail;


public class SendInfoUtils {

	private static ThreadLocal<MailSendInfo> th = new ThreadLocal<>();
	
	public static MailSendInfo getMailSendInfo(){
		MailSendInfo m = th.get();
		if(null == m){
			m = new MailSendInfo();
			th.set(m);
		}
		return m;
	}
	
	public static void clear(){
		th.set(null);
	}
	
	public static void setBrandNo(String brandNo){
		getMailSendInfo().setBrandNo(brandNo);
	}
	
	public static void setProductCode(String productCode){
		getMailSendInfo().setProductCode(productCode);
	}
	
	/**
	 * 添加错误信息
	 * @param errorInfo
	 */
	public static void addErrorInfo(String errorInfo){
		getMailSendInfo().addErrorInfo(errorInfo);
	}
	
	/**
	 * 添加警告信息
	 * @param errorInfo
	 */
	public static void addWarnInfo(String warnInfo){
		getMailSendInfo().addWarnInfo(warnInfo);
	}
	
	/**
	 * 设置异引起的失败
	 * @param errorInfo
	 */
	public static void setExcetionError(){
		getMailSendInfo().setExcetionError();
	}
	
	/**
	 * 添加尺码
	 * @param errorInfo
	 */
	public static void addSizeCode(String sizeCode){
		getMailSendInfo().addSizeCode(sizeCode);
	}
	
	/**
	 * 添加不需要同步的尺码
	 * @param sizeCode
	 */
	public static void addUnSynSizeCode(String sizeCode){
		getMailSendInfo().addUnSynSizeCode(sizeCode);
	}
	
	public static void sendHtmlMail(String subject,String content){
		Mail mail = SpringContext.getBean("distributeMail");
		try {
			mail.sendHtmlMail(subject, content);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			DistributeLog.error("发送邮件失败"+e.getMessage(),e);
		}
	}
	/**
	 * 发送给暗送人
	 * @param subject
	 * @param content
	 */
	public static void sendHtmlMailToBcc(String subject,String content){
		Mail mail = SpringContext.getBean("distributeMail");
		try {
			mail.sendMailToBcc(subject, content);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			DistributeLog.error("发送邮件失败"+e.getMessage(),e);
		}
	}
	
}
