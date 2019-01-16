package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.bo.MktActivityRedPacketRecordBO;
import com.bizvane.mktcenterservice.models.po.MktActivityRedPacketRecordPO;
import com.bizvane.mktcenterservice.models.po.MktActivityRedPacketRecordPOExample;
import com.bizvane.mktcenterservice.models.vo.ActivityRedPacketVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MktActivityRedPacketRecordPOMapper {
    /**
	 * 只读. 
	 * @mbg.generated  2019-01-16 14:56:00
	 */
	long countByExample(MktActivityRedPacketRecordPOExample example);
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 14:56:00
	 */
	int deleteByExample(MktActivityRedPacketRecordPOExample example);
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 14:56:00
	 */
	int deleteByPrimaryKey(Long mktActivityRedPacketRecordId);
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 14:56:00
	 */
	int insert(MktActivityRedPacketRecordPO record);
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 14:56:00
	 */
	int insertSelective(MktActivityRedPacketRecordPO record);
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 14:56:00
	 */
	List<MktActivityRedPacketRecordPO> selectByExample(MktActivityRedPacketRecordPOExample example);
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 14:56:00
	 */
	MktActivityRedPacketRecordPO selectByPrimaryKey(Long mktActivityRedPacketRecordId);
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 14:56:00
	 */
	int updateByExampleSelective(@Param("record") MktActivityRedPacketRecordPO record,
			@Param("example") MktActivityRedPacketRecordPOExample example);
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 14:56:00
	 */
	int updateByExample(@Param("record") MktActivityRedPacketRecordPO record,
			@Param("example") MktActivityRedPacketRecordPOExample example);
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 14:56:00
	 */
	int updateByPrimaryKeySelective(MktActivityRedPacketRecordPO record);
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-16 14:56:00
	 */
	int updateByPrimaryKey(MktActivityRedPacketRecordPO record);
	Integer  getRedPacketCount(@Param("type")Integer type,@Param("memberCode")String memberCode,@Param("sponsorCode")String sponsorCode,@Param("mktActivityId")Long mktActivityId);
	List<MktActivityRedPacketRecordBO> getRedPacketCoponRecord(ActivityRedPacketVO vo);
	List<MktActivityRedPacketRecordPO> getRedPacketZhuLiRecord (ActivityRedPacketVO vo);
}