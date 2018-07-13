package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktTaskOrderPO;
import com.bizvane.mktcenterservice.models.po.MktTaskOrderPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktTaskOrderPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	long countByExample(MktTaskOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int deleteByExample(MktTaskOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int deleteByPrimaryKey(Long mktTaskProfileId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int insert(MktTaskOrderPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int insertSelective(MktTaskOrderPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	List<MktTaskOrderPO> selectByExample(MktTaskOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	MktTaskOrderPO selectByPrimaryKey(Long mktTaskProfileId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int updateByExampleSelective(@Param("record") MktTaskOrderPO record,
			@Param("example") MktTaskOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int updateByExample(@Param("record") MktTaskOrderPO record, @Param("example") MktTaskOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int updateByPrimaryKeySelective(MktTaskOrderPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	int updateByPrimaryKey(MktTaskOrderPO record);
}