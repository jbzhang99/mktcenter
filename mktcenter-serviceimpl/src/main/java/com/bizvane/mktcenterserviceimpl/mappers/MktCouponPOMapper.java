package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.po.MktCouponPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktCouponPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	long countByExample(MktCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	int deleteByExample(MktCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	int deleteByPrimaryKey(Long mktCouponId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	int insert(MktCouponPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	int insertSelective(MktCouponPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	List<MktCouponPO> selectByExample(MktCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	MktCouponPO selectByPrimaryKey(Long mktCouponId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	int updateByExampleSelective(@Param("record") MktCouponPO record, @Param("example") MktCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	int updateByExample(@Param("record") MktCouponPO record, @Param("example") MktCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	int updateByPrimaryKeySelective(MktCouponPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	int updateByPrimaryKey(MktCouponPO record);
}