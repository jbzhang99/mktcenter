package com.bizvane.messageservice.service.impl;

import com.bizvane.messageservice.common.constants.SysResponseEnum;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.mappers.MsgWxLogPOMapper;
import com.bizvane.messageservice.mongo.WechatLogPOMongoDao;
import com.bizvane.messageservice.service.WechatMessageLogService;
import com.bizvane.messagefacade.models.po.MsgWxLogPO;
import com.bizvane.messagefacade.models.po.MsgWxLogPOExample;
import com.bizvane.messagefacade.models.vo.PageForm;
import com.bizvane.messagefacade.models.vo.Result;
import com.bizvane.messagefacade.models.vo.SmsStatisticsVO;
import com.bizvane.messagefacade.models.vo.WechatMessageLogVO;
import com.github.pagehelper.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 记录发送微信模板消息日志
 * 
 * @author 董争光 2018年5月21日下午2:00:22
 */
@Service
public class WechatMessageLogServiceImpl implements WechatMessageLogService {

  @Autowired
  private MsgWxLogPOMapper msgwxlogpomapper;
  @Autowired
  private WechatLogPOMongoDao wechatLogPOMongoDao;
  
  

  public Result<String> insert(MsgWxLogPO po) {

    po.setSendState(SystemConstants.WECHAT_MESSAGE_LOG_SEND_STATE_CREATE);
    po.setCreateDate(new Date());

//    this.msgwxlogpomapper.insert(po);
    //改mongdb
    String logid = wechatLogPOMongoDao.saveRocketLogPO(po);

    Result<String> result = new Result<>();
    result.setData(logid);

    return result;
  }

  @Override
  public Result<Object> update(MsgWxLogPO po) {
    po.setUpdateDate(new Date());
    if("10".equals(po.getSendState())){
    	po.setResultInfo("成功");
    	po.setResultInfoDetail("");
    }else {
    	po.setResultInfoDetail(po.getResultInfo());
    	po.setResultInfo("失败");
    	
    }
    po.setUpdateDate(new Date());
    wechatLogPOMongoDao.updateRocketLogPO(po);

    return new Result<>();
  }

  @Override
  public Result<Object> update(MsgWxLogPO po, MsgWxLogPOExample example) {
    po.setUpdateDate(new Date());

    this.msgwxlogpomapper.updateByExampleSelective(po, example);

    return new Result<>();
  }

  /**
   * 查找微信消息日志分页
   * @param vo
   * @return
   */
  @Override
  public ResponseData<Object> findPage(WechatMessageLogVO vo ) {
    ResponseData<Object> responseData = new ResponseData<>();
//    PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
//    List<MsgWxLogPO> list = msgwxlogpomapper.findPage(vo);

    PageInfo<MsgWxLogPO> pageInfo = wechatLogPOMongoDao.getRocketLogPOList(vo);

    responseData.setData(pageInfo);

    return responseData;
  }
  
  /**
   * 微信发送统计
   * @param smsMessageLogVo
   * @return
   */
  @Override
  public ResponseData getStatistics(WechatMessageLogVO smsMessageLogVo) {
      ResponseData responseData = new ResponseData();
      //根据条件查询发送微信的总条数
  	PageForm pageForm = new PageForm();
      pageForm.setPageNum(smsMessageLogVo.getPageNumber());
      pageForm.setPageSize(smsMessageLogVo.getPageSize());
      //发送微信的总条数
      PageInfo<MsgWxLogPO> pageInfolist= wechatLogPOMongoDao.getRocketLogPOList(smsMessageLogVo);
      Long allCountSms =pageInfolist.getTotal();
      
      //发送微信成功的总条数
        smsMessageLogVo.setSendState("10");
        PageInfo<MsgWxLogPO> pageInfosuccessSmslist = wechatLogPOMongoDao.getRocketLogPOList(smsMessageLogVo);
        Long successSms =pageInfosuccessSmslist.getTotal();
      //发送微信失败的总条数
      /*criteria.andSendStateEqualTo(-1);
      Long failedSms = msgSmsLogPOMapper.countByExample(msgSmsLogPOExample);*/
      Long failedSms =allCountSms-successSms;


      //微信发送触达率
      SmsStatisticsVO smsStatisticsVO = new SmsStatisticsVO();

      if (allCountSms!=0){

          BigDecimal   b   =   new   BigDecimal(successSms);
	        b=b.divide(new BigDecimal(allCountSms),4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
          String endPercent = b.setScale(2, BigDecimal.ROUND_HALF_UP).toString();

          if (successSms==0){
              endPercent="0.00";
          }



          smsStatisticsVO.setAllCountSms(allCountSms);
          smsStatisticsVO.setFailedSms(failedSms);
          smsStatisticsVO.setSuccessSms(successSms);
          smsStatisticsVO.setSuccessPercent(endPercent);



      }else{


          smsStatisticsVO.setAllCountSms(0L);
          smsStatisticsVO.setFailedSms(0L);
          smsStatisticsVO.setSuccessSms(0L);
          smsStatisticsVO.setSuccessPercent("0.00");
      }

      responseData.setData(smsStatisticsVO);
      responseData.setCode(SysResponseEnum.SUCCESS.getCode());
      responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
      return responseData;
  }


}
