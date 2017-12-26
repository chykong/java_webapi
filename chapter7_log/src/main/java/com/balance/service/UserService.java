package com.balance.service;

import com.balance.dao.UserDao;
import com.balance.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 孔垂云 on 2017/12/23.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User getByUsername(String username) {
        return userDao.getByUsername(username);
    }
}
