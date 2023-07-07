package com.june.springbootdemo.advice;

import com.june.springbootdemo.common.enums.ResponseCodeEnum;
import com.june.springbootdemo.common.exception.BusinessException;
import com.june.springbootdemo.response.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionAdvice {
    private static Logger LOG = LoggerFactory.getLogger(GlobalExceptionAdvice.class);

    /**
     * business exception
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public CommonResponse bizExceptionHandler(HttpServletRequest req, BusinessException e){
        //数据校验异常,业务处理异常等
        LOG.error("BUSINESS EXCEPTION:", e);
        return CommonResponse.error(e.getErrorCode(),e.getErrorMsg());
    }

    /**
     * other exception
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResponse exceptionHandler(HttpServletRequest req, Exception e){

        LOG.error("UNKNOWN EXCEPTION:", e);
        return CommonResponse.error(ResponseCodeEnum.GENERAL_INTERNAL_ERROR);
    }
}
