package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityPrizeRecordPO;
import com.bizvane.mktcenterservice.models.po.MktActivityPrizeRecordPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivityPrizeRecordPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    long countByExample(MktActivityPrizeRecordPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    int deleteByExample(MktActivityPrizeRecordPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    int deleteByPrimaryKey(Long mktActivityPrizeRecordId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    int insert(MktActivityPrizeRecordPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    int insertSelective(MktActivityPrizeRecordPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    List<MktActivityPrizeRecordPO> selectByExample(MktActivityPrizeRecordPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    MktActivityPrizeRecordPO selectByPrimaryKey(Long mktActivityPrizeRecordId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    int updateByExampleSelective(@Param("record") MktActivityPrizeRecordPO record, @Param("example") MktActivityPrizeRecordPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    int updateByExample(@Param("record") MktActivityPrizeRecordPO record, @Param("example") MktActivityPrizeRecordPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    int updateByPrimaryKeySelective(MktActivityPrizeRecordPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-12-18 15:22:31
     */
    int updateByPrimaryKey(MktActivityPrizeRecordPO record);
}