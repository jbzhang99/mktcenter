package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.po.MktActivityManualPO;
import com.bizvane.mktcenterservice.models.po.MktActivityManualPOExample;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.bizvane.mktcenterservice.models.po.MktActivityManualPOWithBLOBs;

public interface MktActivityManualPOMapper {
    /**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:05:06
	 */
	long countByExample(MktActivityManualPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:05:06
	 */
	int deleteByExample(MktActivityManualPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:05:06
	 */
	int deleteByPrimaryKey(Long mktActivityManualId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:05:06
	 */
	int insert(MktActivityManualPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:05:06
	 */
	int insertSelective(MktActivityManualPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:05:06
	 */
	List<MktActivityManualPOWithBLOBs> selectByExampleWithBLOBs(MktActivityManualPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:05:06
	 */
	List<MktActivityManualPO> selectByExample(MktActivityManualPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:05:06
	 */
	MktActivityManualPOWithBLOBs selectByPrimaryKey(Long mktActivityManualId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:05:06
	 */
	int updateByExampleSelective(@Param("record") MktActivityManualPOWithBLOBs record,
			@Param("example") MktActivityManualPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:05:06
	 */
	int updateByExampleWithBLOBs(@Param("record") MktActivityManualPOWithBLOBs record,
			@Param("example") MktActivityManualPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:05:06
	 */
	int updateByExample(@Param("record") MktActivityManualPO record,
			@Param("example") MktActivityManualPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:05:06
	 */
	int updateByPrimaryKeySelective(MktActivityManualPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:05:06
	 */
	int updateByPrimaryKeyWithBLOBs(MktActivityManualPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:05:06
	 */
	int updateByPrimaryKey(MktActivityManualPO record);

	List<ActivityVO> getActivityManualList(ActivityVO vo);

    List<ActivityVO> getActivityManualEffect(ActivityVO vo);

    List<ActivityVO> getActivityList(ActivityVO vo);

    List<ActivityVO> getActivityIdList(ActivityVO vo);
}