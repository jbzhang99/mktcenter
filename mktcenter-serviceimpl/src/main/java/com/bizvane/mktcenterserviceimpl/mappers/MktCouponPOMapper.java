package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.po.MktCouponPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktCouponPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:34:37
	 */
	long countByExample(MktCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:34:37
	 */
	int deleteByExample(MktCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:34:37
	 */
	int deleteByPrimaryKey(Long mktCouponId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:34:37
	 */
	int insert(MktCouponPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:34:37
	 */
	int insertSelective(MktCouponPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:34:37
	 */
	List<MktCouponPO> selectByExample(MktCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:34:37
	 */
	MktCouponPO selectByPrimaryKey(Long mktCouponId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:34:37
	 */
	int updateByExampleSelective(@Param("record") MktCouponPO record, @Param("example") MktCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:34:37
	 */
	int updateByExample(@Param("record") MktCouponPO record, @Param("example") MktCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:34:37
	 */
	int updateByPrimaryKeySelective(MktCouponPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:34:37
	 */
	int updateByPrimaryKey(MktCouponPO record);
}