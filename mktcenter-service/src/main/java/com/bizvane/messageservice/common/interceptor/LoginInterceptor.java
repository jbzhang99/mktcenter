//package com.bizvane.messageservice.common.interceptor;
//
//import com.bizvane.centerstageservice.models.po.SysAccountPo;
//import com.bizvane.messageservice.common.constants.SysResponseEnum;
//import com.bizvane.messageservice.common.utils.HttpUtils;
//import com.bizvane.messageservice.common.utils.WebUtils;
//import com.bizvane.utils.responseinfo.ResponseData;
//import com.bizvane.utils.tokens.JWTUtil;
//import com.google.gson.Gson;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class LoginInterceptor implements HandlerInterceptor {
//
//    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        logger.info("-------------前置拦截---------------" + request.getRequestURI() + "---" + request.getContextPath());
//        response.setContentType("text/html;charset=utf-8");
//
//        String token = request.getHeader("token");
//        logger.info("token--------------------------" + token);
//
//        if (StringUtils.isBlank(token)) {
//          ResponseData<Object> responseData = new ResponseData<>();
//          responseData.setCode(SysResponseEnum.SYSTEM_NOT_LOGIN.getCode());
//          responseData.setMessage(SysResponseEnum.SYSTEM_NOT_LOGIN.getMessage());
//          response.getWriter().write(new Gson().toJson(responseData));
//          return false;
//        }
//
//        SysAccountPo loginUser = JWTUtil.unsign(token, SysAccountPo.class);
//        if (loginUser == null) {
//          ResponseData<Object> responseData = new ResponseData<>();
//          responseData.setCode(SysResponseEnum.SYSTEM_NOT_LOGIN.getCode());
//          responseData.setMessage(SysResponseEnum.SYSTEM_NOT_LOGIN.getMessage());
//          response.getWriter().write(new Gson().toJson(responseData));
//          return false;
//        }
//
//        WebUtils.setLoginUser(loginUser);
//        long time = 30 * 60 * 1000;//30分钟
//        String sign = JWTUtil.sign(loginUser, time);
//
//        HttpUtils.editCookie(request.getCookies(), response, "token", sign);
//        return Boolean.TRUE;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
//
//    public static void main(String[] args) {
//      SysAccountPo loginUser = new SysAccountPo();
//      loginUser.setCtrlAccountId(666666L);
//      loginUser.setName("张小三");
//
//      String sign = JWTUtil.sign(loginUser, 10 * 1000);
//      System.out.println(sign);
//
//      SysAccountPo sysAccountPo = JWTUtil.unsign(sign, SysAccountPo.class);
//
//      System.out.println(sysAccountPo);
//    }
//}
