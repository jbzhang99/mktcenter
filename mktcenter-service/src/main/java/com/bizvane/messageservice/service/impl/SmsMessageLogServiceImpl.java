package com.bizvane.messageservice.service.impl;

import com.bizvane.messageservice.common.constants.SysResponseEnum;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.common.utils.PageForm;
import com.bizvane.messageservice.mappers.MsgSmsLogPOMapper;
import com.bizvane.messageservice.mongo.MsgSmsLogPOMongoDao;
import com.bizvane.messageservice.mongo.MsgSmsLogPOMongoDaotest;
import com.bizvane.messageservice.service.SmsMessageLogService;
import com.bizvane.messagefacade.models.po.MsgSmsLogPO;
import com.bizvane.messagefacade.models.po.MsgSmsLogPOExample;
import com.bizvane.messagefacade.models.vo.GenrealGetMessageVO;
import com.bizvane.messagefacade.models.vo.Result;
import com.bizvane.messagefacade.models.vo.SmsMessageLogVo;
import com.bizvane.messagefacade.models.vo.SmsStatisticsVO;
import com.bizvane.utils.responseinfo.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Geng on 2018/8/9.
 */
@Service
public class SmsMessageLogServiceImpl implements SmsMessageLogService{

    @Autowired
    private MsgSmsLogPOMongoDao msgSmsLogPOMongoDao;
    
    @Autowired
    private MsgSmsLogPOMapper msgSmsLogPOMapper;
    
    @Autowired
    private MsgSmsLogPOMongoDaotest msgSmsLogPOMongoDaotest;
    
    public Result<String> insert(MsgSmsLogPO po) {

        po.setSendState(SystemConstants.SMS_MESSAGE_LOG_SEND_STATE_CREATE);
        po.setCreateDate(new Date());

        msgSmsLogPOMongoDao.saveRocketLogPO(po);

        Result<String> result = new Result<>();
        result.setData(po.get_id());

        return result;
      }
    
    public Result<String> insertCreateDate(List<MsgSmsLogPO> po) {

       
        msgSmsLogPOMongoDao.saveMsgSmsLogPOList(po);
        Result<String> result = new Result<>();
        result.setData("1");

        return result;
      }

      @Override
      public Result<Object> update(MsgSmsLogPO po) {
        po.setUpdateDate(new Date());
        
        if(po.getSendState()==1){
        	po.setResultInfo("成功");
        	po.setResultInfoDetail("");
        }else {
        	po.setResultInfo("失败");
        }
        po.setUpdateDate(new Date());
        msgSmsLogPOMongoDao.updateRocketLogPO(po);

        return new Result<>();
      }
      
      @Override
      public  PageInfo<MsgSmsLogPO> rocketLogPOList( SmsMessageLogVo msgSmsLogPO, PageForm pageForm) {

    	  PageInfo<MsgSmsLogPO>  rocketLogPOList =msgSmsLogPOMongoDao.getRocketLogPOList(  msgSmsLogPO,  pageForm);

        return rocketLogPOList;
      }
      
      
      
      
      @Override
      public Result<Object> update(MsgSmsLogPO po, MsgSmsLogPOExample example) {
        po.setUpdateDate(new Date());

        this.msgSmsLogPOMapper.updateByExampleSelective(po, example);

        return new Result<>();
      }


    /**
     * 获取
     * @param smsMessageLogVo
     * @param pageForm
     * @return
     */

    @Override
    public ResponseData<Object> getMsgLogPage(SmsMessageLogVo smsMessageLogVo, PageForm pageForm){

    	ResponseData<Object> responseData = new ResponseData();

        try {
//            PageHelper.startPage(pageForm.getPageNum(),pageForm.getPageSize());

//            List<MsgSmsLogPO> msgSmsLogPOList = msgSmsLogPOMapper.getMsgLogPage(smsMessageLogVo);
            //改到monggodb
        	 PageInfo<MsgSmsLogPO> pageInfo =msgSmsLogPOMongoDao.getRocketLogPOList( smsMessageLogVo,pageForm);
//            List<MsgSmsLogPO>  list =msgSmsLogPOMongoDaotest.getRocketLogPOList( smsMessageLogVo,pageForm);
            

            responseData.setData(pageInfo);
            responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
            
            
        	

        }catch (Exception e){
            e.printStackTrace();
            responseData.setMessage(SysResponseEnum.FAILED.getMessage());
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            return responseData;
        }



        return responseData;

    }

    /**
     * 短信发送统计
     * @param smsMessageLogVo
     * @return
     */
    @Override
    public ResponseData getStatistics(SmsMessageLogVo smsMessageLogVo) {
        ResponseData responseData = new ResponseData();
        //根据条件查询发送短信的总条数
    	PageForm pageForm = new PageForm();
        pageForm.setPageNum(smsMessageLogVo.getPageNumber());
        pageForm.setPageSize(smsMessageLogVo.getPageSize());
        //发送短信的总条数
        PageInfo<MsgSmsLogPO> pageInfolist= msgSmsLogPOMongoDao.getRocketLogPOList(smsMessageLogVo,pageForm);
        Long allCountSms =pageInfolist.getTotal();
        
        //发送短信成功的总条数
          smsMessageLogVo.setSendState(1);
          PageInfo<MsgSmsLogPO> pageInfosuccessSmslist = msgSmsLogPOMongoDao.getRocketLogPOList(smsMessageLogVo,pageForm);
          Long successSms =pageInfosuccessSmslist.getTotal();
        //发送短信失败的总条数
        /*criteria.andSendStateEqualTo(-1);
        Long failedSms = msgSmsLogPOMapper.countByExample(msgSmsLogPOExample);*/
        Long failedSms =allCountSms-successSms;


        //短信发送触达率
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
    
    
    /**
     * 批量短信发送统计
     * @param smsMessageLogVo
     * @return
     */
    @Override
    public ResponseData<Object> getReturnMessage(GenrealGetMessageVO genrealGetMessageVO) {
    	ResponseData<Object> responseData = new ResponseData<Object>();
        //根据条件查询发送短信的总条数
    	PageForm pageForm = new PageForm();
        pageForm.setPageNum(1);
        pageForm.setPageSize(10);
        //发送短信的总条数
        PageInfo<MsgSmsLogPO> pageInfolist= msgSmsLogPOMongoDao.getReturnMessage(genrealGetMessageVO,null,pageForm);
        Long allCountSms =pageInfolist.getTotal();
        
        //发送短信成功的总条数
//          smsMessageLogVo.setSendState(1);
          PageInfo<MsgSmsLogPO> pageInfosuccessSmslist = msgSmsLogPOMongoDao.getReturnMessage(genrealGetMessageVO,1,pageForm);
          Long successSms =pageInfosuccessSmslist.getTotal();
        //发送短信失败的总条数
        Long failedSms =allCountSms-successSms;

        //短信发送触达率
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
