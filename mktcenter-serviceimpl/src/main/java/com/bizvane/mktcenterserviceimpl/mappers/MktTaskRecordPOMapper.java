package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktTaskRecordPO;
import com.bizvane.mktcenterservice.models.po.MktTaskRecordPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktTaskRecordPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	long countByExample(MktTaskRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int deleteByExample(MktTaskRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int deleteByPrimaryKey(Long mktTaskRecordId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int insert(MktTaskRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int insertSelective(MktTaskRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	List<MktTaskRecordPO> selectByExample(MktTaskRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	MktTaskRecordPO selectByPrimaryKey(Long mktTaskRecordId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int updateByExampleSelective(@Param("record") MktTaskRecordPO record,
			@Param("example") MktTaskRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int updateByExample(@Param("record") MktTaskRecordPO record, @Param("example") MktTaskRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int updateByPrimaryKeySelective(MktTaskRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int updateByPrimaryKey(MktTaskRecordPO record);
}