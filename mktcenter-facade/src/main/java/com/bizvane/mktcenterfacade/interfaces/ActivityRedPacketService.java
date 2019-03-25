package com.bizvane.mktcenterfacade.interfaces;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.mktcenterfacade.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterfacade.models.vo.ActivityPriceParamVO;
import com.bizvane.mktcenterfacade.models.bo.ActivityRedPacketBO;
import com.bizvane.mktcenterfacade.models.bo.ActivityRedPacketListBO;
import com.bizvane.mktcenterfacade.models.bo.MktActivityRedPacketRecordBO;
import com.bizvane.mktcenterfacade.models.po.MktActivityRedPacketRecordPO;
import com.bizvane.mktcenterfacade.models.vo.ActivityRedPacketVO;
import com.bizvane.mktcenterfacade.models.vo.RedPacketSocketVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2019/1/11 13:54
 */
public interface ActivityRedPacketService {
    public ResponseData<JSONObject> addActivityRedPacket(ActivityRedPacketBO bo, HttpServletRequest request) throws ParseException;
    public ResponseData<ActivityRedPacketBO> selectActivityRedPacket(ActivityRedPacketVO vo);
    public ResponseData<PageInfo<MktActivityPOWithBLOBs>>  selectActivityRedPacketList(ActivityPriceParamVO vo, HttpServletRequest request);
    public ResponseData<ActivityRedPacketBO> selectActivityRedPacketDetail(ActivityRedPacketVO vo);
    public ResponseData<Integer> doIfActivityRedPacket(ActivityRedPacketVO vo);
    public ResponseData<PageInfo<ActivityRedPacketListBO>> selectActivityRedPacketAnalyzeLists(ActivityRedPacketVO vo, HttpServletRequest request);
    public ResponseData<PageInfo<MktActivityRedPacketRecordBO>> getRedPacketCoponRecord(ActivityRedPacketVO vo, HttpServletRequest request);
    public ResponseData<List<MktActivityRedPacketRecordPO>> getRedPacketZhuLiRecord(ActivityRedPacketVO vo);
    public void andActivityRedPacketCreateRecord(ActivityRedPacketVO vo);
    public ResponseData<Integer> andActivityRedPacketZhuliRecord(ActivityRedPacketVO vo) throws IOException;
    public ResponseData<Integer> andActivityRedPacketSendCouponRecord(ActivityRedPacketVO vo);
    public ResponseData<List<MktActivityRedPacketRecordBO>> getRedPacketCoponAppRecord(ActivityRedPacketVO vo);
    public ResponseData<Integer> stopActivityRedPacket(MktActivityPOWithBLOBs po, HttpServletRequest request);
    public ResponseData<RedPacketSocketVO> getRedPacketZhuLiRecordByAPP(ActivityRedPacketVO vo);
}
