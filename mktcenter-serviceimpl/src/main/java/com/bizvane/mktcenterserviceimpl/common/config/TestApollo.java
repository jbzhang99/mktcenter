//package com.bizvane.mktcenterserviceimpl.common.config;
//
//import com.ctrip.framework.apollo.Config;
//import com.ctrip.framework.apollo.model.ConfigChangeEvent;
//import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
//import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
//import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//
///**
// * @author xiao.shu
// * @date on 2018/8/30 21:05
// * @description
// * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
// */
//@Component
//@EnableApolloConfig
//public class TestApollo {
////    @ApolloConfig
////    private Config config; //inject config for namespace application
//    @ApolloConfig("application")
//    private Config applicationConfig; //inject config for namespace application
////    @ApolloConfig("FX.apollo")
////    private Config yetAnotherConfig; //inject config for namespace FX.apollo
//
//    @Value("${batch:100}")
//    private int batch;
//
//    //config change listener for namespace application
//    @ApolloConfigChangeListener
//    private void someOnChange(ConfigChangeEvent changeEvent) {
//        //update injected value of batch if it is changed in Apollo
//        if (changeEvent.isChanged("spring.datasource.url")) {
//            batch = applicationConfig.getIntProperty("spring.datasource.url", 100);
//        }
//    }
//
//    //config change listener for namespace application
//    @ApolloConfigChangeListener("application")
//    private void anotherOnChange(ConfigChangeEvent changeEvent) {
//        //do something
//    }
//
//    //config change listener for namespaces application and FX.apollo
//    @ApolloConfigChangeListener({"application", "FX.apollo"})
//    private void yetAnotherOnChange(ConfigChangeEvent changeEvent) {
//        //do something
//    }
//
//    //example of getting config from Apollo directly
//    //this will always return the latest value of timeout
//    public int getTimeout() {
//        return applicationConfig.getIntProperty("timeout", 200);
//    }
//
//    //example of getting config from injected value
//    //the program needs to update the injected value when batch is changed in Apollo using @ApolloConfigChangeListener shown above
//    public int getBatch() {
//        return this.batch;
//    }
//
//    @PostConstruct
//    public void getConfig(){
//        System.out.println(applicationConfig);
//    }
//}
