package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityCouponPO;
import com.bizvane.mktcenterservice.models.po.MktActivityCouponPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivityCouponPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	long countByExample(MktActivityCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int deleteByExample(MktActivityCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int deleteByPrimaryKey(Long mktActivityCouponId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int insert(MktActivityCouponPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int insertSelective(MktActivityCouponPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	List<MktActivityCouponPO> selectByExample(MktActivityCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	MktActivityCouponPO selectByPrimaryKey(Long mktActivityCouponId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int updateByExampleSelective(@Param("record") MktActivityCouponPO record,
			@Param("example") MktActivityCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int updateByExample(@Param("record") MktActivityCouponPO record,
			@Param("example") MktActivityCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int updateByPrimaryKeySelective(MktActivityCouponPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int updateByPrimaryKey(MktActivityCouponPO record);
}