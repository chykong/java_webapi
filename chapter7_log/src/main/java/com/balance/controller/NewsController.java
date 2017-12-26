package com.balance.controller;

import com.balance.model.News;
import com.balance.service.NewsService;
import com.balance.util.json.GlobalReturnCode;
import com.balance.util.json.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by 孔垂云 on 2017/12/23.
 */
@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @PostMapping("/add")
    public JsonResult add(HttpServletRequest request, @RequestBody News news) {
        int flag = newsService.add(news);
        if (flag == 1) {
            return new JsonResult(true, GlobalReturnCode.SAVE_SUCCESS);
        } else {
            return new JsonResult(false, GlobalReturnCode.OPERA_FAILURE);
        }
    }

    @PostMapping("/update")
    public JsonResult update(HttpServletRequest request, @RequestBody News news) {
        int flag = newsService.update(news);
        if (flag == 1) {
            return new JsonResult(true, GlobalReturnCode.SAVE_SUCCESS);
        } else {
            return new JsonResult(false, GlobalReturnCode.OPERA_FAILURE);
        }
    }

    @PostMapping("/delete")
    public JsonResult delete(HttpServletRequest request, @RequestBody Map<String, String> map) {
        int flag = newsService.delete(Integer.parseInt(map.get("id")));
        if (flag == 1) {
            return new JsonResult(true, GlobalReturnCode.SAVE_SUCCESS);
        } else {
            return new JsonResult(false, GlobalReturnCode.OPERA_FAILURE);
        }
    }

    @PostMapping("/list")
    public JsonResult list(HttpServletRequest request) {
        List<News> list = newsService.list();
        return new JsonResult(true, GlobalReturnCode.OPERA_SUCCESS, list);
    }

    @PostMapping("/get")
    public JsonResult get(HttpServletRequest request, @RequestBody Map<String, String> map) {
        News news = newsService.get(Integer.parseInt(map.get("id")));
        return new JsonResult(true, GlobalReturnCode.OPERA_SUCCESS, news);
    }
}
