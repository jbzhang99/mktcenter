package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.models.bo.ActivityAnalysisCountBO;
import com.bizvane.mktcenterservice.models.bo.CtivityAnalysisBO;
import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/6 19:49
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public interface ActivityService {

    /**
     * 禁用/停止活动
     * @param vo
     * @return
     */
    public ResponseData<Integer> updateActivityById(ActivityVO vo, SysAccountPO sysAccountPO);

    /**
     * 活动审核
     * @param
     * @return
     */
    public ResponseData<Integer> checkActivityById(SysCheckPo po, SysAccountPO sysAccountPO);

    /**
     * 小程序端活动列表
     * @param vo
     * @return
     */
    public ResponseData<List<ActivityVO>>  getActivityList(ActivityVO vo);

    /**
     * 查询效果分析统计
     * @param bo
     * @return
     */
    public ResponseData<CtivityAnalysisBO> getActivityAnalysisCountpage(ActivityAnalysisCountBO bo, PageForm pageForm);

    public void sendMessage(List<MktMessagePO> messageVOList, MemberInfoModel memberInfo);
}
