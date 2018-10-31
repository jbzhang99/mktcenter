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
	 * @mbg.generated  2018-10-31 10:42:20
	 */
	long countByExample(MktActivityManualPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:42:20
	 */
	int deleteByExample(MktActivityManualPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:42:20
	 */
	int deleteByPrimaryKey(Long mktActivityManualId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:42:20
	 */
	int insert(MktActivityManualPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:42:20
	 */
	int insertSelective(MktActivityManualPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:42:20
	 */
	List<MktActivityManualPO> selectByExampleWithBLOBs(MktActivityManualPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:42:20
	 */
	List<MktActivityManualPO> selectByExample(MktActivityManualPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:42:20
	 */
	MktActivityManualPO selectByPrimaryKey(Long mktActivityManualId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:42:20
	 */
	int updateByExampleSelective(@Param("record") MktActivityManualPO record,
			@Param("example") MktActivityManualPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:42:20
	 */
	int updateByExampleWithBLOBs(@Param("record") MktActivityManualPO record,
			@Param("example") MktActivityManualPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:42:20
	 */
	int updateByExample(@Param("record") MktActivityManualPO record,
			@Param("example") MktActivityManualPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:42:20
	 */
	int updateByPrimaryKeySelective(MktActivityManualPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:42:20
	 */
	int updateByPrimaryKeyWithBLOBs(MktActivityManualPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-31 10:42:20
	 */
	int updateByPrimaryKey(MktActivityManualPO record);

	List<ActivityVO> getActivityManualList(ActivityVO vo);

    List<ActivityVO> getActivityManualEffect(ActivityVO vo);

    List<ActivityVO> getActivityList(ActivityVO vo);

    List<ActivityVO> getActivityIdList(ActivityVO vo);
}