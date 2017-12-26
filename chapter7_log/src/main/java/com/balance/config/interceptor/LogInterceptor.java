package com.balance.config.interceptor;

import com.balance.model.User;
import com.balance.util.string.StringUtil;
import com.balance.util.token.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 记录管理端的请求日志，和请求参数
 *
 * @author 孔垂云 on 2017/9/10.
 */
public class LogInterceptor implements HandlerInterceptor {
    /**
     * 定义日志
     */
    private static Logger logger = LoggerFactory.getLogger("operationLog");

    /**
     * 记录操作日志
     *
     * @param request  request
     * @param response response
     * @param handler  handler
     * @return 处理是否成功
     * @throws Exception 异常
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //校验权限
        String path = request.getServletPath();
        String contentType = request.getContentType();
        if (contentType != null && contentType.equals("application/json")) {
            // 只有json请求才记录日志，上传文件的不记录
            //参数
            String parameters = StringUtil.getBodyString(request.getReader());
            User user = TokenUtil.getToken(request);
            logOperation(path, parameters, user);
        }
        return true;
    }

    /**
     * 记录文本日志
     *
     * @param path       路径
     * @param parameters 参数值
     * @param user       user
     */
    public void logOperation(String path, String parameters, User user) {
        String log = "";
        if (user == null) {
            user = new User();
        }
        log = "[OPERALOG-操作日志]" + "-[" + user.getUsername() + "]" + "-[" + getSystemTime() + "]-" + "[INFO]-" + "-" + parameters;
        logger.info(log);
    }

    public static String getSystemTime() {
        String strTime = "";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        strTime = df.format(new Date());
        return strTime;
    }

    /**
     * @param request      request
     * @param response     response
     * @param handler      handler
     * @param modelAndView modelAndView
     * @throws Exception 异常
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * @param request  request
     * @param response response
     * @param handler  handler
     * @param ex       异常
     * @throws Exception 异常
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


}
