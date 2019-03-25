package com.bizvane.couponservice.common.aop;

import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.exception.BizException;
import com.bizvane.utils.responseinfo.ResponseData;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 服务切面 1：处理参数校 2：处理异常信
 *
 * @author
 */
@Aspect
@Component
public class ServiceHandleAspect {

  @Pointcut("execution(* com.bizvane.couponservice.service..*.*(..))")
  public void serviceMethod(){}
  
  private static final Logger logger = LoggerFactory.getLogger(ServiceHandleAspect.class);

  @Around("serviceMethod()")
  @SuppressWarnings("unchecked")
  public Object checkAndExceptionHandle(ProceedingJoinPoint pjp) throws Throwable {
    Signature signature = pjp.getSignature();
    Class<?> returnType = ((MethodSignature) signature).getReturnType();
    if (!returnType.isAssignableFrom(ResponseData.class)) {
      return pjp.proceed();
    }
    ResponseData<Object> result = new ResponseData<>();
    try {
      result = (ResponseData<Object>) pjp.proceed();
      if (result.getCode() == 0) {
        result.setCode(SysResponseEnum.SUCCESS.getCode());
        result.setMessage(SysResponseEnum.SUCCESS.getMessage());
      }
    } catch (Exception e) {
      ServiceHandleAspect.logger.error("ERROR::", e);
      if (e instanceof BizException) {
        result.setCode(((BizException) e).getCode());
        result.setMessage(((BizException) e).getMessage());
        ServiceHandleAspect.logger.error("BusinessException:" + ((BizException) e).getCode());
      } else {
        result.setCode(SysResponseEnum.FAILED.getCode());
        result.setMessage(SysResponseEnum.FAILED.getMessage());
      }
    }
    return result;
  }
}
