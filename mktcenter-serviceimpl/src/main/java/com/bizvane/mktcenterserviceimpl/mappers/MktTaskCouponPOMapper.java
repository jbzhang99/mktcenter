package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktTaskCouponPO;
import com.bizvane.mktcenterservice.models.po.MktTaskCouponPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktTaskCouponPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    long countByExample(MktTaskCouponPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int deleteByExample(MktTaskCouponPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int deleteByPrimaryKey(Long mktTaskCouponId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int insert(MktTaskCouponPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int insertSelective(MktTaskCouponPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    List<MktTaskCouponPO> selectByExample(MktTaskCouponPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    MktTaskCouponPO selectByPrimaryKey(Long mktTaskCouponId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByExampleSelective(@Param("record") MktTaskCouponPO record, @Param("example") MktTaskCouponPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByExample(@Param("record") MktTaskCouponPO record, @Param("example") MktTaskCouponPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByPrimaryKeySelective(MktTaskCouponPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByPrimaryKey(MktTaskCouponPO record);
}