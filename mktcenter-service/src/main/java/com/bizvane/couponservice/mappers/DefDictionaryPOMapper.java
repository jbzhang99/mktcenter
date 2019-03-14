package com.bizvane.couponservice.mappers;

import com.bizvane.couponfacade.models.po.DefDictionaryPO;
import com.bizvane.couponfacade.models.po.DefDictionaryPOExample;
import com.bizvane.utils.tenant.QuarantineAnnotation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@QuarantineAnnotation
public interface DefDictionaryPOMapper {

  /**
   * 只读. 
   * @mbg.generated  2018-06-27 15:56:28
   */
  long countByExample(DefDictionaryPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-06-27 15:56:28
   */
  int deleteByExample(DefDictionaryPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-06-27 15:56:28
   */
  int deleteByPrimaryKey(Long defDictionaryId);

  /**
   * 只读. 
   * @mbg.generated  2018-06-27 15:56:28
   */
  int insert(DefDictionaryPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-06-27 15:56:28
   */
  int insertSelective(DefDictionaryPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-06-27 15:56:28
   */
  List<DefDictionaryPO> selectByExample(DefDictionaryPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-06-27 15:56:28
   */
  DefDictionaryPO selectByPrimaryKey(Long defDictionaryId);

  /**
   * 只读. 
   * @mbg.generated  2018-06-27 15:56:28
   */
  int updateByExampleSelective(@Param("record") DefDictionaryPO record,
                               @Param("example") DefDictionaryPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-06-27 15:56:28
   */
  int updateByExample(@Param("record") DefDictionaryPO record, @Param("example") DefDictionaryPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-06-27 15:56:28
   */
  int updateByPrimaryKeySelective(DefDictionaryPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-06-27 15:56:28
   */
  int updateByPrimaryKey(DefDictionaryPO record);
}