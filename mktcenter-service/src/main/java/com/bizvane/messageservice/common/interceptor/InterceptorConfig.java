//package com.bizvane.messageservice.common.interceptor;
//
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
///**
// * @author hll
// * @date 2018年1月6日 上午11:23:37
// */
////@Configuration
//public class InterceptorConfig extends WebMvcConfigurationSupport  {
//
//    public void addInterceptors(InterceptorRegistry registry) {
//        //addPathPatterns 用于添加拦截规则
//        //excludePathPatterns 用于排除拦截
//        List<String> pathPatterns = new ArrayList<>();
//        pathPatterns.add("/*/*/*");
//        pathPatterns.add("/*/*");
//        pathPatterns.add("/*");
//
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns(pathPatterns);
//        super.addInterceptors(registry);
//    }
//}