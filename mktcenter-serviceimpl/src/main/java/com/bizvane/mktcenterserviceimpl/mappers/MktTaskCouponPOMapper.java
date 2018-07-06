package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktTaskCouponPO;
import com.bizvane.mktcenterservice.models.po.MktTaskCouponPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktTaskCouponPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	long countByExample(MktTaskCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int deleteByExample(MktTaskCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int deleteByPrimaryKey(Long mktTaskCouponId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int insert(MktTaskCouponPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int insertSelective(MktTaskCouponPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	List<MktTaskCouponPO> selectByExample(MktTaskCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	MktTaskCouponPO selectByPrimaryKey(Long mktTaskCouponId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int updateByExampleSelective(@Param("record") MktTaskCouponPO record,
			@Param("example") MktTaskCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int updateByExample(@Param("record") MktTaskCouponPO record, @Param("example") MktTaskCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int updateByPrimaryKeySelective(MktTaskCouponPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int updateByPrimaryKey(MktTaskCouponPO record);
}