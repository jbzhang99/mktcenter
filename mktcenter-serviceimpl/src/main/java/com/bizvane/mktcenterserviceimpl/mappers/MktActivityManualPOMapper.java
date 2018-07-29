package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.po.MktActivityManualPO;
import com.bizvane.mktcenterservice.models.po.MktActivityManualPOExample;
import java.util.List;

import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import org.apache.ibatis.annotations.Param;

public interface MktActivityManualPOMapper {
    /**
	 * 只读. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	long countByExample(MktActivityManualPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	int deleteByExample(MktActivityManualPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	int deleteByPrimaryKey(Long mktActivityManualId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	int insert(MktActivityManualPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	int insertSelective(MktActivityManualPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	List<MktActivityManualPO> selectByExampleWithBLOBs(MktActivityManualPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	List<MktActivityManualPO> selectByExample(MktActivityManualPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	MktActivityManualPO selectByPrimaryKey(Long mktActivityManualId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	int updateByExampleSelective(@Param("record") MktActivityManualPO record,
			@Param("example") MktActivityManualPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	int updateByExampleWithBLOBs(@Param("record") MktActivityManualPO record,
			@Param("example") MktActivityManualPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	int updateByExample(@Param("record") MktActivityManualPO record,
			@Param("example") MktActivityManualPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	int updateByPrimaryKeySelective(MktActivityManualPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	int updateByPrimaryKeyWithBLOBs(MktActivityManualPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	int updateByPrimaryKey(MktActivityManualPO record);

	List<ActivityVO> getActivityManualList(ActivityVO vo);

    int  addActivityManual(ActivityBO bo);

    int addActivity(ActivityBO bo);

    List<ActivityVO> getActivityManualEffect(ActivityVO vo);

    List<ActivityVO> getActivityList(ActivityVO vo);

}