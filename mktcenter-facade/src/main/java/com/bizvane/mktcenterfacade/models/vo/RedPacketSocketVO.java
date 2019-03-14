package com.bizvane.mktcenterfacade.models.vo;

import com.bizvane.mktcenterfacade.models.po.MktActivityRedPacketRecordPO;

import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2019/1/24 18:29
 */
public class RedPacketSocketVO {
    private Integer copouAppData;
    private List<MktActivityRedPacketRecordPO> dataAppZhuli;
    private String memberCode;

    public Integer getCopouAppData() {
        return copouAppData;
    }

    public void setCopouAppData(Integer copouAppData) {
        this.copouAppData = copouAppData;
    }

    public List<MktActivityRedPacketRecordPO> getDataAppZhuli() {
        return dataAppZhuli;
    }

    public void setDataAppZhuli(List<MktActivityRedPacketRecordPO> dataAppZhuli) {
        this.dataAppZhuli = dataAppZhuli;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }
}
