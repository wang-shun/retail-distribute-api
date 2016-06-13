package cn.wonhigh.retail.distribute.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wonhigh.retail.distribute.common.model.DataSyncLog;
import cn.wonhigh.retail.distribute.dal.database.DataSyncLogMapper;

@Service
public class DataSyncLogServiceImpl implements DataSyncLogService{
	
	@Resource
	private DataSyncLogMapper dataSyncLogMapper;

	@Override
	public void addDataSyncLog(DataSyncLog data) {
		// TODO Auto-generated method stub
		dataSyncLogMapper.insert(data);
	}

	@Override
	public void updateDataSyncLog(DataSyncLog data) {
		// TODO Auto-generated method stub
		dataSyncLogMapper.update(data);
	}

	@Override
	public DataSyncLog getDataSyncLog(String id) {
		// TODO Auto-generated method stub
		return dataSyncLogMapper.selectById(id);
	}

}
