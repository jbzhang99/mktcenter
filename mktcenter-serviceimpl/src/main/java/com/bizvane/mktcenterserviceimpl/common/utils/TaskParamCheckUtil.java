package com.bizvane.mktcenterserviceimpl.common.utils;

import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.mktcenterserviceimpl.common.constants.ActivityConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityTypeEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.util.StringUtils;

/**
 * @author chen.li
 * @date on 2018/7/24 11:18
 * @description
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

        //活动主体
        if(bo ==null || bo.getTaskVO()==null){
            responseData.setMessage(SystemConstants.ERROR_MSG_PARAM_EMPTY);
            return responseData;
        }
        TaskVO vo = bo.getTaskVO();
        if(StringUtils.isEmpty(vo.getTaskName())){
            responseData.setMessage(ActivityConstants.ERROR_MSG_ACTIVITY_NAME_EMPTY);
            return responseData;
        }

        if(vo.getStartTime()==null || vo.getEndTime()==null){
            responseData.setMessage(ActivityConstants.ERROR_MSG_ACTIVITY_DATE_EMPTY);
            return responseData;
        }
        if(StringUtils.isEmpty(vo.getTaskInfo())){
            responseData.setMessage(ActivityConstants.ERROR_MSG_ACTIVITY_INFO_EMPTY);
            return responseData;
        }
        if(vo.getTaskType()==null){
            responseData.setMessage(ActivityConstants.ERROR_MSG_ACTIVITY_TYPE_EMPTY);
            return responseData;
        }

        //各类型活动参数校验
        ActivityTypeEnum activityTypeEnum = ActivityTypeEnum.getActivityTypeEnumByCode(vo.getTaskType());
        //防止前端传来活动类型与枚举类型不匹配产生的空指针
        if(activityTypeEnum==null){
            responseData.setMessage(ActivityConstants.ERROR_MSG_ACTIVITY_TYPE_NOT_EXISTS);
            return responseData;
        }
        switch (activityTypeEnum){
            case ACTIVITY_TYPE_REGISGER:
                responseData = checkRegisterActivityParam(vo);
                break;
            case ACTIVITY_TYPE_UPGRADE:
                responseData = checkCommonActivityParam(vo);
                break;
            case ACTIVITY_TYPE_QRCODE:
                responseData = checkCommonActivityParam(vo);
                break;
            case ACTIVITY_TYPE_MANUAL:
                responseData = checkCommonActivityParam(vo);
                break;
            case ACTIVITY_TYPE_ORDER:
                responseData = checkCommonActivityParam(vo);
                break;
            case ACTIVITY_TYPE_SIGNIN:
                responseData = checkCommonActivityParam(vo);
                break;
            case ACTIVITY_TYPE_BIRTHDAY:
                responseData = checkBirthdayActivityParam(vo);
                break;
            case ACTIVITY_TYPE_SMART:
                responseData = checkCommonActivityParam(vo);
                break;
            default:break;
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
    public static ResponseData checkCommonActivityParam(TaskVO vo){
        ResponseData responseData = new ResponseData();
//        if(StringUtils.isEmpty(vo.getMbrLevelCode())){
//            responseData.setMessage(ActivityConstants.ERROR_MSG_MBR_LEVEL_CODE_EMPTY);
//            return responseData;
//        }
//        if(StringUtils.isEmpty(vo.getMbrLevelName())){
//            responseData.setMessage(ActivityConstants.ERROR_MSG_MBR_LEVEL_NAME_EMPTY);
//            return responseData;
//        }
//        if(vo.getMemberType()==null){
//            responseData.setMessage(ActivityConstants.ERROR_MSG_MEMBER_TYPE_EMPTY);
//            return responseData;
//        }
        return responseData;
    }

    //开卡活动参数校验
    public static ResponseData checkRegisterActivityParam(TaskVO vo){
        ResponseData responseData = new ResponseData();
//        if(vo.getOfflineCardStatus()==null){
//            responseData.setMessage(ActivityConstants.ERROR_MSG_OFFLINE_CARD_STATUS_EMPTY);
//            return responseData;
//        }
//        if(StringUtils.isEmpty(vo.getMbrLevelCode())){
//            responseData.setMessage(ActivityConstants.ERROR_MSG_MBR_LEVEL_CODE_EMPTY);
//            return responseData;
//        }
//        if(StringUtils.isEmpty(vo.getMbrLevelName())){
//            responseData.setMessage(ActivityConstants.ERROR_MSG_MBR_LEVEL_NAME_EMPTY);
//            return responseData;
//        }
        return responseData;
    }

    //升级活动参数校验
    public static ResponseData checkUpgradeActivityParam(TaskVO vo){
        ResponseData responseData = new ResponseData();
        return responseData;
    }

    //生日活动参数校验
    public static ResponseData checkBirthdayActivityParam(TaskVO vo){
        ResponseData responseData = new ResponseData();
//        if(StringUtils.isEmpty(vo.getMbrLevelCode())){
//            responseData.setMessage(ActivityConstants.ERROR_MSG_MBR_LEVEL_CODE_EMPTY);
//            return responseData;
//        }
//        if(StringUtils.isEmpty(vo.getMbrLevelName())){
//            responseData.setMessage(ActivityConstants.ERROR_MSG_MBR_LEVEL_NAME_EMPTY);
//            return responseData;
//        }
//        if(vo.getMemberType()==null){
//            responseData.setMessage(ActivityConstants.ERROR_MSG_MEMBER_TYPE_EMPTY);
//            return responseData;
//        }
//        if(vo.getDaysAhead()==null){
//            responseData.setMessage(ActivityConstants.ERROR_MSG_DAYS_AHEAD);
//            return responseData;
//        }
        return responseData;
    }

    //消费活动参数校验
    public static ResponseData checkOrderActivityParam(TaskVO vo){
        ResponseData responseData = new ResponseData();
        return responseData;
    }

    //签到活动参数校验
    public static ResponseData checkSigninActivityParam(TaskVO vo){
        ResponseData responseData = new ResponseData();
        return responseData;
    }
}
