package cn.wonhigh.retail.distribute.service;

import cn.wonhigh.retail.distribute.common.model.DistributeColothT;

public interface DistributeColothTService {

	public DistributeColothT getDistributeColothT(String colothNo);
	
	public void addDistributeColothT(DistributeColothT t);
	
	void updateDistributeColothT(DistributeColothT t);
}
