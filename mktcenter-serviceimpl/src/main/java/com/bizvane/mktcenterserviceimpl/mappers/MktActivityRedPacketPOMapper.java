package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityRedPacketPO;
import com.bizvane.mktcenterservice.models.po.MktActivityRedPacketPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivityRedPacketPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-14 18:03:09
	 */
	long countByExample(MktActivityRedPacketPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-14 18:03:09
	 */
	int deleteByExample(MktActivityRedPacketPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-14 18:03:09
	 */
	int deleteByPrimaryKey(Long mktActivityRedPacketId);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-14 18:03:09
	 */
	int insert(MktActivityRedPacketPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-14 18:03:09
	 */
	int insertSelective(MktActivityRedPacketPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-14 18:03:09
	 */
	List<MktActivityRedPacketPO> selectByExample(MktActivityRedPacketPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-14 18:03:09
	 */
	MktActivityRedPacketPO selectByPrimaryKey(Long mktActivityRedPacketId);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-14 18:03:09
	 */
	int updateByExampleSelective(@Param("record") MktActivityRedPacketPO record,
			@Param("example") MktActivityRedPacketPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-14 18:03:09
	 */
	int updateByExample(@Param("record") MktActivityRedPacketPO record,
			@Param("example") MktActivityRedPacketPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-14 18:03:09
	 */
	int updateByPrimaryKeySelective(MktActivityRedPacketPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-14 18:03:09
	 */
	int updateByPrimaryKey(MktActivityRedPacketPO record);
}