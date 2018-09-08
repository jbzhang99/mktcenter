package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

import java.util.List;

/**
 * Created by pc on 2018/9/7.
 */
public interface ActivityVipAniversaryService {


    /**
     * 查询纪念日活动列表
     * @param vo
     * @return
     */
    public ResponseData<ActivityVO> getActivityVipAniversaryList(ActivityVO vo, PageForm pageForm);

    /**
     * 新增纪念日活动
     * @param bo
     * @return
     */
    public ResponseData<Integer> addActivityVipAniversary(ActivityBO bo, SysAccountPO stageUser);

    /**
     * 查询活动详情
     * @param
     * @return
     */
    public ResponseData<ActivityBO> selectActivityVipAniversaryById(String businessCode);

    /**
     * 活动审核
     * @param
     * @return
     */
    public ResponseData<Integer> checkActivityVipAniversary(SysCheckPo po, SysAccountPO sysAccountPO);


    /**
     * 修改活动
     * @return
     */
    public ResponseData<Integer> updateActivityAniversary(ActivityBO bo, SysAccountPO stageUser);


    /**
     * 纪念日活动定时发送奖励
     * @param activityBirthday
     * @param memberInfoModelList
     */
    public void AniversaryReward(ActivityVO activityBirthday, List<MemberInfoModel> memberInfoModelList);
}
