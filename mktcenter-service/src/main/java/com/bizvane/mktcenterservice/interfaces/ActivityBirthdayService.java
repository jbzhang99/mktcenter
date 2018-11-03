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
 * @date on 2018/7/13 18:46
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public interface ActivityBirthdayService {

    /**
     * 查询生日活动列表
     * @param vo
     * @return
     */
    public ResponseData<ActivityVO> getActivityBirthdayList(ActivityVO vo, PageForm pageForm, SysAccountPO stageUser);
    /**
     * 新增会员升级活动
     * @param bo
     * @return
     */
    public ResponseData<Integer> addActivityBirthday(ActivityBO bo, SysAccountPO stageUser);
    /**
     * 查询活动详情
     * @param
     * @return
     */
    public ResponseData<ActivityBO> selectActivityBirthdayById(String businessCode);
    /**
     * 活动审核
     * @param
     * @return
     */
    public ResponseData<Integer> checkActivityBirthday(SysCheckPo po, SysAccountPO sysAccountPO);
    /**
     * 修改活动
     * @return
     */
    public ResponseData<Integer> updateActivityBirthday(ActivityBO bo,SysAccountPO stageUser);

    /**
     * 生日活动定时发送奖励
     * @param activityBirthday
     * @param memberInfo
     */
    public void birthdayReward(ActivityVO activityBirthday, MemberInfoModel memberInfo);
}
