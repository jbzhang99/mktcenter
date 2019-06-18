package com.bizvane.mktcenterfacade.interfaces;

import com.bizvane.mktcenterfacade.models.bo.ActivityAnalysisCountBO;
import com.bizvane.mktcenterfacade.models.bo.ActivityBO;
import com.bizvane.mktcenterfacade.models.bo.ActivityEvaluationBO;
import com.bizvane.mktcenterfacade.models.bo.CtivityAnalysisBO;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.mktcenterfacade.models.vo.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

/**
 * Created by pc on 2018/9/6.
 */
public interface ActivityEvaluationService {
    /**
     * 查询评价奖励活动列表
     * @param vo
     * @return
     */
    public ResponseData<ActivityVO> getActivityEvaluationList(ActivityVO vo, PageForm pageForm, SysAccountPO stageUser);

    /**
     * 新增评价奖励活动
     * @param bo
     * @return
     */
    public ResponseData<Integer> addActivityEvaluation(ActivityBO bo, SysAccountPO stageUser);



    /**
     * 查询活动详情
     * @param
     * @return
     */
    public ResponseData<ActivityBO> selectActivityEvaluationById(String businessCode);


    /**
     * 执行评价活动
     * @param
     * @return
     */
    public ResponseData<Integer> executeActivityEvaluation(ActivityEvaluationBO bo);

    /**
     * 查询效果分析统计
     * @param bo
     * @return
     */
    public ResponseData<CtivityAnalysisBO> getActivityAnalysisCountpage(ActivityAnalysisCountBO bo, PageForm pageForm);

}
