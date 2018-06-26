package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.SysCompanyProductPO;
import com.bizvane.mktcenterservice.models.PO.SysCompanyProductPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCompanyProductPOMapper {
    long countByExample(SysCompanyProductPOExample example);

    int deleteByExample(SysCompanyProductPOExample example);

    int deleteByPrimaryKey(Long sysCompanyProductId);

    int insert(SysCompanyProductPO record);

    int insertSelective(SysCompanyProductPO record);

    List<SysCompanyProductPO> selectByExample(SysCompanyProductPOExample example);

    SysCompanyProductPO selectByPrimaryKey(Long sysCompanyProductId);

    int updateByExampleSelective(@Param("record") SysCompanyProductPO record, @Param("example") SysCompanyProductPOExample example);

    int updateByExample(@Param("record") SysCompanyProductPO record, @Param("example") SysCompanyProductPOExample example);

    int updateByPrimaryKeySelective(SysCompanyProductPO record);

    int updateByPrimaryKey(SysCompanyProductPO record);
}