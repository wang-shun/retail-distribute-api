package cn.wonhigh.retail.distribute.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wonhigh.retail.distribute.common.model.SystemParam;
import cn.wonhigh.retail.distribute.dal.database.SystemParamMapper;

@Service
public class SystemParamServiceImpl implements SystemParamService {

	@Resource
	private SystemParamMapper systemParamMapper;
	
	@Override
	public List<SystemParam> getSystemParam(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return systemParamMapper.selectByParams(null, params);
	}

	@Override
	public void addSystemParam(SystemParam param) {
		// TODO Auto-generated method stub
		systemParamMapper.insert(param);
	}

	@Override
	public void updateSystemParam(SystemParam param) {
		// TODO Auto-generated method stub
		systemParamMapper.updateByPrimaryKey(param);
	}
}
