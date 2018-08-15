package com.bizvane.mktcenterservice.models.vo;

/**
 * @Author: lijunwei
 * @Time: 2018/8/13 16:25
 */
public class TaskForWXVO {
    private  Integer pageNumber=1;
    private  Integer pageSize=10;

    private Long brandId;
    private String memberCode;
    private Integer rewarded;//1=完成   0=未完成

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public Integer getRewarded() {
        return rewarded;
    }

    public void setRewarded(Integer rewarded) {
        this.rewarded = rewarded;
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
}
