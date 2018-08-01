package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityRecordPO;
import com.bizvane.mktcenterservice.models.po.MktActivityRecordPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivityRecordPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-01 09:21:14
	 */
	long countByExample(MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-01 09:21:14
	 */
	int deleteByExample(MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-01 09:21:14
	 */
	int deleteByPrimaryKey(Long mktActivityRecordId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-01 09:21:14
	 */
	int insert(MktActivityRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-01 09:21:14
	 */
	int insertSelective(MktActivityRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-01 09:21:14
	 */
	List<MktActivityRecordPO> selectByExample(MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-01 09:21:14
	 */
	MktActivityRecordPO selectByPrimaryKey(Long mktActivityRecordId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-01 09:21:14
	 */
	int updateByExampleSelective(@Param("record") MktActivityRecordPO record,
			@Param("example") MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-01 09:21:14
	 */
	int updateByExample(@Param("record") MktActivityRecordPO record,
			@Param("example") MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-01 09:21:14
	 */
	int updateByPrimaryKeySelective(MktActivityRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-01 09:21:14
	 */
	int updateByPrimaryKey(MktActivityRecordPO record);
	int countByCondition(MktActivityRecordPO mktActivityRecordPO);

	List<MktActivityRecordPO>  selectActivityRecordPOList(MktActivityRecordPO mktActivityRecordPO);
}