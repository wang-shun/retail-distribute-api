package cn.wonhigh.retail.api.other.Distribute.jp.database;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import cn.wonhigh.retail.api.other.Distribute.BaseDalTest;
import cn.wonhigh.retail.distribute.common.model.DataSyncLog;
import cn.wonhigh.retail.distribute.common.utils.UUIDGenerator;
import cn.wonhigh.retail.distribute.dal.database.DataSyncLogMapper;

public class DataSyncLogTest extends BaseDalTest{

	@Resource
	DataSyncLogMapper dataSyncLogMapper;
	
	Log LOG = LogFactory.getLog(DataSyncLogTest.class);
	
	@Test
	public void testInsert(){
		
		DataSyncLog log = new DataSyncLog();
		String uuid = UUIDGenerator.getUUID();
		log.setId(uuid);
		log.setSyncResult("成功");
		log.setSyncTime("2015-05-23");
		log.setSyncParam1("BS");
		log.setSyncMessage("aaaaaa");
		dataSyncLogMapper.insert(log);
	}
}
