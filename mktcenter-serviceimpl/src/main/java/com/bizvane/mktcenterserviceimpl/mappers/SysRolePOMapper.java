package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.SysRolePO;
import com.bizvane.mktcenterservice.models.PO.SysRolePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRolePOMapper {
    long countByExample(SysRolePOExample example);

    int deleteByExample(SysRolePOExample example);

    int deleteByPrimaryKey(Long sysRoleId);

    int insert(SysRolePO record);

    int insertSelective(SysRolePO record);

    List<SysRolePO> selectByExample(SysRolePOExample example);

    SysRolePO selectByPrimaryKey(Long sysRoleId);

    int updateByExampleSelective(@Param("record") SysRolePO record, @Param("example") SysRolePOExample example);

    int updateByExample(@Param("record") SysRolePO record, @Param("example") SysRolePOExample example);

    int updateByPrimaryKeySelective(SysRolePO record);

    int updateByPrimaryKey(SysRolePO record);
}