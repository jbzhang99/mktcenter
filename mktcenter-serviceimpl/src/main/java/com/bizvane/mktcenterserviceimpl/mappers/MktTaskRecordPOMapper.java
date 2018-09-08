package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.bo.TotalStatisticsBO;
import com.bizvane.mktcenterservice.models.po.MktTaskRecordPO;
import com.bizvane.mktcenterservice.models.po.MktTaskRecordPOExample;
import java.util.List;
import java.util.Map;

import com.bizvane.mktcenterservice.models.po.MktTaskSharePO;
import com.bizvane.mktcenterservice.models.vo.DayTaskRecordVo;
import com.bizvane.mktcenterservice.models.vo.MktTaskRecordVO;
import com.bizvane.mktcenterservice.models.vo.TaskAnalysisVo;
import org.apache.ibatis.annotations.Param;

public interface MktTaskRecordPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 16:26:55
	 */
	long countByExample(MktTaskRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 16:26:55
	 */
	int deleteByExample(MktTaskRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 16:26:55
	 */
	int deleteByPrimaryKey(Long mktTaskRecordId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 16:26:55
	 */
	int insert(MktTaskRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 16:26:55
	 */
	int insertSelective(MktTaskRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 16:26:55
	 */
	List<MktTaskRecordPO> selectByExample(MktTaskRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 16:26:55
	 */
	MktTaskRecordPO selectByPrimaryKey(Long mktTaskRecordId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 16:26:55
	 */
	int updateByExampleSelective(@Param("record") MktTaskRecordPO record,
			@Param("example") MktTaskRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 16:26:55
	 */
	int updateByExample(@Param("record") MktTaskRecordPO record, @Param("example") MktTaskRecordPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 16:26:55
	 */
	int updateByPrimaryKeySelective(MktTaskRecordPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-08 16:26:55
	 */
	int updateByPrimaryKey(MktTaskRecordPO record);

	Long countPartMbr(MktTaskSharePO mktTaskSharePO);

	List<TotalStatisticsBO> getTotalStatistics(MktTaskRecordVO vo);

	/**
	 * 分析效果分析
	 * @param vo
	 * @return
	 */
	List<DayTaskRecordVo> getAnalysisResult(TaskAnalysisVo vo);
}