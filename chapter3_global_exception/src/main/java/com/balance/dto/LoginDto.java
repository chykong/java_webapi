package com.balance.dto;

/**
 * Created by 孔垂云 on 2017/12/23.
 */
public class LoginDto {
    private String username;//账号
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
