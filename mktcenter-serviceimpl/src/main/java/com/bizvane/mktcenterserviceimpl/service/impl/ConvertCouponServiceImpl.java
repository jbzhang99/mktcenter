package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.ConvertCouponService;
import com.bizvane.mktcenterservice.models.po.MktConvertCouponRecordPO;
import com.bizvane.mktcenterservice.models.vo.CouponRecordVO;
import com.bizvane.mktcenterservice.models.vo.DayTaskRecordVo;
import com.bizvane.mktcenterservice.models.vo.MktCouponIntegralExchangeVO;
import com.bizvane.mktcenterserviceimpl.mappers.MktConvertCouponRecordPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktCouponIntegralExchangePOMapper;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/11/23 11:28
 */
@Service
public class ConvertCouponServiceImpl implements ConvertCouponService {
    @Autowired
    private MktConvertCouponRecordPOMapper mktConvertCouponRecordPOMapper;
    @Autowired
    private MktCouponIntegralExchangePOMapper mktCouponIntegralExchangePOMapper;

    /**
     * 积分兑换订单的查询
     */
    @Override
    public ResponseData<PageInfo<MktConvertCouponRecordPO>> getCouponRecordLists(CouponRecordVO vo) {
        ResponseData<PageInfo<MktConvertCouponRecordPO>> responseData = new ResponseData<>();
        PageInfo<MktConvertCouponRecordPO> page = null;
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<MktConvertCouponRecordPO> couponRecordLists = mktConvertCouponRecordPOMapper.getCouponRecordLists(vo);
        if (CollectionUtils.isEmpty(couponRecordLists)) {
            page = new PageInfo<>(new ArrayList<MktConvertCouponRecordPO>());
        } else {
            page = new PageInfo<>(couponRecordLists);
        }
        responseData.setData(page);
        return responseData;
    }

    /**
     * 查询兑换的券 全部或可兑换 列表
     */
    @Override
    public ResponseData<PageInfo<MktCouponIntegralExchangeVO>> getConvernCouponLists(CouponRecordVO vo) {
        if (vo.getCanConvertCoupon()) {
            //可兑换券的列表
            List<Integer> exchangeIds = mktCouponIntegralExchangePOMapper.getExchangeIds(vo);
            vo.setExchangeIds(exchangeIds);
        }else{
            //品牌下的券列表
            vo.setOpenCardStoreId(null);
            vo.setExchangeIds(null);
            vo.setCountIntegral(null);
        }
        ResponseData<PageInfo<MktCouponIntegralExchangeVO>> responseData = new ResponseData<>();
        PageInfo<MktCouponIntegralExchangeVO> page = null;
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<MktCouponIntegralExchangeVO> exchangeLists = mktCouponIntegralExchangePOMapper.getExchangeLists(vo);
        if (CollectionUtils.isEmpty(exchangeLists)) {
            page = new PageInfo<>(new ArrayList<MktCouponIntegralExchangeVO>());
        } else {
            page = new PageInfo<>(exchangeLists);
        }
        responseData.setData(page);
        return responseData;
    }

}
