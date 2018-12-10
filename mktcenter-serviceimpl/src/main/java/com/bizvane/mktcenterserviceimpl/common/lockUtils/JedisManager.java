package com.bizvane.mktcenterserviceimpl.common.lockUtils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * @Author: lijunwei
 * @Time: 2018/12/9 20:27
 */
@Configuration
public class JedisManager {
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.database}")
    private int database;

    @Bean
    public Jedis getRedis(){
        Jedis jedis = new Jedis(host, port);
        jedis.auth(password);
        jedis.select(database);
        return jedis;
    }
}
