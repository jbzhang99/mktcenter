package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.SysOperationLogPO;
import com.bizvane.mktcenterservice.models.PO.SysOperationLogPOExample;
import com.bizvane.mktcenterservice.models.PO.SysOperationLogPOWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysOperationLogPOMapper {
    long countByExample(SysOperationLogPOExample example);

    int deleteByExample(SysOperationLogPOExample example);

    int deleteByPrimaryKey(Long sysOperationLogId);

    int insert(SysOperationLogPOWithBLOBs record);

    int insertSelective(SysOperationLogPOWithBLOBs record);

    List<SysOperationLogPOWithBLOBs> selectByExampleWithBLOBs(SysOperationLogPOExample example);

    List<SysOperationLogPO> selectByExample(SysOperationLogPOExample example);

    SysOperationLogPOWithBLOBs selectByPrimaryKey(Long sysOperationLogId);

    int updateByExampleSelective(@Param("record") SysOperationLogPOWithBLOBs record, @Param("example") SysOperationLogPOExample example);

    int updateByExampleWithBLOBs(@Param("record") SysOperationLogPOWithBLOBs record, @Param("example") SysOperationLogPOExample example);

    int updateByExample(@Param("record") SysOperationLogPO record, @Param("example") SysOperationLogPOExample example);

    int updateByPrimaryKeySelective(SysOperationLogPOWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SysOperationLogPOWithBLOBs record);

    int updateByPrimaryKey(SysOperationLogPO record);
}