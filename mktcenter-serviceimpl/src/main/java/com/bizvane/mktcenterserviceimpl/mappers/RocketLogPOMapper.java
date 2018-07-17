package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.RocketLogPO;
import com.bizvane.mktcenterservice.models.po.RocketLogPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RocketLogPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    long countByExample(RocketLogPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    int deleteByExample(RocketLogPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    int deleteByPrimaryKey(Long rocketLogId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    int insert(RocketLogPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    int insertSelective(RocketLogPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    List<RocketLogPO> selectByExample(RocketLogPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    RocketLogPO selectByPrimaryKey(Long rocketLogId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    int updateByExampleSelective(@Param("record") RocketLogPO record, @Param("example") RocketLogPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    int updateByExample(@Param("record") RocketLogPO record, @Param("example") RocketLogPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    int updateByPrimaryKeySelective(RocketLogPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    int updateByPrimaryKey(RocketLogPO record);
}