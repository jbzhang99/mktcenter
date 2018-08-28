package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityBirthdayPO;
import com.bizvane.mktcenterservice.models.po.MktActivityBirthdayPOExample;
import java.util.List;

import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import org.apache.ibatis.annotations.Param;

public interface MktActivityBirthdayPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	long countByExample(MktActivityBirthdayPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	int deleteByExample(MktActivityBirthdayPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	int deleteByPrimaryKey(Long mktActivityBirthdayId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	int insert(MktActivityBirthdayPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	int insertSelective(MktActivityBirthdayPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	List<MktActivityBirthdayPO> selectByExampleWithBLOBs(MktActivityBirthdayPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	List<MktActivityBirthdayPO> selectByExample(MktActivityBirthdayPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	MktActivityBirthdayPO selectByPrimaryKey(Long mktActivityBirthdayId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	int updateByExampleSelective(@Param("record") MktActivityBirthdayPO record,
			@Param("example") MktActivityBirthdayPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	int updateByExampleWithBLOBs(@Param("record") MktActivityBirthdayPO record,
			@Param("example") MktActivityBirthdayPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	int updateByExample(@Param("record") MktActivityBirthdayPO record,
			@Param("example") MktActivityBirthdayPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	int updateByPrimaryKeySelective(MktActivityBirthdayPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	int updateByPrimaryKeyWithBLOBs(MktActivityBirthdayPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-28 18:01:34
	 */
	int updateByPrimaryKey(MktActivityBirthdayPO record);

	List<ActivityVO> getActivityBirthdayList(ActivityVO vo);
}