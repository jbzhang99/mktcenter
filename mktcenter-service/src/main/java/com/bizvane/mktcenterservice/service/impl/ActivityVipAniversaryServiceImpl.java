package com.bizvane.mktcenterservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.centerstageservice.models.vo.SysCheckConfigVo;
import com.bizvane.centerstageservice.rpc.StoreServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckServiceRpc;
import com.bizvane.couponfacade.enums.SendTypeEnum;
import com.bizvane.couponfacade.interfaces.CouponEntityServiceFeign;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.interfaces.SendCouponServiceFeign;
import com.bizvane.couponfacade.models.po.CouponEntityPO;
import com.bizvane.couponfacade.models.vo.CouponDetailResponseVO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.models.IntegralRecordModel;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.IntegralChangeApiService;
import com.bizvane.members.facade.service.api.IntegralRecordApiService;
import com.bizvane.members.facade.service.card.request.IntegralChangeRequestModel;
import com.bizvane.members.facade.service.card.response.IntegralChangeResponseModel;
import com.bizvane.members.facade.vo.IntegralRecordVo;
import com.bizvane.mktcenterfacade.interfaces.ActivityVipAniversaryService;
import com.bizvane.mktcenterfacade.models.bo.ActivityBO;
import com.bizvane.mktcenterfacade.models.po.*;
import com.bizvane.mktcenterservice.mappers.*;

import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.mktcenterfacade.models.vo.PageForm;
import com.bizvane.mktcenterservice.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterservice.common.enums.ActivityTypeEnum;
import com.bizvane.mktcenterservice.common.enums.BusinessTypeEnum;
import com.bizvane.mktcenterservice.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterservice.common.job.JobUtil;
import com.bizvane.mktcenterservice.common.utils.CodeUtil;
import com.bizvane.mktcenterservice.common.utils.ExecuteParamCheckUtil;

import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.jobutils.JobClient;
import com.bizvane.utils.jobutils.XxlJobInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by pc on 2018/9/7.
 */
@Service
@Slf4j
public class ActivityVipAniversaryServiceImpl implements ActivityVipAniversaryService {

    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;

    @Autowired
    private MktActivityVipAniversaryPOMapper mktActivityVipAniversaryPOMapper;

    @Autowired
    private CouponQueryServiceFeign couponQueryServiceFeign;

    @Autowired
    private IntegralChangeApiService integralChangeApiService;

    @Autowired
    private CouponEntityServiceFeign couponEntityServiceFeign;

    @Autowired
    private SendCouponServiceFeign sendCouponServiceFeign;

    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;

    @Autowired
    private MktActivityRecordPOMapper mktActivityRecordPOMapper;

    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;

    @Autowired
    private JobUtil jobUtil;

    @Autowired
    private JobClient jobClient;
    @Autowired
    private StoreServiceRpc storeServiceRpc;
    @Autowired
    private IntegralRecordApiService integralRecordApiService;
    
    @Autowired
    private MktActivityCountPOMapper mktActivityCountPOMapper;
    
    @Override
    public ResponseData<ActivityVO> getActivityVipAniversaryList(ActivityVO vo, PageForm pageForm,SysAccountPO stageUser) {
        log.info("查询纪念日活动列表开始");
        ResponseData responseData = new ResponseData();
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
        vo.setSysBrandId(stageUser.getBrandId());
        vo.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_ANNIVERSARY.getCode());
        List<ActivityVO> activityAniversaryList = mktActivityVipAniversaryPOMapper.getActivityAniversaryList(vo);
        PageInfo<ActivityVO> pageInfo = new PageInfo<>(activityAniversaryList);
        responseData.setData(pageInfo);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    @Override
    @Transactional
    public ResponseData<Integer> addActivityVipAniversary(ActivityBO bo, SysAccountPO stageUser) {

        log.info("创建纪念日活动开始");
        //返回对象
        ResponseData responseData = new ResponseData();
        //得到大实体类
        ActivityVO activityVO = bo.getActivityVO();
        //判断是否是全部等级
        if (activityVO.getMbrLevelCode().equals("0")){
            activityVO.setMbrLevelName("全部等级");
        }
        //判断活动开始时间是否大于当前时间
        if(1 != bo.getActivityVO().getLongTerm() && new Date().after(activityVO.getStartTime())){
            responseData.setCode(SysResponseEnum.MODEL_FAILED_VALIDATION.getCode());
            responseData.setMessage("活动开始时间不能比当前时间小!");
            return responseData;
        }
        //工具类生成活动编码
        String activityCode = CodeUtil.getActivityCode();
        activityVO.setActivityCode(activityCode);
        //增加活动类型是纪念日活动
        activityVO.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_ANNIVERSARY.getCode());
        //增加品牌id
        log.info("获取的品牌id是="+stageUser.getBrandId());
        if(null==stageUser.getBrandId()){
            log.error("token没有获取到品牌id");
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("Token没有获取到品牌id!");
            return responseData;
        }
        activityVO.setSysBrandId(stageUser.getBrandId());
        activityVO.setSysCompanyId(stageUser.getSysCompanyId());
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        BeanUtils.copyProperties(activityVO,mktActivityPOWithBLOBs);

        //查询判断长期活动同一会员等级是否有重复
        if(1 == bo.getActivityVO().getLongTerm()){
            ActivityVO vo = new ActivityVO();
            vo.setMbrLevelCode(bo.getActivityVO().getMbrLevelCode());
            vo.setLongTerm(bo.getActivityVO().getLongTerm());
            vo.setSysBrandId(activityVO.getSysBrandId());
            vo.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_BIRTHDAY.getCode());
            vo.setStop("true");
            List<ActivityVO> registerList = mktActivityVipAniversaryPOMapper.getActivityAniversaryList(vo);
            if(!CollectionUtils.isEmpty(registerList)){
                for (ActivityVO activity:registerList) {
                    //判断适用商品
                    if (!ExecuteParamCheckUtil.addActivitCheck(bo,activity)){
                        responseData.setCode(SysResponseEnum.FAILED.getCode());
                        responseData.setMessage("已存在同一类型的长期活动!");
                        return responseData;
                    }
                }

            }
        }

        //查询结果如果不需要审核审核状态为已审核
        mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
        //getStartTime 开始时间>当前时间增加job
        if(1 != bo.getActivityVO().getLongTerm() && new Date().before(activityVO.getStartTime())){
            //活动状态设置为待执行
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
            //创建任务调度任务开始时间
            jobUtil.addStratAniversaryJob(stageUser,activityVO,activityCode);
            //创建任务调度任务结束时间
            jobUtil.addEndAniversaryJob(stageUser,activityVO,activityCode);
        }else{
            //活动状态设置为执行中
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
        }

        //新增活动主表
        mktActivityPOWithBLOBs.setCreateDate(new Date());
        mktActivityPOWithBLOBs.setCreateUserId(stageUser.getSysAccountId());
        mktActivityPOWithBLOBs.setCreateUserName(stageUser.getName());
        log.info("增加一条数据到主表参数为："+ JSON.toJSONString(mktActivityPOWithBLOBs));
        mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);
        //获取新增后数据id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();
        
        // 新增活动统计表
        MktActivityCountPO mktActivityCountPO = new MktActivityCountPO();
        mktActivityCountPO.setMktActivityId(mktActivityId);
        mktActivityCountPO.setSysCompanyId(mktActivityPOWithBLOBs.getSysCompanyId());
        mktActivityCountPO.setSysBrandId(mktActivityPOWithBLOBs.getSysBrandId());
        mktActivityCountPO.setCreateDate(new Date());
        mktActivityCountPO.setCreateUserId(stageUser.getSysAccountId());
        mktActivityCountPO.setCreateUserName(stageUser.getName());
        mktActivityCountPOMapper.insertSelective(mktActivityCountPO);
        
        //新增纪念日活动表
        MktActivityVipAniversaryPO mktActivityVipAniversaryPO=new MktActivityVipAniversaryPO();
        BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktActivityVipAniversaryPO);
        mktActivityVipAniversaryPO.setMktActivityId(mktActivityId);
        mktActivityVipAniversaryPO.setMbrLevelCode(activityVO.getMbrLevelCode());
        mktActivityVipAniversaryPO.setMbrLevelName(activityVO.getMbrLevelName());
        mktActivityVipAniversaryPO.setDaysAhead(activityVO.getDaysAhead());
        mktActivityVipAniversaryPO.setIsStoreLimit(activityVO.getStoreLimit());
        mktActivityVipAniversaryPO.setRegisterMonths(activityVO.getRegisterMonths());
        if (false==activityVO.getStoreLimit()){
            mktActivityVipAniversaryPO.setStoreLimitList(activityVO.getStoreLimitList());
            mktActivityVipAniversaryPO.setStoreLimitType(activityVO.getStoreLimitType());
        }
        log.info("增加一条数据到纪念日活动,参数为："+ JSON.toJSONString(mktActivityVipAniversaryPO));
        mktActivityVipAniversaryPOMapper.insertSelective(mktActivityVipAniversaryPO);

        //新增券奖励
        List<MktCouponPO> couponCodeList = bo.getCouponCodeList();
        if(!CollectionUtils.isEmpty(couponCodeList)){
            for(MktCouponPO couponCode : couponCodeList){
                MktCouponPO mktCouponPO = new MktCouponPO();
                BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktCouponPO);
                mktCouponPO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
                mktCouponPO.setBizId(mktActivityId);
                mktCouponPO.setCouponName(couponCode.getCouponName());
                mktCouponPO.setCouponDefinitionId(couponCode.getCouponDefinitionId());
                //mktCouponPO.setBizId(couponCode.getBizId());
                mktCouponPOMapper.insertSelective(mktCouponPO);
            }
        }

        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    @Override
    public ResponseData<ActivityBO> selectActivityVipAniversaryById(String businessCode) {
        ActivityBO bo = new ActivityBO();
        log.info("查询纪念日活动详情参数="+businessCode);
        ResponseData responseData = new ResponseData();
        ActivityVO vo= new ActivityVO();
        vo.setActivityCode(businessCode);
        vo.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_ANNIVERSARY.getCode());
        //查询主表和字表数据
        List<ActivityVO> registerList = mktActivityVipAniversaryPOMapper.getActivityAniversaryList(vo);
        if (CollectionUtils.isEmpty(registerList)){
            responseData.setCode(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getCode());
            responseData.setMessage(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
            return responseData;
        }

        if(!CollectionUtils.isEmpty(registerList)){
            bo.setActivityVO(registerList.get(0));
            if (!StringUtils.isEmpty(registerList.get(0).getStoreLimitList())){
                String ids =registerList.get(0).getStoreLimitList();
                //查询适用门店
                List<Long> listIds = Arrays.asList(ids.split(",")).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
                ResponseData<List<SysStorePo>> sysStorePOs = storeServiceRpc.getIdStoreLists(listIds);
                if(!CollectionUtils.isEmpty(sysStorePOs.getData())){
                    bo.getActivityVO().setSysStorePos(sysStorePOs.getData());
                }
            }
        }
        //查询活动卷
        MktCouponPOExample example = new  MktCouponPOExample();
        example.createCriteria().andBizIdEqualTo(registerList.get(0).getMktActivityId()).andValidEqualTo(true).andBizTypeEqualTo(1);
        List<MktCouponPO> mktCouponPOs= mktCouponPOMapper.selectByExample(example);
        //查询券接口
        List<CouponDetailResponseVO> lists = new ArrayList<>();
        //查询券接口
        if(!CollectionUtils.isEmpty(mktCouponPOs)){
            for (MktCouponPO po:mktCouponPOs) {
                ResponseData<CouponDetailResponseVO>  entityAndDefinition = couponQueryServiceFeign.getCouponDefinition(po.getCouponDefinitionId());
                lists.add(entityAndDefinition.getData());
            }
        }
        //查询消息模板
        MktMessagePOExample exampl = new MktMessagePOExample();
        exampl.createCriteria().andBizIdEqualTo(registerList.get(0).getMktActivityId()).andValidEqualTo(true);
        List<MktMessagePO> listMktMessage = mktMessagePOMapper.selectByExample(exampl);
            bo.setCouponEntityAndDefinitionVOList(lists);
        if(!CollectionUtils.isEmpty(listMktMessage)){
            bo.setMessageVOList(listMktMessage);
        }

        responseData.setData(bo);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    @Override
    @Transactional
    public ResponseData<Integer> updateActivityAniversary(ActivityBO bo, SysAccountPO stageUser) {{
        log.info("纪念日活动修改开始");
        //返回对象
        ResponseData responseData = new ResponseData();
        //得到大实体类
        ActivityVO activityVO = bo.getActivityVO();
        if(activityVO.getCheckStatus()!=CheckStatusEnum.CHECK_STATUS_PENDING.getCode()||activityVO.getCheckStatus()!=CheckStatusEnum.CHECK_STATUS_REJECTED.getCode()){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("该任务不能修改!");
            return responseData;
        }

        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        BeanUtils.copyProperties(activityVO,mktActivityPOWithBLOBs);
        //job类
        XxlJobInfo xxlJobInfo = new XxlJobInfo();
        xxlJobInfo.setExecutorParam(activityVO.getActivityCode());
        xxlJobInfo.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());

        //查询结果如果不需要审核审核状态为已审核
        mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
        //getStartTime 开始时间>当前时间增加job
        if( new Date().before(activityVO.getStartTime())){
            //活动状态设置为待执行
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
            //先删除原来创建的job任务
            jobClient.removeByBiz(xxlJobInfo);
            //创建任务调度任务开始时间
            jobUtil.addStratAniversaryJob(stageUser,activityVO,mktActivityPOWithBLOBs.getActivityCode());
            //创建任务调度任务结束时间
            jobUtil.addEndAniversaryJob(stageUser,activityVO,mktActivityPOWithBLOBs.getActivityCode());
        }else{
            //活动状态设置为执行中
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
            //发送模板消息和短信消息TODO

        }

        //修改活动主表
        mktActivityPOWithBLOBs.setModifiedDate(new Date());
        mktActivityPOWithBLOBs.setModifiedUserId(stageUser.getSysAccountId());
        mktActivityPOWithBLOBs.setModifiedUserName(stageUser.getName());
        mktActivityPOMapper.updateByPrimaryKeySelective(mktActivityPOWithBLOBs);

        //获取新增后数据id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();


        //修改生日活动表
        MktActivityVipAniversaryPO mktActivityVipAniversaryPO=new MktActivityVipAniversaryPO();
        BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktActivityVipAniversaryPO);
        mktActivityVipAniversaryPO.setMktActivityId(mktActivityId);
        mktActivityVipAniversaryPOMapper.updateByPrimaryKeySelective(mktActivityVipAniversaryPO);

        //先删除在新增
        MktCouponPO record = new MktCouponPO();
        record.setValid(false);
        MktCouponPOExample example = new MktCouponPOExample();
        example.createCriteria().andBizIdEqualTo(mktActivityId);
        mktCouponPOMapper.updateByExampleSelective(record,example);
        //修改券奖励
        List<MktCouponPO> couponCodeList = bo.getCouponCodeList();
        if(!CollectionUtils.isEmpty(couponCodeList)){
            for(MktCouponPO couponCode : couponCodeList){
                MktCouponPO mktCouponPO = new MktCouponPO();
                BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktCouponPO);
                mktCouponPO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
                mktCouponPO.setBizId(mktActivityId);
                mktCouponPO.setCouponName(couponCode.getCouponName());
                mktCouponPO.setCouponDefinitionId(couponCode.getCouponDefinitionId());
                mktCouponPO.setBizId(couponCode.getBizId());
                mktCouponPOMapper.insertSelective(mktCouponPO);
            }
        }


        //先删除在新增
        MktMessagePO message = new MktMessagePO();
        message.setValid(false);
        MktMessagePOExample exam = new MktMessagePOExample();
        exam.createCriteria().andBizIdEqualTo(mktActivityId);
        mktMessagePOMapper.updateByExampleSelective(message,exam);
        //修改活动消息
        List<MktMessagePO> messageVOList = bo.getMessageVOList();
        if(!CollectionUtils.isEmpty(messageVOList)){
            for(MktMessagePO messageVO : messageVOList){
                MktMessagePO mktMessagePO = new MktMessagePO();
                BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktMessagePO);
                BeanUtils.copyProperties(messageVO,mktMessagePO);
                mktMessagePO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
                mktMessagePO.setBizId(mktActivityId);
                mktMessagePOMapper.insertSelective(mktMessagePO);
            }
        }
        log.info("任务修改结束");
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }
    }

    @Override
    @Async("asyncServiceExecutor")
    public void     AniversaryReward(ActivityVO activityAniversary, MemberInfoModel memberInfo) {
        log.info("纪念日活动发送奖励开始");
        Calendar cal = Calendar.getInstance();
        cal.setTime(memberInfo.getOpenCardTime());
        cal.add(Calendar.MONTH, activityAniversary.getRegisterMonths());
        //开卡时间+上满几个月 >当前时间
        if (new Date().before(cal.getTime())){
            return;
        }
        log.info("服务门店为!==========="+memberInfo.getServiceStoreId());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();// 取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 1);// 把日期往后增加一年.整数往后推,负数往前移动
        date = calendar.getTime();
        //明年
        String s1 =sdf.format(date);
        Date toyear = null;
        try {
            toyear = sdf.parse(s1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //今年
        String s2 =sdf.format(new Date());
        Date year = null;
        try {
            year = sdf.parse(s2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //判断当前时间加上发送天数是都是今年还是明年
        //如果为true 说明是今年
        if (true==dateSize(activityAniversary)){
            //判断今年有没有发券
            ResponseData<List<CouponEntityPO>> couponEntityPOs = couponEntityServiceFeign.findCouponHave(memberInfo.getMemberCode(),activityAniversary.getMktActivityId(),s2);
            List<CouponEntityPO> couponEntityPO =couponEntityPOs.getData();
            if (!CollectionUtils.isEmpty(couponEntityPO)){
                return;
            }
            //判断今年有没有发积分
            IntegralRecordVo vs = new IntegralRecordVo();
            vs.setMemberCode(memberInfo.getMemberCode());
            vs.setChangeBills(activityAniversary.getActivityCode());
            vs.setYear(s2);
            ResponseData<List<IntegralRecordModel>> integralRecordModels = integralRecordApiService.queryIntegralRecord(vs);
            List<IntegralRecordModel> integralRecordModel = integralRecordModels.getData();
            if (!CollectionUtils.isEmpty(integralRecordModel)){
                return;
            }
        }else{
            //说明是明年 判断生日加上提前发送天数有没到明年
            //true 说明是到了明年
            if (true==dateMonth(activityAniversary,memberInfo)){
                //判断明年有没有发券
                ResponseData<List<CouponEntityPO>> couponEntityPOs = couponEntityServiceFeign.findCouponHave(memberInfo.getMemberCode(),activityAniversary.getMktActivityId(),s1);
                List<CouponEntityPO> couponEntityPO =couponEntityPOs.getData();
                if (!CollectionUtils.isEmpty(couponEntityPO)){
                    return;
                }
                //判断明年有没有发积分
                IntegralRecordVo vs = new IntegralRecordVo();
                vs.setMemberCode(memberInfo.getMemberCode());
                vs.setChangeBills(activityAniversary.getActivityCode());
                vs.setYear(s1);
                ResponseData<List<IntegralRecordModel>> integralRecordModels = integralRecordApiService.queryIntegralRecord(vs);
                List<IntegralRecordModel> integralRecordModel = integralRecordModels.getData();
                if (!CollectionUtils.isEmpty(integralRecordModel)){
                    return;
                }
            }else{
                //判断今年有没有发券
                ResponseData<List<CouponEntityPO>> couponEntityPOs = couponEntityServiceFeign.findCouponHave(memberInfo.getMemberCode(),activityAniversary.getMktActivityId(),s2);
                List<CouponEntityPO> couponEntityPO =couponEntityPOs.getData();
                if (!CollectionUtils.isEmpty(couponEntityPO)){
                    return;
                }
                //判断今年有没有发积分
                IntegralRecordVo vs = new IntegralRecordVo();
                vs.setMemberCode(memberInfo.getMemberCode());
                vs.setChangeBills(activityAniversary.getActivityCode());
                vs.setYear(s2);
                ResponseData<List<IntegralRecordModel>> integralRecordModels = integralRecordApiService.queryIntegralRecord(vs);
                List<IntegralRecordModel> integralRecordModel = integralRecordModels.getData();
                if (!CollectionUtils.isEmpty(integralRecordModel)){
                    return;
                }
            }

        }
            log.info("执行纪念日活动通过验证通过验证通过验证========");
            //增加积分奖励新增接口
            IntegralChangeRequestModel integralChangeRequestModel =new IntegralChangeRequestModel();
            integralChangeRequestModel.setSysCompanyId(activityAniversary.getSysCompanyId());
            integralChangeRequestModel.setBrandId(activityAniversary.getSysBrandId());
            integralChangeRequestModel.setMemberCode(memberInfo.getMemberCode());
            integralChangeRequestModel.setChangeBills(activityAniversary.getActivityCode());
            integralChangeRequestModel.setChangeIntegral(activityAniversary.getPoints());
            integralChangeRequestModel.setChangeType(IntegralChangeTypeEnum.INCOME.getCode());
            integralChangeRequestModel.setBusinessType(com.bizvane.members.facade.enums.BusinessTypeEnum.TASK_TYPE_MEMORIAL_DAY.getCode());
            integralChangeRequestModel.setChangeDate(new Date());
            log.info("执行纪念日活动开始开始增加积分增加积分++++++");
            IntegralChangeResponseModel integralChangeResponseModel =integralChangeApiService.integralChangeOperate(integralChangeRequestModel);
            log.info("增加积分返回结果为------------："+ JSON.toJSONString(integralChangeResponseModel));
            // 增加卷奖励接口
        // 增加卷奖励接口
        MktCouponPOExample example = new  MktCouponPOExample();
        example.createCriteria().andBizIdEqualTo(activityAniversary.getMktActivityId()).andValidEqualTo(true).andBizTypeEqualTo(1);
        List<MktCouponPO> mktCouponPOs= mktCouponPOMapper.selectByExample(example);
        for (MktCouponPO mktCouponPO:mktCouponPOs) {
            SendCouponSimpleRequestVO va = new SendCouponSimpleRequestVO();
            va.setBusinessName(activityAniversary.getActivityName());
            va.setMemberCode(memberInfo.getMemberCode());
            va.setCouponDefinitionId(mktCouponPO.getCouponDefinitionId());
            va.setSendBussienId(mktCouponPO.getBizId());
            va.setSendType(SendTypeEnum.SEND_COUPON_MEMORY_DAY.getCode());
            va.setBrandId(activityAniversary.getSysBrandId());
            va.setCompanyId(activityAniversary.getSysCompanyId());
            log.info("执行纪念日活动开始开始增加券增加券~~~~~~~~~~");
            ResponseData<String> responseData=sendCouponServiceFeign.simple(va);
            log.info("增加券返回结果为------------："+ JSON.toJSONString(responseData));
        }
            //新增积分到会员参与活动记录表中数据
            MktActivityRecordPO po = new MktActivityRecordPO();
            po.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_ANNIVERSARY.getCode());
            po.setMemberCode(memberInfo.getMemberCode());
            po.setParticipateDate(new Date());
            po.setPoints(activityAniversary.getPoints());
            po.setAcitivityId(activityAniversary.getMktActivityId());
            po.setSysBrandId(activityAniversary.getSysBrandId());
            po.setSysCompanyId(activityAniversary.getSysCompanyId());
            mktActivityRecordPOMapper.insertSelective(po);
            
            mktActivityCountPOMapper.updateSum(po.getAcitivityId(), 1, BigDecimal.ZERO, po.getPoints());

    }
    private Boolean dateMonth(ActivityVO activityBirthday,MemberInfoModel memberInfo) {
        boolean  falg;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date birthday = memberInfo.getOpenCardTime();
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, activityBirthday.getDaysAhead());// num为增加的天数，可以改变的
        birthday = ca.getTime();
        String enddate = format.format(birthday);
        System.out.println("增加天数以后的日期：" + enddate);

        //获取生日月份和增加天数后的月份
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        String s1 = sdf.format(memberInfo.getOpenCardTime());
        String s2 = sdf.format(birthday);
        System.out.println("日期1：" + s1);
        System.out.println("日期1：" + s2);
        if (Integer.parseInt(s1) > Integer.parseInt(s2)){
            falg=true;
        }else{
            falg=false;
        }
        return falg;
    }

    private Boolean dateSize(ActivityVO activityBirthday) {
        boolean  falg;
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //得到当年日期
        String currdate = format.format(d);
        System.out.println("现在的日期是：" + currdate);
        //获取增加天数后得到的日期
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, activityBirthday.getDaysAhead());// num为增加的天数，可以改变的
        d = ca.getTime();
        String enddate = format.format(d);
        System.out.println("增加天数以后的日期：" + enddate);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        //获取当前年份
        String date = sdf.format(new Date());
        System.out.println("获取当前年份：" + date);
        //获取增加日期后得到的年份
        Date today = null;
        try {
            today = format.parse(enddate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formatDate = sdf.format(today);
        System.out.println("增加天数以后的日期得到的年份：" + formatDate);
        if (Integer.parseInt(date)>=Integer.parseInt(formatDate)){
            falg=true;
        }else{
            falg=false;
        }
        return falg;
    }
}
