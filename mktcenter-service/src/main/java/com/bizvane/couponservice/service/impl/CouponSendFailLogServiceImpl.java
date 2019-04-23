package com.bizvane.couponservice.service.impl;

import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.po.CouponEntityPO;
import com.bizvane.couponfacade.models.po.CouponSendFailLogPO;
import com.bizvane.couponfacade.models.po.CouponSendFailLogPOExample;
import com.bizvane.couponfacade.utils.TimeUtils;
import com.bizvane.couponfacade.constants.CouponConstants;
import com.bizvane.couponservice.mappers.CouponSendFailLogPOMapper;
import com.bizvane.couponservice.service.CouponSendFailLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by yunjie.tian on 2018/9/30.
 */
@Service
public class CouponSendFailLogServiceImpl implements CouponSendFailLogService{

    @Autowired
    private CouponSendFailLogPOMapper couponSendFailLogPOMapper;

    /**
     * 保存券日志信息
     * @param definitionPO
     * @param entityPO
     */
    @Override
    public void saveCouponSendFailLog(CouponDefinitionPO definitionPO, CouponEntityPO entityPO){


        CouponSendFailLogPO failPO = new CouponSendFailLogPO();

        failPO.setSysBrandId(entityPO.getSysBrandId());
        failPO.setSysCompanyId(entityPO.getSysCompanyId());
        failPO.setBrandCode(entityPO.getBrandCode());
        failPO.setCouponDefinitionId(Long.parseLong(entityPO.getCouponDefinitionId()));
        failPO.setCouponEntityId(entityPO.getCouponEntityId());
        failPO.setCouponCode(entityPO.getCouponCode());
        failPO.setMemberCode(entityPO.getMemberCode());
        failPO.setCouponName(definitionPO.getCouponName());
        failPO.setMoney(entityPO.getMoney());
        failPO.setDiscount(entityPO.getDiscount());
        failPO.setImg(entityPO.getImg());
        failPO.setCouponType(definitionPO.getCouponDefinitionType()+"");
        failPO.setBizType(entityPO.getSendType());
        failPO.setBizCode(entityPO.getSendBusinessId()+"");
        //failPO.setInfo();
        failPO.setFailReason(CouponConstants.SEND_COUPON_FAIL_REASON_ERP);
        failPO.setFailTimes(0);
        failPO.setValid(CouponConstants.TABLE_VALID_EFFECTIVE);
        failPO.setSendStatus(CouponConstants.COUPON_SEND_NO);
        failPO.setCreateDate(TimeUtils.getNowTime());
        
        failPO.setBusinessName(entityPO.getBusinessName());
        couponSendFailLogPOMapper.insertSelective(failPO);

    }

    /**
     * 更新发送状态
     * @param sendStatus
     * @param couponCode
     */
    @Override
    public void updateSendStatus(Byte sendStatus,String couponCode){

        CouponSendFailLogPO failLogPO = new CouponSendFailLogPO();
        failLogPO.setSendStatus(sendStatus);

        CouponSendFailLogPOExample example = new CouponSendFailLogPOExample();
        example.createCriteria().andValidEqualTo(CouponConstants.TABLE_VALID_EFFECTIVE).
                andCouponCodeEqualTo(couponCode);

        couponSendFailLogPOMapper.updateByExampleSelective(failLogPO,example);

    }


    /**
     * 更新发券失败信息
     * @param sendStatus
     * @param sendDate
     * @param couponSendFailLogId
     */
    @Override
    public void updateSendStatusAndSendTimes(Byte sendStatus, Date sendDate,Long couponSendFailLogId){

        couponSendFailLogPOMapper.updateSendStatusAndSendTimes(sendStatus,sendDate,couponSendFailLogId);

    }

}
