package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.DefProductPO;
import com.bizvane.mktcenterservice.models.PO.DefProductPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DefProductPOMapper {
    long countByExample(DefProductPOExample example);

    int deleteByExample(DefProductPOExample example);

    int deleteByPrimaryKey(Long defProductId);

    int insert(DefProductPO record);

    int insertSelective(DefProductPO record);

    List<DefProductPO> selectByExample(DefProductPOExample example);

    DefProductPO selectByPrimaryKey(Long defProductId);

    int updateByExampleSelective(@Param("record") DefProductPO record, @Param("example") DefProductPOExample example);

    int updateByExample(@Param("record") DefProductPO record, @Param("example") DefProductPOExample example);

    int updateByPrimaryKeySelective(DefProductPO record);

    int updateByPrimaryKey(DefProductPO record);
}