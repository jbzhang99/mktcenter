package com.bizvane.mktcenterserviceimpl.common.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author chen.li
 * @date on 2018/8/11 11:17
 * @description 线程池配置类
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Configuration
@EnableAsync
public class MktExecutorConfig {

    @Value("${threadPool.corePoolSize}")
    private int corePoolSize;

    @Value("${threadPool.maximumPoolSize}")
    private int maxPoolSize;

    @Value("${threadPool.queueCapacity}")
    private int queueCapacity;

    @Value("${threadPool.keepAliveTime}")
    private int keepAliveTime;

    @Bean
    public Executor asyncServiceExecutor() {
        VisiableThreadPoolTaskExecutor executor = new VisiableThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(corePoolSize);
        //配置最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        //配置队列大小
        executor.setQueueCapacity(queueCapacity);
        //线程活跃时间
        executor.setKeepAliveSeconds(keepAliveTime);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("async-service-");

        // rejection-policy：拒绝策略，当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }
}
