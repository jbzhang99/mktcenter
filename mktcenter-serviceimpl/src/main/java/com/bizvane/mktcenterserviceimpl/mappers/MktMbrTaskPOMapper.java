package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.MktMbrTaskPO;
import com.bizvane.mktcenterservice.models.PO.MktMbrTaskPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktMbrTaskPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    long countByExample(MktMbrTaskPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int deleteByExample(MktMbrTaskPOExample example);

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
    int insert(MktMbrTaskPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int insertSelective(MktMbrTaskPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    List<MktMbrTaskPO> selectByExample(MktMbrTaskPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    MktMbrTaskPO selectByPrimaryKey(Long mktActivityId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int updateByExampleSelective(@Param("record") MktMbrTaskPO record, @Param("example") MktMbrTaskPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int updateByExample(@Param("record") MktMbrTaskPO record, @Param("example") MktMbrTaskPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int updateByPrimaryKeySelective(MktMbrTaskPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int updateByPrimaryKey(MktMbrTaskPO record);
}