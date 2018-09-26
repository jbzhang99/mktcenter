package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.members.facade.service.api.WxAppletApiService;
import com.bizvane.mktcenterservice.interfaces.TaskServiceForWX;
import com.bizvane.mktcenterservice.models.bo.TaskWXBO;
import com.bizvane.mktcenterservice.models.bo.TaskWXDetailBO;
import com.bizvane.mktcenterservice.models.vo.TaskForWXVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.mktcenterserviceimpl.common.enums.TaskTypeEnum;
import com.bizvane.mktcenterserviceimpl.mappers.MktTaskPOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Geng on 2018/8/9.
 */
@Service
@Slf4j
public class TaskServiceForWXImpl implements TaskServiceForWX {

    @Autowired
    private MktTaskPOMapper taskPOMapper;
    @Autowired
    private  WxAppletApiService wxAppletApiService;

    @Override
    //获取该会员已完成和未完成任务的任务
    public ResponseData getCompleteTask(TaskForWXVO vo) {
        ResponseData<PageInfo<TaskWXBO>> responseData = new ResponseData(new PageInfo<TaskWXBO>(new ArrayList<TaskWXBO>()));
        ResponseData<Long> resultData = wxAppletApiService.getServiceStoreId(vo.getMemberCode());
        Long storeId = resultData.getData();
        vo.setStoreIdStyleOne(new StringBuilder().append(storeId).append(",%").toString());
        vo.setStoreIdStyleTwo(new StringBuilder().append("%,").append(storeId).append(",%").toString());
        vo.setStoreIdStyleThree(new StringBuilder().append("%,").append(storeId).toString());
        log.info("----获取已完成和未完成任务列表----getCompleteTask---参数-------"+JSON.toJSONString(vo));

        try{
            PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
            List<TaskWXBO> lists = taskPOMapper.getCompleteTask(vo);
            if (CollectionUtils.isNotEmpty(lists)) {
                PageInfo<TaskWXBO> taskWXBOPageInfo = new PageInfo<>(lists);
                responseData.setData(taskWXBOPageInfo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return responseData;
        }
    }

    //获取任务的详情
    @Override
    public ResponseData<TaskWXDetailBO> getTaskWXDetail(Long taskId) {
        log.info("---------------获取任务的详情----------------" + taskId);
        ResponseData<TaskWXDetailBO> responseData = new ResponseData();
        List<TaskWXDetailBO> lists = taskPOMapper.getTaskWXDetail(taskId);
        log.info("---------------获取任务的详情----------------" + JSON.toJSONString(lists));
        if (CollectionUtils.isNotEmpty(lists)) {
            responseData.setData(lists.get(0));
        }else{
            responseData.setData(new  TaskWXDetailBO());
        }
        return responseData;
    }
}
