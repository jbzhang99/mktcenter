package com.bizvane.messageservice.mappers;

import com.bizvane.messagefacade.models.po.MsmVerifcodePO;
import com.bizvane.messagefacade.models.po.MsmVerifcodePOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsmVerifcodePOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	long countByExample(MsmVerifcodePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	int deleteByExample(MsmVerifcodePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	int deleteByPrimaryKey(Long verifcodeId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	int insert(MsmVerifcodePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	int insertSelective(MsmVerifcodePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	List<MsmVerifcodePO> selectByExample(MsmVerifcodePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	MsmVerifcodePO selectByPrimaryKey(Long verifcodeId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	int updateByExampleSelective(@Param("record") MsmVerifcodePO record,
                                 @Param("example") MsmVerifcodePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	int updateByExample(@Param("record") MsmVerifcodePO record, @Param("example") MsmVerifcodePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	int updateByPrimaryKeySelective(MsmVerifcodePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	int updateByPrimaryKey(MsmVerifcodePO record);
}