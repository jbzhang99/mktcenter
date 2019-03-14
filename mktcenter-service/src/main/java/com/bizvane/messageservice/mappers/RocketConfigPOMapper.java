package com.bizvane.messageservice.mappers;

import com.bizvane.messagefacade.models.po.RocketConfigPO;
import com.bizvane.messagefacade.models.po.RocketConfigPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RocketConfigPOMapper {

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  long countByExample(RocketConfigPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  int deleteByExample(RocketConfigPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  int deleteByPrimaryKey(Integer rocketConfigId);

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  int insert(RocketConfigPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  int insertSelective(RocketConfigPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  List<RocketConfigPO> selectByExample(RocketConfigPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  RocketConfigPO selectByPrimaryKey(Integer rocketConfigId);

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  int updateByExampleSelective(@Param("record") RocketConfigPO record, @Param("example") RocketConfigPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  int updateByExample(@Param("record") RocketConfigPO record, @Param("example") RocketConfigPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  int updateByPrimaryKeySelective(RocketConfigPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  int updateByPrimaryKey(RocketConfigPO record);
}