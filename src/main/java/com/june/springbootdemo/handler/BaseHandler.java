package com.june.springbootdemo.handler;

import com.june.springbootdemo.request.CommonRequest;
import com.june.springbootdemo.response.CommonResponse;

public interface BaseHandler<T extends CommonRequest, V extends CommonResponse> {

    default String getType(){
        return "type";
    }
}
