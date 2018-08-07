package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterservice.models.vo.TaskRecordVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/16 14:07
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public interface TaskShareService {

    /**
     * 查询任务列表
     * @param vo
     * @return
     */
    public ResponseData<PageInfo<TaskVO>> getTaskList(TaskVO vo, PageForm pageForm);

    /**
     * 新增任务
     * @param bo
     * @return
     */
    public ResponseData<Integer> addTask(TaskBO bo, SysAccountPO stageUser);

    /**
     * 执行任务
     * @param
     * @return
     */
    public ResponseData<Integer> executeTask(TaskVO vo, MemberInfoModel memberInfoModel);

    /**
     * 修改任务
     * @return
     */
    public ResponseData<Integer> updateTask(TaskBO bo,SysAccountPO stageUser);

    /**
     * 查询任务详情
     * @param mktTaskId
     * @return
     */
    public ResponseData<TaskBO> selectTaskById(Long mktTaskId);


    /**
     *效果分析
     * @param date1
     * @param date2
     * @param stageUser
     * @return
     */
    public ResponseData<TaskRecordVO> getTaskShareRecordByTime(Date date1, Date date2, SysAccountPO stageUser,String taskName,PageForm pageForm);


    /**
     * 添加任务记录
     * @param vo
     * @param memberInfoModel
     * @return
     */
    public ResponseData addToRecord(TaskVO vo, MemberInfoModel memberInfoModel);

    /**
     * 禁用任务
     * @param taskId
     * @param stageUser
     * @return
     */
    public ResponseData stopTask(Long taskId,SysAccountPO stageUser);

    /**
     *
     * 任务审核
     * @param taskId
     * @param stageUser
     * @param checkStatus
     * @return
     */
    public ResponseData checkTaskShare(Long taskId,SysAccountPO stageUser,Integer checkStatus);
}
