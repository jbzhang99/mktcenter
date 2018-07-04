package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.MktMbrTaskDetailPO;
import com.bizvane.mktcenterservice.models.PO.MktMbrTaskDetailPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktMbrTaskDetailPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    long countByExample(MktMbrTaskDetailPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int deleteByExample(MktMbrTaskDetailPOExample example);

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
    int insert(MktMbrTaskDetailPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int insertSelective(MktMbrTaskDetailPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    List<MktMbrTaskDetailPO> selectByExample(MktMbrTaskDetailPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    MktMbrTaskDetailPO selectByPrimaryKey(Long mktActivityId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int updateByExampleSelective(@Param("record") MktMbrTaskDetailPO record, @Param("example") MktMbrTaskDetailPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int updateByExample(@Param("record") MktMbrTaskDetailPO record, @Param("example") MktMbrTaskDetailPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int updateByPrimaryKeySelective(MktMbrTaskDetailPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int updateByPrimaryKey(MktMbrTaskDetailPO record);
}