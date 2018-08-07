package com.bizvane.mktcenterserviceimpl.common.aspect;

import com.bizvane.utils.responseinfo.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author chen.li
 * @date on 2018/8/7 13:32
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Aspect
@Component
@Slf4j
public class AwardAspect {

    /**
     * 奖励切点
     */
    @Pointcut("execution(* com.bizvane.mktcenterserviceimpl.common.award.AwardFactory.*(..))")
    public void pointcut() {
    }

    /**
     * 环绕
     * @param proceedingJoinPoint
     * @return
     */
    @Around("pointcut()")
    public Object pointcut(ProceedingJoinPoint proceedingJoinPoint){
        Object object = null;
        log.info("================营销奖励环绕切面-start===============");
        long start = System.currentTimeMillis();
        try {
            //原业务方法执行，并获取返回值
            object =proceedingJoinPoint.proceed();
            ResponseData result = (ResponseData) object;
            if (result!=null) {
                if (result.getCode()!=0) {
                    //如果不为0，代表异常
                    log.error("=======sorry award failed=========");
                }
            }
            long end = System.currentTimeMillis();
            //不管日志配置是否配置了info级别日志输出，如果直接logger.info都会拼接字符串，加上判断可以过滤拼接过程
            if(log.isInfoEnabled()){
                log.info("around:" + proceedingJoinPoint + "\tUse time : " + (end - start) + " ms!");
            }
            log.info("=================营销奖励环绕切面-end===============");
        }catch (Throwable e){
            long end = System.currentTimeMillis();
            if(log.isInfoEnabled()){
                log.info("around:" + proceedingJoinPoint + "\tUse time : " + (end - start) + " ms with exception : " + e.getMessage());
            }
        }
        return object;
    }
}
