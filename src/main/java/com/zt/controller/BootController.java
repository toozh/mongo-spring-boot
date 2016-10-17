package com.zt.controller;

import com.zt.model.Boot;
import com.zt.service.BootService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fenxio on 2016/10/17.
 */
@Api(value = "Boot", description = "mongo db 测试")
@Controller
@RequestMapping("/boot")
public class BootController {

    @Autowired
    private BootService bootService;

    @ApiOperation(value = "boot列表", notes = "boot列表", response = Boot.class, position = 2, httpMethod = "GET")
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Boot> getList() {
        List<Boot> bootList = bootService.findAll();
        return bootList;
    }

    @ApiOperation(value = "创建boot", notes = "创建boot", response = String.class, position = 2, httpMethod = "POST")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Boot addBoot(@RequestBody Boot boot) {
        bootService.save(boot);
        return boot;
    }

    @ApiOperation(value = "根据Id获取boot", notes = "创建boot", response = String.class, position = 2, httpMethod = "GET")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Boot getBoot(@PathVariable("id") Integer id) {
        return bootService.findById(id);
    }

    @ApiOperation(value = "修改boot", notes = "创建boot", response = String.class, position = 2, httpMethod = "PUT")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Boot updateBoot(@PathVariable("id") Integer id, @RequestBody Boot boot) {
        bootService.updateBoot(id, boot);
        return boot;
    }

    @ApiOperation(value = "删除boot", notes = "创建boot", response = String.class, position = 2, httpMethod = "DELETE")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Boot deleteBoot(@PathVariable("id") Integer id) {
        return bootService.deleteById(id);
    }

}
