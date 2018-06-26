package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.SysAccountPO;
import com.bizvane.mktcenterservice.models.PO.SysAccountPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAccountPOMapper {
    long countByExample(SysAccountPOExample example);

    int deleteByExample(SysAccountPOExample example);

    int deleteByPrimaryKey(Long sysAccountId);

    int insert(SysAccountPO record);

    int insertSelective(SysAccountPO record);

    List<SysAccountPO> selectByExample(SysAccountPOExample example);

    SysAccountPO selectByPrimaryKey(Long sysAccountId);

    int updateByExampleSelective(@Param("record") SysAccountPO record, @Param("example") SysAccountPOExample example);

    int updateByExample(@Param("record") SysAccountPO record, @Param("example") SysAccountPOExample example);

    int updateByPrimaryKeySelective(SysAccountPO record);

    int updateByPrimaryKey(SysAccountPO record);
}