package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityPO;
import com.bizvane.mktcenterservice.models.po.MktActivityPOExample;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivityPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	long countByExample(MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int deleteByExample(MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int deleteByPrimaryKey(Long mktActivityId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int insert(MktActivityPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int insertSelective(MktActivityPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	List<MktActivityPOWithBLOBs> selectByExampleWithBLOBs(MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	List<MktActivityPO> selectByExample(MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	MktActivityPOWithBLOBs selectByPrimaryKey(Long mktActivityId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int updateByExampleSelective(@Param("record") MktActivityPOWithBLOBs record,
			@Param("example") MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int updateByExampleWithBLOBs(@Param("record") MktActivityPOWithBLOBs record,
			@Param("example") MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int updateByExample(@Param("record") MktActivityPO record, @Param("example") MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int updateByPrimaryKeySelective(MktActivityPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int updateByPrimaryKeyWithBLOBs(MktActivityPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int updateByPrimaryKey(MktActivityPO record);
}