package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityMqLogPO;
import com.bizvane.mktcenterservice.models.po.MktActivityMqLogPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivityMqLogPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	long countByExample(MktActivityMqLogPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int deleteByExample(MktActivityMqLogPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int deleteByPrimaryKey(Long mktActivityMqLogId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int insert(MktActivityMqLogPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int insertSelective(MktActivityMqLogPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	List<MktActivityMqLogPO> selectByExample(MktActivityMqLogPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	MktActivityMqLogPO selectByPrimaryKey(Long mktActivityMqLogId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int updateByExampleSelective(@Param("record") MktActivityMqLogPO record,
			@Param("example") MktActivityMqLogPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int updateByExample(@Param("record") MktActivityMqLogPO record,
			@Param("example") MktActivityMqLogPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int updateByPrimaryKeySelective(MktActivityMqLogPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int updateByPrimaryKey(MktActivityMqLogPO record);
}