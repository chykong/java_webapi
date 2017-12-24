package com.balance.config.aop;

import com.balance.util.json.GlobalReturnCode;
import com.balance.util.json.JsonResult;
import com.balance.util.string.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 该类主要解决以下问题
 * 1、处理api接口的跨域
 * 2、处理conttroller层的异常，返回状态为500
 * 3、处理请求的参数异常，返回状态为400
 *
 * @author 孔垂云 on 2017/8/20.
 */
@ControllerAdvice
public class ApiControllerAdvice {
    /**
     * 定义日志处理
     */
    private static Logger logger = LoggerFactory.getLogger("controllerLog");


    /**
     * 系统异常处理，比如：404,500
     *
     * @param request  request
     * @param response response
     * @param e        异常
     * @return JsonResult结构
     * @throws Exception 异常
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        logger.error("系统异常", e);
        logException(request);
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return new JsonResult(false, GlobalReturnCode.SYSTEM_PATH_NOEXIST);
        } else {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new JsonResult(false, GlobalReturnCode.SYSTEM_ERROR);
        }
    }


    /**
     * 打印所有异常信息
     *
     * @param request request
     */
    private void logException(HttpServletRequest request) {
        try {
            logger.error("请求路径：" + request.getServletPath());
            logger.error("请求参数：" + request.getParameterMap().toString());
            logger.error("请求header:" + StringUtil.getHeaderValue(request.getHeaderNames(), request));
            logger.error("请求body:" + StringUtil.getBodyString(request.getReader()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}