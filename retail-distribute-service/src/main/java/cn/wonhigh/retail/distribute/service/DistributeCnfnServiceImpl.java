package cn.wonhigh.retail.distribute.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wonhigh.retail.distribute.common.model.DistributeCnfn;
import cn.wonhigh.retail.distribute.dal.distribute.jp.database.DistributeCnfnMapper;

@Service
public class DistributeCnfnServiceImpl implements DistributeCnfnService{

	@Resource
	private DistributeCnfnMapper distributeCnfnMapper;
	
	@Override
	public DistributeCnfn getDistributeCnfn(String cusno) {
		// TODO Auto-generated method stub
		DistributeCnfn cnf = new DistributeCnfn();
		cnf.setCusno(cusno);
		return distributeCnfnMapper.selectByPrimaryKey(cnf);
	}

	@Override
	public void addDistributeCnfn(DistributeCnfn t) {
		// TODO Auto-generated method stub
		distributeCnfnMapper.insert(t);
	}

	@Override
	public void updateDistributeCnfn(DistributeCnfn cnfn) {
		// TODO Auto-generated method stub
		distributeCnfnMapper.updateByPrimaryKey(cnfn);
	}

}
