package cn.wonhigh.retail.distribute.service;

import java.util.List;
import java.util.Map;

import cn.wonhigh.retail.distribute.common.model.SystemParam;


public interface SystemParamService{

	List<SystemParam> getSystemParam(Map<String,Object> params);
	
	void addSystemParam(SystemParam param);
	
	void updateSystemParam(SystemParam param);
}
