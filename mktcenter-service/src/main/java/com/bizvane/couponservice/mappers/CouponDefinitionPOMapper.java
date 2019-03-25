package com.bizvane.couponservice.mappers;

import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.po.CouponDefinitionPOExample;
import com.bizvane.couponfacade.models.po.CouponDefinitionPOWithBLOBs;
import com.bizvane.couponfacade.models.vo.CouponDefinitionListQueryVO;
import com.bizvane.utils.tenant.QuarantineAnnotation;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@QuarantineAnnotation
public interface CouponDefinitionPOMapper {
    
    
    
    //非系统sql
    
    /**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	long countByExample(CouponDefinitionPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	int deleteByExample(CouponDefinitionPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	int deleteByPrimaryKey(Long couponDefinitionId);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	int insert(CouponDefinitionPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	int insertSelective(CouponDefinitionPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	List<CouponDefinitionPOWithBLOBs> selectByExampleWithBLOBs(CouponDefinitionPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	List<CouponDefinitionPO> selectByExample(CouponDefinitionPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	CouponDefinitionPOWithBLOBs selectByPrimaryKey(Long couponDefinitionId);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	int updateByExampleSelective(@Param("record") CouponDefinitionPOWithBLOBs record,
                                 @Param("example") CouponDefinitionPOExample example);

	/**
	 * 只读.
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	int updateByExampleWithBLOBs(@Param("record") CouponDefinitionPOWithBLOBs record,
                                 @Param("example") CouponDefinitionPOExample example);

	/**
	 * 只读.
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	int updateByExample(@Param("record") CouponDefinitionPO record,
                        @Param("example") CouponDefinitionPOExample example);

	/**
	 * 只读.
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	int updateByPrimaryKeySelective(CouponDefinitionPOWithBLOBs record);

	/**
	 * 只读.
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	int updateByPrimaryKeyWithBLOBs(CouponDefinitionPOWithBLOBs record);

	/**
	 * 只读.
	 * @mbg.generated  2019-01-16 17:48:34
	 */
	int updateByPrimaryKey(CouponDefinitionPO record);

	/**
     * 券定义列表
     * @param vo
     * @return
     */
      List<CouponDefinitionPO> findCouponDefinitionListByConds(@Param("vo") CouponDefinitionListQueryVO vo,
                                                               @Param("sysBrandId") Long sysBrandId,
                                                               @Param("sysCompanyId") Long sysCompanyId);

    /**
     * 查询可用的券列表
     * @param
     * @param brandId
     * @param date
     * @param valid
     * @param status
     * @param couponDefinitionId
     * @param couponName
     * @return
     */
    List<CouponDefinitionPOWithBLOBs> getUseList(@Param("transferFission") Boolean transferFission, @Param("preferentialType") Byte preferentialType, @Param("brandId") Long brandId, @Param("date") Date date, @Param("valid") Boolean valid,
                                                 @Param("status") Boolean status, @Param("couponDefinitionId") Long couponDefinitionId,
                                                 @Param("couponName") String couponName, @Param("interval") Byte interval,
                                                 @Param("someday") Byte someday);

	/**
	 * 根据DefinitionId精确查询和根据券名称模糊查询
	 */
	List<CouponDefinitionPO> selectByDefinitionAndCouponName(CouponDefinitionPO couponDefinitionPO1);
	/**
	 * 根据DefinitionId查找CouponDefinition对象
	 */
    List<CouponDefinitionPO> selectByDefinitionId(Long vouTypeId);
}