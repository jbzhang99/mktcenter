package com.bizvane.couponservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.couponfacade.models.po.CouponManualPO;
import com.bizvane.couponfacade.models.vo.CouponDetailResponseVO;
import com.bizvane.couponfacade.models.vo.CouponManualRequestVO;
import com.bizvane.couponfacade.models.vo.CouponManualVO;
import com.bizvane.couponfacade.models.vo.CouponSendCheckRequestVO;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.bizvane.couponservice.common.constants.SysResponseEnum;
import com.bizvane.couponservice.common.utils.HttpParamUtil;
import com.bizvane.couponservice.common.utils.HttpUtils;
import com.bizvane.couponservice.common.utils.JacksonUtil;
import com.bizvane.couponservice.service.CouponManualService;
import com.bizvane.members.facade.es.vo.MembersInfoSearchVo;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.vo.MemberInfoApiModel;
import com.bizvane.utils.responseinfo.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/couponManual")
public class CouponManualController {
  private static final Logger logger = LoggerFactory.getLogger(CouponManualController.class);

  @Autowired
  private CouponManualService couponManualService;
  @Autowired
  private MemberInfoApiService memberInfoApiService;

  /**
   * 手动发券（列表）
   * @param vo
   * @return
   */
  @ApiOperation(value = "查询手动发券列表", notes = "查询手动发券列表", tags = {"手动发券"},httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "taskName", value = "任务名称", required = true, dataType = "String"),
          @ApiImplicitParam(name = "sendTimeStr", value = "发券时间", required = true, dataType = "String"),
          @ApiImplicitParam(name = "createDateStr", value = "创建时间", required = true, dataType = "String"),
          @ApiImplicitParam(name = "couponDefinitionName", value = "券名称", required = true, dataType = "String"),
          @ApiImplicitParam(name = "taskStatus", value = "任务状态：10-新建，15-取消发送，20-审核通过，25-审核拒绝，30-待发券，40-发券中，50-系统生成券完成，65-生成券同步到erp，70-线上绑券成功，75-绑定关系同步中，80-发券完成", required = true, dataType = "Byte"),
          @ApiImplicitParam(name = "createUserName", value = "创建人", required = true, dataType = "String"),

          @ApiImplicitParam(name = "memberCount", value = "发送人数", required = true, dataType = "Integer"),
          @ApiImplicitParam(name = "syncFailCount", value = "同步失败", required = true, dataType = "Integer"),
          @ApiImplicitParam(name = "failCount", value = "发券失败", required = true, dataType = "Integer"),
          @ApiImplicitParam(name = "sendTime", value = "发券时间", required = true, dataType = "Date"),
          @ApiImplicitParam(name = "createDate", value = "创建时间", required = true, dataType = "Date"),
          @ApiImplicitParam(name = "createUserName", value = "创建人", required = true, dataType = "String"),
          @ApiImplicitParam(name = "reviewUserName", value = "审核人", required = true, dataType = "String")
  })
  @RequestMapping(value="/getList.do", method = RequestMethod.POST)
  ResponseData<PageInfo<CouponManualVO>> getList(CouponManualVO vo,
                                                 PageFormUtil pageForm,HttpServletRequest request){
    logger.info("enter getList method param: CouponManualVO:{},PageFormUtil:{}",vo,pageForm);
    SysAccountPo accountPo = HttpUtils.getLoginUser(request);
    Long sysBrandId = accountPo.getBrandId();
    return couponManualService.getList(vo,sysBrandId,pageForm);
  
  }

  /**
   * 更改发送状态
   * @param po
   * @return
   */
  @ApiOperation(value = "更改发送状态", notes = "更改发送状态", tags = {"手动发券列表"},httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "couponManualId", value = "手动发券id", required = true, dataType = "Long"),
          @ApiImplicitParam(name = "taskStatus", value = "任务状态：10-新建，15-取消发送，20-审核通过，25-审核拒绝，30-待发券，40-发券中，50-系统生成券完成，65-生成券同步到erp，70-线上绑券成功，75-绑定关系同步中，80-发券完成", required = true, dataType = "byte"),
  })
  @RequestMapping(value="/changeTask.do", method = RequestMethod.POST)
  ResponseData<Integer> changeTask(CouponManualPO po){
    logger.info("enter changeTask method param: CouponManualPO:{}", JSONObject.toJSONString(po));
    return couponManualService.changeTask(po);
    
  }


  /**
   * 停止发送券
   * @return
   */
  @ApiOperation(value = "停止发送", notes = "停止发送", tags = {"手动发券列表"},httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "couponManualId", value = "手动发券id", required = true, dataType = "Long")
  })
  @RequestMapping(value="/suspendTask.do", method = RequestMethod.POST)
  ResponseData<Integer> suspendTask(@RequestParam(value = "couponManualId",required = false)Long couponManualId){
    logger.info("enter changeTask method param: couponManualId:{}", couponManualId);
    return couponManualService.suspendTask(couponManualId);

  }

  
  /**
   * 发券任务效果分析列表查询
   * @param vo
   * @return
   */
  @ApiOperation(value = "发券效果分析", notes = "发券任务效果分析列表查询", tags = {"发券效果分析"},httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "sendTimeStart", value = "发券开始时间", required = true, dataType = "String"),
          @ApiImplicitParam(name = "sendTimeEnd", value = "发券结束时间", required = true, dataType = "String"),
  })
  @RequestMapping(value="/findResult.do", method = RequestMethod.POST)
  ResponseData<PageInfo> findResult(CouponManualVO vo, PageFormUtil pageForm, HttpServletRequest request){
    logger.info("enter findResult method param: CouponManualVO:{},PageFormUtil:{}", JSONObject.toJSONString(vo),JSONObject.toJSONString(pageForm));
    SysAccountPo accountPo = HttpUtils.getLoginUser(request);
    return couponManualService.findResult(vo,pageForm,accountPo);

  }

  /**
   * 发券效果分析合计
   * @param vo
   * @return
   */
  @ApiOperation(value = "发券效果分析合计", notes = "发券任务效果分析合计", tags = {"发券效果分析"},httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "sendTimeStart", value = "发券开始时间", required = true, dataType = "String"),
          @ApiImplicitParam(name = "sendTimeEnd", value = "发券结束时间", required = true, dataType = "String"),
  })
  @RequestMapping(value="/findTotal.do", method = RequestMethod.POST)
  ResponseData<CouponManualVO> findTotal(CouponManualVO vo,HttpServletRequest request){
    logger.info("enter findTotal method param: CouponManualVO:{}", JSONObject.toJSONString(vo));
    SysAccountPo accountPo = HttpUtils.getLoginUser(request);
    return couponManualService.findTotal(vo,accountPo);

  }

  /**
   * 根据条件查询会员列表
    * @param model
   * @return
   */
  @ApiOperation(value = "根据条件查询会员列表", notes = "根据条件查询会员列表", tags = {"手动发券列表"},httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "name", value = "会员姓名", required = true, dataType = "String"),
  })
  @RequestMapping(value="/getMemberList.do", method = RequestMethod.POST)
  ResponseData<PageInfo<MemberInfoModel>> getMemberList(MemberInfoApiModel model){
    logger.info("enter getMemberList method param: MemberInfoApiModel:{}", JSONObject.toJSONString(model));
    return memberInfoApiService.getMemberInfo(model);

  }




  /**
   * 根据手动发券id查询发券信息
   * @param couponManualId
   * @return
   */
  @ApiOperation(value = "根据手动发券id查询发券信息", notes = "根据手动发券id查询发券信息", tags = {"手动发券"},httpMethod = "POST")
  @RequestMapping(value="/find.do", method = RequestMethod.POST)
  public ResponseData<CouponDetailResponseVO> findById(@RequestParam(value = "couponManualId",required = false) Long couponManualId){
    logger.info("enter findById method param: couponManualId:{}", couponManualId);
    return couponManualService.findById(couponManualId);

  }



  /**
   * 查询创建手动发券任务选中的会员
   * @param couponManualId
   * @return
   */
  @ApiOperation(value = "查询创建手动发券任务选中的会员", notes = "查询创建手动发券任务选中的会员", tags = {"手动发券"},httpMethod = "POST")
  @RequestMapping(value="/findManualMembers.do", method = RequestMethod.POST)
  public ResponseData<PageInfo<MemberInfoModel>> findManualMembers(@RequestParam(value = "couponManualId",required = false) Long couponManualId,
                                                                   @RequestParam(value = "name",required = false) String name,
                                                                   @RequestParam(value = "phone",required = false)String phone,
                                                                PageFormUtil pageFormUtil){
    logger.info("enter findManualMembers method param: couponManualId:{}", couponManualId);
    return couponManualService.findManualMembers(couponManualId,name,phone,pageFormUtil);

  }




  /**
   * 创建发券任务 手动发券接口
   * @return
   */
  @ApiOperation(value = "创建发券任务", notes = "创建发券任务", tags = {"手动发券"},httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "taskName", value = "任务名称", required = true, dataType = "String"),
          @ApiImplicitParam(name = "sendTimeStr", value = "发券时间", required = true, dataType = "String"),
          @ApiImplicitParam(name = "sendType", value = "发送类型：1-立即发送，2-指定时间", required = true, dataType = "Byte"),
          @ApiImplicitParam(name = "couponDefinitionId", value = "券定义id", required = true, dataType = "Long"),
          @ApiImplicitParam(name = "memberInfo", value = "会员查询条件", required = true, dataType = "MembersInfoSearchVo")
  })
  @RequestMapping(value="/addTask.do", method = RequestMethod.POST)
  ResponseData<String> addTask(HttpServletRequest request){

    ResponseData<String> responseData = new ResponseData<>();

    CouponManualRequestVO requestVO = JacksonUtil.json2Objs(HttpParamUtil.getJSONParam(request),
            CouponManualRequestVO.class);

    if(null == requestVO){
      requestVO = new CouponManualRequestVO();
    }

    SysAccountPo accountPo = HttpUtils.getLoginUser(request);

    CouponManualVO couponManualVO = new CouponManualVO();
    couponManualVO.setCouponDefinitionId(requestVO.getCouponDefinitionId().toString());
    couponManualVO.setTaskName(requestVO.getTaskName());
    couponManualVO.setSendTimeStr(requestVO.getSendTimeStr());
    couponManualVO.setSendType(requestVO.getSendType());
    couponManualVO.setTotalNumber(requestVO.getTotalNumber());

    MembersInfoSearchVo membersInfoSearchVo = requestVO.getSearchVo();

    logger.info("enter CouponManualController addTask method param: SearchVo:{}",JSONObject.toJSONString(membersInfoSearchVo));
    logger.info("enter CouponManualController addTask method param: CouponManualVO:{}",JSONObject.toJSONString(couponManualVO));
    logger.info("enter CouponManualController addTask method " +
            "param: SysAccountPo:{}",JSONObject.toJSONString(accountPo));

    try {
      responseData = couponManualService.addTask(couponManualVO,membersInfoSearchVo,accountPo);
    }catch (Exception e){
      logger.info(SysResponseEnum.DATE_TRANSFER_EXCEPTION.getMessage());
      responseData.setCode(SysResponseEnum.FAILED.getCode());
      responseData.setMessage(SysResponseEnum.FAILED.getMessage());
      return responseData;
    }
    return responseData;

  }


  /**
   * 修改手动发券任务
   * @param couponManualVO
   * @return
   */
  @ApiOperation(value = "修改手动发券任务", notes = "修改手动发券任务", tags = {"手动发券"},httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "taskName", value = "任务名称", required = true, dataType = "String"),
          @ApiImplicitParam(name = "sendTimeStr", value = "发券时间", required = true, dataType = "String"),
          @ApiImplicitParam(name = "sendType", value = "发送类型：1-立即发送，2-指定时间", required = true, dataType = "Byte"),
          @ApiImplicitParam(name = "couponDefinitionId", value = "券定义id", required = true, dataType = "Long"),
          @ApiImplicitParam(name = "couponManualId", value = "手动发券id", required = true, dataType = "Long"),
          @ApiImplicitParam(name = "memberInfo", value = "会员条件", required = true, dataType = "MembersInfoSearchVo")
  })
  @RequestMapping(value="/changeManualTask.do", method = RequestMethod.POST)
  ResponseData<String> changeManualTask(CouponManualVO couponManualVO,MembersInfoSearchVo memberInfo,HttpServletRequest request){
    logger.info("enter changeManualTask method param: couponManualVO:{}",JSONObject.toJSONString(couponManualVO));
    ResponseData<String> responseData = new ResponseData<>();
    SysAccountPo accountPo = HttpUtils.getLoginUser(request);
    try {
      responseData = couponManualService.changeManualTask(couponManualVO,memberInfo,accountPo);
    }catch (Exception e){
      logger.info(SysResponseEnum.DATE_TRANSFER_EXCEPTION.getMessage());
      responseData.setCode(SysResponseEnum.FAILED.getCode());
      responseData.setMessage(SysResponseEnum.FAILED.getMessage());
      return responseData;
    }

    return responseData;

  }

  /**
   * 审核发券
   * @param param
   * @return
   */
  @ApiOperation(value = "修改审核状态接口(审核发券)", notes = "修改审核状态接口(审核发券)", tags = {"手动发券"},httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "taskStatus", value = "任务状态", required = true, dataType = "Byte"),
          @ApiImplicitParam(name = "couponManualId", value = "手动发券id", required = true, dataType = "Long"),
          @ApiImplicitParam(name = "remark", value = "备注", required = true, dataType = "String"),

  })
  @RequestMapping(value="/changeCheckStatus.do", method = RequestMethod.POST)
  public ResponseData<String> changeCheckStatus(CouponSendCheckRequestVO param){
    logger.info("enter changeCheckStatus method param: CouponSendCheckRequestVO:{}", JSONObject.toJSONString(param));
    return couponManualService.changeCheckStatus(param);

  }


}
