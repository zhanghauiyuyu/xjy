package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PageControllers {

    @RequestMapping("/logins")
    public String toindexs(){
        System.out.println(222222);
        return "login";
    }
    @RequestMapping("/toIndex")
    public String toIndex(){
        System.out.println(3333);
        return "index";
    }

}
