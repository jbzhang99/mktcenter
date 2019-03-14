package com.bizvane.mktcenterservice.mappers;

import com.bizvane.mktcenterfacade.models.po.MktActivityStatisticsPO;
import com.bizvane.mktcenterfacade.models.po.MktActivityStatisticsPOExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MktActivityStatisticsPOMapper {
    /**
	 * 只读. 
	 * @mbg.generated  2019-01-25 11:55:25
	 */
	long countByExample(MktActivityStatisticsPOExample example);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 11:55:25
	 */
	int deleteByExample(MktActivityStatisticsPOExample example);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 11:55:25
	 */
	int deleteByPrimaryKey(Long mktActivityStatisticsId);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 11:55:25
	 */
	int insert(MktActivityStatisticsPO record);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 11:55:25
	 */
	int insertSelective(MktActivityStatisticsPO record);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 11:55:25
	 */
	List<MktActivityStatisticsPO> selectByExampleWithBLOBs(MktActivityStatisticsPOExample example);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 11:55:25
	 */
	List<MktActivityStatisticsPO> selectByExample(MktActivityStatisticsPOExample example);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 11:55:25
	 */
	MktActivityStatisticsPO selectByPrimaryKey(Long mktActivityStatisticsId);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 11:55:25
	 */
	int updateByExampleSelective(@Param("record") MktActivityStatisticsPO record,
			@Param("example") MktActivityStatisticsPOExample example);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 11:55:25
	 */
	int updateByExampleWithBLOBs(@Param("record") MktActivityStatisticsPO record,
			@Param("example") MktActivityStatisticsPOExample example);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 11:55:25
	 */
	int updateByExample(@Param("record") MktActivityStatisticsPO record,
			@Param("example") MktActivityStatisticsPOExample example);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 11:55:25
	 */
	int updateByPrimaryKeySelective(MktActivityStatisticsPO record);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 11:55:25
	 */
	int updateByPrimaryKeyWithBLOBs(MktActivityStatisticsPO record);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 11:55:25
	 */
	int updateByPrimaryKey(MktActivityStatisticsPO record);


	/**
     * 得到所有日期
     * @return
     */
    List<String> getAllDate(@Param("activityId") Long activityId);
}