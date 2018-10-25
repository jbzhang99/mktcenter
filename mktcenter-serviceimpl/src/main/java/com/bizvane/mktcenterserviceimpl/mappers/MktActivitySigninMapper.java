package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivitySignin;
import com.bizvane.mktcenterservice.models.po.MktActivitySigninExample;
import java.util.List;

import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import org.apache.ibatis.annotations.Param;

public interface MktActivitySigninMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-25 14:39:03
	 */
	long countByExample(MktActivitySigninExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-25 14:39:03
	 */
	int deleteByExample(MktActivitySigninExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-25 14:39:03
	 */
	int deleteByPrimaryKey(Long mktActivitySignInId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-25 14:39:03
	 */
	int insert(MktActivitySignin record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-25 14:39:03
	 */
	int insertSelective(MktActivitySignin record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-25 14:39:03
	 */
	List<MktActivitySignin> selectByExampleWithBLOBs(MktActivitySigninExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-25 14:39:03
	 */
	List<MktActivitySignin> selectByExample(MktActivitySigninExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-25 14:39:03
	 */
	MktActivitySignin selectByPrimaryKey(Long mktActivitySignInId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-25 14:39:03
	 */
	int updateByExampleSelective(@Param("record") MktActivitySignin record,
			@Param("example") MktActivitySigninExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-25 14:39:03
	 */
	int updateByExampleWithBLOBs(@Param("record") MktActivitySignin record,
			@Param("example") MktActivitySigninExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-25 14:39:03
	 */
	int updateByExample(@Param("record") MktActivitySignin record, @Param("example") MktActivitySigninExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-25 14:39:03
	 */
	int updateByPrimaryKeySelective(MktActivitySignin record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-25 14:39:03
	 */
	int updateByPrimaryKeyWithBLOBs(MktActivitySignin record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-10-25 14:39:03
	 */
	int updateByPrimaryKey(MktActivitySignin record);

	List<ActivityVO> getActivitySigninList(ActivityVO vo);

}