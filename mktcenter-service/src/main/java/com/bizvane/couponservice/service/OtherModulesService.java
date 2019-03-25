package com.bizvane.couponservice.service;

import com.bizvane.members.facade.es.vo.MembersInfoSearchVo;
import com.bizvane.members.facade.vo.MemberInfoVo;
import com.bizvane.utils.responseinfo.ResponseData;

import java.util.List;

/**
 * Created by Administrator on 2018/9/7.
 */
public interface OtherModulesService {

    /**
     * 根据高级搜索条件查找会员
     * @param
     * @return
     */
    ResponseData<List<MemberInfoVo>> searchMembers(MembersInfoSearchVo memberVO)throws Exception;
}
