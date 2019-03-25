package com.bizvane.couponservice.mappers;

import com.bizvane.couponfacade.models.po.CouponQuotaDetailPO;
import com.bizvane.couponfacade.models.po.CouponQuotaDetailPOExample;
import com.bizvane.couponfacade.models.vo.CouponQuotaDetailVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponQuotaDetailPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	long countByExample(CouponQuotaDetailPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	int deleteByExample(CouponQuotaDetailPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	int deleteByPrimaryKey(Long couponQuotaDetailId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	int insert(CouponQuotaDetailPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	int insertSelective(CouponQuotaDetailPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	List<CouponQuotaDetailPO> selectByExampleWithBLOBs(CouponQuotaDetailPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	List<CouponQuotaDetailPO> selectByExample(CouponQuotaDetailPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	CouponQuotaDetailPO selectByPrimaryKey(Long couponQuotaDetailId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	int updateByExampleSelective(@Param("record") CouponQuotaDetailPO record,
                                 @Param("example") CouponQuotaDetailPOExample example);

	/**
	 * 只读.
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	int updateByExampleWithBLOBs(@Param("record") CouponQuotaDetailPO record,
                                 @Param("example") CouponQuotaDetailPOExample example);

	/**
	 * 只读.
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	int updateByExample(@Param("record") CouponQuotaDetailPO record,
                        @Param("example") CouponQuotaDetailPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	int updateByPrimaryKeySelective(CouponQuotaDetailPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	int updateByPrimaryKeyWithBLOBs(CouponQuotaDetailPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-12 17:54:49
	 */
	int updateByPrimaryKey(CouponQuotaDetailPO record);

	List<CouponQuotaDetailPO> findCouponQuotaDetailPOByConditions(@Param("vo") CouponQuotaDetailVO vo);
	List<CouponQuotaDetailPO> findCouponQuotaDetailPOByConditionsall(@Param("vo") CouponQuotaDetailVO vo);

}