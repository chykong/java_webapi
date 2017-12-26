package com.balance.controller;

import com.balance.dto.LoginDto;
import com.balance.model.User;
import com.balance.service.UserService;
import com.balance.util.json.GlobalReturnCode;
import com.balance.util.json.JsonResult;
import com.balance.util.redis.RedisKey;
import com.balance.util.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 孔垂云 on 2017/12/23.
 */
@RestController
@RequestMapping("/")
public class LoginControler {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 用户登录
     */
    @PostMapping("/checkLogin")
    public JsonResult checkLogin(HttpServletRequest request,@Valid @RequestBody LoginDto loginDto) {
        User user = userService.getByUsername(loginDto.getUsername());
        if (user != null && user.getPassword().equals(loginDto.getPassword())) {
            //登录成功
            String accessToken = UUID.randomUUID().toString();
            //放入redis
            redisUtil.set(RedisKey.ACCESS_TOKEN + accessToken, user, 30 * 60);
            Map<String, String> map = new HashMap<>();
            map.put("accessToken", accessToken);
            JsonResult jsonResult = new JsonResult(true, GlobalReturnCode.OPERA_SUCCESS, accessToken);
            return jsonResult;
        } else {
            JsonResult jsonResult = new JsonResult(false, "20102");
            return jsonResult;
        }
    }
}
