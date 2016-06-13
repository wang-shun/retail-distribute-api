package cn.wonhigh.retail.scheduler.distribute;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.wonhigh.retail.distribute.common.distribute.DistributeLog;
import cn.wonhigh.retail.distribute.common.model.DataSyncLog;
import cn.wonhigh.retail.distribute.service.DataSyncLogService;

@Component
public class DataSyncLogUtils {


	private static DataSyncLogService dataSyncLogService;
	
	public static void addSyncLog(DataSyncLog data){
		try {
			if(null == dataSyncLogService.getDataSyncLog(data.getId())){
				dataSyncLogService.addDataSyncLog(data);
			} else {
				dataSyncLogService.updateDataSyncLog(data);
			}
		} catch (Exception e) {
			// TODO: handle exception
			DistributeLog.error(e.getMessage(),e);
		}
	}

	@Resource
	public void setDataSyncLogService(DataSyncLogService dataSyncLogService) {
		DataSyncLogUtils.dataSyncLogService = dataSyncLogService;
	}
}
