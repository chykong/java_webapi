package com.balance.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Created by 孔垂云 on 2017/12/23.
 */
public class LoginDto {
    @NotNull
    private String username;//账号
    @NotNull
    @Length(min = 6, message = "密码格式错误")
    private String password;//密码

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
