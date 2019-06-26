package com.bizvane.messageservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.messagefacade.models.po.MsgSmsTempPO;
import com.bizvane.messagefacade.models.po.MsgSmsTempPOExample;
import com.bizvane.messagefacade.models.po.SysSmsConfigPO;
import com.bizvane.messagefacade.models.po.SysSmsConfigPOExample;
import com.bizvane.messagefacade.models.vo.Result;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.messageservice.common.constants.SysRespConstants;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.mappers.MsgSmsTempPOMapper;
import com.bizvane.messageservice.mappers.SysSmsConfigPOMapper;
import com.bizvane.messageservice.service.SendCommonMessageService;
import com.bizvane.messageservice.service.SendMessageDoingService;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chen.li
 * @date on 2019/6/26 19:07
 * @description
 */
@Slf4j
@Service
public class sendMessageDoingServiceImpl implements SendMessageDoingService {

    @Resource
    private MsgSmsTempPOMapper msgSmsTempPOMapper;

    @Resource
    private SysSmsConfigPOMapper sysSmsConfigPOMapper;

    @Resource
    private SendCommonMessageService sendCommonMessageService;

    @Override
    public Result<String> sendMessageDoing(JSONObject jsonObject) {
        {
            Result<String> result = new Result<>();
            String memberName = jsonObject.getString("memberName");
            if (StringUtils.isBlank(memberName)) {
                jsonObject.fluentPut("memberName","");
            }
            String denomination = jsonObject.getString("denomination");
            if (StringUtils.isBlank(denomination)) {
                jsonObject.fluentPut("denomination","");
            }
            String couponName = jsonObject.getString("couponName");
            if (StringUtils.isBlank(couponName)) {
                jsonObject.fluentPut("couponName","");
            }
            String couponCode = jsonObject.getString("couponCode");
            if (StringUtils.isBlank(couponCode)) {
                jsonObject.fluentPut("couponCode","");
            }
            //如果是使用就
            if(jsonObject.getString("bussinessType").equals(SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_SEDNSMS_COUPON_ONLINE_MESSAGE)) {
                String orderNo = jsonObject.getString("orderNo");
                if (StringUtils.isBlank(orderNo)) {
                    jsonObject.fluentPut("orderNo","");
                }
            }
            String nickName = jsonObject.getString("nickName");
            if (StringUtils.isBlank(nickName)) {
                jsonObject.fluentPut("nickName","");
            }

            String memberPhone = jsonObject.getString("memberPhone");
            if (StringUtils.isBlank(memberPhone)) {
                log.error(this.getClass().getName()+".sendMessage.memberPhone:手机号不能为空");
                result.setStatus(SysRespConstants.MEMBERPHONE_MODEL_CODE_NOT_EMPTY.getStatus());
                result.setMsg(SysRespConstants.MEMBERPHONE_MODEL_CODE_NOT_EMPTY.getMsg());
                return result;
            }

            Long sysBrandId = jsonObject.getLong("sysBrandId");
            if (sysBrandId==null) {
                log.error(this.getClass().getName()+".sendMessage.sysBrandId:品牌id内容不能为空");
                result.setStatus(SysRespConstants.SYSBRANDID_MODEL_CODE_NOT_EMPTY.getStatus());
                result.setMsg(SysRespConstants.SYSBRANDID_MODEL_CODE_NOT_EMPTY.getMsg());
                return result;
            }
            //找到短信模板信息
            MsgSmsTempPOExample msgSmsTempPOExample = new MsgSmsTempPOExample();
            msgSmsTempPOExample.createCriteria().andSysBrandIdEqualTo(sysBrandId).andTemplateTypeEqualTo(jsonObject.getString("bussinessModuleCode").replace("SMS_","")).andValidEqualTo(Boolean.TRUE);
            List<MsgSmsTempPO> smsTempPOList= msgSmsTempPOMapper.selectByExample(msgSmsTempPOExample);
            if(null == smsTempPOList || smsTempPOList.size()==0){
                result.setStatus(SysRespConstants.SMS_MESSAGETEMP_NOT_EXISTS.getStatus());
                result.setMsg(SysRespConstants.SMS_MESSAGETEMP_NOT_EXISTS.getMsg());
                return result;
            }

            //  校验是否发送短信  是否开启 短信配置开关 0.关闭1.开启
            MsgSmsTempPO smsTempPO= smsTempPOList.get(0);
            if(smsTempPO.getStatus()==false){
                log.error("该会员发送短信未开启！");
                result.setStatus(SysRespConstants.SMS_MESSAGETEMP_OFF.getStatus());
                result.setMsg(SysRespConstants.SMS_MESSAGETEMP_OFF.getMsg());
                return result;
            }

            //判断短信是否发送微信会员  0.全部发送 1.向微信会员发送短信2.向非微信会员发送短信
            //如果模板只向微信会员发送

//        	是微信会员
            if("2".equals(jsonObject.getString("sendWxmember"))) {
//        		设置不是微信会员发送就放回
                if(smsTempPO.getSendWxmember()==1) {
                    log.error("该模板设置不向微信会员发短信");
                    result.setStatus(SysRespConstants.SMS_CONFIG_MESSAGETEMP_WX_OFF.getStatus());
                    result.setMsg(SysRespConstants.SMS_CONFIG_MESSAGETEMP_WX_OFF.getMsg());
                    return result;
                }
            }

            //获取短信通道 sysBrandId
            SysSmsConfigPOExample sysSmsConfigPOExample = new SysSmsConfigPOExample();
            sysSmsConfigPOExample.createCriteria().andSysBrandIdEqualTo(sysBrandId).andChannelTypeEqualTo(10).andValidEqualTo(Boolean.TRUE);
            List<SysSmsConfigPO> sysSmsConfigList= sysSmsConfigPOMapper.selectByExample(sysSmsConfigPOExample);

            //获取短信通道信息
            ResponseData<Integer> sendResults = new ResponseData<Integer>(SysResponseEnum.FAILED.getCode(),SysResponseEnum.FAILED.getMessage(),null);
            if(null == sysSmsConfigList || sysSmsConfigList.size()>0){
                ObjectMapper mapper = new ObjectMapper();
                SysSmsConfigVO syssmsconfigvo = mapper.convertValue(sysSmsConfigList.get(0), SysSmsConfigVO.class);

                String msgContent = smsTempPO.getContent().replace("@[会员姓名]",jsonObject.getString("memberName"))
                        .replace("@[优惠券名称]", jsonObject.getString("couponName"))
                        .replace("@[券号]", jsonObject.getString("couponCode"))
                        .replace("@[公众号]", jsonObject.getString("nickName"));

                if(SystemConstants.PREFERENTIAL_TYPE_MONEY.equals(jsonObject.getString("preferentialType"))){
                    msgContent = msgContent.replace("@[优惠券折扣/金额]", jsonObject.getString("denomination")+"元");
                }else if(SystemConstants.PREFERENTIAL_TYPE_DISCOUNT.equals(jsonObject.getString("preferentialType"))){
                    msgContent = msgContent.replace("@[优惠券折扣/金额]", jsonObject.getString("denomination")+"折");
                }else{
                    msgContent = msgContent.replace("@[优惠券折扣/金额]","");
                }

                //处理短信内容
                syssmsconfigvo.setMsgContent(msgContent);

                //手机号码
                syssmsconfigvo.setPhone(jsonObject.getString("memberPhone"));
                result.setData(syssmsconfigvo.getMsgContent());
                //发送短信
                sendResults =  sendCommonMessageService.sendSmg(syssmsconfigvo);

                if (SysResponseEnum.SUCCESS.getCode() == sendResults.getCode()) {
                    result.setStatus(SysRespConstants.SUCCESS.getStatus());
                    result.setMsg(sendResults.getMessage());
                } else {
                    result.setStatus(SysRespConstants.FAILED.getStatus());
                    result.setMsg("发送异常"+sendResults.getMessage());
                }
            }else {
                result.setStatus(SysRespConstants.SMS_CONFIG_MESSAGETEMP_NOT_EXISTS.getStatus());
                result.setMsg(SysRespConstants.SMS_CONFIG_MESSAGETEMP_NOT_EXISTS.getMsg());
                return result;
            }
            return result;
        }
    }
}
