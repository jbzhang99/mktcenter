package com.bizvane.mktcenterserviceimpl.controllers;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.mktcenterservice.interfaces.ActivityPriceService;
import com.bizvane.mktcenterservice.interfaces.ActivityRedPacketService;
import com.bizvane.mktcenterservice.models.bo.ActivityRedPacketBO;
import com.bizvane.mktcenterservice.models.bo.ActivityRedPacketListBO;
import com.bizvane.mktcenterservice.models.bo.MktActivityRedPacketRecordBO;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktActivityRedPacketRecordPO;
import com.bizvane.mktcenterservice.models.vo.ActivityPriceParamVO;
import com.bizvane.mktcenterservice.models.vo.ActivityRedPacketVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2019/1/14 14:41
 */
@RestController
@RequestMapping("activityRedPacket")
public class ActivityRedPacketController {
    @Autowired
    private ActivityRedPacketService activityRedPacketService;
    @Autowired
    private ActivityPriceService activityPriceService;

    @RequestMapping("addActivityRedPacket")
    public ResponseData<JSONObject> addActivityRedPacket(ActivityRedPacketBO bo, HttpServletRequest request) throws ParseException {
        return activityRedPacketService.addActivityRedPacket(bo, request);
    }

    @RequestMapping("selectActivityRedPacket")
    public ResponseData<ActivityRedPacketBO> selectActivityRedPacket(ActivityRedPacketVO vo) {
        return activityRedPacketService.selectActivityRedPacket(vo);
    }

    @RequestMapping("selectActivityRedPacketList")
    public ResponseData<PageInfo<MktActivityPOWithBLOBs>> selectActivityRedPacketList(ActivityPriceParamVO vo, HttpServletRequest request) {
        return activityRedPacketService.selectActivityRedPacketList(vo, request);
    }

    @RequestMapping("stopActivityRebPacket")
    public ResponseData<Integer> stopActivityPrice(MktActivityPOWithBLOBs po, HttpServletRequest request) {
        return activityPriceService.stopActivityPrice(po, request);
    }
    @RequestMapping("selectActivityRedPacketDetail")
    public ResponseData<ActivityRedPacketBO> selectActivityRedPacketDetail(ActivityRedPacketVO vo) {
        return activityRedPacketService.selectActivityRedPacketDetail(vo);
    }

    @RequestMapping("doIfActivityRedPacket")
    public ResponseData<Integer> doIfActivityRedPacket(ActivityRedPacketVO vo) {
        return activityRedPacketService.doIfActivityRedPacket(vo);
    }

    @RequestMapping("selectActivityRedPacketAnalyzeLists")
    public ResponseData<PageInfo<ActivityRedPacketListBO>> selectActivityRedPacketAnalyzeLists(ActivityRedPacketVO vo, HttpServletRequest request) {
        return activityRedPacketService.selectActivityRedPacketAnalyzeLists(vo, request);
    }

    @RequestMapping("getRedPacketCoponRecord")
    public ResponseData<PageInfo<MktActivityRedPacketRecordBO>> getRedPacketCoponRecord(ActivityRedPacketVO vo, HttpServletRequest request) {
        return activityRedPacketService.getRedPacketCoponRecord(vo, request);
    }
    @RequestMapping("getRedPacketZhuLiRecord")
    public ResponseData<List<MktActivityRedPacketRecordPO>> getRedPacketZhuLiRecord(ActivityRedPacketVO vo, HttpServletRequest request) {
        return activityRedPacketService.getRedPacketZhuLiRecord(vo);
    }

    @RequestMapping("andActivityRedPacketCreateRecord")
    public void andActivityRedPacketCreateRecord(ActivityRedPacketVO vo) {
        activityRedPacketService.andActivityRedPacketCreateRecord(vo);
    }
    @RequestMapping("andActivityRedPacketZhuliRecord")
    public void andActivityRedPacketZhuliRecord(ActivityRedPacketVO vo) {
        activityRedPacketService.andActivityRedPacketZhuliRecord(vo);
    }
    @RequestMapping("andActivityRedPacketSendCouponRecord")
    public ResponseData<Integer> andActivityRedPacketSendCouponRecord(ActivityRedPacketVO vo) {
        return activityRedPacketService.andActivityRedPacketSendCouponRecord(vo);
    }
    @RequestMapping("getRedPacketCoponAppRecord")
    public ResponseData<List<MktActivityRedPacketRecordBO>> getRedPacketCoponAppRecord(ActivityRedPacketVO vo){
        return activityRedPacketService.getRedPacketCoponAppRecord(vo);
    }

}
