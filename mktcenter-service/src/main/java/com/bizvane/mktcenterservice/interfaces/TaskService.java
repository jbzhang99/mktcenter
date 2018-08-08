package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.centerstageservice.models.po.SysCheckConfigPo;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.models.OrderServeModel;
import com.bizvane.mktcenterservice.models.bo.TaskInviteAwardBO;
import com.bizvane.mktcenterservice.models.bo.TaskAwardBO;
import com.bizvane.mktcenterservice.models.po.MktTaskPOWithBLOBs;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterservice.models.vo.TaskDetailVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageInfo;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/16 14:05
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public interface TaskService {

    /**
     * 根据公司id和品牌id查询执行中的消费类任务
     * @param sysCompanyId
     * @param sysBrandId
     * @return
     */
    public List<TaskAwardBO> getTaskOrderAwardList(Long sysCompanyId, Long sysBrandId, Date placeOrderTime);
    /**
     * 根据公司id和品牌id查询执行中的邀请类任务
     * @param sysCompanyId
     * @param sysBrandId
     * @return
     *
     */
    public List<TaskAwardBO> getTaskInviteAwardList(Long sysCompanyId, Long sysBrandId,Date placeOrderTime);
    /**
     * 查询订单详情
     * @param mktTaskId
     * @return
     */
    public  List<TaskDetailVO> getTaskDetailByTaskId(Long mktTaskId);

    /**
     * 设定任务状态
     * @param po
     * @return
     * @throws ParseException
     */
    public MktTaskPOWithBLOBs isOrNoCheckState(MktTaskPOWithBLOBs po)throws ParseException;

    /**
     * 发送任务消息
     * @param vo
     * @param mktTaskPOWithBLOBs
     * @param stageUser
     */
    public void doOrderTask(TaskDetailVO vo, MktTaskPOWithBLOBs mktTaskPOWithBLOBs, SysAccountPO stageUser);
    /**
     * 发送消息
     * @param sysCompanyId
     */
    public  void  sendSmg(Long sysCompanyId);

    /**
     * 发送券和积分
     * @param model
     * @param orderAwardBO
     */
    public void sendCouponAndPoint(OrderServeModel model, TaskAwardBO orderAwardBO);
    /**
     * 根据品牌id查询任务是否需要审核
     */

    public  Integer  getCheckStatus(SysCheckConfigPo sysCheckConfigPo);
    /**
     * 根据任务类型查询任务列表
     * @param vo
     * @return
     */
    public ResponseData<PageInfo<MktTaskPOWithBLOBs>> getTaskByTaskType(TaskVO vo, PageForm pageForm);

    /**
     * 新增
     */
    public  Long  addTask(MktTaskPOWithBLOBs task,SysAccountPO sysAccountPO);

    /**
     * 修改
     * @param task
     * @param stageUser
     * @return
     */
    public  Integer   updateTask(MktTaskPOWithBLOBs task, SysAccountPO stageUser);

    /**
     * 禁用/停止任务
     * @param mktTaskId
     * @return
     */
    public ResponseData<Integer> stopTaskById(Long mktTaskId, SysAccountPO sysAccountPO);

    /**
     * 任务审核
     * @param mktTaskId
     * @return
     */
    public ResponseData<Integer> checkTaskById(Long mktTaskId,Integer checkStatus, SysAccountPO sysAccountPO);

    /**
     * 获取公司下的所有会员
     * @param sysCompanyId
     * @return
     */
    public  List<MemberInfoModel>  getCompanyMemebers(Long sysCompanyId);
}
