package com.bizvane.mktcenterservice.mappers;

import com.bizvane.mktcenterfacade.models.po.MktTaskCountPO;
import com.bizvane.mktcenterfacade.models.po.MktTaskCountPOExample;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface MktTaskCountPOMapper {

  /**
   * 只读. 
   * @mbg.generated  2018-12-06 15:41:41
   */
  long countByExample(MktTaskCountPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-12-06 15:41:41
   */
  int deleteByExample(MktTaskCountPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-12-06 15:41:41
   */
  int deleteByPrimaryKey(Long mktTaskCountId);

  /**
   * 只读. 
   * @mbg.generated  2018-12-06 15:41:41
   */
  int insert(MktTaskCountPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-12-06 15:41:41
   */
  int insertSelective(MktTaskCountPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-12-06 15:41:41
   */
  List<MktTaskCountPO> selectByExample(MktTaskCountPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-12-06 15:41:41
   */
  MktTaskCountPO selectByPrimaryKey(Long mktTaskCountId);

  /**
   * 只读. 
   * @mbg.generated  2018-12-06 15:41:41
   */
  int updateByExampleSelective(@Param("record") MktTaskCountPO record, @Param("example") MktTaskCountPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-12-06 15:41:41
   */
  int updateByExample(@Param("record") MktTaskCountPO record, @Param("example") MktTaskCountPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-12-06 15:41:41
   */
  int updateByPrimaryKeySelective(MktTaskCountPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-12-06 15:41:41
   */
  int updateByPrimaryKey(MktTaskCountPO record);
  
  @Update("update t_mkt_task_count set "
      + " member_count=member_count+#{memberCount}, "
      + " consume_amount_sum=consume_amount_sum + #{consumeAmount}, "
      + " coupon_num_sum=coupon_num_sum + #{couponNum},  "
      + " points_sum=points_sum + #{points} ,"
      + " share_num_sum=share_num_sum + #{shareNum} "
      + " where mkt_task_id=#{mktTaskId} ")
  int updateSum(@Param("mktTaskId") Long mktTaskId, @Param("memberCount") Integer memberCount,  @Param("consumeAmount") BigDecimal consumeAmount, 
      @Param("couponNum") Integer couponNum, @Param("points") Integer points, @Param("shareNum") Integer shareNum);
}