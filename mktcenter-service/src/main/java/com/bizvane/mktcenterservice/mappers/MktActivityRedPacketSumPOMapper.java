package com.bizvane.mktcenterservice.mappers;

import com.bizvane.mktcenterfacade.models.bo.ActivityRedPacketListBO;
import com.bizvane.mktcenterfacade.models.po.MktActivityRedPacketSumPO;
import com.bizvane.mktcenterfacade.models.po.MktActivityRedPacketSumPOExample;
import com.bizvane.mktcenterfacade.models.vo.ActivityRedPacketVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MktActivityRedPacketSumPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	long countByExample(MktActivityRedPacketSumPOExample example);
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	int deleteByExample(MktActivityRedPacketSumPOExample example);
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	int deleteByPrimaryKey(Long mktActivityRedPacketSumId);
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	int insert(MktActivityRedPacketSumPO record);
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	int insertSelective(MktActivityRedPacketSumPO record);
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	List<MktActivityRedPacketSumPO> selectByExample(MktActivityRedPacketSumPOExample example);
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	MktActivityRedPacketSumPO selectByPrimaryKey(Long mktActivityRedPacketSumId);
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	int updateByExampleSelective(@Param("record") MktActivityRedPacketSumPO record,
			@Param("example") MktActivityRedPacketSumPOExample example);
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	int updateByExample(@Param("record") MktActivityRedPacketSumPO record,
			@Param("example") MktActivityRedPacketSumPOExample example);
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	int updateByPrimaryKeySelective(MktActivityRedPacketSumPO record);
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 13:53:49
	 */
	int updateByPrimaryKey(MktActivityRedPacketSumPO record);
	int updateUpdateCount(ActivityRedPacketVO vo);
	List<ActivityRedPacketListBO> selectActivityRedPacketAnalyzeLists(ActivityRedPacketVO vo);
}