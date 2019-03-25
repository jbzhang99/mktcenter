package com.bizvane.mktcenterfacade.models.po;

import java.io.Serializable;

public class MktTaskSharePOWithBLOBs extends MktTaskSharePO implements Serializable {
    /**
     * 只读.
    任务条件/需要分享的链接. share_url
     *
     * @mbg.generated 2018-09-12 11:00:25
     */
    @io.swagger.annotations.ApiModelProperty(value = "任务条件/需要分享的链接",name = "shareUrl", required = false,example = "")
    private String shareUrl;

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
    public String getShareUrl() {
        return shareUrl;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-12 11:00:25
     */
    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl == null ? null : shareUrl.trim();
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