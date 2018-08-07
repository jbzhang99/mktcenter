package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.bo.TaskDetailBO;
import com.bizvane.mktcenterservice.models.bo.TaskInviteAwardBO;
import com.bizvane.mktcenterservice.models.bo.TaskOrderAwardBO;
import com.bizvane.mktcenterservice.models.po.MktTaskPO;
import com.bizvane.mktcenterservice.models.po.MktTaskPOExample;
import com.bizvane.mktcenterservice.models.po.MktTaskPOWithBLOBs;

import java.util.Date;
import java.util.List;

import com.bizvane.mktcenterservice.models.vo.TaskDetailVO;
import org.apache.ibatis.annotations.Param;

public interface MktTaskPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	long countByExample(MktTaskPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int deleteByExample(MktTaskPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int deleteByPrimaryKey(Long mktTaskId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int insert(MktTaskPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int insertSelective(MktTaskPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	List<MktTaskPOWithBLOBs> selectByExampleWithBLOBs(MktTaskPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	List<MktTaskPO> selectByExample(MktTaskPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	MktTaskPOWithBLOBs selectByPrimaryKey(Long mktTaskId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByExampleSelective(@Param("record") MktTaskPOWithBLOBs record,
			@Param("example") MktTaskPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByExampleWithBLOBs(@Param("record") MktTaskPOWithBLOBs record,
			@Param("example") MktTaskPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByExample(@Param("record") MktTaskPO record, @Param("example") MktTaskPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByPrimaryKeySelective(MktTaskPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByPrimaryKeyWithBLOBs(MktTaskPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByPrimaryKey(MktTaskPO record);

	public  List<TaskDetailVO> getTaskDetailByTaskId  (@Param("mktTaskId") Long mktTaskId);

	public List<TaskOrderAwardBO> getTaskOrderAwardList(@Param("sysCompanyId") Long sysCompanyId,@Param("sysBrandId") Long sysBrandId,@Param("placeOrderTime")Date placeOrderTime);

	public List<TaskInviteAwardBO> getTaskInviteAwardList(@Param("sysCompanyId") Long sysCompanyId, @Param("sysBrandId") Long sysBrandId,@Param("placeOrderTime")Date placeOrderTime);
}