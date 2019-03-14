package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;

public class MktTaskProfilePOWithBLOBs extends MktTaskProfilePO implements Serializable {
    /**
     * 只读.
    需要完善的字段code，逗号分隔. property_code
     *
     * @mbg.generated 2018-09-12 11:00:25
     */
    @io.swagger.annotations.ApiModelProperty(value = "需要完善的字段code，逗号分隔",name = "propertyCode", required = false,example = "")
    private String propertyCode;

    /**
     * 只读.
    门店限制名单. store_limit_list
     *
     * @mbg.generated 2018-09-12 11:00:25
     */
    @io.swagger.annotations.ApiModelProperty(value = "门店限制名单",name = "storeLimitList", required = false,example = "")
    private String storeLimitList;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-12 11:00:25
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-12 11:00:25
     */
    public String getPropertyCode() {
        return propertyCode;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-12 11:00:25
     */
    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode == null ? null : propertyCode.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-12 11:00:25
     */
    public String getStoreLimitList() {
        return storeLimitList;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-12 11:00:25
     */
    public void setStoreLimitList(String storeLimitList) {
        this.storeLimitList = storeLimitList == null ? null : storeLimitList.trim();
    }
}