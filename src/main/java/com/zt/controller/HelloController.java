package com.zt.controller;

import com.zt.dao.BootDao;
import com.zt.model.Boot;
import com.zt.model.User;
import com.zt.service.BootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fenxio on 2016/10/17.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private BootService bootService;

//    @Autowired
//    private BootDao bootDao;
//
//    @Autowired
//    private MongoTemplate mongoTemplate;

    @RequestMapping
    public String index(Model model) {
        Boot boot = bootService.findById(1);
        model.addAttribute("user", boot);
        return "index";
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

}
