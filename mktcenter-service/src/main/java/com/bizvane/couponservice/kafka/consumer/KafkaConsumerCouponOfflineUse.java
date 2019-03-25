//package com.bizvane.couponservice.kafka.consumer;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.bizvane.centerstageservice.rpc.CompanyServiceRpc;
//import com.bizvane.centerstageservice.rpc.StoreServiceRpc;
//import com.bizvane.couponfacade.enums.SendTypeEnum;
//import com.bizvane.couponfacade.models.po.CouponEntityPO;
//import com.bizvane.couponfacade.models.po.CouponEntityPOExample;
//import com.bizvane.couponfacade.models.vo.CouponOfflineUseResponseVO;
//import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
//import com.bizvane.couponservice.common.constants.SysResponseEnum;
//import com.bizvane.couponservice.common.constants.SystemConstants;
//import com.bizvane.couponservice.mappers.CouponEntityPOMapper;
//import com.bizvane.couponservice.service.CouponManualService;
//import com.bizvane.couponservice.service.SendCouponService;
//import com.bizvane.members.facade.service.api.WxChannelInfoApiService;
//import com.bizvane.members.facade.vo.WxChannelAndMemberVo;
//import com.bizvane.members.facade.vo.WxChannelInfoVo;
//import com.bizvane.messagefacade.interfaces.WechatCouponServiceFeign;
//import com.bizvane.messagefacade.models.vo.CouponMessageVO;
//import com.bizvane.utils.responseinfo.ResponseData;
//import com.bizvane.wechatfacade.interfaces.WxPublicServiceFeign;
//import com.bizvane.wechatfacade.models.po.WxPublicPO;
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.math.BigDecimal;
//import java.text.SimpleDateFormat;
//import java.util.List;
//
///**
// * 增量topic
// */
//
//@Service("KAFKA_TOPIC_COUPON_OFFLINE_USE")
//public class KafkaConsumerCouponOfflineUse implements KafkaConsumerService{
//
//    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerCouponOfflineUse.class);
//
//    @Autowired
//    private CouponEntityPOMapper couponEntityPOMapper;
//
//    @Autowired
//    private CouponManualService couponManualService;
//
//    @Autowired
//    private StoreServiceRpc storeServiceRpc;
//
//    @Autowired
//    private CompanyServiceRpc companyServiceRpc;
//
//    @Autowired
//    private WxChannelInfoApiService wxChannelInfoApiService;
//
//    @Autowired
//    private WechatCouponServiceFeign wechatCouponServiceFeign;
//
//    @Autowired
//    private  WxPublicServiceFeign wxPublicServiceFeign;
//
//    @Autowired
//    private SendCouponService sendCouponService;
//
//    @Async
//    @Override
//    public void consumer(String topic, String key,@RequestParam("value") String value) {
//
//        logger.info("enter KafkaConsumerAllCouponOfflineUse consumer method! value:{}",value);
//
//        if(StringUtils.isBlank(value)){
//            logger.info(SysResponseEnum.SYSTEM_DATA_NOT_EMPTY.getMessage());
//            return;
//        }
//
////          TODO
//        JSONObject jsonObject = JSON.parseObject(value);
//        CouponOfflineUseResponseVO offlineVO = JSONObject.toJavaObject(jsonObject,CouponOfflineUseResponseVO.class);
//
//        if(StringUtils.isBlank(offlineVO.getCouponCode())){
//            logger.info("enter KafkaConsumerAllCouponOfflineUse consumer method ! CouponCode is null!"+JSONObject.toJSONString(offlineVO));
//            return;
//        }
//        if(StringUtils.isBlank(offlineVO.getCompanyCode())){
//            logger.info("enter KafkaConsumerAllCouponOfflineUse consumer method ! getCompanyCode is null!"+JSONObject.toJSONString(offlineVO));
//            return;
//        }
//
//
//        //获取企业id
//        Long findCompanyId = findCompanyId(offlineVO.getCompanyCode());
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        CouponEntityPOExample entityExample = new CouponEntityPOExample();
//        entityExample.createCriteria().andCouponCodeEqualTo(offlineVO.getCouponCode())
//                .andSysCompanyIdEqualTo(findCompanyId);
//
//
//        //查询券
//        List<CouponEntityPO> entityPOList = couponEntityPOMapper.selectByExample(entityExample);
//
//        if(CollectionUtils.isEmpty(entityPOList)){
//            logger.info("enter KafkaConsumerAllCouponOfflineUse consumer method ! CouponEntityPO is null!"+JSONObject.toJSONString(entityPOList));
//            return;
//        }
//
//        CouponEntityPO entityPO = entityPOList.get(0);
//
//        //是否已被核销
//        if(entityPO.getCouponStatus().equals(SystemConstants.COUPON_STATUS_USED)){
//            logger.info("Coupon is used"+JSONObject.toJSONString(entityPO));
//            return;
//        }
//
//
//        //获取店铺id
//        if(StringUtils.isNotBlank(offlineVO.getUseStoreCode())){
//            ResponseData<Long> storeCodeResult = storeServiceRpc.getStoreOfflineIdByCode(offlineVO.getUseStoreCode());
//            entityPO.setUseStoreId(storeCodeResult.getData());
//        }
//
//        entityPO.setUseBusinessCode(offlineVO.getUseBusinessCode());
//        entityPO.setUseBusinessAmount(offlineVO.getUseBusinessAmount());
//
//        try {
//            if(offlineVO.getUseTime() != null) {
//                entityPO.setUseTime(dateFormat.parse(offlineVO.getUseTime()));
//            }
//        }catch(Exception e){
//            logger.info(SysResponseEnum.DATE_TRANSFER_EXCEPTION.getMessage());
//        }
//
//        entityPO.setCouponStatus(SystemConstants.COUPON_STATUS_USED);
//        entityPO.setIsUse(SystemConstants.COUPON_DEFINITION_STATUS_USE);
//        entityPO.setUseFrom((byte) 4);
//
//        couponEntityPOMapper.updateByExampleSelective(entityPO,entityExample);
//
//
//        //券核销发送微信/短信消息
//        ResponseData<String> responseData = sendMessage(entityPO);
//
//        logger.info("enter KafkaConsumerAllCouponOfflineUse consumer method sendMessage! param:responseData:{}",JSONObject.toJSONString(responseData));
//
//        //手动发券，更新核销数量，券收益，优惠金额
//        if(entityPO.getSendType().equals(SendTypeEnum.SEND_COUPON_BATCH.getCode())){
//
//            logger.info("enter KafkaConsumerAllCouponOfflineUse consumer method sendMessage!");
//            BigDecimal useBusinessAmount = null;
//            if(null != offlineVO.getUseBusinessAmount()){
//                useBusinessAmount = offlineVO.getUseBusinessAmount();
//            }
//
//            couponManualService.updateCouponManualCount(entityPO.getUseStoreId(),entityPO.getSendBusinessId(),useBusinessAmount,offlineVO.getDiscountMoney());
//
//        }
//
//        logger.info("enter semd getTransferSend",entityPO.getCouponCode()+JSONObject.toJSONString(entityPO));
//        // 如果是转增有奖奖券
//        if(entityPO.getTransferSend()!=null||entityPO.getTransferSend()) {
//        	SendCouponSimpleRequestVO sendVO=new SendCouponSimpleRequestVO();
//            sendVO.setMemberCode(entityPO.getTransferMemberCode());
//            sendVO.setCouponDefinitionId(entityPO.getTransferCouponDefinitionId());
//            sendVO.setSendType(entityPO.getSendType());
//            sendVO.setSendBussienId(entityPO.getSendBusinessId());
//            sendVO.setBusinessName(entityPO.getBusinessName());
//            sendVO.setBrandId(entityPO.getSysBrandId());
//            sendVO.setCompanyId(entityPO.getSysCompanyId());
//            sendVO.setBrandCode(entityPO.getBrandCode());
//        	sendCouponService.simple(sendVO);
//        }
//
//
//    }
//
//
//
//    /**
//     * 查找品牌
//     * @param companyCode
//     * @return
//     */
//    public Long findCompanyId(String companyCode){
//
//        ResponseData<Long> companyResult = companyServiceRpc.getIdByCode(companyCode);
//
//        return companyResult.getData();
//
//    }
//
//
//    /**
//     * 券核销发送微信/短信消息
//     * @return
//     */
//    public ResponseData<String> sendMessage(CouponEntityPO couponEntityPO){
//
//        ResponseData<String> responseData = new ResponseData();
//
//        //查询会员信息
////        WxChannelInfoVo channelVO = new WxChannelInfoVo();
////        channelVO.setMemberCode(couponEntityPO.getMemberCode());
////        ResponseData<WxChannelInfoVo> channelResult = wxChannelInfoApiService.getWxChannelInfo(channelVO);
//
//
//        //查询会员信息 新接口
//        WxChannelInfoVo channelVO = new WxChannelInfoVo();
//        channelVO.setMemberCode(couponEntityPO.getMemberCode());
//        channelVO.setBrandId(couponEntityPO.getSysBrandId());
//        channelVO.setMiniProgram(1);
//        ResponseData<WxChannelAndMemberVo> channelResult = wxChannelInfoApiService.getWxChannelInfoAndMemberInfo(channelVO);
//        WxChannelInfoVo channelInfoVo = null;
//
//        if (channelResult.getData() != null) {
//            channelInfoVo = channelResult.getData().getWxChannelInfoVo();
//
//        }
//
//        if(null == channelInfoVo){
//            responseData.setCode(SysResponseEnum.FAILED.getCode());
//            responseData.setMessage(SysResponseEnum.WECHAT_CHANNEL_NOT_EXISTS.getMessage());
//            return responseData;
//        }
//
//        //线上发送核销模板消息
//        CouponMessageVO messageVO = new CouponMessageVO();
//
//        messageVO.setMemberCode(couponEntityPO.getMemberCode());
//        messageVO.setCouponCode(couponEntityPO.getCouponCode());
//        messageVO.setCouponName(couponEntityPO.getCouponName());
//        messageVO.setPreferentialType(couponEntityPO.getPreferentialType()+"");
//        messageVO.setDenomination(couponEntityPO.getMoney()+"");
//        messageVO.setUseTime(couponEntityPO.getUseTime());
//        messageVO.setValidDateStart(couponEntityPO.getValidDateStart());
//        messageVO.setValidDateEnd(couponEntityPO.getValidDateEnd());
//        messageVO.setMemberName(channelInfoVo.getName());
//        messageVO.setOrderNo(couponEntityPO.getUseBusinessCode());
//        messageVO.setSysBrandId(couponEntityPO.getSysBrandId());
//        messageVO.setMemberPhone(channelInfoVo.getPhone());
//        messageVO.setNickName(channelInfoVo.getWxNick());
//        messageVO.setSendWxmember(channelInfoVo.getFocus()+"");
//        messageVO.setSysCompanyId(channelInfoVo.getSysCompanyId());
//
//        ResponseData<WxPublicPO> publicPO = wxPublicServiceFeign.getWxPublicBySysBrandId(couponEntityPO.getSysBrandId());
//        if(publicPO.getData() != null){
//            messageVO.setNickName(publicPO.getData().getNickName());
//        }
//
//
//        ResponseData<String> onlineResult = wechatCouponServiceFeign.couponUse(messageVO);
//
//        return onlineResult;
//
//    }
//
//}
