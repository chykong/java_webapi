package com.balance.dao;

import com.balance.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 孔垂云 on 2017/12/23.
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getByUsername(String username) {
        List<User> list = jdbcTemplate.query("select * from t_user where username = ?", new Object[]{username}, new BeanPropertyRowMapper(User.class));
        return list.size() > 0 ? list.get(0) : null;
    }
}
