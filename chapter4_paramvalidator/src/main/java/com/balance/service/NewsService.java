package com.balance.service;

import com.balance.dao.NewsDao;
import com.balance.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 孔垂云 on 2017/12/23.
 */
@Service
public class NewsService {
    @Autowired
    private NewsDao newsDao;

    public int add(News news) {
        return newsDao.add(news);
    }

    public int update(News news) {
        return newsDao.update(news);
    }

    public int delete(int id) {
        return newsDao.delete(id);
    }

    public News get(int id) {
        return newsDao.get(id);
    }

    public List<News> list() {
        return newsDao.list();
    }
}
