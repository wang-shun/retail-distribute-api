package cn.wonhigh.retail.scheduler.distribute.mail;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import cn.wonhigh.retail.distribute.common.distribute.DistributeLog;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkParse {

	private static String DEFAULT_TEMPLATE = "bi2disMailSend.ftl";
	
	/**
	 * 获取FTL配置信息
	 * @return
	 */
	private static Configuration getConfiguration() {
		try {
			String url = FreemarkParse.class.getResource("/"+DEFAULT_TEMPLATE).getPath();
			File parent = new File(url).getParentFile();
			Configuration conf = new Configuration();
			DistributeLog.info("FTL directory "+parent.getPath());
			conf.setDirectoryForTemplateLoading(parent);
			return conf;
		} catch (IOException e) {
			throw new RuntimeException("创建FTL配置信息失败",e);
		}
	}
	
	/**
	 * 解析FTL文件
	 * @param root
	 * @return
	 */
	public static String getMailInfo(Map<String,Object> root) {
		try {
			Configuration conf = getConfiguration();
			Template temp = conf.getTemplate(DEFAULT_TEMPLATE);
			StringWriter sw = new StringWriter();
			temp.process(root, sw);
			return sw.toString();
		} catch (TemplateException e) {
			throw new RuntimeException("获取FTL模版失败",e);
		} catch (IOException e) {
			throw new RuntimeException("获取FTL模版失败",e);
		} catch (Exception e) {
			throw new RuntimeException("获取FTL模版失败,出现系统异常",e);
		}
	}
	
}
