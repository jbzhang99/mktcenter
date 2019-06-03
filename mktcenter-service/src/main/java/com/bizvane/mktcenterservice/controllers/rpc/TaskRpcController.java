package com.bizvane.mktcenterservice.controllers.rpc;

import com.alibaba.fastjson.JSON;
import com.bizvane.mktcenterfacade.interfaces.ActivityService;
import com.bizvane.mktcenterfacade.interfaces.TaskService;
import com.bizvane.mktcenterfacade.models.vo.WhiteStoreVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        log.info("---getWhiteStoreIds---入参---"+ JSON.toJSONString(vo));
        List<Long> lists = null;
        if (null!=vo.getTaskType()){
            if (vo.getTaskType()!=1 && (vo.getEndTime()==null || vo.getStartTime()==null)){
            log.info("在查询非完善资料任务时,开始时间或结束时间为null,参数不合格!");
            return lists;
            }
            lists = taskService.getWhiteStoreIds(vo);
        }else if (null!=vo.getActivityType()){
            lists = activityService.getActivityWhiteStoreIds(vo);
        }else {
            log.info("getWhiteStoreIds获取店铺白名单参数活动或者任务类型为空不合格!");
        }
        return lists;
    }
}
