package com.bizvane.couponservice.mappers;

import com.bizvane.couponfacade.models.po.CouponQuotaPO;
import com.bizvane.couponfacade.models.po.CouponQuotaPOExample;
import com.bizvane.couponfacade.models.vo.CouponQuotaVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponQuotaPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	long countByExample(CouponQuotaPOExample example);
	
    List<CouponQuotaPO> findCouponEntityByConditions(@Param("vo") CouponQuotaVO vo);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	int deleteByExample(CouponQuotaPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	int deleteByPrimaryKey(Long couponQuotaId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	int insert(CouponQuotaPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	int insertSelective(CouponQuotaPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	List<CouponQuotaPO> selectByExample(CouponQuotaPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	CouponQuotaPO selectByPrimaryKey(Long couponQuotaId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	int updateByExampleSelective(@Param("record") CouponQuotaPO record, @Param("example") CouponQuotaPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	int updateByExample(@Param("record") CouponQuotaPO record, @Param("example") CouponQuotaPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	int updateByPrimaryKeySelective(CouponQuotaPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-11-23 17:48:21
	 */
	int updateByPrimaryKey(CouponQuotaPO record);
}