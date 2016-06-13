package cn.wonhigh.retail.distribute.manager;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import cn.wonhigh.retail.distribute.common.JsonUtils;
import cn.wonhigh.retail.distribute.common.distribute.DistributeLog;
import cn.wonhigh.retail.distribute.common.model.DistributeColoth;
import cn.wonhigh.retail.distribute.service.DistributeColothService;

@Service
public class DistributeColothManagerImpl implements DistributeColothManager{

	static Log LOG = LogFactory.getLog("distributeLogger");
	
	@Resource
	private DistributeColothService distributeColothService;
	
	@Override
	public void syncColoth(List<DistributeColoth> list) {
		// TODO Auto-generated method stub
		DistributeLog.info("同步产品尺码:"+JsonUtils.toJson(list));
		if(list == null || list.size() == 0)return;
		String colthNo = list.get(0).getColthno();
		//删除老的条码
		DistributeColoth o = new DistributeColoth();
		o.setColthno(colthNo);
		distributeColothService.deleteDistributeColoth(o);

		for(DistributeColoth n : list){
			//条码也删掉,条码是唯一约束
			o = new DistributeColoth();
			o.setWords(n.getWords());
			distributeColothService.deleteDistributeColoth(o);
			distributeColothService.addDistributeColoth(n);
		}
	}

}
