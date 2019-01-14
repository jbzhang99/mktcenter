package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityRedPacketRecordPO;
import com.bizvane.mktcenterservice.models.po.MktActivityRedPacketRecordPOExample;
import com.bizvane.mktcenterservice.models.vo.ActivityRedPacketVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MktActivityRedPacketRecordPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    long countByExample(MktActivityRedPacketRecordPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int deleteByExample(MktActivityRedPacketRecordPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int deleteByPrimaryKey(Long mktActivityRedPacketRecordId);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int insert(MktActivityRedPacketRecordPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int insertSelective(MktActivityRedPacketRecordPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    List<MktActivityRedPacketRecordPO> selectByExample(MktActivityRedPacketRecordPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    MktActivityRedPacketRecordPO selectByPrimaryKey(Long mktActivityRedPacketRecordId);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int updateByExampleSelective(@Param("record") MktActivityRedPacketRecordPO record, @Param("example") MktActivityRedPacketRecordPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int updateByExample(@Param("record") MktActivityRedPacketRecordPO record, @Param("example") MktActivityRedPacketRecordPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int updateByPrimaryKeySelective(MktActivityRedPacketRecordPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int updateByPrimaryKey(MktActivityRedPacketRecordPO record);

    Integer  getRedPacketCount(ActivityRedPacketVO vo);
}