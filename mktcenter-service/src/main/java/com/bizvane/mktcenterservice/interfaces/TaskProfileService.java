package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.po.MktMessagePOExample;
import com.bizvane.mktcenterservice.models.po.MktTaskRecordPO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
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
     *执行任务
     * @param vo
     * @return
     */
    public ResponseData<Integer> executeTask(TaskVO vo);

    /**
     * 修改任务
     * @param bo
     * @param stageUser
     * @return
     */
    public ResponseData<Integer> updateTask(TaskBO bo,SysAccountPO stageUser);

    /**
     * 查询任务详情
     * @param mktTaskId
     * @return
     */
    public ResponseData<List<TaskVO>> selectTaskById(Long mktTaskId);

    /**
     * 查询商家选择出的让会员完善的扩展信息字段
     * @param brandId
     * @return
     */
    public ResponseData getChosenExtendProperty(Long brandId);

    /**
     * 根据时间查询完善资料的人数及发行的优惠券以及积分
     * @param date1
     * @param date2
     * @return
     */
    public ResponseData<List<MktTaskRecordPO>> getTaskProfileRecordByTime(Date date1,Date date2);

    /**
     * 任务审核
     * @param taskVO
     * @param sysAccountPO
     * @return
     */
    public ResponseData checkTaskProfile(TaskVO taskVO,SysAccountPO sysAccountPO);

}
