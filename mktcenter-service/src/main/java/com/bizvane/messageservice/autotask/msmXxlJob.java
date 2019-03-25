package com.bizvane.messageservice.autotask;

import com.bizvane.messageservice.common.network.HttpClient;
import com.bizvane.messageservice.mongo.MsgSmsLogPOMongoDao;
import com.bizvane.messagefacade.models.po.MsgSmsLogPO;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Request;
import okhttp3.Response;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

@Slf4j
//@JobHandler(value="msmXxlJob")
@Component
public class msmXxlJob extends IJobHandler {
	
    @Autowired
    private MsgSmsLogPOMongoDao msgSmsLogPOMongoDao;
	
    public static String account = "JJ0253";
    public static String pswd = "513678";

	@Override
	public ReturnT<String> execute(String param) throws Exception {
		XxlJobLogger.log("XXL-JOB, 短信定时任务msmXxlJob");
		scheduled();
		return SUCCESS;
	}
	
	
    public  void scheduled() throws IOException, DocumentException {

//      获取状态
      StringBuilder urlParams2 = new StringBuilder();
      urlParams2.append("http://TSN19.800CT.COM:8901/MWGate/wmgw.asmx/MongateGetDeliver");
      urlParams2.append("?userId=%s&password=%s&iReqType=2");
      String  msgPath2=  String.format(urlParams2.toString(), account,pswd);
      HttpClient httpClient=new HttpClient();
      Request request2 = new Request.Builder().url(msgPath2).addHeader("Host", "192.169.1.130").addHeader("Content-Type", "application/x-www-form-urlencoded").addHeader("Connection", "Close").build();
      Response response2 = httpClient.post(request2);    
      String returns2 = response2.body().string();
      Document document2 = DocumentHelper.parseText(returns2);
      Element rootElt2 = document2.getRootElement(); // 获取根节点
      Iterator iter = rootElt2.elementIterator("string"); // 获取根节点下的子节点string
      // 遍历string节点
      MsgSmsLogPO msgSmsLogPO =new MsgSmsLogPO();
      log.info("=====>>>>>梦网3.4批量短信获取发送状态自动任务msgLogJob  {}");
      while (iter.hasNext()) {
          Element recordEle = (Element) iter.next();
          int i =1;
          
          for(String stringdata :recordEle.getText().split(",")){
        	  if(i<5) {
        	  }else if(i==5) {
        		  msgSmsLogPO.setMemberPhone(stringdata);
        	  }else if(i==6) {
        		  msgSmsLogPO.setBussinessId(stringdata);
        	  }else if(i==8) {
        		  if(stringdata.equals("0")) {
        			  msgSmsLogPO.setSendState(1);
        			  msgSmsLogPO.setResultInfo("成功");
        			  msgSmsLogPO.setUpdateDate(new Date());
        		  }else {
        			  msgSmsLogPO.setSendState(-1);
        			  msgSmsLogPO.setResultInfo("失败");
        			  msgSmsLogPO.setUpdateDate(new Date());
        		  }
        		  
        	  }
        	  i++;
          }
          msgSmsLogPO.setResultInfoDetail(recordEle.getText());
         msgSmsLogPOMongoDao.MsgSmsLogPOBymemberPhone(msgSmsLogPO);
        
      }
      
    }

}
