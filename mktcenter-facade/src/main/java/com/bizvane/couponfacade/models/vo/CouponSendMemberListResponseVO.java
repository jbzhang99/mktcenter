package com.bizvane.couponfacade.models.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yunjie.tian on 2018/10/23.
 */
public class CouponSendMemberListResponseVO implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @io.swagger.annotations.ApiModelProperty(value = "会员卡号", name = "cardNo", required = false,example = "")
    private String cardNo;

    @io.swagger.annotations.ApiModelProperty(value = "会员名称", name = "memberName", required = false,example = "")
    private String memberName;

    @io.swagger.annotations.ApiModelProperty(value = "会员等级", name = "levelName", required = false,example = "")
    private String levelName;

    @io.swagger.annotations.ApiModelProperty(value = "发券时间", name = "sendDate", required = false,example = "")
    private Date sendDate;

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }
}
