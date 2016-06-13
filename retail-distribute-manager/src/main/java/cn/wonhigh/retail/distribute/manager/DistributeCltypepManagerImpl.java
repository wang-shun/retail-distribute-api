package cn.wonhigh.retail.distribute.manager;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wonhigh.retail.distribute.common.JsonUtils;
import cn.wonhigh.retail.distribute.common.distribute.DistributeLog;
import cn.wonhigh.retail.distribute.common.model.DistributeCltypep;
import cn.wonhigh.retail.distribute.service.DistributeCltypepService;
import cn.wonhigh.retail.uc.common.api.utils.CommonUtil;

@Service
public class DistributeCltypepManagerImpl implements DistributeCltypepManager{

	@Resource
	private DistributeCltypepService distributeCltypepService;

	@Override
	public void syncCltypep(List<DistributeCltypep> list) {
		// TODO Auto-generated method stub
		if(null == list || list.size() == 0)return;
		list = removeRepeat(list);
		DistributeLog.info("同步产品品牌级,集团级属性:"+JsonUtils.toJson(list));
		//同步之前先更新名称
//		for(DistributeCltypep p : list){
//			DistributeCltypebNew b = distributeCltypebNewServicel.getDistributeCltypebNew(p.getTypeno(), p.getClassno());
//			b.setClassname(b.getClassname());
//		}
		String colthNo = list.get(0).getColthno();
		List<DistributeCltypep> olist = distributeCltypepService.getDistributeCltypepList(colthNo);
		if(null == olist || olist.size() == 0){
			for(DistributeCltypep t : list) {
				distributeCltypepService.addDistributeCltypep(t);
			}
		} else {
			for(DistributeCltypep n : list){
				if(olist.contains(n)){
					distributeCltypepService.updateDistributeCltypep(n);
					olist.remove(n);
				} else {
					distributeCltypepService.addDistributeCltypep(n);
				}
			}
//			if(olist.size() > 0){
//				for(DistributeCltypep o : olist) {
//					distributeCltypepService.deleteDistributeCltypep(o);
//				}
//			}
		}
	}
	
	private List<DistributeCltypep> removeRepeat(List<DistributeCltypep> list){
		if(CommonUtil.hasValue(list)){
			List<DistributeCltypep> newList = new ArrayList<>();
			for(DistributeCltypep p : list){
				if(!newList.contains(p)){
					newList.add(p);
				}
			}
			return newList;
		}
		return list;
	}
}
