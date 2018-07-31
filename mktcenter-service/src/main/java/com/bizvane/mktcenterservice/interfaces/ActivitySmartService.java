package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.po.MktActivitySmartPO;
import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.vo.ActivitySmartVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/13 18:44
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public interface ActivitySmartService {

    /**
     * 查询智能营销分组列表
     * @param vo
     * @return
     */
    public ResponseData<PageInfo<MktActivitySmartPO>> getSmartActivityList(ActivitySmartVO vo, PageForm pageForm);

    /**
     * 查询历史营销活动列表
     * @param vo
     * @param pageForm
     * @return
     */
    public ResponseData<PageInfo<MktActivitySmartPO>> getActivityHistoryList(ActivitySmartVO vo, PageForm pageForm);

    public ResponseData<Integer> addCouponActivity(ActivitySmartVO vo, List<MktCouponPO> couponCodeList, SysAccountPO stageUser);

    /**
     * 查询某个智能营销分组
     * @param mktActivitySmartId
     * @return
     */
    public ResponseData<MktActivitySmartPO> getSmartActivityById(Long mktActivitySmartId);

    /**
     * 添加智能营销分组
     * @param vo
     * @return
     */
    public ResponseData<Integer> addSmartActivity(ActivitySmartVO vo);

    /**
     * 修改智能营销分组
     * @param vo
     * @return
     */
    public ResponseData<Integer> updateSmartActivity(ActivitySmartVO vo);
}
