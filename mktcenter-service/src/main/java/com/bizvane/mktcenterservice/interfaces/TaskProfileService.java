package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.po.MktMessagePOExample;
import com.bizvane.mktcenterservice.models.po.MktTaskRecordPO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterservice.models.vo.TaskRecordVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

import java.util.Date;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/16 14:06
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public interface TaskProfileService {
    /**
     * 添加完善资料任务
     * @param bo
     * @param stageUser
     * @return
     */

    public ResponseData<Integer> addTask(TaskBO bo, SysAccountPO stageUser);

    /**
     * 执行任务
     * @param vo
     * @param memberInfoModel
     * @return
     */
    public ResponseData<Integer> executeTask(TaskVO vo, MemberInfoModel memberInfoModel);

    /**
     * 修改任务
     * @param bo
     * @param stageUser
     * @return
     */
    public ResponseData<Integer> updateTask(TaskBO bo,SysAccountPO stageUser);

    /**
     * 查询任务详情
     * @param taskId
     * @return
     */
    public ResponseData<TaskBO> selectTaskById(Long taskId);

//    /**
//     * 查询商家选择出的让会员完善的扩展信息字段
//     * @param brandId
//     * @return
//     */
//    public ResponseData getChosenExtendProperty(Long brandId);

    /**
     * 完善资料任务效果分析
     * @param date1
     * @param date2
     * @param stageUser
     * @return
     */
    public ResponseData<TaskRecordVO> getTaskProfileRecordByTime(Date date1, Date date2,SysAccountPO stageUser,PageForm pageForm);


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
     * 任务审核
     * @param taskId
     * @param stageUser
     * @param checkStatus
     * @return
     */
    public ResponseData checkTaskProfile(Long taskId,SysAccountPO stageUser,Integer checkStatus);

}
