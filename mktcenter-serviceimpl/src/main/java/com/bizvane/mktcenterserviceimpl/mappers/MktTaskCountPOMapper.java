package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktTaskCountPO;
import com.bizvane.mktcenterservice.models.po.MktTaskCountPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}