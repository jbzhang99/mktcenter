package com.bizvane.couponfacade.models.vo;

import com.bizvane.couponfacade.models.po.CouponSendFailLogPO;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by yunjie.tian on 2018/7/21.
 */
public class CouponSendFailLogVO extends CouponSendFailLogPO{
    @ApiModelProperty(value = "会员卡号", name = "cardNo", required = false,example = "")
    private String cardNo;
    @ApiModelProperty(value = "手机号", name = "phone", required = false,example = "")
    private String phone;
    @ApiModelProperty(value = "会员", name = "name", required = false,example = "")
    private String name;
    @ApiModelProperty(value = "会员姓名", name = "memberName", required = false,example = "")
    private String memberName;
    @ApiModelProperty(value = "渠道限制（1仅线上，2仅线下，3全渠道）", name = "useChannel", required = false,example = "")
    private String useChannel;

    @ApiModelProperty(value = "发券开始时间", name = "createDtStart", required = false,example = "")
    private String createDtStart;
    @ApiModelProperty(value = "发券结束时间", name = "createDtEnd", required = false,example = "")
    private String createDtEnd;

    @ApiModelProperty(value = "发放类型（10-开卡发券，15生日发券，105-受赠，115-积分兑换）", name = "sendType", required = false,example = "")
    private String sendType;
    
    @ApiModelProperty(value = "列表类型：1.手动发券任务2.会员活动- 3.会员任务4.智能营销  5.会员分组运营   6.转赠", name = "listType", required = false,example = "")
    private String listType;

    @ApiModelProperty(value = "查询", name = "baseSearchValue", required = false,example = "")
    private String baseSearchValue;

    @ApiModelProperty(value = "任务名称", name = "businessName", required = false,example = "")
    private String businessName;
    
    

    public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getListType() {
		return listType;
	}

	public void setListType(String listType) {
		this.listType = listType;
	}

	public String getBaseSearchValue() {
		return baseSearchValue;
	}

	public void setBaseSearchValue(String baseSearchValue) {
		this.baseSearchValue = baseSearchValue;
	}

	public String getCreateDtStart() {
        return createDtStart;
    }

    public void setCreateDtStart(String createDtStart) {
        this.createDtStart = createDtStart;
    }

    public String getCreateDtEnd() {
        return createDtEnd;
    }

    public void setCreateDtEnd(String createDtEnd) {
        this.createDtEnd = createDtEnd;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUseChannel() {
        return useChannel;
    }

    public void setUseChannel(String useChannel) {
        this.useChannel = useChannel;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
