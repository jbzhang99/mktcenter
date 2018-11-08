package com.bizvane.mktcenterserviceimpl.controllers.rpc;

import com.bizvane.mktcenterservice.interfaces.ActivityService;
import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.vo.WhiteStoreVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/11/5 13:46
 */
@RestController
@RequestMapping("taskRpc")
@Slf4j
public class TaskRpcController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private ActivityService activityService;
    /**
     * 查询白名单店铺Id集合
     */
    @RequestMapping("getWhiteStoreIds")
    public List<Long> getWhiteStoreIds(@RequestBody WhiteStoreVO vo){
        List<Long> lists = null;
        if (null!=vo.getTaskType()){
            lists = taskService.getWhiteStoreIds(vo);
        }else if (null!=vo.getActivityType()){
            lists = activityService.getActivityWhiteStoreIds(vo);
        }else {
            log.info("getWhiteStoreIds获取店铺白名单参数活动或者任务类型为空不合格!");
        }
        return lists;
    }
}
