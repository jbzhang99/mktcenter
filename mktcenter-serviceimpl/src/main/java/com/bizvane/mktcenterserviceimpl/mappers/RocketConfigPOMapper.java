package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.RocketConfigPO;
import com.bizvane.mktcenterservice.models.po.RocketConfigPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RocketConfigPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    long countByExample(RocketConfigPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    int deleteByExample(RocketConfigPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    int deleteByPrimaryKey(Integer rocketConfigId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    int insert(RocketConfigPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    int insertSelective(RocketConfigPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    List<RocketConfigPO> selectByExample(RocketConfigPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    RocketConfigPO selectByPrimaryKey(Integer rocketConfigId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    int updateByExampleSelective(@Param("record") RocketConfigPO record, @Param("example") RocketConfigPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    int updateByExample(@Param("record") RocketConfigPO record, @Param("example") RocketConfigPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    int updateByPrimaryKeySelective(RocketConfigPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-17 10:38:52
     */
    int updateByPrimaryKey(RocketConfigPO record);
}