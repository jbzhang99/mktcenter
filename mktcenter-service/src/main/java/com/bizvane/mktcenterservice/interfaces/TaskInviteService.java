package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.bo.TaskDetailBO;
import com.bizvane.mktcenterservice.models.po.MktTaskInvitePO;
import com.bizvane.mktcenterservice.models.po.MktTaskOrderPO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterservice.models.vo.TaskDetailVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

import java.text.ParseException;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/16 14:06
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public interface TaskInviteService {
    /**
     * 任务的审核
     * @param vo
     * @return
     */
    public  Integer  checkInviteTask(TaskVO vo);

    /**
     * 查询任务详情
     */
    public List<TaskDetailBO> getInviteTaskDetails(Long mktTaskId);

    /**
     * 查询任务列表
     * @return
     */
    public List<TaskVO> selectTask(TaskVO vo);

    /**
     * 新增任务
     * @return
     */
    public ResponseData<Integer> addTask(TaskDetailVO vo, SysAccountPO stageUser) throws ParseException;

    /**
     * 修改任务
     * @param stageUser
     * @return
     */
    public ResponseData updateInviteTask(TaskDetailVO vo, SysAccountPO stageUser) throws ParseException;
    /**
     * 新增具体任务
     */
    public Integer insertInviteTask(MktTaskInvitePO po, SysAccountPO stageUser);
    /**
     * 修改具体任务
     * @param po
     * @param stageUser
     * @return
     */
    public Integer modifieInviteTask(MktTaskInvitePO po, SysAccountPO stageUser);
}

