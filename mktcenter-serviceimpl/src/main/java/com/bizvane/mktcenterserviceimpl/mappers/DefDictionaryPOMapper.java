package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.DefDictionaryPO;
import com.bizvane.mktcenterservice.models.po.DefDictionaryPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DefDictionaryPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    long countByExample(DefDictionaryPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    int deleteByExample(DefDictionaryPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    int deleteByPrimaryKey(Long defDictionaryId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    int insert(DefDictionaryPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    int insertSelective(DefDictionaryPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    List<DefDictionaryPO> selectByExample(DefDictionaryPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    DefDictionaryPO selectByPrimaryKey(Long defDictionaryId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    int updateByExampleSelective(@Param("record") DefDictionaryPO record, @Param("example") DefDictionaryPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    int updateByExample(@Param("record") DefDictionaryPO record, @Param("example") DefDictionaryPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    int updateByPrimaryKeySelective(DefDictionaryPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-31 12:40:26
     */
    int updateByPrimaryKey(DefDictionaryPO record);
}