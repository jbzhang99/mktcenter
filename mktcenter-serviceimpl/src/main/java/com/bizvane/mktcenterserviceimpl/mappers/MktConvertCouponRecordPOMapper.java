package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktConvertCouponRecordPO;
import com.bizvane.mktcenterservice.models.po.MktConvertCouponRecordPOExample;
import java.util.List;

import com.bizvane.mktcenterservice.models.vo.CouponRecordVO;
import org.apache.ibatis.annotations.Param;

public interface MktConvertCouponRecordPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-26 14:51:19
	 */
	long countByExample(MktConvertCouponRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-26 14:51:19
	 */
	int deleteByExample(MktConvertCouponRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-26 14:51:19
	 */
	int deleteByPrimaryKey(Long convertCouponRecordId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-26 14:51:19
	 */
	int insert(MktConvertCouponRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-26 14:51:19
	 */
	int insertSelective(MktConvertCouponRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-26 14:51:19
	 */
	List<MktConvertCouponRecordPO> selectByExampleWithBLOBs(MktConvertCouponRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-26 14:51:19
	 */
	List<MktConvertCouponRecordPO> selectByExample(MktConvertCouponRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-26 14:51:19
	 */
	MktConvertCouponRecordPO selectByPrimaryKey(Long convertCouponRecordId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-26 14:51:19
	 */
	int updateByExampleSelective(@Param("record") MktConvertCouponRecordPO record,
			@Param("example") MktConvertCouponRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-26 14:51:19
	 */
	int updateByExampleWithBLOBs(@Param("record") MktConvertCouponRecordPO record,
			@Param("example") MktConvertCouponRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-26 14:51:19
	 */
	int updateByExample(@Param("record") MktConvertCouponRecordPO record,
			@Param("example") MktConvertCouponRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-26 14:51:19
	 */
	int updateByPrimaryKeySelective(MktConvertCouponRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-26 14:51:19
	 */
	int updateByPrimaryKeyWithBLOBs(MktConvertCouponRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-26 14:51:19
	 */
	int updateByPrimaryKey(MktConvertCouponRecordPO record);

	List<MktConvertCouponRecordPO> getCouponRecordLists(@Param("vo")CouponRecordVO vo);
	List<MktConvertCouponRecordPO> getCouponRecordLists(@Param("vo") CouponRecordVO vo,@Param("a")Long a,@Param("b")Long b);
	Integer getConvertNumber(CouponRecordVO vo);
}