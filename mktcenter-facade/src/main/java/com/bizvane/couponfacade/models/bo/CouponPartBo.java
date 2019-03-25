package com.bizvane.couponfacade.models.bo;

/**
 * @author liufq
 */
public class CouponPartBo {
    //用于接收前端参数的实体类
    /**
     * 判断是订单量或者成交额的属性
     * orderNum 订单量
     * turnVolume 成交额
     * */
    private String orderNumOrTurnVolume;
    /**
     * 账号id
     * */
    private Long sysAccountId;

    /**
     * 企业id
     * */

    private Long sysCompanyId;

    /**
     * 品牌id
     * */
    private Long sysBrandId;

    /**
     *  券类型Id
     * */
    private String vouTypeId;

    /**
     * 自定义日期开始时间
     */
    private String startDate;

    /**
     * 自定义日期结束时间
     */
    private String endDate;
    /**
     * 报表粒度 1:日 2:周 3:月 4:年
     */
    private String particleSize;

    /**
     * 粒度具体。例：30天
     * */
    private int number;

    /**
     * 页显示条数
     * */
    private int pageSize;

    /**
     * 当前页数
     * */
    private int pageNumber;

    /**
     * 是否导出
     * */
    private String isExport;

    public Long getSysAccountId() {
        return sysAccountId;
    }

    public void setSysAccountId(Long sysAccountId) {
        this.sysAccountId = sysAccountId;
    }

    public Long getSysCompanyId() {
        return sysCompanyId;
    }

    public void setSysCompanyId(Long sysCompanyId) {
        this.sysCompanyId = sysCompanyId;
    }

    public Long getSysBrandId() {
        return sysBrandId;
    }

    public void setSysBrandId(Long sysBrandId) {
        this.sysBrandId = sysBrandId;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getVouTypeId() {
        return vouTypeId;
    }

    public void setVouTypeId(String vouTypeId) {
        this.vouTypeId = vouTypeId;
    }

    public String getIsExport() {
        return isExport;
    }

    public void setIsExport(String isExport) {
        this.isExport = isExport;
    }

    public String getOrderNumOrTurnVolume() {
        return orderNumOrTurnVolume;
    }

    public void setOrderNumOrTurnVolume(String orderNumOrTurnVolume) {
        this.orderNumOrTurnVolume = orderNumOrTurnVolume;
    }
}
