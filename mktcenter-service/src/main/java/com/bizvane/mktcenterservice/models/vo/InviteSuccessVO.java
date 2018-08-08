package com.bizvane.mktcenterservice.models.vo;

import java.util.Date;

/**
 * @Author: lijunwei
 * @Time: 2018/8/8 20:37
 * 邀请会员注册
 */
public class InviteSuccessVO {
    //注册人code
    private String memberCode;
    //开卡时间
    private Date openCardTime;
    //邀请人
    private String inviteMemberCode;

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }
}
