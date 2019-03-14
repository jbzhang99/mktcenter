package com.bizvane.mktcenterservice.common.utils;

import com.bizvane.mktcenterfacade.models.bo.TaskBO;
import com.bizvane.mktcenterfacade.models.po.MktCouponPO;
import com.bizvane.mktcenterfacade.models.vo.TaskDetailVO;
import com.bizvane.mktcenterfacade.models.vo.TaskVO;
import com.bizvane.mktcenterservice.common.constants.SystemConstants;
import com.bizvane.mktcenterservice.common.constants.TaskConstants;
import com.bizvane.mktcenterservice.common.enums.TaskTypeEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/24 11:18
 * @description 任务参数校验工具类
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public class TaskParamCheckUtil {
    /**
     * 参数校验
     * @param bo
     * @return
     */
    public static ResponseData checkParam(TaskBO bo){
        ResponseData responseData = new ResponseData();
        responseData.setCode(SystemConstants.ERROR_CODE);

        //任务主体参数校验
        if(bo ==null || bo.getTaskVO()==null){
            responseData.setMessage(SystemConstants.ERROR_MSG_PARAM_EMPTY);
            return responseData;
        }
        TaskVO vo = bo.getTaskVO();
        //任务名称为空
        if(StringUtils.isEmpty(vo.getTaskName())){
            responseData.setMessage(TaskConstants.ERROR_MSG_TASK_NAME_EMPTY);
            return responseData;
        }



        /*//任务类型
        if(vo.getTaskType()==null){
            responseData.setMessage(TaskConstants.ERROR_MSG_TASK_TYPE_EMPTY);
            return responseData;
        }*/

        //各类型活动参数校验
        TaskTypeEnum activityTypeEnum = TaskTypeEnum.getTaskTypeEnumByCode(vo.getTaskType());
        //防止前端传来活动类型与枚举类型不匹配产生的空指针
        if(activityTypeEnum==null){
            responseData.setMessage(TaskConstants.ERROR_MSG_TASK_TYPE_NOT_EXISTS);
            return responseData;
        }
        switch (activityTypeEnum){
            case TASK_TYPE_PROFILE:
                responseData = checkProfileTaskParam(vo);
                break;
            case TASK_TYPE_SHARE:
                responseData = checkCommonTaskParam(vo);
                break;
            case TASK_TYPE_INVITE:
                responseData = checkCommonTaskParam(vo);
                break;
            case TASK_TYPE_CONSUME_TIMES:
                responseData = checkCommonTaskParam(vo);
                break;
            case TASK_TYPE_CONSUME_AMOUNT:
                responseData = checkCommonTaskParam(vo);
                break;
            default:
                responseData.setCode(SystemConstants.SUCCESS_CODE);
                break;
        }

        //如果任务不为完善资料 则需判断任务时间以及描述
        if (activityTypeEnum!=TaskTypeEnum.TASK_TYPE_PROFILE){
            //任务开始时间，结束时间校验
            if(vo.getStartTime()==null || vo.getEndTime()==null){
                responseData.setMessage(TaskConstants.ERROR_MSG_TASK_DATE_EMPTY);
                return responseData;
            }
            //任务描述校验
            if(StringUtils.isEmpty(vo.getTaskInfo())){
                responseData.setMessage(TaskConstants.ERROR_MSG_TASK_INFO_EMPTY);
                return responseData;
            }

        }
        //任务审核通过,不能修改
        Integer checkStatus = vo.getCheckStatus();
        if (TaskConstants.THREE.equals(checkStatus)){
            responseData.setMessage(TaskConstants.ERROR_MSG_TASK_INFO_IS_CHECK);
            return responseData;
        }


        if(responseData.getCode()==SystemConstants.ERROR_CODE){
            return responseData;
        }else{
            responseData.setCode(SystemConstants.SUCCESS_CODE);
            responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
            return responseData;
        }
    }

    //通用活动参数校验
    public static ResponseData checkCommonTaskParam(TaskVO vo){
        ResponseData responseData = new ResponseData();
        return responseData;
    }

    //完善资料任务参数校验
    public static ResponseData checkProfileTaskParam(TaskVO vo){
        ResponseData responseData = new ResponseData();
        return responseData;
    }

    /**
     * 用于判断消费相关的任务
     * @param vo
     * @return
     */
    public static ResponseData checkParam(TaskDetailVO vo){
        ResponseData responseData = new ResponseData();
        responseData.setCode(SystemConstants.ERROR_CODE);

        //任务主体参数校验

        List<MktCouponPO> mktCouponPOList = vo.getMktCouponPOList();
  
        if(vo ==null){
            responseData.setMessage(SystemConstants.ERROR_MSG_PARAM_EMPTY);
            return responseData;
        }
        //任务名称为空
        if(StringUtils.isEmpty(vo.getTaskName())){
            responseData.setMessage(TaskConstants.ERROR_MSG_TASK_NAME_EMPTY);
            return responseData;
        }
        //任务开始时间，结束时间校验
        if(vo.getStartTime()==null || vo.getEndTime()==null){
            responseData.setMessage(TaskConstants.ERROR_MSG_TASK_DATE_EMPTY);
            return responseData;
        }
        //任务描述校验
        if(StringUtils.isEmpty(vo.getTaskInfo())){
            responseData.setMessage(TaskConstants.ERROR_MSG_TASK_INFO_EMPTY);
            return responseData;
        }
        //任务类型
        if(vo.getTaskType()==null){
            responseData.setMessage(TaskConstants.ERROR_MSG_TASK_TYPE_EMPTY);
            return responseData;
        }

        //各类型活动参数校验
        TaskTypeEnum activityTypeEnum = TaskTypeEnum.getTaskTypeEnumByCode(vo.getTaskType());
        //防止前端传来活动类型与枚举类型不匹配产生的空指针
        if(activityTypeEnum==null){
            responseData.setMessage(TaskConstants.ERROR_MSG_TASK_TYPE_NOT_EXISTS);
            return responseData;
        }
        //TASK_TYPE_CONSUME_AMOUNT

        switch (activityTypeEnum){
            case TASK_TYPE_CONSUME_TIMES:
                responseData.setCode(SystemConstants.SUCCESS_CODE);
                break;
            case TASK_TYPE_CONSUME_AMOUNT:
                responseData.setCode(SystemConstants.SUCCESS_CODE);
                break;
            case TASK_TYPE_INVITE:
                responseData.setCode(SystemConstants.SUCCESS_CODE);
                break;
            default:
                responseData.setMessage(SystemConstants.ERROR_TASK_TYPE_ERRO);
                break;
        }

        if(responseData.getCode()==SystemConstants.ERROR_CODE){
            return responseData;
        }else{
            responseData.setCode(SystemConstants.SUCCESS_CODE);
            responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
            return responseData;
        }
    }
}
