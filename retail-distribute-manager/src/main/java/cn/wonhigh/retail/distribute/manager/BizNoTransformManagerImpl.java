package cn.wonhigh.retail.distribute.manager;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wonhigh.retail.distribute.service.BizNoTransformService;

import com.yougou.logistics.base.manager.BaseCrudManagerImpl;
import com.yougou.logistics.base.service.BaseCrudService;

/**
 * 请写出类的用途 
 * @author user
 * @date  2015-07-15 18:13:09
 * @version 1.0.0
 * @copyright (C) 2013 WonHigh Information Technology Co.,Ltd 
 * All Rights Reserved. 
 * 
 * The software for the WonHigh technology development, without the 
 * company's written consent, and any other individuals and 
 * organizations shall not be used, Copying, Modify or distribute 
 * the software.
 * 
 */
@Service("bizNoTransformManager")
class BizNoTransformManagerImpl extends BaseCrudManagerImpl implements BizNoTransformManager {
    @Resource
    private BizNoTransformService bizNoTransformService;

    @Override
    public BaseCrudService init() {
        return bizNoTransformService;
    }
}