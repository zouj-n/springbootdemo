package com.june.springbootdemo.request;

import lombok.Data;

@Data
public class CommonRequest<R> {
    CommonHead commonHead;
    R request;
}
