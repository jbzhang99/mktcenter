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

public interface MktTaskProfilePOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	long countByExample(MktTaskProfilePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int deleteByExample(MktTaskProfilePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int deleteByPrimaryKey(Long mktTaskProfileId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int insert(MktTaskProfilePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int insertSelective(MktTaskProfilePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	List<MktTaskProfilePO> selectByExampleWithBLOBs(MktTaskProfilePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	List<MktTaskProfilePO> selectByExample(MktTaskProfilePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	MktTaskProfilePO selectByPrimaryKey(Long mktTaskProfileId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByExampleSelective(@Param("record") MktTaskProfilePO record,
			@Param("example") MktTaskProfilePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByExampleWithBLOBs(@Param("record") MktTaskProfilePO record,
			@Param("example") MktTaskProfilePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByExample(@Param("record") MktTaskProfilePO record, @Param("example") MktTaskProfilePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByPrimaryKeySelective(MktTaskProfilePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByPrimaryKeyWithBLOBs(MktTaskProfilePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
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