package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.shade.com.alibaba.fastjson.JSONObject;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.models.vo.CouponDetailResponseVO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.es.pojo.MembersInfoSearchPojo;
import com.bizvane.members.facade.es.vo.MembersInfoSearchVo;
import com.bizvane.members.facade.models.IntegralRecordModel;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.service.api.MembersAdvancedSearchApiService;
import com.bizvane.members.facade.vo.MemberInfoApiModel;
import com.bizvane.members.facade.vo.MemberInfoVo;
import com.bizvane.messagefacade.models.vo.MemberMessageVO;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.mktcenterservice.interfaces.ActivitySmartService;
import com.bizvane.mktcenterservice.models.bo.ActivitySmartBO;
import com.bizvane.mktcenterservice.models.bo.AwardBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.ActivitySmartVO;
import com.bizvane.mktcenterservice.models.vo.MessageVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterserviceimpl.common.award.Award;
import com.bizvane.mktcenterserviceimpl.common.award.MemberMessageSend;
import com.bizvane.mktcenterserviceimpl.common.constants.ActivityConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.ResponseConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.*;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.job.JobUtil;
import com.bizvane.mktcenterserviceimpl.mappers.*;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/13 18:52
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Service
@Slf4j
public class ActivitySmartServiceImpl implements ActivitySmartService {

    @Autowired
    private MktActivitySmartPOMapper mktActivitySmartPOMapper;

    @Autowired
    private MktActivitySmartGroupPOMapper mktActivitySmartGroupPOMapper;

    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;

    @Autowired
    private JobUtil jobUtil;

    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;

    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;

    @Autowired
    private Award award;

    @Autowired
    private MemberInfoApiService memberInfoApiService;
    @Autowired
    private MembersAdvancedSearchApiService membersAdvancedSearchApiService;
    @Autowired
    private MemberMessageSend memberMessageSend;
    @Autowired
    private CouponQueryServiceFeign couponQueryServiceFeign;
    /**
     * 查询智能营销分组列表(方块)
     * @param vo
     * @return
     */
    @Override
    public ResponseData<PageInfo<MktActivitySmartGroupPO>> getSmartActivityGroupList(ActivitySmartVO vo, PageForm pageForm,SysAccountPO stageUser) {
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.getSmartActivityGroupList param"+"vo:"+ JSON.toJSONString(vo)+"pageForm"+ JSON.toJSONString(pageForm));
        ResponseData responseData = new ResponseData();
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());

        MktActivitySmartGroupPOExample example = new MktActivitySmartGroupPOExample();
        MktActivitySmartGroupPOExample.Criteria criteria = example.createCriteria();
        criteria.andValidEqualTo(Boolean.TRUE);
        //判断是中控列表还是营销列表
        if (null==vo.getType()){
            criteria.andStatusEqualTo(Boolean.TRUE);
        }


        if(!StringUtils.isEmpty(vo.getMemberGroupName())){
            log.warn("vo.getMemberGroupName()) is empty");
            criteria.andMemberGroupNameLike(SystemConstants.LIKE_SYMBOL+vo.getMemberGroupName()+SystemConstants.LIKE_SYMBOL);
        }

        List<MktActivitySmartGroupPO> mktActivitySmartGroupPOS = mktActivitySmartGroupPOMapper.selectByExampleWithBLOBs(example);
        if(!CollectionUtils.isEmpty(mktActivitySmartGroupPOS)){
            //查询数量这个分组会员数量
            for (MktActivitySmartGroupPO mktActivitySmartGroupPO:mktActivitySmartGroupPOS) {

                //判断是中控调用的还是中台
                if (null==vo.getType()){
                    String targetMbr = mktActivitySmartGroupPO.getTargetMbr();
                    ////分页查询会员信息
                    //把高级搜索的条件转换成对象
                    // JSONObject jsonObject=JSONObject.parseObject(targetMbr);
                    // MembersInfoSearchVo membersInfoSearchVo=jsonObject.toJavaObject(MembersInfoSearchVo.class);
                    MembersInfoSearchVo membersInfoSearchVo=JSON.parseObject(targetMbr,MembersInfoSearchVo.class);
                    membersInfoSearchVo.setPageNumber(1);
                    membersInfoSearchVo.setPageSize(1);
                    membersInfoSearchVo.setBrandId(stageUser.getBrandId());
                    log.info("调用高级搜索的参数列表=================="+ JSON.toJSONString(membersInfoSearchVo)+"分页参数++"+membersInfoSearchVo.getPageNumber()+"分页参数2++"+membersInfoSearchVo.getPageSize()+"品牌id+====="+membersInfoSearchVo.getBrandId());
                    //ResponseData<com.bizvane.utils.responseinfo.PageInfo<MemberInfoVo>> memberInfoVoPages = membersAdvancedSearchApiService.search(membersInfoSearchVo);
                    ResponseData<com.bizvane.utils.responseinfo.PageInfo<MembersInfoSearchPojo>> memberInfoVoPages =membersAdvancedSearchApiService.advancedSearch(membersInfoSearchVo);
                    mktActivitySmartGroupPO.setTargetMbrCount((int) memberInfoVoPages.getData().getTotal());

                }

            }
        }


        PageInfo<MktActivitySmartGroupPO> pageInfo = new PageInfo<>(mktActivitySmartGroupPOS);
        if (null==vo.getType()){
            responseData.setData(mktActivitySmartGroupPOS);
        }else{
            responseData.setData(pageInfo);
        }

        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.getSmartActivityGroupList result"+ JSON.toJSONString(responseData));
        return responseData;
    }

    /**
     * 查询历史营销活动列表
     * @param vo
     * @param pageForm
     * @return
     */
    @Override
    public ResponseData<PageInfo<MktActivitySmartPO>> getActivityHistoryList(ActivitySmartVO vo, PageForm pageForm) {
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.getActivityHistoryList param"+"vo:"+ JSON.toJSONString(vo)+"pageForm"+ JSON.toJSONString(pageForm));
        ResponseData responseData = new ResponseData();
        //活动分组id不能为空
       /* if(vo.getMktActivitySmartGroupId()==null){
            log.warn("vo.getMktActivitySmartGroupId() is null");
            responseData.setCode(ResponseConstants.ERROR);
            responseData.setMessage(ActivityConstants.SMART_ACTIVITY_GROUP_ID_EMPTY);
            return responseData;
        }*/
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
        List<ActivitySmartVO> activityList = mktActivitySmartPOMapper.getActivityList(vo);

        PageInfo<ActivitySmartVO> pageInfo = new PageInfo<>(activityList);
        responseData.setData(pageInfo);
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.getActivityHistoryList result"+ JSON.toJSONString(responseData));
        return responseData;
    }

    /**
     * 查询某个智能营销分组
     * @param mktActivitySmartGroupId
     * @return
     */
    @Override
    public ResponseData<MktActivitySmartGroupPO> getSmartActivityGroupById(Long mktActivitySmartGroupId,SysAccountPO stageUser) {
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.getSmartActivityGroupById param"+"mktActivitySmartGroupId:"+ mktActivitySmartGroupId);
        ResponseData responseData = new ResponseData();
        //活动分组id不能为空
        if(mktActivitySmartGroupId==null){
            log.warn("mktActivitySmartGroupId is null");
            responseData.setCode(ResponseConstants.ERROR);
            responseData.setMessage(ActivityConstants.SMART_ACTIVITY_GROUP_ID_EMPTY);
            return responseData;
        }
        MktActivitySmartGroupPO mktActivitySmartGroupPO = mktActivitySmartGroupPOMapper.selectByPrimaryKey(mktActivitySmartGroupId);
        ////////////////////
        //
        if (null!=stageUser.getBrandId()){
            String targetMbr = mktActivitySmartGroupPO.getTargetMbr();
            MembersInfoSearchVo membersInfoSearchVo=JSON.parseObject(targetMbr,MembersInfoSearchVo.class);
            membersInfoSearchVo.setPageNumber(1);
            membersInfoSearchVo.setPageSize(1);
            membersInfoSearchVo.setBrandId(stageUser.getBrandId());
            log.info("调用高级搜索的参数列表=================="+ JSON.toJSONString(membersInfoSearchVo)+"分页参数++"+membersInfoSearchVo.getPageNumber()+"分页参数2++"+membersInfoSearchVo.getPageSize()+"品牌id+====="+membersInfoSearchVo.getBrandId());
            //ResponseData<com.bizvane.utils.responseinfo.PageInfo<MemberInfoVo>> memberInfoVoPages = membersAdvancedSearchApiService.search(membersInfoSearchVo);
            ResponseData<com.bizvane.utils.responseinfo.PageInfo<MembersInfoSearchPojo>> memberInfoVoPages =membersAdvancedSearchApiService.advancedSearch(membersInfoSearchVo);
            mktActivitySmartGroupPO.setTargetMbrCount((int) memberInfoVoPages.getData().getTotal());
        }


        /////////////////////////
        responseData.setData(mktActivitySmartGroupPO);
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.getSmartActivityGroupById result"+ JSON.toJSONString(responseData));
        return responseData;
    }

    /**
     * 查询某个智能营销活动详情
     * @param mktActivityId
     * @return
     */
    @Override
    public ResponseData<ActivitySmartVO> getActivityDetailById(Long mktActivityId,Integer mktSmartType) {
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.getActivityDetailById param"+"mktActivityId:"+ mktActivityId+"mktSmartType:"+mktSmartType);
        ResponseData responseData = new ResponseData();
        //活动分组id不能为空
        if(mktActivityId==null){
            log.warn("mktActivityId is null");
            responseData.setCode(ResponseConstants.ERROR);
            responseData.setMessage(ActivityConstants.ERROR_MSG_ACTIVITY_ID_EMPTY);
            return responseData;
        }

        MktSmartTypeEnum mktSmartTypeEnum = MktSmartTypeEnum.getMktSmartTypeEnumByCode(mktSmartType);
        if(mktSmartTypeEnum==null){
            log.warn("mktSmartTypeEnum is null");
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.MODEL_FAILED_VALIDATION.getMessage());
            return responseData;
        }
        switch (mktSmartTypeEnum){
            case SMART_TYPE_COUPON:
                log.info("match with SMART_TYPE_COUPON");
                responseData =getCouponActivityDetailById(mktActivityId);
                break;
            case SMART_TYPE_INTEGRAL:
                log.info("match with SMART_TYPE_INTEGRAL");
                responseData =getIntegralActivityDetailById(mktActivityId);
                break;
            case SMART_TYPE_SMS:
                log.info("match with SMART_TYPE_SMS");
                responseData =getSmsActivityDetailById(mktActivityId);
                break;
            case SMART_TYPE_WXMESSAGE:
                log.info("match with SMART_TYPE_WXMESSAGE");
                responseData =getWxmessageActivityDetailById(mktActivityId);
                break;
            default:break;
        }
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.getActivityDetailById result"+ JSON.toJSONString(responseData));
        return responseData;
    }

    /**
     * 查询券营销详情
     * @return
     */
    public ResponseData<ActivitySmartVO> getCouponActivityDetailById(Long mktActivityId){
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.getCouponActivityDetailById param"+"mktActivityId:"+ mktActivityId);
        ResponseData responseData = new ResponseData();
        ActivitySmartVO activitySmartVO = new ActivitySmartVO();

        //智能营销规则表
        MktActivitySmartPOExample mktActivitySmartPOExample = new MktActivitySmartPOExample();
        mktActivitySmartPOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andMktActivityIdEqualTo(mktActivityId).andMktSmartTypeEqualTo(MktSmartTypeEnum.SMART_TYPE_COUPON.getCode());
        List<MktActivitySmartPO> mktActivitySmartPOS = mktActivitySmartPOMapper.selectByExampleWithBLOBs(mktActivitySmartPOExample);
        if(CollectionUtils.isEmpty(mktActivitySmartPOS)){
            log.warn("mktActivitySmartPOS is empty");
            responseData.setCode(ResponseConstants.ERROR);
            responseData.setMessage(ResponseConstants.DATA_NOT_EXIST);
            return responseData;
        }

        //主表
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = mktActivityPOMapper.selectByPrimaryKey(mktActivityId);
        BeanUtils.copyProperties(mktActivityPOWithBLOBs,activitySmartVO);

        activitySmartVO.setTargetMbr(mktActivitySmartPOS.get(0).getTargetMbr());

        //券表
        MktCouponPOExample mktCouponPOExample = new MktCouponPOExample();
        mktCouponPOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andBizTypeEqualTo(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode()).andBizIdEqualTo(mktActivityId);
        List<MktCouponPO> mktCouponPOS = mktCouponPOMapper.selectByExample(mktCouponPOExample);
        //拿到发送时间和是否时是立即发送
        activitySmartVO.setSendImmediately(mktCouponPOS.get(0).getSendImmediately());
        activitySmartVO.setSendTime(mktCouponPOS.get(0).getSendTime());
        List<CouponDetailResponseVO> lists = new ArrayList<>();
        //通过券定义id查询券详细信息
        if(!CollectionUtils.isEmpty(mktCouponPOS)){
            for (MktCouponPO po:mktCouponPOS) {
                ResponseData<CouponDetailResponseVO>  entityAndDefinition = couponQueryServiceFeign.getCouponDefinition(po.getCouponDefinitionId());
                lists.add(entityAndDefinition.getData());
            }
        }
        activitySmartVO.setCouponDetailResponseVOList(lists);
        responseData.setData(activitySmartVO);
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.getCouponActivityDetailById result"+ JSON.toJSONString(responseData));
        return responseData;
    }

    /**
     * 查询积分营销详情
     * @return
     */
    public ResponseData<ActivitySmartVO> getIntegralActivityDetailById(Long mktActivityId){
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.getIntegralActivityDetailById param"+"mktActivityId:"+ mktActivityId);
        ResponseData responseData = new ResponseData();
        ActivitySmartVO activitySmartVO = new ActivitySmartVO();

        //智能营销规则表
        MktActivitySmartPOExample mktActivitySmartPOExample = new MktActivitySmartPOExample();
        mktActivitySmartPOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andMktActivityIdEqualTo(mktActivityId).andMktSmartTypeEqualTo(MktSmartTypeEnum.SMART_TYPE_INTEGRAL.getCode());
        List<MktActivitySmartPO> mktActivitySmartPOS = mktActivitySmartPOMapper.selectByExample(mktActivitySmartPOExample);
        if(CollectionUtils.isEmpty(mktActivitySmartPOS)){
            log.warn("mktActivitySmartPOS is empty");
            responseData.setCode(ResponseConstants.ERROR);
            responseData.setMessage(ResponseConstants.DATA_NOT_EXIST);
            return responseData;
        }

        //主表
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = mktActivityPOMapper.selectByPrimaryKey(mktActivityId);
        BeanUtils.copyProperties(mktActivityPOWithBLOBs,activitySmartVO);
        activitySmartVO.setTargetMbr(mktActivitySmartPOS.get(0).getTargetMbr());

        responseData.setData(activitySmartVO);
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.getIntegralActivityDetailById result"+ JSON.toJSONString(responseData));
        return responseData;
    }

    /**
     * 查询短信营销详情
     * @return
     */
    public ResponseData<ActivitySmartVO> getSmsActivityDetailById(Long mktActivityId){
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.getSmsActivityDetailById param"+"mktActivityId:"+ mktActivityId);
        ResponseData responseData = new ResponseData();
        ActivitySmartVO activitySmartVO = new ActivitySmartVO();

        //智能营销规则表
        MktActivitySmartPOExample mktActivitySmartPOExample = new MktActivitySmartPOExample();
        mktActivitySmartPOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andMktActivityIdEqualTo(mktActivityId).andMktSmartTypeEqualTo(MktSmartTypeEnum.SMART_TYPE_SMS.getCode());
        List<MktActivitySmartPO> mktActivitySmartPOS = mktActivitySmartPOMapper.selectByExample(mktActivitySmartPOExample);
        if(CollectionUtils.isEmpty(mktActivitySmartPOS)){
            log.warn("mktActivitySmartPOS is empty");
            responseData.setCode(ResponseConstants.ERROR);
            responseData.setMessage(ResponseConstants.DATA_NOT_EXIST);
            return responseData;
        }

        //主表
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = mktActivityPOMapper.selectByPrimaryKey(mktActivityId);
        BeanUtils.copyProperties(mktActivityPOWithBLOBs,activitySmartVO);
        activitySmartVO.setTargetMbr(mktActivitySmartPOS.get(0).getTargetMbr());
        //消息表
        MktMessagePOExample mktMessagePOExample = new MktMessagePOExample();
        mktMessagePOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andBizTypeEqualTo(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode()).andBizIdEqualTo(mktActivityId);
        List<MktMessagePO> mktMessagePOS = mktMessagePOMapper.selectByExampleWithBLOBs(mktMessagePOExample);
        if(!CollectionUtils.isEmpty(mktMessagePOS)){
            activitySmartVO.setMktMessagePO(mktMessagePOS.get(0));
        }
        responseData.setData(activitySmartVO);
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.getSmsActivityDetailById result"+ JSON.toJSONString(responseData));
        return responseData;
    }

    /**
     * 查询模板消息营销详情
     * @return
     */
    public ResponseData<ActivitySmartVO> getWxmessageActivityDetailById(Long mktActivityId){
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.getWxmessageActivityDetailById param"+"mktActivityId:"+ mktActivityId);
        ResponseData responseData = new ResponseData();
        ActivitySmartVO activitySmartVO = new ActivitySmartVO();

        //智能营销规则表
        MktActivitySmartPOExample mktActivitySmartPOExample = new MktActivitySmartPOExample();
        mktActivitySmartPOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andMktActivityIdEqualTo(mktActivityId).andMktSmartTypeEqualTo(MktSmartTypeEnum.SMART_TYPE_WXMESSAGE.getCode());
        List<MktActivitySmartPO> mktActivitySmartPOS = mktActivitySmartPOMapper.selectByExample(mktActivitySmartPOExample);
        if(CollectionUtils.isEmpty(mktActivitySmartPOS)){
            log.warn("mktActivitySmartPOS is empty");
            responseData.setCode(ResponseConstants.ERROR);
            responseData.setMessage(ResponseConstants.DATA_NOT_EXIST);
            return responseData;
        }

        //主表
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = mktActivityPOMapper.selectByPrimaryKey(mktActivityId);
        BeanUtils.copyProperties(mktActivityPOWithBLOBs,activitySmartVO);
        activitySmartVO.setTargetMbr(mktActivitySmartPOS.get(0).getTargetMbr());
        //消息表
        MktMessagePOExample mktMessagePOExample = new MktMessagePOExample();
        mktMessagePOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andBizTypeEqualTo(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode()).andBizIdEqualTo(mktActivityId);
        List<MktMessagePO> mktMessagePOS = mktMessagePOMapper.selectByExampleWithBLOBs(mktMessagePOExample);
        if(!CollectionUtils.isEmpty(mktMessagePOS)){
            activitySmartVO.setMktMessagePO(mktMessagePOS.get(0));
        }
        responseData.setData(activitySmartVO);
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.getWxmessageActivityDetailById result"+ JSON.toJSONString(responseData));
        return responseData;
    }

    /**
     * 添加智能营销分组
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Integer> addSmartActivityGroup(ActivitySmartVO vo) {
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.addSmartActivityGroup param"+"vo:"+ JSON.toJSONString(vo));
        ResponseData responseData = new ResponseData();

        //营销名称为空
        if(StringUtils.isEmpty(vo.getMemberGroupName())){
            log.warn("vo.getMemberGroupName() is empty");
            responseData.setCode(ResponseConstants.ERROR);
            responseData.setMessage(ActivityConstants.SMART_ACTIVITY_TASK_NAME_EMPTY);
            return responseData;
        }

        //会员条件
        if(StringUtils.isEmpty(vo.getTargetMbr())){
            log.warn("vo.getTargetMbr() is empty");
            responseData.setCode(ResponseConstants.ERROR);
            responseData.setMessage(ActivityConstants.SMART_ACTIVITY_TARGET_MEMBER_EMPTY);
            return responseData;
        }
        MktActivitySmartGroupPO mktActivitySmartPO = new MktActivitySmartGroupPO();
        BeanUtils.copyProperties(vo,mktActivitySmartPO);

        mktActivitySmartPO.setMemberGroupCode(CodeUtil.getMemberGroupCode());
        mktActivitySmartGroupPOMapper.insertSelective(mktActivitySmartPO);
        responseData.setMessage(ResponseConstants.SUCCESS_MSG);
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.addSmartActivityGroup result"+ JSON.toJSONString(responseData));
        return responseData;
    }

    /**
     * 修改智能营销分组
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Integer> updateSmartActivityGroup(ActivitySmartVO vo) {
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.updateSmartActivityGroup param"+"vo:"+ JSON.toJSONString(vo));
        ResponseData responseData = new ResponseData();

        if(vo.getMktActivitySmartGroupId()==null){
            log.warn("vo.getMktActivitySmartGroupId() is null");
            responseData.setCode(ResponseConstants.ERROR);
            responseData.setMessage(ActivityConstants.SMART_ACTIVITY_GROUP_ID_EMPTY);
            return responseData;
        }
        //营销名称为空
        if(StringUtils.isEmpty(vo.getMemberGroupName())){
            log.warn("vo.getMemberGroupName() is empty");
            responseData.setCode(ResponseConstants.ERROR);
            responseData.setMessage(ActivityConstants.SMART_ACTIVITY_TASK_NAME_EMPTY);
            return responseData;
        }

        //会员条件
        if(StringUtils.isEmpty(vo.getTargetMbr())){
            log.warn("vo.getTargetMbr() is empty");
            responseData.setCode(ResponseConstants.ERROR);
            responseData.setMessage(ActivityConstants.SMART_ACTIVITY_TARGET_MEMBER_EMPTY);
            return responseData;
        }
        MktActivitySmartGroupPO mktActivitySmartPO = new MktActivitySmartGroupPO();
        BeanUtils.copyProperties(vo,mktActivitySmartPO);
        mktActivitySmartGroupPOMapper.updateByPrimaryKeySelective(mktActivitySmartPO);
        responseData.setMessage(ResponseConstants.SUCCESS_MSG);
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.updateSmartActivityGroup result"+ JSON.toJSONString(responseData));
        return responseData;
    }

    /**
     * 启用/禁用智能营销分组
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Integer> updateSmartActivityGroupStatus(ActivitySmartVO vo) {
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.updateSmartActivityGroupStatus param"+"vo:"+ JSON.toJSONString(vo));
        ResponseData responseData = new ResponseData();
        MktActivitySmartGroupPO mktActivitySmartPO = new MktActivitySmartGroupPO();
        BeanUtils.copyProperties(vo,mktActivitySmartPO);
        mktActivitySmartGroupPOMapper.updateByPrimaryKeySelective(mktActivitySmartPO);
        responseData.setMessage(ResponseConstants.SUCCESS_MSG);
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.updateSmartActivityGroupStatus result"+ JSON.toJSONString(responseData));
        return responseData;
    }

    /**
     * 删除智能营销分组
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Integer> deleteSmartActivityGroup(ActivitySmartVO vo) {
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.deleteSmartActivityGroup param"+"vo:"+ JSON.toJSONString(vo));
        ResponseData responseData = new ResponseData();
        MktActivitySmartGroupPO mktActivitySmartPO = new MktActivitySmartGroupPO();
        BeanUtils.copyProperties(vo,mktActivitySmartPO);
        mktActivitySmartPO.setValid(Boolean.FALSE);
        mktActivitySmartGroupPOMapper.updateByPrimaryKeySelective(mktActivitySmartPO);
        responseData.setMessage(ResponseConstants.SUCCESS_MSG);
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.deleteSmartActivityGroup result"+ JSON.toJSONString(responseData));
        return responseData;
    }

    /**
     * 复制智能营销分组
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Integer> copySmartActivityGroup(ActivitySmartVO vo) {
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.copySmartActivityGroup param"+"vo:"+ JSON.toJSONString(vo));
        ResponseData responseData = new ResponseData();

        MktActivitySmartGroupPO mktActivitySmartGroupPO = mktActivitySmartGroupPOMapper.selectByPrimaryKey(vo.getMktActivitySmartGroupId());

        mktActivitySmartGroupPO.setCreateDate(new Date());
        mktActivitySmartGroupPO.setCreateUserId(vo.getCreateUserId());
        mktActivitySmartGroupPO.setCreateUserName(vo.getCreateUserName());

        mktActivitySmartGroupPO.setModifiedDate(null);
        mktActivitySmartGroupPO.setModifiedUserId(null);
        mktActivitySmartGroupPO.setModifiedUserName(null);

        mktActivitySmartGroupPO.setMemberGroupCode(CodeUtil.getMemberGroupCode());
        mktActivitySmartGroupPO.setMemberGroupName(mktActivitySmartGroupPO.getMemberGroupName()+ActivityConstants.SMART_ACTIVITY_COPY);

        mktActivitySmartGroupPOMapper.insertSelective(mktActivitySmartGroupPO);

        responseData.setMessage(ResponseConstants.SUCCESS_MSG);
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.copySmartActivityGroup result"+ JSON.toJSONString(responseData));
        return responseData;
    }

    /**
     * 对某个智能营销组创建任务，需要给mktSmartActivityGroupId
     * 任务类型：1优惠券营销
     * @return
     */
    @Override
    public ResponseData<Integer> addCouponActivity(ActivitySmartVO vo, SysAccountPO stageUser) {
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.addCouponActivity param"+"vo:"+ JSON.toJSONString(vo)+"stageUser:"+JSON.toJSONString(stageUser));
        ResponseData responseData = new ResponseData();

        if(vo==null){
            log.warn("vo is null");
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.MODEL_FAILED_VALIDATION.getMessage());
            return responseData;
        }

        //关联的智能营销分组不能为空
        if(null==vo.getMktActivitySmartGroupId()  && vo.getSmartType()==1){
            log.warn("vo.getMktActivitySmartGroupId() is null");
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.MODEL_FAILED_VALIDATION.getMessage());
            return responseData;
        }

        vo.setCreateUserId(stageUser.getSysAccountId());
        vo.setCreateDate(new Date());
        vo.setCreateUserName(stageUser.getName());
        vo.setSysBrandId(stageUser.getBrandId());
        vo.setSysCompanyId(stageUser.getSysCompanyId());

        //生成活动编号
        String activityCode = CodeUtil.getActivityCode();
        vo.setActivityCode(activityCode);
        //拷贝属性
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        BeanUtils.copyProperties(vo,mktActivityPOWithBLOBs);
        //活动编号
        mktActivityPOWithBLOBs.setActivityCode(activityCode);
        mktActivityPOWithBLOBs.setSysCompanyId(stageUser.getSysCompanyId());
        mktActivityPOWithBLOBs.setSysBrandId(stageUser.getBrandId());
        mktActivityPOWithBLOBs.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_SMART.getCode());
        mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());

        Boolean execute = Boolean.FALSE;

      /*  if(vo.getSendTime()==null){
            log.warn("vo.getSendTime() is null");
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.MODEL_FAILED_VALIDATION.getMessage());
            return responseData;
        }*/

        if (false==vo.getSendImmediately()){
            //如果活动时间滞后
            if(new Date().before(vo.getSendTime())){
                log.info("new Date().before(vo.getSendTime()) is true");
                //活动状态设置为待执行
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
                //创建任务调度
                vo.setMktSmartType(MktSmartTypeEnum.SMART_TYPE_COUPON_BATCH.getCode());
                jobUtil.addSmartActivityJob(stageUser,vo);
            }else{
                //活动状态设置为执行中
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
                //需要立即执行
                execute = Boolean.TRUE;
            }
        }else{
            execute = Boolean.TRUE;
        }

        //新增活动主表
        mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);
        //获取新增后数据id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();

        //新增智能营销表
        MktActivitySmartPO mktActivitySmartPO = new MktActivitySmartPO();
        BeanUtils.copyProperties(vo,mktActivitySmartPO);
        mktActivitySmartPO.setMktActivityId(mktActivityId);
        mktActivitySmartPO.setMktSmartType(MktSmartTypeEnum.SMART_TYPE_COUPON.getCode());
        mktActivitySmartPOMapper.insertSelective(mktActivitySmartPO);

        //新增奖励券表
        if(!CollectionUtils.isEmpty(vo.getMktCouponPOS())){
            log.info("vo.getMktCouponPOS()) is not empty");
            for(MktCouponPO mktCouponPO : vo.getMktCouponPOS()){
                mktCouponPO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
                mktCouponPO.setBizId(mktActivityId);
                mktCouponPO.setCreateDate(new Date());
                mktCouponPO.setCreateUserId(stageUser.getSysAccountId());
                mktCouponPO.setCreateUserName(stageUser.getName());
                mktCouponPO.setSendImmediately(vo.getSendImmediately());
                mktCouponPO.setSendTime(vo.getSendTime());
                mktCouponPOMapper.insertSelective(mktCouponPO);
            }
        }

        //立即执行
        if(execute) {
            String targetMbr = vo.getTargetMbr();
            ////分页查询会员信息
            //把高级搜索的条件转换成对象
            // JSONObject jsonObject=JSONObject.parseObject(targetMbr);
            // MembersInfoSearchVo membersInfoSearchVo=jsonObject.toJavaObject(MembersInfoSearchVo.class);
            MembersInfoSearchVo membersInfoSearchVo=JSON.parseObject(targetMbr,MembersInfoSearchVo.class);
            membersInfoSearchVo.setPageNumber(1);
            membersInfoSearchVo.setPageSize(1000);
            membersInfoSearchVo.setBrandId(stageUser.getBrandId());
            membersInfoSearchVo.setSysCompanyId(stageUser.getSysCompanyId());
            log.info("调用高级搜索的参数列表=================="+ JSON.toJSONString(membersInfoSearchVo));
            memberMessageSend.sendMemberCoupon(vo, membersInfoSearchVo);
        }
        responseData.setMessage(ResponseConstants.SUCCESS_MSG);
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.addCouponActivity result"+ JSON.toJSONString(responseData));
        return responseData;
    }


    /**
     * 对某个智能营销组创建任务
     * 任务类型：2积分营销
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Integer> addIntegralActivity(ActivitySmartVO vo, SysAccountPO stageUser) {
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.addIntegralActivity param"+"vo:"+ JSON.toJSONString(vo)+"stageUser:"+JSON.toJSONString(stageUser));
        ResponseData responseData = new ResponseData();

        if(vo==null){
            log.warn("vo is null");
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.MODEL_FAILED_VALIDATION.getMessage());
            return responseData;
        }

        //关联的智能营销分组不能为空
        if(null==vo.getMktActivitySmartGroupId()  && vo.getSmartType()==1){
            log.warn("vo.getMktActivitySmartGroupId() is null");
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.MODEL_FAILED_VALIDATION.getMessage());
            return responseData;
        }

        vo.setCreateUserId(stageUser.getSysAccountId());
        vo.setCreateDate(new Date());
        vo.setCreateUserName(stageUser.getName());
        vo.setSysBrandId(stageUser.getBrandId());
        vo.setSysCompanyId(stageUser.getSysCompanyId());

        //生成活动编号
        String activityCode = CodeUtil.getActivityCode();
        vo.setActivityCode(activityCode);
        //拷贝属性
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        BeanUtils.copyProperties(vo,mktActivityPOWithBLOBs);
        //活动编号
        mktActivityPOWithBLOBs.setActivityCode(activityCode);
        mktActivityPOWithBLOBs.setSysCompanyId(stageUser.getSysCompanyId());
        mktActivityPOWithBLOBs.setSysBrandId(stageUser.getBrandId());
        mktActivityPOWithBLOBs.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_SMART.getCode());
        mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());

        Boolean execute = Boolean.FALSE;
        /*if(vo.getSendTime()==null){
            log.warn("vo.getSendTime() is null");
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.MODEL_FAILED_VALIDATION.getMessage());
            return responseData;
        }*/
        if (false==vo.getSendImmediately()){
            //如果活动时间滞后
            if(new Date().before(vo.getSendTime())){
                log.warn("vnew Date().before(vo.getSendTime()) is true");
                //活动状态设置为待执行
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
                vo.setMktSmartType(MktSmartTypeEnum.SMART_TYPE_INTEGRAL.getCode());
                //创建任务调度
                jobUtil.addSmartActivityJob(stageUser,vo);
            }else{
                //活动状态设置为执行中
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
                //需要立即执行
                execute = Boolean.TRUE;
            }
        }else{
            execute = Boolean.TRUE;
        }

        //新增活动主表
        mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);
        //获取新增后数据id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();

        //新增智能营销表
        MktActivitySmartPO mktActivitySmartPO = new MktActivitySmartPO();
        BeanUtils.copyProperties(vo,mktActivitySmartPO);
        mktActivitySmartPO.setMktActivityId(mktActivityId);
        mktActivitySmartPO.setMktSmartType(MktSmartTypeEnum.SMART_TYPE_INTEGRAL.getCode());
        mktActivitySmartPOMapper.insertSelective(mktActivitySmartPO);

        //立即执行
        if(execute){
            //根据条件获取人，再遍历
            String targetMbr = vo.getTargetMbr();
            ////分页查询会员信息
            //把高级搜索的条件转换成对象
            // JSONObject jsonObject=JSONObject.parseObject(targetMbr);
            // MembersInfoSearchVo membersInfoSearchVo=jsonObject.toJavaObject(MembersInfoSearchVo.class);
            MembersInfoSearchVo membersInfoSearchVo=JSON.parseObject(targetMbr,MembersInfoSearchVo.class);
            membersInfoSearchVo.setPageNumber(1);
            membersInfoSearchVo.setPageSize(1000);
            membersInfoSearchVo.setBrandId(stageUser.getBrandId());
            membersInfoSearchVo.setSysCompanyId(stageUser.getSysCompanyId());
            log.info("智能营销调用高级搜索的参数列表+++++++==================");
            log.info("调用高级搜索的参数列表=================="+ JSON.toJSONString(membersInfoSearchVo));
            memberMessageSend.sendMemberPoints(vo, activityCode, membersInfoSearchVo);

        }

        responseData.setMessage(ResponseConstants.SUCCESS_MSG);
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.addIntegralActivity result"+ JSON.toJSONString(responseData));
        return responseData;
    }


    /**
     * 对某个智能营销组创建任务
     * 任务类型：3短信营销
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Integer> addSmsActivity(ActivitySmartVO vo, MessageVO messageVO, SysAccountPO stageUser) {
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.addSmsActivity param"+"vo:"+ JSON.toJSONString(vo)+"stageUser:"+JSON.toJSONString(stageUser));
        ResponseData responseData = new ResponseData();

        if(vo==null){
            log.warn("vo is null");
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.MODEL_FAILED_VALIDATION.getMessage());
            return responseData;
        }

        //关联的智能营销分组不能为空
        if(null==vo.getMktActivitySmartGroupId()  && vo.getSmartType()==1){
            log.warn("vo.getMktActivitySmartGroupId() is null");
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.MODEL_FAILED_VALIDATION.getMessage());
            return responseData;
        }

        vo.setCreateUserId(stageUser.getSysAccountId());
        vo.setCreateDate(new Date());
        vo.setCreateUserName(stageUser.getName());
        vo.setSysBrandId(stageUser.getBrandId());
        vo.setSysCompanyId(stageUser.getSysCompanyId());

        //生成活动编号
        String activityCode = CodeUtil.getActivityCode();
        vo.setActivityCode(activityCode);
        //拷贝属性
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        BeanUtils.copyProperties(vo,mktActivityPOWithBLOBs);
        //活动编号
        mktActivityPOWithBLOBs.setActivityCode(activityCode);
        mktActivityPOWithBLOBs.setSysCompanyId(stageUser.getSysCompanyId());
        mktActivityPOWithBLOBs.setSysBrandId(stageUser.getBrandId());
        mktActivityPOWithBLOBs.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_SMART.getCode());
        mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());

        Boolean execute = Boolean.FALSE;
     /*   if(vo.getSendTime()==null){
            log.warn("vo.getSendTime() is null");
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.MODEL_FAILED_VALIDATION.getMessage());
            return responseData;
        }*/
        if (false==vo.getSendImmediately()){
            //如果活动时间滞后
            if(new Date().before(vo.getSendTime())){
                log.info("new Date().before(vo.getSendTime()) is true");
                //活动状态设置为待执行
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
                vo.setMktSmartType(MktSmartTypeEnum.SMART_TYPE_SMS.getCode());
                //创建任务调度
                jobUtil.addSmartActivityJob(stageUser,vo);
            }else{
                //活动状态设置为执行中
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
                //需要立即执行
                execute = Boolean.TRUE;
            }
        }else {
            execute = Boolean.TRUE;
        }

        //新增活动主表
        mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);
        //获取新增后数据id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();

        //新增智能营销表
        MktActivitySmartPO mktActivitySmartPO = new MktActivitySmartPO();
        BeanUtils.copyProperties(vo,mktActivitySmartPO);
        mktActivitySmartPO.setMktActivityId(mktActivityId);
        mktActivitySmartPO.setMktSmartType(MktSmartTypeEnum.SMART_TYPE_SMS.getCode());
        mktActivitySmartPOMapper.insertSelective(mktActivitySmartPO);

        //新增消息表
        MktMessagePO mktMessagePO = new MktMessagePO();
        BeanUtils.copyProperties(messageVO,mktMessagePO);
        mktMessagePO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
        mktMessagePO.setBizId(mktActivityId);
        mktMessagePO.setCreateDate(new Date());
        mktMessagePO.setCreateUserId(stageUser.getSysAccountId());
        mktMessagePO.setCreateUserName(stageUser.getName());
        mktMessagePO.setSendImmediately(vo.getSendImmediately());
        mktMessagePO.setSendTime(vo.getSendTime());
        mktMessagePOMapper.insertSelective(mktMessagePO);

        //立即执行
        if(execute){
            String targetMbr = vo.getTargetMbr();
            ////分页查询会员信息
            //把高级搜索的条件转换成对象
            // JSONObject jsonObject=JSONObject.parseObject(targetMbr);
            // MembersInfoSearchVo membersInfoSearchVo=jsonObject.toJavaObject(MembersInfoSearchVo.class);
            MembersInfoSearchVo membersInfoSearchVo=JSON.parseObject(targetMbr,MembersInfoSearchVo.class);
            membersInfoSearchVo.setPageNumber(1);
            membersInfoSearchVo.setPageSize(1000);
            membersInfoSearchVo.setBrandId(stageUser.getBrandId());
            membersInfoSearchVo.setSysCompanyId(stageUser.getSysCompanyId());
            memberMessageSend.sendShortMessage(mktMessagePO, membersInfoSearchVo);
        }

        responseData.setMessage(ResponseConstants.SUCCESS_MSG);
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.addSmsActivity result"+ JSON.toJSONString(responseData));
        return responseData;
    }


    /**
     * 对某个智能营销组创建任务
     * 任务类型：4微信模板消息
     * @param vo
     * @param messageVO
     * @param stageUser
     * @return
     */
    @Override
    public ResponseData<Integer> addWxMessageActivity(ActivitySmartVO vo, MessageVO messageVO, SysAccountPO stageUser) {
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.addWxMessageActivity param"+"vo:"+ JSON.toJSONString(vo)+"messageVO:"+ JSON.toJSONString(messageVO)+"stageUser:"+JSON.toJSONString(stageUser));
        ResponseData responseData = new ResponseData();

        if(vo==null){
            log.warn("vo is null");
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.MODEL_FAILED_VALIDATION.getMessage());
            return responseData;
        }

        //关联的智能营销分组不能为空
        if(null==vo.getMktActivitySmartGroupId() && vo.getSmartType()==1){
            log.warn("vo.getMktActivitySmartGroupId() is null");
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.MODEL_FAILED_VALIDATION.getMessage());
            return responseData;
        }

        vo.setCreateUserId(stageUser.getSysAccountId());
        vo.setCreateDate(new Date());
        vo.setCreateUserName(stageUser.getName());
        vo.setSysBrandId(stageUser.getBrandId());
        vo.setSysCompanyId(stageUser.getSysCompanyId());

        //生成活动编号
        String activityCode = CodeUtil.getActivityCode();
        vo.setActivityCode(activityCode);
        //拷贝属性
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        BeanUtils.copyProperties(vo,mktActivityPOWithBLOBs);
        //活动编号
        mktActivityPOWithBLOBs.setActivityCode(activityCode);
        mktActivityPOWithBLOBs.setSysCompanyId(stageUser.getSysCompanyId());
        mktActivityPOWithBLOBs.setSysBrandId(stageUser.getBrandId());
        mktActivityPOWithBLOBs.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_SMART.getCode());
        mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());

        Boolean execute = Boolean.FALSE;
        /*if(vo.getSendTime()==null){
            log.warn("vo.getSendTime() is null");
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.MODEL_FAILED_VALIDATION.getMessage());
            return responseData;
        }*/
        //判断是不是需要立即发送
        if (false==vo.getSendImmediately()){
            //如果活动时间滞后
            if(new Date().before(vo.getSendTime())){
                log.info("new Date().before(vo.getSendTime()) is true");
                //活动状态设置为待执行
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
                vo.setMktSmartType(MktSmartTypeEnum.SMART_TYPE_WXMESSAGE.getCode());
                //创建任务调度
                jobUtil.addSmartActivityJob(stageUser,vo);
            }else{
                //活动状态设置为执行中
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
                //需要立即执行
                execute = Boolean.TRUE;
            }
        }else {
            execute = Boolean.TRUE;
        }

        //新增活动主表
        mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);
        //获取新增后数据id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();

        //新增智能营销表
        MktActivitySmartPO mktActivitySmartPO = new MktActivitySmartPO();
        BeanUtils.copyProperties(vo,mktActivitySmartPO);
        mktActivitySmartPO.setMktActivityId(mktActivityId);
        mktActivitySmartPO.setMktSmartType(MktSmartTypeEnum.SMART_TYPE_WXMESSAGE.getCode());
        mktActivitySmartPOMapper.insertSelective(mktActivitySmartPO);

        //新增消息表
        MktMessagePO mktMessagePO = new MktMessagePO();
        BeanUtils.copyProperties(messageVO,mktMessagePO);
        mktMessagePO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
        mktMessagePO.setBizId(mktActivityId);
        mktMessagePO.setCreateDate(new Date());
        mktMessagePO.setCreateUserId(stageUser.getSysAccountId());
        mktMessagePO.setCreateUserName(stageUser.getName());
        mktMessagePO.setSendImmediately(vo.getSendImmediately());
        mktMessagePO.setSendTime(vo.getSendTime());
        mktMessagePOMapper.insertSelective(mktMessagePO);

        //立即执行
        if(execute){
            String targetMbr = vo.getTargetMbr();
            ////分页查询会员信息
            //把高级搜索的条件转换成对象
            // JSONObject jsonObject=JSONObject.parseObject(targetMbr);
            // MembersInfoSearchVo membersInfoSearchVo=jsonObject.toJavaObject(MembersInfoSearchVo.class);
            MembersInfoSearchVo membersInfoSearchVo=JSON.parseObject(targetMbr,MembersInfoSearchVo.class);
            membersInfoSearchVo.setPageNumber(1);
            membersInfoSearchVo.setPageSize(1000);
            membersInfoSearchVo.setBrandId(stageUser.getBrandId());
            membersInfoSearchVo.setSysCompanyId(stageUser.getSysCompanyId());
            memberMessageSend.sendWxMessage(mktMessagePO, membersInfoSearchVo);
        }

        responseData.setMessage(ResponseConstants.SUCCESS_MSG);
        log.info("com.bizvane.mktcenterserviceimpl.service.impl.ActivitySmartServiceImpl.addWxMessageActivity result"+ JSON.toJSONString(responseData));
        return responseData;
    }
}
