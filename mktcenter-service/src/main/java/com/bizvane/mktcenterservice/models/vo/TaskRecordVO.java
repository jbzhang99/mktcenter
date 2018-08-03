package com.bizvane.mktcenterservice.models.vo;

import com.bizvane.mktcenterservice.models.po.MktTaskProfilePO;
import com.bizvane.mktcenterservice.models.po.MktTaskRecordPO;

import java.util.Date;
import java.util.List;

/**
 * Created by Geng on 2018/8/1.
 */
public class TaskRecordVO extends MktTaskRecordPO{

    //赠送总积分数
    private Long allPoints;

    //发行券总张数
    private Long allCountCoupon;

    //参与任务总人数
    private Long allCountMbr;

    //被核销优惠券数
    private Long allinvalidCountCoupon;


    //每天的记录
    private List<DayTaskRecordVo> dayTaskRecordVoList;





    public Long getAllPoints() {
        return allPoints;
    }

    public Long getAllCountCoupon() {
        return allCountCoupon;
    }

    public Long getAllCountMbr() {
        return allCountMbr;
    }

    public Long getAllinvalidCountCoupon() {
        return allinvalidCountCoupon;
    }





    public void setAllPoints(Long allPoints) {
        this.allPoints = allPoints;
    }

    public void setAllCountCoupon(Long allCountCoupon) {
        this.allCountCoupon = allCountCoupon;
    }

    public void setAllCountMbr(Long allCountMbr) {
        this.allCountMbr = allCountMbr;
    }

    public void setAllinvalidCountCoupon(Long allinvalidCountCoupon) {
        this.allinvalidCountCoupon = allinvalidCountCoupon;
    }

    public List<DayTaskRecordVo> getDayTaskRecordVoList() {
        return dayTaskRecordVoList;
    }

    public void setDayTaskRecordVoList(List<DayTaskRecordVo> dayTaskRecordVoList) {
        this.dayTaskRecordVoList = dayTaskRecordVoList;
    }
}
