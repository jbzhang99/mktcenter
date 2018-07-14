package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityMqLogPO;
import com.bizvane.mktcenterservice.models.po.MktActivityMqLogPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivityMqLogPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	long countByExample(MktActivityMqLogPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int deleteByExample(MktActivityMqLogPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int deleteByPrimaryKey(Long mktActivityMqLogId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int insert(MktActivityMqLogPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int insertSelective(MktActivityMqLogPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	List<MktActivityMqLogPO> selectByExample(MktActivityMqLogPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	MktActivityMqLogPO selectByPrimaryKey(Long mktActivityMqLogId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByExampleSelective(@Param("record") MktActivityMqLogPO record,
			@Param("example") MktActivityMqLogPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByExample(@Param("record") MktActivityMqLogPO record,
			@Param("example") MktActivityMqLogPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByPrimaryKeySelective(MktActivityMqLogPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByPrimaryKey(MktActivityMqLogPO record);
}