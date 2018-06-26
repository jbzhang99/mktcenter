package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.DefProductMenuRelPO;
import com.bizvane.mktcenterservice.models.PO.DefProductMenuRelPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DefProductMenuRelPOMapper {
    long countByExample(DefProductMenuRelPOExample example);

    int deleteByExample(DefProductMenuRelPOExample example);

    int deleteByPrimaryKey(Long defProductMenuRelId);

    int insert(DefProductMenuRelPO record);

    int insertSelective(DefProductMenuRelPO record);

    List<DefProductMenuRelPO> selectByExample(DefProductMenuRelPOExample example);

    DefProductMenuRelPO selectByPrimaryKey(Long defProductMenuRelId);

    int updateByExampleSelective(@Param("record") DefProductMenuRelPO record, @Param("example") DefProductMenuRelPOExample example);

    int updateByExample(@Param("record") DefProductMenuRelPO record, @Param("example") DefProductMenuRelPOExample example);

    int updateByPrimaryKeySelective(DefProductMenuRelPO record);

    int updateByPrimaryKey(DefProductMenuRelPO record);
}