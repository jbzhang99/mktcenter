package com.bizvane.couponservice.mappers;

import com.bizvane.couponfacade.models.po.CouponStatusLogPO;
import com.bizvane.couponfacade.models.po.CouponStatusLogPOExample;
import com.bizvane.utils.tenant.QuarantineAnnotation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@QuarantineAnnotation
public interface CouponStatusLogPOMapper {

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  long countByExample(CouponStatusLogPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  int deleteByExample(CouponStatusLogPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  int deleteByPrimaryKey(Long couponStatusLogId);

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  int insert(CouponStatusLogPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  int insertSelective(CouponStatusLogPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  List<CouponStatusLogPO> selectByExample(CouponStatusLogPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  CouponStatusLogPO selectByPrimaryKey(Long couponStatusLogId);

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  int updateByExampleSelective(@Param("record") CouponStatusLogPO record,
                               @Param("example") CouponStatusLogPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  int updateByExample(@Param("record") CouponStatusLogPO record, @Param("example") CouponStatusLogPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  int updateByPrimaryKeySelective(CouponStatusLogPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-07-27 16:45:43
   */
  int updateByPrimaryKey(CouponStatusLogPO record);
}