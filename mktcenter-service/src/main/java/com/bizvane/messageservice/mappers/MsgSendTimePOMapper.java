package com.bizvane.messageservice.mappers;


import com.bizvane.messagefacade.models.po.MsgSendTimePO;
import com.bizvane.messagefacade.models.po.MsgSendTimePOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsgSendTimePOMapper {
    int countByExample(MsgSendTimePOExample example);

    int deleteByExample(MsgSendTimePOExample example);

    int deleteByPrimaryKey(Long msgSendtimeId);

    int insert(MsgSendTimePO record);

    int insertSelective(MsgSendTimePO record);

    List<MsgSendTimePO> selectByExample(MsgSendTimePOExample example);

    MsgSendTimePO selectByPrimaryKey(Long msgSendtimeId);

    int updateByExampleSelective(@Param("record") MsgSendTimePO record, @Param("example") MsgSendTimePOExample example);

    int updateByExample(@Param("record") MsgSendTimePO record, @Param("example") MsgSendTimePOExample example);

    int updateByPrimaryKeySelective(MsgSendTimePO record);

    int updateByPrimaryKey(MsgSendTimePO record);
}