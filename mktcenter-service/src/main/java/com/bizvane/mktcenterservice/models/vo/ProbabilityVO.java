package com.bizvane.mktcenterservice.models.vo;

/**
 * @Author: lijunwei
 * @Time: 2019/2/25 22:02
 */
public class ProbabilityVO {
    private Long mktActivityId;
    private String activityCode;
    private String memberCode;
    private Integer activityType;
    private Integer triesLimit;

    public Long getMktActivityId() {
        return mktActivityId;
    }

    public void setMktActivityId(Long mktActivityId) {
        this.mktActivityId = mktActivityId;
    }

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public Integer getTriesLimit() {
        return triesLimit;
    }

    public void setTriesLimit(Integer triesLimit) {
        this.triesLimit = triesLimit;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }
}
