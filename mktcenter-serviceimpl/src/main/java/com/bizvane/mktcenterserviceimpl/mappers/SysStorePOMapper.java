package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.SysStorePO;
import com.bizvane.mktcenterservice.models.PO.SysStorePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysStorePOMapper {
    long countByExample(SysStorePOExample example);

    int deleteByExample(SysStorePOExample example);

    int deleteByPrimaryKey(Long sysStoreId);

    int insert(SysStorePO record);

    int insertSelective(SysStorePO record);

    List<SysStorePO> selectByExampleWithBLOBs(SysStorePOExample example);

    List<SysStorePO> selectByExample(SysStorePOExample example);

    SysStorePO selectByPrimaryKey(Long sysStoreId);

    int updateByExampleSelective(@Param("record") SysStorePO record, @Param("example") SysStorePOExample example);

    int updateByExampleWithBLOBs(@Param("record") SysStorePO record, @Param("example") SysStorePOExample example);

    int updateByExample(@Param("record") SysStorePO record, @Param("example") SysStorePOExample example);

    int updateByPrimaryKeySelective(SysStorePO record);

    int updateByPrimaryKeyWithBLOBs(SysStorePO record);

    int updateByPrimaryKey(SysStorePO record);
}