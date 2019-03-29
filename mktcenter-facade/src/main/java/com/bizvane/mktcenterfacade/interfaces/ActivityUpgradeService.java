package com.bizvane.mktcenterfacade.interfaces;

import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterfacade.models.bo.ActivityBO;
import com.bizvane.mktcenterfacade.models.vo.PageForm;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

/**
 * @author chen.li
 * @date on 2018/7/13 18:44
 * @description
 *
 */
public interface ActivityUpgradeService {

    /**
     * 查询升级活动列表
     * @param vo
     * @return
     */
    public ResponseData<ActivityVO> getActivityUpgradeList(ActivityVO vo, PageForm pageForm, SysAccountPO stageUser);
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
     * @param 
     * @return
     */
    public ResponseData<ActivityBO> selectActivityUpgradesById(String businessCode);

    /**
     * 执行活动
     * @param vo
     * @return
     */
    public ResponseData<Integer> executeUpgrades(MemberInfoModel vo);
    /**
     * 活动审核
     * @param
     * @return
     */
    public ResponseData<Integer> checkActivityUpgrades(SysCheckPo po, SysAccountPO sysAccountPO);
}
