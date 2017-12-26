package com.balance.util.token;

import com.balance.model.User;
import com.balance.util.redis.RedisKey;
import com.balance.util.redis.RedisUtil;
import com.balance.util.spring.SpringContextUtil;
import com.balance.util.string.StringUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 孔垂云 on 2017/12/26.
 */
public class TokenUtil {
    /**
     * 功能描述:获取管理端token对应的对象
     *
     * @param request request
     * @return User,user可以换成自己要的各种对象
     */
    public static User getToken(HttpServletRequest request) {
        //从header获取Authorization
        String authorization = request.getHeader("Authorization");
        if (StringUtil.isNotNullOrEmpty(authorization)) {
            RedisUtil redisUtil = (RedisUtil) SpringContextUtil.getBean("redisUtil");
            return redisUtil.get(RedisKey.ACCESS_TOKEN + authorization, User.class);
        } else {
            return null;
        }
    }
}
