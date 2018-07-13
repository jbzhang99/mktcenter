package com.bizvane.mktcenterservice.models.vo;

import com.bizvane.mktcenterservice.models.po.MktActivityPO;
import com.bizvane.mktcenterservice.models.po.MktActivityRegisterPO;

/**
 * @author chen.li
 * @date on 2018/7/6 20:07
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public class ActivityVO extends MktActivityPO {

    /**
     * 只读. 活动描述、简介. activity_info
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "活动描述、简介", name = "activityInfo", required = false, example = "")
    private String activityInfo;

    /**
     * 只读. 线下开卡状态：0所有，1未开，2已开. offline_card_status
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "线下开卡状态：0所有，1未开，2已开", name = "offlineCardStatus", required = false, example = "")
    private Integer offlineCardStatus;

    /**
     * 只读. 开卡时等级编号. mbr_level_code
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "活动针对的会员等级编号", name = "mbrLevelCode", required = false, example = "")
    private String mbrLevelCode;
    /**
     * 只读. 开卡时等级名称. mbr_level_name
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "活动针对的会员等级名称", name = "mbrLevelName", required = false, example = "")
    private String mbrLevelName;

    /**
     * 只读. 针对的会员类型：0,所有类型，1微信会员. member_type
     * @mbg.generated  2018-07-13 11:45:27
     */
    @io.swagger.annotations.ApiModelProperty(value = "针对的会员类型：0,所有类型，1微信会员", name = "memberType", required = false, example = "")
    private Integer memberType;

    /**
     * 只读. 提前多少日进行. days_ahead
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "提前多少日进行", name = "daysAhead", required = false, example = "")
    private Integer daysAhead;

    public String getActivityInfo() {
        return activityInfo;
    }

    public void setActivityInfo(String activityInfo) {
        this.activityInfo = activityInfo;
    }

    public Integer getOfflineCardStatus() {
        return offlineCardStatus;
    }

    public void setOfflineCardStatus(Integer offlineCardStatus) {
        this.offlineCardStatus = offlineCardStatus;
    }

    public String getMbrLevelCode() {
        return mbrLevelCode;
    }

    public void setMbrLevelCode(String mbrLevelCode) {
        this.mbrLevelCode = mbrLevelCode;
    }

    public String getMbrLevelName() {
        return mbrLevelName;
    }

    public void setMbrLevelName(String mbrLevelName) {
        this.mbrLevelName = mbrLevelName;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public Integer getDaysAhead() {
        return daysAhead;
    }

    public void setDaysAhead(Integer daysAhead) {
        this.daysAhead = daysAhead;
    }
}
