package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktTaskRecordPO;
import com.bizvane.mktcenterservice.models.po.MktTaskRecordPOExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MktTaskRecordPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 14:07:08
	 */
	long countByExample(MktTaskRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 14:07:08
	 */
	int deleteByExample(MktTaskRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 14:07:08
	 */
	int deleteByPrimaryKey(Long mktTaskRecordId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 14:07:08
	 */
	int insert(MktTaskRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 14:07:08
	 */
	int insertSelective(MktTaskRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 14:07:08
	 */
	List<MktTaskRecordPO> selectByExample(MktTaskRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 14:07:08
	 */
	MktTaskRecordPO selectByPrimaryKey(Long mktTaskRecordId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 14:07:08
	 */
	int updateByExampleSelective(@Param("record") MktTaskRecordPO record,
			@Param("example") MktTaskRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 14:07:08
	 */
	int updateByExample(@Param("record") MktTaskRecordPO record, @Param("example") MktTaskRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 14:07:08
	 */
	int updateByPrimaryKeySelective(MktTaskRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 14:07:08
	 */
	int updateByPrimaryKey(MktTaskRecordPO record);

	Long countCompleteMbr(Map<String,Long> map);
}