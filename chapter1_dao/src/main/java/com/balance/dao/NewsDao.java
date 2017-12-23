package com.balance.dao;

import com.balance.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 孔垂云 on 2017/12/23.
 */
@Repository
public class NewsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int add(News news) {
        String sql = "insert into t_news(title,content) values(:title,:content)";
        return new NamedParameterJdbcTemplate(jdbcTemplate).update(sql, new BeanPropertySqlParameterSource(news));
    }

    public int update(News news) {
        String sql = "update  t_news SET title=:title,content=:content   WHERE id=?";
        return new NamedParameterJdbcTemplate(jdbcTemplate).update(sql, new BeanPropertySqlParameterSource(news));
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE from t_news where id=?", id);
    }

    public News get(int id) {
        List<News> list = jdbcTemplate.query("select * from t_news where id = ?", new Object[]{id}, new BeanPropertyRowMapper(News.class));
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<News> list() {
        List<News> list = jdbcTemplate.query("select * from t_news", new BeanPropertyRowMapper(News.class));
        return list;
    }
}
