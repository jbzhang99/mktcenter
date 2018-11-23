package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.ConvertCouponService;
import com.bizvane.mktcenterservice.models.po.MktConvertCouponRecordPO;
import com.bizvane.mktcenterservice.models.vo.CouponRecordVO;
import com.bizvane.mktcenterservice.models.vo.DayTaskRecordVo;
import com.bizvane.mktcenterserviceimpl.mappers.MktConvertCouponRecordPOMapper;
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
    /**
     * 积分兑换订单的查询
     */
    @Override
    public ResponseData<PageInfo<MktConvertCouponRecordPO>>  getCouponRecordLists(CouponRecordVO vo) {
        ResponseData<PageInfo<MktConvertCouponRecordPO>> responseData = new ResponseData<>();
        PageInfo<MktConvertCouponRecordPO> page=null;
        PageHelper.startPage(vo.getPageNumber(),vo.getPageSize());
        List<MktConvertCouponRecordPO> couponRecordLists = mktConvertCouponRecordPOMapper.getCouponRecordLists(vo);
        if (CollectionUtils.isEmpty(couponRecordLists)){
            page = new PageInfo<>(new ArrayList<MktConvertCouponRecordPO>());
        }else{
            page = new PageInfo<>(couponRecordLists);
        }
        responseData.setData(page);
        return responseData;
    }
    /**
     * 查询可兑换的券
     */

}
