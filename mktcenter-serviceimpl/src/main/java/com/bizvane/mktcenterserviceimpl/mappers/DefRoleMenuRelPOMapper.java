package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.DefRoleMenuRelPO;
import com.bizvane.mktcenterservice.models.PO.DefRoleMenuRelPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DefRoleMenuRelPOMapper {
    long countByExample(DefRoleMenuRelPOExample example);

    int deleteByExample(DefRoleMenuRelPOExample example);

    int deleteByPrimaryKey(Long defRoleMenuRelId);

    int insert(DefRoleMenuRelPO record);

    int insertSelective(DefRoleMenuRelPO record);

    List<DefRoleMenuRelPO> selectByExample(DefRoleMenuRelPOExample example);

    DefRoleMenuRelPO selectByPrimaryKey(Long defRoleMenuRelId);

    int updateByExampleSelective(@Param("record") DefRoleMenuRelPO record, @Param("example") DefRoleMenuRelPOExample example);

    int updateByExample(@Param("record") DefRoleMenuRelPO record, @Param("example") DefRoleMenuRelPOExample example);

    int updateByPrimaryKeySelective(DefRoleMenuRelPO record);

    int updateByPrimaryKey(DefRoleMenuRelPO record);
}