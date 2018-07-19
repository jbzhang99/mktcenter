package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityManualPO;
import com.bizvane.mktcenterservice.models.po.MktActivityManualPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivityManualPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    long countByExample(MktActivityManualPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    int deleteByExample(MktActivityManualPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    int deleteByPrimaryKey(Long mktActivityManualId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    int insert(MktActivityManualPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    int insertSelective(MktActivityManualPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    List<MktActivityManualPO> selectByExample(MktActivityManualPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    MktActivityManualPO selectByPrimaryKey(Long mktActivityManualId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    int updateByExampleSelective(@Param("record") MktActivityManualPO record, @Param("example") MktActivityManualPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    int updateByExample(@Param("record") MktActivityManualPO record, @Param("example") MktActivityManualPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    int updateByPrimaryKeySelective(MktActivityManualPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-19 16:07:25
     */
    int updateByPrimaryKey(MktActivityManualPO record);
}