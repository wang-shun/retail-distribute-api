package cn.wonhigh.retail.distribute.manager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wonhigh.retail.distribute.common.JsonUtils;
import cn.wonhigh.retail.distribute.common.distribute.DistributeLog;
import cn.wonhigh.retail.distribute.common.model.DistributeColothTB;
import cn.wonhigh.retail.distribute.service.DistributeColothTBService;

@Service
public class DistributeColothTBManagerImpl implements DistributeColothTBManager{

	@Resource
	private DistributeColothTBService distributeColothTBService;
	
	@Override
	public void syncColothTB(List<DistributeColothTB> clist) {
		// TODO Auto-generated method stub
		DistributeLog.info("同步产品鞋型:"+JsonUtils.toJson(clist));
		for(DistributeColothTB t : clist){
			if(null == distributeColothTBService.getDistributeColothTB(t.getColthno())){
				distributeColothTBService.addDistributeColothTB(t);
			} else {
				distributeColothTBService.updateDistributeColothTB(t);
			}
		}
	
	}

	@Override
	public void syncColothTB(DistributeColothTB t) {
		// TODO Auto-generated method stub
		DistributeLog.info("同步产品鞋型:"+JsonUtils.toJson(t));
		if(null == distributeColothTBService.getDistributeColothTB(t.getColthno())){
			distributeColothTBService.addDistributeColothTB(t);
		} else {
			distributeColothTBService.updateDistributeColothTB(t);
		}
	}

}
