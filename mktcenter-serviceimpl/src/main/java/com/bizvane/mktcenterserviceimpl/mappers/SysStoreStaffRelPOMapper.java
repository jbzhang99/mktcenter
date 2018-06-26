package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.SysStoreStaffRelPO;
import com.bizvane.mktcenterservice.models.PO.SysStoreStaffRelPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysStoreStaffRelPOMapper {
    long countByExample(SysStoreStaffRelPOExample example);

    int deleteByExample(SysStoreStaffRelPOExample example);

    int deleteByPrimaryKey(Long sysStoreStaffRelId);

    int insert(SysStoreStaffRelPO record);

    int insertSelective(SysStoreStaffRelPO record);

    List<SysStoreStaffRelPO> selectByExample(SysStoreStaffRelPOExample example);

    SysStoreStaffRelPO selectByPrimaryKey(Long sysStoreStaffRelId);

    int updateByExampleSelective(@Param("record") SysStoreStaffRelPO record, @Param("example") SysStoreStaffRelPOExample example);

    int updateByExample(@Param("record") SysStoreStaffRelPO record, @Param("example") SysStoreStaffRelPOExample example);

    int updateByPrimaryKeySelective(SysStoreStaffRelPO record);

    int updateByPrimaryKey(SysStoreStaffRelPO record);
}