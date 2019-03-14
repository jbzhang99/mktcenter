package com.bizvane.mktcenterfacade.models.vo;

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

    private  Long storeId;
    //1,%
    private  String storeIdStyleOne;
    //%,1,%
    private  String storeIdStyleTwo;
    //%,2
    private  String storeIdStyleThree;

    private Long mktTaskId;
    private Integer taskType;

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

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreIdStyleOne() {
        return storeIdStyleOne;
    }

    public void setStoreIdStyleOne(String storeIdStyleOne) {
        this.storeIdStyleOne = storeIdStyleOne;
    }

    public String getStoreIdStyleTwo() {
        return storeIdStyleTwo;
    }

    public void setStoreIdStyleTwo(String storeIdStyleTwo) {
        this.storeIdStyleTwo = storeIdStyleTwo;
    }

    public String getStoreIdStyleThree() {
        return storeIdStyleThree;
    }

    public void setStoreIdStyleThree(String storeIdStyleThree) {
        this.storeIdStyleThree = storeIdStyleThree;
    }

    public Long getMktTaskId() {
        return mktTaskId;
    }

    public void setMktTaskId(Long mktTaskId) {
        this.mktTaskId = mktTaskId;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }
}
