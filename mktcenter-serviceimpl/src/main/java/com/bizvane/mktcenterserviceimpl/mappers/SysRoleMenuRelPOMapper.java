package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.SysRoleMenuRelPO;
import com.bizvane.mktcenterservice.models.PO.SysRoleMenuRelPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMenuRelPOMapper {
    long countByExample(SysRoleMenuRelPOExample example);

    int deleteByExample(SysRoleMenuRelPOExample example);

    int deleteByPrimaryKey(Long sysRoleMenuRelId);

    int insert(SysRoleMenuRelPO record);

    int insertSelective(SysRoleMenuRelPO record);

    List<SysRoleMenuRelPO> selectByExample(SysRoleMenuRelPOExample example);

    SysRoleMenuRelPO selectByPrimaryKey(Long sysRoleMenuRelId);

    int updateByExampleSelective(@Param("record") SysRoleMenuRelPO record, @Param("example") SysRoleMenuRelPOExample example);

    int updateByExample(@Param("record") SysRoleMenuRelPO record, @Param("example") SysRoleMenuRelPOExample example);

    int updateByPrimaryKeySelective(SysRoleMenuRelPO record);

    int updateByPrimaryKey(SysRoleMenuRelPO record);
}