package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityRecordPO;
import com.bizvane.mktcenterservice.models.po.MktActivityRecordPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivityRecordPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:22:17
	 */
	long countByExample(MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:22:17
	 */
	int deleteByExample(MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:22:17
	 */
	int deleteByPrimaryKey(Long mktActivityRecordId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:22:17
	 */
	int insert(MktActivityRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:22:17
	 */
	int insertSelective(MktActivityRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:22:17
	 */
	List<MktActivityRecordPO> selectByExample(MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:22:17
	 */
	MktActivityRecordPO selectByPrimaryKey(Long mktActivityRecordId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:22:17
	 */
	int updateByExampleSelective(@Param("record") MktActivityRecordPO record,
			@Param("example") MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:22:17
	 */
	int updateByExample(@Param("record") MktActivityRecordPO record,
			@Param("example") MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:22:17
	 */
	int updateByPrimaryKeySelective(MktActivityRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-31 14:22:17
	 */
	int updateByPrimaryKey(MktActivityRecordPO record);
}