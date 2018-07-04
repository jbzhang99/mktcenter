package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.MktActivityMqLogPO;
import com.bizvane.mktcenterservice.models.PO.MktActivityMqLogPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivityMqLogPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    long countByExample(MktActivityMqLogPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int deleteByExample(MktActivityMqLogPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int deleteByPrimaryKey(Long mktActivityId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int insert(MktActivityMqLogPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int insertSelective(MktActivityMqLogPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    List<MktActivityMqLogPO> selectByExample(MktActivityMqLogPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    MktActivityMqLogPO selectByPrimaryKey(Long mktActivityId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int updateByExampleSelective(@Param("record") MktActivityMqLogPO record, @Param("example") MktActivityMqLogPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int updateByExample(@Param("record") MktActivityMqLogPO record, @Param("example") MktActivityMqLogPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int updateByPrimaryKeySelective(MktActivityMqLogPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int updateByPrimaryKey(MktActivityMqLogPO record);
}