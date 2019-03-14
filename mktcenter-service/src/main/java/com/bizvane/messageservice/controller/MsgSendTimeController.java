package com.bizvane.messageservice.controller;

import com.bizvane.messageservice.service.MsgSendTimeService;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Geng on 2018/8/20.
 */
@RestController
@RequestMapping("/msgSendTime")
public class MsgSendTimeController {

    @Autowired
    private MsgSendTimeService msgSendTimeService;


    @RequestMapping("/saveSendTime")
    public ResponseData saveSendTime(String sendTimeStart, String sendTimeEnd, HttpServletRequest request)throws Exception{
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        //SysAccountPO stageUser = new SysAccountPO();
        //stageUser.setBrandId(1L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date timeStart = simpleDateFormat.parse(sendTimeStart);
        Date timeEnd = simpleDateFormat.parse(sendTimeEnd);
        return msgSendTimeService.saveSendTime(timeStart,timeEnd,stageUser);
    }


    @RequestMapping("/getSendTime")
    public ResponseData getSendTime(Long sysBrandId){
        return msgSendTimeService.getSendTime(sysBrandId);
    }


}
