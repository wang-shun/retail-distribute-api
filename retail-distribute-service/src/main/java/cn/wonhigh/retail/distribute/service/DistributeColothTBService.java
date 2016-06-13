package cn.wonhigh.retail.distribute.service;

import cn.wonhigh.retail.distribute.common.model.DistributeColothTB;

public interface DistributeColothTBService {

	DistributeColothTB getDistributeColothTB(String colothNo);
	
	void addDistributeColothTB(DistributeColothTB t);
	
	void updateDistributeColothTB(DistributeColothTB t);
}
