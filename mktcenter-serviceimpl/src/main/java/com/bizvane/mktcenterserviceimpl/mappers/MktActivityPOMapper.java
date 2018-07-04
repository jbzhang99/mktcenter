package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.MktActivityPO;
import com.bizvane.mktcenterservice.models.PO.MktActivityPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivityPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    long countByExample(MktActivityPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int deleteByExample(MktActivityPOExample example);

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
    int insert(MktActivityPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int insertSelective(MktActivityPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    List<MktActivityPO> selectByExample(MktActivityPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    MktActivityPO selectByPrimaryKey(Long mktActivityId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int updateByExampleSelective(@Param("record") MktActivityPO record, @Param("example") MktActivityPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int updateByExample(@Param("record") MktActivityPO record, @Param("example") MktActivityPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int updateByPrimaryKeySelective(MktActivityPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int updateByPrimaryKey(MktActivityPO record);
}