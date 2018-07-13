package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityMqLogPO;
import com.bizvane.mktcenterservice.models.po.MktActivityMqLogPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivityMqLogPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	long countByExample(MktActivityMqLogPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int deleteByExample(MktActivityMqLogPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int deleteByPrimaryKey(Long mktActivityMqLogId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int insert(MktActivityMqLogPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int insertSelective(MktActivityMqLogPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	List<MktActivityMqLogPO> selectByExample(MktActivityMqLogPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	MktActivityMqLogPO selectByPrimaryKey(Long mktActivityMqLogId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int updateByExampleSelective(@Param("record") MktActivityMqLogPO record,
			@Param("example") MktActivityMqLogPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int updateByExample(@Param("record") MktActivityMqLogPO record,
			@Param("example") MktActivityMqLogPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int updateByPrimaryKeySelective(MktActivityMqLogPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int updateByPrimaryKey(MktActivityMqLogPO record);
}