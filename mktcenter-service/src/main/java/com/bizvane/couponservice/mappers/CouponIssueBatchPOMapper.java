package com.bizvane.couponservice.mappers;

import com.bizvane.couponfacade.models.po.CouponIssueBatchPO;
import com.bizvane.couponfacade.models.po.CouponIssueBatchPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponIssueBatchPOMapper {

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  long countByExample(CouponIssueBatchPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  int deleteByExample(CouponIssueBatchPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  int deleteByPrimaryKey(Long couponIssueBatchId);

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  int insert(CouponIssueBatchPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  int insertSelective(CouponIssueBatchPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  List<CouponIssueBatchPO> selectByExample(CouponIssueBatchPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  CouponIssueBatchPO selectByPrimaryKey(Long couponIssueBatchId);

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  int updateByExampleSelective(@Param("record") CouponIssueBatchPO record,
                               @Param("example") CouponIssueBatchPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  int updateByExample(@Param("record") CouponIssueBatchPO record, @Param("example") CouponIssueBatchPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  int updateByPrimaryKeySelective(CouponIssueBatchPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-07-06 10:56:28
   */
  int updateByPrimaryKey(CouponIssueBatchPO record);
}