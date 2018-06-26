package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.SysAccountRoleRelPO;
import com.bizvane.mktcenterservice.models.PO.SysAccountRoleRelPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAccountRoleRelPOMapper {
    long countByExample(SysAccountRoleRelPOExample example);

    int deleteByExample(SysAccountRoleRelPOExample example);

    int deleteByPrimaryKey(Long sysAccountRoleRelId);

    int insert(SysAccountRoleRelPO record);

    int insertSelective(SysAccountRoleRelPO record);

    List<SysAccountRoleRelPO> selectByExample(SysAccountRoleRelPOExample example);

    SysAccountRoleRelPO selectByPrimaryKey(Long sysAccountRoleRelId);

    int updateByExampleSelective(@Param("record") SysAccountRoleRelPO record, @Param("example") SysAccountRoleRelPOExample example);

    int updateByExample(@Param("record") SysAccountRoleRelPO record, @Param("example") SysAccountRoleRelPOExample example);

    int updateByPrimaryKeySelective(SysAccountRoleRelPO record);

    int updateByPrimaryKey(SysAccountRoleRelPO record);
}