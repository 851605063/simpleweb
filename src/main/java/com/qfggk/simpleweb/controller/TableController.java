package com.qfggk.simpleweb.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qfggk.simpleweb.bean.User;
import com.qfggk.simpleweb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
public class TableController {
    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table()
    {

        return "table/basic_table";
    }
    @GetMapping("/responsive_table")
    public String responsive_table()
    {
        return "table/responsive_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteuser(@PathVariable("id") Integer id,
                             @RequestParam("pn") Integer pn,
                             RedirectAttributes ra)
    {
        ra.addAttribute("pn",pn);
        userService.removeById(id);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1")  Integer pn ,
                                Model model)
    {
        //List<User> list = userService.list();
        //分页查询数据
        Page<User> userPage = new Page<User>(pn, 2);
        //分页查询的结果对象
        Page<User> page = userService.page(userPage, null);
        long current = page.getCurrent();
        long pages = page.getPages();
        long total = page.getTotal();
        log.info("当前：{}，总页数：{}，总记录数:{}",current,pages,total);
        //返回model
        model.addAttribute("page",page);
        return "table/dynamic_table";
    }
}
