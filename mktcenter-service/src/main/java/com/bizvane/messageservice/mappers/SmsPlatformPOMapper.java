package com.bizvane.messageservice.mappers;

import com.bizvane.messagefacade.models.po.SmsPlatformPO;
import com.bizvane.messagefacade.models.po.SmsPlatformPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsPlatformPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	long countByExample(SmsPlatformPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	int deleteByExample(SmsPlatformPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	int deleteByPrimaryKey(Long platformId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	int insert(SmsPlatformPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	int insertSelective(SmsPlatformPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	List<SmsPlatformPO> selectByExample(SmsPlatformPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	SmsPlatformPO selectByPrimaryKey(Long platformId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	int updateByExampleSelective(@Param("record") SmsPlatformPO record, @Param("example") SmsPlatformPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	int updateByExample(@Param("record") SmsPlatformPO record, @Param("example") SmsPlatformPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	int updateByPrimaryKeySelective(SmsPlatformPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-10 19:55:07
	 */
	int updateByPrimaryKey(SmsPlatformPO record);
}