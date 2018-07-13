package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityRecordPO;
import com.bizvane.mktcenterservice.models.po.MktActivityRecordPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivityRecordPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	long countByExample(MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int deleteByExample(MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int deleteByPrimaryKey(Long mktActivityRecordId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int insert(MktActivityRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int insertSelective(MktActivityRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	List<MktActivityRecordPO> selectByExample(MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	MktActivityRecordPO selectByPrimaryKey(Long mktActivityRecordId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int updateByExampleSelective(@Param("record") MktActivityRecordPO record,
			@Param("example") MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int updateByExample(@Param("record") MktActivityRecordPO record,
			@Param("example") MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int updateByPrimaryKeySelective(MktActivityRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int updateByPrimaryKey(MktActivityRecordPO record);
}