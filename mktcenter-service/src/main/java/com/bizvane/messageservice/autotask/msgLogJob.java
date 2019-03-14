package com.bizvane.messageservice.autotask;

import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.common.network.HttpClient;
import com.bizvane.messageservice.mongo.MsgSmsLogPOMongoDao;
import com.bizvane.messagefacade.models.po.MsgSmsLogPO;
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class msgLogJob {
	
    public static String account = "JJ0253";
    public static String pswd = "513678";
    
    @Autowired
    private MsgSmsLogPOMongoDao msgSmsLogPOMongoDao;
	
//  梦网3.4批量群发回执获取，每30s启动
    
//    @Scheduled(cron = "0/30 * * * * ?")
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
//      log.info("=====>>>>>梦网3.4批量短信获取发送状态自动任务msgLogJob  {}",returns2);
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
        			  msgSmsLogPO.setSendState(SystemConstants.SMS_MESSAGE_LOG_SEND_STATE_SUCCESS);
        			  msgSmsLogPO.setResultInfo("成功");
        			  msgSmsLogPO.setUpdateDate(new Date());
        		  }else {
        			  msgSmsLogPO.setSendState(SystemConstants.SMS_MESSAGE_LOG_SEND_STATE_FAIL);
        			  msgSmsLogPO.setResultInfo("失败");
        			  msgSmsLogPO.setUpdateDate(new Date());
        		  }
        		  
        	  }
        	  i++;
          }
        
         msgSmsLogPOMongoDao.MsgSmsLogPOBymemberPhone(msgSmsLogPO);
        
      }
      
    }

    public   void scheduledjob() throws IOException, DocumentException{
//        log.info("=====>>>>>梦网3.4批量短信获取发送状态自动任务msgLogJob1  {}",System.currentTimeMillis());
      //创建一个可重用固定线程数的线程池
        for(int i= 0;i<30;i++) {
        ExecutorService pool = Executors.newFixedThreadPool(80);
                           pool.execute(new Runnable() {
                                public void run() {
                                    try {

                                  	  scheduled() ;

                                    } catch (IOException e) {
  									e.printStackTrace();
  								} catch (DocumentException e) {
  									e.printStackTrace();
  								}
                                }
                            });
        pool.shutdown();
        
        }
  }

    

}
