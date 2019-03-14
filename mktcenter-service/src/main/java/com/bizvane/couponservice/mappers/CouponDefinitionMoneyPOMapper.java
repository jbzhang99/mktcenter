package com.bizvane.couponservice.mappers;

import com.bizvane.couponfacade.models.po.CouponDefinitionMoneyPO;
import com.bizvane.couponfacade.models.po.CouponDefinitionMoneyPOExample;
import com.bizvane.utils.tenant.QuarantineAnnotation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@QuarantineAnnotation
public interface CouponDefinitionMoneyPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    long countByExample(CouponDefinitionMoneyPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    int deleteByExample(CouponDefinitionMoneyPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    int deleteByPrimaryKey(Long couponDefinitionMoneyId);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    int insert(CouponDefinitionMoneyPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    int insertSelective(CouponDefinitionMoneyPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    List<CouponDefinitionMoneyPO> selectByExample(CouponDefinitionMoneyPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    CouponDefinitionMoneyPO selectByPrimaryKey(Long couponDefinitionMoneyId);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    int updateByExampleSelective(@Param("record") CouponDefinitionMoneyPO record, @Param("example") CouponDefinitionMoneyPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    int updateByExample(@Param("record") CouponDefinitionMoneyPO record, @Param("example") CouponDefinitionMoneyPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    int updateByPrimaryKeySelective(CouponDefinitionMoneyPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-15 18:05:45
     */
    int updateByPrimaryKey(CouponDefinitionMoneyPO record);
}