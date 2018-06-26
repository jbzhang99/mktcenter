package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.DefFunctionPO;
import com.bizvane.mktcenterservice.models.PO.DefFunctionPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DefFunctionPOMapper {
    long countByExample(DefFunctionPOExample example);

    int deleteByExample(DefFunctionPOExample example);

    int deleteByPrimaryKey(Long defFunctionId);

    int insert(DefFunctionPO record);

    int insertSelective(DefFunctionPO record);

    List<DefFunctionPO> selectByExample(DefFunctionPOExample example);

    DefFunctionPO selectByPrimaryKey(Long defFunctionId);

    int updateByExampleSelective(@Param("record") DefFunctionPO record, @Param("example") DefFunctionPOExample example);

    int updateByExample(@Param("record") DefFunctionPO record, @Param("example") DefFunctionPOExample example);

    int updateByPrimaryKeySelective(DefFunctionPO record);

    int updateByPrimaryKey(DefFunctionPO record);
}