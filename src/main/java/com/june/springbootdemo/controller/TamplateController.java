package com.june.springbootdemo.controller;

import com.june.springbootdemo.request.TestRequest;
import com.june.springbootdemo.request.CommonRequest;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "测试示例")
@RestController
@RequestMapping("/example")
public class TamplateController extends AbstractBaseController {
    @ApiOperation(value = "测试示例", notes = "111")
    @GetMapping("/test1")
    public String test1(@RequestParam String name){
        this.operationRequest(null, null);
        return "user";
    }

    @ApiOperation(value = "测试示例", notes = "222", consumes = "application/json")
    @PostMapping(value = "/test2", consumes = "application/json")
    public String test2(@RequestHeader HttpHeaders httpHeaders, @RequestBody CommonRequest<TestRequest> commonRequest){
        this.operationRequest(null, null);

        return "user";
    }

}
