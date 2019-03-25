package com.bizvane.couponservice.mappers;

import com.bizvane.couponfacade.models.po.CouponQuotaSendDetailPO;
import com.bizvane.couponfacade.models.po.CouponQuotaSendDetailPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponQuotaSendDetailPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    int countByExample(CouponQuotaSendDetailPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    int deleteByExample(CouponQuotaSendDetailPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    int deleteByPrimaryKey(Long couponQuotaSendDetailId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    int insert(CouponQuotaSendDetailPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    int insertSelective(CouponQuotaSendDetailPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    List<CouponQuotaSendDetailPO> selectByExample(CouponQuotaSendDetailPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    CouponQuotaSendDetailPO selectByPrimaryKey(Long couponQuotaSendDetailId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    int updateByExampleSelective(@Param("record") CouponQuotaSendDetailPO record, @Param("example") CouponQuotaSendDetailPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    int updateByExample(@Param("record") CouponQuotaSendDetailPO record, @Param("example") CouponQuotaSendDetailPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    int updateByPrimaryKeySelective(CouponQuotaSendDetailPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-12 10:15:42
     */
    int updateByPrimaryKey(CouponQuotaSendDetailPO record);
}