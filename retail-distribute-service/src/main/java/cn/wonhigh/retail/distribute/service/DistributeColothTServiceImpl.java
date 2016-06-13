package cn.wonhigh.retail.distribute.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wonhigh.retail.distribute.common.model.DistributeColothT;
import cn.wonhigh.retail.distribute.dal.distribute.jp.database.DistributeColothTMapper;

@Service
public class DistributeColothTServiceImpl implements DistributeColothTService{

	@Resource
	private DistributeColothTMapper colothTMapper;
	
	@Override
	public DistributeColothT getDistributeColothT(String colthNo){
		// TODO Auto-generated method stub
		DistributeColothT t = new DistributeColothT();
		t.setColthno(colthNo);
		return colothTMapper.selectByPrimaryKey(t);
	}

	@Override
	public void addDistributeColothT(DistributeColothT t) {
		// TODO Auto-generated method stub
		colothTMapper.insert(t);
	}

	@Override
	public void updateDistributeColothT(DistributeColothT t) {
		// TODO Auto-generated method stub
		colothTMapper.updateByPrimaryKey(t);
	}
	
	
	

}
