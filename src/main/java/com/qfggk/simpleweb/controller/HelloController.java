package com.qfggk.simpleweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@Slf4j
public class HelloController {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("id") String id)
    {
        String sql="select * from bms_books where book_id="+id;

        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        log.info("查询记录:{}", maps.get(0).toString());
        return maps.get(0).toString();
    }
}
