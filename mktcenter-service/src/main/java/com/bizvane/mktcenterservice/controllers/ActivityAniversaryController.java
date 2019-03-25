package com.bizvane.mktcenterservice.controllers;

import com.bizvane.mktcenterfacade.interfaces.ActivityVipAniversaryService;
import com.bizvane.mktcenterfacade.models.bo.ActivityBO;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.mktcenterfacade.models.vo.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by pc on 2018/9/8.
 */
@RestController
@RequestMapping("activityAniversary")
public class ActivityAniversaryController {

    @Autowired
    private ActivityVipAniversaryService activityVipAniversaryService;
    /**
     * 查询评价奖励活动列表
     * @param vo
     * @return
     */ 
    @RequestMapping("getActivityAniversaryList")
    public ResponseData<ActivityVO> getActivityAniversary(ActivityVO vo, PageForm pageForm,HttpServletRequest request){
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        ResponseData<ActivityVO> activityAniversaryList=activityVipAniversaryService.getActivityVipAniversaryList(vo,pageForm,stageUser);
        return  activityAniversaryList;
    }

    /**
     * 创建活动
     * @return
     */
    @RequestMapping("addActivityAniversary")
    public ResponseData<Integer> addActivityAniversary(ActivityBO bo , HttpServletRequest request) {
        //参数校验
      /*  ResponseData responseData = ActivityParamCheckUtil.checkParam(bo);
        //参数校验不通过
        if (SystemConstants.ERROR_CODE == responseData.getCode()) {
            return responseData;
        }*/
        //参数校验通过，获取操作人信息
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        System.out.println("=============="+stageUser);
        //SysAccountPO stageUser = new SysAccountPO();

        //新增活动
        ResponseData<Integer> integerResponseData = activityVipAniversaryService.addActivityVipAniversary(bo, stageUser);

        //返回
        return integerResponseData;
    }

    /**
     * 查询活动详情
     * @param businessCode
     * @return
     */
    @RequestMapping("selectActivityAniversaryById")
    public ResponseData<ActivityBO> selectActivityAniversaryById(String businessCode){
        return activityVipAniversaryService.selectActivityVipAniversaryById(businessCode);
    }


}
