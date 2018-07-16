package com.bizvane.mktcenterserviceimpl.controllers;
import com.bizvane.mktcenterservice.interfaces.ActivityUpgradeService;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.vo.ActivityUpgradeVO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.MessageVO;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.utils.ActivityParamCheckUtil;
import com.bizvane.utils.commonutils.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/13 13:37
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@RestController
@RequestMapping("activityUpgrade")
public class ActivityUpgradeController {

    @Autowired
    private ActivityUpgradeService activityUpgradeService;

    /**
     * 查询活动列表
     * @return
     */
    @RequestMapping("getActivityUpgradeList")
    public ResponseData<ActivityVO> getActivityUpgradeList(ActivityVO vo, PageForm pageForm){
        ResponseData<ActivityVO> activityUpgradeList = activityUpgradeService.getActivityUpgradeList(vo, pageForm);
        return activityUpgradeList;
    }
    /**
     * 创建活动
     * @return
     */
    @RequestMapping("addActivityUpgrade.do")
    public ResponseData<Integer> addActivityUpgrade(ActivityVO activityVO, List<String> couponCodeList, List<MessageVO> messageVOList, HttpServletRequest request){
        ActivityBO bo = new ActivityBO();
        bo.setActivityVO(activityVO);
        bo.setCouponCodeList(couponCodeList);
        bo.setMessageVOList(messageVOList);
        //参数校验
        ResponseData responseData = ActivityParamCheckUtil.checkParam(bo);
        //参数校验不通过
        if(SystemConstants.ERROR_CODE==responseData.getCode()){
            return responseData;
        }
        //参数校验通过，获取操作人信息
//        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        SysAccountPO stageUser = new SysAccountPO();

        //新增活动
        ResponseData<Integer> integerResponseData = activityUpgradeService.addActivityUpgrade(bo, stageUser);

        //返回
        return integerResponseData;
    }
}
