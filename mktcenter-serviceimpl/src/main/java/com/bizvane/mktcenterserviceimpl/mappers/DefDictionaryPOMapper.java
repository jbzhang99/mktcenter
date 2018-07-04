package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.PO.DefDictionaryPO;
import com.bizvane.mktcenterservice.models.PO.DefDictionaryPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DefDictionaryPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-04 11:13:59
	 */
	long countByExample(DefDictionaryPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-04 11:13:59
	 */
	int deleteByExample(DefDictionaryPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-04 11:13:59
	 */
	int deleteByPrimaryKey(Long mktActivityId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-04 11:13:59
	 */
	int insert(DefDictionaryPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-04 11:13:59
	 */
	int insertSelective(DefDictionaryPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-04 11:13:59
	 */
	List<DefDictionaryPO> selectByExample(DefDictionaryPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-04 11:13:59
	 */
	DefDictionaryPO selectByPrimaryKey(Long mktActivityId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-04 11:13:59
	 */
	int updateByExampleSelective(@Param("record") DefDictionaryPO record,
			@Param("example") DefDictionaryPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-04 11:13:59
	 */
	int updateByExample(@Param("record") DefDictionaryPO record, @Param("example") DefDictionaryPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-04 11:13:59
	 */
	int updateByPrimaryKeySelective(DefDictionaryPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-04 11:13:59
	 */
	int updateByPrimaryKey(DefDictionaryPO record);
}