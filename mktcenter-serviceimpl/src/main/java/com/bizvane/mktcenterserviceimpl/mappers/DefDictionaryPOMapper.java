package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.DefDictionaryPO;
import com.bizvane.mktcenterservice.models.PO.DefDictionaryPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DefDictionaryPOMapper {
    long countByExample(DefDictionaryPOExample example);

    int deleteByExample(DefDictionaryPOExample example);

    int deleteByPrimaryKey(Long defDictionaryId);

    int insert(DefDictionaryPO record);

    int insertSelective(DefDictionaryPO record);

    List<DefDictionaryPO> selectByExample(DefDictionaryPOExample example);

    DefDictionaryPO selectByPrimaryKey(Long defDictionaryId);

    int updateByExampleSelective(@Param("record") DefDictionaryPO record, @Param("example") DefDictionaryPOExample example);

    int updateByExample(@Param("record") DefDictionaryPO record, @Param("example") DefDictionaryPOExample example);

    int updateByPrimaryKeySelective(DefDictionaryPO record);

    int updateByPrimaryKey(DefDictionaryPO record);
}