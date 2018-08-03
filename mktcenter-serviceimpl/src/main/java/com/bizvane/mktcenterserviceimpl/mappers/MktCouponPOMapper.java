package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.po.MktCouponPOExample;
import java.util.List;

import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import org.apache.ibatis.annotations.Param;

public interface MktCouponPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-03 14:00:57
	 */
	long countByExample(MktCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-03 14:00:57
	 */
	int deleteByExample(MktCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-03 14:00:57
	 */
	int deleteByPrimaryKey(Long mktCouponId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-03 14:00:57
	 */
	int insert(MktCouponPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-03 14:00:57
	 */
	int insertSelective(MktCouponPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-03 14:00:57
	 */
	List<MktCouponPO> selectByExample(MktCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-03 14:00:57
	 */
	MktCouponPO selectByPrimaryKey(Long mktCouponId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-03 14:00:57
	 */
	int updateByExampleSelective(@Param("record") MktCouponPO record, @Param("example") MktCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-03 14:00:57
	 */
	int updateByExample(@Param("record") MktCouponPO record, @Param("example") MktCouponPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-03 14:00:57
	 */
	int updateByPrimaryKeySelective(MktCouponPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-03 14:00:57
	 */
	int updateByPrimaryKey(MktCouponPO record);

	MktCouponPO selectMktActivityManualId(MktCouponPO mktCouponPO);

	MktCouponPO selectCouponCode(MktCouponPO mktCouponPO);
}