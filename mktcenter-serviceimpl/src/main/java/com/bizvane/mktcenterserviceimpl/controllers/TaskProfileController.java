package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.members.facade.models.ExtendPropertyModel;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.ExtendPropertyApiService;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.service.api.MemberLevelApiService;
import com.bizvane.mktcenterservice.interfaces.TaskProfileService;
import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.mktcenterservice.models.vo.MessageVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.utils.TaskParamCheckUtil;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author gengxiaoyu
 * @date on 2018/7/13 13:39
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@RestController
@RequestMapping("taskProfile")
public class TaskProfileController {

    @Autowired
    private TaskProfileService taskProfileService;

    @Autowired
    private MemberLevelApiService memberLevelApiService;

    @Autowired
    private MemberInfoApiService memberInfoApiService;

    @Autowired
    private ExtendPropertyApiService extendPropertyApiService;



    /**
     * 创建任务
     * @return
     */
    @RequestMapping("addTask")
    public ResponseData<Integer> addTask(TaskVO vo, List<MktCouponPO> couponCodeList, List<MktMessagePO> messagePOList, HttpServletRequest request){
        TaskBO bo = new TaskBO();
        bo.setTaskVO(vo);
        bo.setMktCouponPOList(couponCodeList);
        bo.setMessagePOList(messagePOList);

        //获取操作人信息
        //SysAccountPO stageUser = TokenUtils.getStageUser(request);
        SysAccountPO stageUser = new SysAccountPO();


        //新增任务
        ResponseData<Integer> integerResponseData = taskProfileService.addTask(bo, stageUser);

        //返回
        return integerResponseData;
    }

    /**
     * 修改任务
     * @param vo
     * @param couponCodeList
     * @param messagePOList
     * @param request
     * @return
     */
    @RequestMapping("updateTask")
    public ResponseData<Integer> updateTask(TaskVO vo, List<MktCouponPO> couponCodeList, List<MktMessagePO> messagePOList, HttpServletRequest request){
        TaskBO bo = new TaskBO();
        bo.setTaskVO(vo);
        bo.setMktCouponPOList(couponCodeList);
        bo.setMessagePOList(messagePOList);
        //参数校验
        ResponseData responseData = TaskParamCheckUtil.checkParam(bo);
        //参数校验不通过
        if(SystemConstants.ERROR_CODE==responseData.getCode()){
            return responseData;
        }
        //参数校验通过，获取操作人信息
        SysAccountPO stageUser = new SysAccountPO();
        //更新活动
        ResponseData<Integer> registerData = taskProfileService.updateTask(bo,stageUser);

        //返回

        return registerData;
    }

    /**
     * 执行任务
     * @param
     * @return
     */
    @RequestMapping("executeTask")
    public ResponseData<Integer> executeTask(TaskVO vo,MemberInfoModel memberInfoModel){

        return taskProfileService.executeTask(vo,memberInfoModel);
    }

    /**
     * 查询任务详情
     * @param businessId
     * @return
     */
    @RequestMapping("selectTaskById")
    public ResponseData<TaskBO> selectTaskById(Long businessId){
        return taskProfileService.selectTaskById(businessId);
    }


    /**
     * 查询商家自定义扩展信息
     * @param
     * @return
     */
    //前端传回的是品牌id还是ExtendPropertyModel？？？？
    @RequestMapping("getExtendProperty")
    public ResponseData getExtendProperty(Long brandid){

        ExtendPropertyModel extendPropertyModel = new ExtendPropertyModel();
        extendPropertyModel.setBrandId(brandid);
        return extendPropertyApiService.getExtendProperty(extendPropertyModel);

    }

}

