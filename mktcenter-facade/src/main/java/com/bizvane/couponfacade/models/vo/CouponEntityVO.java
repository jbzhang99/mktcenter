package com.bizvane.couponfacade.models.vo;

import com.bizvane.couponfacade.models.po.CouponEntityPO;

import java.util.Date;
import java.util.List;


public class CouponEntityVO extends CouponEntityPO{

    @io.swagger.annotations.ApiModelProperty(value = "优惠类型（1现金，2折扣，3礼品）", name = "preferentialType", required = false,example = "")
    private Byte preferentialType;

    @io.swagger.annotations.ApiModelProperty(value = "赠与会员号", name = "oldMemberCode", required = true,example = "")
    private String oldMemberCode;
    @io.swagger.annotations.ApiModelProperty(value = "被赠与会员号", name = "newMemberCode", required = true,example = "")
    private String newMemberCode;

    @io.swagger.annotations.ApiModelProperty(value = "开始时间", name = "createDtStart", required = false,example = "")
    private String createDtStart;
    @io.swagger.annotations.ApiModelProperty(value = "结束时间", name = "createDtEnd", required = false,example = "")
    private String createDtEnd;

    @io.swagger.annotations.ApiModelProperty(value = "开始时间", name = "dtStart", required = false,example = "")
    private Date dtStart;
    @io.swagger.annotations.ApiModelProperty(value = "结束时间", name = "dtEnd", required = false,example = "")
    private Date dtEnd;

    @io.swagger.annotations.ApiModelProperty(value = "当前页数", name = "pageNumber")
    private Integer pageNumber = 1;

    @io.swagger.annotations.ApiModelProperty(value = "显示条数", name = "pageSize")
    private Integer pageSize = 20;

    @io.swagger.annotations.ApiModelProperty(value = "id集合", name = "sendIdList", required = false,example = "")
    private List<Long> sendIdList;

    @io.swagger.annotations.ApiModelProperty(value = "手机号", name = "phone", required = false,example = "")
    private String phone;

    @io.swagger.annotations.ApiModelProperty(value = "会员卡号", name = "cardNo", required = false,example = "")
    private String cardNo;

    @io.swagger.annotations.ApiModelProperty(value = "描述", name = "description", required = false,example = "")
    private String description;

    @io.swagger.annotations.ApiModelProperty(value = "", name = "name", required = false,example = "")
    private String name;
    
    @io.swagger.annotations.ApiModelProperty(value = "会员名称", name = "memberName", required = false,example = "")
    private String memberName;
    
    
    @io.swagger.annotations.ApiModelProperty(value = "多少天到期", name = "memberName", required = false,example = "")
    private String dateDue;

    @io.swagger.annotations.ApiModelProperty(value = "微信昵称", name = "wxNick", required = false,example = "")
    private String wxNick;
//    1.手动发券任务 -- 85
//    2.会员活动-- 15,30,35,45,50,55,90,100
//    3.会员任务 -- 60,65,70,75,80
//    4.智能营销 - 95
//    5.会员分组运营-94
//    6.转赠-20
    @io.swagger.annotations.ApiModelProperty(value = "列表类型：1.手动发券任务2.会员活动- 3.会员任务4.智能营销  5.会员分组运营   6.转赠", name = "listType", required = false,example = "")
    private String listType;
    private String listTypeBusinessName;
    
    @io.swagger.annotations.ApiModelProperty(value = "任务名称", name = "businessName", required = false,example = "")
    private String businessName;
    
    @io.swagger.annotations.ApiModelProperty(value = "查询", name = "baseSearchValue", required = false,example = "")
    private String baseSearchValue;
    
    @io.swagger.annotations.ApiModelProperty(value = "员工", name = "staffcode", required = false,example = "")
    private String staffcode;
    @io.swagger.annotations.ApiModelProperty(value = "查询类型", name = "DESC", required = false,example = "")
    private String fingType;
    
    @io.swagger.annotations.ApiModelProperty(value = "'好友userid", name = "DESC", required = false,example = "")
    private String externalUserId;
    
    
    @io.swagger.annotations.ApiModelProperty(value = "'会员头像", name = "DESC", required = false,example = "")
    private String headPortraits;
    
    @io.swagger.annotations.ApiModelProperty(value = "'备注", name = "DESC", required = false,example = "")
    private String memberComment;
    
    

    public String getListTypeBusinessName() {
		return listTypeBusinessName;
	}

	public void setListTypeBusinessName(String listTypeBusinessName) {
		this.listTypeBusinessName = listTypeBusinessName;
	}

	public String getMemberComment() {
		return memberComment;
	}

	public void setMemberComment(String memberComment) {
		this.memberComment = memberComment;
	}

	public String getExternalUserId() {
		return externalUserId;
	}

	public void setExternalUserId(String externalUserId) {
		this.externalUserId = externalUserId;
	}

	public String getHeadPortraits() {
		return headPortraits;
	}

	public void setHeadPortraits(String headPortraits) {
		this.headPortraits = headPortraits;
	}

	public String getStaffcode() {
		return staffcode;
	}

	public void setStaffcode(String staffcode) {
		this.staffcode = staffcode;
	}

	public String getFingType() {
		return fingType;
	}

	public void setFingType(String fingType) {
		this.fingType = fingType;
	}

	public String getDateDue() {
		return dateDue;
	}

	public void setDateDue(String dateDue) {
		this.dateDue = dateDue;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getBaseSearchValue() {
		return baseSearchValue;
	}

	public void setBaseSearchValue(String baseSearchValue) {
		this.baseSearchValue = baseSearchValue;
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

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWxNick() {
        return wxNick;
    }

    public void setWxNick(String wxNick) {
        this.wxNick = wxNick;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public Byte getPreferentialType() {
        return preferentialType;
    }

    @Override
    public void setPreferentialType(Byte preferentialType) {
        this.preferentialType = preferentialType;
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

    public String getOldMemberCode() {
        return oldMemberCode;
    }

    public void setOldMemberCode(String oldMemberCode) {
        this.oldMemberCode = oldMemberCode;
    }

    public String getNewMemberCode() {
        return newMemberCode;
    }

    public void setNewMemberCode(String newMemberCode) {
        this.newMemberCode = newMemberCode;
    }

    public void setCreateDtEnd(String createDtEnd) {
        this.createDtEnd = createDtEnd;
    }

    public List<Long> getSendIdList() {
        return sendIdList;
    }

    public void setSendIdList(List<Long> sendIdList) {
        this.sendIdList = sendIdList;
    }

    public Date getDtStart() {
        return dtStart;
    }

    public void setDtStart(Date dtStart) {
        this.dtStart = dtStart;
    }

    public Date getDtEnd() {
        return dtEnd;
    }

    public void setDtEnd(Date dtEnd) {
        this.dtEnd = dtEnd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
