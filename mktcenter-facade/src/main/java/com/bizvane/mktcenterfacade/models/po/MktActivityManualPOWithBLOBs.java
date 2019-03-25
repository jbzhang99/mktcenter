package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;

public class MktActivityManualPOWithBLOBs extends MktActivityManualPO implements Serializable {
    /**
     * 只读.
    二维码地址. qrcode
     *
     * @mbg.generated 2018-10-31 10:05:06
     */
    @io.swagger.annotations.ApiModelProperty(value = "二维码地址",name = "qrcode", required = false,example = "")
    private String qrcode;

    /**
     * 只读.
    门店限制名单. store_limit_list
     *
     * @mbg.generated 2018-10-31 10:05:06
     */
    @io.swagger.annotations.ApiModelProperty(value = "门店限制名单",name = "storeLimitList", required = false,example = "")
    private String storeLimitList;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-10-31 10:05:06
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-10-31 10:05:06
     */
    public String getQrcode() {
        return qrcode;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-10-31 10:05:06
     */
    public void setQrcode(String qrcode) {
        this.qrcode = qrcode == null ? null : qrcode.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-10-31 10:05:06
     */
    public String getStoreLimitList() {
        return storeLimitList;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-10-31 10:05:06
     */
    public void setStoreLimitList(String storeLimitList) {
        this.storeLimitList = storeLimitList == null ? null : storeLimitList.trim();
    }
}