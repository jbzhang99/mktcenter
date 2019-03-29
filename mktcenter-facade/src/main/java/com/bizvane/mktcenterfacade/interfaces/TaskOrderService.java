package com.bizvane.mktcenterfacade.interfaces;

import com.bizvane.mktcenterfacade.models.po.MktTaskOrderPO;
import com.bizvane.mktcenterfacade.models.bo.TaskBO;
import com.bizvane.mktcenterfacade.models.bo.TaskDetailBO;
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
public interface TaskOrderService {
    /**
     * 任务的审核
     * @param vo
     * @return
     */
    public  Integer  checkOrderTask(TaskVO vo);
    /**
     * 查询任务详情
     */
    public  List<TaskDetailBO> getOrderTaskDetails(Long mktTaskId);
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
     * 修改消费任务
     * @return
     */
    public ResponseData updateOrderTask(TaskBO bo, SysAccountPO stageUser);

    public Integer modifieOrderTask(MktTaskOrderPO po, SysAccountPO stageUser);

}
