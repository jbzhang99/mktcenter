package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityRegisterPO;
import com.bizvane.mktcenterservice.models.po.MktActivityRegisterPOExample;
import java.util.List;

import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import org.apache.ibatis.annotations.Param;

public interface MktActivityRegisterPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	long countByExample(MktActivityRegisterPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	int deleteByExample(MktActivityRegisterPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	int deleteByPrimaryKey(Long mktActivityResigterId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	int insert(MktActivityRegisterPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	int insertSelective(MktActivityRegisterPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	List<MktActivityRegisterPO> selectByExampleWithBLOBs(MktActivityRegisterPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	List<MktActivityRegisterPO> selectByExample(MktActivityRegisterPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	MktActivityRegisterPO selectByPrimaryKey(Long mktActivityResigterId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	int updateByExampleSelective(@Param("record") MktActivityRegisterPO record,
			@Param("example") MktActivityRegisterPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	int updateByExampleWithBLOBs(@Param("record") MktActivityRegisterPO record,
			@Param("example") MktActivityRegisterPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	int updateByExample(@Param("record") MktActivityRegisterPO record,
			@Param("example") MktActivityRegisterPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	int updateByPrimaryKeySelective(MktActivityRegisterPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	int updateByPrimaryKeyWithBLOBs(MktActivityRegisterPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	int updateByPrimaryKey(MktActivityRegisterPO record);

	List<ActivityVO> getActivityList(ActivityVO vo);
}