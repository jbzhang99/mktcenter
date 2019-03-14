package com.bizvane.couponservice.mappers;

import com.bizvane.couponfacade.models.po.CouponDefinitionCodePO;
import com.bizvane.couponfacade.models.po.CouponDefinitionCodePOExample;
import com.bizvane.couponfacade.models.vo.CouponDefinitionCodeQueryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponDefinitionCodePOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	long countByExample(CouponDefinitionCodePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	int deleteByExample(CouponDefinitionCodePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	int deleteByPrimaryKey(Long couponDefinitionCodeId);

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	int insert(CouponDefinitionCodePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	int insertSelective(CouponDefinitionCodePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	List<CouponDefinitionCodePO> selectByExample(CouponDefinitionCodePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	CouponDefinitionCodePO selectByPrimaryKey(Long couponDefinitionCodeId);

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	int updateByExampleSelective(@Param("record") CouponDefinitionCodePO record,
                                 @Param("example") CouponDefinitionCodePOExample example);

	/**
	 * 只读.
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	int updateByExample(@Param("record") CouponDefinitionCodePO record,
                        @Param("example") CouponDefinitionCodePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	int updateByPrimaryKeySelective(CouponDefinitionCodePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2019-03-11 16:34:48
	 */
	int updateByPrimaryKey(CouponDefinitionCodePO record);

	List<CouponDefinitionCodePO> findCouponCode(CouponDefinitionCodeQueryVO vo, Long sysBrandId, Long sysCompanyId);
}