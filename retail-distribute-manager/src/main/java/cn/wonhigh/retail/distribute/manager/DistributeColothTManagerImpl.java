package cn.wonhigh.retail.distribute.manager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wonhigh.retail.distribute.common.JsonUtils;
import cn.wonhigh.retail.distribute.common.distribute.DistributeLog;
import cn.wonhigh.retail.distribute.common.model.DistributeColothT;
import cn.wonhigh.retail.distribute.service.DistributeColothTService;

@Service
public class DistributeColothTManagerImpl implements DistributeColothTManager{

	@Resource
	private DistributeColothTService colothTService;
	
	@Override
	public void syncColothT(List<DistributeColothT> clist) {
		//找出新增与更新的
		DistributeLog.info("同步产品主档:"+JsonUtils.toJson(clist));
		for(DistributeColothT t : clist){
			if(null == colothTService.getDistributeColothT(t.getColthno())){
				colothTService.addDistributeColothT(t);
			} else {
				colothTService.updateDistributeColothT(t);
			}
		}
	}

	@Override
	public void syncColothT(DistributeColothT t) {
		// TODO Auto-generated method stub
		DistributeLog.info("同步产品主档:"+JsonUtils.toJson(t));
		if(null == colothTService.getDistributeColothT(t.getColthno())){
			colothTService.addDistributeColothT(t);
		} else {
			colothTService.updateDistributeColothT(t);
		}
	}

}
