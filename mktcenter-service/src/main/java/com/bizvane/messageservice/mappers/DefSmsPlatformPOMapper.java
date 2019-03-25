package com.bizvane.messageservice.mappers;

import com.bizvane.messagefacade.models.po.DefSmsPlatformPO;
import com.bizvane.messagefacade.models.po.DefSmsPlatformPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DefSmsPlatformPOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_def_sms_platform
     *
     * @mbg.generated Mon Aug 20 20:07:00 CST 2018
     */
    long countByExample(DefSmsPlatformPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_def_sms_platform
     *
     * @mbg.generated Mon Aug 20 20:07:00 CST 2018
     */
    int deleteByExample(DefSmsPlatformPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_def_sms_platform
     *
     * @mbg.generated Mon Aug 20 20:07:00 CST 2018
     */
    int deleteByPrimaryKey(Long platformId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_def_sms_platform
     *
     * @mbg.generated Mon Aug 20 20:07:00 CST 2018
     */
    int insert(DefSmsPlatformPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_def_sms_platform
     *
     * @mbg.generated Mon Aug 20 20:07:00 CST 2018
     */
    int insertSelective(DefSmsPlatformPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_def_sms_platform
     *
     * @mbg.generated Mon Aug 20 20:07:00 CST 2018
     */
    List<DefSmsPlatformPO> selectByExample(DefSmsPlatformPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_def_sms_platform
     *
     * @mbg.generated Mon Aug 20 20:07:00 CST 2018
     */
    DefSmsPlatformPO selectByPrimaryKey(Long platformId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_def_sms_platform
     *
     * @mbg.generated Mon Aug 20 20:07:00 CST 2018
     */
    int updateByExampleSelective(@Param("record") DefSmsPlatformPO record, @Param("example") DefSmsPlatformPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_def_sms_platform
     *
     * @mbg.generated Mon Aug 20 20:07:00 CST 2018
     */
    int updateByExample(@Param("record") DefSmsPlatformPO record, @Param("example") DefSmsPlatformPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_def_sms_platform
     *
     * @mbg.generated Mon Aug 20 20:07:00 CST 2018
     */
    int updateByPrimaryKeySelective(DefSmsPlatformPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_def_sms_platform
     *
     * @mbg.generated Mon Aug 20 20:07:00 CST 2018
     */
    int updateByPrimaryKey(DefSmsPlatformPO record);
}