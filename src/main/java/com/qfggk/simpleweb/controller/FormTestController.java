package com.qfggk.simpleweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@Slf4j
public class FormTestController {
    @GetMapping("/form_layouts")
    public String form_layouts()
    {
        return "form/form_layouts";
    }

    @RequestMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("passwd") String passwd,
                         @RequestPart("headerp") MultipartFile hp,
                         @RequestPart("photos") MultipartFile[] ps) throws IOException {

        log.info("email:{},passwd:{},hp={},ps={}",email,passwd,hp.getSize(),ps.length);
        if(!hp.isEmpty())
        {

            String originalFilename = hp.getOriginalFilename();
            log.info("头像名为："+originalFilename);
            hp.transferTo(new File("D:\\"+originalFilename));

        }
        return "main";
    }
}
