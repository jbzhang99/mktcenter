package com.bizvane.couponservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.couponfacade.enums.CouponManualTaskStatusEnum;
import com.bizvane.couponfacade.enums.SendTypeEnum;
import com.bizvane.couponfacade.models.po.*;
import com.bizvane.couponfacade.models.vo.CouponSendAgainRequestVO;
import com.bizvane.couponfacade.models.vo.CouponSendFailLogVO;
import com.bizvane.couponfacade.models.vo.SendCouponBatchRequestVO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.bizvane.couponfacade.utils.TimeUtils;
import com.bizvane.couponservice.common.constants.SysResponseEnum;
import com.bizvane.couponfacade.constants.CouponConstants;
import com.bizvane.couponservice.common.utils.BarcodeUtil;
import com.bizvane.couponservice.common.utils.BusinessCodeUtil;
import com.bizvane.couponservice.common.utils.CouponJobUtil;
import com.bizvane.couponservice.mappers.*;
import com.bizvane.couponservice.service.CouponManualService;
import com.bizvane.couponservice.service.CouponSendFailLogService;
import com.bizvane.couponservice.service.SendCouponService;
import com.bizvane.members.facade.es.pojo.MembersInfoSearchPojo;
import com.bizvane.members.facade.es.vo.MembersInfoSearchVo;
import com.bizvane.members.facade.service.api.MembersAdvancedSearchApiService;
import com.bizvane.members.facade.service.api.WxChannelInfoApiService;
import com.bizvane.members.facade.vo.MemberInfoVo;
import com.bizvane.members.facade.vo.WxChannelAndMemberVo;
import com.bizvane.members.facade.vo.WxChannelInfoVo;
import com.bizvane.messagefacade.interfaces.WechatCouponServiceFeign;
import com.bizvane.messagefacade.models.vo.CouponMessageVO;
import com.bizvane.messageservice.common.thread.ThreadPool;
import com.github.pagehelper.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.wechatfacade.interfaces.WxPublicServiceFeign;
import com.bizvane.wechatfacade.models.po.WxPublicPO;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class SendCouponServiceImpl implements SendCouponService {
    private static final Logger logger = LoggerFactory.getLogger(SendCouponServiceImpl.class);

    @Autowired
    private CouponDefinitionPOMapper couponDefinitionPOMapper;

    @Autowired
    private CouponEntityPOMapper couponEntityPOMapper;

    @Autowired
    private CouponSendFailLogPOMapper couponSendFailLogPOMapper;

    @Autowired
    private WechatCouponServiceFeign wechatCouponServiceFeign;

    @Autowired
    private CouponBatchSendRecordPOMapper couponBatchSendRecordPOMapper;
    
    @Autowired
    private  CouponBatchSendDetailPOMapper couponBatchSendDetailPOMapper;

    @Autowired
    private CouponJobUtil jobUtil;

    @Autowired
    private CouponSysCodeValuePOMapper sysCodeValuePOMapper;

    @Autowired
    private MembersAdvancedSearchApiService membersAdvancedSearchApiService;
    @Lazy
    @Autowired
    private CouponManualService couponManualService;

    @Autowired
    private CouponManualPOMapper couponManualPOMapper;

    @Autowired
    private WxChannelInfoApiService wxChannelInfoApiService;

    @Autowired
    private CouponSendFailLogService couponSendFailLogService;

    @Autowired
    private WxPublicServiceFeign wxPublicServiceFeign;
    
    @Autowired
    private  CouponDefinitionMoneyPOMapper couponDefinitionMoneyPOMapper;




    /**
     * 单张发券(优惠券入账)
     *
     * @param param
     * @return
     */
    @Override
    public ResponseData<String> simple(SendCouponSimpleRequestVO param) {

        logger.info("enter SendCouponServiceImpl simple method ! SendCouponSimpleRequestVO:{}",JSONObject.toJSONString(param));

        ResponseData<String> responseData = new ResponseData<>();

        if(null == param){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.SYSTEM_DATA_NOT_EMPTY.getMessage());
            return responseData;
        }

        //受赠不能发券
        if(SendTypeEnum.SEND_COUPON_GIVE.getCode().equals(param.getSendType()+"")){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.GIVEN_SEND_COUPON_NOT_ALLOW.getMessage());
            return responseData;
        }

        if (null == param.getCouponDefinitionId()) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_DEFINITION_ID_NOT_NULL.getMessage());
            return responseData;
        }

        //查找券定义
        CouponDefinitionPOWithBLOBs definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(param.getCouponDefinitionId());

        if (definitionPO == null) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_NOT_EXIST.getMessage());
            return responseData;
        }
        
      // 如果是涨红包
		if (StringUtils.isNotEmpty(param.getTaskId())) {
			CouponDefinitionMoneyPOExample example = new CouponDefinitionMoneyPOExample();
			example.createCriteria().andTaskIdEqualTo(param.getTaskId());
			List<CouponDefinitionMoneyPO> selectByExamplelist = couponDefinitionMoneyPOMapper.selectByExample(example);

			if (CollectionUtils.isNotEmpty(selectByExamplelist)) {
				CouponDefinitionMoneyPO couponDefinitionMoneyOld = selectByExamplelist.get(0);
				definitionPO.setMoney(definitionPO.getMoney().add(couponDefinitionMoneyOld.getMoneyAdd()));
			}
		}
        
        

        try {

            //判断是否过期,日期区间存在过期情况
            if(CouponConstants.VALID_TYPE__INTERVAL.equals(definitionPO.getValidType())){

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date endDate = format.parse(format.format(definitionPO.getValidDateEnd()));
                Date today = format.parse(format.format(new Date()));

                //判断券是否过期
                if (endDate.getTime() < today.getTime()) {
                    responseData.setCode(SysResponseEnum.FAILED.getCode());
                    responseData.setMessage(SysResponseEnum.COUPON_EXPIRED.getMessage());
                    return responseData;
                }

            }

        }catch(Exception e){
            logger.info("enter SendCouponServiceImpl simple method Exception:{}",JSONObject.toJSONString(e));
        }


        //新建券实例
        CouponEntityPO entityPO = new CouponEntityPO();

        String couponCode = BusinessCodeUtil.getCouponCode();

        entityPO.setCouponCode(couponCode);
        entityPO.setCouponDefinitionId(definitionPO.getCouponDefinitionId()+"");
        entityPO.setCouponBatchSendRecordId(definitionPO.getCouponDefinitionId());// 批次号大数据取数要求不能是空
        entityPO.setMemberCode(param.getMemberCode());
        entityPO.setCouponName(definitionPO.getCouponName());
        entityPO.setMoney(definitionPO.getMoney());
        entityPO.setDiscount(definitionPO.getDiscount());
        entityPO.setImg(definitionPO.getImg());
        entityPO.setInfo(definitionPO.getInfo());
        
        // 转增有奖字段
        entityPO.setTransferSend(definitionPO.getTransferSend());
        entityPO.setTransferCouponDefinitionId(definitionPO.getTransferCouponDefinitionId());
        entityPO.setTransferInfo(definitionPO.getTransferInfo());
        
        
        entityPO.setBindStatus(CouponConstants.COUPON_BIND_STATUS_UNBIND);

        //计算有效期开始到结束区间
        Calendar calendar = Calendar.getInstance();

        if (definitionPO.getValidType().equals(CouponConstants.VALID_TYPE__SOMEDAY)) {
            calendar.add(Calendar.DATE, definitionPO.getValidDay());
            calendar.set(Calendar.HOUR_OF_DAY,23);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.MILLISECOND, 59);

            entityPO.setValidDateStart(TimeUtils.getNowTime());
            entityPO.setValidDateEnd(calendar.getTime());
        }else{
            entityPO.setValidDateStart(definitionPO.getValidDateStart());

            calendar.setTime(definitionPO.getValidDateEnd());
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.MILLISECOND, 59);

            entityPO.setValidDateEnd(calendar.getTime());
        }

        entityPO.setIsLock(CouponConstants.COUPON_STATUS_CHANGE_IS_UNLOCK);
        entityPO.setSendType(param.getSendType());
        entityPO.setSendBusinessId(param.getSendBussienId());
        entityPO.setRemark(definitionPO.getRemark());
        entityPO.setValid(CouponConstants.TABLE_VALID_EFFECTIVE);
        entityPO.setPreferentialType(definitionPO.getPreferentialType());
        entityPO.setCreateDate(TimeUtils.getNowTime());
        entityPO.setModifiedDate(TimeUtils.getNowTime());
        entityPO.setBrandCode(param.getBrandCode());
        entityPO.setSysBrandId(definitionPO.getSysBrandId());
        entityPO.setSysCompanyId(definitionPO.getSysCompanyId());
        entityPO.setBusinessName(param.getBusinessName());

        Byte couponStatus = null;
        //判断发券渠道
        if (CouponConstants.USE_CHANNEL_ONLINE.equals(definitionPO.getUseChannel())) {
            couponStatus = CouponConstants.COUPON_STATUS_UNUSED;
        } else if (CouponConstants.USE_CHANNEL_OFFLINE.equals(definitionPO.getUseChannel())) {
            couponStatus = CouponConstants.COUPON_STATUS_SYNCHROING;
        } else if (CouponConstants.USE_CHANNEL_ANY.equals(definitionPO.getUseChannel())) {
            couponStatus = CouponConstants.COUPON_STATUS_SYNCHROING;
        } else {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.USE_CHANNEL_NOT_EXISTS.getMessage());
            return responseData;
        }
        entityPO.setCouponStatus(couponStatus);
        couponEntityPOMapper.insertSelective(entityPO);

        //判断渠道
        if (CouponConstants.USE_CHANNEL_ONLINE.equals(definitionPO.getUseChannel())) {

            ResponseData<String> onlineResult = sendCouponOnline(definitionPO, entityPO);


        } else if (CouponConstants.USE_CHANNEL_OFFLINE.equals(definitionPO.getUseChannel())) {

            ResponseData<String> offlineResult = sendCouponOffline(definitionPO, entityPO,CouponConstants.COUPON_SEND_AGAIN_NO);


        } else if (CouponConstants.USE_CHANNEL_ANY.equals(definitionPO.getUseChannel())) {

            ResponseData<String> offlineResult = sendCouponOffline(definitionPO, entityPO,CouponConstants.COUPON_SEND_AGAIN_NO);


        } else {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.USE_CHANNEL_NOT_EXISTS.getMessage());
            return responseData;
        }
        //券code
        responseData.setData(couponCode);
        return responseData;
    }


    private CouponDefinitionMoneyPOExample CouponDefinitionMoneyPOExample() {
		// TODO Auto-generated method stub
		return null;
	}


	/**
     * 单张发券发送短信微信模板消息
     *
     * @param definitionPO
     * @param entityPO
     * @return
     */

    @Async
    @Override
    public ResponseData<String> sendCouponOnline(CouponDefinitionPOWithBLOBs definitionPO, CouponEntityPO entityPO) {
        ResponseData<String> responseData = new ResponseData<>();

        //微信公众号信息
        ResponseData<WxPublicPO> publicPO = wxPublicServiceFeign.getWxPublicBySysBrandId(definitionPO.getSysBrandId());

        CouponMessageVO messageVO = new CouponMessageVO();
        messageVO.setUseTime(entityPO.getCreateDate());
        messageVO.setSysCompanyId(entityPO.getSysCompanyId());
        messageVO.setMemberCode(entityPO.getMemberCode());
        messageVO.setCouponCode(entityPO.getCouponCode());
        messageVO.setCouponName(entityPO.getCouponName());
        messageVO.setPreferentialType(entityPO.getPreferentialType() + "");
        messageVO.setDenomination(entityPO.getMoney() + "");
        messageVO.setValidDateStart(definitionPO.getValidDateStart());
        messageVO.setValidDateEnd(definitionPO.getValidDateEnd());
        messageVO.setSysBrandId(definitionPO.getSysBrandId());
        //填入折扣或金额
        if(definitionPO.getPreferentialType().equals(CouponConstants.PREFERENTIAL_TYPE_MONEY)){
            messageVO.setDenomination(definitionPO.getMoney()+"");
        }else if(definitionPO.getPreferentialType().equals(CouponConstants.PREFERENTIAL_TYPE_DISCOUNT)){
            messageVO.setDenomination(definitionPO.getDiscount()+"");
        }


        
        //查询会员信息
        WxChannelInfoVo channelVO = new WxChannelInfoVo();
        channelVO.setMemberCode(entityPO.getMemberCode());
        channelVO.setBrandId(entityPO.getSysBrandId());
        channelVO.setMiniProgram(1);
        ResponseData<WxChannelAndMemberVo> channelResult = wxChannelInfoApiService.getWxChannelInfoAndMemberInfo(channelVO);
        

        if (channelResult.getData() != null) {
            WxChannelInfoVo channelInfoVo = channelResult.getData().getWxChannelInfoVo();
            messageVO.setMemberName(channelInfoVo.getName());
            messageVO.setMemberPhone(channelInfoVo.getPhone());
            messageVO.setSendWxmember(channelInfoVo.getFocus()+"");
            messageVO.setSysCompanyId(channelInfoVo.getSysCompanyId());
        }
        if(publicPO.getData() != null){
            messageVO.setNickName(publicPO.getData().getNickName());
        }
        logger.info("enter SendCouponServiceImpl couponnoe method"+JSONObject.toJSONString(messageVO)+JSONObject.toJSONString(channelVO)+JSONObject.toJSONString(channelResult.getData().getWxChannelInfoVo()));

        //调取message模块接口
        responseData = wechatCouponServiceFeign.couponReceive(messageVO);

        return responseData;
    }


    /**
     * 线下单张发券
     *
     * @param definitionPO
     * @param entityPO
     * @return
     */
    public ResponseData<String> sendCouponOffline(CouponDefinitionPOWithBLOBs definitionPO, CouponEntityPO entityPO,Integer ifSendAgain) {
        ResponseData<String> responseData = new ResponseData<>();
        //线下券需要有效期开始到结束区间
        if (definitionPO.getValidType().equals(CouponConstants.VALID_TYPE__SOMEDAY)) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, definitionPO.getValidDay());
            definitionPO.setValidDateStart(TimeUtils.getNowTime());
            definitionPO.setValidDateEnd(calendar.getTime());
        }

        //查询会员信息 新接口
        WxChannelInfoVo channelVO = new WxChannelInfoVo();
        channelVO.setMemberCode(entityPO.getMemberCode());
        channelVO.setBrandId(entityPO.getSysBrandId());
        channelVO.setMiniProgram(1);
        ResponseData<WxChannelAndMemberVo> channelResult = wxChannelInfoApiService.getWxChannelInfoAndMemberInfo(channelVO);
        if (channelResult.getData() != null) {
            WxChannelInfoVo channelInfoVo = channelResult.getData().getWxChannelInfoVo();
            
        }
        
        logger.info("enter hhhhhhhhh SendCouponServiceImpl sendCouponOffline:param:{}", JSONObject.toJSONString(channelResult));

        return responseData;
    }



    /**
     * 批量发券
     *
     * @param requestVO
     * @return
     */
    @Override
    public ResponseData<String> batchRpc(SendCouponBatchRequestVO requestVO) {

        logger.info("enter SendCouponServiceImpl batchRpc method");
        ResponseData<String> responseData = new ResponseData<>();

        //受赠不能发券
        if(SendTypeEnum.SEND_COUPON_GIVE.getCode().equals(requestVO.getSendType()+"")){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.GIVEN_SEND_COUPON_NOT_ALLOW.getMessage());
            return responseData;
        }

        if (null == requestVO.getCouponDefinitionId()) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_DEFINITION_ID_NOT_NULL.getMessage());
            return responseData;
        }
        if(null == requestVO.getMemberList()){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.MEMBER_SEND_EMPTY.getMessage());
            return responseData;
        }

        //转换对象
        List<MembersInfoSearchPojo> memberPojo = new ArrayList<>();
        for(MemberInfoVo member : requestVO.getMemberList()){
            MembersInfoSearchPojo pojo = new MembersInfoSearchPojo();

            pojo.setMemberCode(member.getMemberCode());

            memberPojo.add(pojo);
        }
        requestVO.setMemberListManual(memberPojo);

        //查询券定义数据
        CouponDefinitionPOWithBLOBs definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(requestVO.getCouponDefinitionId());

        if (null == definitionPO) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_NOT_EXIST.getMessage());
            return responseData;
        }

        try {

            //判断是否过期,日期区间存在过期情况
            if(CouponConstants.VALID_TYPE__INTERVAL.equals(definitionPO.getValidType())){

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date endDate = format.parse(format.format(definitionPO.getValidDateEnd()));
                Date today = format.parse(format.format(new Date()));

                //判断券是否过期
                if (endDate.getTime() < today.getTime()) {
                    responseData.setCode(SysResponseEnum.FAILED.getCode());
                    responseData.setMessage(SysResponseEnum.COUPON_EXPIRED.getMessage());
                    return responseData;
                }

            }

        }catch(Exception e){
            logger.info("enter SendCouponServiceImpl simple method Exception:{}",JSONObject.toJSONString(e));
        }

        //保存批次记录和券实例记录
        //requestVO.setTotalNumber(requestVO.getMemberList().size());
        CouponBatchSendRecordPO batchPO = saveCouponBatchRecord(definitionPO, requestVO);

        Byte couponStatus = null;
        //判断发券渠道
        if (CouponConstants.USE_CHANNEL_ONLINE.equals(definitionPO.getUseChannel())) {
            couponStatus = CouponConstants.COUPON_STATUS_UNUSED;
        } else if (CouponConstants.USE_CHANNEL_OFFLINE.equals(definitionPO.getUseChannel())) {
            couponStatus = CouponConstants.COUPON_STATUS_SYNCHROING;
        } else if (CouponConstants.USE_CHANNEL_ANY.equals(definitionPO.getUseChannel())) {
            couponStatus = CouponConstants.COUPON_STATUS_UNUSED;
        } else {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.USE_CHANNEL_NOT_EXISTS.getMessage());
            return responseData;
        }
        List<CouponEntityPO> entityPOList = saveEntityList(definitionPO, requestVO, batchPO.getCouponBatchSendRecordId(), couponStatus);

        //立刻发券

        //判断发券渠道
        if (CouponConstants.USE_CHANNEL_ONLINE.equals(definitionPO.getUseChannel())) {

            //线上发券
            ResponseData<String> onlineResult = sendCouponBatchOnline(definitionPO, entityPOList);

            if (SysResponseEnum.SUCCESS.getCode() != onlineResult.getCode()) {
                return onlineResult;
            }

        } else if (CouponConstants.USE_CHANNEL_OFFLINE.equals(definitionPO.getUseChannel())) {

            //线下发券
            ResponseData<String> offlineResult = sendCouponBatchOffline(definitionPO, entityPOList, batchPO);

            if (SysResponseEnum.SUCCESS.getCode() != offlineResult.getCode()) {
                return offlineResult;
            }

        } else if (CouponConstants.USE_CHANNEL_ANY.equals(definitionPO.getUseChannel())) {
        	//
        	
            //全渠道收到线下结果在发短信
//            ResponseData<String> onlineResult = sendCouponBatchOnline(definitionPO, entityPOList);


            //批量更新券状态 - 线下同步
            List<String> couponCodeList = new ArrayList<>();
            for (int i = 0; i < entityPOList.size(); i++) {
                couponCodeList.add(entityPOList.get(i).getCouponCode());
            }
            couponEntityPOMapper.updateCouponStatusBatch(couponCodeList, CouponConstants.COUPON_STATUS_SYNCHROING);
            //线下发券
            ResponseData<String> offlineResult = sendCouponBatchOffline(definitionPO, entityPOList, batchPO);

//            if (SysResponseEnum.SUCCESS.getCode() != onlineResult.getCode()) {
//                responseData.setCode(SysResponseEnum.FAILED.getCode());
//                responseData.setMessage(onlineResult.getMessage());
//                return responseData;
//            }

            if (SysResponseEnum.SUCCESS.getCode() != offlineResult.getCode()) {
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage(offlineResult.getMessage());
                return responseData;
            }

        } else {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.USE_CHANNEL_NOT_EXISTS.getMessage());
            return responseData;
        }

        return responseData;

    }


    /**
     * 保存批量发券记录（券实例）
     *
     * @param requestVO
     * @return
     */
    @Override
    public List<CouponEntityPO> saveEntityList(CouponDefinitionPOWithBLOBs definitionPO, SendCouponBatchRequestVO requestVO,
                                               Long batchId, Byte couponStatus) {
        logger.info("enter SendCouponServiceImpl saveEntityList method");

        List<MembersInfoSearchPojo> memberList = requestVO.getMemberListManual();

        //批量插入券
        List<CouponEntityPO> entityPOList = new ArrayList<>();

        for (int i = 0; i < memberList.size(); i++) {

            String couponCode = BusinessCodeUtil.getCouponCode();

            CouponEntityPO entityPO = new CouponEntityPO();

            entityPO.setCouponCode(couponCode);

            //生成条形码
           // String url = BarcodeUtil.generateBarCode(couponCode);
           // entityPO.setBarcodeUrl(url);

            entityPO.setSysCompanyId(definitionPO.getSysCompanyId());
            entityPO.setSysBrandId(definitionPO.getSysBrandId());
            entityPO.setBrandCode(definitionPO.getBrandCode());
            entityPO.setCouponDefinitionId(definitionPO.getCouponDefinitionId() + "");
            entityPO.setCouponBatchSendRecordId(batchId);

            entityPO.setMemberCode(memberList.get(i).getMemberCode());
            memberList.get(i).getCardNo();

            entityPO.setCouponName(definitionPO.getCouponName());
            entityPO.setMoney(definitionPO.getMoney());
            entityPO.setDiscount(definitionPO.getDiscount());
            entityPO.setImg(definitionPO.getImg());
            entityPO.setInfo(definitionPO.getInfo());
            entityPO.setBindStatus(CouponConstants.COUPON_BIND_STATUS_UNBIND);

            Calendar calendar = Calendar.getInstance();

            //计算有效期开始到结束区间
            if (definitionPO.getValidType().equals(CouponConstants.VALID_TYPE__SOMEDAY)) {
                calendar.add(Calendar.DATE, definitionPO.getValidDay());
                calendar.set(Calendar.HOUR_OF_DAY,23);
                calendar.set(Calendar.SECOND, 59);
                calendar.set(Calendar.MINUTE, 59);
                calendar.set(Calendar.MILLISECOND, 59);

                entityPO.setValidDateStart(TimeUtils.getNowTime());
                entityPO.setValidDateEnd(calendar.getTime());
            }else{
                entityPO.setValidDateStart(definitionPO.getValidDateStart());

                calendar.setTime(definitionPO.getValidDateEnd());
                calendar.set(Calendar.HOUR_OF_DAY, 23);
                calendar.set(Calendar.SECOND, 59);
                calendar.set(Calendar.MINUTE, 59);
                calendar.set(Calendar.MILLISECOND, 59);

                entityPO.setValidDateEnd(calendar.getTime());
            }

            entityPO.setIsLock(CouponConstants.COUPON_STATUS_CHANGE_IS_UNLOCK);
            entityPO.setSendType(requestVO.getBusinessType());
            entityPO.setSendBusinessId(requestVO.getBusinessId());
            entityPO.setIsUse(CouponConstants.COUPON_USE_UNUSED);
            entityPO.setCouponStatus(couponStatus);
            entityPO.setInfo(definitionPO.getInfo());
            entityPO.setValid(CouponConstants.TABLE_VALID_EFFECTIVE);
            entityPO.setPreferentialType(definitionPO.getPreferentialType());
            entityPO.setCreateDate(TimeUtils.getNowTime());
            entityPO.setModifiedDate(TimeUtils.getNowTime());
            entityPO.setCreateUserId(requestVO.getCreateUserId());
            entityPO.setCreateUserName(requestVO.getCreateUserName());
            
            entityPO.setBusinessName(requestVO.getBusinessName());
            //保全二级批次号
            entityPO.setCouponBatchSendRecordId(definitionPO.getBatchSendCodeDetail());
            
            
            // 转增有奖字段
            entityPO.setTransferSend(definitionPO.getTransferSend());
            entityPO.setTransferCouponDefinitionId(definitionPO.getTransferCouponDefinitionId());
            entityPO.setTransferInfo(definitionPO.getTransferInfo());

            entityPOList.add(entityPO);
        }

        //批量保存券实例
        couponEntityPOMapper.insertBatch(entityPOList);

        //批量生成条形码
        //new Thread(
        /*Runnable runnable = new Runnable() {
            @Override
            public void run() {

                updateBarcodeUrlBatch(entityPOList);

            }
        };*/
        //).start();
        /*ThreadPool.init();
        ThreadPool.run(runnable);*/

        return entityPOList;
    }


    /**
     * 批量生成条形码
     * @param entityPOList
     */
    public synchronized void updateBarcodeUrlBatch(List<CouponEntityPO> entityPOList){


            logger.info("enter SendCouponServiceImpl updateBarcodeUrlBatch method");

            List<CouponEntityPO> list = new ArrayList<>();

           // for (CouponEntityPO entityPO : entityPOList) {
            for(int i=0;i<entityPOList.size();i++){

                //生成条形码
                String url = BarcodeUtil.generateBarCode(entityPOList.get(i).getCouponCode());
                entityPOList.get(i).setBarcodeUrl(url);

                logger.info("enter SendCouponServiceImpl updateBarcodeUrlBatch method param:url:{}",url);
               /* try {
                    Thread.sleep(1000);
                }catch(Exception e){
                    logger.info("enter SendCouponServiceImpl updateBarcodeUrlBatch method Exception param:{}",JSONObject.toJSONString(e));
                }*/

            }

            couponEntityPOMapper.updateBarcodeUrlBatch(entityPOList);

    }

    /**
     * 单张生成条形码
     * @param entityPO
     */
    @Override
    public void updateBarcodeUrl(CouponEntityPO entityPO){


        logger.info("enter SendCouponServiceImpl updateBarcodeUrl method");


        //生成条形码
        String url = BarcodeUtil.generateBarCode(entityPO.getCouponCode());
        entityPO.setBarcodeUrl(url);

        CouponEntityPOExample entityPOExample = new CouponEntityPOExample();
        entityPOExample.createCriteria().andCouponCodeEqualTo(entityPO.getCouponCode());

        CouponEntityPO entityPORequest = new CouponEntityPO();
        entityPORequest.setBarcodeUrl(url);
        couponEntityPOMapper.updateByExampleSelective(entityPORequest,entityPOExample);

    }

    @Override
    public CouponBatchSendRecordPO saveNewCouponBatchRecord(Long companyId,Long brandId,String brandCode,String ids, SendCouponBatchRequestVO requestVO) {
        logger.info("enter SendCouponServiceImpl saveCouponBatchRecord method:requestVO:{}", requestVO);

        //保存发券记录
        CouponBatchSendRecordPO batchPO = new CouponBatchSendRecordPO();

        batchPO.setSysCompanyId(companyId);
        batchPO.setSysBrandId(brandId);
        batchPO.setBrandCode(brandCode);
        batchPO.setCouponDefinitionId(ids);

        batchPO.setBatchSendCode(BusinessCodeUtil.getCouponBatchSendCode());
        batchPO.setBizType(requestVO.getBusinessType());
        batchPO.setBizCode(requestVO.getBusinessId() + "");

        //batchPO.setSendNum(requestVO.getTotalNumber());
        batchPO.setCreateDate(TimeUtils.getNowTime());
        batchPO.setCreateUserId(requestVO.getCreateUserId());
        batchPO.setCreateUserName(requestVO.getCreateUserName());
        //保存发券记录，返回
        couponBatchSendRecordPOMapper.insertSelective(batchPO);


        return batchPO;
    }
    
    @Override
    public void saveNewCouponBatchRecordDetail(Long companyId,Long brandId,String brandCode,CouponDefinitionPOWithBLOBs couponDefinitionPOWithBLOBs, SendCouponBatchRequestVO requestVO) {

        //保存发券记录
        CouponBatchSendDetailPO batchPO = new CouponBatchSendDetailPO();

        batchPO.setSysCompanyId(companyId);
        batchPO.setSysBrandId(brandId);
        batchPO.setBrandCode(brandCode);
        batchPO.setCouponDefinitionId(couponDefinitionPOWithBLOBs.getCouponDefinitionId().toString());

        batchPO.setBatchSendCode(requestVO.getBatchSendCode());
        batchPO.setBatchSendCodeDetail(requestVO.getBatchSendCodeDetail().toString());
        batchPO.setCouponDefinitionCode(couponDefinitionPOWithBLOBs.getCouponDefinitionCode());
        batchPO.setCouponName(couponDefinitionPOWithBLOBs.getCouponName());
        
        batchPO.setBizType(requestVO.getBusinessType());
        batchPO.setBizCode(requestVO.getBusinessId() + "");
        batchPO.setCouponManualId(requestVO.getBusinessId() + "");

        //batchPO.setSendNum(requestVO.getTotalNumber());
        batchPO.setCreateDate(TimeUtils.getNowTime());
        batchPO.setCreateUserId(requestVO.getCreateUserId());
        batchPO.setCreateUserName(requestVO.getCreateUserName());
        
        //计算有效期开始到结束区间
        Calendar calendar = Calendar.getInstance();
        if (couponDefinitionPOWithBLOBs.getValidType().equals(CouponConstants.VALID_TYPE__SOMEDAY)) {
            calendar.add(Calendar.DATE, couponDefinitionPOWithBLOBs.getValidDay());
            calendar.set(Calendar.HOUR_OF_DAY,23);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.MILLISECOND, 59);

            batchPO.setValidDateStart(TimeUtils.getNowTime());
            batchPO.setValidDateEnd(calendar.getTime());
        }else{
        	batchPO.setValidDateStart(couponDefinitionPOWithBLOBs.getValidDateStart());

            calendar.setTime(couponDefinitionPOWithBLOBs.getValidDateEnd());
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.MILLISECOND, 59);

            batchPO.setValidDateEnd(calendar.getTime());
        }
        
        
        //保存发券记录，返回
        logger.info("enter SendCouponServiceImpl saveNewCouponBatchRecordDetail method:requestVO:{}", batchPO);
        couponBatchSendDetailPOMapper.insertSelective(batchPO);

    }


    /**
     * 线上批量发券
     *
     * @param entityPOList
     * @return
     */
    @Override
    public ResponseData<String> sendCouponBatchOnline(CouponDefinitionPO definitionPO, List<CouponEntityPO> entityPOList) {
        logger.info("enter SendCouponServiceImpl sendCouponBatchOnline method");
        ResponseData<String> responseData = new ResponseData<>();

        ResponseData<WxPublicPO> publicPO = wxPublicServiceFeign.getWxPublicBySysBrandId(definitionPO.getSysBrandId());


        //批量发券
        for (int i = 0; i < entityPOList.size(); i++) {

            CouponMessageVO messageVO = new CouponMessageVO();
            messageVO.setUseTime(entityPOList.get(i).getCreateDate());
            messageVO.setSysCompanyId(entityPOList.get(i).getSysCompanyId());
            messageVO.setMemberCode(entityPOList.get(i).getMemberCode());
            messageVO.setCouponCode(entityPOList.get(i).getCouponCode());
            messageVO.setCouponName(definitionPO.getCouponName());

            messageVO.setPreferentialType(definitionPO.getPreferentialType()+"");

            if(definitionPO.getPreferentialType().equals(CouponConstants.PREFERENTIAL_TYPE_MONEY)){
                messageVO.setDenomination(definitionPO.getMoney()+"");
            }else if(definitionPO.getPreferentialType().equals(CouponConstants.PREFERENTIAL_TYPE_DISCOUNT)){
                messageVO.setDenomination(definitionPO.getDiscount()+"");
            }

            messageVO.setValidDateStart(entityPOList.get(i).getValidDateStart());
            messageVO.setValidDateEnd(entityPOList.get(i).getValidDateEnd());
            messageVO.setSysBrandId(entityPOList.get(i).getSysBrandId());

            //查询会员信息
            WxChannelInfoVo channelVO = new WxChannelInfoVo();
            channelVO.setMemberCode(entityPOList.get(i).getMemberCode());
            channelVO.setBrandId(entityPOList.get(i).getSysBrandId());
            channelVO.setMiniProgram(1);
            ResponseData<WxChannelAndMemberVo> channelResult = wxChannelInfoApiService.getWxChannelInfoAndMemberInfo(channelVO);

            if (channelResult.getData() != null) {
                WxChannelInfoVo channelInfoVo = channelResult.getData().getWxChannelInfoVo();
                messageVO.setMemberName(channelInfoVo.getName());
                messageVO.setMemberPhone(channelInfoVo.getPhone());
                messageVO.setSendWxmember(channelInfoVo.getFocus()+"");
                messageVO.setSysCompanyId(channelInfoVo.getSysCompanyId());
                
            }


            if(publicPO.getData() != null){
                messageVO.setNickName(publicPO.getData().getNickName());
            }

            //调取message模块接口
            logger.info("enter SendCouponServiceImpl couponReceive method"+JSONObject.toJSONString(messageVO)+JSONObject.toJSONString(channelVO)+JSONObject.toJSONString(channelResult.getData().getWxChannelInfoVo()));
            ResponseData<String> sendOnlineResult = wechatCouponServiceFeign.couponReceive(messageVO);

        }


        return responseData;
    }


    /**
     * 线下批量发券
     *
     * @param entityPOList
     * @return
     */
    @Override
    public ResponseData<String> sendCouponBatchOffline(CouponDefinitionPOWithBLOBs definitionPO, List<CouponEntityPO> entityPOList,
                                                       CouponBatchSendRecordPO batchPO) {
                                                        return null;}


    /**
     * 线下发券失败信息记录
     */
    public void sendCouponBatchOfflineFail(List<String> failCouponCodeList, CouponBatchSendRecordPO batchPO) {

        //修改发券实例表状态
        couponEntityPOMapper.updateCouponStatusBatch(failCouponCodeList,CouponConstants.COUPON_STATUS_SYNC_FAIL);

        //发券失败表插入记录
        List<CouponSendFailLogPO> failPOList = couponSendFailLogPOMapper.selectByCouponCodeList(failCouponCodeList);

        for (int i = 0; i < failPOList.size(); i++) {
            failPOList.get(i).setBatchSendCode(batchPO.getBatchSendCode());
            failPOList.get(i).setSendStatus(CouponConstants.COUPON_SEND_NO);
            failPOList.get(i).setValid(CouponConstants.TABLE_VALID_EFFECTIVE);
            failPOList.get(i).setCreateDate(TimeUtils.getNowTime());
            failPOList.get(i).setBizCode(batchPO.getBizCode());
            failPOList.get(i).setBizType(batchPO.getBizType());
            failPOList.get(i).setFailReason(CouponConstants.SEND_COUPON_FAIL_REASON_ERP);
            failPOList.get(i).setFailTimes(0);
        }

        couponSendFailLogPOMapper.insertBatch(failPOList);

        throw new RuntimeException();

    }


    /**
     * 发券失败查询
     *
     * @param vo
     * @return
     */
    @Override
    public ResponseData<PageInfo> couponSendFail(CouponSendFailLogVO vo, SysAccountPo accountPo, PageFormUtil pageForm) {
        logger.info("enter SendCouponServiceImpl couponSendFail method:param:{}", accountPo.getBrandId());
        ResponseData<PageInfo> responseData = new ResponseData<>();
        PageHelper.startPage(pageForm.getPageNumber(), pageForm.getPageSize());

        if(vo.getListType()==null) {
        	vo.setListType("1");
        }
        if(vo.getListType().equals("1")) {
        	vo.setListType("85");
        }else if(vo.getListType().equals("2")) {
        	vo.setListType("10,15,30,35,45,50,55,56,90,100,103,104,105");
        }else if(vo.getListType().equals("3")) {
        	vo.setListType("60,65,70,75,80");
        }else if(vo.getListType().equals("4")) {
        	vo.setListType("95");
        }else if(vo.getListType().equals("5")) {
        	vo.setListType("94");
        }else if(vo.getListType().equals("6")) {
        	vo.setListType("20");
        }else if(vo.getListType().equals("7")) {
        	vo.setListType("101");
        }else if(vo.getListType().equals("8")) {
        	vo.setListType("102");
        }

        List<CouponSendFailLogVO> list = couponSendFailLogPOMapper.findCouponSendFailLogByCondition(vo, accountPo.getBrandId());

        PageInfo pageInfo = new PageInfo(list);
        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 根据id修改券发放失败信息
     *
     * @param couponSendFailLogPO
     * @return
     */
    @Override
    public ResponseData<Object> update(CouponSendFailLogPO couponSendFailLogPO) {
        logger.info("enter SendCouponServiceImpl update method");
        ResponseData<Object> responseData = new ResponseData<>();

        if (null == couponSendFailLogPO.getCouponSendFailLogId()) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("发券失败id不能为空");
            return responseData;
        }
        couponSendFailLogPO.setModifiedDate(TimeUtils.getNowTime());
        int count = couponSendFailLogPOMapper.updateByPrimaryKeySelective(couponSendFailLogPO);

        responseData.setData(count);

        return responseData;
    }


    /**
     * 券到期提醒
     *
     * @param expireDay
     * @return
     */
    @Override
    public ResponseData<Integer> expire(String expireDay) {
        logger.info("enter SendCouponServiceImpl expire method !");

        ResponseData<Integer> responseData = new ResponseData<>();

        if (StringUtils.isBlank(expireDay)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.EXPIRE_DAY_NOT_NULL.getMessage());
            return responseData;
        }

        SysCodeValuePOExample valuePOExample = new SysCodeValuePOExample();
        valuePOExample.createCriteria().andCodeTypeEqualTo(CouponConstants.COUPON_EXPIRE_CODE_TYPE);
        SysCodeValuePO valuePO = new SysCodeValuePO();
        valuePO.setItemCode(expireDay);
        sysCodeValuePOMapper.updateByExampleSelective(valuePO, valuePOExample);
        ResponseData<Integer> jobResult = jobUtil.sendCouponExpireJob();

        if (SysResponseEnum.SUCCESS.getCode() != jobResult.getCode()) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(jobResult.getMessage());
            return responseData;
        }

        return responseData;
    }


    /**
     * 券补发(单张)
     *
     * @return
     */
    @Override
    public ResponseData<Integer> sendSingleAgain(Long couponSendFailLogId) {

        logger.info("enter SendCouponServiceImpl sendSingleAgain method !");

        ResponseData<Integer> responseData = new ResponseData<>();

        if (null == couponSendFailLogId) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_SEND_FAIL_LOG_ID_NOT_NULL.getMessage());
            return responseData;
        }


        CouponSendFailLogPO failLogPO = couponSendFailLogPOMapper.selectByPrimaryKey(couponSendFailLogId);

        //更新失败状态
        couponSendFailLogService.updateSendStatusAndSendTimes(CouponConstants.COUPON_SENDING,TimeUtils.getNowTime(),couponSendFailLogId);

        CouponEntityPO entityPO = couponEntityPOMapper.selectByPrimaryKey(failLogPO.getCouponEntityId());
        CouponDefinitionPOWithBLOBs definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(Long.parseLong(entityPO.getCouponDefinitionId()));

        //线下发券
        ResponseData<String> offlineResult = sendCouponOffline(definitionPO, entityPO,CouponConstants.COUPON_SEND_AGAIN_YES);

        if (SysResponseEnum.SUCCESS.getCode() != offlineResult.getCode()) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(offlineResult.getMessage());
            return responseData;
        }

        return responseData;

    }


    /**
     * 补发券(批量)
     *
     * @return
     */
    @Override
    public ResponseData<Integer> sendBatchAgain(String ids) {
        logger.info("enter SendCouponServiceImpl sendBatchAgain method ! param:ids:{}",ids);

        ResponseData<Integer> responseData = new ResponseData<>();

        if (StringUtils.isBlank(ids)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_SEND_FAIL_LOG_ID_NOT_NULL.getMessage());
            return responseData;
        }

        //切分字符串
        String[] idArr = ids.split(",");
        List<String> idList = Arrays.asList(idArr);

        //根据id集合查询数据
        List<CouponSendAgainRequestVO> againList = couponSendFailLogPOMapper.selectBatchByIdList(idList,CouponConstants.COUPON_SEND_NO);

        //单张发券批量补发
        List<CouponSendAgainRequestVO> singleBatchList = new ArrayList<>();

        //批量发券补发
        List<CouponSendAgainRequestVO> batchList = new ArrayList<>();

        //分组
        for (int i = 0; i < againList.size(); i++) {

            if (StringUtils.isBlank(againList.get(i).getBatchSendCode())) {
                //如果没有批次信息-为单张发券批量补发
                singleBatchList.add(againList.get(i));
            } else {
                //如果有批次信息-为批量发券补发
                batchList.add(againList.get(i));
            }
        }

        //如果没有批次信息-为单张发券批量补发
        if (CollectionUtils.isNotEmpty(singleBatchList)) {
            ResponseData<Integer> executeResult = this.sendSingleBatchAgainExecute(singleBatchList);

        }

        //如果有批次信息-为批量发券补发
        if (CollectionUtils.isNotEmpty(batchList)) {
            ResponseData<Integer> executeResult = this.sendBatchAgainExecute(batchList);
        }

        return responseData;
    }


    /**
     * 执行批量补发
     *
     * @param againList
     * @return
     */
    @Override
    public ResponseData<Integer> sendBatchAgainExecute(List<CouponSendAgainRequestVO> againList) {

        ResponseData<Integer> responseData = new ResponseData<>();

        if(CollectionUtils.isEmpty(againList)){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
            return responseData;
        }

        Map<Long, List<CouponSendAgainRequestVO>> brandMap = new HashMap<>();

        //根据券定义id分组
        for (CouponSendAgainRequestVO vo : againList) {

            if (brandMap.containsKey(vo.getCouponDefinitionId())) {
                brandMap.get(vo.getCouponDefinitionId()).add(vo);
            } else {
                List<CouponSendAgainRequestVO> list = new ArrayList<>();
                list.add(vo);
                brandMap.put(vo.getCouponDefinitionId(), list);
            }

        }

        //遍历券定义id，根据发券批次号分组
        for (Map.Entry<Long, List<CouponSendAgainRequestVO>> brandEntry : brandMap.entrySet()) {

            Map<String, List<CouponSendAgainRequestVO>> batchMap = new HashMap();

            //根据发券批次号分组
            for (CouponSendAgainRequestVO batchVO : brandEntry.getValue()) {

                if (batchMap.containsKey(batchVO.getBatchSendCode())) {
                    batchMap.get(batchVO.getBatchSendCode()).add(batchVO);
                } else {
                    List<CouponSendAgainRequestVO> list = new ArrayList<>();
                    list.add(batchVO);
                    batchMap.put(batchVO.getBatchSendCode(), list);
                }

            }


            //遍历批次集合，分批发送券
            for (Map.Entry<String, List<CouponSendAgainRequestVO>> batchEntry : batchMap.entrySet()) {}


        }


        return responseData;

    }


    /**
     * 单张发券执行批量补发
     *
     * @param againList
     * @return
     */
    @Override
    public ResponseData<Integer> sendSingleBatchAgainExecute(List<CouponSendAgainRequestVO> againList) {

        ResponseData<Integer> responseData = new ResponseData<>();

        if (CollectionUtils.isEmpty(againList)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
            return responseData;
        }

        //根据品牌id分组
        Map<Long, List<CouponSendAgainRequestVO>> brandMap = new HashMap<>();


        for (CouponSendAgainRequestVO vo : againList) {

            if (brandMap.containsKey(vo.getCouponDefinitionId())) {
                brandMap.get(vo.getCouponDefinitionId()).add(vo);
            } else {
                List<CouponSendAgainRequestVO> list = new ArrayList<>();
                list.add(vo);
                brandMap.put(vo.getCouponDefinitionId(), list);
            }

        }

        //遍历品牌id,发券
        for (Map.Entry<Long, List<CouponSendAgainRequestVO>> brandEntry : brandMap.entrySet()) {}

        return responseData;

    }


    /**
     * 保存发券批次记录
     *
     * @param definitionPO
     * @param requestVO
     * @return
     */
    @Override
    public CouponBatchSendRecordPO saveCouponBatchRecord(CouponDefinitionPO definitionPO, SendCouponBatchRequestVO requestVO) {

        logger.info("enter SendCouponServiceImpl saveCouponBatchRecord method:requestVO:{}", requestVO);

        //保存发券记录
        CouponBatchSendRecordPO batchPO = new CouponBatchSendRecordPO();

        batchPO.setSysCompanyId(definitionPO.getSysCompanyId());
        batchPO.setSysBrandId(definitionPO.getSysBrandId());
        batchPO.setBrandCode(definitionPO.getBrandCode());
        batchPO.setCouponDefinitionId(definitionPO.getCouponDefinitionId().toString());
        batchPO.setBatchSendCode(BusinessCodeUtil.getCouponBatchSendCode());
        batchPO.setBizType(requestVO.getBusinessType());
        batchPO.setBizCode(requestVO.getBusinessId() + "");
        if (CouponConstants.COUPON_DEFINITION_TYPE_ONLINE.equals(definitionPO.getCouponDefinitionType())) {
            batchPO.setIsOfflineSync(CouponConstants.TABLE_VALID_INVALID);
        } else if (CouponConstants.COUPON_DEFINITION_TYPE_ERP.equals(definitionPO.getCouponDefinitionType())) {
            batchPO.setIsOfflineSync(CouponConstants.TABLE_VALID_EFFECTIVE);
        } else {
            logger.error(SysResponseEnum.COUPON_DEFINITION_TYPE_NOT_EXISTS.getMessage());
        }
        //batchPO.setSendNum(requestVO.getTotalNumber());
        batchPO.setCreateDate(TimeUtils.getNowTime());
        batchPO.setCreateUserId(requestVO.getCreateUserId());
        batchPO.setCreateUserName(requestVO.getCreateUserName());
        //保存发券记录，返回
        couponBatchSendRecordPOMapper.insertSelective(batchPO);


        return batchPO;
    }


    /**
     * 线上批量发券
     *
     * @param definitionPO
     * @param requestVO
     */
    @Override
    public ResponseData<String> sendCouponBatchOnlineNow(CouponDefinitionPOWithBLOBs definitionPO, SendCouponBatchRequestVO requestVO,
                                                         CouponBatchSendRecordPO batchPO) {

        logger.info("enter SendCouponServiceImpl sendCouponBatchOnlineNow method! param:exception:{}",JSONObject.toJSONString(requestVO));

        ResponseData<String> responseData = new ResponseData<>();

        CouponManualPO manualPO = couponManualPOMapper.selectByPrimaryKey(requestVO.getBusinessId());

        //查询会员记录，分批发券
        MembersInfoSearchVo searchVo = JSONObject.toJavaObject(JSONObject.parseObject(manualPO.getMemberCondition()), MembersInfoSearchVo.class);
        searchVo.setPageNumber(CouponConstants.SEARCH_MEMBERS_PAGE_NUMBER);
        searchVo.setPageSize(CouponConstants.SEARCH_MEMBERS_PAGE_SIZE);

        ResponseData<PageInfo<MembersInfoSearchPojo>> esFirstResult = membersAdvancedSearchApiService.advancedSearch(searchVo);

        if(esFirstResult.getCode() == SysResponseEnum.FAILED.getCode()){

            //更新发券失败数量
            updateSendCouponBatchException(batchPO,batchPO.getSendNum(),definitionPO);

            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.FAILED.getMessage());
            return responseData;
        }

        //总页数
        int totalPages = esFirstResult.getData().getPages();
        //总数量
        int totalNumber = Integer.parseInt(esFirstResult.getData().getTotal()+"");

        //更新发券数量
        CouponManualPO manualRequest = new CouponManualPO();
        manualRequest.setMemberCount(totalNumber);
        manualRequest.setCouponManualId(Long.parseLong(batchPO.getBizCode()));
        //couponManualPOMapper.updateByPrimaryKeySelective(manualRequest);
        couponManualPOMapper.updateMemberCount(totalNumber,Long.parseLong(batchPO.getBizCode()));

        CouponBatchSendRecordPO batchSendRequest = new CouponBatchSendRecordPO();
        batchSendRequest.setSendNum(totalNumber);
        batchSendRequest.setCouponBatchSendRecordId(batchPO.getCouponBatchSendRecordId());
        //couponBatchSendRecordPOMapper.updateByPrimaryKeySelective(batchSendRequest);
        couponBatchSendRecordPOMapper.updateSendNum(totalNumber,batchPO.getCouponBatchSendRecordId());

        /*new Thread(*/
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                //成功总数
                int allSuccessCount = 0;

                //根据总页数，分批次发券
                for (int es = 1; es <= totalPages; es++) {

                    //最后一页，控制查询的数量,可能不足pageSize条(因为会员数量会变动)
                    if (es == totalPages) {
                        searchVo.setPageSize(totalNumber % CouponConstants.SEARCH_MEMBERS_PAGE_SIZE);
                    }

                    try {

                        searchVo.setPageNumber(es);
                        ResponseData<PageInfo<MembersInfoSearchPojo>> esResult = membersAdvancedSearchApiService.advancedSearch(searchVo);

                        if (SysResponseEnum.SUCCESS.getCode() != esResult.getCode()) {

                            throw new RuntimeException();
                        }


                        requestVO.setMemberListManual(esResult.getData().getList());

                        //保存发券记录
                        List<CouponEntityPO> entityPOList = saveEntityList(definitionPO, requestVO, batchPO.getCouponBatchSendRecordId(), CouponConstants.COUPON_STATUS_UNUSED);

                        //如果业务类型是手动发券
                        if (SendTypeEnum.SEND_COUPON_BATCH.getCode().equals(batchPO.getBizType())) {

                            //更新手动发券成功数量
                            int successCount = 0;

                            if (es == totalPages) {
                                //最后一页
                                successCount = totalNumber % CouponConstants.SEARCH_MEMBERS_PAGE_SIZE;
                            } else {
                                //其余页数
                                successCount = CouponConstants.SEARCH_MEMBERS_PAGE_SIZE;
                            }

                            couponManualPOMapper.updateCouponManualSuccessCount(successCount, manualPO.getCouponManualId());

                            allSuccessCount += successCount;
                            if (allSuccessCount == totalNumber) {
                                //更新状态为发券成功
                                couponManualService.updateTaskStatus(manualPO.getCouponManualId(), CouponManualTaskStatusEnum.TASK_STATUS_SEND_SUCCESS.getCode().byteValue());
                            }

                        }

                        //批量发券
                        ResponseData<String> onlineResult = sendCouponBatchOnline(definitionPO, entityPOList);

                    } catch (Exception e) {

                        logger.info("enter SendCouponServiceImpl sendCouponBatchOnlineNow error param:exception:{}",JSONObject.toJSONString(e));

                        int failCount = 0;
                        if (es == totalPages) {
                            //最后一页
                            failCount = totalNumber % CouponConstants.SEARCH_MEMBERS_PAGE_SIZE;
                        } else {
                            //其余页数
                            failCount = CouponConstants.SEARCH_MEMBERS_PAGE_SIZE;
                        }
                        updateSendCouponBatchException(batchPO, failCount,definitionPO);

                    }

                }

            }
        };
        //).start();
        //ThreadPool.init();
        ThreadPool.run(runnable);

        return responseData;

    }


    /**
     * 线下批量发券
     *
     * @param definitionPO
     * @param requestVO
     * @param batchPO
     * @return
     */
    @Override
    public ResponseData<String> sendCouponBatchOfflineNow(CouponDefinitionPOWithBLOBs definitionPO, SendCouponBatchRequestVO requestVO,
                                                          CouponBatchSendRecordPO batchPO) {

        logger.info("enter SendCouponServiceImpl sendCouponBatchOfflineNow method !");
        ResponseData<String> responseData = new ResponseData<>();

        CouponManualPO manualPO = couponManualPOMapper.selectByPrimaryKey(requestVO.getBusinessId());

        //查询会员记录，分批发券
        MembersInfoSearchVo searchVo = JSONObject.toJavaObject(JSONObject.parseObject(manualPO.getMemberCondition()), MembersInfoSearchVo.class);
        searchVo.setPageNumber(CouponConstants.SEARCH_MEMBERS_PAGE_NUMBER);
        searchVo.setPageSize(CouponConstants.SEARCH_MEMBERS_PAGE_SIZE);

            logger.info("sssssssssssssssssssss+"+JSONObject.toJSONString(searchVo));

            //查询会员信息
            ResponseData<PageInfo<MembersInfoSearchPojo>> esFirstResult = membersAdvancedSearchApiService.advancedSearch(searchVo);

            logger.info("enter SendCouponServiceImpl sendCouponBatchOfflineNow method ! param:esFirstResult:{}",JSONObject.toJSONString(esFirstResult));

            if(esFirstResult.getCode() == SysResponseEnum.FAILED.getCode()){

                //更新发券失败数量
                updateSendCouponBatchException(batchPO,batchPO.getSendNum(),definitionPO);

                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage(SysResponseEnum.FAILED.getMessage());
                return responseData;
            }

        //总页数
        int totalPages = esFirstResult.getData().getPages();
        //总数量
        int totalNumber = Integer.parseInt(esFirstResult.getData().getTotal()+"");

        //更新发券数量
        CouponManualPO manualRequest = new CouponManualPO();
        manualRequest.setMemberCount(totalNumber);
        manualRequest.setCouponManualId(Long.parseLong(batchPO.getBizCode()));
        //couponManualPOMapper.updateByPrimaryKeySelective(manualRequest);
        couponManualPOMapper.updateMemberCount(totalNumber,Long.parseLong(batchPO.getBizCode()));

        CouponBatchSendRecordPO batchSendRequest = new CouponBatchSendRecordPO();
        batchSendRequest.setSendNum(totalNumber);
        batchSendRequest.setCouponBatchSendRecordId(batchPO.getCouponBatchSendRecordId());
        //couponBatchSendRecordPOMapper.updateByPrimaryKeySelective(batchSendRequest);
        couponBatchSendRecordPOMapper.updateSendNum(totalNumber,batchPO.getCouponBatchSendRecordId());

        //new Thread(
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                System.out.println(Thread.currentThread().getName()+"::vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");

                for (int es = 1; es <= totalPages; es++) {

                    //最后一页，控制查询的数量,可能不足pageSize条
                    if (es == totalPages) {
                        searchVo.setPageSize(totalNumber % CouponConstants.SEARCH_MEMBERS_PAGE_SIZE);
                    }

                    List<CouponEntityPO> entityPOList = null;

                    try {

                        searchVo.setPageNumber(es);
                        ResponseData<PageInfo<MembersInfoSearchPojo>> esResult = membersAdvancedSearchApiService.advancedSearch(searchVo);

                        logger.info("enter SendCouponServiceImpl sendCouponBatchOfflineNow method:param:{}",JSONObject.toJSONString(esResult));

                        if (SysResponseEnum.SUCCESS.getCode() != esResult.getCode()) {

                            throw new RuntimeException();
                        }

                        requestVO.setMemberListManual(esResult.getData().getList());

                        //保存发券记录
                        entityPOList = saveEntityList(definitionPO, requestVO, batchPO.getCouponBatchSendRecordId(), CouponConstants.COUPON_STATUS_SYNCHROING);

                        //线下发券
                        ResponseData<String> sendResult = sendCouponBatchOffline(definitionPO, entityPOList, batchPO);

                    } catch (Exception e) {

                        logger.info("enter CouponManualServiceImpl sendCouponBatchOfflineNow exception !"+JSONObject.toJSONString(e));
                        int failCount = 0;
                        if (es == totalPages) {
                            //最后一页
                            failCount = totalNumber % CouponConstants.SEARCH_MEMBERS_PAGE_SIZE;
                        } else {
                            //其余页数
                            failCount = CouponConstants.SEARCH_MEMBERS_PAGE_SIZE;
                        }
                        updateSendCouponBatchException(batchPO, failCount,definitionPO);


                        //调用线下失败，插入失败表
                        /*if(CollectionUtils.isNotEmpty(entityPOList)){

                            List<String> couponCodeList = new ArrayList<>();
                            for(CouponEntityPO entityPO : entityPOList){
                                couponCodeList.add(entityPO.getCouponCode());
                            }

                            saveCouponSendFail(batchPO,couponCodeList);
                        }*/

                    }

                }


            }
        };
        //).start();
        //ThreadPool.init();
        ThreadPool.run(runnable);

        return responseData;

    }


    /**
     * 批量发券调用线下失败,存入失败表
     */
    /*public void saveCouponSendFail(CouponBatchSendRecordPO batchPO,List<String> couponCodeList){

        List<CouponSendFailLogPO> failPOList = couponSendFailLogPOMapper.selectByCouponCodeList(couponCodeList);

        for (int i = 0; i < failPOList.size(); i++) {
            failPOList.get(i).setBatchSendCode(batchPO.getBatchSendCode());
            failPOList.get(i).setSendStatus(CouponConstants.COUPON_SEND_NO);
            failPOList.get(i).setValid(CouponConstants.TABLE_VALID_EFFECTIVE);
            failPOList.get(i).setCreateDate(TimeUtils.getNowTime());
            failPOList.get(i).setBizCode(batchPO.getBizCode());
            failPOList.get(i).setBizType(batchPO.getBizType());
            failPOList.get(i).setFailReason(CouponConstants.SEND_COUPON_FAIL_REASON_ERP_UNCONNECT);
            failPOList.get(i).setFailTimes(0);
        }

        //非补发，批量插入
        couponSendFailLogPOMapper.insertBatch(failPOList);

    }*/




    /**
     * 全渠道批量发券
     *
     * @param requestVO
     * @return
     */
    @Override
    public ResponseData<String> sendCouponBatchAnyNow(CouponDefinitionPOWithBLOBs definitionPO, SendCouponBatchRequestVO requestVO,
                                                      CouponBatchSendRecordPO batchPO) {
        logger.info("enter CouponManualServiceImpl sendCouponBatchAnyNow method !");
        ResponseData<String> responseData = new ResponseData<>();

        CouponManualPO manualPO = couponManualPOMapper.selectByPrimaryKey(requestVO.getBusinessId());

        //查询会员记录，分批发券
        MembersInfoSearchVo searchVo = JSONObject.toJavaObject(JSONObject.parseObject(manualPO.getMemberCondition()), MembersInfoSearchVo.class);
        searchVo.setPageNumber(CouponConstants.SEARCH_MEMBERS_PAGE_NUMBER);
        searchVo.setPageSize(CouponConstants.SEARCH_MEMBERS_PAGE_SIZE);

        ResponseData<PageInfo<MembersInfoSearchPojo>> esFirstResult = membersAdvancedSearchApiService.advancedSearch(searchVo);

        logger.info("enter SendCouponServiceImpl sendCouponBatchAnyNow method ! param:esFirstResult:{}",JSONObject.toJSONString(esFirstResult));

        if(esFirstResult.getCode() == SysResponseEnum.FAILED.getCode()){

            //更新发券失败数量
            updateSendCouponBatchException(batchPO,batchPO.getSendNum(),definitionPO);

            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.FAILED.getMessage());
            return responseData;
        }

        //总页数
        int totalPages = esFirstResult.getData().getPages();
        //总数量
        int totalNumber = Integer.parseInt(esFirstResult.getData().getTotal()+"");

        //更新发券数量
        CouponManualPO manualRequest = new CouponManualPO();
        manualRequest.setMemberCount(totalNumber);
        manualRequest.setCouponManualId(Long.parseLong(batchPO.getBizCode()));
        //couponManualPOMapper.updateByPrimaryKeySelective(manualRequest);
        couponManualPOMapper.updateMemberCount(totalNumber,Long.parseLong(batchPO.getBizCode()));

        CouponBatchSendRecordPO batchSendRequest = new CouponBatchSendRecordPO();
        batchSendRequest.setSendNum(totalNumber);
        batchSendRequest.setCouponBatchSendRecordId(batchPO.getCouponBatchSendRecordId());
        //couponBatchSendRecordPOMapper.updateByPrimaryKeySelective(batchSendRequest);
        couponBatchSendRecordPOMapper.updateSendNum(totalNumber,batchPO.getCouponBatchSendRecordId());

        //new Thread(
        Runnable runnable = new Runnable() {
            @Override
            public void run() {


                for (int es = 1; es <= totalPages; es++) {

                    //最后一页，控制查询的数量,可能不足pageSize条
                    if (es == totalPages) {
                        searchVo.setPageSize(totalNumber % CouponConstants.SEARCH_MEMBERS_PAGE_SIZE);
                    }

                    List<CouponEntityPO> entityPOList = null;
                    try {

                        searchVo.setPageNumber(es);
                        ResponseData<PageInfo<MembersInfoSearchPojo>> esResult = membersAdvancedSearchApiService.advancedSearch(searchVo);

                        if (SysResponseEnum.SUCCESS.getCode() != esResult.getCode()) {

                            throw new RuntimeException();
                        }

                        requestVO.setMemberListManual(esResult.getData().getList());

                        //更新手动发券状态为-发送中
                        couponManualService.updateTaskStatus(requestVO.getBusinessId(), CouponManualTaskStatusEnum.TASK_STATUS_SENDING.getCode().byteValue());

                        //保存发券记录 - 首先线上发券，保存为未使用
                        entityPOList = saveEntityList(definitionPO, requestVO, batchPO.getCouponBatchSendRecordId(), CouponConstants.COUPON_STATUS_UNUSED);

                        //更新手动发券状态为-同步中
                        couponManualService.updateTaskStatus(requestVO.getBusinessId(), CouponManualTaskStatusEnum.TASK_STATUS_SYNCING.getCode().byteValue());


                        //批量更新券状态 - 线下同步
                        List<String> couponCodeList = new ArrayList<>();
                        for (int i = 0; i < entityPOList.size(); i++) {
                            couponCodeList.add(entityPOList.get(i).getCouponCode());
                        }
                        couponEntityPOMapper.updateCouponStatusBatch(couponCodeList, CouponConstants.COUPON_STATUS_SYNCHROING);

                        //线下发券
                        ResponseData<String> sendResult = sendCouponBatchOffline(definitionPO, entityPOList, batchPO);


                    } catch (Exception e) {

                        logger.info("enter CouponManualServiceImpl sendCouponBatchAnyNow exception !"+JSONObject.toJSONString(e));

                        int failCount = 0;
                        if (es == totalPages) {
                            //最后一页
                            failCount = totalNumber % CouponConstants.SEARCH_MEMBERS_PAGE_SIZE;
                        } else {
                            //其余页数
                            failCount = CouponConstants.SEARCH_MEMBERS_PAGE_SIZE;
                        }
                        updateSendCouponBatchException(batchPO, failCount,definitionPO);

                        //调用线下失败，插入失败表
                        /*if(CollectionUtils.isNotEmpty(entityPOList)){

                            List<String> couponCodeList = new ArrayList<>();
                            for(CouponEntityPO entityPO : entityPOList){
                                couponCodeList.add(entityPO.getCouponCode());
                            }

                            saveCouponSendFail(batchPO,couponCodeList);
                        }*/

                    }

                }


            }
        };
        //).start();
        //ThreadPool.init();
        ThreadPool.run(runnable);

        return responseData;
    }


    /**
     * 出现异常时的批量发券处理
     *
     * @param batchPO
     * @param count
     */
    public void updateSendCouponBatchException(CouponBatchSendRecordPO batchPO, Integer count,CouponDefinitionPO definitionPO) {

        couponBatchSendRecordPOMapper.updateFailNum(count, batchPO.getCouponBatchSendRecordId());

        //如果业务类型是手动发券
        if (SendTypeEnum.SEND_COUPON_BATCH.getCode().equals(batchPO.getBizType())) {

            int syncFailCount = 0;

            //更新失败数量
            if(definitionPO.getUseChannel().equals(CouponConstants.USE_CHANNEL_OFFLINE) ||
                    definitionPO.getUseChannel().equals(CouponConstants.USE_CHANNEL_ANY)){
                syncFailCount = count;
            }
            couponManualPOMapper.updateCouponManualFailCount(count,syncFailCount,Long.parseLong(batchPO.getBizCode()));

            //更新发券状态
            couponManualService.updateTaskStatus(Long.parseLong(batchPO.getBizCode()),CouponManualTaskStatusEnum.TASK_STATUS_PART_FAIL.getCode().byteValue());

        }


    }


}
