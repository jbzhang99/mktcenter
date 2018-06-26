package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.DefMenuPO;
import com.bizvane.mktcenterservice.models.PO.DefMenuPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DefMenuPOMapper {
    long countByExample(DefMenuPOExample example);

    int deleteByExample(DefMenuPOExample example);

    int deleteByPrimaryKey(Long defMenuId);

    int insert(DefMenuPO record);

    int insertSelective(DefMenuPO record);

    List<DefMenuPO> selectByExample(DefMenuPOExample example);

    DefMenuPO selectByPrimaryKey(Long defMenuId);

    int updateByExampleSelective(@Param("record") DefMenuPO record, @Param("example") DefMenuPOExample example);

    int updateByExample(@Param("record") DefMenuPO record, @Param("example") DefMenuPOExample example);

    int updateByPrimaryKeySelective(DefMenuPO record);

    int updateByPrimaryKey(DefMenuPO record);
}