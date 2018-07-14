package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityRegisterPO;
import com.bizvane.mktcenterservice.models.po.MktActivityRegisterPOExample;
import java.util.List;

import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import org.apache.ibatis.annotations.Param;

public interface MktActivityRegisterPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	long countByExample(MktActivityRegisterPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int deleteByExample(MktActivityRegisterPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int deleteByPrimaryKey(Long mktActivityResigterId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int insert(MktActivityRegisterPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int insertSelective(MktActivityRegisterPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	List<MktActivityRegisterPO> selectByExample(MktActivityRegisterPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	MktActivityRegisterPO selectByPrimaryKey(Long mktActivityResigterId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByExampleSelective(@Param("record") MktActivityRegisterPO record,
			@Param("example") MktActivityRegisterPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByExample(@Param("record") MktActivityRegisterPO record,
			@Param("example") MktActivityRegisterPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByPrimaryKeySelective(MktActivityRegisterPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByPrimaryKey(MktActivityRegisterPO record);

	List<ActivityVO> getActivityList(ActivityVO vo);
}