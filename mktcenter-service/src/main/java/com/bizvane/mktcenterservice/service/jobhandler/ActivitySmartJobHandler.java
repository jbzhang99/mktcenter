package com.bizvane.mktcenterservice.service.jobhandler;

import com.alibaba.fastjson.JSON;
import com.bizvane.members.facade.es.vo.MembersInfoSearchVo;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.service.api.MembersAdvancedSearchApiService;
import com.bizvane.mktcenterfacade.interfaces.ActivitySmartService;
import com.bizvane.mktcenterfacade.models.po.MktActivityPOExample;
import com.bizvane.mktcenterfacade.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterfacade.models.po.MktActivitySmartPO;
import com.bizvane.mktcenterfacade.models.po.MktActivitySmartPOExample;

import com.bizvane.mktcenterservice.common.award.Award;
import com.bizvane.mktcenterservice.common.award.MemberMessageSend;
import com.bizvane.mktcenterservice.common.constants.ResponseConstants;
import com.bizvane.mktcenterservice.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterservice.mappers.MktActivitySmartPOMapper;
import com.bizvane.mktcenterservice.mappers.MktCouponPOMapper;
import com.bizvane.mktcenterservice.mappers.MktMessagePOMapper;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chen.li
 * @date on 2018/8/3 14:05
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@JobHandler(value="smartActivity")
@Component
@Slf4j
public class ActivitySmartJobHandler extends IJobHandler {

    @Autowired
    private ActivitySmartService activitySmartService;

    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;

    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;

    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;

    @Autowired
    private MktActivitySmartPOMapper mktActivitySmartPOMapper;

    @Autowired
    private Award award;

    @Autowired
    private MemberInfoApiService memberInfoApiService;
    @Autowired
    private MembersAdvancedSearchApiService membersAdvancedSearchApiService;
    @Autowired
    private MemberMessageSend memberMessage;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        log.info("ActivitySmartJobHandler.execute param:"+param);
        ReturnT returnT = new ReturnT();
        try {
            String[] split = param.split("&");
            if(split.length>1){
                Integer mktSmartType = Integer.valueOf(split[0]);
                String activitiCode = split[1];
                //get main activity object
                log.info("智能营销-param参数是mktSmartType====："+mktSmartType+"activitiCode是==="+activitiCode);
                MktActivityPOExample mktActivityPOExample = new MktActivityPOExample();
                mktActivityPOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andActivityCodeEqualTo(activitiCode);
                List<MktActivityPOWithBLOBs> mktActivityPOWithBLOBsList = mktActivityPOMapper.selectByExampleWithBLOBs(mktActivityPOExample);
                log.info("智能营销-查询到该智能营销活动时+==："+JSON.toJSONString(mktActivityPOWithBLOBsList));
                MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
                if(CollectionUtils.isNotEmpty(mktActivityPOWithBLOBsList)){
                    mktActivityPOWithBLOBs = mktActivityPOWithBLOBsList.get(0);
                }else{
                    log.error("mktActivityPOWithBLOBsList is empty");
                    returnT.setMsg("mktActivityPOWithBLOBsList is empty");
                    return returnT;
                }
                //get smart activity object
                MktActivitySmartPOExample mktActivitySmartPOExample = new MktActivitySmartPOExample();
                mktActivitySmartPOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andMktActivityIdEqualTo(mktActivityPOWithBLOBs.getMktActivityId());
                List<MktActivitySmartPO> mktActivitySmartPOList = mktActivitySmartPOMapper.selectByExampleWithBLOBs(mktActivitySmartPOExample);
                log.info("智能营销-查询到结果是++++++++++++++==："+JSON.toJSONString(mktActivitySmartPOList));
                MktActivitySmartPO mktActivitySmartPO = new MktActivitySmartPO();
                if(CollectionUtils.isNotEmpty(mktActivitySmartPOList)){
                    mktActivitySmartPO = mktActivitySmartPOList.get(0);
                }else{
                    log.error("mktActivitySmartPOList is empty");
                    returnT.setMsg("mktActivitySmartPOList is empty");
                    return returnT;
                }
                String targetMbr = mktActivitySmartPO.getTargetMbr();
                log.info("智能营销-高级搜索的条件："+targetMbr);
                ////分页查询会员信息
                //把高级搜索的条件转换成对象
                // JSONObject jsonObject=JSONObject.parseObject(targetMbr);
                // MembersInfoSearchVo membersInfoSearchVo=jsonObject.toJavaObject(MembersInfoSearchVo.class);
                MembersInfoSearchVo membersInfoSearchVo= JSON.parseObject(targetMbr,MembersInfoSearchVo.class);
                membersInfoSearchVo.setPageNumber(1);
                membersInfoSearchVo.setPageSize(10000);
                membersInfoSearchVo.setSysCompanyId(mktActivityPOWithBLOBs.getSysCompanyId());
                membersInfoSearchVo.setBrandId(mktActivityPOWithBLOBs.getSysBrandId());
                log.info("智能营销-查询发短信会员参数："+JSON.toJSONString(membersInfoSearchVo));
                memberMessage.sendSmart(mktSmartType, mktActivityPOWithBLOBs, membersInfoSearchVo);

                returnT.setCode(ResponseConstants.SUCCESS);
                returnT.setContent(ResponseConstants.SUCCESS_MSG);
                returnT.setMsg(ResponseConstants.SUCCESS_MSG);
            }else{
                returnT.setCode(ResponseConstants.ERROR);
                returnT.setContent(ResponseConstants.ERROR_MSG);
                returnT.setMsg(ResponseConstants.ERROR_MSG);
            }
        } catch (Exception e) {
            log.error("ActivitySmartJobHandler.execute error"+e.getMessage());
        }
        return returnT;
    }


}
