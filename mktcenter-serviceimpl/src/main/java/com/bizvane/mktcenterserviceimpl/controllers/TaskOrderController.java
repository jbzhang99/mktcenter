package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.mktcenterservice.interfaces.TaskOrderService;
import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.bo.TaskDetailBO;
import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.vo.MessageVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterservice.models.vo.TaskConsumeVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.utils.TaskParamCheckUtil;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/13 13:38
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 * 消费次数任务
 */
@RestController
@RequestMapping("taskOrder")
public class TaskOrderController {

    @Autowired
    private TaskOrderService taskOrderService;

    /**
     * 任务审核
     */
    @RequestMapping("checkOrderTask")
    public  ResponseData<Integer>  checkOrderTask(TaskVO vo){
        ResponseData<Integer> result = new ResponseData<Integer>(SysResponseEnum.FAILED.getCode(),SysResponseEnum.FAILED.getMessage(),null);
        Integer data = taskOrderService.checkOrderTask(vo);
        if (data>0){
            result.setCode(SysResponseEnum.SUCCESS.getCode());
            result.setMessage(SysResponseEnum.SUCCESS.getMessage());
        }
        return result;
    }
    /**
     * 查询消费任务详情
     */
    @RequestMapping("getOrderTaskDetails")
    public  ResponseData<TaskDetailBO> getOrderTaskDetails(Long mktTaskId){
        ResponseData<TaskDetailBO> result = new ResponseData<TaskDetailBO>(SysResponseEnum.FAILED.getCode(),SysResponseEnum.FAILED.getMessage(),null);
        List<TaskDetailBO> orderTaskDetails = taskOrderService.getOrderTaskDetails(mktTaskId);

        if (CollectionUtils.isNotEmpty(orderTaskDetails)){
            result.setCode(SysResponseEnum.SUCCESS.getCode());
            result.setMessage(SysResponseEnum.SUCCESS.getMessage());
            result.setData(orderTaskDetails.get(0));
        }

        return  result;
    }
    /**
     * 查询任务列表并分页(有问题)
     * @return
     */
    @RequestMapping("getTaskList")
    public ResponseData<TaskVO> getTaskList(TaskVO vo, PageForm pageForm){
        ResponseData responseData = new ResponseData();
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
        List<TaskVO> activityRegisterList = taskOrderService.selectTask(vo);
        PageInfo<TaskVO> pageInfo = new PageInfo<>(activityRegisterList);
        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 创建任务
     * @return
     */
    @RequestMapping("addTask")
    public ResponseData<Integer> addTask(TaskConsumeVO vo, HttpServletRequest request) throws ParseException {
        //参数校验通过，获取操作人信息
       SysAccountPO stageUser = TokenUtils.getStageUser(request);

       return  taskOrderService.addTask(vo, stageUser);
    }

    /**
     * 修改任务
     * @param
     * @return
     */
    public ResponseData<Integer> updateTask(TaskVO vo, List<MktCouponPO> couponCodeList, List<MessageVO> messageVOList, HttpServletRequest request){
        TaskBO bo = new TaskBO();
        bo.setTaskVO(vo);
        bo.setMktCouponPOList(couponCodeList);
        bo.setMessageVOList(messageVOList);
        //参数校验
        ResponseData responseData = TaskParamCheckUtil.checkParam(bo);
        //参数校验不通过
        if(SystemConstants.ERROR_CODE==responseData.getCode()){
            return responseData;
        }
        //参数校验通过，获取操作人信息
        SysAccountPO stageUser = new SysAccountPO();
        //更新活动
       // ResponseData<Integer> registerData = taskOrderService.updateTask(bo,stageUser);

        //返回

        return null;
    }

    /**
     * 执行任务
     * @param
     * @return
     */
    public ResponseData<Integer> executeTask(TaskVO vo){

        return taskOrderService.executeTask(vo);
    }

    /**
     * 查询任务详情
     * @param mktActivityId
     * @return
     */
 /*   public ResponseData<List<TaskVO>> selectTaskById(Long mktActivityId){
        return taskOrderService.selectTaskById(mktActivityId);
    }*/
}
