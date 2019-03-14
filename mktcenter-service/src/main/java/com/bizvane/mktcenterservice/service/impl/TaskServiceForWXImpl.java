package com.bizvane.mktcenterservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.centercontrolservice.models.bo.AppletFunctionBO;
import com.bizvane.centercontrolservice.rpc.AppletRouteServiceRpc;
import com.bizvane.members.facade.service.api.WxAppletApiService;
import com.bizvane.mktcenterfacade.interfaces.TaskServiceForWX;
import com.bizvane.mktcenterfacade.models.bo.TaskWXBO;
import com.bizvane.mktcenterfacade.models.bo.TaskWXDetailBO;
import com.bizvane.mktcenterfacade.models.po.MktTaskSharePOExample;
import com.bizvane.mktcenterfacade.models.po.MktTaskSharePOWithBLOBs;
import com.bizvane.mktcenterfacade.models.vo.TaskForWXVO;
import com.bizvane.mktcenterservice.common.constants.TaskConstants;
import com.bizvane.mktcenterservice.mappers.MktTaskPOMapper;
import com.bizvane.mktcenterservice.mappers.MktTaskSharePOMapper;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private MktTaskSharePOMapper mktTaskSharePOMapper;
    @Autowired
    private AppletRouteServiceRpc appletRouteServiceRpc;

    @Override
    //获取该会员已完成和未完成任务的任务
    public ResponseData<PageInfo<TaskWXBO>> getCompleteTask(TaskForWXVO vo) {
        log.info("获取会员的任务列表getCompleteTask--入参--"+JSON.toJSONString(vo));

        ResponseData<PageInfo<TaskWXBO>> responseData = new ResponseData(new PageInfo<TaskWXBO>(new ArrayList<TaskWXBO>()));
        ResponseData<Long> resultData = wxAppletApiService.getServiceStoreId(vo.getMemberCode());
        log.info("获取会员的任务列表storeId--出参--"+JSON.toJSONString(resultData));
        Long storeId = resultData.getData();
        vo.setStoreId(storeId);
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
            log.info("获取会员的任务列表最终数据--出参--"+JSON.toJSONString(responseData));
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
    /**
     * 获取链接详情
     */
    @Override
    public ResponseData<AppletFunctionBO>  getURLDetail(TaskForWXVO vo){
        log.info("获取链接详情getURLDetail--入参--"+JSON.toJSONString(vo));

        ResponseData<AppletFunctionBO> responseData = new ResponseData<>();
        AppletFunctionBO urlBO = new AppletFunctionBO();
        MktTaskSharePOExample mktTaskSharePOExample = new MktTaskSharePOExample();
        mktTaskSharePOExample.createCriteria().andMktTaskIdEqualTo(vo.getMktTaskId()).andValidEqualTo(Boolean.TRUE);
        List<MktTaskSharePOWithBLOBs> sharePOlist = mktTaskSharePOMapper.selectByExampleWithBLOBs(mktTaskSharePOExample);
        if (CollectionUtils.isNotEmpty(sharePOlist)){
            MktTaskSharePOWithBLOBs sharePOWithBLOBs = sharePOlist.get(0);
            String shareUrl = sharePOWithBLOBs.getShareUrl();
            // 1站内链接，2自定义链接',
            Integer shareUrlType = sharePOWithBLOBs.getShareUrlType();
            if (TaskConstants.FIRST.equals(shareUrlType)) {
                urlBO = appletRouteServiceRpc.getAllAppletFunctionByUrl(shareUrl).getData();
                urlBO.setType(1);
            }else {
                urlBO.setFunctionUrl(shareUrl);
                urlBO.setFunctionName("站外链接");
                urlBO.setType(2);
            }
        }
        log.info("获取链接详情getURLDetail--出参--"+JSON.toJSONString(urlBO));
        responseData.setData(urlBO);
        return responseData;
    }
}
