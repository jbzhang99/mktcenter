package com.bizvane.messageservice.service.impl.centerMsg;

import com.alibaba.fastjson.JSON;
import com.bizvane.messageservice.common.network.NetWorkBatch;
import com.bizvane.messageservice.mongo.MsgMongoRepository;
import com.bizvane.messagefacade.interfaces.SendBatchMessageFeign;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * @Author: lijunwei
 * @Time: 2018/8/20 10:19
 */
@Service
public class SendBatchMessageImpl implements SendBatchMessageFeign {
private  static  final Logger logger  = LogManager.getLogger(SendBatchMessageImpl.class);
    @Autowired
    private NetWorkBatch netWorkBatch;
    @Autowired
    private MsgMongoRepository mongoTemplateService;


    @SuppressWarnings("finally")
	@Override
    public ResponseData<Integer> sendSmgBatch(SysSmsConfigVO vo) {
        ResponseData<Integer> result = new ResponseData<Integer>(SysResponseEnum.FAILED.getCode(),SysResponseEnum.FAILED.getMessage(),null);
        String channelName = vo.getChannelName();//通道名称
        Boolean  resultData=Boolean.FALSE;
        String phones = vo.getPhones();
        Integer batchNum = vo.getBatchNum();
        if (StringUtils.isBlank(phones)){
            result.setMessage("批量手机号为空");
        }
        int phonenum = phones.split(",").length;//手机号的数量
        if (phonenum>1000){
            result.setMessage("批量手机号超过"+batchNum+",无法发送");
            logger.info("批量手机号超过"+1000+",无法发送"+ JSON.toJSONString(channelName));
        }

        try {
            if ("moments3.4".equals(channelName)){   //梦网3.4  moments  梦网3.4  MOMENTS   梦网3.4  rec   梦网3.4 newest  梦网3.4   MOMENTS    梦网3.4
                resultData = netWorkBatch.sendMsgMomentsBatch(vo);
            }else if ("chuangLan253".equals(channelName)){   //创蓝253短信
            	String resultstr = netWorkBatch.sendChuangLan253Batch(vo);
                
                if (resultstr.equals("ture")){
              	  resultData=Boolean.TRUE;
                    result.setCode(SysResponseEnum.SUCCESS.getCode());
                    result.setMessage(SysResponseEnum.SUCCESS.getMessage());
                }else {
                    result.setCode(SysResponseEnum.FAILED.getCode());
                    result.setMessage(resultstr);
                }
            }
            
            
            
        }catch (Exception e){
            logger.info("------短信发送异常-----"+ JSON.toJSONString(channelName));
            e.printStackTrace();
        }finally {
           //mogo的插入发送消息
            vo.setStatus(resultData);
            vo.setCreateDate(new Date());
            mongoTemplateService.singleSave(vo);
  	      if(resultData){
		      result.setCode(SysResponseEnum.SUCCESS.getCode());
		      result.setMessage(SysResponseEnum.SUCCESS.getMessage());
	       } 
          return  result;
        }


    }
}
