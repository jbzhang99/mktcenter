package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityOrderPO;
import com.bizvane.mktcenterservice.models.po.MktActivityOrderPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivityOrderPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	long countByExample(MktActivityOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int deleteByExample(MktActivityOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int deleteByPrimaryKey(Long mktActivityOrderId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int insert(MktActivityOrderPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int insertSelective(MktActivityOrderPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	List<MktActivityOrderPO> selectByExample(MktActivityOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	MktActivityOrderPO selectByPrimaryKey(Long mktActivityOrderId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int updateByExampleSelective(@Param("record") MktActivityOrderPO record,
			@Param("example") MktActivityOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int updateByExample(@Param("record") MktActivityOrderPO record,
			@Param("example") MktActivityOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int updateByPrimaryKeySelective(MktActivityOrderPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-06 19:28:16
	 */
	int updateByPrimaryKey(MktActivityOrderPO record);
}