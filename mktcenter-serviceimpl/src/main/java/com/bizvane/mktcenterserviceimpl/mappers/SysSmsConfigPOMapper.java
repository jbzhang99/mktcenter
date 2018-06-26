package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.SysSmsConfigPO;
import com.bizvane.mktcenterservice.models.PO.SysSmsConfigPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSmsConfigPOMapper {
    long countByExample(SysSmsConfigPOExample example);

    int deleteByExample(SysSmsConfigPOExample example);

    int deleteByPrimaryKey(Long sysSmsConfigId);

    int insert(SysSmsConfigPO record);

    int insertSelective(SysSmsConfigPO record);

    List<SysSmsConfigPO> selectByExample(SysSmsConfigPOExample example);

    SysSmsConfigPO selectByPrimaryKey(Long sysSmsConfigId);

    int updateByExampleSelective(@Param("record") SysSmsConfigPO record, @Param("example") SysSmsConfigPOExample example);

    int updateByExample(@Param("record") SysSmsConfigPO record, @Param("example") SysSmsConfigPOExample example);

    int updateByPrimaryKeySelective(SysSmsConfigPO record);

    int updateByPrimaryKey(SysSmsConfigPO record);
}