package cn.wonhigh.retail.distribute.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wonhigh.retail.distribute.common.model.DistributeCltypebNew;
import cn.wonhigh.retail.distribute.dal.distribute.jp.database.DistributeCltypebNewMapper;
import cn.wonhigh.retail.uc.common.api.utils.CommonUtil;

@Service
public class DistributeCltypebNewServiceImpl implements DistributeCltypebNewService{

	@Resource
	private DistributeCltypebNewMapper distributeCltypebNewMapper;
	
	@Override
	public DistributeCltypebNew getDistributeCltypebNew(String typeNo,
			String classNo) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<>();
		params.put("typeno", typeNo);
		params.put("classno", classNo);
		List<DistributeCltypebNew> nlist = distributeCltypebNewMapper.selectByParams(null, params);
		if(CommonUtil.hasValue(nlist)){
			return nlist.get(0);
		}
		return null;
		
	}

	@Override
	public List<DistributeCltypebNew> getDistributeCltypebNewList(
			Map<String, Object> params ) {
		// TODO Auto-generated method stub
		return distributeCltypebNewMapper.selectByParams(null, params);
	}

}
