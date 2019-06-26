package com.bizvane.mktcenterfacade.interfaces;

import com.bizvane.mktcenterfacade.models.bo.ActivityBO;
import com.bizvane.mktcenterfacade.models.vo.ActivityInviteVO;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.mktcenterfacade.models.vo.InviteSuccessVO;
import com.bizvane.mktcenterfacade.models.vo.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/16 14:06
 * @description
 *
 */
public interface ActivityInviteService {
    /**
     * 查询任务列表
     * @return
     */
    public ResponseData<List<ActivityVO>> list(ActivityVO vo, PageForm pageForm, SysAccountPO stageUser);

    /**
     * 查详情
     * @param businessCode
     * @return
     */
    ResponseData<ActivityBO> selectActivityInviteById(String businessCode);
    /**
     * 新增任务
     * @return
     */
    public ResponseData<Integer> add(ActivityBO bo, SysAccountPO stageUser) throws ParseException;

    /**
     * 修改任务
     * @param stageUser
     * @return
     */
    public ResponseData update(ActivityBO bo, SysAccountPO stageUser) throws ParseException;

    public void award(@RequestBody @Valid InviteSuccessVO vo);
}

