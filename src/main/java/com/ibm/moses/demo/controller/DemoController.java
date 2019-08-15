package com.ibm.moses.demo.controller;

import com.ibm.moses.common.controller.BaseResponse;
import com.ibm.moses.demo.entity.Demo;
import com.ibm.moses.demo.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * demo
 * @author Moses
 */
@RestController
@Api("demo api")
@RequestMapping(value = "/demo")
public class DemoController {
    protected static final Logger logger = LoggerFactory.getLogger(DemoController.class);
    @Autowired
    private DemoService demoService;

    /**
     * post find by condition
     *
     * @param demo object
     * @return list
     */
    @PostMapping("/find")
    @ApiOperation(value = "find demo", notes = "find by condition or all demo")
    public BaseResponse<List<Demo>> findAll(@RequestBody Demo demo) {
        return BaseResponse.success(demoService.findAll());
    }
}
