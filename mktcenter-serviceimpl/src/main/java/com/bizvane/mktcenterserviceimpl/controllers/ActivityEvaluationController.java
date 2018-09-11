package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.interfaces.ActivityEvaluationService;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by pc on 2018/9/8.
 */
@RestController
@RequestMapping("activityEvaluation")
public class ActivityEvaluationController {
    @Autowired
    private ActivityEvaluationService activityEvaluationService;

    /**
     * 查询活动列表
     * @return
     */
    @RequestMapping("getActivityEvaluationList")
    public ResponseData<ActivityVO> getActivityEvaluationList(ActivityVO vo, PageForm pageForm){
        ResponseData<ActivityVO> activityEvaluationList = activityEvaluationService.getActivityEvaluationList(vo,pageForm);
        return activityEvaluationList;
    }

    /**
     * 创建活动
     * @return
     */
    @RequestMapping("addActivityEvaluation")
    public ResponseData<Integer> addActivityEvaluation(ActivityBO bo , HttpServletRequest request) {
        //参数校验
      /*  ResponseData responseData = ActivityParamCheckUtil.checkParam(bo);
        //参数校验不通过
        if (SystemConstants.ERROR_CODE == responseData.getCode()) {
            return responseData;
        }*/
        //参数校验通过，获取操作人信息
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        System.out.println("=============="+stageUser);
        //SysAccountPO stageUser = new SysAccountPO();

        //新增活动
        ResponseData<Integer> integerResponseData = activityEvaluationService.addActivityEvaluation(bo,stageUser);

        //返回
        return integerResponseData;
    }

    /**
     * 查询活动详情
     * @param businessCode
     * @return
     */
    @RequestMapping("selectActivityEvaluationById")
    public ResponseData<ActivityBO> selectActivityEvaluationById(String businessCode){
        return activityEvaluationService.selectActivityEvaluationById(businessCode);
    }

    /**
     * 执行活动
     * @param
     * @return
     */
    @RequestMapping("executeActivityEvaluation")
    public ResponseData<Integer> executeActivityEvaluation(MemberInfoModel vo){
        return activityEvaluationService.executeActivityEvaluation(vo);
    }
}
