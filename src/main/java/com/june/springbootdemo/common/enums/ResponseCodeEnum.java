package com.june.springbootdemo.common.enums;

import org.springframework.http.HttpStatus;

import java.util.Arrays;

public enum ResponseCodeEnum implements BaseResultInterface {
    ALL_OK("13200", "OK",HttpStatus.OK.value()),
    GENERAL_INTERNAL_ERROR("13500", "INTERNAL_ERROR", HttpStatus.INTERNAL_SERVER_ERROR.value()),
    INVALID_PARAMETER("13400", "INVALID_REQUEST", HttpStatus.BAD_REQUEST.value()),
    AUTHENTICATION_FAILED("13401", "NEED_AUTHENTICATION", HttpStatus.UNAUTHORIZED.value()),
    FORBIDDEN("13403", "FORBIDDEN", HttpStatus.FORBIDDEN.value());

    public String serviceCode;
    public String serviceMsg;
    public int httpStatusCode;

    ResponseCodeEnum(String serviceCode, String serviceMsg, int httpStatusCode) {
        this.serviceCode = serviceCode;
        this.serviceMsg = serviceMsg;
        this.httpStatusCode = httpStatusCode;
    }

    @Override
    public String getServiceCode() {
        return serviceCode;
    }

    @Override
    public String getServiceMsg() {
        return serviceMsg;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public static ResponseCodeEnum getResponseCodeByServiceCode( String code) {
        return Arrays.stream(ResponseCodeEnum.values())
                .filter(responseCode -> responseCode.getServiceCode() == code)
                .findFirst()
                .orElse(null);
    }
}
