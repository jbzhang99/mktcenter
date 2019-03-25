package com.bizvane.messageservice.mappers;

import com.bizvane.messagefacade.models.po.MsgVerifcodePO;
import com.bizvane.messagefacade.models.po.MsgVerifcodePOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsgVerifcodePOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_msg_verifcode
     *
     * @mbg.generated Fri Aug 31 15:34:28 CST 2018
     */
    long countByExample(MsgVerifcodePOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_msg_verifcode
     *
     * @mbg.generated Fri Aug 31 15:34:28 CST 2018
     */
    int deleteByExample(MsgVerifcodePOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_msg_verifcode
     *
     * @mbg.generated Fri Aug 31 15:34:28 CST 2018
     */
    int deleteByPrimaryKey(Long verifcodeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_msg_verifcode
     *
     * @mbg.generated Fri Aug 31 15:34:28 CST 2018
     */
    int insert(MsgVerifcodePO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_msg_verifcode
     *
     * @mbg.generated Fri Aug 31 15:34:28 CST 2018
     */
    int insertSelective(MsgVerifcodePO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_msg_verifcode
     *
     * @mbg.generated Fri Aug 31 15:34:28 CST 2018
     */
    List<MsgVerifcodePO> selectByExample(MsgVerifcodePOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_msg_verifcode
     *
     * @mbg.generated Fri Aug 31 15:34:28 CST 2018
     */
    MsgVerifcodePO selectByPrimaryKey(Long verifcodeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_msg_verifcode
     *
     * @mbg.generated Fri Aug 31 15:34:28 CST 2018
     */
    int updateByExampleSelective(@Param("record") MsgVerifcodePO record, @Param("example") MsgVerifcodePOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_msg_verifcode
     *
     * @mbg.generated Fri Aug 31 15:34:28 CST 2018
     */
    int updateByExample(@Param("record") MsgVerifcodePO record, @Param("example") MsgVerifcodePOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_msg_verifcode
     *
     * @mbg.generated Fri Aug 31 15:34:28 CST 2018
     */
    int updateByPrimaryKeySelective(MsgVerifcodePO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_msg_verifcode
     *
     * @mbg.generated Fri Aug 31 15:34:28 CST 2018
     */
    int updateByPrimaryKey(MsgVerifcodePO record);
}