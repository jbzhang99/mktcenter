package com.bizvane.mktcenterserviceimpl.common.award;

import com.bizvane.members.facade.es.vo.MembersInfoSearchVo;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.MembersAdvancedSearchApiService;
import com.bizvane.members.facade.vo.MemberInfoVo;
import com.bizvane.members.facade.vo.PageVo;
import com.bizvane.messagefacade.models.vo.MemberMessageVO;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.mktcenterservice.models.bo.AwardBO;
import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.mktcenterserviceimpl.common.enums.MktSmartTypeEnum;
import com.bizvane.utils.responseinfo.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by agan on 2018/8/24.
 */
@Component
public class MemberMessageSend {
    @Autowired
    private MembersAdvancedSearchApiService membersAdvancedSearchApiService;
    @Autowired
    private Award award;
    public void getMemberList(List<MktMessagePO> messageVOList, MembersInfoSearchVo membersInfoSearchVo, PageVo pageVo) {
        ResponseData<PageInfo<MemberInfoVo>> memberInfoVoPage = membersAdvancedSearchApiService.search(membersInfoSearchVo,pageVo);
        //循环分页条件查询会员信息发送短信信息
        for (int a =1;a<=memberInfoVoPage.getData().getPages();a++){
            pageVo.setPageNum(a);
            ResponseData<com.bizvane.utils.responseinfo.PageInfo<MemberInfoVo>> memberInfoVoPages = membersAdvancedSearchApiService.search(membersInfoSearchVo,pageVo);
            List<MemberInfoVo> memberInfoModelList = memberInfoVoPages.getData().getList();
            //循环发送
            if (!CollectionUtils.isEmpty(memberInfoModelList)){
                for (MemberInfoModel memberInfo:memberInfoModelList) {
                    //循环信息类然后发送
                    for (MktMessagePO mktMessagePO:messageVOList) {
                        AwardBO awardBO = new AwardBO();
                        if (mktMessagePO.getMsgType().equals("1") && !StringUtils.isEmpty(memberInfo.getWxOpenId())){
                            //发送微信模板消息
                            MemberMessageVO memberMessageVO = new MemberMessageVO();
                            memberMessageVO.setMemberCode(memberInfo.getMemberCode());
                            memberMessageVO.setOpenId(memberInfo.getWxOpenId());
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
        }
    }
}
