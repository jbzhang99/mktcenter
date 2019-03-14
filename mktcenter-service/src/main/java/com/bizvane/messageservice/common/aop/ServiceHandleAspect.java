package com.bizvane.messageservice.common.aop;

import com.bizvane.messageservice.common.constants.SysRespConstants;
import com.bizvane.messageservice.common.utils.BusinessException;
import com.bizvane.messagefacade.models.vo.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 服务切面 1：处理参数校 2：处理异常信
 *
 * @author
 */
public class ServiceHandleAspect {

  private static final Logger logger = LoggerFactory.getLogger(ServiceHandleAspect.class);

  @SuppressWarnings("unchecked")
  public Object checkAndExceptionHandle(ProceedingJoinPoint pjp) throws Throwable {
    Signature signature = pjp.getSignature();
    Class<?> returnType = ((MethodSignature) signature).getReturnType();
    if (!returnType.isAssignableFrom(Result.class)) {
      return pjp.proceed();
    }
    Result<Object> result = new Result<>();
    try {
      result = (Result<Object>) pjp.proceed();
      if (result.getStatus() == 0) {
        result.setStatus(SysRespConstants.SUCCESS.getStatus());
        result.setMsg(SysRespConstants.SUCCESS.getMsg());
      }
    } catch (Exception e) {
      ServiceHandleAspect.logger.error("ERROR::", e);
      if (!(e instanceof BusinessException)) {
        e = (Exception) e.getCause();
      }
      if (e instanceof BusinessException) {
        result.setStatus(((BusinessException) e).getStatus());
        result.setMsg(((BusinessException) e).getStatus() + "：" + ((BusinessException) e).getMsg());
        ServiceHandleAspect.logger.error("BusinessException:" + ((BusinessException) e).getStatus());
      } else {
        result.setStatus(SysRespConstants.FAILED.getStatus());
        result.setMsg(SysRespConstants.FAILED.getMsg());
      }
    }
    return result;
  }
}
