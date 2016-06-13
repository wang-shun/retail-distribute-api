package cn.wonhigh.retail.distribute.service;

import java.util.List;

import cn.wonhigh.retail.distribute.common.model.DistributeColoth;

public interface DistributeColothService {

	List<DistributeColoth> getDistributeColothList(String colthNo);
	
	void addDistributeColoth(DistributeColoth t);
	
	void updateDistributeColoth(DistributeColoth t);
	
	void deleteDistributeColoth(DistributeColoth t);
}
