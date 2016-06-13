package cn.wonhigh.retail.distribute.dal.database;

import cn.wonhigh.retail.distribute.common.model.DataSyncLog;

public interface DataSyncLogMapper {

	void insert(DataSyncLog data);
	
	void update(DataSyncLog data);
	
	DataSyncLog selectById(String id);
}
