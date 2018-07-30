package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.po.MktTaskPO;
import com.bizvane.mktcenterservice.models.po.MktTaskPOExample;
import com.bizvane.mktcenterservice.models.po.MktTaskPOWithBLOBs;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.mktcenterserviceimpl.common.constants.ResponseConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.TaskConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.TaskStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.MktTaskPOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/16 14:11
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private MktTaskPOMapper mktTaskPOMapper;

    /**
     * 根据任务类型查询任务
     */
    @Override
    public   ResponseData<PageInfo<MktTaskPOWithBLOBs>>  getTaskByTaskType(TaskVO vo,PageForm pageForm){
        ResponseData<PageInfo<MktTaskPOWithBLOBs>> result = new ResponseData<PageInfo<MktTaskPOWithBLOBs>>(SysResponseEnum.FAILED.getCode(),SysResponseEnum.FAILED.getMessage(),null);
        String showType = vo.getShowType();
        //1完善资料，2分享任务，3邀请注册，4累计消费次数，5累计消费金额',
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());

        MktTaskPOExample mktTaskPOExample = new MktTaskPOExample();
        //查询所有
        if (TaskConstants.FIRST.equals(showType)){
            mktTaskPOExample.createCriteria().andTaskTypeEqualTo(vo.getTaskType());
        }else  if(TaskConstants.SECOND.equals(showType)){
            //查询已启用
            mktTaskPOExample.createCriteria().andTaskTypeEqualTo(vo.getTaskType()).andValidEqualTo(Boolean.TRUE);
        }else if(TaskConstants.THREE.equals(showType)){
            //查询已启用
            mktTaskPOExample.createCriteria().andTaskTypeEqualTo(vo.getTaskType()).andValidEqualTo(Boolean.FALSE);
        }
        mktTaskPOExample.setOrderByClause("create_date desc");

        List<MktTaskPOWithBLOBs> lists = mktTaskPOMapper.selectByExampleWithBLOBs(mktTaskPOExample);
        if (CollectionUtils.isNotEmpty(lists)){
            PageInfo<MktTaskPOWithBLOBs> pageInfo = new PageInfo<MktTaskPOWithBLOBs>();
            result.setData(pageInfo);
            result.setCode(SysResponseEnum.SUCCESS.getCode());
            result.setMessage(SysResponseEnum.SUCCESS.getMessage());
        }

        return result;

    }

    /**
     * 禁用/停用任务
     * @param mktTaskId
     * @param sysAccountPO
     * @return
     */
    @Override
    public ResponseData<Integer> stopTaskById(Long mktTaskId, SysAccountPO sysAccountPO) {
        ResponseData responseData = new ResponseData();
        MktTaskPOWithBLOBs mktTaskPOWithBLOBs = new MktTaskPOWithBLOBs();
        mktTaskPOWithBLOBs.setMktTaskId(mktTaskId);
        mktTaskPOWithBLOBs.setTaskStatus(TaskStatusEnum.TASK_STATUS_DISABLED.getCode());
        mktTaskPOWithBLOBs.setModifiedDate(new Date());
        mktTaskPOWithBLOBs.setModifiedUserId(sysAccountPO.getSysAccountId());
        mktTaskPOWithBLOBs.setModifiedUserName(sysAccountPO.getName());
        mktTaskPOMapper.updateByPrimaryKeySelective(mktTaskPOWithBLOBs);
        responseData.setData(ResponseConstants.SUCCESS_MSG);
        return responseData;
    }

    /**
     * 新增任务主表任务数据
     * @param task
     * @param stageUser
     * @return
     */
    @Override
    public Long addTask(MktTaskPOWithBLOBs task, SysAccountPO stageUser) {
        task.setCreateDate(TimeUtils.getNowTime());
        task.setCreateUserId(stageUser.getSysAccountId());
        task.setCreateUserName(stageUser.getName());

        mktTaskPOMapper.insertSelective(task);
        return task.getMktTaskId();
    }

    /**
     * 修改任务
     */
    @Override
    public  Integer   updateTask(MktTaskPOWithBLOBs task, SysAccountPO stageUser){
        task.setModifiedDate(TimeUtils.getNowTime());
        task.setModifiedUserId(stageUser.getCtrlAccountId());
        task.setModifiedUserName(stageUser.getName());

        return mktTaskPOMapper.updateByPrimaryKeySelective(task);
    }



    /**
     * 任务审核:通过/驳回
     * @param mktTaskId
     * @param sysAccountPO
     * @return
     */
    @Override
    public ResponseData<Integer> checkTaskById(Long mktTaskId, SysAccountPO sysAccountPO) {
        ResponseData responseData = new ResponseData();
        MktTaskPOWithBLOBs mktTaskPOWithBLOBs = new MktTaskPOWithBLOBs();
        mktTaskPOWithBLOBs.setMktTaskId(mktTaskId);
        mktTaskPOWithBLOBs.setTaskStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
        mktTaskPOWithBLOBs.setModifiedDate(new Date());
        mktTaskPOWithBLOBs.setModifiedUserId(sysAccountPO.getSysAccountId());
        mktTaskPOWithBLOBs.setModifiedUserName(sysAccountPO.getName());
        mktTaskPOMapper.updateByPrimaryKeySelective(mktTaskPOWithBLOBs);
        return responseData;
    }
}
