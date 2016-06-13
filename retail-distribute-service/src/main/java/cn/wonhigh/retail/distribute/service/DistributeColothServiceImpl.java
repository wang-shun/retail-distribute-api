package cn.wonhigh.retail.distribute.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wonhigh.retail.distribute.common.model.DistributeColoth;
import cn.wonhigh.retail.distribute.dal.distribute.jp.database.DistributeColothMapper;

@Service
public class DistributeColothServiceImpl implements DistributeColothService{

	@Resource
	private DistributeColothMapper distributeColothMapper;
	
	@Override
	public List<DistributeColoth> getDistributeColothList(String colthNo) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<>();
		params.put("colthno", colthNo);
		return distributeColothMapper.selectByParams(null, params);
	}

	@Override
	public void addDistributeColoth(DistributeColoth t) {
		// TODO Auto-generated method stub
		distributeColothMapper.insert(t);
	}

	@Override
	public void updateDistributeColoth(DistributeColoth t) {
		// TODO Auto-generated method stub
		distributeColothMapper.updateByPrimaryKey(t);
	}

	@Override
	public void deleteDistributeColoth(DistributeColoth t) {
		// TODO Auto-generated method stub
		distributeColothMapper.deleteByPrimarayKeyForModel(t);
	}

}
