package com.bizvane.messageservice.autotask;

import com.alibaba.fastjson.JSON;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.common.sms.request.SmsReportRequest;
import com.bizvane.messageservice.common.sms.response.SmsReportResponse;
import com.bizvane.messageservice.common.sms.response.SmsResult;
import com.bizvane.messageservice.common.sms.util.ChuangLanSmsUtil;
import com.bizvane.messageservice.mappers.SysSmsConfigPOMapper;
import com.bizvane.messageservice.mongo.MsgSmsLogPOMongoDao;
import com.bizvane.messagefacade.models.po.MsgSmsLogPO;
import com.bizvane.messagefacade.models.po.SysSmsConfigPO;
import com.bizvane.messagefacade.models.po.SysSmsConfigPOExample;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Slf4j
@JobHandler(value="msmChuangLanlJob")
@Component
public class msmChuangLanlJob extends IJobHandler {
	
    @Autowired
    private MsgSmsLogPOMongoDao msgSmsLogPOMongoDao;
	
    @Autowired
    private SysSmsConfigPOMapper sysSmsConfigPOMapper;
    
    public static String smsReportRequestUrl = "https://smssh1.253.com/msg/pull/report";

	@Override
	public ReturnT<String> execute(String param) throws Exception {
		XxlJobLogger.log("XXL-JOB, 创蓝短信定时任务msmChuangLanlJob");
		
//	    todo每个账号抓取
        //获取短信通道 sysBrandId
        SysSmsConfigPOExample sysSmsConfigPOExample = new SysSmsConfigPOExample();
        sysSmsConfigPOExample.createCriteria().andChannelNameEqualTo("chuangLan253").andChannelTypeEqualTo(10).andValidEqualTo(Boolean.TRUE);
        List<SysSmsConfigPO> sysSmsConfigList= sysSmsConfigPOMapper.selectByExample(sysSmsConfigPOExample);
	    for(SysSmsConfigPO sysSmsConfigPO :sysSmsConfigList) {
			scheduled(sysSmsConfigPO.getChannelAccount(),sysSmsConfigPO.getChannelPassword(),smsReportRequestUrl);
	    }

		return SUCCESS;
	}
	
	
    public  void scheduled(String account, String pswd, String smsReportRequestUrl) throws IOException, DocumentException {
    	  
		//状态报告拉取条数
		String count = "500";
		
		SmsReportRequest smsReportRequest = new SmsReportRequest(account, pswd, count);

		String requestJson = JSON.toJSONString(smsReportRequest);

		String response = ChuangLanSmsUtil.sendSmsByPost(smsReportRequestUrl, requestJson);

		SmsReportResponse smsReportRespnse = JSON.parseObject(response, SmsReportResponse.class);
		
		log.info("=====>>>>>创蓝短信定时任务状态报告拉取条数msmChuangLanlJob"+account+"条"+smsReportRespnse.getResult().size());

//		System.out.println("XXL-JOB - response  toString is : " + response);
		for(SmsResult smsResult : smsReportRespnse.getResult()) {
			
			 MsgSmsLogPO msgSmsLogPO  = new MsgSmsLogPO();
			 msgSmsLogPO.setMemberPhone(smsResult.getMobile());
			 msgSmsLogPO.setBussinessId(smsResult.getUid());
			
			 if(smsResult.getStatus().equals("DELIVRD")) {
				 msgSmsLogPO.setResultInfo("成功");
				 msgSmsLogPO.setSendState(SystemConstants.SMS_MESSAGE_LOG_SEND_STATE_SUCCESS);
			 }else {
				 msgSmsLogPO.setResultInfo("失败");
				 msgSmsLogPO.setSendState(SystemConstants.SMS_MESSAGE_LOG_SEND_STATE_FAIL) ;
				 msgSmsLogPO.setResultInfoDetail(smsResult.getStatusDesc());
			 }
			
			msgSmsLogPOMongoDao.MsgSmsLogPOBymemberPhone(msgSmsLogPO);
			
		}
		
		
         
        
      
    }

}
