package com.bizvane.mktcenterservice.mappers;

import com.bizvane.mktcenterfacade.models.po.MktActivityMqLogPO;
import com.bizvane.mktcenterfacade.models.po.MktActivityMqLogPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivityMqLogPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	long countByExample(MktActivityMqLogPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int deleteByExample(MktActivityMqLogPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int deleteByPrimaryKey(Long mktActivityMqLogId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int insert(MktActivityMqLogPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int insertSelective(MktActivityMqLogPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	List<MktActivityMqLogPO> selectByExample(MktActivityMqLogPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	MktActivityMqLogPO selectByPrimaryKey(Long mktActivityMqLogId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByExampleSelective(@Param("record") MktActivityMqLogPO record,
			@Param("example") MktActivityMqLogPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByExample(@Param("record") MktActivityMqLogPO record,
			@Param("example") MktActivityMqLogPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByPrimaryKeySelective(MktActivityMqLogPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByPrimaryKey(MktActivityMqLogPO record);
}