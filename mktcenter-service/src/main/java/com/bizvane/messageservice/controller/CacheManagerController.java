package com.bizvane.messageservice.controller;

import com.bizvane.couponservice.service.DictService;
import com.bizvane.messageservice.common.thread.ThreadPool;
import com.bizvane.messageservice.template.AuthorizeUtil;
import com.bizvane.messagefacade.models.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 缓存管理类
 * 
 * @author 董争光 2018年5月21日下午1:53:53
 */
@Controller
@RequestMapping("/cacheManager")
public class CacheManagerController {

  @Autowired
  private DictService dictService;
  
  @Autowired
  private AuthorizeUtil authorizeUtil;

  /**
   * 刷新系统缓存
   * 
   * @return
   */
  @RequestMapping(value = "/refreshDict")
  @ResponseBody
  public Result<Object> sendSimple() {
    this.dictService.init();
    return new Result<>();
  }

  /**
   * 刷新获取公众号token的url地址
   * 
   * @return
   */
  @RequestMapping(value = "/refreshGetAccessTokenUrl")
  @ResponseBody
  public Result<Object> refreshGetAccessTokenUrl() {
//    authorizeUtil.initGetAccessTokenUrl();
    return new Result<>();
  }

  /**
   * 刷新线程池连接属性，慎用
   * 
   * @return
   */
  @RequestMapping(value = "/refreshThreadPool")
  @ResponseBody
  public Result<Object> refreshThreadPool() {
    ThreadPool.init();
    return new Result<>();
  }
  
  /**
   * 刷新redis缓存
   * @return
   */
  @RequestMapping(value = "/refreshRedisCache")
  @ResponseBody
  public Result<Object> refreshRedisCache() {
    /*RedisConnection connection = null;
    try {
      connection = RedisCache.jedisConnectionFactory.getConnection();
      connection.flushDb();
    } catch (JedisConnectionException e) {
      e.printStackTrace();
    } finally {
      if (connection != null) {
        connection.close();
      }
    }*/
    return new Result<>();
  }



}
