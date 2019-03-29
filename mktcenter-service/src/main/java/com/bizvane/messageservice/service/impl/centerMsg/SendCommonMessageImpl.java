package com.bizvane.messageservice.service.impl.centerMsg;

import com.alibaba.fastjson.JSON;
import com.bizvane.messageservice.common.network.NetWorkCommon;
import com.bizvane.messageservice.mappers.MsgSmsPhonePOMapper;
import com.bizvane.messageservice.mongo.MsgMongoRepository;
import com.bizvane.messagefacade.interfaces.SendCommonMessageFeign;
import com.bizvane.messagefacade.models.po.MsgSmsPhonePO;
import com.bizvane.messagefacade.models.po.MsgSmsPhonePOExample;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 发送短信,需要传送短信短通道数据和手机号,信息内容
 * @Author: lijunwei
 * @Time: 2018/7/10 19:05
 * 以  平台类型  来区分
 */
@Service
public class SendCommonMessageImpl implements SendCommonMessageFeign {
    @Autowired
    private NetWorkCommon netWorkCommon;
    
    @SuppressWarnings("rawtypes")
  	@Autowired
  	private MsgMongoRepository mongoTemplateService;
    
  	@Autowired
  	private  MsgSmsPhonePOMapper msgSmsPhonePOMapper;
  	
    @Value("${smssend.phonewhite}")
    private String phonewhite;
    @Value("${smssend.phoneblack}")
    private String phoneblack;

@SuppressWarnings({ "unchecked", "finally" })
@Override
    public ResponseData<Integer> sendSmg(SysSmsConfigVO vo) {
        ResponseData<Integer> result = new ResponseData<Integer>(SysResponseEnum.FAILED.getCode(),SysResponseEnum.FAILED.getMessage(),null);
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
	//1黑0白名单过滤
	try {
	MsgSmsPhonePOExample sysSmsConfigPOExample = new MsgSmsPhonePOExample();
    sysSmsConfigPOExample.createCriteria().andPhoneEqualTo(vo.getPhone()).andValidEqualTo(Boolean.TRUE);
    List<MsgSmsPhonePO>  sysSmsConfigList= msgSmsPhonePOMapper.selectByExample(sysSmsConfigPOExample);

    
    
    //检查是否黑名单
	if(phoneblack.equals("true")) {
        for(MsgSmsPhonePO smsTempPO: sysSmsConfigList) {
            if(smsTempPO.getTemplateType()==true){
                result.setCode(SysResponseEnum.FAILED.getCode());
                result.setMessage(":该手机号是黑名单，不发送短信！");
                return result;
            }
        } 
	}
	
    //检查没有在白名单
	if(phonewhite.equals("true")) {
        for(MsgSmsPhonePO smsTempPO: sysSmsConfigList) {
            if(smsTempPO.getTemplateType()==false){
                return result;
            }
        } 
        result.setCode(SysResponseEnum.FAILED.getCode());
        result.setMessage(":该手机号不是白名单，不发送短信！");
	}
    

	} catch (Exception e) {
        result.setCode(SysResponseEnum.FAILED.getCode());
        result.setMessage(":查询黑白名单系统报错！");
	}
	 return  result;
}

	public static void main(String[] args) {
		 ResponseData<Integer> result = new ResponseData<Integer>(SysResponseEnum.FAILED.getCode(),SysResponseEnum.FAILED.getMessage(),null);
		System.out.println(result);
	}





}
