package com.bizvane.couponfacade.models.bo;

import java.util.List;
import java.util.Map;

public class BigDataPartBo {
    //用于给大数据传递参数的实体类
    /**
     * 调用商家编号
     */
    private String businessNum;
    /**
     * APIkey
     */
    private String apiKey;

    /**
     * 企业编号
     */
    private String corpId;

    /**
     * 品牌编号
     */
    private String brandId;
    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 券类型id
     */
    private String vouTypeId;

    /**
     * 线下店铺id
     * */
    private String[] storeIds;

    /**
     * 店铺群组id
     * */
    private Map<String, List> storeIdsInArea;

    /**
     * 开始时间
     */
    private String startDate;
    /**
     * 结束时间
     */
    private String endDate;
    /**
     * 同比起止时间
     */
    private String yesteryearStartDate;
    /**
     * 同比截止时间
     */
    private String yesteryearEndDate;
    /**
     * 环比起止时间
     */
    private String lastStartDate;
    /**
     * 环比截止时间
     */
    private String lastEndDate;
    /**
     * 报表粒度 1:日 2:周 3:月 4:年
     */
    private String particleSize;

    private String startRecord;

    private int queryNum;

    //券类型id数组
    private String[] vouTypeIdList;

    public String[] getVouTypeIdList() {
        return vouTypeIdList;
    }

    public void setVouTypeIdList(String[] vouTypeIdList) {
        this.vouTypeIdList = vouTypeIdList;
    }

    public String getBusinessNum() {
        return businessNum;
    }

    public void setBusinessNum(String businessNum) {
        this.businessNum = businessNum;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getVouTypeId() {
        return vouTypeId;
    }

    public void setVouTypeId(String vouTypeId) {
        this.vouTypeId = vouTypeId;
    }

    public String[] getStoreIds() {
        return storeIds;
    }

    public void setStoreIds(String[] storeIds) {
        this.storeIds = storeIds;
    }

    public Map<String, List> getStoreIdsInArea() {
        return storeIdsInArea;
    }

    public void setStoreIdsInArea(Map<String, List> storeIdsInArea) {
        this.storeIdsInArea = storeIdsInArea;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getParticleSize() {
        return particleSize;
    }

    public void setParticleSize(String particleSize) {
        this.particleSize = particleSize;
    }

    public String getStartRecord() {
        return startRecord;
    }

    public void setStartRecord(String startRecord) {
        this.startRecord = startRecord;
    }

    public int getQueryNum() {
        return queryNum;
    }

    public void setQueryNum(int queryNum) {
        this.queryNum = queryNum;
    }

    public String getYesteryearStartDate() {
        return yesteryearStartDate;
    }

    public void setYesteryearStartDate(String yesteryearStartDate) {
        this.yesteryearStartDate = yesteryearStartDate;
    }

    public String getYesteryearEndDate() {
        return yesteryearEndDate;
    }

    public void setYesteryearEndDate(String yesteryearEndDate) {
        this.yesteryearEndDate = yesteryearEndDate;
    }

    public String getLastStartDate() {
        return lastStartDate;
    }

    public void setLastStartDate(String lastStartDate) {
        this.lastStartDate = lastStartDate;
    }

    public String getLastEndDate() {
        return lastEndDate;
    }

    public void setLastEndDate(String lastEndDate) {
        this.lastEndDate = lastEndDate;
    }
}
