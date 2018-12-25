package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.centerstageservice.models.po.FileTaskPo;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.centerstageservice.models.vo.QiNiuVo;
import com.bizvane.centerstageservice.rpc.FileTaskServiceRpc;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.interfaces.CouponServiceFeign;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.vo.CouponUseVO;
import com.bizvane.mktcenterservice.interfaces.ActivityPriceService;
import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.ActivityPriceBO;
import com.bizvane.mktcenterservice.models.vo.ActivityPriceParamVO;
import com.bizvane.mktcenterservice.models.vo.AnalysisPriceResultVO;
import com.bizvane.mktcenterserviceimpl.common.job.JobUtil;
import com.bizvane.mktcenterserviceimpl.common.tools.QiNiuConfigs;
import com.bizvane.mktcenterserviceimpl.common.tools.QiNiuUtils;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityCountPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPrizePOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPrizeRecordPOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.jobutils.JobClient;
import com.bizvane.utils.jobutils.XxlJobInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import com.bizvane.wechatfacade.interfaces.QRCodeServiceFeign;
import com.bizvane.wechatfacade.models.vo.CreateMiniprgmQRCodeRequestVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Author: lijunwei
 * @Time: 2018/12/19 14:20
 */

@Service
@Slf4j
public class ActivityPriceServiceImpl implements ActivityPriceService {

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

    /**
     * 新增
     *
     * @param bo
     * @return
     */
    @Transactional
    @Override
    public ResponseData<JSONObject>
    addActivityPrice(ActivityPriceBO bo, HttpServletRequest request) throws ParseException {
        ResponseData<JSONObject> responseData = new ResponseData<>();
        MktActivityPOWithBLOBs activityPO = bo.getActivityPO();
        List<MktActivityPrizePO> activityPrizePOList = bo.getActivityPrizePOList();
        if (activityPO == null || CollectionUtils.isEmpty(activityPrizePOList)) {
            responseData.setCode(100);
            responseData.setMessage("数据不合格!");
        }
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        Long sysAccountId = sysAccountPo.getSysAccountId();
        String name = sysAccountPo.getName();
        Long brandId = sysAccountPo.getBrandId();
        Long sysCompanyId = sysAccountPo.getSysCompanyId();
        Date date = new Date();
        String activePriceCode = CodeUtil.getActivePriceCode();

        Date startTime = activityPO.getStartTime();
        Boolean runStatus = TimeUtils.ifImmediatelyRun(startTime);
        if (runStatus) {
            activityPO.setActivityType(2);
        } else {
            activityPO.setActivityType(1);
            jobUtil.addStartPrizeJob(sysAccountPo, activityPO, activePriceCode);
        }
        jobUtil.addEndPrizeJob(sysAccountPo, activityPO, activePriceCode);

        activityPO.setCheckStatus(3);
        CreateMiniprgmQRCodeRequestVO createMiniprgmQRCodeRequestVO = new CreateMiniprgmQRCodeRequestVO();
        createMiniprgmQRCodeRequestVO.setSysBrandId(brandId);
        createMiniprgmQRCodeRequestVO.setMiniProgramType("10");
        createMiniprgmQRCodeRequestVO.setPath("pages/template01/coupon-scancode/main");
        createMiniprgmQRCodeRequestVO.setScene(activePriceCode);
        log.info("addActivityPrice wexin param:" + JSON.toJSONString(createMiniprgmQRCodeRequestVO));
        ResponseData<String> qrCodeResponseData = qrCodeServiceFeign.createMiniprgmQRCode(createMiniprgmQRCodeRequestVO);
        log.info("addActivityPrice wexin result:" + JSON.toJSONString(qrCodeResponseData));
        String weixinUrl = qrCodeResponseData.getData();

        activityPO.setActivityType(11);
        activityPO.setQrCodeUrl(weixinUrl);
        activityPO.setActivityCode(activePriceCode);
        activityPO.setSysBrandId(brandId);
        activityPO.setSysCompanyId(sysCompanyId);
        activityPO.setCreateUserId(sysAccountId);
        activityPO.setCreateUserName(name);
        activityPO.setCreateDate(date);
        mktActivityPOMapper.insertSelective(activityPO);
        Long mktActivityId = activityPO.getMktActivityId();

        activityPrizePOList.parallelStream().forEach((MktActivityPrizePO po) -> {
            po.setMktActivityId(mktActivityId);
            po.setSysBrandId(brandId);
            po.setSysCompanyId(sysCompanyId);
            po.setCreateUserId(sysAccountId);
            po.setCreateUserName(name);
            po.setCreateDate(date);
            mktActivityPrizePOMapper.insertSelective(po);
        });

        MktActivityCountPO mktActivityCountPO = new MktActivityCountPO();
        mktActivityCountPO.setMktActivityId(mktActivityId);
        mktActivityCountPO.setSysCompanyId(sysCompanyId);
        mktActivityCountPO.setSysBrandId(brandId);
        mktActivityCountPO.setCreateUserId(sysAccountId);
        mktActivityCountPO.setCreateUserName(name);
        mktActivityCountPO.setCreateDate(date);
        mktActivityCountPOMapper.insertSelective(mktActivityCountPO);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("qrCodeUrl", weixinUrl);
        jsonObject.put("activePriceCode", activePriceCode);
        jsonObject.put("activityName", activityPO.getActivityName());
        responseData.setData(jsonObject);
        return responseData;
    }

    /**
     * 查询详情 id
     *
     * @param mktActivityId
     * @return
     */
    @Override
    public ResponseData<ActivityPriceBO> selectActivityPrice(Long mktActivityId, HttpServletRequest request) {

        ResponseData<ActivityPriceBO> responseData = new ResponseData<>();

        //  SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        ActivityPriceBO activityPriceBO = new ActivityPriceBO();
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = mktActivityPOMapper.selectByPrimaryKey(mktActivityId);
        String storeLimitListStr = mktActivityPOWithBLOBs.getStoreLimitList();
        List<SysStorePo> storeList = new ArrayList<SysStorePo>();
        if (StringUtils.isNotBlank(storeLimitListStr)) {
            List<Long> storeIdList = Arrays.asList(storeLimitListStr.split(",")).stream().map(element -> Long.valueOf(element)).collect(Collectors.toList());
            //查询店铺列表
            storeList = taskService.getStoreListByIds(storeIdList);
            log.info("---------通过品牌Ids--" + JSON.toJSONString(storeList) + "-----获取店铺列表----------" + JSON.toJSONString(storeList));
            activityPriceBO.setStoreList(storeList);
        }


        MktActivityPrizePOExample example = new MktActivityPrizePOExample();
        example.createCriteria().andMktActivityIdEqualTo(mktActivityId);
        List<MktActivityPrizePO> mktActivityPrizePOS = mktActivityPrizePOMapper.selectByExample(example);

        activityPriceBO.setActivityPO(mktActivityPOWithBLOBs);
        activityPriceBO.setActivityPrizePOList(mktActivityPrizePOS);
        responseData.setData(activityPriceBO);
        return responseData;
    }

    /**
     * 查询详情 code
     */
    @Override
    public ResponseData<ActivityPriceBO> selectActivityPrice(String activePriceCode) {
        ResponseData<ActivityPriceBO> responseData = new ResponseData<>();

        //  SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        ActivityPriceBO activityPriceBO = new ActivityPriceBO();
        MktActivityPOExample example0 = new MktActivityPOExample();
        example0.createCriteria().andActivityCodeEqualTo(activePriceCode);
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = mktActivityPOMapper.selectByExampleWithBLOBs(example0).get(0);

        MktActivityPrizePOExample example = new MktActivityPrizePOExample();
        example.createCriteria().andMktActivityIdEqualTo(mktActivityPOWithBLOBs.getMktActivityId());
        List<MktActivityPrizePO> mktActivityPrizePOS = mktActivityPrizePOMapper.selectByExample(example);

        activityPriceBO.setActivityPO(mktActivityPOWithBLOBs);
        activityPriceBO.setActivityPrizePOList(mktActivityPrizePOS);
        responseData.setData(activityPriceBO);
        return responseData;
    }

    /**
     * 查询列表
     */
    @Override
    public ResponseData<PageInfo<MktActivityPOWithBLOBs>> selectActivityPriceLists(ActivityPriceParamVO vo, HttpServletRequest request) {
        ResponseData<PageInfo<MktActivityPOWithBLOBs>> responseData = new ResponseData<>();
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        MktActivityPOExample example = new MktActivityPOExample();
        MktActivityPOExample.Criteria criteria = example.createCriteria();
        criteria.andActivityTypeEqualTo(11);
        criteria.andSysBrandIdEqualTo(sysAccountPo.getBrandId());
        String activityCode = vo.getActivityCode();
        if (null != activityCode) {
            criteria.andActivityCodeLike("%" + activityCode + "%");
        }
        String activityName = vo.getActivityName();
        if (null != activityName) {
            criteria.andActivityNameLike("%" + activityName + "%");
        }
        Integer activityStatus = vo.getActivityStatus();
        if (0 != activityStatus) {
            criteria.andActivityStatusEqualTo(activityStatus);
        }
        List<MktActivityPOWithBLOBs> listparam = mktActivityPOMapper.selectByExampleWithBLOBs(example);
        if (CollectionUtils.isEmpty(listparam)) {
            listparam = new ArrayList<MktActivityPOWithBLOBs>();
        }
        PageInfo<MktActivityPOWithBLOBs> pageInfo = new PageInfo<>(listparam);
        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 禁用活动
     * 活动Id  和  活动Code
     */
    @Override
    public ResponseData<Integer> stopActivityPrice(MktActivityPOWithBLOBs po, HttpServletRequest request) {
        ResponseData<Integer> responseData = new ResponseData<>();
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        po.setActivityStatus(4);
        po.setModifiedDate(new Date());
        po.setModifiedUserId(sysAccountPo.getSysAccountId());
        po.setModifiedUserName(sysAccountPo.getName());
        mktActivityPOMapper.updateByPrimaryKeySelective(po);

        //禁用后要清除所有的job
        XxlJobInfo xxlJobInfo = new XxlJobInfo();
        xxlJobInfo.setBizCode(po.getActivityCode());
        jobClient.removeByBiz(xxlJobInfo);

        return responseData;

    }


    /**
     * 记录统计
     */
    @Override
    public ResponseData<PageInfo<AnalysisPriceResultVO>> selectAnalysisPrice(ActivityPriceParamVO vo, HttpServletRequest request) {
        ResponseData<PageInfo<AnalysisPriceResultVO>> responseData = new ResponseData<>();
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<AnalysisPriceResultVO> lists = mktActivityPrizePOMapper.selectAnalysisPrice(vo);
        if (CollectionUtils.isEmpty(lists)) {
            lists = new ArrayList<>();
        } else {
            lists.parallelStream().forEach(param -> {
                int dataNum = TimeUtils.getDataNum(param.getEndTime());
                param.setResidueDates(dataNum);
                param.setGoingDates(param.getTotalDates() - dataNum);
                param.setPrizePeople(mktActivitPrizeRecordPOMapper.selectPrizePeopleNum(param.getMktActivityId()));
            });
        }
        PageInfo<AnalysisPriceResultVO> pageInfo = new PageInfo<>(lists);
        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 中奖人数
     */
    @Override
    public ResponseData<PageInfo<MktActivityPrizeRecordPO>> selectPrizePeople(ActivityPriceParamVO vo) {
        ResponseData<PageInfo<MktActivityPrizeRecordPO>> responseData = new ResponseData<>();
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        MktActivityPrizeRecordPOExample example = new MktActivityPrizeRecordPOExample();
        example.createCriteria().andMktActivityIdEqualTo(vo.getMktActivityId())
                .andMemberNameLike("%" + vo.getMemberName() + "%")
                .andPrizeNameLike("%" + vo.getPrizeName() + "%")
                .andAwadTypeNotEqualTo(50).andValidEqualTo(Boolean.TRUE);

        List<MktActivityPrizeRecordPO> lists = mktActivitPrizeRecordPOMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(lists)) {
            lists = new ArrayList<MktActivityPrizeRecordPO>();
        }
        PageInfo<MktActivityPrizeRecordPO> pageInfo = new PageInfo<>(lists);
        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 核销
     */
    @Override
    public ResponseData<String> doVerificationCoupon(ActivityPriceParamVO vo, HttpServletRequest request) {
        log.info("doVerificationCoupon param:" + JSON.toJSONString(vo));
        ResponseData<String> responseData = null;
        CouponDefinitionPO couponDefinitionPO = couponQueryServiceFeign.getCouponDefinition(vo.getCouponDefinitionId()).getData().getCouponDefinitionPO();
        if (couponDefinitionPO == null) {
            responseData = new ResponseData<>();
            responseData.setCode(100);
            responseData.setMessage("券不存在!");
            return responseData;
        }
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        CouponUseVO requestVO = new CouponUseVO();
        requestVO.setCouponCode(couponDefinitionPO.getCouponDefinitionCode());
        requestVO.setStaffCode(vo.getMemberCode());
        requestVO.setBrandId(sysAccountPo.getBrandId());
        responseData = couponServiceFeign.use(requestVO);
        log.info("doVerificationCoupon result:" + JSON.toJSONString(responseData));
        return responseData;
    }

    /**
     * 下载转盘二维码
     */
    @Override
    public ResponseData<String> exportQRCodes(ActivityPriceParamVO vo, HttpServletRequest request, HttpServletResponse response) {

        SysAccountPO sysAccountPO = TokenUtils.getStageUser(request);
        ResponseData responseData = new ResponseData();
        responseData.setCode(SysResponseEnum.FAILED.getCode());
        //创建需要下载的文件路径的集合
//        List<SysStorePo> storeResult = new ArrayList<>();
//        for (Long id : sysStoreVo.getStoreIdList()) {
//          //  SysStorePo sysStorePo = sysStorePOMapper.selectByPrimaryKey(id);
////            if (sysStorePo != null && sysStorePo.getStoreOrcode() != null) {
////                storeResult.add(sysStorePo);
////            }
//        }
        //插入导出任务
        Long taskId = (long) Integer.parseInt(String.valueOf(UUID.randomUUID().hashCode()).replaceAll("-", ""));
        FileTaskPo fileTaskPo = new FileTaskPo();
        fileTaskPo.setTaskId(taskId);
        if (sysAccountPO != null) {
            fileTaskPo.setSysBrandId(sysAccountPO.getBrandId());
            fileTaskPo.setCreateUserId(sysAccountPO.getSysAccountId());
            fileTaskPo.setCreateUserName(sysAccountPO.getName());
        }
        fileTaskPo.setTaskTypeCode(String.valueOf(1) + "条");//任务记录
        fileTaskPo.setTaskName("下载转盘活动二维码");
        //进度
        fileTaskPo.setFileStatus(25L);
        fileTaskPo.setFileType("EXPORT");
        fileTaskPo.setValid(true);
        fileTaskServiceRpc.addFileTask(fileTaskPo);

        new Thread(() -> {
            try {
                ByteArrayOutputStream tempByteOStream = null;
                BufferedOutputStream tempBufferOStream = null;
                ZipOutputStream tempZStream = null;
                ZipEntry tempEntry = null;

                tempByteOStream = new ByteArrayOutputStream();
                tempZStream = new ZipOutputStream(tempByteOStream);
                tempBufferOStream = new BufferedOutputStream(tempZStream);


                fileTaskPo.setFileStatus(60L);
                fileTaskServiceRpc.update(fileTaskPo);

                try {
                    URL url = new URL(vo.getQrCodeUrl());
                    InputStream in = url.openStream();
                    byte[] buff = new byte[1024];
                    tempEntry = new ZipEntry(vo.getActivityName() + "(" + vo.getActivityCode() + ")" + ".jpg");
                    tempZStream.putNextEntry(tempEntry);

                    int len = 0;
                    while ((len = in.read(buff)) != -1) {
                        tempZStream.write(buff, 0, len);
                    }

                    Thread.sleep(3000);

                } catch (Exception e) {
                }

                fileTaskPo.setFileStatus(99L);
//                new Thread(() -> {
//                	可以做进度
//                }).start();
                tempBufferOStream.flush();
                tempByteOStream.flush();
                tempZStream.closeEntry();
                tempZStream.close();
                tempByteOStream.close();
                tempBufferOStream.close();

                ByteArrayInputStream in = new ByteArrayInputStream(((ByteArrayOutputStream) tempByteOStream).toByteArray());

                //  QiNiuUtils niuUtil = new QiNiuUtils();
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
                String day = format.format(new Date());
                QiNiuVo qiniuUrl = niuUtil.upload(qiNiuConfig.getBucket(), in, day + "转盘活动.zip");

                //保存成功会写数据库
                fileTaskPo.setFileStatus(100L);
                fileTaskPo.setFileUnl("https://" + qiNiuConfig.getDoMain() + "/" + qiniuUrl.getUrl().toString());
                fileTaskServiceRpc.update(fileTaskPo);


            } catch (Exception e) {
                e.printStackTrace();
                // 导出报错
                fileTaskPo.setFileStatus(-1L);
                fileTaskServiceRpc.update(fileTaskPo);
            }
        }).start();

        responseData.setData(taskId);
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());

        return responseData;
    }
}
