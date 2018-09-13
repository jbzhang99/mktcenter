package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktTaskProfilePO;
import com.bizvane.mktcenterservice.models.po.MktTaskProfilePOExample;

import java.util.Date;
import java.util.List;

import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.DayTaskRecordVo;
import com.bizvane.mktcenterservice.models.vo.TaskAnalysisVo;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import org.apache.ibatis.annotations.Param;
import com.bizvane.mktcenterservice.models.po.MktTaskProfilePOWithBLOBs;

public interface MktTaskProfilePOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	long countByExample(MktTaskProfilePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int deleteByExample(MktTaskProfilePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int deleteByPrimaryKey(Long mktTaskProfileId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int insert(MktTaskProfilePOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int insertSelective(MktTaskProfilePOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	List<MktTaskProfilePOWithBLOBs> selectByExampleWithBLOBs(MktTaskProfilePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	List<MktTaskProfilePO> selectByExample(MktTaskProfilePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	MktTaskProfilePOWithBLOBs selectByPrimaryKey(Long mktTaskProfileId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int updateByExampleSelective(@Param("record") MktTaskProfilePOWithBLOBs record,
			@Param("example") MktTaskProfilePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int updateByExampleWithBLOBs(@Param("record") MktTaskProfilePOWithBLOBs record,
			@Param("example") MktTaskProfilePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int updateByExample(@Param("record") MktTaskProfilePO record, @Param("example") MktTaskProfilePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int updateByPrimaryKeySelective(MktTaskProfilePOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int updateByPrimaryKeyWithBLOBs(MktTaskProfilePOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int updateByPrimaryKey(MktTaskProfilePO record);

	List<TaskVO> getTaskList(TaskVO vo);

	/**
	 *
	 * @param taskVO
	 * @return
	 */
	String getChosenExtendProperties(TaskVO taskVO);

	/**
	 * 完善资料的效果分析
	 * @return
	 */
	// List<DayTaskRecordVo> getPrifleAnalysisResult(@Param("brandId") Long brandId,@Param("date1") Date date1,@Param("date2")Date date2);
	 List<DayTaskRecordVo> getPrifleAnalysisResult(TaskAnalysisVo vo);

}