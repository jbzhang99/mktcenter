package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.utils.commonutils.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/16 14:06
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public interface TaskOrderService {
    /**
     * 查询任务列表
     * @param vo
     * @return
     */
    public ResponseData<TaskVO> getTaskList(TaskVO vo, PageForm pageForm);

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
    public ResponseData<Integer> executeTask(TaskVO vo);

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
    public ResponseData<List<TaskVO>> selectTaskById(Long mktTaskId);
}
