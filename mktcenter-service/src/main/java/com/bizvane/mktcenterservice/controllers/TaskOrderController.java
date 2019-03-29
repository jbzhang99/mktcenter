package com.bizvane.mktcenterservice.controllers;

import com.bizvane.mktcenterfacade.interfaces.TaskOrderService;
import com.bizvane.mktcenterfacade.models.bo.TaskBO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * @author chen.li
 * @date on 2018/7/13 13:38
 * @description
 *
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
