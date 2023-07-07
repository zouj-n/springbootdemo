package com.june.springbootdemo.service;

import com.june.springbootdemo.request.CommonRequest;
import com.june.springbootdemo.response.CommonResponse;


public interface ExternalFacade {

    /**
     * 根据serviceCode  执行具体业务逻辑
     *
     * @param request
     * @return
     */
    public CommonResponse excute(CommonRequest request);
}
