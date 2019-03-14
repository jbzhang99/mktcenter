package com.bizvane.couponservice.service;

import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.couponfacade.es.CouponEntityInfoSearchPojo;
import com.bizvane.couponfacade.models.po.CouponEntityPO;
import com.bizvane.couponfacade.models.vo.*;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 券service
 *
 * @author 董争光
 *         2018年7月6日下午2:16:36
 */
public interface CouponEntityService {


    ResponseData<CouponEntityPO> findCouponEntity(String couponCode, String memberCode);

    /**
     * 券的发放记录分页
     *
     * @param vo
     * @return
     */
    ResponseData<PageInfo<CouponEntityVO>> getList(CouponEntityVO vo, SysAccountPo accountPo, PageFormUtil pageForm);

    /**
     * 券发放总数查询
     * @param entityParam
     * @param successVO
     * @return
     */
    ResponseData<Long> getCouponTotal(CouponEntityVO entityParam, CouponStatusEntitySuccessVO successVO);


    /**
     * 券的发放记录分页
     *
     * @param vo
     * @return
     */
    ResponseData<PageInfo<CouponEntityVO>> getListRpc(CouponEntityVO vo, PageFormUtil pageForm);

    /**
     * 券的发放记录列表
     *
     * @param vo
     * @return
     */
    List<CouponSendLogExportVO> getListExport(CouponEntityVO vo, SysAccountPo accountPo);

    /**
     * 券的发放记录详细查询
     *
     * @param po
     * @return
     */
    ResponseData<CouponDetailResponseVO> getCouponEntityAndDefinitionByEntityId(Long couponEntityId);

    /**
     * 查询会员是否有某个券
     *
     * @param date
     * @param memberCode
     * @param sendBusinessId
     * @return
     */
    ResponseData<List<CouponEntityPO>> finCouponHave(String memberCode, Long sendBusinessId, String date);

    /**
     * 根据券code更新券状态
     *
     * @param couponCode
     * @param couponStatus
     * @return
     */
    ResponseData<Integer> updateCouponStatus(String couponCode, Byte couponStatus, Integer ifSendAgain);

    /**
     * 批量发券收到线下处理结果
     *
     * @param vo
     * @return
     */
    ResponseData<Integer> updateCouponStatusBatch(CouponStatusUpdateBatchRequestVO vo);

    /**
     * 券的发放记录详细查询
     *
     * @return
     */
    ResponseData<CouponDetailResponseVO> getCouponEntityAndDefinitionById(Long couponEntityId, Long couponDefinitionId);

    /**
     * 查询单张券定义信息
     *
     * @param couponDefinitionId
     * @return
     */
    ResponseData<CouponDetailResponseVO> getCouponDefinition(Long couponDefinitionId);

    /**
     * 查询券详情（根据实例id）
     *
     * @param couponEntityId
     * @return
     */
    ResponseData<CouponDetailResponseVO> getAllDetailRpc(Long couponEntityId);

    /**
     * 查询活动/任务发送的券的会员列表
     *
     * @param requestVO
     * @return
     */
    ResponseData<PageInfo<CouponSendMemberListResponseVO>> findCouponSendMemberList(CouponSendMemberListRequestVO requestVO);

	ResponseData<PageInfo<CouponEntityInfoSearchPojo>> getListEs(CouponEntityVO entityParam, SysAccountPo accountPo, PageFormUtil pageForm);
			
}
