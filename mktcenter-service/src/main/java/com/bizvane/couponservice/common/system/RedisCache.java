package com.bizvane.couponservice.common.system;

import com.bizvane.couponservice.common.utils.CouponSpringContextUtil;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Micro
 * @date 2018/6/15 18:16
 */
public class RedisCache implements Cache {

    private static final Logger logger = LoggerFactory.getLogger(com.bizvane.utils.redisutils.RedisCache.class);

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private final String id; // cache instance id

    private RedisTemplate<Object, Object> redisTemplate;

    private static final long EXPIRE_TIME = 120; // redis过期时间

    public RedisCache(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    /**
     * Put query result to redis
     *
     * @param key
     * @param value
     */
    @Override
    public void putObject(Object key, Object value) {
        RedisTemplate<Object, Object> redisTemplate = this.getRedisTemplate();
        ValueOperations<Object, Object> opsForValue = redisTemplate.opsForValue();
        opsForValue.set(key, value, RedisCache.EXPIRE_TIME, TimeUnit.SECONDS);
        RedisCache.logger.debug("Put query result to redis");
    }

    /**
     * Get cached query result from redis
     *
     * @param key
     * @return
     */
    @Override
    public Object getObject(Object key) {
        RedisTemplate<Object, Object> redisTemplate = this.getRedisTemplate();
        ValueOperations<Object, Object> opsForValue = redisTemplate.opsForValue();
        RedisCache.logger.debug("Get cached query result from redis");
        return opsForValue.get(key);
    }

    /**
     * Remove cached query result from redis
     *
     * @param key
     * @return
     */
    @Override
    public Object removeObject(Object key) {
        RedisTemplate<Object, Object> redisTemplate = this.getRedisTemplate();
        redisTemplate.delete(key);
        RedisCache.logger.debug("Remove cached query result from redis");
        return null;
    }

    /**
     * Clears this cache instance
     */
    @Override
    public void clear() {
        RedisTemplate<Object, Object> redisTemplate = this.getRedisTemplate();
        redisTemplate.execute((RedisCallback<Object>) connection -> {
            connection.flushDb();
            return null;
        });
        RedisCache.logger.debug("Clear all the cached query result from redis");
    }

    @Override
    public int getSize() {
        RedisTemplate<Object, Object> redisTemplate = this.getRedisTemplate();
        return redisTemplate.getConnectionFactory().getConnection().dbSize().intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }

    @SuppressWarnings("unchecked")
    private RedisTemplate<Object, Object> getRedisTemplate() {
        if (this.redisTemplate == null) {
            this.redisTemplate = (RedisTemplate<Object, Object>) CouponSpringContextUtil.getBean("redisTemplate");
        }
        return this.redisTemplate;
    }
}
