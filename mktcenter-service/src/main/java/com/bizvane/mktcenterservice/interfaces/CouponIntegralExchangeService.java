package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.bo.ActivityBO;
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
    /**
     * 新增积分兑换列表
     * @param vo
     * @return
     */
    public ResponseData<Integer> addCouponIntegralExchange(MktCouponIntegralExchangeVO vo, SysAccountPO stageUser);

    /**
     * 修改积分兑换规则
     * @param vo
     * @param stageUser
     * @return
     */
    public ResponseData<Integer> updateCouponIntegralExchange(MktCouponIntegralExchangeVO vo,SysAccountPO stageUser);

    /**
     * 查看积分兑换规则的详情
     * @param exchangeId
     * @return
     */
    public ResponseData<MktCouponIntegralExchangeVO> selectCouponIntegralExchange(Long exchangeId);

    /**
     *批量上架下架
     * @return
     */
    public ResponseData<Integer> batchUpdateCouponIntegralExchange(MktCouponIntegralExchangeVO vo,SysAccountPO stageUser);
}
