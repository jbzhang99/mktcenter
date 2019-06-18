package com.bizvane.mktcenterservice.controllers;

import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterfacade.interfaces.ActivityEvaluationService;
import com.bizvane.mktcenterfacade.models.bo.ActivityAnalysisCountBO;
import com.bizvane.mktcenterfacade.models.bo.ActivityBO;
import com.bizvane.mktcenterfacade.models.bo.ActivityEvaluationBO;
import com.bizvane.mktcenterfacade.models.bo.CtivityAnalysisBO;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.mktcenterfacade.models.vo.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
    public ResponseData<ActivityVO> getActivityEvaluationList(ActivityVO vo, PageForm pageForm,HttpServletRequest request){
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        ResponseData<ActivityVO> activityEvaluationList = activityEvaluationService.getActivityEvaluationList(vo,pageForm,stageUser);
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
    public ResponseData<Integer> executeActivityEvaluation(ActivityEvaluationBO activityEvaluationBO){
        return activityEvaluationService.executeActivityEvaluation(activityEvaluationBO);
    }

    /**
     * 查询效果分析统计
     * @param bo
     * @param pageForm
     * @return
     */
    @RequestMapping("getEvaluationAnalysisCountpage")
    public ResponseData<CtivityAnalysisBO> getEvaluationAnalysisCountpage(ActivityAnalysisCountBO bo, PageForm pageForm){
        return activityEvaluationService.getActivityAnalysisCountpage(bo,pageForm);
    }
}
