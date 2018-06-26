package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.SysStoreGroupPO;
import com.bizvane.mktcenterservice.models.PO.SysStoreGroupPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysStoreGroupPOMapper {
    long countByExample(SysStoreGroupPOExample example);

    int deleteByExample(SysStoreGroupPOExample example);

    int deleteByPrimaryKey(Long sysStoreGroupId);

    int insert(SysStoreGroupPO record);

    int insertSelective(SysStoreGroupPO record);

    List<SysStoreGroupPO> selectByExample(SysStoreGroupPOExample example);

    SysStoreGroupPO selectByPrimaryKey(Long sysStoreGroupId);

    int updateByExampleSelective(@Param("record") SysStoreGroupPO record, @Param("example") SysStoreGroupPOExample example);

    int updateByExample(@Param("record") SysStoreGroupPO record, @Param("example") SysStoreGroupPOExample example);

    int updateByPrimaryKeySelective(SysStoreGroupPO record);

    int updateByPrimaryKey(SysStoreGroupPO record);
}