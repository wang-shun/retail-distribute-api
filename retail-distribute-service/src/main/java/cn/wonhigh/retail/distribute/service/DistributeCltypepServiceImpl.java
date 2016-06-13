package cn.wonhigh.retail.distribute.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wonhigh.retail.distribute.common.model.DistributeCltypep;
import cn.wonhigh.retail.distribute.dal.distribute.jp.database.DistributeCltypepMapper;

@Service
public class DistributeCltypepServiceImpl implements DistributeCltypepService{

	@Resource
	private DistributeCltypepMapper distributeCltypepMapper;
	
	@Override
	public List<DistributeCltypep> getDistributeCltypepList(String colthNo) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<>();
		params.put("colthno", colthNo);
		return distributeCltypepMapper.selectByParams(null, params);
	}

	@Override
	public void addDistributeCltypep(DistributeCltypep t) {
		// TODO Auto-generated method stub
		distributeCltypepMapper.insert(t);
	}

	@Override
	public void updateDistributeCltypep(DistributeCltypep t) {
		// TODO Auto-generated method stub
		distributeCltypepMapper.updateByPrimaryKey(t);
	}

	@Override
	public void deleteDistributeCltypep(DistributeCltypep t) {
		// TODO Auto-generated method stub
		distributeCltypepMapper.deleteByPrimarayKeyForModel(t);
	}
}
