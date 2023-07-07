package com.june.springbootdemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "测试DTO")
public class TestDto {
    @ApiModelProperty(value = "测试类型")
    private String testType;

    @ApiModelProperty(value = "测试类型")
    private String testModle;
}
