package cn.wonhigh.retail.distribute.dal.database;

import cn.wonhigh.retail.distribute.common.model.SystemParam;

import com.yougou.logistics.base.dal.database.BaseCrudMapper;

public interface SystemParamMapper extends BaseCrudMapper{

	void update(SystemParam param);
}
