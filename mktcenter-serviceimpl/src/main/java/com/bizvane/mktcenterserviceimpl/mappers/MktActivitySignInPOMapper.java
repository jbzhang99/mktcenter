package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivitySignInPO;
import com.bizvane.mktcenterservice.models.po.MktActivitySignInPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivitySignInPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	long countByExample(MktActivitySignInPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int deleteByExample(MktActivitySignInPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int deleteByPrimaryKey(Long mktActivitySignInId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int insert(MktActivitySignInPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int insertSelective(MktActivitySignInPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	List<MktActivitySignInPO> selectByExample(MktActivitySignInPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	MktActivitySignInPO selectByPrimaryKey(Long mktActivitySignInId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int updateByExampleSelective(@Param("record") MktActivitySignInPO record,
			@Param("example") MktActivitySignInPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int updateByExample(@Param("record") MktActivitySignInPO record,
			@Param("example") MktActivitySignInPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int updateByPrimaryKeySelective(MktActivitySignInPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int updateByPrimaryKey(MktActivitySignInPO record);
}