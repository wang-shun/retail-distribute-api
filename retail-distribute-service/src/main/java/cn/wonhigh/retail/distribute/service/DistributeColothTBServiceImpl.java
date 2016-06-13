package cn.wonhigh.retail.distribute.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wonhigh.retail.distribute.common.model.DistributeColothTB;
import cn.wonhigh.retail.distribute.dal.distribute.jp.database.DistributeColothTBMapper;

@Service
public class DistributeColothTBServiceImpl implements DistributeColothTBService{

	@Resource
	private DistributeColothTBMapper colothTBMapper;
	
	@Override
	public DistributeColothTB getDistributeColothTB(String colothNo) {
		// TODO Auto-generated method stub
		DistributeColothTB t = new DistributeColothTB();
		t.setColthno(colothNo);
		return colothTBMapper.selectByPrimaryKey(t);
	}

	@Override
	public void addDistributeColothTB(DistributeColothTB t) {
		// TODO Auto-generated method stub
		colothTBMapper.insert(t);
	}

	@Override
	public void updateDistributeColothTB(DistributeColothTB t) {
		// TODO Auto-generated method stub
		colothTBMapper.updateByPrimaryKey(t);
	}

}
