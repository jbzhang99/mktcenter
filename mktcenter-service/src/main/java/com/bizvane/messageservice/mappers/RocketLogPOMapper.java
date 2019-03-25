package com.bizvane.messageservice.mappers;

import com.bizvane.messagefacade.models.po.RocketLogPO;
import com.bizvane.messagefacade.models.po.RocketLogPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RocketLogPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    long countByExample(RocketLogPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int deleteByExample(RocketLogPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int deleteByPrimaryKey(Long rocketLogId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int insert(RocketLogPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int insertSelective(RocketLogPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    List<RocketLogPO> selectByExample(RocketLogPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    RocketLogPO selectByPrimaryKey(Long rocketLogId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int updateByExampleSelective(@Param("record") RocketLogPO record, @Param("example") RocketLogPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int updateByExample(@Param("record") RocketLogPO record, @Param("example") RocketLogPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int updateByPrimaryKeySelective(RocketLogPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int updateByPrimaryKey(RocketLogPO record);
}