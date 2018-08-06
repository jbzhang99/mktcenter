package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.po.MktCouponPOExample;
import java.util.List;

import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import org.apache.ibatis.annotations.Param;

public interface MktCouponPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-06 17:22:45
	 */
	long countByExample(MktCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-06 17:22:45
	 */
	int deleteByExample(MktCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-06 17:22:45
	 */
	int deleteByPrimaryKey(Long mktCouponId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-06 17:22:45
	 */
	int insert(MktCouponPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-06 17:22:45
	 */
	int insertSelective(MktCouponPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-06 17:22:45
	 */
	List<MktCouponPO> selectByExample(MktCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-06 17:22:45
	 */
	MktCouponPO selectByPrimaryKey(Long mktCouponId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-06 17:22:45
	 */
	int updateByExampleSelective(@Param("record") MktCouponPO record, @Param("example") MktCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-06 17:22:45
	 */
	int updateByExample(@Param("record") MktCouponPO record, @Param("example") MktCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-06 17:22:45
	 */
	int updateByPrimaryKeySelective(MktCouponPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-06 17:22:45
	 */
	int updateByPrimaryKey(MktCouponPO record);

	MktCouponPO selectMktActivityManualId(MktCouponPO mktCouponPO);

	MktCouponPO selectCouponCode(MktCouponPO mktCouponPO);
}