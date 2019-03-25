package com.bizvane.messagefacade.models.vo;

/**
 * Created by Geng on 2018/8/17.
 */
public class SmsStatisticsVO {
    
	//总条数
    private Long allCountSms;

    //成功
    private Long failedSms;

    //失败
    private Long successSms;
    //成功率100.00%
    private String successPercent;
    
    

    public Long getAllCountSms() {
        return allCountSms;
    }

    public void setAllCountSms(Long allCountSms) {
        this.allCountSms = allCountSms;
    }

    public Long getFailedSms() {
        return failedSms;
    }

    public void setFailedSms(Long failedSms) {
        this.failedSms = failedSms;
    }

    public Long getSuccessSms() {
        return successSms;
    }

    public void setSuccessSms(Long successSms) {
        this.successSms = successSms;
    }

    public String getSuccessPercent() {
        return successPercent;
    }

    public void setSuccessPercent(String successPercent) {
        this.successPercent = successPercent;
    }
}
