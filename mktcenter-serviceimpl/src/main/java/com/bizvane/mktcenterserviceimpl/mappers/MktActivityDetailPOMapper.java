package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.MktActivityDetailPO;
import com.bizvane.mktcenterservice.models.PO.MktActivityDetailPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivityDetailPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    long countByExample(MktActivityDetailPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int deleteByExample(MktActivityDetailPOExample example);

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
    int insert(MktActivityDetailPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int insertSelective(MktActivityDetailPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    List<MktActivityDetailPO> selectByExample(MktActivityDetailPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    MktActivityDetailPO selectByPrimaryKey(Long mktActivityId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int updateByExampleSelective(@Param("record") MktActivityDetailPO record, @Param("example") MktActivityDetailPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int updateByExample(@Param("record") MktActivityDetailPO record, @Param("example") MktActivityDetailPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int updateByPrimaryKeySelective(MktActivityDetailPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-04 11:16:30
     */
    int updateByPrimaryKey(MktActivityDetailPO record);
}