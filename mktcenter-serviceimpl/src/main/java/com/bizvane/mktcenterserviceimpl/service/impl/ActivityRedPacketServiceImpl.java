package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.mktcenterservice.interfaces.ActivityRedPacketService;
import com.bizvane.mktcenterservice.models.bo.ActivityRedPacketBO;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktActivityRedPacketPO;
import com.bizvane.mktcenterservice.models.po.MktActivityRedPacketSumPO;
import com.bizvane.mktcenterserviceimpl.common.job.JobUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityRedPacketPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityRedPacketSumPOMapper;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import com.bizvane.wechatfacade.interfaces.QRCodeServiceFeign;
import com.bizvane.wechatfacade.models.vo.CreateMiniprgmQRCodeRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;

/**
 * @Author: lijunwei
 * @Time: 2019/1/11 13:55
 */
@Slf4j
@Service
public class ActivityRedPacketServiceImpl implements ActivityRedPacketService {
    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Autowired
    private  MktActivityRedPacketPO mktActivityRedPacketPO;
    @Autowired
    private QRCodeServiceFeign qrCodeServiceFeign;
    @Autowired
    private MktActivityRedPacketPOMapper mktActivityRedPacketPOMapper;
    @Autowired
    private MktActivityRedPacketSumPOMapper mktActivityRedPacketSumPOMapper;
    @Autowired
    private JobUtil jobUtil;
    /**
     * 新增
     */
    @Override
    public ResponseData<JSONObject> addActivityRedPacket(ActivityRedPacketBO bo, HttpServletRequest request) throws ParseException {
        ResponseData<JSONObject> responseData = new ResponseData<>();
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        String activeRedPacketCode = CodeUtil.getActiveRedPacketCode();
        Date date = new Date();
        MktActivityPOWithBLOBs activityPO = bo.getActivityPO();
        Date startTime = activityPO.getStartTime();
        Boolean runStatus = TimeUtils.ifImmediatelyRun(startTime);
        log.info("红包 addActivityPrice status:"+runStatus);
        if (runStatus) {
            activityPO.setActivityStatus(2);
        } else {
            activityPO.setActivityStatus(1);
            jobUtil.addStartRedPacketJob(sysAccountPo, activityPO, activeRedPacketCode);
        }
        jobUtil.addEndStartRedPacketJob(sysAccountPo, activityPO, activeRedPacketCode);

        CreateMiniprgmQRCodeRequestVO createMiniprgmQRCodeRequestVO = new CreateMiniprgmQRCodeRequestVO();
        createMiniprgmQRCodeRequestVO.setSysBrandId(sysAccountPo.getBrandId());
        createMiniprgmQRCodeRequestVO.setMiniProgramType("10");
        createMiniprgmQRCodeRequestVO.setPath("pages/template01/prize-draw/main");
        createMiniprgmQRCodeRequestVO.setScene(activeRedPacketCode);
        log.info("addActivityRedPacket wexin param:" + JSON.toJSONString(createMiniprgmQRCodeRequestVO));
        ResponseData<String> qrCodeResponseData = qrCodeServiceFeign.createMiniprgmQRCode(createMiniprgmQRCodeRequestVO);
        log.info("addActivityRedPacket wexin result:" + JSON.toJSONString(qrCodeResponseData));
        String weixinUrl = qrCodeResponseData.getData();

        activityPO.setQrCodeUrl(weixinUrl);
        activityPO.setActivityCode(activeRedPacketCode);
        activityPO.setActivityType(12);
        activityPO.setSysCompanyId(sysAccountPo.getSysCompanyId());
        activityPO.setSysBrandId(sysAccountPo.getBrandId());
        activityPO.setCreateUserId(sysAccountPo.getSysAccountId());
        activityPO.setCreateUserName(sysAccountPo.getName());
        activityPO.setCreateDate(date);
        mktActivityPOMapper.insertSelective(activityPO);

        MktActivityRedPacketPO activityRedPacketPO = bo.getActivityRedPacketPO();
        activityRedPacketPO.setSysCompanyId(sysAccountPo.getSysCompanyId());
        activityRedPacketPO.setSysBrandId(sysAccountPo.getBrandId());
        activityRedPacketPO.setMktActivityId(activityPO.getMktActivityId());
        activityPO.setSysBrandId(sysAccountPo.getBrandId());
        activityPO.setCreateUserId(sysAccountPo.getSysAccountId());
        activityPO.setCreateUserName(sysAccountPo.getName());
        activityPO.setCreateDate(date);
        mktActivityRedPacketPOMapper.insertSelective(activityRedPacketPO);

        MktActivityRedPacketSumPO redPacketSumPO = new MktActivityRedPacketSumPO();
        redPacketSumPO.setMktActivityId(activityPO.getMktActivityId());
        redPacketSumPO.setSysCompanyId(sysAccountPo.getSysCompanyId());
        redPacketSumPO.setActivityCode(activityPO.getActivityCode());
        redPacketSumPO.setActivityName(activityPO.getActivityName());
        redPacketSumPO.setActivityTime(TimeUtils.getDataNum(activityPO.getStartTime(),activityPO.getEndTime()));
        redPacketSumPO.setSysBrandId(sysAccountPo.getBrandId());
        redPacketSumPO.setCreateUserId(sysAccountPo.getSysAccountId());
        redPacketSumPO.setCreateUserName(sysAccountPo.getName());
        redPacketSumPO.setCreateDate(date);
        mktActivityRedPacketSumPOMapper.insertSelective(redPacketSumPO);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("qrCodeUrl", weixinUrl);
        jsonObject.put("activityCode", activeRedPacketCode);
        jsonObject.put("activityName", activityPO.getActivityName());
        responseData.setData(jsonObject);
        return responseData;
    }



}
