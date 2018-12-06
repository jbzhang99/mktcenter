package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityCountPO;
import com.bizvane.mktcenterservice.models.po.MktActivityCountPOExample;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface MktActivityCountPOMapper {

  /**
   * 只读. 
   * @mbg.generated  2018-12-06 15:41:41
   */
  long countByExample(MktActivityCountPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-12-06 15:41:41
   */
  int deleteByExample(MktActivityCountPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-12-06 15:41:41
   */
  int deleteByPrimaryKey(Long mktActivityCountId);

  /**
   * 只读. 
   * @mbg.generated  2018-12-06 15:41:41
   */
  int insert(MktActivityCountPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-12-06 15:41:41
   */
  int insertSelective(MktActivityCountPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-12-06 15:41:41
   */
  List<MktActivityCountPO> selectByExample(MktActivityCountPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-12-06 15:41:41
   */
  MktActivityCountPO selectByPrimaryKey(Long mktActivityCountId);

  /**
   * 只读. 
   * @mbg.generated  2018-12-06 15:41:41
   */
  int updateByExampleSelective(@Param("record") MktActivityCountPO record,
      @Param("example") MktActivityCountPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-12-06 15:41:41
   */
  int updateByExample(@Param("record") MktActivityCountPO record, @Param("example") MktActivityCountPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-12-06 15:41:41
   */
  int updateByPrimaryKeySelective(MktActivityCountPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-12-06 15:41:41
   */
  int updateByPrimaryKey(MktActivityCountPO record);
  
  @Update("update t_mkt_activity_count set member_count=member_count+#{memberCount}, order_amount_sum=order_amount_sum + #{orderAmount}, "
      + " points_sum=points_sum + #{points} where mkt_activity_count_id=#{mktActivityCountId} ")
  int updateSum(@Param("mktActivityCountId") Long mktActivityCountId, @Param("memberCount") Integer memberCount,
      @Param("orderAmount") BigDecimal orderAmount, @Param("points") Integer points);
}