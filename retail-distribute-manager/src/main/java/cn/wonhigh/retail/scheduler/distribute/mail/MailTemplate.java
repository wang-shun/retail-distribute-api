package cn.wonhigh.retail.scheduler.distribute.mail;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cn.wonhigh.retail.distribute.common.distribute.DistributeLog;

public class MailTemplate {

	/**
	 * 获取需要解析的对象
	 * @param sendInfo
	 * @return
	 */
	public static Map<String,Object> getMailMap(MailSendInfo sendInfo){
		Map<String,Object> result = sendInfo.getResult();
		Map<String,Object> root = new HashMap<>();
		if(result != null && result.size() >0){
			root.put("brand", result);
		}
		//设置同步时间
		root.put("synTime", new Date());
		return root;
	}
	

	public static String getMailContent(MailSendInfo sendInfo){
		try {
			return FreemarkParse.getMailInfo(MailTemplate.getMailMap(sendInfo));
		} catch (Exception e) {
			DistributeLog.error("获取邮件内容失败",e);
			return "品牌同步成功,但是获取邮件发送内容失败，请联系管理员";
		}
	}
}
