package com.bizvane.mktcenterserviceimpl.common.lockUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * @Author: lijunwei
 * @Time: 2018/12/9 20:32
 */
@Component
public class JedisLock {
    @Autowired
    private Jedis jedis;

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    /**
     * 尝试获取分布式锁
     * @return 是否获取成功
     */
    public  boolean tryGetDistributedLock() {
        String result = jedis.set("lock-Key", "lock-value", SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, 20000);
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    private static final Long RELEASE_SUCCESS = 1L;
    /**
     * 释放分布式锁
     * @return 是否释放成功
     */
    public  boolean releaseDistributedLock() {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList("lock-Key"), Collections.singletonList("lock-value"));
        if (RELEASE_SUCCESS.equals(result)) {
            System.out.println("删除成功!");
            return true;
        }
        return false;

    }
}
