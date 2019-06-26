package com.bizvane.mktcenterfacade.models.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Author: lijunwei
 * @Time: 2018/8/8 20:37
 * 邀请会员注册
 */
@Data
public class InviteSuccessVO {

    @NotNull
    private Long sysBrandId;
    //活动id
    private Long mktActivityId;

    //注册人code
    @NotNull
    private String memberCode;
    //开卡时间
    @NotNull
    private Date openCardTime;
    //邀请人
    @NotNull
    private String inviteMemberCode;
}
