package com.bizvane.couponfacade.models.po;

import com.bizvane.couponfacade.models.po.CouponQuotaSendDetailPO;

import java.io.Serializable;

public class CouponQuotaSendDetailPOWithBLOBs extends CouponQuotaSendDetailPO implements Serializable {

	/**
	 * 只读. 发送会员code集合. member_code_list
	 * @mbg.generated  2018-12-11 18:35:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "发送会员code集合", name = "memberCodeList", required = false, example = "")
	private String memberCodeList;
	/**
	 * 只读. 发送会员名称集合. member_name_list
	 * @mbg.generated  2018-12-11 18:35:30
	 */
	@io.swagger.annotations.ApiModelProperty(value = "发送会员名称集合", name = "memberNameList", required = false, example = "")
	private String memberNameList;
	/**
	 * 只读. 
	 * @mbg.generated  2018-12-11 18:35:30
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-11 18:35:30
	 */
	public String getMemberCodeList() {
		return memberCodeList;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-11 18:35:30
	 */
	public void setMemberCodeList(String memberCodeList) {
		this.memberCodeList = memberCodeList == null ? null : memberCodeList.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-11 18:35:30
	 */
	public String getMemberNameList() {
		return memberNameList;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-11 18:35:30
	 */
	public void setMemberNameList(String memberNameList) {
		this.memberNameList = memberNameList == null ? null : memberNameList.trim();
	}
}