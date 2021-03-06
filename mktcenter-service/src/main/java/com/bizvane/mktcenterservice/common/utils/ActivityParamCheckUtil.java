package com.bizvane.mktcenterservice.common.utils;

import com.bizvane.mktcenterfacade.models.bo.ActivityBO;
import com.bizvane.mktcenterfacade.models.vo.ActivitySmartVO;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.common.constants.ActivityConstants;
import com.bizvane.mktcenterservice.common.constants.SystemConstants;
import com.bizvane.mktcenterservice.common.enums.ActivityTypeEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.util.StringUtils;

/**
 * @author chen.li
 * @date on 2018/7/13 11:29
 * @description
 *
 */
public class ActivityParamCheckUtil {

    /**
     * 参数校验
     * @param bo
     * @return
     */
    public static ResponseData checkParam(ActivityBO bo){
        ResponseData responseData = new ResponseData();
        responseData.setCode(SystemConstants.ERROR_CODE);

        //活动主体
        if(bo ==null || bo.getActivityVO()==null){
            responseData.setMessage(SystemConstants.ERROR_MSG_PARAM_EMPTY);
            return responseData;
        }
        ActivityVO vo = bo.getActivityVO();
        if(StringUtils.isEmpty(vo.getActivityName())){
            responseData.setMessage(ActivityConstants.ERROR_MSG_ACTIVITY_NAME_EMPTY);
            return responseData;
        }
        if(StringUtils.isEmpty(vo.getLongTerm())){
            responseData.setMessage(ActivityConstants.ERROR_MSG_ACTIVITY_LONG_TERM_EMPTY);
            return responseData;
        }
        if(vo.getStartTime()==null || vo.getEndTime()==null){
            responseData.setMessage(ActivityConstants.ERROR_MSG_ACTIVITY_DATE_EMPTY);
            return responseData;
        }
        if(StringUtils.isEmpty(vo.getActivityInfo())){
            responseData.setMessage(ActivityConstants.ERROR_MSG_ACTIVITY_INFO_EMPTY);
            return responseData;
        }
        if(vo.getActivityType()==null){
            responseData.setMessage(ActivityConstants.ERROR_MSG_ACTIVITY_TYPE_EMPTY);
            return responseData;
        }

        //各类型活动参数校验
        ActivityTypeEnum activityTypeEnum = ActivityTypeEnum.getActivityTypeEnumByCode(vo.getActivityType());
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
    public static ResponseData checkCommonActivityParam(ActivityVO vo){
        ResponseData responseData = new ResponseData();
        if(StringUtils.isEmpty(vo.getMbrLevelCode())){
            responseData.setMessage(ActivityConstants.ERROR_MSG_MBR_LEVEL_CODE_EMPTY);
            return responseData;
        }
        if(StringUtils.isEmpty(vo.getMbrLevelName())){
            responseData.setMessage(ActivityConstants.ERROR_MSG_MBR_LEVEL_NAME_EMPTY);
            return responseData;
        }
        if(vo.getMemberType()==null){
            responseData.setMessage(ActivityConstants.ERROR_MSG_MEMBER_TYPE_EMPTY);
            return responseData;
        }
        return responseData;
    }

    //开卡活动参数校验
    public static ResponseData checkRegisterActivityParam(ActivityVO vo){
        ResponseData responseData = new ResponseData();
        if(vo.getOfflineCardStatus()==null){
            responseData.setMessage(ActivityConstants.ERROR_MSG_OFFLINE_CARD_STATUS_EMPTY);
            return responseData;
        }
        if(StringUtils.isEmpty(vo.getMbrLevelCode())){
            responseData.setMessage(ActivityConstants.ERROR_MSG_MBR_LEVEL_CODE_EMPTY);
            return responseData;
        }
        if(StringUtils.isEmpty(vo.getMbrLevelName())){
            responseData.setMessage(ActivityConstants.ERROR_MSG_MBR_LEVEL_NAME_EMPTY);
            return responseData;
        }
        return responseData;
    }

    //升级活动参数校验
    public static ResponseData checkUpgradeActivityParam(ActivityVO vo){
        ResponseData responseData = new ResponseData();
        return responseData;
    }

    //生日活动参数校验
    public static ResponseData checkBirthdayActivityParam(ActivityVO vo){
        ResponseData responseData = new ResponseData();
        if(StringUtils.isEmpty(vo.getMbrLevelCode())){
            responseData.setMessage(ActivityConstants.ERROR_MSG_MBR_LEVEL_CODE_EMPTY);
            return responseData;
        }
        if(StringUtils.isEmpty(vo.getMbrLevelName())){
            responseData.setMessage(ActivityConstants.ERROR_MSG_MBR_LEVEL_NAME_EMPTY);
            return responseData;
        }
        if(vo.getMemberType()==null){
            responseData.setMessage(ActivityConstants.ERROR_MSG_MEMBER_TYPE_EMPTY);
            return responseData;
        }
        if(vo.getDaysAhead()==null){
            responseData.setMessage(ActivityConstants.ERROR_MSG_DAYS_AHEAD);
            return responseData;
        }
        return responseData;
    }

    //消费活动参数校验
    public static ResponseData checkOrderActivityParam(ActivityVO vo){
        ResponseData responseData = new ResponseData();
        return responseData;
    }

    //签到活动参数校验
    public static ResponseData checkSigninActivityParam(ActivityVO vo){
        ResponseData responseData = new ResponseData();
        return responseData;
    }

    public static ResponseData checkManualActivityParams(Long couponId, ActivityVO activityVO) {
        ResponseData responseData = new ResponseData();
        if(activityVO==null){
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage(SystemConstants.ERROR_MSG_PARAM_EMPTY);
            return responseData;
        }
        if(activityVO.getSysBrandId()==null){
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage(ActivityConstants.ERROR_MSG_BRAND_ID_EMPTY);
            return  responseData;
        }
        if(StringUtils.isEmpty(activityVO.getActivityName())){
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage(ActivityConstants.ERROR_MSG_ACTIVITY_NAME_EMPTY);
            return responseData;
        }
        if(StringUtils.isEmpty(activityVO.getStartTime())||StringUtils.isEmpty(activityVO.getEndTime())){
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage(ActivityConstants.ERROR_MSG_ACTIVITY_DATE_EMPTY);
            return responseData;
        }
        if(null==activityVO.getPerPersonMax()){
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage(ActivityConstants.MAX_CAN_RECEIVE);
            return responseData;
        }
        if(null==activityVO.getPerPersonPerDayMax()){
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage(ActivityConstants.MAX_DAY_CAN_RECEIVE);
            return responseData;
        }
        if(null==couponId){
            responseData.setCode(SystemConstants.ERROR_CODE);
            responseData.setMessage(ActivityConstants.COUPON_INFO_EMPTY);
            return responseData;
        }
        return responseData;
    }

    //智能营销活动参数校验
    public static ResponseData checkSmartActivityParam(ActivitySmartVO vo){
        ResponseData responseData = new ResponseData();
        return responseData;
    }
}
