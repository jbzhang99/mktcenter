package com.bizvane.mktcenterserviceimpl.controllers.rpc;

import com.bizvane.mktcenterservice.interfaces.ActivityRedPacketService;
import com.bizvane.mktcenterservice.models.bo.ActivityRedPacketBO;
import com.bizvane.mktcenterservice.models.bo.MktActivityRedPacketRecordBO;
import com.bizvane.mktcenterservice.models.po.MktActivityRedPacketRecordPO;
import com.bizvane.mktcenterservice.models.vo.ActivityRedPacketVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void andActivityRedPacketZhuliRecord(@RequestBody ActivityRedPacketVO vo) {
        activityRedPacketService.andActivityRedPacketZhuliRecord(vo);
    }
    @RequestMapping("andActivityRedPacketSendCouponRecord")
    public ResponseData<Integer> andActivityRedPacketSendCouponRecord(@RequestBody ActivityRedPacketVO vo) {
        return activityRedPacketService.andActivityRedPacketSendCouponRecord(vo);
    }

    @RequestMapping("getRedPacketZhuLiRecord")
    public ResponseData<List<MktActivityRedPacketRecordPO>> getRedPacketZhuLiRecord(@RequestBody ActivityRedPacketVO vo) {
        return activityRedPacketService.getRedPacketZhuLiRecord(vo);
    }

    @RequestMapping("getRedPacketCoponAppRecord")
    public ResponseData<PageInfo<MktActivityRedPacketRecordBO>> getRedPacketCoponAppRecord(ActivityRedPacketVO vo) {
        return activityRedPacketService.getRedPacketCoponAppRecord(vo);
    }

}
