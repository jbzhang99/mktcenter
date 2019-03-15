package com.bizvane.messageservice.mappers;

import com.bizvane.messagefacade.models.po.MsgCoupontimePO;
import com.bizvane.messagefacade.models.po.MsgCoupontimePOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsgCoupontimePOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_msg_coupontime
     *
     * @mbg.generated Tue Sep 04 19:52:44 CST 2018
     */
    long countByExample(MsgCoupontimePOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_msg_coupontime
     *
     * @mbg.generated Tue Sep 04 19:52:44 CST 2018
     */
    int deleteByExample(MsgCoupontimePOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_msg_coupontime
     *
     * @mbg.generated Tue Sep 04 19:52:44 CST 2018
     */
    int deleteByPrimaryKey(Long msgSendtimeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_msg_coupontime
     *
     * @mbg.generated Tue Sep 04 19:52:44 CST 2018
     */
    int insert(MsgCoupontimePO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_msg_coupontime
     *
     * @mbg.generated Tue Sep 04 19:52:44 CST 2018
     */
    int insertSelective(MsgCoupontimePO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_msg_coupontime
     *
     * @mbg.generated Tue Sep 04 19:52:44 CST 2018
     */
    List<MsgCoupontimePO> selectByExample(MsgCoupontimePOExample example);
    List<MsgCoupontimePO> selectByExampletest(MsgCoupontimePOExample example, Long limit, Long to);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_msg_coupontime
     *
     * @mbg.generated Tue Sep 04 19:52:44 CST 2018
     */
    MsgCoupontimePO selectByPrimaryKey(Long msgSendtimeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_msg_coupontime
     *
     * @mbg.generated Tue Sep 04 19:52:44 CST 2018
     */
    int updateByExampleSelective(@Param("record") MsgCoupontimePO record, @Param("example") MsgCoupontimePOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_msg_coupontime
     *
     * @mbg.generated Tue Sep 04 19:52:44 CST 2018
     */
    int updateByExample(@Param("record") MsgCoupontimePO record, @Param("example") MsgCoupontimePOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_msg_coupontime
     *
     * @mbg.generated Tue Sep 04 19:52:44 CST 2018
     */
    int updateByPrimaryKeySelective(MsgCoupontimePO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_msg_coupontime
     *
     * @mbg.generated Tue Sep 04 19:52:44 CST 2018
     */
    int updateByPrimaryKey(MsgCoupontimePO record);
}