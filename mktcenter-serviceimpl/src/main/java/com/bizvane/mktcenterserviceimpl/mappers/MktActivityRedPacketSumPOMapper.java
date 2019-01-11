package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityRedPacketSumPO;
import com.bizvane.mktcenterservice.models.po.MktActivityRedPacketSumPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivityRedPacketSumPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    long countByExample(MktActivityRedPacketSumPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int deleteByExample(MktActivityRedPacketSumPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int deleteByPrimaryKey(Long mktActivityRedPacketSumId);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int insert(MktActivityRedPacketSumPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int insertSelective(MktActivityRedPacketSumPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    List<MktActivityRedPacketSumPO> selectByExample(MktActivityRedPacketSumPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    MktActivityRedPacketSumPO selectByPrimaryKey(Long mktActivityRedPacketSumId);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int updateByExampleSelective(@Param("record") MktActivityRedPacketSumPO record, @Param("example") MktActivityRedPacketSumPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int updateByExample(@Param("record") MktActivityRedPacketSumPO record, @Param("example") MktActivityRedPacketSumPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int updateByPrimaryKeySelective(MktActivityRedPacketSumPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int updateByPrimaryKey(MktActivityRedPacketSumPO record);
}