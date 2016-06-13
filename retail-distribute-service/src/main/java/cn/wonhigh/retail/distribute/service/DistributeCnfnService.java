package cn.wonhigh.retail.distribute.service;

import cn.wonhigh.retail.distribute.common.model.DistributeCnfn;

public interface DistributeCnfnService {

	public DistributeCnfn getDistributeCnfn(String cusno);
	
	public void addDistributeCnfn(DistributeCnfn t);
	
	void updateDistributeCnfn(DistributeCnfn cnfn);
}
