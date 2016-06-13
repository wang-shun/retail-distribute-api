package cn.wonhigh.retail.scheduler.distribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import cn.wonhigh.retail.distribute.common.model.BizNoTransform;
import cn.wonhigh.retail.distribute.manager.BizNoTransformManager;
import cn.wonhigh.retail.uc.common.api.utils.CommonUtil;

import com.yougou.logistics.base.common.exception.ManagerException;

/**
 * 系统参数类型
 * @author user
 *
 */
@Component
public class SystemParamUtils {
	
	private static BizNoTransformManager bizNoTransformManager;
	
	private static Map<String/**类型*/,Map<String/**品牌*/,Map<String/**主数据编码*/,List<BizNoTransform>>>> bizParams = new HashMap<>();
	
	static{
		initBizNoTransform();
	}
	
	private static void initBizNoTransform(){
		//load整个表
	}
	
	/**
	 * 清除缓存
	 */
	public static void clear(){
		bizParams.clear();
		bizParams = new HashMap<>();
	}
	
	public static BizNoTransform getSizeCode(String type,String brandNo,
			String requestNo,String paramExt1){
		List<BizNoTransform> bizs = getBizNoTransforms(type,brandNo,requestNo);
		if(null == bizs){
			return null;
		} else {
			for(BizNoTransform biz : bizs){
				if(StringUtils.equals(paramExt1, biz.getParamExt1())){
					return biz;
				}
			}
			//没有Load到,继续Load
			List<BizNoTransform> bs = findByBiz(type, brandNo, requestNo, paramExt1);
			if(CommonUtil.hasValue(bs)){
				bizs.add(bs.get(0));
				return bs.get(0);
			}
		}
		return null;
	}
	
	public static List<BizNoTransform> getBizNoTransforms(String type,String brandNo,String requestNo){
		List<BizNoTransform> bizs = getTypeBrand(type, brandNo).get(requestNo);
		if(null == bizs || bizs.size() == 0){
			bizs = findByBiz(type, brandNo,requestNo,null);
			getTypeBrand(type, brandNo).put(requestNo, bizs);
		}
		return bizs;
	}
	
	/**
	 * 根据类型与品牌进行LOAD
	 * @param type
	 * @param brandNo
	 * @return
	 * @throws ManagerException 
	 */
	public static Map<String,List<BizNoTransform>> getTypeBrand(String type,String brandNo){
		Map<String,List<BizNoTransform>> bizms = getTypes(type).get(brandNo);
			if(bizms == null){
				List<BizNoTransform> bizs = findByBiz(type, brandNo,null,null);
				bizms = new HashMap<>();
				for(BizNoTransform biz : bizs){
					List<BizNoTransform> bs = bizms.get(biz.getRequestNo());
					if(null == bs){
						bs = new ArrayList<>(1);
					}
					bs.add(biz);
					bizms.put(biz.getRequestNo(), bs);
				}
			bizParams.get(type).put(brandNo, bizms);
		}
		return bizms;
	}
	
	private static Map<String,Map<String,List<BizNoTransform>>> getTypes(String type){
		Map<String,Map<String,List<BizNoTransform>>> types = bizParams.get(type);
		if(types == null){
			//暂时不LOAD
			types = new HashMap<>();
			bizParams.put(type, types);
		}
		return types;
	}
	
	private static List<BizNoTransform> findByBiz(String type,String brandNo,String requestNo,String paramExt1){
		Map<String,Object> params = buildParams(type,brandNo,requestNo,paramExt1);
		try {
			return bizNoTransformManager.findByBiz(null, params);
		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("数据库异常，获取业务转换数据失败",e);
		}
	}

	private static Map<String,Object> buildParams(String type,String brandNo,String requestNo,String paramExt1){
		Map<String,Object> params = new HashMap<>();
		params.put("type", type);
		params.put("brandNo", brandNo);
		params.put("requestNo", requestNo);
		params.put("paramExt1", paramExt1);
		return params;
	}
	
	@Resource
	public void setBizNoTransformManager(
			BizNoTransformManager bizNoTransformManager) {
		SystemParamUtils.bizNoTransformManager = bizNoTransformManager;
	}
}
