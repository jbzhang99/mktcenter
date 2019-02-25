package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.centerstageservice.rpc.FileTaskServiceRpc;
import com.bizvane.couponfacade.interfaces.CouponDefinitionServiceFeign;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.interfaces.CouponServiceFeign;
import com.bizvane.couponfacade.interfaces.SendCouponServiceFeign;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.service.api.IntegralChangeApiService;
import com.bizvane.members.facade.service.card.request.IntegralChangeRequestModel;
import com.bizvane.members.facade.service.card.response.IntegralChangeResponseModel;
import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.po.MktActivityCountPO;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktActivityPrizePO;
import com.bizvane.mktcenterservice.models.po.MktActivityPrizePOExample;
import com.bizvane.mktcenterservice.models.vo.MktActivityPrizeVO;
import com.bizvane.mktcenterserviceimpl.common.job.JobUtil;
import com.bizvane.mktcenterserviceimpl.common.tools.QiNiuConfigs;
import com.bizvane.mktcenterserviceimpl.common.tools.QiNiuUtils;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityCountPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPrizePOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPrizeRecordPOMapper;
import com.bizvane.utils.jobutils.JobClient;
import com.bizvane.utils.jobutils.XxlJobInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import com.bizvane.wechatfacade.interfaces.QRCodeServiceFeign;
import com.bizvane.wechatfacade.models.vo.CreateMiniprgmQRCodeRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2019/2/25 9:13
 */
@Service
@Slf4j
public class ActivityCommonServiceImpl {
    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Autowired
    private MktActivityPrizePOMapper mktActivityPrizePOMapper;
    @Autowired
    private QRCodeServiceFeign qrCodeServiceFeign;
    @Autowired
    private MktActivityPrizeRecordPOMapper mktActivitPrizeRecordPOMapper;
    @Autowired
    private MktActivityCountPOMapper mktActivityCountPOMapper;
    @Autowired
    private JobUtil jobUtil;
    @Autowired
    private JobClient jobClient;
    @Autowired
    private QiNiuConfigs qiNiuConfig;
    @Autowired
    private QiNiuUtils niuUtil;
    @Autowired
    private FileTaskServiceRpc fileTaskServiceRpc;
    @Autowired
    private CouponServiceFeign couponServiceFeign;
    @Autowired
    private CouponQueryServiceFeign couponQueryServiceFeign;
    @Autowired
    private TaskService taskService;
    @Autowired
    private CouponDefinitionServiceFeign couponDefinitionServiceFeign;
    @Autowired
    private  IntegralChangeApiService integralChangeApiService;
    @Autowired
    private SendCouponServiceFeign sendCouponServiceFeign;

    //新增游戏主表
    public Long addActivityMianGame(MktActivityPOWithBLOBs activityPO, SysAccountPO sysAccountPo, String activePriceCode, String weixinUrl) throws ParseException {
        Date startTime = activityPO.getStartTime();
        Boolean runStatus = TimeUtils.ifImmediatelyRun(startTime);
        log.info("游戏 addActivityMianGame status:" + runStatus);
        if (runStatus) {
            activityPO.setActivityStatus(2);
        } else {
            activityPO.setActivityStatus(1);
            jobUtil.addStartPrizeJob(sysAccountPo, activityPO, activePriceCode);
        }
        jobUtil.addEndPrizeJob(sysAccountPo, activityPO, activePriceCode);
        activityPO.setCheckStatus(3);
        //activityPO.setActivityType(13);
        activityPO.setQrCodeUrl(weixinUrl);
        activityPO.setActivityCode(activePriceCode);
        activityPO.setSysBrandId(sysAccountPo.getBrandId());
        activityPO.setSysCompanyId(sysAccountPo.getSysCompanyId());
        activityPO.setCreateUserId(sysAccountPo.getSysAccountId());
        activityPO.setCreateUserName(sysAccountPo.getName());
        activityPO.setCreateDate(new Date());
        mktActivityPOMapper.insertSelective(activityPO);
        return activityPO.getMktActivityId();
    }

    //修改游戏主表
    public void updateActivityMianGame(MktActivityPOWithBLOBs activityPO, SysAccountPO sysAccountPo) throws ParseException {
        String activePriceCode = activityPO.getActivityCode();
        Date startTime = activityPO.getStartTime();
        Boolean runStatus = TimeUtils.ifImmediatelyRun(startTime);
        log.info("游戏 updateActivityMianGame status:" + runStatus);
        if (runStatus) {
            activityPO.setActivityStatus(2);
        } else {
            activityPO.setActivityStatus(1);
            jobUtil.addStartPrizeJob(sysAccountPo, activityPO, activePriceCode);
        }
        jobUtil.addEndPrizeJob(sysAccountPo, activityPO, activePriceCode);
        activityPO.setCheckStatus(3);
        activityPO.setModifiedUserId(sysAccountPo.getSysAccountId());
        activityPO.setModifiedUserName(sysAccountPo.getName());
        activityPO.setModifiedDate(new Date());
        mktActivityPOMapper.updateByPrimaryKeySelective(activityPO);
    }

    //添加奖项
    public void addAllPrize(List<MktActivityPrizeVO> activityPrizePOList, SysAccountPO sysAccountPo, Long mktActivityId) {
        activityPrizePOList.parallelStream().forEach((MktActivityPrizePO po) -> {
            po.setMktActivityId(mktActivityId);
            po.setSysBrandId(sysAccountPo.getBrandId());
            po.setSysCompanyId(sysAccountPo.getSysCompanyId());
            po.setCreateUserId(sysAccountPo.getSysAccountId());
            po.setCreateUserName(sysAccountPo.getName());
            po.setCreateDate(new Date());
            mktActivityPrizePOMapper.insertSelective(po);
        });
    }

    //删除奖项
    public void deleteAllPrize(Long mktActivityId) {
        MktActivityPrizePOExample example = new MktActivityPrizePOExample();
        example.createCriteria().andMktActivityIdEqualTo(mktActivityId).andValidEqualTo(Boolean.TRUE);
        mktActivityPrizePOMapper.deleteByExample(example);
    }

    //获取微信url
    public String getWxurl(Long brandId, String activePriceCode) {
        CreateMiniprgmQRCodeRequestVO createMiniprgmQRCodeRequestVO = new CreateMiniprgmQRCodeRequestVO();
        createMiniprgmQRCodeRequestVO.setSysBrandId(brandId);
        createMiniprgmQRCodeRequestVO.setMiniProgramType("10");
        createMiniprgmQRCodeRequestVO.setPath("pages/template01/prize-draw/main");
        createMiniprgmQRCodeRequestVO.setScene(activePriceCode);
        log.info("addActivityPrice wexin param:" + JSON.toJSONString(createMiniprgmQRCodeRequestVO));
        ResponseData<String> qrCodeResponseData = qrCodeServiceFeign.createMiniprgmQRCode(createMiniprgmQRCodeRequestVO);
        log.info("addActivityPrice wexin result:" + JSON.toJSONString(qrCodeResponseData));
        return qrCodeResponseData.getData();
    }

    //新增游戏统计
    public void addGameCount(SysAccountPO sysAccountPo, Long mktActivityId) {
        MktActivityCountPO mktActivityCountPO = new MktActivityCountPO();
        mktActivityCountPO.setMktActivityId(mktActivityId);
        mktActivityCountPO.setSysCompanyId(sysAccountPo.getSysCompanyId());
        mktActivityCountPO.setSysBrandId(sysAccountPo.getBrandId());
        mktActivityCountPO.setCreateUserId(sysAccountPo.getSysAccountId());
        mktActivityCountPO.setCreateUserName(sysAccountPo.getName());
        mktActivityCountPO.setCreateDate(new Date());
        mktActivityCountPOMapper.insertSelective(mktActivityCountPO);
    }

    /**
     * 禁用活动
     * 活动Id  和  活动Code
     */
    public ResponseData<Integer> stopActivityGame(MktActivityPOWithBLOBs po, HttpServletRequest request) {
        ResponseData<Integer> responseData = new ResponseData<>();
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        po.setActivityStatus(4);
        po.setModifiedDate(new Date());
        po.setModifiedUserId(sysAccountPo.getSysAccountId());
        po.setModifiedUserName(sysAccountPo.getName());
        mktActivityPOMapper.updateByPrimaryKeySelective(po);
        //禁用后要清除所有的job
        this.stopJobs(po);
        return responseData;
    }

    /**
     * 停用job
     *
     * @param po
     */
    public void stopJobs(MktActivityPOWithBLOBs po) {
        XxlJobInfo xxlJobInfo = new XxlJobInfo();
        xxlJobInfo.setBizCode(po.getActivityCode());
        jobClient.removeByBiz(xxlJobInfo);
    }

    /**
     *   成功   data有值    code为0     失败   data无值    code为100
     * @param mktActivityPrizePO
     * @param activityCode
     * @param memberCode
     * @return
     */
    public ResponseData<String>   operationPoint(MktActivityPrizePO mktActivityPrizePO,String activityCode,String memberCode){
        ResponseData<String> responseData = new ResponseData<>();
        Integer prizePoints = mktActivityPrizePO.getPrizePoints();
        if (prizePoints==null){
           return responseData;
        }
        IntegralChangeRequestModel integralRecordModel = new IntegralChangeRequestModel();
        integralRecordModel.setSysCompanyId(mktActivityPrizePO.getSysCompanyId());
        integralRecordModel.setBrandId(mktActivityPrizePO.getSysBrandId());
        integralRecordModel.setMemberCode(memberCode);
        //BusinessTypeEnum  会员定义的任务类型
        integralRecordModel.setBusinessType("29");
        //2=收入积分(新增积分)      1=支出积分(减少积分)
        integralRecordModel.setChangeType(IntegralChangeTypeEnum.INCOME.getCode());
        integralRecordModel.setChangeBills(activityCode);
        integralRecordModel.setChangeIntegral(mktActivityPrizePO.getPrizePoints());
        log.info("游戏 操作积分的参数--" + JSON.toJSONString(integralRecordModel));
        IntegralChangeResponseModel integralChangeResponseModel = integralChangeApiService.integralChangeOperate(integralRecordModel);
        log.info("游戏 操作积分结果打印======" + JSON.toJSONString(integralChangeResponseModel));
        responseData.setMessage(String.valueOf(prizePoints));
        return responseData;
    }

    //操作券
    public ResponseData<String> operationCoupon(MktActivityPrizePO mktActivityPrizePO,Long mktActivityId,String activityCode,String activityName,String memberCode){
        SendCouponSimpleRequestVO onecouponVO = new SendCouponSimpleRequestVO();
        onecouponVO.setMemberCode(memberCode);
        onecouponVO.setSendBussienId(mktActivityId);
        onecouponVO.setBusinessName(activityName);
        onecouponVO.setSendType("105");
        onecouponVO.setCouponDefinitionId(mktActivityPrizePO.getCouponDefinitionId());
        onecouponVO.setBrandId(mktActivityPrizePO.getSysBrandId());
        log.info("游戏 发送券的参数-----" + JSON.toJSONString(onecouponVO));
        ResponseData<String> responseData = sendCouponServiceFeign.simple(onecouponVO);
        log.info("游戏 发送券的结果------" + JSON.toJSONString(responseData));
        responseData.setData(mktActivityPrizePO.getImageUrl());
        return responseData;
    }
}
