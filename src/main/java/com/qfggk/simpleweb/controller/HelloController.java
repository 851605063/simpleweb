package com.qfggk.simpleweb.controller;

import com.qfggk.simpleweb.bean.books;
import com.qfggk.simpleweb.service.imp.BooksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@Slf4j
public class HelloController {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    BooksService booksService;

    @GetMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("id") int id)
    {
        String sql="select * from bms_books where book_id="+id;

        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        log.info("查询记录:{}", maps.get(0).toString());
        return maps.get(0).toString();
    }

    @GetMapping("/getbooks")
    @ResponseBody
    public String getBooks(@RequestParam("id") Integer id)
    {
        books book = booksService.getBooksById(id);
        return book.toString();
    }
}
