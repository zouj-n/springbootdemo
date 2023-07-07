package com.june.springbootdemo.service;

import com.june.springbootdemo.request.CommonRequest;
import com.june.springbootdemo.response.CommonResponse;

public interface ExternalServiceHandler {
    public String getServiceCode();

    public CommonResponse handle(CommonRequest request);
}
