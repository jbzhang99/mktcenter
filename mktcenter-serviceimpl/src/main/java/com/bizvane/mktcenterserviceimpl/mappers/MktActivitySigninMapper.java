package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivitySignin;
import com.bizvane.mktcenterservice.models.po.MktActivitySigninExample;
import java.util.List;

import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import org.apache.ibatis.annotations.Param;

public interface MktActivitySigninMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	long countByExample(MktActivitySigninExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int deleteByExample(MktActivitySigninExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int deleteByPrimaryKey(Long mktActivitySignInId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int insert(MktActivitySignin record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int insertSelective(MktActivitySignin record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	List<MktActivitySignin> selectByExample(MktActivitySigninExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	MktActivitySignin selectByPrimaryKey(Long mktActivitySignInId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByExampleSelective(@Param("record") MktActivitySignin record,
			@Param("example") MktActivitySigninExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByExample(@Param("record") MktActivitySignin record, @Param("example") MktActivitySigninExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByPrimaryKeySelective(MktActivitySignin record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByPrimaryKey(MktActivitySignin record);

	List<ActivityVO> getActivitySigninList(ActivityVO vo);

}