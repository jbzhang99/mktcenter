package com.bizvane.mktcenterservice.controllers.rpc;

import com.bizvane.mktcenterfacade.interfaces.ActivityRedPacketService;
import com.bizvane.mktcenterfacade.models.bo.ActivityRedPacketBO;
import com.bizvane.mktcenterfacade.models.bo.MktActivityRedPacketRecordBO;
import com.bizvane.mktcenterfacade.models.po.MktActivityRedPacketRecordPO;
import com.bizvane.mktcenterfacade.models.vo.ActivityRedPacketVO;
import com.bizvane.mktcenterfacade.models.vo.RedPacketSocketVO;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2019/1/16 15:13
 */
@RestController
@RequestMapping("activityRedPacketRpc")
public class ActivityRedPacketRpcController {
    @Autowired
    private ActivityRedPacketService activityRedPacketService;

    @RequestMapping("selectActivityRedPacketDetail")
    public ResponseData<ActivityRedPacketBO> selectActivityRedPacketDetail(@RequestBody ActivityRedPacketVO vo) {
        return activityRedPacketService.selectActivityRedPacketDetail(vo);
    }
    @RequestMapping("doIfActivityRedPacket")
    public ResponseData<Integer> doIfActivityRedPacket(@RequestBody ActivityRedPacketVO vo) {
        return activityRedPacketService.doIfActivityRedPacket(vo);
    }
    @RequestMapping("andActivityRedPacketCreateRecord")
    public void andActivityRedPacketCreateRecord(@RequestBody ActivityRedPacketVO vo) {
        activityRedPacketService.andActivityRedPacketCreateRecord(vo);
    }
    @RequestMapping("andActivityRedPacketZhuliRecord")
    public ResponseData<Integer> andActivityRedPacketZhuliRecord(@RequestBody ActivityRedPacketVO vo) throws IOException {
       return activityRedPacketService.andActivityRedPacketZhuliRecord(vo);
    }
    @RequestMapping("andActivityRedPacketSendCouponRecord")
    public ResponseData<Integer> andActivityRedPacketSendCouponRecord(@RequestBody ActivityRedPacketVO vo) {
        return activityRedPacketService.andActivityRedPacketSendCouponRecord(vo);
    }

    @RequestMapping("getRedPacketZhuLiRecord")
    public ResponseData<List<MktActivityRedPacketRecordPO>> getRedPacketZhuLiRecord(@RequestBody ActivityRedPacketVO vo) {
        return activityRedPacketService.getRedPacketZhuLiRecord(vo);
    }
    @RequestMapping("getRedPacketZhuLiRecordByAPP")
    public ResponseData<RedPacketSocketVO>  getRedPacketZhuLiRecordByAPP(@RequestBody ActivityRedPacketVO vo){
        return activityRedPacketService.getRedPacketZhuLiRecordByAPP(vo);
    }
    @RequestMapping("getRedPacketCoponAppRecord")
    public ResponseData<List<MktActivityRedPacketRecordBO>> getRedPacketCoponAppRecord(@RequestBody ActivityRedPacketVO vo) {
        return activityRedPacketService.getRedPacketCoponAppRecord(vo);
    }

}
