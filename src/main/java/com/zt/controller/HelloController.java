package com.zt.controller;

import com.zt.dao.BootDao;
import com.zt.model.Boot;
import com.zt.model.User;
import com.zt.service.BootService;
import com.zt.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fenxio on 2016/10/17.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private BootService bootService;
    @Autowired
    private RedisUtil redisUtil;

//    @Autowired
//    private BootDao bootDao;
//
//    @Autowired
//    private MongoTemplate mongoTemplate;

    @RequestMapping
    public String index(Model model) {
        Boot boot = bootService.findById(1);
        redisUtil.set(boot.getId() +"", boot);
        model.addAttribute("result", "222");
        return "index";
    }

    @RequestMapping("/test/{id}")
    public String test(@PathVariable("id") Integer id, Model model) {
        Boot boot = new Boot();
        Object object = redisUtil.get(id +"");
        if(object != null) {
            boot = (Boot) object;
        }
        model.addAttribute("boot", boot);
        return "test";
    }

}
