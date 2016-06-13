package cn.wonhigh.retail.distribute.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wonhigh.retail.distribute.dal.database.BizNoTransformMapper;

import com.yougou.logistics.base.dal.database.BaseCrudMapper;
import com.yougou.logistics.base.service.BaseCrudServiceImpl;

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
@Service("bizNoTransformService")
class BizNoTransformServiceImpl extends BaseCrudServiceImpl implements BizNoTransformService {
    @Resource
    private BizNoTransformMapper bizNoTransformMapper;

    @Override
    public BaseCrudMapper init() {
        return bizNoTransformMapper;
    }
}