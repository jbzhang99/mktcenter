package com.bizvane.mktcenterservice.models.vo;

import com.bizvane.mktcenterservice.models.po.MktTaskProfilePO;
import com.bizvane.mktcenterservice.models.po.MktTaskRecordPO;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;

/**
 * Created by Geng on 2018/8/1.
 */
public class TaskRecordVO{

    //赠送总积分数
    private Long allPoints;

    //发行券总张数
    private Long allCountCoupon;

    //参与任务总人数
    private Long allCountMbr;

    //被核销优惠券总数
    private Long allinvalidCountCoupon;


    //每天或每条记录 的分页结果
    private PageInfo<DayTaskRecordVo> dayTaskRecordVoList;





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

    public PageInfo<DayTaskRecordVo> getDayTaskRecordVoList() {
        return dayTaskRecordVoList;
    }

    public void setDayTaskRecordVoList(PageInfo<DayTaskRecordVo> dayTaskRecordVoList) {
        this.dayTaskRecordVoList = dayTaskRecordVoList;
    }
}
