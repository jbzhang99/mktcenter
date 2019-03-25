package com.bizvane.couponservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.centerstageservice.rpc.StoreServiceRpc;
import com.bizvane.couponfacade.enums.SendTypeEnum;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.po.CouponEntityPO;
import com.bizvane.couponfacade.models.po.CouponEntityPOExample;
import com.bizvane.couponfacade.models.po.CouponStatusLogPO;
import com.bizvane.couponfacade.models.vo.*;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.bizvane.couponfacade.utils.TimeUtils;
import com.bizvane.couponservice.common.constants.SysResponseEnum;
import com.bizvane.couponservice.common.constants.SystemConstants;
import com.bizvane.couponservice.common.utils.BaseData;
import com.bizvane.couponservice.mappers.CouponDefinitionPOMapper;
import com.bizvane.couponservice.mappers.CouponEntityPOMapper;
import com.bizvane.couponservice.mappers.CouponStatusLogPOMapper;
import com.bizvane.couponservice.service.CouponManualService;
import com.bizvane.couponservice.service.CouponService;
import com.bizvane.couponservice.service.SendCouponService;
import com.bizvane.members.facade.service.api.WxChannelInfoApiService;
import com.bizvane.members.facade.vo.WxChannelAndMemberVo;
import com.bizvane.members.facade.vo.WxChannelInfoVo;
import com.bizvane.messagefacade.interfaces.WechatCouponServiceFeign;
import com.bizvane.messagefacade.models.vo.CouponMessageVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.wechatfacade.interfaces.WxPublicServiceFeign;
import com.bizvane.wechatfacade.models.po.WxPublicPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    private static Logger logger = LoggerFactory.getLogger(CouponServiceImpl.class);

    @Autowired
    private CouponEntityPOMapper couponEntityPOMapper;

    @Autowired
    private CouponStatusLogPOMapper couponStatusLogPOMapper;

    @Autowired
    private WechatCouponServiceFeign wechatCouponServiceFeign;
    @Autowired
    private CouponDefinitionPOMapper couponDefinitionPOMapper;

    @Autowired
    private WxChannelInfoApiService wxChannelInfoApiService;

    @Autowired
    private SendCouponService sendCouponService;

    @Autowired
    private StoreServiceRpc storeServiceRpc;

    @Autowired
    private CouponManualService couponManualService;

    @Autowired
    private WxPublicServiceFeign wxPublicServiceFeign;


    /**
     * 线上使用优惠券
     *
     * @param param
     * @return
     */
    @Override
    public ResponseData<String> onlineUse(CouponOnlineUseRequestVO param) {
        logger.info("enter CouponServiceImpl onlineUse method");

        ResponseData<String> responseData = new ResponseData<>();

        String couponCode = param.getCouponCode();
        String useBusinessCode = param.getUseBusinessCode();

        if (StringUtils.isBlank(couponCode)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_CODE_NOT_NULL.getMessage());
            return responseData;
        }


        //查询券实例
        CouponEntityPO couponEntityPO = findCouponEntityPO(couponCode);
        if (null == couponEntityPO) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_NOT_EXIST.getMessage());
            return responseData;
        }

        if (couponEntityPO.getCouponStatus().equals(SystemConstants.COUPON_STATUS_USED)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_USED.getMessage());
            return responseData;
        }

        if (couponEntityPO.getCouponStatus().equals(SystemConstants.COUPON_STATUS_OVERDUE)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_EXPIRED.getMessage());
            return responseData;
        }

        try {
            //判断券是否今天可用
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Date validDateStart = couponEntityPO.getValidDateStart();
            Date startDate = format.parse(format.format(validDateStart));
            Date today = format.parse(format.format(new Date()));

            if (today.getTime() < startDate.getTime()) {
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage(SysResponseEnum.COUPON_NOT_VALID.getMessage());
                return responseData;
            }

        } catch (Exception e) {
            logger.info("enter CouponServiceImpl use  method ! date format error");
        }


        //手动发券，更新核销数量，券收益，优惠金额
        if (couponEntityPO.getSendType().equals(SendTypeEnum.SEND_COUPON_BATCH.getCode())) {

            couponManualService.updateCouponManualCount(couponEntityPO.getUseStoreId(), couponEntityPO.getSendBusinessId(), param.getProfitMoney(), param.getDiscountMoney());

        }

        //更新券实例信息
        couponEntityPO.setUseBusinessCode(useBusinessCode);
        couponEntityPO.setUseType(SystemConstants.COUPON_USE_TYPE_ONLINE);
        couponEntityPO.setCouponStatus(SystemConstants.COUPON_STATUS_USED);
        couponEntityPO.setUseTime(TimeUtils.getNowTime());
        couponEntityPO.setModifiedDate(TimeUtils.getNowTime());
        couponEntityPO.setIsUse(SystemConstants.COUPON_DEFINITION_STATUS_USE);
        couponEntityPO.setUseFrom(param.getUseFrom());
        couponEntityPO.setStaffCode(param.getStaffCode());
        logger.info("enter semd getTransferSend" + couponEntityPO.getCouponCode() + JSONObject.toJSONString(couponEntityPO));
        couponEntityPOMapper.updateByPrimaryKeySelective(couponEntityPO);


        //如果是全渠道  也线下核销 
        CouponDefinitionPO definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(Long.valueOf(couponEntityPO.getCouponDefinitionId()));


        logger.info("enter semd getTransferSend", couponEntityPO.getCouponCode() + JSONObject.toJSONString(couponEntityPO));
        // 如果是转增有奖奖券 
        if (couponEntityPO.getTransferSend() != null && couponEntityPO.getTransferSend()) {
            SendCouponSimpleRequestVO sendVO = new SendCouponSimpleRequestVO();
            sendVO.setMemberCode(couponEntityPO.getTransferMemberCode());
            sendVO.setCouponDefinitionId(couponEntityPO.getTransferCouponDefinitionId());
            sendVO.setSendType(couponEntityPO.getSendType());
            sendVO.setSendBussienId(couponEntityPO.getSendBusinessId());
            sendVO.setBusinessName(couponEntityPO.getBusinessName());
            sendVO.setBrandId(couponEntityPO.getSysBrandId());
            sendVO.setCompanyId(couponEntityPO.getSysCompanyId());
            sendVO.setBrandCode(couponEntityPO.getBrandCode());
            sendCouponService.simple(sendVO);
        }

        //记录券状态更新日志
        CouponStatusLogPO couponStatusLogPO = new CouponStatusLogPO();
        couponStatusLogPO.setCouponEntityId(couponEntityPO.getCouponEntityId());
        couponStatusLogPO.setCouponCode(couponCode);
        couponStatusLogPO.setBusinessType(SystemConstants.COUPON_STATUS_CHANGE_BUSINESS_TYPE_USE);
        couponStatusLogPO.setBusinessCode(useBusinessCode);
        couponStatusLogPO.setBusinessTime(TimeUtils.getNowTime());
        couponStatusLogPO.setCreateDate(TimeUtils.getNowTime());

        couponStatusLogPOMapper.insertSelective(couponStatusLogPO);

        //查询会员信息
        WxChannelInfoVo channelVO = new WxChannelInfoVo();
        channelVO.setMemberCode(couponEntityPO.getMemberCode());
        channelVO.setBrandId(couponEntityPO.getSysBrandId());
        channelVO.setMiniProgram(1);
        ResponseData<WxChannelAndMemberVo> channelResult = wxChannelInfoApiService.getWxChannelInfoAndMemberInfo(channelVO);

        WxChannelInfoVo channelInfoVo = channelResult.getData().getWxChannelInfoVo();

        //线上发送核销模板消息
        CouponMessageVO messageVO = new CouponMessageVO();

        messageVO.setMemberCode(couponEntityPO.getMemberCode());
        messageVO.setCouponCode(couponCode);
        messageVO.setCouponName(couponEntityPO.getCouponName());
        messageVO.setPreferentialType(couponEntityPO.getPreferentialType() + "");
        messageVO.setDenomination(couponEntityPO.getMoney() + "");
        messageVO.setUseTime(couponEntityPO.getUseTime());
        messageVO.setValidDateStart(couponEntityPO.getValidDateStart());
        messageVO.setValidDateEnd(couponEntityPO.getValidDateEnd());
        messageVO.setMemberName(channelInfoVo.getName());
        messageVO.setOrderNo(useBusinessCode);
        messageVO.setSysBrandId(couponEntityPO.getSysBrandId());
        messageVO.setMemberPhone(channelInfoVo.getPhone());
        messageVO.setSendWxmember(channelInfoVo.getFocus() + "");

        messageVO.setSysCompanyId(channelInfoVo.getSysCompanyId());

        ResponseData<WxPublicPO> publicPO = wxPublicServiceFeign.getWxPublicBySysBrandId(couponEntityPO.getSysBrandId());
        if (publicPO.getData() != null) {
            messageVO.setNickName(publicPO.getData().getNickName());
        }

        wechatCouponServiceFeign.couponUse(messageVO);
        return responseData;
    }

    /**
     * 线下使用优惠券
     *
     * @param param
     * @return
     */
    @Override
    public ResponseData<Integer> offlineUse(CouponOfflineUseRequestVO param) {
        logger.info("enter CouponServiceImpl offlineUse method");
        ResponseData<Integer> responseData = new ResponseData<>();

        if (null == param) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.SYSTEM_DATA_NOT_EMPTY.getMessage());
            return responseData;
        }

        if (StringUtils.isBlank(param.getCouponCode())) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_CODE_NOT_NULL.getMessage());
            return responseData;
        }
   /* if(null == param.getSysBrandId()){
      responseData.setCode(SysResponseEnum.FAILED.getCode());
      responseData.setMessage(SysResponseEnum.SYS_BRAND_ID_NOT_NULL.getMessage());
      return responseData;
    }*/

        CouponEntityPO couponEntityPO = findCouponEntityPO(param.getCouponCode());
        if (null == couponEntityPO) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_NOT_EXIST.getMessage());
            return responseData;
        }

        if (couponEntityPO.getCouponStatus().equals(SystemConstants.COUPON_STATUS_USED)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_USED.getMessage());
            return responseData;
        }
        if (couponEntityPO.getCouponStatus().equals(SystemConstants.COUPON_STATUS_OVERDUE)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_EXPIRED.getMessage());
            return responseData;
        }

        try {
            //判断券是否今天可用
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Date validDateStart = couponEntityPO.getValidDateStart();
            Date startDate = format.parse(format.format(validDateStart));
            Date today = format.parse(format.format(new Date()));

            if (today.getTime() < startDate.getTime()) {
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage(SysResponseEnum.COUPON_NOT_VALID.getMessage());
                return responseData;
            }

        } catch (Exception e) {
            logger.info("enter CouponServiceImpl use  method ! date format error");
        }


        //手动发券，更新核销数量，券收益，优惠金额
        if (couponEntityPO.getSendType().equals(SendTypeEnum.SEND_COUPON_BATCH.getCode())) {

            couponManualService.updateCouponManualCount(couponEntityPO.getUseStoreId(), couponEntityPO.getSendBusinessId(), param.getProfitMoney(), param.getDiscountMoney());

        }

        //更新券实例信息
        couponEntityPO.setUseType(SystemConstants.COUPON_USE_TYPE_OFFLINE);
        couponEntityPO.setCouponStatus(SystemConstants.COUPON_STATUS_USED);
        couponEntityPO.setUseTime(TimeUtils.getNowTime());
        couponEntityPO.setUseBusinessCode(param.getBusinessCode());
        couponEntityPO.setUseStoreId(param.getUseStoreId());
        couponEntityPO.setModifiedDate(TimeUtils.getNowTime());
        couponEntityPO.setIsUse(SystemConstants.COUPON_DEFINITION_STATUS_USE);
        couponEntityPO.setUseFrom(param.getUseFrom());
        couponEntityPO.setStaffCode(param.getStaffCode());
        logger.info("enter semd getTransferSend" + couponEntityPO.getCouponCode() + JSONObject.toJSONString(couponEntityPO));
        couponEntityPOMapper.updateByPrimaryKeySelective(couponEntityPO);
        // 如果是转增有奖奖券 
        if (couponEntityPO.getTransferSend() != null && couponEntityPO.getTransferSend()) {
            SendCouponSimpleRequestVO sendVO = new SendCouponSimpleRequestVO();
            sendVO.setMemberCode(couponEntityPO.getTransferMemberCode());
            sendVO.setCouponDefinitionId(couponEntityPO.getTransferCouponDefinitionId());
            sendVO.setSendType(couponEntityPO.getSendType());
            sendVO.setSendBussienId(couponEntityPO.getSendBusinessId());
            sendVO.setBusinessName(couponEntityPO.getBusinessName());
            sendVO.setBrandId(couponEntityPO.getSysBrandId());
            sendVO.setCompanyId(couponEntityPO.getSysCompanyId());
            sendVO.setBrandCode(couponEntityPO.getBrandCode());
            sendCouponService.simple(sendVO);
        }

        //插入日志
        CouponStatusLogPO couponStatusLogPO = new CouponStatusLogPO();
        couponStatusLogPO.setCouponEntityId(couponEntityPO.getCouponEntityId());
        couponStatusLogPO.setCouponCode(param.getCouponCode());
        couponStatusLogPO.setBusinessType(SystemConstants.COUPON_STATUS_CHANGE_BUSINESS_TYPE_USE);
        couponStatusLogPO.setBusinessCode(param.getBusinessCode());
        couponStatusLogPO.setBusinessTime(TimeUtils.getNowTime());
        couponStatusLogPO.setCreateDate(TimeUtils.getNowTime());

        couponStatusLogPOMapper.insertSelective(couponStatusLogPO);

        return responseData;
    }


    /**
     * 全渠道使用优惠券
     *
     * @param requestVO
     * @return
     */
    @Override
    public ResponseData<String> allUse(CouponAllUseRequestVO requestVO) {
        logger.info("enter CouponServiceImpl allUse method");

        ResponseData<String> responseData = new ResponseData<>();

        if (null == requestVO) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.SYSTEM_DATA_NOT_EMPTY.getMessage());
            return responseData;
        }

        if (StringUtils.isBlank(requestVO.getCouponCode())) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_CODE_NOT_NULL.getMessage());
            return responseData;
        }


        //查询券实例
        CouponEntityPO couponEntityPO = findCouponEntityPO(requestVO.getCouponCode());
        if (null == couponEntityPO) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_NOT_EXIST.getMessage());
            return responseData;
        }

        if (couponEntityPO.getCouponStatus().equals(SystemConstants.COUPON_STATUS_USED)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_USED.getMessage());
            return responseData;
        }

        if (couponEntityPO.getCouponStatus().equals(SystemConstants.COUPON_STATUS_OVERDUE)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_EXPIRED.getMessage());
            return responseData;
        }

        try {
            //判断券是否今天可用
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Date validDateStart = couponEntityPO.getValidDateStart();
            Date startDate = format.parse(format.format(validDateStart));
            Date today = format.parse(format.format(new Date()));

            if (today.getTime() < startDate.getTime()) {
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage(SysResponseEnum.COUPON_NOT_VALID.getMessage());
                return responseData;
            }

        } catch (Exception e) {
            logger.info("enter CouponServiceImpl use  method ! date format error");
        }


        //手动发券，更新核销数量，券收益，优惠金额
        if (couponEntityPO.getSendType().equals(SendTypeEnum.SEND_COUPON_BATCH.getCode())) {

            couponManualService.updateCouponManualCount(couponEntityPO.getUseStoreId(), couponEntityPO.getSendBusinessId(), requestVO.getProfitMoney(), requestVO.getDiscountMoney());

        }

        //更新券实例
        couponEntityPO.setUseType(SystemConstants.COUPON_USE_TYPE_ALL);
        couponEntityPO.setCouponStatus(SystemConstants.COUPON_STATUS_USED);
        couponEntityPO.setUseTime(TimeUtils.getNowTime());
        couponEntityPO.setModifiedDate(TimeUtils.getNowTime());
        couponEntityPO.setIsUse(SystemConstants.COUPON_DEFINITION_STATUS_USE);
        couponEntityPO.setUseFrom(requestVO.getUseFrom());
        couponEntityPO.setStaffCode(requestVO.getStaffCode());

        couponEntityPOMapper.updateByPrimaryKeySelective(couponEntityPO);
        logger.info("enter semd getTransferSend", couponEntityPO.getCouponCode() + JSONObject.toJSONString(couponEntityPO));
        // 如果是转增有奖奖券 
        if (couponEntityPO.getTransferSend() != null && couponEntityPO.getTransferSend()) {
            SendCouponSimpleRequestVO sendVO = new SendCouponSimpleRequestVO();
            sendVO.setMemberCode(couponEntityPO.getTransferMemberCode());
            sendVO.setCouponDefinitionId(couponEntityPO.getTransferCouponDefinitionId());
            sendVO.setSendType(couponEntityPO.getSendType());
            sendVO.setSendBussienId(couponEntityPO.getSendBusinessId());
            sendVO.setBusinessName(couponEntityPO.getBusinessName());
            sendVO.setBrandId(couponEntityPO.getSysBrandId());
            sendVO.setCompanyId(couponEntityPO.getSysCompanyId());
            sendVO.setBrandCode(couponEntityPO.getBrandCode());
            sendCouponService.simple(sendVO);
        }

        //记录券状态更新日志
        CouponStatusLogPO couponStatusLogPO = new CouponStatusLogPO();
        couponStatusLogPO.setCouponEntityId(couponEntityPO.getCouponEntityId());
        couponStatusLogPO.setCouponCode(requestVO.getCouponCode());
        couponStatusLogPO.setBusinessType(SystemConstants.COUPON_STATUS_CHANGE_BUSINESS_TYPE_USE);
        couponStatusLogPO.setBusinessTime(TimeUtils.getNowTime());
        couponStatusLogPO.setCreateDate(TimeUtils.getNowTime());

        couponStatusLogPOMapper.insertSelective(couponStatusLogPO);

        return responseData;
    }


    @Override
    public ResponseData<Object> cancelUse(CouponCancelUseRequestVO vo) {
        logger.info("enter CouponServiceImpl cancelUse method");
        ResponseData<Object> responseData = new ResponseData<>();

        String couponCode = vo.getCouponCode();
        String memberCode = vo.getMemberCode();

        ResponseData<CouponEntityPO> findCouponEntityResult = this.findCouponEntity(couponCode, memberCode);
        if (SysResponseEnum.SUCCESS.getCode() != findCouponEntityResult.getCode()) {
            responseData.setCode(findCouponEntityResult.getCode());
            responseData.setMessage(findCouponEntityResult.getMessage());
            return responseData;
        }

        CouponEntityPO couponEntityPO = findCouponEntityResult.getData();

        couponEntityPO.setUseType(null);
        couponEntityPO.setCouponStatus(SystemConstants.COUPON_STATUS_UNUSED);
        couponEntityPO.setUseTime(null);
        couponEntityPO.setUseBusinessCode(null);
        couponEntityPO.setUseStoreId(null);
        couponEntityPO.setModifiedDate(new Date());

        couponEntityPOMapper.updateByPrimaryKey(couponEntityPO);

        CouponStatusLogPO couponStatusLogPO = new CouponStatusLogPO();
        couponStatusLogPO.setCouponEntityId(couponEntityPO.getCouponEntityId());
        couponStatusLogPO.setCouponCode(couponCode);
        couponStatusLogPO.setBusinessType(SystemConstants.COUPON_STATUS_CHANGE_BUSINESS_TYPE_CANCEL_USE);
        couponStatusLogPO.setBusinessTime(new Date());
        couponStatusLogPO.setCreateDate(new Date());

        couponStatusLogPOMapper.insertSelective(couponStatusLogPO);
        return responseData;
    }

    /**
     * 通过memberCode查询券集合
     *
     * @param vo
     * @param pageFormUtil
     * @return
     */
    @Override
    public ResponseData<PageInfo<CouponEntityAndDefinitionVO>> getCouponListByMemeberCode(CouponListByMemberCodeRequestVO vo, PageFormUtil pageFormUtil) {
        logger.info("enter CouponServiceImpl getCouponListByMemeberCode method");


        ResponseData<PageInfo<CouponEntityAndDefinitionVO>> result = new ResponseData<>();
        PageHelper.startPage(pageFormUtil.getPageNumber(), pageFormUtil.getPageSize());

        List<CouponEntityAndDefinitionVO> list = couponEntityPOMapper.getCouponListByMemeberCode(vo);

        PageInfo pageInfo = new PageInfo(list);
        result.setData(pageInfo);

        return result;
    }

    /**
     * 根据券code查询券详情
     *
     * @param couponCode
     * @return
     */
    @Override
    public ResponseData<CouponDetailModelVO> findCouponByCouponCode(String couponCode) {
        logger.info("enter CouponServiceImpl findCouponByCouponCode method");

        ResponseData<CouponDetailModelVO> responseData = new ResponseData<>();

        CouponEntityPOExample couponEntityPOExample = new CouponEntityPOExample();
        CouponEntityPOExample.Criteria criteria = couponEntityPOExample.createCriteria();
        criteria.andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE);
        criteria.andCouponCodeEqualTo(couponCode);


        List<CouponEntityPO> list = couponEntityPOMapper.selectByExample(couponEntityPOExample);

        if (CollectionUtils.isEmpty(list)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
            return responseData;
        }

        CouponDefinitionPO definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(Long.parseLong(list.get(0).getCouponDefinitionId()));

        CouponDetailModelVO modelVO = new CouponDetailModelVO();
        modelVO.setCouponDefinitionPO(definitionPO);
        modelVO.setCouponEntityPO(list.get(0));

        responseData.setData(modelVO);

        return responseData;
    }

    /**
     * 根据券号和会员号查找券
     *
     * @param couponCode
     * @param memberCode
     * @return
     */
    @Override
    public ResponseData<CouponEntityPO> findCouponEntity(String couponCode, String memberCode) {
        logger.info("enter CouponServiceImpl findCouponEntity method param:CouponCode:{},memberCode:{}", couponCode, memberCode);

        ResponseData<CouponEntityPO> responseData = new ResponseData<>();

        CouponEntityPOExample couponEntityPOExample = new CouponEntityPOExample();
        CouponEntityPOExample.Criteria criteria = couponEntityPOExample.createCriteria();
        criteria.andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE);
        criteria.andMemberCodeEqualTo(memberCode);
        criteria.andCouponCodeEqualTo(couponCode);

        List<CouponEntityPO> list = couponEntityPOMapper.selectByExample(couponEntityPOExample);

        if (CollectionUtils.isEmpty(list)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_NOT_EXIST.getMessage());
            return responseData;
        }

        responseData.setData(list.get(0));

        return responseData;
    }

    /**
     * 根据memberCode查询券发送相关数量
     *
     * @param memberCode
     * @return
     */
    @Override
    public ResponseData<CouponFindCouponCountResponseVO> findCouponCountByMemberCode(String memberCode) {
        logger.info("enter CouponServiceImpl findCouponCountByMemberCode method");

        ResponseData<CouponFindCouponCountResponseVO> responseData = new ResponseData<>();

        if (null == memberCode) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("会员code不能为空");
            return responseData;
        }

        CouponFindCouponCountResponseVO vo = new CouponFindCouponCountResponseVO();

        CouponEntityPOExample couponEntityPOExample = new CouponEntityPOExample();
        CouponEntityPOExample.Criteria criteria = couponEntityPOExample.createCriteria();
        criteria.andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE);
        criteria.andMemberCodeEqualTo(memberCode);

        List<CouponEntityPO> list = couponEntityPOMapper.selectByExample(couponEntityPOExample);

        if (CollectionUtils.isNotEmpty(list)) {
            Long couponSum = 0L;
            Long couponUsedSum = 0L;
            Long couponUnusedSum = 0L;
            Long couponOverdueSum = 0L;

            for (CouponEntityPO couponEntityPO : list) {
                Byte couponStatus = couponEntityPO.getCouponStatus();

                Boolean exist = Boolean.TRUE;
                if (SystemConstants.COUPON_STATUS_USED.equals(couponStatus)) {
                    couponUsedSum++;
                } else if (SystemConstants.COUPON_STATUS_UNUSED.equals(couponStatus)) {
                    couponUnusedSum++;
                } else if (SystemConstants.COUPON_STATUS_OVERDUE.equals(couponStatus)) {
                    couponOverdueSum++;
                } else {
                    exist = Boolean.FALSE;
                }

                if (exist) {
                    couponSum++;
                }
            }
            vo.setCouponOverdueSum(couponOverdueSum);
            vo.setCouponSum(couponSum);
            vo.setCouponUnusedSum(couponUnusedSum);
            vo.setCouponUsedSum(couponUsedSum);

        }

        responseData.setData(vo);

        return responseData;
    }

    /**
     * 查询券数量
     *
     * @return
     */
    @Override
    public ResponseData<CouponFindCouponCountResponseVO> findCouponCountByDate(CouponEntityVO param) {
        logger.info("enter CouponServiceImpl findCouponCountByDate method");
        ResponseData<CouponFindCouponCountResponseVO> responseData = new ResponseData<>();

        if (null == param.getSendBusinessId()) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_SEND_BUSINESS_ID_NOT_NULL.getMessage());
            return responseData;
        }
        if (null == param.getSendType()) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_SEND_TYPE_NOT_NULL.getMessage());
            return responseData;
        }
        if (null == param.getSysBrandId()) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.SYS_BRAND_ID_NOT_NULL.getMessage());
            return responseData;
        }

        CouponFindCouponCountResponseVO vo = new CouponFindCouponCountResponseVO();

        Long couponSum = couponEntityPOMapper.findCouponAllCount(param.getSendBusinessId(), param.getSendType(), param.getSysBrandId(),
                SystemConstants.COUPON_STATUS_UNUSED, SystemConstants.COUPON_STATUS_USED, SystemConstants.COUPON_STATUS_OVERDUE,
                param.getDtStart(), param.getDtEnd(), null);

        Long couponUnusedSum = couponEntityPOMapper.findCouponCount(param.getSendBusinessId(), param.getSendType(), param.getSysBrandId(),
                SystemConstants.COUPON_STATUS_UNUSED,
                param.getDtStart(), param.getDtEnd(), null);

        Long couponUsedSum = couponEntityPOMapper.findCouponCount(param.getSendBusinessId(), param.getSendType(), param.getSysBrandId(),
                SystemConstants.COUPON_STATUS_USED,
                param.getDtStart(), param.getDtEnd(), null);

        Long couponOverdueSum = couponEntityPOMapper.findCouponCount(param.getSendBusinessId(), param.getSendType(), param.getSysBrandId(),
                SystemConstants.COUPON_STATUS_OVERDUE,
                param.getDtStart(), param.getDtEnd(), null);

        BigDecimal money = couponEntityPOMapper.findUseBusinessAmountSum(param.getSendBusinessId(), param.getSendType(), param.getSysBrandId(),
                SystemConstants.COUPON_STATUS_USED,
                param.getDtStart(), param.getDtEnd(), null);


        vo.setCouponOverdueSum(couponOverdueSum);
        vo.setCouponSum(couponSum);
        vo.setCouponUnusedSum(couponUnusedSum);
        vo.setCouponUsedSum(couponUsedSum);
        vo.setMoney(money == null ? BigDecimal.ZERO : money);

        responseData.setData(vo);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());

        return responseData;
    }


    /**
     * 统计券使用状况
     *
     * @param sendBusinessId
     * @param sendType
     * @param sysBrandId
     * @return
     */
    @Override
    public ResponseData<CouponFindCouponCountResponseVO> findCouponCountBySendBusinessId(Long sendBusinessId, String sendType, Long sysBrandId) {
        logger.info("enter CouponServiceImpl findCouponCountBySendBusinessId method");
        ResponseData<CouponFindCouponCountResponseVO> responseData = new ResponseData<>();

        if (null == sendBusinessId) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_SEND_BUSINESS_ID_NOT_NULL.getMessage());
            return responseData;
        }
        if (StringUtils.isBlank(sendType)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_SEND_TYPE_NOT_NULL.getMessage());
            return responseData;
        }
        if (null == sysBrandId) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.SYS_BRAND_ID_NOT_NULL.getMessage());
            return responseData;
        }


        CouponStatusEntitySuccessVO successVO = new CouponStatusEntitySuccessVO();
        successVO.setCouponStatusUsed(SystemConstants.COUPON_STATUS_USED);
        successVO.setCouponStatusUnused(SystemConstants.COUPON_STATUS_UNUSED);
        successVO.setCouponStatusOverdue(SystemConstants.COUPON_STATUS_OVERDUE);


        CouponFindCouponCountResponseVO vo = couponEntityPOMapper.findCouponCountByStatus(sendBusinessId, sendType, sysBrandId, successVO);


        /*Long couponSum = couponEntityPOMapper.findCouponAllCountByStatus(sendBusinessId, sendType, sysBrandId,
                SystemConstants.COUPON_STATUS_UNUSED, SystemConstants.COUPON_STATUS_USED, SystemConstants.COUPON_STATUS_OVERDUE);*/
        //总数
        Long couponSum = vo.getCouponOverdueSum() + vo.getCouponUnusedSum() + vo.getCouponUsedSum();


        //收益
        BigDecimal money = couponEntityPOMapper.findBusinessAmountSumUsed(sendBusinessId, sendType, sysBrandId, SystemConstants.COUPON_STATUS_USED);

        vo.setCouponSum(couponSum);

        vo.setMoney(money == null ? BigDecimal.ZERO : money);

        responseData.setData(vo);

        return responseData;
    }


    /**
     * 发券量CouponSum,核销量couponUsedSum,核销率
     *
     * @param sendBusinessId
     * @param sendType
     * @param sysBrandId
     * @return
     */
    @Override
    public CouponFindCouponCountResponseVO findCouponCountbatchSend(Long batchSendId, Long sendBusinessId, String sendType, Long sysBrandId) {
        logger.info("enter CouponServiceImpl findCouponCountBySendBusinessId method");

        CouponStatusEntitySuccessVO successVO = new CouponStatusEntitySuccessVO();
        successVO.setCouponStatusUsed(SystemConstants.COUPON_STATUS_USED);
        successVO.setCouponStatusUnused(SystemConstants.COUPON_STATUS_UNUSED);
        successVO.setCouponStatusOverdue(SystemConstants.COUPON_STATUS_OVERDUE);


        CouponFindCouponCountResponseVO vo = couponEntityPOMapper.findCouponCountbatchSend(batchSendId, sendBusinessId, sendType, sysBrandId, successVO);

        //总数
        Long couponSum = vo.getCouponOverdueSum() + vo.getCouponUnusedSum() + vo.getCouponUsedSum();
        vo.setCouponSum(couponSum);
        //核销率
        vo.setCouponRate(BaseData.growthNot(vo.getCouponUsedSum() + "", couponSum + ""));

        return vo;
    }


    /**
     * 转赠
     *
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Integer> givenCoupon(CouponEntityVO vo) {
        logger.info("enter CouponServiceImpl givenCoupon method param:CouponEntityVO:{}", JSONObject.toJSONString(vo));

        ResponseData<Integer> responseData = new ResponseData<>();

        String couponCode = vo.getCouponCode();
        String oldMemberCode = vo.getOldMemberCode();
        String newMemberCode = vo.getNewMemberCode();
        String useBusinessCode = vo.getUseBusinessCode();
        String description = vo.getDescription();

        if (null == vo) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.SYSTEM_DATA_NOT_EMPTY.getMessage());
            return responseData;
        }

        if (StringUtils.isBlank(couponCode)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_CODE_NOT_NULL.getMessage());
            return responseData;
        }
        if (StringUtils.isBlank(oldMemberCode) || StringUtils.isBlank(newMemberCode)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_MEMBER_CODE_NOT_NULL.getMessage());
            return responseData;
        }


        ResponseData<CouponEntityPO> findCouponEntityResult = this.findCouponEntity(couponCode, oldMemberCode);

        if (SysResponseEnum.SUCCESS.getCode() != findCouponEntityResult.getCode()) {
            responseData.setCode(findCouponEntityResult.getCode());
            responseData.setMessage(findCouponEntityResult.getMessage());
            return responseData;
        }

        CouponEntityPO couponEntityPO = findCouponEntityResult.getData();

        //couponEntityPO.setSendType(SendTypeEnum.SEND_COUPON_GIVE.getCode());
        couponEntityPO.setUseTime(TimeUtils.getNowTime());
        couponEntityPO.setMemberCode(newMemberCode);
        couponEntityPO.setTransferMemberCode(oldMemberCode);//原来会员

        couponEntityPO.setModifiedDate(TimeUtils.getNowTime());
        couponEntityPO.setGive(SystemConstants.COUPON_UNGIVE);
        logger.info("enter semd getTransferSend" + couponEntityPO.getCouponCode() + JSONObject.toJSONString(couponEntityPO));
        couponEntityPOMapper.updateByPrimaryKeySelective(couponEntityPO);

        CouponStatusLogPO couponStatusLogPO = new CouponStatusLogPO();
        couponStatusLogPO.setCouponEntityId(couponEntityPO.getCouponEntityId());
        couponStatusLogPO.setCouponCode(couponCode);
        couponStatusLogPO.setBusinessCode(useBusinessCode);
        couponStatusLogPO.setBusinessType((byte) Integer.parseInt(SendTypeEnum.SEND_COUPON_GIVE.getCode()));
        couponStatusLogPO.setBusinessTime(TimeUtils.getNowTime());
        couponStatusLogPO.setCreateDate(TimeUtils.getNowTime());

        couponStatusLogPOMapper.insertSelective(couponStatusLogPO);

        //查询券定义信息
        CouponDefinitionPO definitionPOResult = couponDefinitionPOMapper.selectByPrimaryKey(Long.parseLong(couponEntityPO.getCouponDefinitionId()));

        //查询会员信息
        WxChannelInfoVo channelVO = new WxChannelInfoVo();
        channelVO.setMemberCode(oldMemberCode);
        channelVO.setBrandId(couponEntityPO.getSysBrandId());
        channelVO.setMiniProgram(1);
        ResponseData<WxChannelAndMemberVo> channelResult = wxChannelInfoApiService.getWxChannelInfoAndMemberInfo(channelVO);
        WxChannelInfoVo channelInfoVo = channelResult.getData().getWxChannelInfoVo();

        //查询会员信息
        WxChannelInfoVo channelVOnew = new WxChannelInfoVo();
        channelVOnew.setMemberCode(newMemberCode);
        channelVOnew.setBrandId(couponEntityPO.getSysBrandId());
        channelVOnew.setMiniProgram(1);
        ResponseData<WxChannelAndMemberVo> channelResultnew = wxChannelInfoApiService.getWxChannelInfoAndMemberInfo(channelVOnew);
        WxChannelInfoVo channelResultnewVO = channelResultnew.getData().getWxChannelInfoVo();
//        }
        return responseData;
    }


    /**
     * 锁定
     *
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Object> lock(CouponEntityVO vo) {
        logger.info("enter CouponServiceImpl lock method");
        ResponseData<Object> responseData = new ResponseData<>();

        String couponCode = vo.getCouponCode();
        String memberCode = vo.getMemberCode();

        ResponseData<CouponEntityPO> findCouponEntityResult = this.findCouponEntity(couponCode, memberCode);
        if (SysResponseEnum.SUCCESS.getCode() != findCouponEntityResult.getCode()) {
            responseData.setCode(findCouponEntityResult.getCode());
            responseData.setMessage(findCouponEntityResult.getMessage());
            return responseData;
        }

        CouponEntityPO couponEntityPO = findCouponEntityResult.getData();

        couponEntityPO.setIsLock(SystemConstants.COUPON_STATUS_CHANGE_IS_LOCK);
        couponEntityPO.setUseTime(TimeUtils.getNowTime());
        couponEntityPO.setModifiedDate(TimeUtils.getNowTime());
        logger.info("enter semd getTransferSend" + couponEntityPO.getCouponCode() + JSONObject.toJSONString(couponEntityPO));
        couponEntityPOMapper.updateByPrimaryKeySelective(couponEntityPO);

        return responseData;
    }

    /**
     * 解锁
     *
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Object> unlock(CouponEntityVO vo) {
        logger.info("enter CouponServiceImpl unlock method");
        ResponseData<Object> responseData = new ResponseData<>();

        String couponCode = vo.getCouponCode();
        String memberCode = vo.getMemberCode();

        ResponseData<CouponEntityPO> findCouponEntityResult = this.findCouponEntity(couponCode, memberCode);
        if (SysResponseEnum.SUCCESS.getCode() != findCouponEntityResult.getCode()) {
            responseData.setCode(findCouponEntityResult.getCode());
            responseData.setMessage(findCouponEntityResult.getMessage());
            return responseData;
        }

        CouponEntityPO couponEntityPO = findCouponEntityResult.getData();

        couponEntityPO.setIsLock(SystemConstants.COUPON_STATUS_CHANGE_IS_UNLOCK);
        couponEntityPO.setUseTime(TimeUtils.getNowTime());
        couponEntityPO.setModifiedDate(TimeUtils.getNowTime());
        logger.info("enter semd getTransferSend" + couponEntityPO.getCouponCode() + JSONObject.toJSONString(couponEntityPO));
        couponEntityPOMapper.updateByPrimaryKeySelective(couponEntityPO);

        return responseData;
    }

    /**
     * 券过期
     *
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Object> couponExpire(CouponEntityVO vo) {
        logger.info("enter CouponServiceImpl couponExpire method");
        ResponseData<Object> responseData = new ResponseData<>();

        String couponCode = vo.getCouponCode();
        String memberCode = vo.getMemberCode();
        Long sysBrandId = vo.getSysBrandId();
        String useBusinessCode = vo.getUseBusinessCode();


        if (StringUtils.isBlank(couponCode)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_CODE_NOT_NULL.getMessage());
            return responseData;
        }

        if (StringUtils.isBlank(memberCode)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_MEMBER_CODE_NOT_NULL.getMessage());
            return responseData;
        }

        if (null == sysBrandId) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.SYS_BRAND_ID_NOT_NULL.getMessage());
            return responseData;
        }

        if (StringUtils.isBlank(useBusinessCode)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.USE_BUSINESS_CODE_NOT_NULL.getMessage());
            return responseData;
        }


        ResponseData<CouponEntityPO> findCouponEntityResult = this.findCouponEntity(couponCode, memberCode);
        if (SysResponseEnum.SUCCESS.getCode() != findCouponEntityResult.getCode()) {
            responseData.setCode(findCouponEntityResult.getCode());
            responseData.setMessage(findCouponEntityResult.getMessage());
            return responseData;
        }

        CouponEntityPO couponEntityPO = findCouponEntityResult.getData();

        couponEntityPO.setCouponStatus(SystemConstants.COUPON_STATUS_CHANGE_BUSINESS_TYPE_OVERDUE);
        couponEntityPO.setUseTime(TimeUtils.getNowTime());
        couponEntityPO.setModifiedDate(TimeUtils.getNowTime());
        logger.info("enter semd getTransferSend" + couponEntityPO.getCouponCode() + JSONObject.toJSONString(couponEntityPO));
        couponEntityPOMapper.updateByPrimaryKeySelective(couponEntityPO);

        CouponStatusLogPO couponStatusLogPO = new CouponStatusLogPO();
        couponStatusLogPO.setCouponEntityId(couponEntityPO.getCouponEntityId());
        couponStatusLogPO.setCouponCode(couponCode);
        couponStatusLogPO.setBusinessCode(vo.getUseBusinessCode());
        couponStatusLogPO.setBusinessType(SystemConstants.COUPON_STATUS_CHANGE_BUSINESS_TYPE_OVERDUE);
        couponStatusLogPO.setBusinessTime(TimeUtils.getNowTime());
        couponStatusLogPO.setCreateDate(TimeUtils.getNowTime());

        couponStatusLogPOMapper.insertSelective(couponStatusLogPO);

        //查询会员信息
        WxChannelInfoVo channelVO = new WxChannelInfoVo();
        channelVO.setMemberCode(vo.getMemberCode());
        channelVO.setBrandId(vo.getSysBrandId());
        channelVO.setMiniProgram(1);
        ResponseData<WxChannelAndMemberVo> channelResult = wxChannelInfoApiService.getWxChannelInfoAndMemberInfo(channelVO);

        WxChannelInfoVo channelInfoVo = channelResult.getData().getWxChannelInfoVo();

        CouponMessageVO messageVO = new CouponMessageVO();
        messageVO.setMemberCode(vo.getMemberCode());
        messageVO.setCouponCode(vo.getCouponCode());
        messageVO.setCouponName(couponEntityPO.getCouponName());
        messageVO.setPreferentialType(couponEntityPO.getPreferentialType() + "");
        messageVO.setDenomination(couponEntityPO.getMoney() + "");
        messageVO.setValidDateStart(couponEntityPO.getValidDateStart());
        messageVO.setValidDateEnd(couponEntityPO.getValidDateEnd());
        messageVO.setOrderNo(vo.getUseBusinessCode());
        messageVO.setSysBrandId(vo.getSysBrandId());
        messageVO.setMemberName(channelInfoVo.getName());
        messageVO.setMemberPhone(channelInfoVo.getPhone());
        messageVO.setNickName(channelInfoVo.getWxNick());
        messageVO.setSysCompanyId(channelInfoVo.getSysCompanyId());
        wechatCouponServiceFeign.couponExpire(messageVO);

        return responseData;
    }

    /**
     * 根据memberCode查询可使用券列表
     *
     * @param memberCode
     * @return
     */
    @Override
    public ResponseData<List<CouponEntityPO>> getCouponUnusedByMemberCode(String memberCode) {
        logger.info("enter CouponServiceImpl getCouponUnusedByMemberCode method");
        ResponseData<List<CouponEntityPO>> responseData = new ResponseData<>();

        if (StringUtils.isBlank(memberCode)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("会员code不能为空");
            return responseData;
        }
        CouponEntityPOExample entityPOExample = new CouponEntityPOExample();
        entityPOExample.createCriteria().andMemberCodeEqualTo(memberCode)
                .andCouponStatusEqualTo(SystemConstants.COUPON_STATUS_USED)
                .andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE);
        List<CouponEntityPO> entityPOList = couponEntityPOMapper.selectByExample(entityPOExample);
        responseData.setData(entityPOList);
        return responseData;
    }

    /**
     * 根据发券业务单号集合统计券的使用状况
     *
     * @param vo
     * @return
     */
    @Override
    public ResponseData<CouponFindCouponCountResponseVO> findCouponCountByList(CouponEntityVO vo) {
        logger.info("enter CouponServiceImpl findCouponCountByList method");
        ResponseData<CouponFindCouponCountResponseVO> responseData = new ResponseData<>();

        if (CollectionUtils.isEmpty(vo.getSendIdList())) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("传入参数不能为空");
            return responseData;
        }
        Integer sendCount = couponEntityPOMapper.getCountBySendBusinessId(vo.getSendIdList());

        CouponFindCouponCountResponseVO findVO = new CouponFindCouponCountResponseVO();
        findVO.setCouponSum(Long.parseLong(sendCount + ""));
        responseData.setData(findVO);
        return responseData;
    }


    /**
     * 根据发送类型（活动，任务）查询券数量
     *
     * @param sendType
     * @param sysBrandId
     * @return
     */
    @Override
    public ResponseData<CouponFindCouponCountResponseVO> getCountBySendType(String sendType, Long sysBrandId) {
        logger.info("enter CouponServiceImpl getCountBySendType method");
        ResponseData<CouponFindCouponCountResponseVO> responseData = new ResponseData<>();

        if (StringUtils.isBlank(sendType)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_SEND_TYPE_NOT_NULL.getMessage());
            return responseData;
        }
        if (null == sysBrandId) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.SYS_BRAND_ID_NOT_NULL.getMessage());
            return responseData;
        }


        CouponStatusEntitySuccessVO successVO = new CouponStatusEntitySuccessVO();
        successVO.setCouponStatusUsed(SystemConstants.COUPON_STATUS_USED);
        successVO.setCouponStatusUnused(SystemConstants.COUPON_STATUS_UNUSED);
        successVO.setCouponStatusOverdue(SystemConstants.COUPON_STATUS_OVERDUE);

        CouponFindCouponCountResponseVO vo = couponEntityPOMapper.findCouponCountBySendType(sendType, sysBrandId, successVO);

        /*Long couponSum = couponEntityPOMapper.findAllCouponCountBySendType(sendType, sysBrandId,successVO);*/
        //总数
        Long couponSum = vo.getCouponOverdueSum() + vo.getCouponUsedSum() + vo.getCouponUnusedSum();

        BigDecimal money = couponEntityPOMapper.findBusinessAmountSumUsedBySendType(sendType, sysBrandId, SystemConstants.COUPON_STATUS_USED);


        vo.setCouponSum(couponSum);

        vo.setMoney(money == null ? BigDecimal.ZERO : money);


        responseData.setData(vo);
        return responseData;
    }

    /**
     * 查询券实例
     *
     * @param couponCode
     * @return
     */
    public CouponEntityPO findCouponEntityPO(String couponCode) {

        logger.info("enter CouponServiceImpl findCouponEntityPO method");

        CouponEntityPOExample entityExample = new CouponEntityPOExample();
        entityExample.createCriteria().andCouponCodeEqualTo(couponCode).andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE);
        List<CouponEntityPO> entityList = couponEntityPOMapper.selectByExample(entityExample);

        CouponEntityPO entityPO = null;

        if (CollectionUtils.isNotEmpty(entityList)) {
            entityPO = entityList.get(0);
        }

        return entityPO;
    }


    /**
     * 根据券号获取券实例和券定义详情
     *
     * @param couponCode
     * @return
     */
    @Override
    public ResponseData<CouponDetailResponseVO> findCouponDetailByCouponCode(String couponCode) {
        logger.info("enter CouponServiceImpl findCouponDetailByCouponCode method");
        ResponseData<CouponDetailResponseVO> responseData = new ResponseData<>();
        CouponEntityPOExample entityExample = new CouponEntityPOExample();
        entityExample.createCriteria().andCouponCodeEqualTo(couponCode).andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE);
        List<CouponEntityPO> entityList = couponEntityPOMapper.selectByExample(entityExample);

        CouponDefinitionPO definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(Long.parseLong(entityList.get(0).getCouponDefinitionId()));

        CouponDetailResponseVO responseVO = new CouponDetailResponseVO();
        responseVO.setCouponDefinitionPO(definitionPO);
        responseVO.setCouponEntityPO(entityList.get(0));
        responseData.setData(responseVO);
        return responseData;
    }


    /**
     * 根据券号获取券实例和券定义详情
     *
     * @param couponCode
     * @return
     */
    @Override
    public ResponseData<CouponDetailResponseVO> findCouponDetailByCouponCode(String couponCode, Long brandId) {
        logger.info("enter CouponServiceImpl findCouponDetailByCouponCode method");
        ResponseData<CouponDetailResponseVO> responseData = new ResponseData<>();

        if (StringUtils.isBlank(couponCode)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_CODE_NOT_NULL.getMessage());
            return responseData;
        }
        if (null == brandId) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.SYS_BRAND_ID_NOT_NULL.getMessage());
            return responseData;
        }

        CouponEntityPOExample entityExample = new CouponEntityPOExample();
        entityExample.createCriteria().andCouponCodeEqualTo(couponCode).andSysBrandIdEqualTo(brandId)
                .andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE);
        List<CouponEntityPO> entityList = couponEntityPOMapper.selectByExample(entityExample);

        if (CollectionUtils.isEmpty(entityList)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_NOT_EXIST.getMessage());
            return responseData;
        }

        CouponDefinitionPO definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(Long.parseLong(entityList.get(0).getCouponDefinitionId()));

        CouponDetailResponseVO responseVO = new CouponDetailResponseVO();
        responseVO.setCouponDefinitionPO(definitionPO);
        responseVO.setCouponEntityPO(entityList.get(0));
        responseData.setData(responseVO);
        return responseData;
    }


    /**
     * 查询受赠人信息
     *
     * @param fromOpenId
     * @param couponCode
     * @return
     */
    @Override
    public ResponseData<WxChannelInfoVo> findTOMemberInfo(String fromOpenId, String couponCode, Long sysBrandId) {

        //查询赠与人信息
//        WxChannelInfoVo channelParam = new WxChannelInfoVo();
//        channelParam.setWxOpenId(fromOpenId);
//        ResponseData<WxChannelInfoVo> fromMemberResult = wxChannelInfoApiService.getWxChannelInfo(channelParam);

        //查询会员信息 新接口
        WxChannelInfoVo channelVO = new WxChannelInfoVo();
        channelVO.setWxOpenId(fromOpenId);
        channelVO.setBrandId(sysBrandId);
        channelVO.setMiniProgram(1);
        ResponseData<WxChannelAndMemberVo> channelResult = wxChannelInfoApiService.getWxChannelInfoAndMemberInfo(channelVO);

        //查询券状态日志表
//        CouponStatusLogPOExample statusExample = new CouponStatusLogPOExample();
//        statusExample.createCriteria().andCouponCodeEqualTo(couponCode).andTransferMemberCodeEqualTo(channelResult.getData().getWxChannelInfoVo().getMemberCode())
//                .andSysBrandIdEqualTo(sysBrandId).andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE);
//        List<CouponStatusLogPO> statusLogList = couponStatusLogPOMapper.selectByExample(statusExample);
//        CouponStatusLogPO logPO = statusLogList.get(0);

//        String toMemberCode = logPO.getReceivedMemberCode();

//        WxChannelInfoVo toMemberParam = new WxChannelInfoVo();
//        toMemberParam.setMemberCode(toMemberCode);
//        toMemberParam.setBrandId(sysBrandId);
//        ResponseData<WxChannelInfoVo> memberResult = wxChannelInfoApiService.getWxChannelInfo(toMemberParam);
        //查询会员信息 新接口
//        WxChannelInfoVo channelVO = new WxChannelInfoVo();
//        channelVO.setMemberCode(MemberCode());
//        channelVO.setBrandId(sysBrandId);
//        channelVO.setMiniProgram(1);
//        ResponseData<WxChannelAndMemberVo> channelResult1 = wxChannelInfoApiService.getWxChannelInfoAndMemberInfo(channelVO);
//        


        ResponseData<WxChannelInfoVo> memberResult = new ResponseData<WxChannelInfoVo>();
        memberResult.setData(channelResult.getData().getWxChannelInfoVo());

        return memberResult;

    }


    /**
     * 根据发券时间和券类型统计券使用状况
     *
     * @param sendType
     * @param createDate
     * @return
     */
    @Override
    public ResponseData<CouponFindCouponCountResponseVO> findCountBySendType(String sendType, String createDate, Long sysBrandId) throws Exception {

        logger.info("enter CouponServiceImpl findCountBySendType method");

        ResponseData<CouponFindCouponCountResponseVO> responseData = new ResponseData<>();

        if (StringUtils.isBlank(sendType)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_SEND_TYPE_NOT_NULL.getMessage());
            return responseData;
        }
        if (StringUtils.isBlank(createDate)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.DATE_NOT_NULL.getMessage());
            return responseData;
        }
        if (null == sysBrandId) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.SYS_BRAND_ID_NOT_NULL.getMessage());
            return responseData;
        }

        CouponFindCouponCountResponseVO vo = new CouponFindCouponCountResponseVO();


        Long couponSum = couponEntityPOMapper.findCouponAllCount(null, sendType, sysBrandId,
                SystemConstants.COUPON_STATUS_UNUSED, SystemConstants.COUPON_STATUS_USED, SystemConstants.COUPON_STATUS_OVERDUE, null, null, createDate);

        Long couponUnusedSum = couponEntityPOMapper.findCouponCount(null, sendType, sysBrandId, SystemConstants.COUPON_STATUS_UNUSED, null, null, createDate);

        Long couponUsedSum = couponEntityPOMapper.findCouponCount(null, sendType, sysBrandId, SystemConstants.COUPON_STATUS_USED, null, null, createDate);

        Long couponOverdueSum = couponEntityPOMapper.findCouponCount(null, sendType, sysBrandId, SystemConstants.COUPON_STATUS_OVERDUE, null, null, createDate);

        BigDecimal money = couponEntityPOMapper.findUseBusinessAmountSum(null, sendType, sysBrandId, SystemConstants.COUPON_STATUS_USED, null, null, createDate);

        vo.setCouponOverdueSum(couponOverdueSum);
        vo.setCouponSum(couponSum);
        vo.setCouponUnusedSum(couponUnusedSum);
        vo.setCouponUsedSum(couponUsedSum);
        vo.setMoney(money == null ? BigDecimal.ZERO : money);

        responseData.setData(vo);
        return responseData;
    }


    /**
     * 券核销接口
     *
     * @param requestVO
     * @return
     */
    @Override
    public ResponseData<String> use(CouponUseVO requestVO) {

        logger.info("enter CouponServiceImpl use method ! param:requestVO:{}", JSONObject.toJSONString(requestVO));

        ResponseData<String> responseData = new ResponseData<>();

        String couponCode = requestVO.getCouponCode();

        if (StringUtils.isBlank(couponCode)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_CODE_NOT_NULL.getMessage());
            return responseData;
        }


        CouponEntityPO couponEntityPO = findCouponEntityPO(couponCode);

        if (null == couponEntityPO) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_NOT_EXIST.getMessage());
            return responseData;
        }

        CouponDefinitionPO definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(Long.parseLong(couponEntityPO.getCouponDefinitionId()));

        //使用优惠券
        ResponseData<String> couponUseResult = couponUse(couponEntityPO, definitionPO, requestVO);

        return couponUseResult;
    }


    /**
     * 企业微信券核销
     *
     * @return
     */
    @Override
    public ResponseData<String> wechatEnterpriseUse(CouponUseVO requestVO) {

        logger.info("enter CouponServiceImpl wechatEnterpriseUse method ! param:requestVO:{}", JSONObject.toJSONString(requestVO));

        ResponseData<String> responseData = new ResponseData<>();

        String couponCode = requestVO.getCouponCode();

        if (StringUtils.isBlank(couponCode)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_CODE_NOT_NULL.getMessage());
            return responseData;
        }


        CouponEntityPO couponEntityPO = findCouponEntityPO(couponCode);

        if (null == couponEntityPO) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_NOT_EXIST.getMessage());
            return responseData;
        }

        CouponDefinitionPO definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(Long.parseLong(couponEntityPO.getCouponDefinitionId()));

        //微商城券-企业微信-不可核销
        if (definitionPO.getUseChannel().equals(SystemConstants.USE_CHANNEL_ONLINE)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.WECHAT_ENTERPRISE_COUPON_ONLINE_NOT_USE.getMessage());
            return responseData;
        }

        //使用优惠券
        ResponseData<String> couponUseResult = couponUse(couponEntityPO, definitionPO, requestVO);

        return couponUseResult;
    }


    /**
     * 使用优惠券
     *
     * @param couponEntityPO
     * @return
     */
    public ResponseData<String> couponUse(CouponEntityPO couponEntityPO, CouponDefinitionPO couponDefinitionPO, CouponUseVO requestVO) {

        ResponseData responseData = new ResponseData();

        String couponCode = requestVO.getCouponCode();
        Long brandId = requestVO.getBrandId();
        Byte useFrom = requestVO.getUseFrom();
        String staffCode = requestVO.getStaffCode();

        if (couponEntityPO.getCouponStatus().equals(SystemConstants.COUPON_STATUS_USED)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_USED.getMessage());
            return responseData;
        }

        if (couponEntityPO.getCouponStatus().equals(SystemConstants.COUPON_STATUS_OVERDUE)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_EXPIRED.getMessage());
            return responseData;
        }

        try {
            //判断券是否今天可用
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Date validDateStart = couponEntityPO.getValidDateStart();
            Date startDate = format.parse(format.format(validDateStart));
            Date today = format.parse(format.format(new Date()));

            if (today.getTime() < startDate.getTime()) {
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage(SysResponseEnum.COUPON_NOT_VALID.getMessage());
                return responseData;
            }

        } catch (Exception e) {
            logger.info("enter CouponServiceImpl use  method ! date format error");
        }


        //判断渠道核销
        Byte useChannel = couponDefinitionPO.getUseChannel();

        if (useChannel.equals(SystemConstants.USE_CHANNEL_ONLINE)) {

            CouponOnlineUseRequestVO couponOnlineUseRequestVO = new CouponOnlineUseRequestVO();
            couponOnlineUseRequestVO.setCouponCode(couponCode);
            couponOnlineUseRequestVO.setBrandId(brandId);
            couponOnlineUseRequestVO.setUseFrom(useFrom);
            couponOnlineUseRequestVO.setStaffCode(staffCode);

            onlineUse(couponOnlineUseRequestVO);

        } else if (useChannel.equals(SystemConstants.USE_CHANNEL_OFFLINE)) {

            CouponOfflineUseRequestVO couponOfflineUseRequestVO = new CouponOfflineUseRequestVO();
            couponOfflineUseRequestVO.setCouponCode(couponCode);
            couponOfflineUseRequestVO.setSysBrandId(brandId);
            couponOfflineUseRequestVO.setIsMember(SystemConstants.IS_MEMBER);
            couponOfflineUseRequestVO.setUseFrom(useFrom);
            couponOfflineUseRequestVO.setStaffCode(staffCode);

            offlineUse(couponOfflineUseRequestVO);
        } else {

            CouponAllUseRequestVO couponAllUseRequestVO = new CouponAllUseRequestVO();
            couponAllUseRequestVO.setCouponCode(couponCode);
            couponAllUseRequestVO.setBrandId(brandId);
            couponAllUseRequestVO.setUseFrom(useFrom);
            couponAllUseRequestVO.setStaffCode(staffCode);

            allUse(couponAllUseRequestVO);
        }


        return responseData;

    }


    /**
     * 根据券号查找券
     *
     * @param couponCode
     * @return
     */
    @Override
    public ResponseData<CouponEntityPO> findCouponEntityByCouponCode(String couponCode, Long brandId) {
        logger.info("enter CouponServiceImpl findCouponEntityByCouponCode method");

        ResponseData<CouponEntityPO> responseData = new ResponseData<>();

        CouponEntityPOExample couponEntityPOExample = new CouponEntityPOExample();
        CouponEntityPOExample.Criteria criteria = couponEntityPOExample.createCriteria();
        criteria.andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE);
        criteria.andCouponCodeEqualTo(couponCode);
        criteria.andSysBrandIdEqualTo(brandId);

        List<CouponEntityPO> list = couponEntityPOMapper.selectByExample(couponEntityPOExample);

        if (CollectionUtils.isEmpty(list)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
            return responseData;
        }

        responseData.setData(list.get(0));

        return responseData;
    }


    /**
     * 通过memberCode查询券集合
     *
     * @param vo
     * @return
     */
    @Override
    public ResponseData<List<CouponEntityAndDefinitionVO>> getMemberCoupon(CouponListByMemberCodeRequestVO vo) {
        logger.info("enter CouponServiceImpl getMemberCoupon method");
        ResponseData<List<CouponEntityAndDefinitionVO>> result = new ResponseData<>();

        if (StringUtils.isBlank(vo.getMemberCode())) {
            result.setCode(SysResponseEnum.FAILED.getCode());
            result.setMessage(SysResponseEnum.COUPON_MEMBER_CODE_NOT_NULL.getMessage());
            return result;
        }

        if (null == vo.getCouponStatus()) {
            result.setCode(SysResponseEnum.FAILED.getCode());
            result.setMessage(SysResponseEnum.COUPON_STATUS_NOT_NULL.getMessage());
            return result;
        }

        List<CouponEntityAndDefinitionVO> list = couponEntityPOMapper.getCouponListByMemeberCode(vo);
        if (null == list) {
            list = new ArrayList<>();
        }

        result.setData(list);

        return result;
    }


    /**
     * 根据多个业务id和业务类型统计券的使用状况
     *
     * @param sendBusinessId
     * @param sendType
     * @return
     */
    @Override
    public ResponseData<CouponFindCouponCountResponseVO> findCouponCount(List<String> sendBusinessId, Byte sendType, Long sysBrandId) {


        logger.info("enter CouponServiceImpl findCouponCount method");

        ResponseData<CouponFindCouponCountResponseVO> responseData = new ResponseData<>();

        if (CollectionUtils.isEmpty(sendBusinessId)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_SEND_BUSINESS_ID_NOT_NULL.getMessage());
            return responseData;
        }

        if (null == sendType) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_SEND_TYPE_NOT_NULL.getMessage());
            return responseData;
        }

        if (null == sysBrandId) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.SYS_BRAND_ID_NOT_NULL.getMessage());
            return responseData;
        }


        CouponFindCouponCountResponseVO vo = new CouponFindCouponCountResponseVO();

        CouponStatusEntitySuccessVO successVO = new CouponStatusEntitySuccessVO();
        successVO.setCouponStatusUsed(SystemConstants.COUPON_STATUS_USED);
        successVO.setCouponStatusUnused(SystemConstants.COUPON_STATUS_UNUSED);
        successVO.setCouponStatusOverdue(SystemConstants.COUPON_STATUS_OVERDUE);

        Long couponSum = couponEntityPOMapper.findCouponAllCountBySendBusinessIdList(sendBusinessId, sendType, sysBrandId, successVO);

        //Long couponUnusedSum = couponEntityPOMapper.findCouponCountBySendBusinessIdList(sendBusinessId,sendType,sysBrandId,SystemConstants.COUPON_STATUS_UNUSED);

        Long couponUsedSum = couponEntityPOMapper.findCouponCountBySendBusinessIdList(sendBusinessId, sendType, sysBrandId, SystemConstants.COUPON_STATUS_USED);

        //Long couponOverdueSum = couponEntityPOMapper.findCouponCountBySendBusinessIdList(sendBusinessId,sendType,sysBrandId,SystemConstants.COUPON_STATUS_OVERDUE);

      /*BigDecimal money = couponEntityPOMapper.findUseBusinessAmountSum(param.getSendBusinessId(),param.getSendType(),param.getSysBrandId(),
              SystemConstants.COUPON_STATUS_USED,
              param.getDtStart(),param.getDtEnd(),null);*/


        // vo.setCouponOverdueSum(couponOverdueSum);
        vo.setCouponSum(couponSum);
        //vo.setCouponUnusedSum(couponUnusedSum);
        vo.setCouponUsedSum(couponUsedSum);
        //vo.setMoney(money == null?BigDecimal.ZERO:money);

        responseData.setData(vo);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());

        return responseData;


    }


    /**
     * 查询企业微信核销券历史
     *
     * @return
     */
    @Override
    public ResponseData<PageInfo<CouponEntityVO>> findQyCouponUseHistory(String staffCode, String searchValue, int pageNumber, int pageSize) {

        ResponseData responseData = new ResponseData();

        PageHelper.startPage(pageNumber, pageSize);

        Byte useFrom = SystemConstants.COUPON_USE_FROM_QY;
        Byte couponStatus = SystemConstants.COUPON_STATUS_USED;

        List<CouponEntityVO> couponEntityVOS = couponEntityPOMapper.findQyCouponUseHistory(staffCode, searchValue, useFrom, couponStatus);

        PageInfo pageInfo = new PageInfo(couponEntityVOS);

        responseData.setData(pageInfo);
        return responseData;
    }


    /**
     * 转赠状态更改为转赠中
     *
     * @return
     */
    @Override
    public ResponseData<Integer> couponGiving(String couponCode) {

        ResponseData<Integer> responseData = new ResponseData<>();

        if (StringUtils.isBlank(couponCode)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_CODE_NOT_NULL.getMessage());
            return responseData;
        }

        CouponEntityPOExample entityPOExample = new CouponEntityPOExample();
        entityPOExample.createCriteria().andCouponCodeEqualTo(couponCode);

        CouponEntityPO couponEntityPO = new CouponEntityPO();
        couponEntityPO.setGive(SystemConstants.COUPON_GIVING);

        couponEntityPOMapper.updateByExampleSelective(couponEntityPO, entityPOExample);

        return responseData;
    }


}
