package com.qfggk.simpleweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TableController {
    @GetMapping("/basic_table")
    public String basic_table(@RequestParam("a") int a)
    {
        return "table/basic_table";
    }
    @GetMapping("/responsive_table")
    public String responsive_table()
    {
        return "table/responsive_table";
    }
    @GetMapping("/dynamic_table")
    public String dynamic_table()
    {
        return "table/dynamic_table";
    }
}
