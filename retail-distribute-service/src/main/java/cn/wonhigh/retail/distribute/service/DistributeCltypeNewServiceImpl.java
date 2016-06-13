package cn.wonhigh.retail.distribute.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wonhigh.retail.distribute.common.model.DistributeCltypeNew;
import cn.wonhigh.retail.distribute.dal.distribute.jp.database.DistributeCltypeNewMapper;

@Service
public class DistributeCltypeNewServiceImpl implements
		DistributeCltypeNewService {
	@Resource
	private DistributeCltypeNewMapper distributeCltypeNewMapper;
	@Override
	public List<DistributeCltypeNew> selectByParams(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return distributeCltypeNewMapper.selectByParams(null, params);
	}

}
