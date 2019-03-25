package com.bizvane.mktcenterfacade.interfaces;

import com.bizvane.centercontrolservice.models.po.AppletFunctionPO;
import com.bizvane.mktcenterfacade.models.bo.TaskBO;
import com.bizvane.mktcenterfacade.models.vo.ShareSuccessVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

import java.text.ParseException;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/16 14:07
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public interface TaskShareService {
    /**
     * 从中控获取站内链接列表
     * @return
     */
    public ResponseData<List<AppletFunctionPO>>  getURLList(Long brandId);

    /**
     * 新增任务
     * @param bo
     * @return
     */
    public ResponseData<Integer> addTask(TaskBO bo, SysAccountPO stageUser) throws ParseException;

    /**
     * 修改任务
     * @return
     */
    public ResponseData<Integer> updateTask(TaskBO bo,SysAccountPO stageUser);

    /**
     * 执行分享任务的奖励
     * @param vo
     */
    public  void   doAwardShare(ShareSuccessVO vo);
    /**
     *效果分析
     * @param date1
     * @param date2
     * @param stageUser
     * @return
     */
  //  public ResponseData<TaskRecordVO> getTaskShareRecordByTime(Date date1, Date date2, SysAccountPO stageUser,String taskName,PageForm pageForm);

}
