package com.june.springbootdemo.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class TestRequest {
    private String brand;
    private String channel;
    private String productLine;
}
