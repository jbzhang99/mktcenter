package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.ConvertCouponService;
import com.bizvane.mktcenterservice.models.po.MktConvertCouponRecordPO;
import com.bizvane.mktcenterservice.models.po.MktConvertCouponRecordPOExample;
import com.bizvane.mktcenterservice.models.po.MktTaskProfilePOExample;
import com.bizvane.mktcenterservice.models.vo.CouponRecordVO;
import com.bizvane.mktcenterserviceimpl.mappers.MktConvertCouponRecordPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktTaskProfilePOMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/11/23 11:28
 */
@Service
public class ConvertCouponServiceImpl implements ConvertCouponService {
    @Autowired
    private MktConvertCouponRecordPOMapper mktConvertCouponRecordPOMapper;
    /**
     * 积分兑换订单的查询
     */
    @Override
    public List<MktConvertCouponRecordPO>  getCouponRecordLists(CouponRecordVO vo) {
      return  mktConvertCouponRecordPOMapper.getCouponRecordLists(vo);
    }
}
