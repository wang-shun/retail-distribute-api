package cn.wonhigh.retail.scheduler.distribute;

import java.util.Date;

import com.yougou.logistics.base.common.exception.ManagerException;

/**
 * 从MDM获取产品资料
 * @author user
 *
 */
public interface MdmDataSync {

	/**
	 * 同步产品主数据
	 * @param brand 品牌部
	 * @return
	 */
	boolean synProProduct(String brand,Date editTime) throws ManagerException;
}
