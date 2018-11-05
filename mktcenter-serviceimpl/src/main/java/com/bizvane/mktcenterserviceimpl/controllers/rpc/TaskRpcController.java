package com.bizvane.mktcenterserviceimpl.controllers.rpc;

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
    /**
     * 查询白名单店铺Id集合
     */
    @RequestMapping("getWhiteStoreIds")
    public List<Long> getWhiteStoreIds(@RequestBody WhiteStoreVO vo){
        if (vo.getSysbrandId()==null || vo.getTaskType()==null|| vo.getStartTime()==null || vo.getEndTime()==null){
            log.info("getWhiteStoreIds获取店铺白名单参数不合格!");
            return new ArrayList<Long>();
        }
        return taskService.getWhiteStoreIds(vo);
    }
}
