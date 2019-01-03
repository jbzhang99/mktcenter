package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityPrizeRecordPO;
import com.bizvane.mktcenterservice.models.po.MktActivityPrizeRecordPOExample;
import com.bizvane.mktcenterservice.models.vo.ActivityPriceParamVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MktActivityPrizeRecordPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	long countByExample(MktActivityPrizeRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	int deleteByExample(MktActivityPrizeRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	int deleteByPrimaryKey(Long mktActivityPrizeRecordId);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	int insert(MktActivityPrizeRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	int insertSelective(MktActivityPrizeRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	List<MktActivityPrizeRecordPO> selectByExample(MktActivityPrizeRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	MktActivityPrizeRecordPO selectByPrimaryKey(Long mktActivityPrizeRecordId);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	int updateByExampleSelective(@Param("record") MktActivityPrizeRecordPO record,
			@Param("example") MktActivityPrizeRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	int updateByExample(@Param("record") MktActivityPrizeRecordPO record,
			@Param("example") MktActivityPrizeRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	int updateByPrimaryKeySelective(MktActivityPrizeRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-02 13:14:26
	 */
	int updateByPrimaryKey(MktActivityPrizeRecordPO record);

	Integer selectPrizePeopleNum(@Param("mktActivityId")Long mktActivityId);
	Integer selectTotalPeopleNum(@Param("mktActivityId")Long mktActivityId);
	List<MktActivityPrizeRecordPO> selectPrizePeople(ActivityPriceParamVO vo);
}