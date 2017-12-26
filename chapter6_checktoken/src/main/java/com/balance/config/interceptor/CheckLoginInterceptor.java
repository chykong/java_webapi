package com.balance.config.interceptor;

import com.balance.util.json.GlobalReturnCode;
import com.balance.util.json.JsonResult;
import com.balance.util.json.JsonUtil;
import com.balance.util.string.StringUtil;
import com.balance.util.token.TokenUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 校验是否登录
 *
 * @author 孔垂云 on 2017/8/18.
 */
public class CheckLoginInterceptor implements HandlerInterceptor {

    /**
     * 操作前先判断是否登录，未登录提示未登录
     *
     * @param request  request
     * @param response response
     * @param handler  handler
     * @return 处理是否成功
     * @throws Exception 异常
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (StringUtil.isNullOrEmpty(request.getHeader("Authorization")) || TokenUtil.getToken(request) == null) {
            //状态设置为未授权
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            StringUtil.out(response, JsonUtil.toStr(new JsonResult(false, GlobalReturnCode.NO_AUTH)));
            return false;
        } else {
            return true;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
