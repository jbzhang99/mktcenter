package com.bizvane.messageservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.messageservice.common.constants.SysResponseEnum;
import com.bizvane.messageservice.common.redis.RedisManager;
import com.bizvane.messageservice.mappers.MsgSendTimePOMapper;
import com.bizvane.messageservice.service.MsgSendTimeService;
import com.bizvane.messagefacade.models.po.MsgSendTimePO;
import com.bizvane.messagefacade.models.po.MsgSendTimePOExample;
import com.bizvane.utils.redisutils.RedisClient;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Geng on 2018/8/20.
 */
@Service
public class MsgSendTimeServiceImpl implements MsgSendTimeService {


    @Autowired
    private MsgSendTimePOMapper msgSendTimePOMapper;

    /**
     * 持久化消息防骚扰设置入数据库
     * @param sendTimeStart
     * @param sendTimeEnd
     * @param stageUser
     * @return
     */
    @Transactional
    @Override
    public ResponseData saveSendTime(Date sendTimeStart, Date sendTimeEnd, SysAccountPO stageUser) {

        ResponseData responseData = new ResponseData();
        if (sendTimeStart==null){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("请输入短信发送开始时间");
            return responseData;
        }
        if (sendTimeEnd==null){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("请输入短信发送结束时间");
            return responseData;

        }
        if (sendTimeEnd.before(sendTimeStart)){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("结束发送时间不可早于开始发送时间");
            return responseData;
        }
        //先假删再新增
        //根据brandid更新出该品牌所设时间

        MsgSendTimePOExample msgSendTimePOExample = new MsgSendTimePOExample();
        msgSendTimePOExample.createCriteria().andValidEqualTo(true).andSysBrandIdEqualTo(stageUser.getBrandId());
        MsgSendTimePO record = new MsgSendTimePO();
        record.setModifiedDate(new Date());
        record.setModifiedUserId(stageUser.getSysAccountId());
        record.setCreateUserName(stageUser.getModifiedUserName());
        record.setValid(false);

        msgSendTimePOMapper.updateByExampleSelective(record,msgSendTimePOExample);
        //新增
        MsgSendTimePO msgSendTimePO = new MsgSendTimePO();
        msgSendTimePO.setSendTimeStart(sendTimeStart);
        msgSendTimePO.setSendTimeEnd(sendTimeEnd);
        msgSendTimePO.setCreateDate(new Date());
        msgSendTimePO.setCreateUserId(stageUser.getSysAccountId());
        msgSendTimePO.setCreateUserName(stageUser.getCreateUserName());
        msgSendTimePO.setSysBrandId(stageUser.getBrandId());
        msgSendTimePO.setValid(true);

        msgSendTimePOMapper.insert(msgSendTimePO);
        
        //保全成功，把时间更新到缓存
        RedisClient redisClient = RedisManager.getInstince();
        redisClient.set("send_message_sysBrandId:"+stageUser.getBrandId(), JSONObject.parseObject(JSONObject.toJSONString(msgSendTimePO)));

        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        return responseData;
    }

    /**
     * 查询防骚扰设置
     * @param sysBrandId
     * @return
     */

    @Transactional
    @Override
    public ResponseData getSendTime(Long sysBrandId) {
        ResponseData responseData = new ResponseData();
        if (sysBrandId==null){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("请输入品牌id");
            return responseData;
        }

        //查询出该品牌设置

        MsgSendTimePOExample msgSendTimePOExample  =  new MsgSendTimePOExample();
        msgSendTimePOExample.createCriteria().andSysBrandIdEqualTo(sysBrandId).andValidEqualTo(true);
        List<MsgSendTimePO> msgSendTimePOS  = msgSendTimePOMapper.selectByExample(msgSendTimePOExample);
        MsgSendTimePO msgSendTimePO =null;
        
        if(msgSendTimePOS!=null&msgSendTimePOS.size()>0) {
				   msgSendTimePO = msgSendTimePOS.get(0);
			  }
      

        responseData.setData(msgSendTimePO);

        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        return responseData;
    }
}
