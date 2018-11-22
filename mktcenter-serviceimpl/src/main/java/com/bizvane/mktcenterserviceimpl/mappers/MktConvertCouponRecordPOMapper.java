package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktConvertCouponRecordPO;
import com.bizvane.mktcenterservice.models.po.MktConvertCouponRecordPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktConvertCouponRecordPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    long countByExample(MktConvertCouponRecordPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    int deleteByExample(MktConvertCouponRecordPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    int deleteByPrimaryKey(Long convertCouponRecordId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    int insert(MktConvertCouponRecordPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    int insertSelective(MktConvertCouponRecordPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    List<MktConvertCouponRecordPO> selectByExample(MktConvertCouponRecordPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    MktConvertCouponRecordPO selectByPrimaryKey(Long convertCouponRecordId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    int updateByExampleSelective(@Param("record") MktConvertCouponRecordPO record, @Param("example") MktConvertCouponRecordPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    int updateByExample(@Param("record") MktConvertCouponRecordPO record, @Param("example") MktConvertCouponRecordPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    int updateByPrimaryKeySelective(MktConvertCouponRecordPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    int updateByPrimaryKey(MktConvertCouponRecordPO record);
}