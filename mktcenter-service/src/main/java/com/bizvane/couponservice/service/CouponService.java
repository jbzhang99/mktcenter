package com.bizvane.couponservice.service;

import com.bizvane.couponfacade.models.po.CouponEntityPO;
import com.bizvane.couponfacade.models.vo.*;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.bizvane.members.facade.vo.WxChannelInfoVo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 券实例
 *
 * @author 董争光
 *         2018年7月6日下午2:16:36
 */
public interface CouponService {

    /**
     * 线上核销券
     *
     * @param vo
     * @return
     */
    ResponseData<String> onlineUse(CouponOnlineUseRequestVO vo);


    /**
     * 线下核销券
     *
     * @param vo
     * @return
     */
    ResponseData<Integer> offlineUse(CouponOfflineUseRequestVO vo);


    /**
     * 冲正券
     *
     * @param vo
     * @return
     */
    ResponseData<Object> cancelUse(CouponCancelUseRequestVO vo);

    /**
     * 根据会员code查询所有券
     *
     * @param vo
     * @return
     */
    ResponseData<PageInfo<CouponEntityAndDefinitionVO>> getCouponListByMemeberCode(CouponListByMemberCodeRequestVO vo, PageFormUtil pageFormUtil);


    /**
     * 根据券code查询券详情
     *
     * @param couponId
     * @return
     */
    ResponseData<CouponDetailModelVO> findCouponByCouponCode(String couponCode);


    ResponseData<CouponDetailResponseVO> findCouponDetailByCouponCode(String couponCode, Long brandId);


    ResponseData<CouponEntityPO> findCouponEntity(String couponCode, String memberCode);


    ResponseData<CouponFindCouponCountResponseVO> findCouponCountByMemberCode(String memberCode);

    ResponseData<CouponFindCouponCountResponseVO> findCouponCountBySendBusinessId(Long sendBusinessId, String sendType, Long sysBrandId);

    ResponseData<CouponFindCouponCountResponseVO> findCouponCountByDate(CouponEntityVO couponEntityVO);


    /**
     * 转赠
     *
     * @param vo
     * @return
     */
    ResponseData<Integer> givenCoupon(CouponEntityVO vo);

    /**
     * 锁定
     *
     * @param vo
     * @return
     */
    ResponseData<Object> lock(CouponEntityVO vo);

    /**
     * 未锁定
     *
     * @param vo
     * @return
     */
    ResponseData<Object> unlock(CouponEntityVO vo);

    /**
     * 券过期
     *
     * @param vo
     * @return
     */
    ResponseData<Object> couponExpire(CouponEntityVO vo);

    /**
     * 根据memberCode查询可使用券列表
     *
     * @param memberCode
     * @return
     */
    ResponseData<List<CouponEntityPO>> getCouponUnusedByMemberCode(String memberCode);

    /**
     * 根据发券业务单号集合统计券的使用状况
     *
     * @param vo
     * @return
     */
    ResponseData<CouponFindCouponCountResponseVO> findCouponCountByList(CouponEntityVO vo);


    /**
     * 根据发送类型（活动，任务）查询券数量
     *
     * @param sendType
     * @param sysBrandId
     * @return
     */
    ResponseData<CouponFindCouponCountResponseVO> getCountBySendType(String sendType, Long sysBrandId);

    /**
     * 查询受赠人信息
     *
     * @param fromOpenId
     * @param couponCode
     * @return
     */
    ResponseData<WxChannelInfoVo> findTOMemberInfo(String fromOpenId, String couponCode, Long sysBrandId);


    /**
     * 根据发券时间和券类型统计券使用状况
     *
     * @param sendType
     * @param createDate
     * @return
     */
    ResponseData<CouponFindCouponCountResponseVO> findCountBySendType(String sendType, String createDate, Long sysBrandId) throws Exception;


    /**
     * 根据券号使用优惠券接口(核销)
     *
     * @param requestVO
     * @return
     */
    ResponseData<String> use(CouponUseVO requestVO);

    ResponseData<CouponDetailResponseVO> findCouponDetailByCouponCode(String couponCode);

    /**
     * 根据券号查找券
     *
     * @param couponCode
     * @return
     */
    ResponseData<CouponEntityPO> findCouponEntityByCouponCode(String couponCode, Long brandId);

    /**
     * 全渠道使用优惠券
     *
     * @param requestVO
     * @return
     */
    ResponseData<String> allUse(CouponAllUseRequestVO requestVO);

    /**
     * 查询会员拥有的券
     *
     * @param vo
     * @return
     */
    ResponseData<List<CouponEntityAndDefinitionVO>> getMemberCoupon(CouponListByMemberCodeRequestVO vo);

    /**
     * 根据多个业务id和业务类型统计券的使用状况
     *
     * @param sendBusinessId
     * @param sendType
     * @return
     */
    ResponseData<CouponFindCouponCountResponseVO> findCouponCount(List<String> sendBusinessId, Byte sendType, Long sysBrandId);

    /**
     * 查询企业微信核销券历史
     *
     * @return
     */
    ResponseData<PageInfo<CouponEntityVO>> findQyCouponUseHistory(String staffCode, String searchValue, int pageNumber, int pageSize);

    /**
     * 转赠状态更改为转赠中
     * @return
     */
    ResponseData<Integer> couponGiving(String couponCode);

    /**
     * 企业微信券核销
     * @return
     */
    ResponseData<String> wechatEnterpriseUse(CouponUseVO requestVO);

    /**
     * 发券量,核销量,核销率
     * @return
     */

	CouponFindCouponCountResponseVO findCouponCountbatchSend(Long batchSendId, Long sendBusinessId, String sendType,
                                                             Long sysBrandId);
}
