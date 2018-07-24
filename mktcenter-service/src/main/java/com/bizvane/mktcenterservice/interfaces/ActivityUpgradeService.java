package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.utils.commonutils.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/13 18:44
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public interface ActivityUpgradeService {

    /**
     * 查询升级活动列表
     * @param vo
     * @return
     */
    public ResponseData<ActivityVO> getActivityUpgradeList(ActivityVO vo, PageForm pageForm);
    /**
     * 新增会员升级活动
     * @param bo
     * @return
     */
    public ResponseData<Integer> addActivityUpgrade(ActivityBO bo, SysAccountPO stageUser);
    /**
     * 修改活动
     * @return
     */
    public ResponseData<Integer> updateActivityUpgrade(ActivityBO bo,SysAccountPO stageUser);

    /**
     * 查询活动详情
     * @param mktActivityId
     * @return
     */
    public ResponseData<List<ActivityVO>> selectActivityUpgradesById(Long mktActivityId);

    /**
     * 执行活动
     * @param vo
     * @return
     */
    public ResponseData<Integer> executeUpgrades(ActivityVO vo);
}
