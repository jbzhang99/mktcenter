package com.bizvane.couponservice.mappers;

import com.bizvane.couponfacade.models.po.CouponOfflineBindPO;
import com.bizvane.couponfacade.models.po.CouponOfflineBindPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponOfflineBindPOMapper {

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  long countByExample(CouponOfflineBindPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  int deleteByExample(CouponOfflineBindPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  int deleteByPrimaryKey(Long couponOfflineBindId);

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  int insert(CouponOfflineBindPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  int insertSelective(CouponOfflineBindPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  List<CouponOfflineBindPO> selectByExampleWithBLOBs(CouponOfflineBindPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  List<CouponOfflineBindPO> selectByExample(CouponOfflineBindPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  CouponOfflineBindPO selectByPrimaryKey(Long couponOfflineBindId);

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  int updateByExampleSelective(@Param("record") CouponOfflineBindPO record,
                               @Param("example") CouponOfflineBindPOExample example);

  /**
   * 只读.
   * @mbg.generated  2018-07-26 09:54:19
   */
  int updateByExampleWithBLOBs(@Param("record") CouponOfflineBindPO record,
                               @Param("example") CouponOfflineBindPOExample example);

  /**
   * 只读.
   * @mbg.generated  2018-07-26 09:54:19
   */
  int updateByExample(@Param("record") CouponOfflineBindPO record,
                      @Param("example") CouponOfflineBindPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  int updateByPrimaryKeySelective(CouponOfflineBindPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  int updateByPrimaryKeyWithBLOBs(CouponOfflineBindPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-07-26 09:54:19
   */
  int updateByPrimaryKey(CouponOfflineBindPO record);
}