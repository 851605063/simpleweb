package com.qfggk.simpleweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @GetMapping(value = {"/","/login"})
    public String loginPage(HttpSession session,Model model)
    {
        String username=(String)session.getAttribute("username");
        if(username!=null)
            return "redirect:/main.html";
        return "login";
    }

    @PostMapping (value={"/login"})
    public String main(HttpSession session, String name, String passwd, Model model)
    {

        if(name.equals("wjq")&&passwd.equals("123")) {
            model.addAttribute("msg","登录成功！");
            session.setAttribute("username",name);
            return "redirect:/main.html";
        }
        else
        {
            model.addAttribute("msg","账号密码错误");
            return "login";
        }

    }
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model)
    {
        String username=(String)session.getAttribute("username");
        if(username!=null)
            return "main";
        else
            //model.addAttribute("msg","未登录");
            return "redirect:/login";
    }
}
