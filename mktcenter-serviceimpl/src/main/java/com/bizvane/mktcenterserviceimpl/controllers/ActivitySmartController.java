package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.mktcenterservice.interfaces.ActivitySmartService;
import com.bizvane.mktcenterservice.models.bo.ActivitySmartBO;
import com.bizvane.mktcenterservice.models.po.MktActivitySmartGroupPO;
import com.bizvane.mktcenterservice.models.po.MktActivitySmartPO;
import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.vo.ActivitySmartVO;
import com.bizvane.mktcenterservice.models.vo.MessageVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterservice.models.vo.PictureMessageVO;
import com.bizvane.mktcenterserviceimpl.common.utils.ActivityParamCheckUtil;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/13 13:37
 * @description 智能营销
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Api(description = "智能营销")
@RestController
@RequestMapping("activitySmart")
public class ActivitySmartController {

    @Autowired
    private ActivitySmartService activitySmartService;

    /**
     * 查询智能营销活动分组列表(方块)
     * @return
     */
    @ApiOperation(value = "查询智能营销活动分组列表(方块)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberGroupName", dataType = "String", value = "智能营销会员分组名称", paramType = "query", required = true),
    })
    @PostMapping("getSmartActivityGroupList")
    public ResponseData<PageInfo<MktActivitySmartGroupPO>> getSmartActivityGroupList(ActivitySmartVO vo, PageForm pageForm,HttpServletRequest request){
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        return activitySmartService.getSmartActivityGroupList(vo,pageForm,stageUser);
    }

    /**
     * 查询历史营销活动列表
     * @return
     */
    @ApiOperation(value = "查询历史营销活动列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberGroupName", dataType = "String", value = "智能营销会员分组名称", paramType = "query", required = true),
    })
    @PostMapping("getActivityHistoryList")
    public ResponseData<PageInfo<MktActivitySmartPO>> getActivityHistoryList(ActivitySmartVO vo, PageForm pageForm){
        return activitySmartService.getActivityHistoryList(vo, pageForm);
    }

    /**
     *
     * @param mktActivitySmartGroupId
     * @return
     */
    @ApiOperation(value = "通过id获取智能营销分组")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mktActivitySmartGroupId", dataType = "Long", value = "智能营销会员分组id", paramType = "query", required = true),
    })
    @PostMapping("getSmartActivityGroupById")
    public ResponseData<MktActivitySmartGroupPO> getSmartActivityGroupById(Long mktActivitySmartGroupId,HttpServletRequest request){
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        return activitySmartService.getSmartActivityGroupById(mktActivitySmartGroupId,stageUser);
    }

    /**
     * 查询某个智能营销详情
     * @param mktActivityId
     * @return
     */
    @ApiOperation(value = "查询某个智能营销详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mktActivityId", dataType = "Long", value = "智能营销活动id", paramType = "query", required = true),
            @ApiImplicitParam(name = "mktSmartType", dataType = "Integer", value = "智能营销方式", paramType = "query", required = true),
    })
    @PostMapping("getActivityDetailById")
    public ResponseData<ActivitySmartVO> getActivityDetailById(Long mktActivityId,Integer mktSmartType){
        return activitySmartService.getActivityDetailById(mktActivityId,mktSmartType);
    }

    /**
     * 对某个智能营销组创建任务
     * 任务类型：1优惠券营销
     * @return
     */
    @ApiOperation(value = "对某个智能营销组创建任务，任务类型：1优惠券营销")
    @PostMapping("addCouponActivity")
    public ResponseData<Integer> addCouponActivity(ActivitySmartVO vo, HttpServletRequest request){
        //获取操作人信息
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        ResponseData<Integer> responseData = activitySmartService.addCouponActivity(vo, stageUser);
        return responseData;
    }

    /**
     * 对某个智能营销组创建任务
     * 任务类型：2积分营销
     * @return
     */
    @ApiOperation(value = "对某个智能营销组创建任务，任务类型：2积分营销")
    @PostMapping("addIntegralActivity")
    public ResponseData<Integer> addIntegralActivity(ActivitySmartVO vo, HttpServletRequest request){
        //参数校验
         ActivityParamCheckUtil.checkSmartActivityParam(vo);
        //参数校验通过，获取操作人信息
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        ResponseData<Integer> responseData = activitySmartService.addIntegralActivity(vo,stageUser);
        return new ResponseData<>();
    }

    /**
     * 对某个智能营销组创建任务
     * 任务类型：3短信营销
     * @return
     */
    @ApiOperation(value = "对某个智能营销组创建任务，任务类型：3短信营销")
    @PostMapping("addSmsActivity")
    public ResponseData<Integer> addSmsActivity(ActivitySmartVO vo, MessageVO messageVO,HttpServletRequest request){
        //参数校验
        ActivityParamCheckUtil.checkSmartActivityParam(vo);
        //参数校验通过，获取操作人信息
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        ResponseData<Integer> responseData = activitySmartService.addSmsActivity(vo,messageVO,stageUser);
        return new ResponseData<>();
    }

    /**
     * 对某个智能营销组创建任务
     * 任务类型：4微信模板消息
     * @return
     */
    @ApiOperation(value = "对某个智能营销组创建任务，任务类型：4微信模板消息")
    @PostMapping("addWxMessageActivity")
    public ResponseData<Integer> addWxMessageActivity(ActivitySmartVO vo, MessageVO messageVO,HttpServletRequest request){
        //参数校验
        ActivityParamCheckUtil.checkSmartActivityParam(vo);
        //参数校验通过，获取操作人信息
       SysAccountPO stageUser = TokenUtils.getStageUser(request);
        ResponseData<Integer> responseData = activitySmartService.addWxMessageActivity(vo,messageVO,stageUser);
        return new ResponseData<>();
    }

    @ApiOperation(value = "对某个智能营销组创建任务，任务类型：5图文消息")
    @PostMapping("addPictureMessageActivity")
    public ResponseData<Integer> addPictureMessageActivity(ActivitySmartVO vo, MessageVO messageVO,HttpServletRequest request){
        //参数校验
       // ActivityParamCheckUtil.checkSmartActivityParam(vo);
        //参数校验通过，获取操作人信息
        //SysAccountPO stageUser = TokenUtils.getStageUser(request);
        SysAccountPO stageUser=new SysAccountPO();
        stageUser.setBrandId(96L);
        stageUser.setName("测试测试");
        stageUser.setSysAccountId(12867L);
        stageUser.setSysCompanyId(3841L);
        ResponseData<Integer> responseData = activitySmartService.addPictureMessageActivity(vo,messageVO,stageUser);
        return new ResponseData<>();
    }

    /**
     * 图文消息剩余次数
     * @param vo
     * @return
     */
    @PostMapping("getPictureMessageCount")
    public  ResponseData<Integer>  getPictureMessageCount(ActivitySmartVO vo){
        return activitySmartService.getPictureMessageCount(vo);
    }
    @PostMapping("getPictureLists")
    public  ResponseData  getPictureLists(PictureMessageVO vo){
        return  activitySmartService.getPictureLists(vo);
    }
}
