package cn.wonhigh.retail.distribute.service;

import java.util.List;
import java.util.Map;

import cn.wonhigh.retail.distribute.common.model.DistributeCltypeNew;

public interface DistributeCltypeNewService {

	List<DistributeCltypeNew> selectByParams(Map<String, Object> params);

}
