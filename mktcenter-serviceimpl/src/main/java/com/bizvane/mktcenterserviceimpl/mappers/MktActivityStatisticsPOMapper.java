package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.bo.ActivityStatisticsBO;
import com.bizvane.mktcenterservice.models.po.MktActivityStatisticsPO;
import com.bizvane.mktcenterservice.models.po.MktActivityStatisticsPOExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MktActivityStatisticsPOMapper {
    /**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	long countByExample(MktActivityStatisticsPOExample example);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	int deleteByExample(MktActivityStatisticsPOExample example);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	int deleteByPrimaryKey(Long mktActivityStatisticsId);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	int insert(MktActivityStatisticsPO record);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	int insertSelective(MktActivityStatisticsPO record);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	List<MktActivityStatisticsPO> selectByExampleWithBLOBs(MktActivityStatisticsPOExample example);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	List<MktActivityStatisticsPO> selectByExample(MktActivityStatisticsPOExample example);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	MktActivityStatisticsPO selectByPrimaryKey(Long mktActivityStatisticsId);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	int updateByExampleSelective(@Param("record") MktActivityStatisticsPO record,
			@Param("example") MktActivityStatisticsPOExample example);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	int updateByExampleWithBLOBs(@Param("record") MktActivityStatisticsPO record,
			@Param("example") MktActivityStatisticsPOExample example);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	int updateByExample(@Param("record") MktActivityStatisticsPO record,
			@Param("example") MktActivityStatisticsPOExample example);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	int updateByPrimaryKeySelective(MktActivityStatisticsPO record);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	int updateByPrimaryKeyWithBLOBs(MktActivityStatisticsPO record);


	/**
	 * 只读. 
	 * @mbg.generated  2019-01-25 10:27:46
	 */
	int updateByPrimaryKey(MktActivityStatisticsPO record);


	/**
     * 得到所有日期
     * @return
     */
    List<String> getAllDate(@Param("activityId") Long activityId);


    ActivityStatisticsBO getBo(Map map);
}