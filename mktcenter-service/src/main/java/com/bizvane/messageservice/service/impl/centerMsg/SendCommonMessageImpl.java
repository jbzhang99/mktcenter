package com.bizvane.messageservice.service.impl.centerMsg;

import com.alibaba.fastjson.JSON;
import com.bizvane.messageservice.common.network.NetWorkCommon;
import com.bizvane.messageservice.mappers.MsgSmsPhonePOMapper;
import com.bizvane.messageservice.mongo.MsgMongoRepository;
import com.bizvane.messagefacade.models.po.MsgSmsPhonePO;
import com.bizvane.messagefacade.models.po.MsgSmsPhonePOExample;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.messageservice.service.SendCommonMessageService;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * 发送短信,需要传送短信短通道数据和手机号,信息内容
 * @Author: lijunwei
 * @Time: 2018/7/10 19:05
 * 以  平台类型  来区分
 */
@Service
public class SendCommonMessageImpl implements SendCommonMessageService {
    @Autowired
    private NetWorkCommon netWorkCommon;

    @SuppressWarnings("rawtypes")
    @Autowired
    private MsgMongoRepository mongoTemplateService;

    @Autowired
    private  MsgSmsPhonePOMapper msgSmsPhonePOMapper;

    @SuppressWarnings({ "unchecked", "finally" })
    @Override
    public ResponseData<Integer> sendSmg(@RequestBody SysSmsConfigVO vo) {
        ResponseData<Integer> result = new ResponseData<Integer>(SysResponseEnum.FAILED.getCode(),SysResponseEnum.FAILED.getMessage(),null);
        if(StringUtils.isBlank(vo.getChannelName())){
            vo.setChannelType(20);
            vo.setChannelName("chuangLan253");
            vo.setChannelService("http://smssh1.253.com/msg/send/json");
            vo.setChannelAccount("N4646531");
            vo.setChannelPassword("ka2fUAZox");
        }
        String channelName = vo.getChannelName();//通道名称
        Boolean  resultData=Boolean.FALSE;
        try {

            //黑白名单过滤
            result=sendSmgPhone( vo);
            if(SysResponseEnum.FAILED.getCode() == result.getCode()) {
                return  result;
            }

            if ("moments3.4".equals(channelName)){   //梦网3.4  moments  梦网3.4  MOMENTS   梦网3.4  rec   梦网3.4 newest  梦网3.4   MOMENTS    梦网3.4
                resultData = netWorkCommon.sendMsgMoments(vo);
                if (resultData){
                    result.setCode(SysResponseEnum.SUCCESS.getCode());
                    result.setMessage(SysResponseEnum.SUCCESS.getMessage());
                }

            }else if ("chuangLan253".equals(channelName)){   //创蓝253短信
                String  resultstr = netWorkCommon.sendChuangLan253(vo);

                if (resultstr.equals("true")){
                    resultData=Boolean.TRUE;
                    result.setCode(SysResponseEnum.SUCCESS.getCode());
                    result.setMessage(SysResponseEnum.SUCCESS.getMessage());
                }else {
                    result.setCode(SysResponseEnum.FAILED.getCode());
                    result.setMessage(resultstr);
                }

            }

        }catch (Exception e){
            System.out.println("------短信发送异常-----"+ JSON.toJSONString(channelName));
            e.printStackTrace();
        }finally {
            //mogo的插入
            vo.setStatus(resultData);
            vo.setCreateDate(new Date());
            vo.setCountryCode(result.getMessage());
            mongoTemplateService.singleSave(vo);
            return  result;
        }


    }

    public ResponseData<Integer> sendSmgPhone(SysSmsConfigVO vo) {
        ResponseData<Integer> result = new ResponseData<Integer>(SysResponseEnum.SUCCESS.getCode(),SysResponseEnum.SUCCESS.getMessage(),null);
        MsgSmsPhonePOExample sysSmsConfigPOExample = new MsgSmsPhonePOExample();
        sysSmsConfigPOExample.createCriteria().andPhoneEqualTo(vo.getPhone()).andValidEqualTo(Boolean.TRUE);
        List<MsgSmsPhonePO>  msgSmsPhonePOS= msgSmsPhonePOMapper.selectByExample(sysSmsConfigPOExample);

        //检查没有在白名单
        if(CollectionUtils.isNotEmpty(msgSmsPhonePOS)&& !msgSmsPhonePOS.get(0).getTemplateType()){
            return result;
        }
        result.setCode(SysResponseEnum.FAILED.getCode());
        result.setMessage(":该手机号不是白名单，不发送短信！");
        return  result;
    }
}
