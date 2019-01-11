package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityRedPacketPO;
import com.bizvane.mktcenterservice.models.po.MktActivityRedPacketPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivityRedPacketPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    long countByExample(MktActivityRedPacketPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int deleteByExample(MktActivityRedPacketPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int deleteByPrimaryKey(Long mktActivityRedPacketId);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int insert(MktActivityRedPacketPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int insertSelective(MktActivityRedPacketPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    List<MktActivityRedPacketPO> selectByExample(MktActivityRedPacketPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    MktActivityRedPacketPO selectByPrimaryKey(Long mktActivityRedPacketId);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int updateByExampleSelective(@Param("record") MktActivityRedPacketPO record, @Param("example") MktActivityRedPacketPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int updateByExample(@Param("record") MktActivityRedPacketPO record, @Param("example") MktActivityRedPacketPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int updateByPrimaryKeySelective(MktActivityRedPacketPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int updateByPrimaryKey(MktActivityRedPacketPO record);
}