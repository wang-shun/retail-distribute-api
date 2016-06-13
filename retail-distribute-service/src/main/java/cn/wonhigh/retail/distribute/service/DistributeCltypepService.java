package cn.wonhigh.retail.distribute.service;

import java.util.List;

import cn.wonhigh.retail.distribute.common.model.DistributeCltypep;

public interface DistributeCltypepService {

	List<DistributeCltypep> getDistributeCltypepList(String colthNo);
	
	void addDistributeCltypep(DistributeCltypep t);
	
	void updateDistributeCltypep(DistributeCltypep t);
	
	void deleteDistributeCltypep(DistributeCltypep t);
	
}
