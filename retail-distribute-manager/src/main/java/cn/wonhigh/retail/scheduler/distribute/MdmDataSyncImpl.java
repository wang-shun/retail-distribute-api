package cn.wonhigh.retail.scheduler.distribute;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wonhigh.retail.distribute.common.constans.PublicConstans;
import cn.wonhigh.retail.distribute.common.distribute.DistributeLog;
import cn.wonhigh.retail.distribute.common.model.DataSyncLog;
import cn.wonhigh.retail.distribute.common.model.DistributeCltypep;
import cn.wonhigh.retail.distribute.common.model.DistributeColoth;
import cn.wonhigh.retail.distribute.common.model.DistributeColothT;
import cn.wonhigh.retail.distribute.common.model.DistributeColothTB;
import cn.wonhigh.retail.distribute.common.utils.ContextUtils;
import cn.wonhigh.retail.distribute.common.utils.UUIDGenerator;
import cn.wonhigh.retail.distribute.manager.DistributeCltypepManager;
import cn.wonhigh.retail.distribute.manager.DistributeColothManager;
import cn.wonhigh.retail.distribute.manager.DistributeColothTBManager;
import cn.wonhigh.retail.distribute.manager.DistributeColothTManager;
import cn.wonhigh.retail.distribute.service.DataSyncLogService;
import cn.wonhigh.retail.scheduler.distribute.convert.MDMConvert;
import cn.wonhigh.retail.scheduler.distribute.convert.SizeTypeConvert;
import cn.wonhigh.retail.scheduler.distribute.mail.SendInfoUtils;

import com.yougou.bi.mdm.api.vo.ProProductDto;
import com.yougou.logistics.base.common.exception.ManagerException;
import com.yougou.logistics.base.common.utils.SimplePage;

@Service
public class MdmDataSyncImpl implements MdmDataSync{

	@Resource
	private ProductApi productApi;

	@Resource
	private DistributeColothTManager colothTManager;
	
	@Resource
	private DistributeColothTBManager colothTBManager;
	
	@Resource
	private DistributeColothManager colothManager;
	
	@Resource
	private DistributeCltypepManager cltypepManager;
	
	@Resource
	private DataSyncLogService dataSyncLogService;

	public boolean synProProduct(String brand,Date editTime) throws ManagerException{
		DataSyncLog data = new DataSyncLog(UUIDGenerator.getUUID(),editTime,PublicConstans.SYNC_READY,brand);
		try {
			//添加一个是否成功标志
			boolean isSuccess = true;
			Map<String,Object> newParams = buildParams(brand, null, editTime);
			//newParams.put("edittm", "2015-08-18 09:37:20");//测试用的
			//分页查询,每次查询500条
			int totalCount = productApi.getCountProProduct(newParams);
			int pageSize = 500;
			int pageNo = 0;
			SimplePage sp = new SimplePage(pageNo, pageSize, totalCount);
			data.setSyncParam2(totalCount+"");
			data.setSyncParam5("");
			addSyncLog(data);
			StringBuilder sb = new StringBuilder();
			do{
				sp.setPageNo(++pageNo);
				//根据品牌过滤主数据
				List<ProProductDto> proList = productApi.getProProduct(newParams,sp);
				data.setSyncResult(PublicConstans.SYNC_RUNNING);
				if(null != proList && proList.size() > 0){
					for(ProProductDto pro : proList){
						data.setSyncParam3((--totalCount) + "");
						sb.append(pro.getProductCode()).append(",");
						data.setSyncParam5(sb.toString());
						addSyncLog(data);
						//发送邮件设置货号
						SendInfoUtils.setProductCode(pro.getProductCode());
						//默认转换成功
						ContextUtils.setParam(PublicConstans.EXCHAGE_RESULT, true);
						DistributeColothT colothT = MDMConvert.pro2ColothT(pro);
						//colothT中尺寸类型需要特别处理  所有含有F尺码的尺寸类型转为D，尺码转为F
						List<DistributeColoth> coloths = MDMConvert.pro2Coloth(pro);
						List<DistributeCltypep> cplist = MDMConvert.pro2Cltypep(pro);
						DistributeColothTB tb = MDMConvert.pro2ColothTB(pro);
						//上下文中含有sizeTypeCode,需要替换sizeTypeCode
						SizeTypeConvert.replaceSizeTypeCode(colothT);
						if((boolean)ContextUtils.getParam(PublicConstans.EXCHAGE_RESULT)){
							colothTManager.syncColothT(colothT);
							colothTBManager.syncColothTB(tb);
							colothManager.syncColoth(coloths);
							cltypepManager.syncCltypep(cplist);
						} else isSuccess = false;
				
					}
				}
			}while(!sp.isLastPage());
			if(isSuccess){
				data.setSyncResult(PublicConstans.SYNC_SUCCESS);
			} else {
				data.setSyncResult(PublicConstans.SYNC_FAILD);
			}
			addSyncLog(data);
			return isSuccess;
		} catch (Exception e) {
			data.setSyncResult(PublicConstans.SYNC_FAILD);
			data.setSyncMessage(e.getMessage());
			addSyncLog(data);
			throw new ManagerException(e);
		}
		
	}
	
	private Map<String, Object> buildParams(String brandNo,String productNo,Date editTime){
		Map<String,Object> params = new HashMap<>();
		params.put("brandNo", brandNo);
		params.put("productNo", productNo);
		params.put("edittm", editTime);
		return params;
	}

	private void addSyncLog(DataSyncLog data){
		try {
			if(null == dataSyncLogService.getDataSyncLog(data.getId())){
				dataSyncLogService.addDataSyncLog(data);
			} else {
				dataSyncLogService.updateDataSyncLog(data);
			}
		} catch (Exception e) {
			// TODO: handle exception
			DistributeLog.error(e.getMessage(),e);
		}
	}
}
