package com.bizvane.messageservice.mappers;

import com.bizvane.messagefacade.models.po.MsgSmsTempPO;
import com.bizvane.messagefacade.models.po.MsgSmsTempPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsgSmsTempPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    long countByExample(MsgSmsTempPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    int deleteByExample(MsgSmsTempPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    int deleteByPrimaryKey(Long msgSmsTempId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    int insert(MsgSmsTempPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    int insertSelective(MsgSmsTempPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    List<MsgSmsTempPO> selectByExampleWithBLOBs(MsgSmsTempPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    List<MsgSmsTempPO> selectByExample(MsgSmsTempPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    MsgSmsTempPO selectByPrimaryKey(Long msgSmsTempId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    int updateByExampleSelective(@Param("record") MsgSmsTempPO record, @Param("example") MsgSmsTempPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    int updateByExampleWithBLOBs(@Param("record") MsgSmsTempPO record, @Param("example") MsgSmsTempPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    int updateByExample(@Param("record") MsgSmsTempPO record, @Param("example") MsgSmsTempPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    int updateByPrimaryKeySelective(MsgSmsTempPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    int updateByPrimaryKeyWithBLOBs(MsgSmsTempPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    int updateByPrimaryKey(MsgSmsTempPO record);
}