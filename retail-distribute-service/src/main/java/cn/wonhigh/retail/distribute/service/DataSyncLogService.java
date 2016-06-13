package cn.wonhigh.retail.distribute.service;

import cn.wonhigh.retail.distribute.common.model.DataSyncLog;

public interface DataSyncLogService {

	void addDataSyncLog(DataSyncLog data);
	
	void updateDataSyncLog(DataSyncLog data);
	
	DataSyncLog getDataSyncLog(String id);
}
