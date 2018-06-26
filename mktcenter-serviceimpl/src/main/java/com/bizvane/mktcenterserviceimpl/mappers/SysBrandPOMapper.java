package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.SysBrandPO;
import com.bizvane.mktcenterservice.models.PO.SysBrandPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysBrandPOMapper {
    long countByExample(SysBrandPOExample example);

    int deleteByExample(SysBrandPOExample example);

    int deleteByPrimaryKey(Long sysBrandId);

    int insert(SysBrandPO record);

    int insertSelective(SysBrandPO record);

    List<SysBrandPO> selectByExampleWithBLOBs(SysBrandPOExample example);

    List<SysBrandPO> selectByExample(SysBrandPOExample example);

    SysBrandPO selectByPrimaryKey(Long sysBrandId);

    int updateByExampleSelective(@Param("record") SysBrandPO record, @Param("example") SysBrandPOExample example);

    int updateByExampleWithBLOBs(@Param("record") SysBrandPO record, @Param("example") SysBrandPOExample example);

    int updateByExample(@Param("record") SysBrandPO record, @Param("example") SysBrandPOExample example);

    int updateByPrimaryKeySelective(SysBrandPO record);

    int updateByPrimaryKeyWithBLOBs(SysBrandPO record);

    int updateByPrimaryKey(SysBrandPO record);
}