package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.centerstageservice.rpc.SysCheckServiceRpc;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.models.vo.CouponFindCouponCountResponseVO;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.mktcenterservice.interfaces.ActivityService;
import com.bizvane.mktcenterservice.models.bo.ActivityAnalysisCountBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.CouponSendTypeEnum;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityRegisterPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktMessagePOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/6 19:50
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;
    @Autowired
    private SysCheckServiceRpc sysCheckServiceRpc;
    @Autowired
    private CouponQueryServiceFeign couponQueryServiceFeign;
    @Autowired
    private MemberInfoApiService memberInfoApiService;
    @Autowired
    private MktActivityRegisterPOMapper mktActivityRegisterPOMapper;
    /**
     * 禁用/启用活动
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Integer> updateActivityById(ActivityVO vo, SysAccountPO sysAccountPO) {
        ResponseData responseData = new ResponseData();
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        mktActivityPOWithBLOBs.setMktActivityId(vo.getMktActivityId());
        mktActivityPOWithBLOBs.setValid(vo.getValid());
        mktActivityPOWithBLOBs.setModifiedUserId(sysAccountPO.getSysAccountId());
        mktActivityPOWithBLOBs.setModifiedDate(new Date());
        mktActivityPOWithBLOBs.setModifiedUserName(sysAccountPO.getName());
        int i = mktActivityPOMapper.updateByPrimaryKeySelective(mktActivityPOWithBLOBs);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 活动审核
     * @param
     * @param sysAccountPO
     * @return
     */
    @Override
    public ResponseData<Integer> checkActivityById(SysCheckPo po, SysAccountPO sysAccountPO) {
        ResponseData responseData = new ResponseData();
        MktActivityPOWithBLOBs bs = new MktActivityPOWithBLOBs();
        bs.setModifiedUserId(sysAccountPO.getSysAccountId());
        bs.setModifiedDate(new Date());
        bs.setModifiedUserName(sysAccountPO.getName());
        bs.setCheckStatus(po.getCheckStatus());
        bs.setActivityCode(po.getBusinessCode());
        //根据code查询出审核活动的详细信息
        ActivityVO vo = new ActivityVO();
        vo.setActivityCode(po.getBusinessCode());
        List<ActivityVO> activityRegisterList = mktActivityRegisterPOMapper.getActivityList(vo);
        if (CollectionUtils.isEmpty(activityRegisterList)){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
            return responseData;
        }
        ActivityVO activityPO = activityRegisterList.get(0);
        //判断是审核通过还是审核驳回
        if(bs.getCheckStatus()==CheckStatusEnum.CHECK_STATUS_APPROVED.getCode()){
            //活动开始时间<当前时间<活动结束时间  或者长期活动 也就是StartTime=null
            if(1== activityPO.getLongTerm() ||(new Date().after(activityPO.getStartTime()) && new Date().before(activityPO.getEndTime()))){
                //将活动状态变更为执行中 并且发送消息
                bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
                int i = mktActivityPOMapper.updateByPrimaryKeySelective(bs);
                //发送模板消息TODO
                //查询消息集合
                MktMessagePOExample example = new MktMessagePOExample();
                example.createCriteria().andBizIdEqualTo(po.getBusinessId()).andValidEqualTo(true);
                List<MktMessagePO> ListMktMessage = mktMessagePOMapper.selectByExample(example);
                //查询对应的会员
                MemberInfoModel memberInfoModel= new MemberInfoModel();
                memberInfoModel.setBrandId(activityPO.getSysBrandId());
                memberInfoModel.setLevelId(Long.parseLong(activityPO.getMbrLevelCode()));
                ResponseData<List<MemberInfoModel>> memberInfoModelLists =memberInfoApiService.getMemberInfo(memberInfoModel);
                List<MemberInfoModel> memberInfoModelList = memberInfoModelLists.getData();
                //循环发送
                if (!org.springframework.util.CollectionUtils.isEmpty(memberInfoModelList)){
                    for (MemberInfoModel memberInfo:memberInfoModelList) {
                        //循环信息类然后发送
                        for (MktMessagePO mktMessagePO:ListMktMessage) {
                            if (mktMessagePO.getMsgType().equals("1")){
                                //发送微信模板消息
                            }
                            if (mktMessagePO.getMsgType().equals("2")){
                                //发送短信消息
                            }
                        }
                    }
                }

            }
            //判断审核时间 >活动结束时间  将活动状态变为已结束
            if(new Date().after(activityPO.getEndTime())){
                bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_FINISHED.getCode());
                int i = mktActivityPOMapper.updateByPrimaryKeySelective(bs);
            }

        }else{
            bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_FINISHED.getCode());
            int i = mktActivityPOMapper.updateByPrimaryKeySelective(bs);
        }
        //更新审核中心状态
        sysCheckServiceRpc.updateCheck(po);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 小程序端查询活动列表
     * @param vo
     * @return
     */
    @Override
    public ResponseData<List<ActivityVO>> getActivityList(ActivityVO vo) {
        ResponseData responseData = new ResponseData();
        List<ActivityVO> activityList =mktActivityPOMapper.getActivityList(vo);
        responseData.setData(activityList);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 活动效果分析
     * @param bo
     * @param pageForm
     * @return
     */
    @Override
    public ResponseData<ActivityAnalysisCountBO> getActivityAnalysisCountpage(ActivityAnalysisCountBO bo, PageForm pageForm) {
        ResponseData responseData = new ResponseData();
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
        //分页查询出主表信息
        List<ActivityAnalysisCountBO> activityAnalysisList = mktActivityPOMapper.getActivityAnalysisCountpage(bo);
        if (!CollectionUtils.isEmpty(activityAnalysisList)){
            for (ActivityAnalysisCountBO activityAnalysisCount:activityAnalysisList) {
                //查询券统计
                ResponseData<CouponFindCouponCountResponseVO> couponFindCouponCountResponseVODate = couponQueryServiceFeign.findCouponCountBySendBusinessId(activityAnalysisCount.getMktActivityId(), CouponSendTypeEnum.getCouponSendTypeEnumByMktModuleCode(bo.getActivityType()).getCouponModuleCode(),activityAnalysisCount.getSysBrandId());
                CouponFindCouponCountResponseVO couponFindCouponCountResponseVO = couponFindCouponCountResponseVODate.getData();
                //券数量
                activityAnalysisCount.setCouponSum(couponFindCouponCountResponseVO.getCouponSum());
                //核销券数量
                activityAnalysisCount.setCouponUsedSum(couponFindCouponCountResponseVO.getCouponUsedSum());
                //收益
                activityAnalysisCount.setMoney(couponFindCouponCountResponseVO.getMoney());
                //核销率
                // 创建一个数值格式化对象
                NumberFormat numberFormat = NumberFormat.getInstance();
                // 设置精确到小数点后2位
                numberFormat.setMaximumFractionDigits(2);
                String result = numberFormat.format((float)couponFindCouponCountResponseVO.getCouponUsedSum()/(float)couponFindCouponCountResponseVO.getCouponSum()*100);
                activityAnalysisCount.setCouponUsedSumPercentage(result+"%");
                //查询积分统计方法TODO

            }

        }

        PageInfo<ActivityAnalysisCountBO> pageInfo = new PageInfo<>(activityAnalysisList);
        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 奖励券
     * @param activityCode
     * @return
     */
    public ResponseData<Integer> awardCoupon(String activityCode){
        ResponseData responseData = new ResponseData();
        return responseData;
    }

    /**
     * 奖励积分
     * @param activityCode
     * @return
     */
    public ResponseData<Integer> awardIntegral(String activityCode){
        ResponseData responseData = new ResponseData();
        return responseData;
    }

    /**
     * 发送短信
     * @param activityCode
     * @return
     */
    public ResponseData<Integer> sendSms(String activityCode){
        ResponseData responseData = new ResponseData();
        return responseData;
    }

    /**
     * 发送模板消息
     * @param activityCode
     * @return
     */
    public ResponseData<Integer> sendWxTemplateMessage(String activityCode){
        ResponseData responseData = new ResponseData();
        return responseData;
    }
}
