package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.DefLocationPO;
import com.bizvane.mktcenterservice.models.PO.DefLocationPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DefLocationPOMapper {
    long countByExample(DefLocationPOExample example);

    int deleteByExample(DefLocationPOExample example);

    int deleteByPrimaryKey(Long defLocationId);

    int insert(DefLocationPO record);

    int insertSelective(DefLocationPO record);

    List<DefLocationPO> selectByExample(DefLocationPOExample example);

    DefLocationPO selectByPrimaryKey(Long defLocationId);

    int updateByExampleSelective(@Param("record") DefLocationPO record, @Param("example") DefLocationPOExample example);

    int updateByExample(@Param("record") DefLocationPO record, @Param("example") DefLocationPOExample example);

    int updateByPrimaryKeySelective(DefLocationPO record);

    int updateByPrimaryKey(DefLocationPO record);
}