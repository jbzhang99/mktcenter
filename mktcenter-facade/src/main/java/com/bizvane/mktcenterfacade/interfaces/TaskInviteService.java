package com.bizvane.mktcenterfacade.interfaces;

import com.bizvane.mktcenterfacade.models.bo.TaskBO;
import com.bizvane.mktcenterfacade.models.po.MktTaskInvitePO;
import com.bizvane.mktcenterfacade.models.vo.InviteSuccessVO;
import com.bizvane.mktcenterfacade.models.vo.TaskVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

import java.text.ParseException;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/16 14:06
 * @description
 *
 */
public interface TaskInviteService {
    /**
     * 查询任务列表
     * @return
     */
    public List<TaskVO> selectTask(TaskVO vo);

    /**
     * 新增任务
     * @return
     */
    public ResponseData<Integer> addTask(TaskBO bo, SysAccountPO stageUser) throws ParseException;

    /**
     * 执行任务奖励
     * @param vo
     */
    public  void   doAwardInvite(InviteSuccessVO vo);
    /**
     * 修改任务
     * @param stageUser
     * @return
     */
    public ResponseData updateInviteTask(TaskBO bo, SysAccountPO stageUser) throws ParseException;
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

