package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityRecordPO;
import com.bizvane.mktcenterservice.models.po.MktActivityRecordPOExample;
import java.util.List;

import com.bizvane.mktcenterservice.models.vo.MktActivityRecordVO;
import org.apache.ibatis.annotations.Param;

public interface MktActivityRecordPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	long countByExample(MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int deleteByExample(MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int deleteByPrimaryKey(Long mktActivityRecordId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int insert(MktActivityRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int insertSelective(MktActivityRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	List<MktActivityRecordPO> selectByExample(MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	MktActivityRecordPO selectByPrimaryKey(Long mktActivityRecordId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByExampleSelective(@Param("record") MktActivityRecordPO record,
			@Param("example") MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByExample(@Param("record") MktActivityRecordPO record,
			@Param("example") MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByPrimaryKeySelective(MktActivityRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByPrimaryKey(MktActivityRecordPO record);

	int countByCondition(MktActivityRecordPO mktActivityRecordPO);

	List<MktActivityRecordPO>  selectActivityRecordPOList(MktActivityRecordPO mktActivityRecordPO);
	List<MktActivityRecordPO>  getActivityRecordPOList(MktActivityRecordVO vo);
	List<MktActivityRecordPO> selectRecordPOList(MktActivityRecordPO mktActivityRecordPO);
}