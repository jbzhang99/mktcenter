package com.bizvane.mktcenterservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.centerstageservice.rpc.FileTaskServiceRpc;
import com.bizvane.couponfacade.interfaces.CouponDefinitionServiceFeign;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.interfaces.CouponServiceFeign;
import com.bizvane.couponfacade.interfaces.SendCouponServiceFeign;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.IntegralChangeApiService;
import com.bizvane.members.facade.service.card.request.IntegralChangeRequestModel;
import com.bizvane.members.facade.service.card.response.IntegralChangeResponseModel;
import com.bizvane.mktcenterfacade.interfaces.TaskService;
import com.bizvane.mktcenterfacade.models.po.*;

import com.bizvane.mktcenterfacade.models.vo.MktActivityPrizeVO;
import com.bizvane.mktcenterservice.common.job.JobUtil;
import com.bizvane.mktcenterservice.common.tools.QiNiuConfigs;
import com.bizvane.mktcenterservice.common.tools.QiNiuUtils;
import com.bizvane.mktcenterservice.common.utils.TimeUtils;
import com.bizvane.mktcenterservice.mappers.MktActivityCountPOMapper;
import com.bizvane.mktcenterservice.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterservice.mappers.MktActivityPrizePOMapper;
import com.bizvane.mktcenterservice.mappers.MktActivityPrizeRecordPOMapper;
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
import java.math.BigDecimal;
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
    @Autowired
    private MktActivityPrizeRecordPOMapper mktActivityPrizeRecordPOMapper;

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
        createMiniprgmQRCodeRequestVO.setPath("pages/template01/gold-egg/main");
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
     * @return
     */
   // 加
    public ResponseData<String>   operationPoint(MktActivityPrizePO mktActivityPrizePO,String activityCode,MemberInfoModel memberInfoModel){
        ResponseData<String> responseData = new ResponseData<>();
        Integer prizePoints = mktActivityPrizePO.getPrizePoints();

        this.addRecord(mktActivityPrizePO,memberInfoModel,null);

        if (prizePoints==null || prizePoints==0){
            //谢谢参与,无积分奖励
            responseData.setData("104");
           return responseData;
        }
        IntegralChangeRequestModel integralRecordModel = new IntegralChangeRequestModel();
        integralRecordModel.setSysCompanyId(mktActivityPrizePO.getSysCompanyId());
        integralRecordModel.setBrandId(mktActivityPrizePO.getSysBrandId());
        integralRecordModel.setMemberCode(memberInfoModel.getMemberCode());
        //BusinessTypeEnum  会员定义的任务类型
        integralRecordModel.setBusinessType("29");
        //2=收入积分(新增积分)      1=支出积分(减少积分)
        integralRecordModel.setChangeType(IntegralChangeTypeEnum.INCOME.getCode());
        integralRecordModel.setChangeBills(activityCode);
        integralRecordModel.setChangeIntegral(mktActivityPrizePO.getPrizePoints());
        log.info("游戏 增操作积分的参数--" + JSON.toJSONString(integralRecordModel));
        IntegralChangeResponseModel integralChangeResponseModel = integralChangeApiService.integralChangeOperate(integralRecordModel);
        log.info("游戏 增操作积分结果打印======" + JSON.toJSONString(integralChangeResponseModel));
        if(mktActivityPrizePO.getPrizeType()==90){
            //谢谢参与奖励积分
            responseData.setData("105");
            responseData.setMessage(String.valueOf(prizePoints));
        }else{
            //非谢谢参与奖  展示图片
            responseData.setData("106");
            responseData.setMessage(mktActivityPrizePO.getImageUrl());
        }

        return responseData;
    }
   //减
    public Boolean operationPoint(MktActivityPOWithBLOBs po,String memberCode){
        IntegralChangeRequestModel integralRecordModel = new IntegralChangeRequestModel();
        integralRecordModel.setSysCompanyId(po.getSysCompanyId());
        integralRecordModel.setBrandId(po.getSysBrandId());
        integralRecordModel.setMemberCode(memberCode);
        //BusinessTypeEnum  会员定义的任务类型
        integralRecordModel.setBusinessType("29");
        //2=收入积分(新增积分)      1=支出积分(减少积分)
        integralRecordModel.setChangeType(IntegralChangeTypeEnum.Expend.getCode());
        integralRecordModel.setChangeBills(po.getActivityCode());
        integralRecordModel.setChangeIntegral(po.getPrizePoints());
        log.info("游戏 减操作积分的参数--" + JSON.toJSONString(integralRecordModel));
        IntegralChangeResponseModel integralChangeResponseModel = integralChangeApiService.integralChangeOperate(integralRecordModel);
        log.info("游戏 减操作积分结果打印======" + JSON.toJSONString(integralChangeResponseModel));
        Integer code = integralChangeResponseModel.getCode();
        if (100==code){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    //操作券
    public ResponseData<String> operationCoupon(MktActivityPrizePO mktActivityPrizePO, String activityName, MemberInfoModel memberInfoModel){
        SendCouponSimpleRequestVO onecouponVO = new SendCouponSimpleRequestVO();
        onecouponVO.setMemberCode(memberInfoModel.getMemberCode());
        onecouponVO.setSendBussienId(mktActivityPrizePO.getMktActivityId());
        onecouponVO.setBusinessName(activityName);
        onecouponVO.setSendType("105");
        onecouponVO.setCouponDefinitionId(mktActivityPrizePO.getCouponDefinitionId());
        onecouponVO.setBrandId(mktActivityPrizePO.getSysBrandId());
        log.info("游戏 发送券的参数-----" + JSON.toJSONString(onecouponVO));
        ResponseData<String> responseData = sendCouponServiceFeign.simple(onecouponVO);
        log.info("游戏 发送券的结果------" + JSON.toJSONString(responseData));
        String couponCode = responseData.getData();
        this.addRecord(mktActivityPrizePO,memberInfoModel,couponCode);
        responseData.setData("106");
        responseData.setMessage(mktActivityPrizePO.getImageUrl());
        return responseData;
    }
    //添加记录
    public  void addRecord(MktActivityPrizePO mktActivityPrizePO,MemberInfoModel memberInfoModel,String couponCode){
        MktActivityPrizeRecordPO record = new MktActivityPrizeRecordPO();
        record.setMktActivityId(mktActivityPrizePO.getMktActivityId());
        record.setSysCompanyId(mktActivityPrizePO.getSysCompanyId());
        record.setSysBrandId(mktActivityPrizePO.getSysBrandId());
        record.setMemberCode(memberInfoModel.getMemberCode());
        record.setMemberPhone(memberInfoModel.getPhone());
        record.setMemberName(memberInfoModel.getName());
        record.setCouponDefinitionId(mktActivityPrizePO.getCouponDefinitionId());
        record.setCouponDefinitionCode(couponCode);
        record.setPrizeTime(new Date());
        record.setPrizeType(mktActivityPrizePO.getPrizeType());
        record.setAwadType(mktActivityPrizePO.getAwadType());
        record.setPrizeName(mktActivityPrizePO.getPrizeName());
        if (mktActivityPrizePO.getPrizeType()!=90){
            record.setIsWinPrize(Boolean.TRUE);
        }else {
            record.setIsWinPrize(Boolean.FALSE);
        }
        record.setValid(Boolean.TRUE);
        mktActivityPrizeRecordPOMapper.insertSelective(record);

        mktActivityCountPOMapper.updateSum(mktActivityPrizePO.getMktActivityId(), 1, BigDecimal.ZERO,0);
    }
}
