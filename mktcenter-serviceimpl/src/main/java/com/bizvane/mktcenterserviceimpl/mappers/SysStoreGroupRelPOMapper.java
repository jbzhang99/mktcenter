package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.SysStoreGroupRelPO;
import com.bizvane.mktcenterservice.models.PO.SysStoreGroupRelPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysStoreGroupRelPOMapper {
    long countByExample(SysStoreGroupRelPOExample example);

    int deleteByExample(SysStoreGroupRelPOExample example);

    int deleteByPrimaryKey(Long sysStoreGroupRelId);

    int insert(SysStoreGroupRelPO record);

    int insertSelective(SysStoreGroupRelPO record);

    List<SysStoreGroupRelPO> selectByExample(SysStoreGroupRelPOExample example);

    SysStoreGroupRelPO selectByPrimaryKey(Long sysStoreGroupRelId);

    int updateByExampleSelective(@Param("record") SysStoreGroupRelPO record, @Param("example") SysStoreGroupRelPOExample example);

    int updateByExample(@Param("record") SysStoreGroupRelPO record, @Param("example") SysStoreGroupRelPOExample example);

    int updateByPrimaryKeySelective(SysStoreGroupRelPO record);

    int updateByPrimaryKey(SysStoreGroupRelPO record);
}