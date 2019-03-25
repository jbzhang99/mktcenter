//package com.bizvane.mktcenterserviceimpl.common.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.ctrip.framework.apollo.Config;
//import com.ctrip.framework.apollo.model.ConfigChangeEvent;
//import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
//import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
//import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//
///**
// * @author xiao.shu
// * @date on 2018/8/30 21:39
// * @description
// * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
// */
//@Configuration
//@EnableApolloConfig
//@Primary //在同样的DataSource中，首先使用被标注的DataSource
//public class DruidConfig {
//
//    @ApolloConfig("application")
//    private Config applicationConfig; //inject config for namespace application
//
//    @Value("${spring.datasource.url}")
//    private String dbUrl;
//    @Value("${spring.datasource.username}")
//    private String username;
//    @Value("${spring.datasource.password}")
//    private String password;
//    @Value("${spring.datasource.driver-class-name}")
//    private String driverClassName;
//
//    //声明其为Bean实例
//    @Bean
//    public DataSource dataSource(){
//        DruidDataSource datasource = new DruidDataSource();
//        datasource.setUrl(this.dbUrl);
//        datasource.setUsername(username);
//        datasource.setPassword(password);
//        datasource.setDriverClassName(driverClassName);
//
//        //configuration
////        datasource.setInitialSize(initialSize);
////        datasource.setMinIdle(minIdle);
////        datasource.setMaxActive(maxActive);
////        datasource.setMaxWait(maxWait);
////        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
////        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
////        datasource.setValidationQuery(validationQuery);
////        datasource.setTestWhileIdle(testWhileIdle);
////        datasource.setTestOnBorrow(testOnBorrow);
////        datasource.setTestOnReturn(testOnReturn);
////        datasource.setPoolPreparedStatements(poolPreparedStatements);
////        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
////        try {
////            datasource.setFilters(filters);
////        } catch (SQLException e) {
////            logger.error("druid configuration initialization filter", e);
////        }
////        datasource.setConnectionProperties(connectionProperties);
//        return datasource;
//    }
//
//}
