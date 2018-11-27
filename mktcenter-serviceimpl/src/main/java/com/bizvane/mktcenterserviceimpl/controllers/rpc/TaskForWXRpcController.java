package com.bizvane.mktcenterserviceimpl.controllers.rpc;

import com.bizvane.centercontrolservice.models.bo.AppletFunctionBO;
import com.bizvane.mktcenterservice.interfaces.ConvertCouponService;
import com.bizvane.mktcenterservice.interfaces.TaskServiceForWX;
import com.bizvane.mktcenterservice.models.bo.TaskWXBO;
import com.bizvane.mktcenterservice.models.bo.TaskWXDetailBO;
import com.bizvane.mktcenterservice.models.po.MktConvertCouponRecordPO;
import com.bizvane.mktcenterservice.models.vo.CouponRecordVO;
import com.bizvane.mktcenterservice.models.vo.TaskForWXVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Geng on 2018/8/9.
 */

@RestController
@RequestMapping("taskForWXRpc")
public class TaskForWXRpcController {

    @Autowired
    private TaskServiceForWX taskServiceForWX;
    @Autowired
    private  ConvertCouponService convertCouponService;

    @RequestMapping("/getCompleteTask")
    @io.swagger.annotations.ApiModelProperty(value = "brandId,memberCode",name = "该会员已完成的任务列表", required = false,example = "")
    public ResponseData<PageInfo<TaskWXBO>> getCompleteTask(@RequestBody TaskForWXVO vo){

        return taskServiceForWX.getCompleteTask(vo);
    }

    @RequestMapping("/getTaskWXDetail")
    @io.swagger.annotations.ApiModelProperty(value = "brandId,memberCode",name = "该会员已完成的任务列表", required = false,example = "")
    public  ResponseData<TaskWXDetailBO>  getTaskWXDetail(@RequestParam Long taskId){
        System.out.println("---------TaskForWXRpcController------获取任务的详情----------------"+taskId);
        return taskServiceForWX.getTaskWXDetail(taskId);
    }

    @RequestMapping("/getURLDetail")
    @io.swagger.annotations.ApiModelProperty(value = "TaskForWXVO",name = "获取url链接详情", required = false,example = "")
    public ResponseData<AppletFunctionBO>  getURLDetail(@RequestBody TaskForWXVO vo){
      return taskServiceForWX.getURLDetail(vo);
    }
    //积分兑换券
    //查询对换列表
    @RequestMapping("/getConvernCouponLists")
    public ResponseData<PageInfo<MktConvertCouponRecordPO>> getConvernCouponLists(@RequestBody CouponRecordVO vo){
        return convertCouponService.getCouponRecordLists(vo);
    }
    //兑换
    @RequestMapping("/doConvernCoupon")
    public ResponseData<Integer> doConvernCoupon(@RequestBody CouponRecordVO vo){
        return convertCouponService.doConvernCoupon(vo);
    }
    //查询已兑换
    @RequestMapping("/getConvernConpouByMember")
    public ResponseData<PageInfo<MktConvertCouponRecordPO>> getConvernConpouByMember(@RequestBody CouponRecordVO vo){
        return convertCouponService.getConvernConpouByMember(vo);
    }
}
