package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.mktcenterservice.interfaces.ConvertCouponService;
import com.bizvane.mktcenterservice.models.po.MktConvertCouponRecordPO;
import com.bizvane.mktcenterservice.models.vo.CouponRecordVO;
import com.bizvane.utils.responseinfo.ResponseData;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/11/23 11:29
 */
@RestController
@RequestMapping("convertRecord")
public class ConvertCouponController {

    @Autowired
    private ConvertCouponService convertCouponService;
    /**
     * 获取兑换订单集合
     * @param vo
     */
    @RequestMapping("getCouponRecordLists")
    public ResponseData<List<MktConvertCouponRecordPO>> getCouponRecordLists(CouponRecordVO vo){
        ResponseData<List<MktConvertCouponRecordPO>> responseData = new ResponseData<>();
        List<MktConvertCouponRecordPO> couponRecordLists = convertCouponService.getCouponRecordLists(vo);
            responseData.setData(couponRecordLists);
        if (CollectionUtils.isEmpty(couponRecordLists)){
            responseData.setData(new ArrayList<MktConvertCouponRecordPO>());
        }
        return responseData;
    }
}
