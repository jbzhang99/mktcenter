package com.bizvane.mktcenterfacade.interfaces;

import com.bizvane.centerstageservice.models.po.SysCheckConfigPo;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.centerstageservice.models.vo.SysStoreVo;
import com.bizvane.couponfacade.models.vo.CouponSendMemberListResponseVO;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.vo.WxChannelInfoVo;
import com.bizvane.messagefacade.models.vo.GenrealGetMessageVO;
import com.bizvane.mktcenterfacade.models.bo.TaskBO;
import com.bizvane.mktcenterfacade.models.po.MktMessagePO;
import com.bizvane.mktcenterfacade.models.po.MktTaskPOWithBLOBs;
import com.bizvane.mktcenterfacade.models.vo.*;
import com.bizvane.mktcenterfacade.models.bo.TaskAwardBO;
import com.bizvane.mktcenterfacade.models.bo.TaskDetailBO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageInfo;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author chen.li
 * @date on 2018/7/16 14:05
 * @description
 *
 */
public interface TaskService {
    /**
     * 给会员发送消息
     */
    public  void sendMemberMessage(SendMessageVO sendMessageVO);
    /**
     * 批量给粉丝发送短信
     */
    public void sendBachMSM(SendMessageVO sendMessageVO);
    /**
     * 获取发送消息和短信的VO
     * @param mktTaskPOWithBLOBs
     * @return
     */
    public SendMessageVO getSendMessageVO(MktTaskPOWithBLOBs mktTaskPOWithBLOBs);
    /**
     * 通过storeid获取店铺列表
     * @param sysStoreIdList
     * @return
     */
    public List<SysStorePo> getStoreListByIds(List<Long> sysStoreIdList);
    /**
     * 获取短信的数量 失败/总数
     * @param vo
     * @return
     */
    public String searchSmsNum(GenrealGetMessageVO vo);
    /**
     * 获取店铺列表
     * @param vo
     * @param sysAccountPo
     * @return
     */
    public ResponseData<List<SysStoreVo>> getWhiteStoreList(SysStoreVo vo,SysAccountPO sysAccountPo);
    /**
     * 查询任务详情
     * @param mktTaskId
     * @return
     */
    public ResponseData<TaskBO> selectTaskById(Long mktTaskId, Integer taskType);
    /**
     * 根据公司id和品牌id查询执行中的消费类任务
     * @param sysCompanyId
     * @param sysBrandId
     * @return
     */
    public List<TaskAwardBO> getTaskOrderAwardList(Long sysCompanyId, Long sysBrandId, Date placeOrderTime, Integer orderSource,Integer taskType);
    /**
     * 根据公司id和品牌id查询执行中的邀请类任务
     * @param sysCompanyId
     * @param sysBrandId
     * @return
     *
     */
    public List<TaskAwardBO> getTaskInviteAwardList( Long mktTaskIdParam,Long sysCompanyId, Long sysBrandId,Date openCardTime);

    /**
     * 完善资料任务的奖励查询
     * @return
     */
    public List<TaskAwardBO> getTaskProfileAwardList(Long mktTaskIdParam,Long sysCompanyId, Long sysBrandId,Date profileDate);

    /**
     * 分享任务的奖励查询
     * @return
     */
    public List<TaskAwardBO> getTaskShareAwardList(Long mktTaskIdparam ,Long sysCompanyId, Long sysBrandId,Date shareDate);
    /**
     * 查询订单详情
     * @param mktTaskId
     * @return
     */
    public  List<TaskDetailVO> getTaskDetailByTaskId(Long mktTaskId);

    /**
     * 设定任务状态
     * @param po
     * @return
     * @throws ParseException
     */
    public MktTaskPOWithBLOBs isOrNoCheckState(MktTaskPOWithBLOBs po,Integer centeStagecheckStatus)throws ParseException;
    /**
     * 完善资料任务,没有开始时间和结束时间.根据任务状态和执行状态来发送消息和短信
     */
    public void doProfileTask(MktTaskPOWithBLOBs mktTaskPOWithBLOBs, List<MktMessagePO> mktmessagePOList, SysAccountPO stageUser);
    /**
     * 发送任务消息
     * @param mktTaskPOWithBLOBs
     * @param stageUser
     */
    public void doOrderTask(MktTaskPOWithBLOBs mktTaskPOWithBLOBs, List<MktMessagePO> mktmessagePOList, SysAccountPO stageUser);
    /**
     * 发送消息--已经核对
     */
    public  void  sendSmg(MktTaskPOWithBLOBs mktTaskPOWithBLOBs,List<MktMessagePO> mktmessagePOList,SysAccountPO stageUser);

    /**
     * 发送券和积分
     * @param orderAwardBO
     */
    public void sendCouponAndPoint(String memberCode,TaskAwardBO orderAwardBO);
    /**
     * 发券和修改积分时的任务类型转换
     * 任务类型：1完善资料，2分享任务，3邀请注册，4累计消费次数，5累计消费金额
     * @param taskType
     * @return
     */
    public ChangeTaskTypeVO changeTaskType(Integer taskType);
    /**
     * 根据品牌id查询任务是否需要审核
     */

    public  Integer  getCheckStatus(SysCheckConfigPo sysCheckConfigPo);
    /**
     * 根据任务类型查询任务列表
     * @param vo
     * @return
     */
    public ResponseData<com.github.pagehelper.PageInfo<MktTaskPOWithBLOBs>> getTaskByTaskType(TaskSearchVO vo) throws ParseException;

    /**
     * 新增
     */
    public  Long  addTask(MktTaskPOWithBLOBs task,SysAccountPO sysAccountPO);

    /**
     * 修改
     * @param task
     * @param stageUser
     * @return
     */
    public  Integer   updateTask(MktTaskPOWithBLOBs task, SysAccountPO stageUser);

    /**
     * 禁用/停止任务
     * @param mktTaskId
     * @return
     */
    public ResponseData<Integer> stopTaskById(Long mktTaskId, SysAccountPO sysAccountPO);

    /**
     * 任务审核
     * @return
     */
    public ResponseData<Integer> checkTaskById(CheckTaskVO vo,SysAccountPO sysAccountPO) throws ParseException;

    /**
     * 获取品牌下的所有会员
     * @return
     */
    public  com.github.pagehelper.PageInfo<MemberInfoModel> getCompanyMemebers(SendMessageVO sendMessageVO,Integer pageNumber,Integer pageSize);

    /**
     * 获取品牌下的所有粉丝
     */
    public  com.github.pagehelper.PageInfo<WxChannelInfoVo>  getCompanyFans(Long sysBrandId, Integer pageNumber, Integer pageSize);

    /**
     * 根据会员Code的某一会员的详情
     */
    public MemberInfoModel getCompanyMemeberDetail(String  memberCode);

    /**
     * 效果分析的明细
     */
    public ResponseData<TaskRecordVO> doAnalysis(TaskAnalysisVo vo, SysAccountPO sysAccountPo) throws ExecutionException, InterruptedException;
    /**
     * 将需要审核的任务添加到中台
     * @param po
     */
    public  void addCheckData(MktTaskPOWithBLOBs po);
    /**
     *修改添加到中台任务的状态
     */
    public  ResponseData<Integer>  updateCheckData(Long mktTaskId ,Integer checkStatus,String functionCode,SysAccountPO sysAccountPO);

    /**
     * 中台通过品牌Id查询任务是否需要审核
     * @param po
     * @return
     */
    public Integer getCenterStageCheckStage(MktTaskPOWithBLOBs po);

    /**
     * 活动、任务效果分析“发行优惠券”添加会员明细弹框；
     * @return
     */
    ResponseData<PageInfo<CouponSendMemberListResponseVO>> findCouponSendResultTask(Long id, Integer type, SysAccountPO stageUser, PageForm pageForm, String name, String cardNo);
    /**
     * 查询白名单店铺Id
     */
   public  List<Long>  getWhiteStoreIds(WhiteStoreVO vo);

    public List<TaskDetailBO> getTaskProfileListApp(ProfileSuccessVO vo);
}
