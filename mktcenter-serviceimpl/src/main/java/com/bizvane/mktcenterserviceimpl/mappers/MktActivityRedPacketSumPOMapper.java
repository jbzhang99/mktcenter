package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityRedPacketSumPO;
import com.bizvane.mktcenterservice.models.po.MktActivityRedPacketSumPOExample;
import com.bizvane.mktcenterservice.models.vo.ActivityRedPacketVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MktActivityRedPacketSumPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 18:24:08
	 */
	long countByExample(MktActivityRedPacketSumPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 18:24:08
	 */
	int deleteByExample(MktActivityRedPacketSumPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 18:24:08
	 */
	int deleteByPrimaryKey(Long mktActivityRedPacketSumId);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 18:24:08
	 */
	int insert(MktActivityRedPacketSumPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 18:24:08
	 */
	int insertSelective(MktActivityRedPacketSumPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 18:24:08
	 */
	List<MktActivityRedPacketSumPO> selectByExample(MktActivityRedPacketSumPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 18:24:08
	 */
	MktActivityRedPacketSumPO selectByPrimaryKey(Long mktActivityRedPacketSumId);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 18:24:08
	 */
	int updateByExampleSelective(@Param("record") MktActivityRedPacketSumPO record,
			@Param("example") MktActivityRedPacketSumPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 18:24:08
	 */
	int updateByExample(@Param("record") MktActivityRedPacketSumPO record,
			@Param("example") MktActivityRedPacketSumPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 18:24:08
	 */
	int updateByPrimaryKeySelective(MktActivityRedPacketSumPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-15 18:24:08
	 */
	int updateByPrimaryKey(MktActivityRedPacketSumPO record);

	int updateUpdateCount(ActivityRedPacketVO vo);
}