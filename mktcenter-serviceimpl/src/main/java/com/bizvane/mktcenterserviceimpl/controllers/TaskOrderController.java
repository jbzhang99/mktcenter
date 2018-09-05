package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.mktcenterservice.interfaces.TaskOrderService;
import com.bizvane.mktcenterservice.models.bo.AddTaskBO;
import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.bo.TaskDetailBO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterservice.models.vo.TaskDetailVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
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
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 * 消费次数任务
 */
@RestController
@RequestMapping("taskOrder")
public class TaskOrderController {

    @Autowired
    private TaskOrderService taskOrderService;


    /**
     * 创建任务-已经核对
     * @return
     */
    @RequestMapping("addTask")
    public ResponseData<Integer> addTask(TaskBO bo, HttpServletRequest request) throws ParseException {
        //参数校验通过，获取操作人信息
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
//        SysAccountPO sysAccountPo = new SysAccountPO();
//        sysAccountPo.setSysAccountId(26L);
//        sysAccountPo.setSysCompanyId(2L);
//        sysAccountPo.setBrandId(4L);
//        sysAccountPo.setAccountCode("15328634678");
//        sysAccountPo.setName("不啊哟删除");

       // bo.getTaskVO().setSysBrandId(sysAccountPo.getBrandId());
        bo.getTaskVO().setTaskType(4);
        return  taskOrderService.addTask(bo, sysAccountPo);
    }
    /**
     * 修改任务
     */
    public ResponseData updateOrderTask(TaskBO bo, HttpServletRequest request){
        SysAccountPO stageUser = TokenUtils.getStageUser(request);

        return  taskOrderService.updateOrderTask(bo, stageUser);
    }
}
