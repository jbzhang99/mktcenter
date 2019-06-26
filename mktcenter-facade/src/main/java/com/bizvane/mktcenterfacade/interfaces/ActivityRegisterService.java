package com.bizvane.mktcenterfacade.interfaces;

import com.bizvane.mktcenterfacade.models.vo.PageForm;
import com.bizvane.mktcenterfacade.models.bo.ActivityBO;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.mktcenterfacade.models.vo.MemberInfoModelVOActivity;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

/**
 * @author chen.li
 * @date on 2018/7/13 14:47
 * @description
 *
 */
public interface ActivityRegisterService {

    /**
     * 查询开卡活动列表
     * @param vo
     * @return
     */
    public ResponseData<ActivityVO> getActivityList(ActivityVO vo, PageForm pageForm, SysAccountPO stageUser);

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
    public ResponseData<Integer> executeRegisterActivity(MemberInfoModelVOActivity vo);

    /**
     * 修改活动
     * @return
     */
    public ResponseData<Integer> updateActivityRegister(ActivityBO bo,SysAccountPO stageUser);

    /**
     * 查询活动详情
     * @param
     * @return
     */
    public ResponseData<ActivityBO> selectActivityRegisterById(String businessCode);
}
