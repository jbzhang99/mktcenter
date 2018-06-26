package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.SysAccountLoginLog;
import com.bizvane.mktcenterservice.models.PO.SysAccountLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAccountLoginLogMapper {
    long countByExample(SysAccountLoginLogExample example);

    int deleteByExample(SysAccountLoginLogExample example);

    int deleteByPrimaryKey(Long sysAccountLoginLogId);

    int insert(SysAccountLoginLog record);

    int insertSelective(SysAccountLoginLog record);

    List<SysAccountLoginLog> selectByExample(SysAccountLoginLogExample example);

    SysAccountLoginLog selectByPrimaryKey(Long sysAccountLoginLogId);

    int updateByExampleSelective(@Param("record") SysAccountLoginLog record, @Param("example") SysAccountLoginLogExample example);

    int updateByExample(@Param("record") SysAccountLoginLog record, @Param("example") SysAccountLoginLogExample example);

    int updateByPrimaryKeySelective(SysAccountLoginLog record);

    int updateByPrimaryKey(SysAccountLoginLog record);
}