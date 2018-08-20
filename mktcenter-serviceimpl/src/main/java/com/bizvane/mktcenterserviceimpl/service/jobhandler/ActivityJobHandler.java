package com.bizvane.mktcenterserviceimpl.service.jobhandler;

import com.bizvane.members.facade.models.MbrLevelModel;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.service.api.MemberLevelApiService;
import com.bizvane.messagefacade.models.vo.MemberMessageVO;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.mktcenterservice.models.bo.AwardBO;
import com.bizvane.mktcenterservice.models.po.MktActivityPO;
import com.bizvane.mktcenterservice.models.po.MktActivityPOExample;
import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.mktcenterservice.models.po.MktMessagePOExample;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterserviceimpl.common.award.Award;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.MktSmartTypeEnum;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityOrderPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityUpgradePOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktMessagePOMapper;
import com.bizvane.utils.responseinfo.ResponseData;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@JobHandler(value="activity")
@Component
public class ActivityJobHandler extends IJobHandler {

    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;
    @Autowired
    private MemberInfoApiService memberInfoApiService;
    @Autowired
    private MemberLevelApiService memberLevelApiService;
    @Autowired
    private MktActivityUpgradePOMapper mktActivityUpgradePOMapper;
    @Autowired
    private MktActivityOrderPOMapper mktActivityOrderPOMapper;
    @Autowired
    private Award award;
    @Override
    public ReturnT<String> execute(String param) throws Exception {

        System.out.println("job执行参数 "+param);
        ReturnT returnT = new ReturnT();
        System.out.println("开始执行活动");
        //查询该活动是否已经审核
        MktActivityPOExample examplem = new MktActivityPOExample();
        examplem.createCriteria().andActivityCodeEqualTo(param).andValidEqualTo(true);
        List<MktActivityPO> mktActivityPOs = mktActivityPOMapper.selectByExample(examplem);
        MktActivityPO mktActivityPO = mktActivityPOs.get(0);
        if(mktActivityPO.getCheckStatus()==CheckStatusEnum.CHECK_STATUS_APPROVED.getCode()){
            MktActivityPO po = new MktActivityPO();
            po.setActivityCode(param);
            po.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
            //把活动状态改成执行中
            int sum = mktActivityPOMapper.updateActivityStatus(po);

            //判断是什么类型的活动 然后给不同的会员发送消息
            MemberInfoModel memberInfoModel= new MemberInfoModel();
            //开卡活动的
            if (mktActivityPO.getActivityType()== ActivityTypeEnum.ACTIVITY_TYPE_REGISGER.getCode()){

                memberInfoModel.setBrandId(mktActivityPO.getSysBrandId());
               // memberInfoModel.setLevelId(Long.parseLong(mktActivityPO.getMbrLevelCode()));

            }
            //升级活动的
            if (mktActivityPO.getActivityType()== ActivityTypeEnum.ACTIVITY_TYPE_UPGRADE.getCode()){
                ActivityVO vo = new ActivityVO();
                vo.setActivityCode(param);
                List<ActivityVO> activityUpgradeList = mktActivityUpgradePOMapper.getActivityUpgradeList(vo);
                //查询该会员下一个等级
                ResponseData<MbrLevelModel> MbrLevelModels = memberLevelApiService.queryOnLevel(Long.parseLong(activityUpgradeList.get(0).getMbrLevelCode()));
                MbrLevelModel  mbrLevel = MbrLevelModels.getData();
                memberInfoModel.setBrandId(mktActivityPO.getSysBrandId());
                memberInfoModel.setLevelId(mbrLevel.getMbrLevelId());
            }
            //消费活动的
            if (mktActivityPO.getActivityType()== ActivityTypeEnum.ACTIVITY_TYPE_ORDER.getCode()){
                ActivityVO vo = new ActivityVO();
                vo.setActivityCode(param);
                List<ActivityVO> activityOrderList = mktActivityOrderPOMapper.getActivityOrderList(vo);

                memberInfoModel.setBrandId(mktActivityPO.getSysBrandId());
                if (!activityOrderList.get(0).getMbrLevelCode().equals("0")){
                    memberInfoModel.setLevelId(Long.parseLong(activityOrderList.get(0).getMbrLevelCode()));
                }
            }
            //查询对应的会员
            ResponseData<List<MemberInfoModel>> memberInfoModelLists =memberInfoApiService.getMemberInfo(memberInfoModel);
            List<MemberInfoModel> memberInfoModelList = memberInfoModelLists.getData();
            //查询消息集合
            MktMessagePOExample example = new MktMessagePOExample();
            example.createCriteria().andBizIdEqualTo(Long.parseLong("param"));
            List<MktMessagePO> ListMktMessage = mktMessagePOMapper.selectByExample(example);
            //发送模板消息和短信消息给会员群体
            //循环发送
            if (!CollectionUtils.isEmpty(memberInfoModelList)){
                for (MemberInfoModel memberInfo:memberInfoModelList) {
                    //循环信息类然后发送
                    for (MktMessagePO mktMessagePO:ListMktMessage) {
                        AwardBO awardBO = new AwardBO();
                        if (mktMessagePO.getMsgType().equals("1")){
                            //发送微信模板消息
                            MemberMessageVO memberMessageVO = new MemberMessageVO();
                            memberMessageVO.setMemberCode(memberInfo.getMemberCode());
                            memberMessageVO.setActivityName(mktActivityPO.getActivityName());
                            memberMessageVO.setActivityDate(mktActivityPO.getStartTime());
                            memberMessageVO.setActivityInterests(mktMessagePO.getMsgContent());
                            awardBO.setMemberMessageVO(memberMessageVO);
                            awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_WXMESSAGE.getCode());
                            award.execute(awardBO);
                        }
                        if (mktMessagePO.getMsgType().equals("2")){
                            SysSmsConfigVO sysSmsConfigVO = new SysSmsConfigVO();
                            sysSmsConfigVO.setPhone(memberInfo.getPhone());
                            awardBO.setSysSmsConfigVO(sysSmsConfigVO);
                            awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_SMS.getCode());
                            //发送短信消息
                            award.execute(awardBO);
                        }
                    }
                }
            }
        }else{
            returnT.setCode(1);
            returnT.setContent("该活动未审核");
            returnT.setMsg("FAILED");
            return returnT;
        }

        returnT.setCode(0);
        returnT.setContent("活动执行完毕");
        returnT.setMsg("success");
        return returnT;
    }
}
