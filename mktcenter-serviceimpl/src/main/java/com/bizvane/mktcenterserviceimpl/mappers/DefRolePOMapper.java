package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.DefRolePO;
import com.bizvane.mktcenterservice.models.PO.DefRolePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DefRolePOMapper {
    long countByExample(DefRolePOExample example);

    int deleteByExample(DefRolePOExample example);

    int deleteByPrimaryKey(Long defRoleId);

    int insert(DefRolePO record);

    int insertSelective(DefRolePO record);

    List<DefRolePO> selectByExample(DefRolePOExample example);

    DefRolePO selectByPrimaryKey(Long defRoleId);

    int updateByExampleSelective(@Param("record") DefRolePO record, @Param("example") DefRolePOExample example);

    int updateByExample(@Param("record") DefRolePO record, @Param("example") DefRolePOExample example);

    int updateByPrimaryKeySelective(DefRolePO record);

    int updateByPrimaryKey(DefRolePO record);
}