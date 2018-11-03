package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/13 18:44
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public interface ActivitySigninService {

    /**
     * 查询签到活动列表
     * @param vo
     * @return
     */
    public ResponseData<ActivityVO> getActivitySigninList(ActivityVO vo, PageForm pageForm,SysAccountPO stageUser);
    /**
     * 新增会员签到活动
     * @param bo
     * @return
     */
    public ResponseData<Integer> addActivitySignin(ActivityBO bo, SysAccountPO stageUser);
    /**
     * 查询活动详情
     * @param
     * @return
     */
    public ResponseData<ActivityBO> selectActivitySigninById(String businessCode);
    /**
     * 执行活动
     * @param
     * @return
     */
    public ResponseData<Integer> executeActivitySignin(MemberInfoModel vo);
    /**
     * 活动审核
     * @param
     * @return
     */
    public ResponseData<Integer> checkActivitySignin(SysCheckPo po, SysAccountPO sysAccountPO);
}
