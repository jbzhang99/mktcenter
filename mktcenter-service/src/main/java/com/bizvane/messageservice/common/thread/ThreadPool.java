package com.bizvane.messageservice.common.thread;

import com.bizvane.couponservice.common.system.DictHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * 线程池
 * 
 * @author 董争光 2018年5月21日下午1:44:45
 */
@Service
public class ThreadPool implements InitializingBean {
  
  @Value("${threadPool.corePoolSize}")
  private int corePoolSize;
  
  @Value("${threadPool.maximumPoolSize}")
  private int maximumPoolSize;
  
  @Value("${threadPool.keepAliveTime}")
  private long keepAliveTime;

  private static ExecutorService executorService;

  private static final Logger logger = LoggerFactory.getLogger(ThreadPool.class);

  public static void init() {
    ThreadPool.logger.info("ThreadPool初始化开始");
    int corePoolSize = Integer.valueOf(DictHelper.getDict("threadPool", "corePoolSize").getItemCodeName());
    int maximumPoolSize = Integer.valueOf(DictHelper.getDict("threadPool", "maximumPoolSize").getItemCodeName());
    long keepAliveTime = Integer.valueOf(DictHelper.getDict("threadPool", "keepAliveTime").getItemCodeName());
    ThreadPool.executorService = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS,
        new SynchronousQueue<Runnable>());
    ThreadPool.logger.info("ThreadPool初始化结束");
  }

  /**
   * 默认构造方法
   */
  private ThreadPool() {

  }

  /**
   * 启动一个线程
   * 
   * @param runnable
   */
  public static void run(Runnable runnable) {

    ThreadPool.executorService.execute(runnable);
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    // TODO Auto-generated method stub
    executorService = new ThreadPoolExecutor(corePoolSize,
        maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
  }
  
  
}
