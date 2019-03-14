package com.bizvane.messageservice.common.redis;

import com.bizvane.messageservice.common.utils.MessageSpringContextUtil;
import com.bizvane.utils.redisutils.RedisClient;
import org.springframework.stereotype.Component;

/**
 * Created by paco on 2017/4/12.
 */

@Component
public class RedisManager {
  
    public static synchronized RedisClient getInstince(){
        return (RedisClient) MessageSpringContextUtil.getBean(RedisClient.class);
    }
}