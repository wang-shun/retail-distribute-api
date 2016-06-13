package cn.wonhigh.retail.distribute.common.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataSyncLog implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	
	private String syncTime;
	
	private String syncResult;
	
	private String syncParam1;
	
	private String syncParam2;
	
	private String syncParam3;
	
	private String syncParam4;
	
	private String syncParam5;
	
	private String syncMessage;

	
	public DataSyncLog(){};
	
	public DataSyncLog(String id, String syncTime, String syncResult,
			String syncParam1) {
		super();
		this.id = id;
		this.syncTime = syncTime;
		this.syncResult = syncResult;
		this.syncParam1 = syncParam1;
	}
	
	public DataSyncLog(String id, Date syncTime, String syncResult,
			String syncParam1) {
		super();
		this.id = id;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.syncTime = sdf.format(syncTime);
		this.syncResult = syncResult;
		this.syncParam1 = syncParam1;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(String syncTime) {
		this.syncTime = syncTime;
	}

	public String getSyncResult() {
		return syncResult;
	}

	public void setSyncResult(String syncResult) {
		this.syncResult = syncResult;
	}

	public String getSyncParam1() {
		return syncParam1;
	}

	public void setSyncParam1(String syncParam1) {
		this.syncParam1 = syncParam1;
	}

	public String getSyncParam2() {
		return syncParam2;
	}

	public void setSyncParam2(String syncParam2) {
		this.syncParam2 = syncParam2;
	}

	public String getSyncParam3() {
		return syncParam3;
	}

	public void setSyncParam3(String syncParam3) {
		this.syncParam3 = syncParam3;
	}

	public String getSyncParam4() {
		return syncParam4;
	}

	public void setSyncParam4(String syncParam4) {
		this.syncParam4 = syncParam4;
	}

	public String getSyncParam5() {
		return syncParam5;
	}

	public void setSyncParam5(String syncParam5) {
		this.syncParam5 = syncParam5;
	}

	public String getSyncMessage() {
		return syncMessage;
	}

	public void setSyncMessage(String syncMessage) {
		this.syncMessage = syncMessage;
	}
}
