package com.bizvane.messageservice.mappers;

import com.bizvane.messagefacade.models.po.WxPublicPO;
import com.bizvane.messagefacade.models.po.WxPublicPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxPublicPOMapper {

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  long countByExample(WxPublicPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  int deleteByExample(WxPublicPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  int deleteByPrimaryKey(Long wxPublicId);

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  int insert(WxPublicPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  int insertSelective(WxPublicPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  List<WxPublicPO> selectByExample(WxPublicPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  WxPublicPO selectByPrimaryKey(Long wxPublicId);

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  int updateByExampleSelective(@Param("record") WxPublicPO record, @Param("example") WxPublicPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  int updateByExample(@Param("record") WxPublicPO record, @Param("example") WxPublicPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  int updateByPrimaryKeySelective(WxPublicPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  int updateByPrimaryKey(WxPublicPO record);
}