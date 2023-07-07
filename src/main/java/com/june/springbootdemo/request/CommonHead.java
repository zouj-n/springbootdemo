package com.june.springbootdemo.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "请求头")
public class CommonHead {
    @ApiModelProperty(value = "请求Id")
    private String requestId;

    @ApiModelProperty(value = "请求用户")
    private String requestUser;

    @ApiModelProperty(value = "服务编码")
    private String serviceCode;

}
