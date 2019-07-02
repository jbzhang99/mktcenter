package com.bizvane.mktcenterservice.mappers;

import com.bizvane.mktcenterfacade.models.po.MktActivityRecordPO;
import com.bizvane.mktcenterfacade.models.po.MktActivityRecordPOExample;
import java.util.List;

import com.bizvane.mktcenterfacade.models.vo.MktActivityRecordVO;
import org.apache.ibatis.annotations.Param;

public interface MktActivityRecordPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated
	 */
	long countByExample(MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated
	 */
	int deleteByExample(MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated
	 */
	int deleteByPrimaryKey(Long mktActivityRecordId);

	/**
	 * 只读. 
	 * @mbg.generated
	 */
	int insert(MktActivityRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated
	 */
	int insertSelective(MktActivityRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated
	 */
	List<MktActivityRecordPO> selectByExample(MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated
	 */
	MktActivityRecordPO selectByPrimaryKey(Long mktActivityRecordId);

	/**
	 * 只读. 
	 * @mbg.generated
	 */
	int updateByExampleSelective(@Param("record") MktActivityRecordPO record,
			@Param("example") MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated
	 */
	int updateByExample(@Param("record") MktActivityRecordPO record,
			@Param("example") MktActivityRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated
	 */
	int updateByPrimaryKeySelective(MktActivityRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated
	 */
	int updateByPrimaryKey(MktActivityRecordPO record);

	int countByCondition(MktActivityRecordPO mktActivityRecordPO);

	List<MktActivityRecordPO>  selectActivityRecordPOList(MktActivityRecordPO mktActivityRecordPO);
	List<MktActivityRecordPO>  getActivityRecordPOList(MktActivityRecordVO vo);
	List<MktActivityRecordPO> selectRecordPOList(MktActivityRecordPO mktActivityRecordPO);
}