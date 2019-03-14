package com.bizvane.mktcenterfacade.rpc;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.mktcenterfacade.models.bo.ActivityRedPacketBO;
import com.bizvane.mktcenterfacade.models.bo.MktActivityRedPacketRecordBO;
import com.bizvane.mktcenterfacade.models.po.MktActivityRedPacketRecordPO;
import com.bizvane.mktcenterfacade.models.vo.ActivityRedPacketVO;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2019/1/16 15:41
 */
@FeignClient(value = "${feign.client.mktcenter.name}",path = "${feign.client.mktcenter.path}/activityRedPacketRpc")
public interface ActivityRedPacketServiceRpc {
    @RequestMapping("selectActivityRedPacketDetail")
    public ResponseData<ActivityRedPacketBO> selectActivityRedPacketDetail(@RequestBody ActivityRedPacketVO vo);
    @RequestMapping("doIfActivityRedPacket")
    public ResponseData<Integer> doIfActivityRedPacket(@RequestBody ActivityRedPacketVO vo);
    @RequestMapping("andActivityRedPacketCreateRecord")
    public void andActivityRedPacketCreateRecord(@RequestBody ActivityRedPacketVO vo);
    @RequestMapping("andActivityRedPacketZhuliRecord")
    public ResponseData<Integer> andActivityRedPacketZhuliRecord(@RequestBody ActivityRedPacketVO vo);
    @RequestMapping("andActivityRedPacketSendCouponRecord")
    public ResponseData<Integer> andActivityRedPacketSendCouponRecord(@RequestBody ActivityRedPacketVO vo);
    @RequestMapping("getRedPacketZhuLiRecord")
    public ResponseData<List<MktActivityRedPacketRecordPO>> getRedPacketZhuLiRecord(@RequestBody ActivityRedPacketVO vo);
    @RequestMapping("getRedPacketZhuLiRecordByAPP")
    public ResponseData<JSONObject> getRedPacketZhuLiRecordByAPP(@RequestBody ActivityRedPacketVO vo);
    @RequestMapping("getRedPacketCoponAppRecord")
    public ResponseData<List<MktActivityRedPacketRecordBO>> getRedPacketCoponAppRecord(@RequestBody ActivityRedPacketVO vo);


}
