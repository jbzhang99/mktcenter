package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityEvaluationPO;
import com.bizvane.mktcenterservice.models.po.MktActivityEvaluationPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivityEvaluationPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    long countByExample(MktActivityEvaluationPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    int deleteByExample(MktActivityEvaluationPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    int deleteByPrimaryKey(Long mktActivityEvaluationId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    int insert(MktActivityEvaluationPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    int insertSelective(MktActivityEvaluationPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    List<MktActivityEvaluationPO> selectByExampleWithBLOBs(MktActivityEvaluationPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    List<MktActivityEvaluationPO> selectByExample(MktActivityEvaluationPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    MktActivityEvaluationPO selectByPrimaryKey(Long mktActivityEvaluationId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    int updateByExampleSelective(@Param("record") MktActivityEvaluationPO record, @Param("example") MktActivityEvaluationPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    int updateByExampleWithBLOBs(@Param("record") MktActivityEvaluationPO record, @Param("example") MktActivityEvaluationPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    int updateByExample(@Param("record") MktActivityEvaluationPO record, @Param("example") MktActivityEvaluationPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    int updateByPrimaryKeySelective(MktActivityEvaluationPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    int updateByPrimaryKeyWithBLOBs(MktActivityEvaluationPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    int updateByPrimaryKey(MktActivityEvaluationPO record);
}