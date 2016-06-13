package cn.wonhigh.retail.distribute.manager;

import java.util.List;

import cn.wonhigh.retail.distribute.common.model.DistributeColothTB;

public interface DistributeColothTBManager {

	void syncColothTB(List<DistributeColothTB> clist);
	
	void syncColothTB(DistributeColothTB t);
}
