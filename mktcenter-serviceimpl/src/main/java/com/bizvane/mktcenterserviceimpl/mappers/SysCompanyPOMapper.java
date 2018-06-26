package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.SysCompanyPO;
import com.bizvane.mktcenterservice.models.PO.SysCompanyPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCompanyPOMapper {
    long countByExample(SysCompanyPOExample example);

    int deleteByExample(SysCompanyPOExample example);

    int deleteByPrimaryKey(Long sysCompanyId);

    int insert(SysCompanyPO record);

    int insertSelective(SysCompanyPO record);

    List<SysCompanyPO> selectByExampleWithBLOBs(SysCompanyPOExample example);

    List<SysCompanyPO> selectByExample(SysCompanyPOExample example);

    SysCompanyPO selectByPrimaryKey(Long sysCompanyId);

    int updateByExampleSelective(@Param("record") SysCompanyPO record, @Param("example") SysCompanyPOExample example);

    int updateByExampleWithBLOBs(@Param("record") SysCompanyPO record, @Param("example") SysCompanyPOExample example);

    int updateByExample(@Param("record") SysCompanyPO record, @Param("example") SysCompanyPOExample example);

    int updateByPrimaryKeySelective(SysCompanyPO record);

    int updateByPrimaryKeyWithBLOBs(SysCompanyPO record);

    int updateByPrimaryKey(SysCompanyPO record);
}