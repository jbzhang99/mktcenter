package com.bizvane.mktcenterservice.controllers;

import com.bizvane.mktcenterfacade.interfaces.ActivityInviteService;
import com.bizvane.mktcenterfacade.models.bo.ActivityBO;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.mktcenterfacade.models.vo.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/13 13:38
 * @description
 *
 * 消费金额任务
 */
@RestController
@RequestMapping("/activityInvite")
public class ActivityInviteController {

    @Autowired
    private ActivityInviteService activityInviteService;

    @Autowired
    private HttpServletRequest request;
    /**
     * 查询活动列表
     * @return
     */
    @RequestMapping("list")
    public ResponseData<List<ActivityVO>> list(ActivityVO vo, PageForm pageForm){
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        return activityInviteService.list(vo, pageForm,stageUser);
    }

    /**
     * 创建任务
     * @return
     */
    @RequestMapping("/add")
    public ResponseData<Integer> add(ActivityBO bo) throws ParseException {
        //参数校验通过，获取操作人信息
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        return  activityInviteService.add(bo, sysAccountPo);
    }
    /**
     * 修改任务
     */
    @RequestMapping("/update")
    public ResponseData update(ActivityBO bo) throws ParseException {
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        return  activityInviteService.update(bo, stageUser);
    }
}
