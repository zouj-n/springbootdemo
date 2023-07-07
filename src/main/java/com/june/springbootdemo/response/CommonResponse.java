package com.june.springbootdemo.response;

import com.june.springbootdemo.common.enums.ResponseCodeEnum;
import com.june.springbootdemo.common.enums.BaseResultInterface;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Data
public class CommonResponse<T> {
    private String code;
    private String message;

    private T data;

    public CommonResponse() {
    }

    public CommonResponse(BaseResultInterface errorInfo) {
        this.code = errorInfo.getServiceCode();
        this.message = errorInfo.getServiceMsg();
    }

    /**
     * success response
     * @param data
     * @return
     */
    public static <T> CommonResponse<T> success(T data) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(ResponseCodeEnum.ALL_OK.getServiceCode());
        commonResponse.setMessage(ResponseCodeEnum.ALL_OK.getServiceMsg());
        commonResponse.setData(data);
        return commonResponse;
    }

    /**
     * BaseResultInterface error message result
     * @param errorInfo
     * @return
     */
    public static CommonResponse error(BaseResultInterface errorInfo) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(errorInfo.getServiceCode());
        commonResponse.setMessage(errorInfo.getServiceMsg());
        commonResponse.setData(null);
        return commonResponse;
    }

    /**
     * user-defined error message and code
     * @param code
     * @param message
     * @return
     */
    public static CommonResponse error(String code, String message) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(code);
        commonResponse.setMessage(message);
        commonResponse.setData(null);
        return commonResponse;
    }

    /**
     * user-defined error message
     * @param message
     * @return
     */
    public static CommonResponse error(String message) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(ResponseCodeEnum.GENERAL_INTERNAL_ERROR.getServiceCode());
        commonResponse.setMessage(message);
        commonResponse.setData(null);
        return commonResponse;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
