package com.bizvane.messageservice.service.impl;

import com.bizvane.messageservice.common.constants.SysResponseEnum;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.mongo.WechatTuWenLogPOMongoDao;
import com.bizvane.messageservice.service.WechatTuWenMessageLogService;
import com.bizvane.messagefacade.models.po.MsgWxLogPOExample;
import com.bizvane.messagefacade.models.po.MsgWxTuWenPO;
import com.bizvane.messagefacade.models.vo.PageForm;
import com.bizvane.messagefacade.models.vo.Result;
import com.bizvane.messagefacade.models.vo.SmsStatisticsVO;
import com.bizvane.messagefacade.models.vo.WechatMessageLogVO;
import com.bizvane.utils.responseinfo.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 记录发送图文模板消息日志
 * 
 */
@Service
public class WechatTuWenMessageLogServiceImpl implements WechatTuWenMessageLogService {

  @Autowired
  private WechatTuWenLogPOMongoDao wechatTuWenLogPOMongoDao;
  
  

  public Result<String> insert(MsgWxTuWenPO po) {

    po.setSendState(SystemConstants.WECHAT_MESSAGE_LOG_SEND_STATE_CREATE);
    po.setCreateDate(new Date());

//    this.MsgWxTuWenPOmapper.insert(po);
    //改mongdb
    String logid = wechatTuWenLogPOMongoDao.saveRocketLogPO(po);

    Result<String> result = new Result<>();
    result.setData(logid);

    return result;
  }

  @Override
  public Result<Object> update(MsgWxTuWenPO po) {
    po.setUpdateDate(new Date());
    wechatTuWenLogPOMongoDao.updateRocketLogPO(po);

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

    PageInfo<MsgWxTuWenPO> pageInfo = wechatTuWenLogPOMongoDao.getRocketLogPOList(vo);

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
      PageInfo<MsgWxTuWenPO> pageInfolist= wechatTuWenLogPOMongoDao.getRocketLogPOList(smsMessageLogVo);
      Long allCountSms =pageInfolist.getTotal();
      
      //发送微信成功的总条数
        smsMessageLogVo.setSendState("10");
        PageInfo<MsgWxTuWenPO> pageInfosuccessSmslist = wechatTuWenLogPOMongoDao.getRocketLogPOList(smsMessageLogVo);
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

@Override
public Result<Object> update(MsgWxTuWenPO po, MsgWxLogPOExample example) {
	// TODO Auto-generated method stub
	return null;
}


}
