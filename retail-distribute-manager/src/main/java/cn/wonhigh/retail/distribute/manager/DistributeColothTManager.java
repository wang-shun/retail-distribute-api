package cn.wonhigh.retail.distribute.manager;

import java.util.List;

import cn.wonhigh.retail.distribute.common.model.DistributeColothT;

/**
 * 
 * @author user
 *
 */
public interface DistributeColothTManager {

	void syncColothT(List<DistributeColothT> clist);
	
	void syncColothT(DistributeColothT t);
}
