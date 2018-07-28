package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.bo.OrderModelBo;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/13 18:42
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public interface ActivityOrderService {
    /**
     * 查询消费活动列表
     * @param vo
     * @return
     */
    public ResponseData<ActivityVO> getActivityOrderList(ActivityVO vo, PageForm pageForm);
    /**
     * 新增会员消费活动
     * @param bo
     * @return
     */
    public ResponseData<Integer> addActivityOrder(ActivityBO bo, SysAccountPO stageUser);
    /**
     * 查询活动详情
     * @param mktActivityId
     * @return
     */
    public ResponseData<List<ActivityVO>> selectActivityOrderById(Long mktActivityId);
    /**
     * 修改活动
     * @return
     */
    public ResponseData<Integer> updateActivityOrder(ActivityBO bo,SysAccountPO stageUser);
    /**
     * 活动审核
     * @param
     * @return
     */
    public ResponseData<Integer> checkActivityOrder(MktActivityPOWithBLOBs bs, SysAccountPO sysAccountPO);
    /**
     * 执行活动
     * @param
     * @return
     */
    public ResponseData<Integer> executeOrder(OrderModelBo vo);
}
