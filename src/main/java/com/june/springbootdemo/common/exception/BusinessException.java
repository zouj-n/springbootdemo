package com.june.springbootdemo.common.exception;

import com.june.springbootdemo.common.enums.BaseResultInterface;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    protected String errorCode;

    protected String errorMsg;

    public BusinessException() {
        super();
    }

    public BusinessException(BaseResultInterface errorInfoInterface) {
        super(errorInfoInterface.getServiceCode());
        this.errorCode = errorInfoInterface.getServiceCode();
        this.errorMsg = errorInfoInterface.getServiceMsg();
    }

    public BusinessException(BaseResultInterface errorInfoInterface, Throwable cause) {
        super(errorInfoInterface.getServiceCode(), cause);
        this.errorCode = errorInfoInterface.getServiceCode();
        this.errorMsg = errorInfoInterface.getServiceMsg();
    }

    public BusinessException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public BusinessException(String errorCode, String errorMsg) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BusinessException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}

