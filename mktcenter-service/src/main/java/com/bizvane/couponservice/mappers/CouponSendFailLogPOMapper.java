package com.bizvane.couponservice.mappers;

import com.bizvane.couponfacade.models.po.CouponSendFailLogPO;
import com.bizvane.couponfacade.models.po.CouponSendFailLogPOExample;
import com.bizvane.couponfacade.models.vo.CouponSendAgainRequestVO;
import com.bizvane.couponfacade.models.vo.CouponSendFailLogVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CouponSendFailLogPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    int countByExample(CouponSendFailLogPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    int deleteByExample(CouponSendFailLogPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    int deleteByPrimaryKey(Long couponSendFailLogId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    int insert(CouponSendFailLogPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    int insertSelective(CouponSendFailLogPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    List<CouponSendFailLogPO> selectByExample(CouponSendFailLogPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    CouponSendFailLogPO selectByPrimaryKey(Long couponSendFailLogId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    int updateByExampleSelective(@Param("record") CouponSendFailLogPO record, @Param("example") CouponSendFailLogPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    int updateByExample(@Param("record") CouponSendFailLogPO record, @Param("example") CouponSendFailLogPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    int updateByPrimaryKeySelective(CouponSendFailLogPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-28 17:14:41
     */
    int updateByPrimaryKey(CouponSendFailLogPO record);
    
    
    //非生成sql 
    
    
    /**
     * 根据条件查询
     * @param vo
     * @return
     */
      List<CouponSendFailLogVO> findCouponSendFailLogByCondition(@Param("vo") CouponSendFailLogVO vo, @Param("sysBrandId") Long sysBrandId);

    /**
     * 根据条件获取发券失败记录
     * @param sendNum
     * @param tryTimes
     * @return
     */
    List<CouponSendAgainRequestVO> getListBySendNum(@Param("sendNum") String sendNum, @Param("tryTimes") Byte tryTimes);

    /**
     * 更新补发次数
     * @param failIdList
     */
    void updateTryTimesByIdList(@Param("list") List<Long> failIdList, @Param("sendStatus") Byte sendStatus, @Param("sendDate") Date sendDate);

    /**
     * 补发券(批量)
     * @return
     */
    List<CouponSendAgainRequestVO> selectBatchByIdList(@Param("list") List<String> idList, @Param("sendStatus") Byte sendStatus);

    /**
     * 根据券号集合查询券集合
     * @param couponFailList
     * @return
     */
    List<CouponSendFailLogPO> selectByCouponCodeList(@Param("list") List<String> couponFailList);

    /**
     * 批量插入
     * @param failPOList
     */
    void insertBatch(@Param("list") List<CouponSendFailLogPO> failPOList);

    /**
     * 根据coupon_code批量更新补发状态
     * @param couponSuccessList
     * @param sendStatus
     */
    void updateSendStatusByCouponCodeList(@Param("list") List<String> couponSuccessList, @Param("sendStatus") Byte sendStatus);

    /**
     * 更新发券失败状态
     * @param sendStatus
     * @param sendDate
     * @param couponSendFailLogId
     */
    void updateSendStatusAndSendTimes(@Param("sendStatus") Byte sendStatus, @Param("sendDate") Date sendDate, @Param("id") Long couponSendFailLogId);
}