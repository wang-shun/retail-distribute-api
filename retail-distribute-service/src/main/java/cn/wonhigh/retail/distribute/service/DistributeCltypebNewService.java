package cn.wonhigh.retail.distribute.service;

import java.util.List;
import java.util.Map;

import cn.wonhigh.retail.distribute.common.model.DistributeCltypebNew;

public interface DistributeCltypebNewService {

	DistributeCltypebNew getDistributeCltypebNew(String typeNo,String classNo);
	
	List<DistributeCltypebNew> getDistributeCltypebNewList(Map<String,Object> params);
}
