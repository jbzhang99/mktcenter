package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.bo.TaskInviteAwardBO;
import com.bizvane.mktcenterservice.models.bo.TaskAwardBO;
import com.bizvane.mktcenterservice.models.bo.TaskWXBO;
import com.bizvane.mktcenterservice.models.bo.TaskWXDetailBO;
import com.bizvane.mktcenterservice.models.po.MktTaskPO;
import com.bizvane.mktcenterservice.models.po.MktTaskPOExample;
import com.bizvane.mktcenterservice.models.po.MktTaskPOWithBLOBs;

import java.util.Date;
import java.util.List;

import com.bizvane.mktcenterservice.models.vo.TaskDetailVO;
import com.bizvane.mktcenterservice.models.vo.TaskForWXVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import org.apache.ibatis.annotations.Param;

public interface MktTaskPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	long countByExample(MktTaskPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int deleteByExample(MktTaskPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int deleteByPrimaryKey(Long mktTaskId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int insert(MktTaskPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int insertSelective(MktTaskPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	List<MktTaskPOWithBLOBs> selectByExampleWithBLOBs(MktTaskPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	List<MktTaskPO> selectByExample(MktTaskPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	MktTaskPOWithBLOBs selectByPrimaryKey(Long mktTaskId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByExampleSelective(@Param("record") MktTaskPOWithBLOBs record,
			@Param("example") MktTaskPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByExampleWithBLOBs(@Param("record") MktTaskPOWithBLOBs record,
			@Param("example") MktTaskPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByExample(@Param("record") MktTaskPO record, @Param("example") MktTaskPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByPrimaryKeySelective(MktTaskPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByPrimaryKeyWithBLOBs(MktTaskPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByPrimaryKey(MktTaskPO record);

	public  List<TaskDetailVO> getTaskDetailByTaskId  (@Param("mktTaskId") Long mktTaskId);

	/**
	 * 获取订单任务的奖励条件
	 * @param sysCompanyId
	 * @param sysBrandId
	 * @param placeOrderTime
	 * @return
	 */

	public List<TaskAwardBO> getTaskOrderAwardList(@Param("sysCompanyId") Long sysCompanyId, @Param("sysBrandId") Long sysBrandId, @Param("placeOrderTime")Date placeOrderTime);
	/**
	 * 获取邀请开卡任务的奖励条件
	 * @param sysCompanyId
	 * @param sysBrandId
	 * @param placeOrderTime
	 * @return
	 */
	public List<TaskAwardBO> getTaskInviteAwardList(@Param("sysCompanyId") Long sysCompanyId, @Param("sysBrandId") Long sysBrandId,@Param("placeOrderTime")Date placeOrderTime);

	/**
	 * 完善资料任务的奖励
	 * @param sysCompanyId
	 * @param sysBrandId
	 * @param placeOrderTime
	 * @return
	 */
	public List<TaskAwardBO> getTaskProfileAwardList(@Param("sysCompanyId") Long sysCompanyId, @Param("sysBrandId") Long sysBrandId,@Param("placeOrderTime")Date placeOrderTime);

	/**
	 * 分享任务的奖励
	 * @param sysCompanyId
	 * @param sysBrandId
	 * @param placeOrderTime
	 * @return
	 */
	public List<TaskAwardBO> getTaskShareAwardList(@Param("sysCompanyId") Long sysCompanyId, @Param("sysBrandId") Long sysBrandId,@Param("placeOrderTime")Date placeOrderTime);

	/**
	 * 获取会员已完成和未完成任务列表
	 * @param vo
	 * @return
	 */
	public List<TaskWXBO> getCompleteTask(TaskForWXVO vo);

	public  List<TaskWXDetailBO>  getTaskWXDetail(@Param("taskId") Long taskId);

	/**
	 * 获取任务的详情
	 * @return
	 */
	public List<TaskVO>  getOrderTaskList(@Param("mktTaskId") Long mktTaskId);
	public List<TaskVO> getInviteTaskList(@Param("mktTaskId") Long mktTaskId);
	public List<TaskVO> getShareTaskList(@Param("mktTaskId") Long mktTaskId);
	public List<TaskVO> getProfileTaskList(@Param("mktTaskId") Long mktTaskId);
}