package com.bizvane.messageservice.mappers;

import com.bizvane.messagefacade.models.po.MsgPlaceholderPO;
import com.bizvane.messagefacade.models.po.MsgPlaceholderPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsgPlaceholderPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 20:32:17
     */
    long countByExample(MsgPlaceholderPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 20:32:17
     */
    int deleteByExample(MsgPlaceholderPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 20:32:17
     */
    int deleteByPrimaryKey(Long msgPlaceholderId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 20:32:17
     */
    int insert(MsgPlaceholderPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 20:32:17
     */
    int insertSelective(MsgPlaceholderPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 20:32:17
     */
    List<MsgPlaceholderPO> selectByExample(MsgPlaceholderPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 20:32:17
     */
    MsgPlaceholderPO selectByPrimaryKey(Long msgPlaceholderId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 20:32:17
     */
    int updateByExampleSelective(@Param("record") MsgPlaceholderPO record, @Param("example") MsgPlaceholderPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 20:32:17
     */
    int updateByExample(@Param("record") MsgPlaceholderPO record, @Param("example") MsgPlaceholderPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 20:32:17
     */
    int updateByPrimaryKeySelective(MsgPlaceholderPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 20:32:17
     */
    int updateByPrimaryKey(MsgPlaceholderPO record);
}