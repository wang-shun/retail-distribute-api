package cn.wonhigh.retail.distribute.common.model;

import java.io.Serializable;
import java.util.Date;

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
public class BizNoTransform implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private String requestNo;

    /**
     * 
     */
    private String brandNo;
    
    private String paramExt1;
    
    private String paramExt2;

    /**
     * 
     */
    private String responseNo;

    /**
     * 
     */
    private String responseName;

    /**
     * 
     */
    private String createUser;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private String updateUser;

    /**
     * 
     */
    private Date updateTime;
    

    public String getParamExt1() {
		return paramExt1;
	}

	public void setParamEx1(String paramExt1) {
		this.paramExt1 = paramExt1;
	}

	public String getParamExt2() {
		return paramExt2;
	}

	public void setParamEx2(String paramExt2) {
		this.paramExt2 = paramExt2;
	}

	/**
     * 
     * {@linkplain #id}
     *
     * @return the value of biz_no_transform.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * {@linkplain #id}
     * @param id the value for biz_no_transform.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * {@linkplain #type}
     *
     * @return the value of biz_no_transform.type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * {@linkplain #type}
     * @param type the value for biz_no_transform.type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * {@linkplain #requestNo}
     *
     * @return the value of biz_no_transform.request_no
     */
    public String getRequestNo() {
        return requestNo;
    }

    /**
     * 
     * {@linkplain #requestNo}
     * @param requestNo the value for biz_no_transform.request_no
     */
    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    /**
     * 
     * {@linkplain #brandNo}
     *
     * @return the value of biz_no_transform.brand_no
     */
    public String getBrandNo() {
        return brandNo;
    }

    /**
     * 
     * {@linkplain #brandNo}
     * @param brandNo the value for biz_no_transform.brand_no
     */
    public void setBrandNo(String brandNo) {
        this.brandNo = brandNo;
    }

    /**
     * 
     * {@linkplain #responseNo}
     *
     * @return the value of biz_no_transform.response_no
     */
    public String getResponseNo() {
        return responseNo;
    }

    /**
     * 
     * {@linkplain #responseNo}
     * @param responseNo the value for biz_no_transform.response_no
     */
    public void setResponseNo(String responseNo) {
        this.responseNo = responseNo;
    }

    /**
     * 
     * {@linkplain #responseName}
     *
     * @return the value of biz_no_transform.response_name
     */
    public String getResponseName() {
        return responseName;
    }

    /**
     * 
     * {@linkplain #responseName}
     * @param responseName the value for biz_no_transform.response_name
     */
    public void setResponseName(String responseName) {
        this.responseName = responseName;
    }

    /**
     * 
     * {@linkplain #createUser}
     *
     * @return the value of biz_no_transform.create_user
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 
     * {@linkplain #createUser}
     * @param createUser the value for biz_no_transform.create_user
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 
     * {@linkplain #createTime}
     *
     * @return the value of biz_no_transform.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * {@linkplain #createTime}
     * @param createTime the value for biz_no_transform.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     * {@linkplain #updateUser}
     *
     * @return the value of biz_no_transform.update_user
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 
     * {@linkplain #updateUser}
     * @param updateUser the value for biz_no_transform.update_user
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 
     * {@linkplain #updateTime}
     *
     * @return the value of biz_no_transform.update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 
     * {@linkplain #updateTime}
     * @param updateTime the value for biz_no_transform.update_time
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	public void setParamExt1(String paramExt1) {
		this.paramExt1 = paramExt1;
	}

	public void setParamExt2(String paramExt2) {
		this.paramExt2 = paramExt2;
	}

}