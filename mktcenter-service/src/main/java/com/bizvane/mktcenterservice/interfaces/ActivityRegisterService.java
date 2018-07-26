package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.members.facade.models.IntegralRecordModel;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.utils.commonutils.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/13 14:47
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public interface ActivityRegisterService {

    /**
     * 查询开卡活动列表
     * @param vo
     * @return
     */
    public ResponseData<ActivityVO> getActivityList(ActivityVO vo,PageForm pageForm);

    /**
     * 新增开卡活动
     * @param bo
     * @return
     */
    public ResponseData<Integer> addActivity(ActivityBO bo,SysAccountPO stageUser);

    /**
     * 执行活动
     * @param
     * @return
     */
    public ResponseData<Integer> executeActivity(MemberInfoModel vo);

    /**
     * 修改活动
     * @return
     */
    public ResponseData<Integer> updateActivityRegister(ActivityBO bo,SysAccountPO stageUser);

    /**
     * 查询活动详情
     * @param mktActivityId
     * @return
     */
    public ResponseData<List<ActivityVO>> selectActivityRegisterById(Long mktActivityId);
}
