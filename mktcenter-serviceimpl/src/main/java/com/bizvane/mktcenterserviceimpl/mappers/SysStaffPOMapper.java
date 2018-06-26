package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.SysStaffPO;
import com.bizvane.mktcenterservice.models.PO.SysStaffPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysStaffPOMapper {
    long countByExample(SysStaffPOExample example);

    int deleteByExample(SysStaffPOExample example);

    int deleteByPrimaryKey(Long sysStaffId);

    int insert(SysStaffPO record);

    int insertSelective(SysStaffPO record);

    List<SysStaffPO> selectByExample(SysStaffPOExample example);

    SysStaffPO selectByPrimaryKey(Long sysStaffId);

    int updateByExampleSelective(@Param("record") SysStaffPO record, @Param("example") SysStaffPOExample example);

    int updateByExample(@Param("record") SysStaffPO record, @Param("example") SysStaffPOExample example);

    int updateByPrimaryKeySelective(SysStaffPO record);

    int updateByPrimaryKey(SysStaffPO record);
}