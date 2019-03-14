package com.bizvane.couponservice.mappers;

import com.bizvane.couponfacade.models.po.CouponBatchSendDetailPO;
import com.bizvane.couponfacade.models.po.CouponBatchSendDetailPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponBatchSendDetailPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	long countByExample(CouponBatchSendDetailPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	int deleteByExample(CouponBatchSendDetailPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	int deleteByPrimaryKey(Long tCouponBatchSendDetailId);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	int insert(CouponBatchSendDetailPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	int insertSelective(CouponBatchSendDetailPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	List<CouponBatchSendDetailPO> selectByExample(CouponBatchSendDetailPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	CouponBatchSendDetailPO selectByPrimaryKey(Long tCouponBatchSendDetailId);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	int updateByExampleSelective(@Param("record") CouponBatchSendDetailPO record,
                                 @Param("example") CouponBatchSendDetailPOExample example);

	/**
	 * 只读.
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	int updateByExample(@Param("record") CouponBatchSendDetailPO record,
                        @Param("example") CouponBatchSendDetailPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	int updateByPrimaryKeySelective(CouponBatchSendDetailPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	int updateByPrimaryKey(CouponBatchSendDetailPO record);
}