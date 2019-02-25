package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.centerstageservice.rpc.FileTaskServiceRpc;
import com.bizvane.couponfacade.interfaces.CouponDefinitionServiceFeign;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.interfaces.CouponServiceFeign;
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
}
