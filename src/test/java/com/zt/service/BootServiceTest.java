package com.zt.service;

import com.zt.Application;
import com.zt.model.Boot;
import io.swagger.annotations.ApiModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by fenxio on 2016/10/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BootServiceTest {

    @Autowired
    private BootService bootService;

    @Test
    public void testFindById() {
        Boot boot = bootService.findById(1);
        System.out.println(boot.getName());
    }



}
