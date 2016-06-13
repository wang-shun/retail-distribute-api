package cn.wonhigh.retail.scheduler.distribute;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.Resource;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import cn.wonhigh.retail.backend.utils.StopWatch;
import cn.wonhigh.retail.distribute.common.JsonUtils;
import cn.wonhigh.retail.distribute.common.constans.PublicConstans;
import cn.wonhigh.retail.distribute.common.distribute.DistributeLog;
import cn.wonhigh.retail.distribute.common.model.SystemParam;
import cn.wonhigh.retail.distribute.dal.distribute.inteceptor.DataSourceHolder;
import cn.wonhigh.retail.distribute.service.SystemParamService;
import cn.wonhigh.retail.scheduler.distribute.mail.MailTemplate;
import cn.wonhigh.retail.scheduler.distribute.mail.SendInfoUtils;
import cn.wonhigh.retail.uc.common.api.utils.CommonUtil;

import com.yougou.logistics.base.common.enums.JobBizStatusEnum;
import com.yougou.logistics.base.common.interfaces.RemoteJobServiceExtWithParams;
import com.yougou.logistics.base.common.vo.scheduler.RemoteJobInvokeParamsDto;

@Component
@ManagedResource(objectName="mdm:type=dataSync")
public class DistributeSyncJmx implements RemoteJobServiceExtWithParams{

	@Resource
	private SystemParamService systemParamService;
	
	@Resource
	private MdmDataSync mdmDataSync;
	
	Lock lock = new ReentrantLock();

	@ManagedOperation
	public void sync(){
		lock.lock();
		try {
			DistributeLog.info("开始同步产品数据...");
			StopWatch st = new StopWatch();
			List<SystemParam> spList = getSyncBrand();
			if(CommonUtil.hasValue(spList)){
				for(SystemParam param : spList){
					try {
						//写入发送邮件的信息,先设置品牌
						SendInfoUtils.setBrandNo(param.getParamValue());
						//设置数据源
						DataSourceHolder.set(param.getParamValue());
						SystemParam syncTime = getSyncTime(param.getParamValue());

						// 同步成功回写时间
						if(mdmDataSync.synProProduct(param.getParamValue(), parseTime(syncTime.getParamValue()))){
							Date writeTime = new Date();
							syncTime.setParamValue(formatTime(writeTime));
							systemParamService.updateSystemParam(syncTime);
						}
						DistributeLog.info("同步品牌["+param.getParamValue()+"],时间["+syncTime.getParamValue()+"],成功^_^");
					} catch (Exception e) {
						//该品牌出现异常，同步下一个品牌
						//设置异常引起的失败
						SendInfoUtils.setExcetionError();
						//邮件暗送
						StringWriter sw = new StringWriter();
						PrintWriter pw = new PrintWriter(sw);
						e.printStackTrace(pw);
						SendInfoUtils.sendHtmlMailToBcc("同步品牌"+param.getParamValue()+"失败", sw.toString());
						DistributeLog.error(e.getMessage(),e);
					}
					//发送邮件
					SendInfoUtils.sendHtmlMail("【系统邮件】主数据产品信息同步至分销库结果", MailTemplate.getMailContent(SendInfoUtils.getMailSendInfo()));
					SendInfoUtils.clear();
				}
				
			}
			st.printExecuteTime("synProProduct");
			DistributeLog.info("结束同步产品数据...");
		} catch (Exception e) {
			DistributeLog.error("同步失败...", e);
		}finally{
			lock.unlock();
		}
	}
	
	private List<SystemParam> getSyncBrand(){
		Map<String,Object> params = new HashMap<>();
		params.put("paramType", PublicConstans.SYNC_BRAND);
		return systemParamService.getSystemParam(params);
	}
	
	private SystemParam getSyncTime(String brandNo) throws ParseException{
		//获取时间
		Map<String,Object> params = new HashMap<>();
		params.put("paramType", PublicConstans.SYNC_TIME);
		params.put("paramId", brandNo);
		List<SystemParam> spList = systemParamService.getSystemParam(params);
		if(CommonUtil.hasValue(spList)){
			return spList.get(0);
		}
		return null;
	}
	
	private String formatTime(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	private Date parseTime(String time) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.parse(time);
	}

	@Override
	public void initializeJob(String jobId, String triggerName, String groupName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executeJobWithParams(String jobId, String triggerName,
			String groupName, RemoteJobInvokeParamsDto remoteJobInvokeParamsDto) {
		// TODO Auto-generated method stub
		sync();
	}

	@Override
	public void pauseJob(String jobId, String triggerName, String groupName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resumeJob(String jobId, String triggerName, String groupName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopJob(String jobId, String triggerName, String groupName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void restartJob(String jobId, String triggerName, String groupName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JobBizStatusEnum getJobStatus(String jobId, String triggerName,
			String groupName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLogs(String jobId, String triggerName, String groupName,
			long lastDate) {
		Map<String,String> map = new HashMap<>();
		map.put("jobId", jobId);
		map.put("triggerName", triggerName);
		map.put("groupName", groupName);
		map.put("lastDate", lastDate+"");
		
		return JsonUtils.toJson(map);
	}
}
