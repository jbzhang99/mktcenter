package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktConvertCouponRecordPO;
import com.bizvane.mktcenterservice.models.po.MktConvertCouponRecordPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktConvertCouponRecordPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 21:48:36
	 */
	long countByExample(MktConvertCouponRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 21:48:36
	 */
	int deleteByExample(MktConvertCouponRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 21:48:36
	 */
	int deleteByPrimaryKey(Long convertCouponRecordId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 21:48:36
	 */
	int insert(MktConvertCouponRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 21:48:36
	 */
	int insertSelective(MktConvertCouponRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 21:48:36
	 */
	List<MktConvertCouponRecordPO> selectByExampleWithBLOBs(MktConvertCouponRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 21:48:36
	 */
	List<MktConvertCouponRecordPO> selectByExample(MktConvertCouponRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 21:48:36
	 */
	MktConvertCouponRecordPO selectByPrimaryKey(Long convertCouponRecordId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 21:48:36
	 */
	int updateByExampleSelective(@Param("record") MktConvertCouponRecordPO record,
			@Param("example") MktConvertCouponRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 21:48:36
	 */
	int updateByExampleWithBLOBs(@Param("record") MktConvertCouponRecordPO record,
			@Param("example") MktConvertCouponRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 21:48:36
	 */
	int updateByExample(@Param("record") MktConvertCouponRecordPO record,
			@Param("example") MktConvertCouponRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 21:48:36
	 */
	int updateByPrimaryKeySelective(MktConvertCouponRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 21:48:36
	 */
	int updateByPrimaryKeyWithBLOBs(MktConvertCouponRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-22 21:48:36
	 */
	int updateByPrimaryKey(MktConvertCouponRecordPO record);
}