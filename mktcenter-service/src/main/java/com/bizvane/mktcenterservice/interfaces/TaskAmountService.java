package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.bo.TaskDetailBO;
import com.bizvane.mktcenterservice.models.po.MktTaskOrderPO;
import com.bizvane.mktcenterservice.models.vo.TaskDetailVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

import java.text.ParseException;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/8/2 18:04
 * 消费金额
 */
public interface TaskAmountService {
    /**
     * 任务的审核
     * @param vo
     * @return
     */
    public  Integer  checkAmountTask(TaskVO vo);

    /**
     * 查询任务详情
     */
    public List<TaskDetailBO> getAmountTaskDetails(Long mktTaskId);

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
    public ResponseData updateAmountTask(TaskDetailVO vo, SysAccountPO stageUser);
    /**
     * 新增具体任务
     */
    public Integer insertAmoutTask(MktTaskOrderPO po, SysAccountPO stageUser);
    /**
     * 修改具体任务
     * @param po
     * @param stageUser
     * @return
     */
    public Integer modifieAmoutTask(MktTaskOrderPO po, SysAccountPO stageUser);
}
