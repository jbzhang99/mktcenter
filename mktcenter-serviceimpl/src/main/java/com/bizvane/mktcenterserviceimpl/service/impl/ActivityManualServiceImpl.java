package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.centerstageservice.models.po.SysCheckConfigPo;
import com.bizvane.centerstageservice.models.vo.SysCheckConfigVo;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.mktcenterservice.interfaces.ActivityManualService;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.po.MktActivityManualPO;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.utils.JobUtil;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityManualPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktCouponPOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ActivityManualServiceImpl implements ActivityManualService {


    @Autowired
    private MktActivityManualPOMapper mktActivityManualPOMapper;
    @Autowired
    private SysCheckConfigServiceRpc sysCheckConfigServiceRpc;

    @Autowired
    private JobUtil jobUtil;
    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;

    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;
    @Override
    public ResponseData<ActivityVO> getActivityManualList(ActivityVO vo, PageForm  pageForm) {
        ResponseData  responseData  = new ResponseData();
        PageHelper.startPage(pageForm.getPageNum(),pageForm.getPageSize());
        List<ActivityVO> activityManualList =mktActivityManualPOMapper.getActivityManualList(vo);

        PageInfo<ActivityVO>pageInfo = new PageInfo<>(activityManualList);
        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 创建活动
     * @param couponId
     * @param activityVO
     * @param stageUser
     * @return
     */
    @Override
    @Transactional
    public ResponseData<Integer> addActivityManual(Long couponId, ActivityVO activityVO,SysAccountPO stageUser) {
        ResponseData responseData = new ResponseData();
        //对象转换

        activityVO.setCreateUserName(stageUser.getName());
        activityVO.setCreateUserId(stageUser.getSysAccountId());
        activityVO.setCreateDate(new Date());

        //活动编号
        String activityCode = "AC"+ UUID.randomUUID().toString().replaceAll("-", "");
        activityVO.setActivityCode(activityCode);
        //活动类型
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        BeanUtils.copyProperties(activityVO,mktActivityPOWithBLOBs);

        //查询审核配置，是否需要审核然后判断
        SysCheckConfigVo so = new SysCheckConfigVo();
        so.setSysBrandId(activityVO.getSysBrandId());
        ResponseData<List<SysCheckConfigVo>> sysCheckConfigVo =sysCheckConfigServiceRpc.getCheckConfigListAll(so);
        List<SysCheckConfigVo> sysCheckConfigVoList = sysCheckConfigVo.getData();
        //判断是否有审核配置
        int i = 0;
        if(!CollectionUtils.isEmpty(sysCheckConfigVoList)){
            for (SysCheckConfigVo sysCheckConfig:sysCheckConfigVoList) {
                //判断是否需要审核  暂时先写这三个审核类型 后期确定下来写成枚举类
                if(sysCheckConfig.getFunctionCode().equals("C0001") || sysCheckConfig.getFunctionCode().equals("C0002") || sysCheckConfig.getFunctionCode().equals("C0003")){
                    i+=1;
                }
            }
        }
        if(i>0){
            //1.待审核，增加审核单，活动开始时间>今天，待执行
            //查询结果如果需要审核审核状态为待审核
            mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
            //活动状态设置为待执行
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());

            //如果是待审核数据则需要增加一条审核数据
            SysCheckConfigPo configPo = new SysCheckConfigPo();
            configPo.setSysBrandId(mktActivityPOWithBLOBs.getSysBrandId());
            configPo.setFunctionCode(mktActivityPOWithBLOBs.getActivityCode());
            configPo.setFunctionName(mktActivityPOWithBLOBs.getActivityName());
            configPo.setCreateDate(new Date());
            configPo.setCreateUserId(stageUser.getSysAccountId());
            configPo.setCreateUserName(stageUser.getName());
            sysCheckConfigServiceRpc.addCheckConfig(configPo);
            //getStartTime 开始时间>当前时间增加job
            if( new Date().before(activityVO.getStartTime())){
                //创建任务调度任务开始时间
                jobUtil.addJob(stageUser,activityVO,mktActivityPOWithBLOBs,activityCode);
                //创建任务调度任务结束时间
                jobUtil.addJobEndTime(stageUser,activityVO,mktActivityPOWithBLOBs,activityCode);
            }
        }else{
            //查询结果如果不需要审核审核状态为已审核
            mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
            //getStartTime 开始时间>当前时间增加job，待执行
            if(new Date().before(activityVO.getStartTime())){
                //活动状态设置为待执行
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
                //创建任务调度任务开始时间
                jobUtil.addJob(stageUser,activityVO,mktActivityPOWithBLOBs,activityCode);
                //创建任务调度任务结束时间
                jobUtil.addJobEndTime(stageUser,activityVO,mktActivityPOWithBLOBs,activityCode);
            }else{
                //活动状态设置为执行中
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
            }
        }

        //新增活动主表
        mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);
       //返回主表的id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();
        //新增明细表
        MktActivityManualPO mktActivityManualPO = new MktActivityManualPO();
        BeanUtils.copyProperties(activityVO,mktActivityManualPO);
        mktActivityManualPO.setMktActivityId(mktActivityId);
        // todo 券二维码
        mktActivityManualPOMapper.insertSelective(mktActivityManualPO);
        //新增券表,和活动绑定
        MktCouponPO mktCouponPO = new MktCouponPO();
        mktCouponPO.setCouponId(couponId);
        mktCouponPO.setBizId(mktActivityId);//活动id
        mktCouponPO.setBizCode(activityCode);//活动编号
        mktCouponPO.setBizType(1);//业务类型 1.活动改为枚举，不要出现魔数
        mktCouponPO.setModifiedUserId(stageUser.getSysAccountId());
        mktCouponPO.setModifiedUserName(stageUser.getName());
        mktCouponPO.setModifiedDate(new Date());
        mktCouponPO.setCouponName(activityVO.getCouponName());
        mktCouponPO.setCouponCode(activityVO.getCouponCode());
        mktCouponPOMapper.insertSelective(mktCouponPO);
        responseData.setCode(SystemConstants.SUCCESS_CODE);
        responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
        return responseData;
    }

   /* @Override
    public ResponseData<Integer> executeActivity(MemberInfoModel vo) {
      ActivityVO activityVO = new ActivityVO();
      activityVO.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
      activityVO.setSysBrandId(vo.getBrandId());
      //activityVO.setActivityType();
      activityVO.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_QRCODE.getCode());//???
        return null;
    }*/



    @Override
    public ResponseData<ActivityBO> getActivityManualEffect(ActivityVO vo) {

         MktCouponPO mktCouponPO= new MktCouponPO();
        //调券接口查询券信息
        /**
         * 入参：
         * 出参领取张数，核销张数，核销率，券收益
         */
        //查活动信息
       // List<ActivityBO>  activityManualEffectList= mktActivityManualPOMapper.getActivityManualEffect(vo);

        return null;
    }


    @Override
    public ResponseData<ActivityVO> selectActivityManualById(Long mktActivityId){
        ResponseData responseData = new ResponseData();
        ActivityVO vo = new ActivityVO();
        vo.setMktActivityId(mktActivityId);
        List<ActivityVO> activityManualList = mktActivityManualPOMapper.getActivityList(vo);
        responseData.setData(activityManualList);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return null;
    }

}
