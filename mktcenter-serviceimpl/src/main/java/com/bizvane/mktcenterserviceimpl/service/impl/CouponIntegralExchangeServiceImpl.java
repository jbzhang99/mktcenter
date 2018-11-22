package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.CouponIntegralExchangeService;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.MktCouponIntegralExchangeVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterserviceimpl.mappers.MktCouponIntegralExchangePOMapper;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by agan on 2018/11/22.
 */
@Service
@Slf4j
public class CouponIntegralExchangeServiceImpl implements CouponIntegralExchangeService {

    @Autowired
    private MktCouponIntegralExchangePOMapper mktCouponIntegralExchangePOMapper;
    /**
     * 积分兑换券列表
     * @param vo
     * @param pageForm
     * @param stageUser
     * @return
     */
    @Override
    public ResponseData<MktCouponIntegralExchangeVO> getCouponIntegralExchangeList(MktCouponIntegralExchangeVO vo, PageForm pageForm, SysAccountPO stageUser) {
        ResponseData responseData = new ResponseData();
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
        vo.setSysBrandId(stageUser.getBrandId());
        List<MktCouponIntegralExchangeVO> mktCouponIntegralExchangeVOList = mktCouponIntegralExchangePOMapper.getCouponIntegralExchangeList(vo);
        PageInfo<MktCouponIntegralExchangeVO> pageInfo = new PageInfo<>(mktCouponIntegralExchangeVOList);
        responseData.setData(pageInfo);
        return responseData;
    }
}
