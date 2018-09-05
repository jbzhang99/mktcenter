package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.mktcenterservice.interfaces.TaskAmountService;
import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.bo.TaskDetailBO;
import com.bizvane.mktcenterservice.models.vo.TaskDetailVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/8/2 18:00
 * 消费金额任务
 */
@RestController
@RequestMapping("/taskAmoun")
public class TaskAmountController {
    @Autowired
    private TaskAmountService taskAmountService;
    /**
     * 任务审核
     */
    @RequestMapping("checkAmountTask")
    public  ResponseData<Integer>  checkOrderTask(TaskVO vo){
        ResponseData<Integer> result = new ResponseData<Integer>(SysResponseEnum.FAILED.getCode(),SysResponseEnum.FAILED.getMessage(),null);
        Integer data = taskAmountService.checkAmountTask(vo);
        if (data>0){
            result.setCode(SysResponseEnum.SUCCESS.getCode());
            result.setMessage(SysResponseEnum.SUCCESS.getMessage());
        }
        return result;
    }
    /**
     * 查询消费任务详情
     */
    @RequestMapping("getAmountTaskDetails")
    public  ResponseData<TaskDetailBO> getOrderTaskDetails(Long mktTaskId){
        ResponseData<TaskDetailBO> result = new ResponseData<TaskDetailBO>(SysResponseEnum.FAILED.getCode(),SysResponseEnum.FAILED.getMessage(),null);
        List<TaskDetailBO> orderTaskDetails = taskAmountService.getAmountTaskDetails(mktTaskId);

        if (CollectionUtils.isNotEmpty(orderTaskDetails)){
            result.setCode(SysResponseEnum.SUCCESS.getCode());
            result.setMessage(SysResponseEnum.SUCCESS.getMessage());
            result.setData(orderTaskDetails.get(0));
        }

        return  result;
    }

    /**
     * 创建任务
     * @return
     */
    @RequestMapping("addTask")
    public ResponseData<Integer> addTask(TaskBO bo, HttpServletRequest request) throws ParseException {
        //参数校验通过，获取操作人信息
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
//        SysAccountPO sysAccountPo = new SysAccountPO();
//        sysAccountPo.setSysAccountId(26L);
//        sysAccountPo.setSysCompanyId(2L);
//        sysAccountPo.setBrandId(4L);
//        sysAccountPo.setAccountCode("15328634678");
//        sysAccountPo.setName("不啊哟删除");
        bo.getTaskVO().setTaskType(5);
        return  taskAmountService.addTask(bo, sysAccountPo);
    }
    /**
     * 修改任务
     */
    @RequestMapping("updateAmountTask")
    public ResponseData updateAmountTask(TaskBO bo, HttpServletRequest request){
        SysAccountPO stageUser = TokenUtils.getStageUser(request);

        return  taskAmountService.updateAmountTask(bo, stageUser);
    }
}
