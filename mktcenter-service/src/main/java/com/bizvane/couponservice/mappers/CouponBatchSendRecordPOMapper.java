package com.bizvane.couponservice.mappers;

import com.bizvane.couponfacade.models.po.CouponBatchSendRecordPO;
import com.bizvane.couponfacade.models.po.CouponBatchSendRecordPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponBatchSendRecordPOMapper {
    

    //非系统sql

    /**
	 * 只读. 
	 * @mbg.generated  2018-12-20 14:37:22
	 */
	long countByExample(CouponBatchSendRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-20 14:37:22
	 */
	int deleteByExample(CouponBatchSendRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-20 14:37:22
	 */
	int deleteByPrimaryKey(Long couponBatchSendRecordId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-20 14:37:22
	 */
	int insert(CouponBatchSendRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-20 14:37:22
	 */
	int insertSelective(CouponBatchSendRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-20 14:37:22
	 */
	List<CouponBatchSendRecordPO> selectByExample(CouponBatchSendRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-20 14:37:22
	 */
	CouponBatchSendRecordPO selectByPrimaryKey(Long couponBatchSendRecordId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-20 14:37:22
	 */
	int updateByExampleSelective(@Param("record") CouponBatchSendRecordPO record,
                                 @Param("example") CouponBatchSendRecordPOExample example);

	/**
	 * 只读.
	 * @mbg.generated  2018-12-20 14:37:22
	 */
	int updateByExample(@Param("record") CouponBatchSendRecordPO record,
                        @Param("example") CouponBatchSendRecordPOExample example);

	/**
	 * 只读.
	 * @mbg.generated  2018-12-20 14:37:22
	 */
	int updateByPrimaryKeySelective(CouponBatchSendRecordPO record);

	/**
	 * 只读.
	 * @mbg.generated  2018-12-20 14:37:22
	 */
	int updateByPrimaryKey(CouponBatchSendRecordPO record);

	/**
     * 更新失败数量
     * @param count
     * @param couponBatchSendRecordId
     */
    void updateFailNum(@Param("count") Integer count, @Param("id") Long couponBatchSendRecordId);


    int updateSendNum(@Param("sendNum") Integer sendNum, @Param("couponBatchSendRecordId") Long couponBatchSendRecordId);
}