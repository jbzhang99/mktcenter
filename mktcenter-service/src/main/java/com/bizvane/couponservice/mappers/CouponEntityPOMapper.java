package com.bizvane.couponservice.mappers;

import com.bizvane.couponfacade.models.bo.GetCouponSurveyBo;
import com.bizvane.couponfacade.models.po.CouponEntityPO;
import com.bizvane.couponfacade.models.po.CouponEntityPOExample;
import com.bizvane.couponfacade.models.vo.*;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface CouponEntityPOMapper {


    //非生成sql


    /**
     * 只读.
     *
     * @mbg.generated 2019-01-17 16:08:03
     */
    long countByExample(CouponEntityPOExample example);


    /**
     * 只读.
     *
     * @mbg.generated 2019-01-17 16:08:03
     */
    int deleteByExample(CouponEntityPOExample example);


    /**
     * 只读.
     *
     * @mbg.generated 2019-01-17 16:08:03
     */
    int deleteByPrimaryKey(Long couponEntityId);


    /**
     * 只读.
     *
     * @mbg.generated 2019-01-17 16:08:03
     */
    int insert(CouponEntityPO record);


    /**
     * 只读.
     *
     * @mbg.generated 2019-01-17 16:08:03
     */
    int insertSelective(CouponEntityPO record);


    /**
     * 只读.
     *
     * @mbg.generated 2019-01-17 16:08:03
     */
    List<CouponEntityPO> selectByExample(CouponEntityPOExample example);


    /**
     * 只读.
     *
     * @mbg.generated 2019-01-17 16:08:03
     */
    CouponEntityPO selectByPrimaryKey(Long couponEntityId);


    /**
     * 只读.
     *
     * @mbg.generated 2019-01-17 16:08:03
     */
    int updateByExampleSelective(@Param("record") CouponEntityPO record,
                                 @Param("example") CouponEntityPOExample example);


    /**
     * 只读.
     *
     * @mbg.generated 2019-01-17 16:08:03
     */
    int updateByExample(@Param("record") CouponEntityPO record, @Param("example") CouponEntityPOExample example);


    /**
     * 只读.
     *
     * @mbg.generated 2019-01-17 16:08:03
     */
    int updateByPrimaryKeySelective(CouponEntityPO record);


    /**
     * 只读.
     *
     * @mbg.generated 2019-01-17 16:08:03
     */
    int updateByPrimaryKey(CouponEntityPO record);


    /**
     * 根据条件查询券列表
     *
     * @param vo
     * @return
     */
    List<CouponEntityVO> findCouponEntityByConditions(@Param("vo") CouponEntityVO vo, @Param("successVO") CouponStatusEntitySuccessVO successVO);


    /**
     * 批量插入券
     *
     * @param list
     */
    int insertBatch(@Param("list") List<CouponEntityPO> list);


    /**
     * 根据sendBusinessId集合查询数量
     *
     * @param sendIdList
     * @return
     */
    Integer getCountBySendBusinessId(@Param("sendIdList") List<Long> sendIdList);

    /**
     * 券发放记录列表导出
     *
     * @param vo
     * @return
     */
    List<CouponEntityVO> findListExportByConditions(@Param("vo") CouponEntityVO vo, @Param("successVO") CouponStatusEntitySuccessVO successVO,
                                                    @Param("sysBrandId") Long sysBrandId,
                                                    @Param("limit") Long limit, @Param("to") Long to);
    
    int findListExportByConditionscount(@Param("vo") CouponEntityVO vo, @Param("successVO") CouponStatusEntitySuccessVO successVO,
                                        @Param("sysBrandId") Long sysBrandId,
                                        @Param("limit") Long limit, @Param("to") Long to);


    /**
     * 根据券code批量更新券状态
     *
     * @param list
     * @return
     */
    void updateCouponStatusBatch(@Param("list") List<String> list, @Param("couponStatus") Byte couponStatus);


    List<CouponEntityAndDefinitionVO> getCouponListByMemeberCode(@Param("vo") CouponListByMemberCodeRequestVO vo);

    List<FindMembersVO> getFindMembersVo(@Param("vo") FindMembersVO vo);

    /**
     * 根据时间查询券
     *
     * @param date
     * @return
     */
    List<CouponEntityVO> findWxCouponList(@Param("date") Date date, @Param("dateEnd") Date dateEnd, @Param("brandId") Long brandId, @Param("couponStatus") Byte couponStatus);

    /**
     * 根据会员code和业务id和时间查询会员是否有某个券
     *
     * @param memberCode
     * @param sendBusinessId
     * @param date
     * @return
     */
    List<CouponEntityPO> findCouponHave(@Param("memberCode") String memberCode,
                                        @Param("sendBusinessId") Long sendBusinessId,
                                        @Param("date") String date);

    /**
     * 批量生成条形码
     *
     * @param entityPOList
     */
    void updateBarcodeUrlBatch(@Param("list") List<CouponEntityPO> entityPOList);

    /**
     * 查询券数量
     *
     * @param sendBusinessId
     * @param sendType
     * @param sysBrandId
     * @param couponStatus
     * @return
     */
    Long findCouponCount(@Param("sendBusinessId") Long sendBusinessId, @Param("sendType") String sendType,
                         @Param("sysBrandId") Long sysBrandId, @Param("couponStatus") Byte couponStatus,
                         @Param("dtStart") Date dtStart, @Param("dtEnd") Date dtEnd, @Param("createDate") String createDate);

    /**
     * 查询核销金额
     *
     * @param sendBusinessId
     * @param sendType
     * @param sysBrandId
     * @param couponStatus
     * @return
     */
    BigDecimal findUseBusinessAmountSum(@Param("sendBusinessId") Long sendBusinessId, @Param("sendType") String sendType,
                                        @Param("sysBrandId") Long sysBrandId, @Param("couponStatus") Byte couponStatus,
                                        @Param("dtStart") Date dtStart, @Param("dtEnd") Date dtEnd, @Param("createDate") String createDate);

    /**
     * 查询券总数
     *
     * @param sendBusinessId
     * @param sendType
     * @param sysBrandId
     * @param unused
     * @param used
     * @param overDue
     * @return
     */
    Long findCouponAllCount(@Param("sendBusinessId") Long sendBusinessId, @Param("sendType") String sendType,
                            @Param("sysBrandId") Long sysBrandId, @Param("unused") Byte unused,
                            @Param("used") Byte used, @Param("overDue") Byte overDue, @Param("dtStart") Date dtStart, @Param("dtEnd") Date dtEnd, @Param("createDate") String createDate);

    /**
     * 查找券实例list
     *
     * @param couponSuccessList
     * @return
     */
    List<CouponEntityPO> findByCouponCodeList(@Param("list") List<String> couponSuccessList);

    /**
     * 查询某个活动/任务的券数量
     *
     * @param sendBusinessId
     * @param sendType
     * @param sysBrandId
     * @param successVO
     * @return
     */
    CouponFindCouponCountResponseVO findCouponCountByStatus(@Param("sendBusinessId") Long sendBusinessId, @Param("sendType") String sendType,
                                                            @Param("sysBrandId") Long sysBrandId, @Param("successVO") CouponStatusEntitySuccessVO successVO);

    /**
     * 查询某个活动/任务的核销金额
     *
     * @param sendBusinessId
     * @param sendType
     * @param sysBrandId
     * @param couponStatus
     * @return
     */
    BigDecimal findBusinessAmountSumUsed(@Param("sendBusinessId") Long sendBusinessId, @Param("sendType") String sendType,
                                         @Param("sysBrandId") Long sysBrandId, @Param("couponStatus") Byte couponStatus);

    /**
     * 查询券总数
     *
     * @param sendBusinessId
     * @param sendType
     * @param sysBrandId
     * @param unused
     * @param used
     * @param overDue
     * @return
     */
    Long findCouponAllCountByStatus(@Param("sendBusinessId") Long sendBusinessId, @Param("sendType") String sendType,
                                    @Param("sysBrandId") Long sysBrandId, @Param("unused") Byte unused,
                                    @Param("used") Byte used, @Param("overDue") Byte overDue);

    /**
     * 根据业务类型查询券总数
     *
     * @param sendType
     * @param sysBrandId
     * @param successVO
     * @return
     */
    Long findAllCouponCountBySendType(@Param("sendType") String sendType, @Param("sysBrandId") Long sysBrandId,
                                      @Param("successVO") CouponStatusEntitySuccessVO successVO);

    /**
     * 根据业务类型查询某个状态的券数量
     *
     * @param sendType
     * @param sysBrandId
     * @param successVO
     * @return
     */
    CouponFindCouponCountResponseVO findCouponCountBySendType(@Param("sendType") String sendType, @Param("sysBrandId") Long sysBrandId,
                                                              @Param("successVO") CouponStatusEntitySuccessVO successVO);

    /**
     * 查询某个活动/任务的核销金额
     *
     * @param sendType
     * @param sysBrandId
     * @param couponStatus
     * @return
     */
    BigDecimal findBusinessAmountSumUsedBySendType(@Param("sendType") String sendType, @Param("sysBrandId") Long sysBrandId,
                                                   @Param("couponStatus") Byte couponStatus);

    /**
     * 券的发放记录数量查询
     *
     * @return
     */
    Long findCouponEntityByConditions_COUNT(@Param("vo") CouponEntityVO entityParam, @Param("successVO") CouponStatusEntitySuccessVO successVO);

    /**
     * 总数
     *
     * @param sendBusinessId
     * @param sendType
     * @param sysBrandId
     * @param successVO
     * @return
     */
    Long findCouponAllCountBySendBusinessIdList(@Param("sendBusinessId") List<String> sendBusinessId, @Param("sendType") Byte sendType,
                                                @Param("sysBrandId") Long sysBrandId, @Param("successVO") CouponStatusEntitySuccessVO successVO);

    /**
     * @param sendBusinessId
     * @param sendType
     * @param sysBrandId
     * @param couponStatus
     * @return
     */
    Long findCouponCountBySendBusinessIdList(@Param("sendBusinessId") List<String> sendBusinessId, @Param("sendType") Byte sendType,
                                             @Param("sysBrandId") Long sysBrandId, @Param("couponStatus") Byte couponStatus);

    /**
     * 查询企业微信核销券历史
     *
     * @return
     */
    List<CouponEntityVO> findQyCouponUseHistory(@Param("staffCode") String staffCode, @Param("searchValue") String searchValue,
                                                @Param("useFrom") Byte useFrom, @Param("couponStatus") Byte couponStatus);

    CouponFindCouponCountResponseVO findCouponCountbatchSend(Long batchSendId, Long sendBusinessId, String sendType, Long sysBrandId, CouponStatusEntitySuccessVO successVO);

    GetCouponSurveyBo getCouponSurvey(Long sysBrandId);

    double getBusinessAmount(Long sysBrandId);


			
}