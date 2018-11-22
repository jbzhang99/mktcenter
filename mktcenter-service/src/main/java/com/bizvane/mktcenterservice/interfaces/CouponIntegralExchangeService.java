package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.vo.MktCouponIntegralExchangeVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

/**
 * Created by wangkeqiang on 2018/11/22.
 */
public interface CouponIntegralExchangeService {

    /**
     * 积分兑换券列表
     * @param vo
     * @param pageForm
     * @param stageUser
     * @return
     */
    public ResponseData<MktCouponIntegralExchangeVO> getCouponIntegralExchangeList(MktCouponIntegralExchangeVO vo, PageForm pageForm, SysAccountPO stageUser);

}
