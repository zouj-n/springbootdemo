package com.june.springbootdemo.controller;

import com.june.springbootdemo.request.CommonRequest;
import com.june.springbootdemo.response.CommonResponse;
import com.june.springbootdemo.service.ExternalFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import java.util.List;
import java.util.Map;

@Slf4j
public abstract class AbstractBaseController {
    public static final ThreadLocal<Map<String,Object>> CURRENT_SESSION = new ThreadLocal<>();

    @Autowired
    public ExternalFacade externalFacade;

    protected CommonResponse operationRequest(HttpHeaders httpHeaders, CommonRequest commonRequest) {

        doParseRequestJson(commonRequest);
        this.handleHeaderInfos(httpHeaders);
        getRequestContext(commonRequest);

        CommonResponse response = null;
        response = externalFacade.excute(commonRequest);
        return response;
    }

    private void handleHeaderInfos(HttpHeaders httpHeaders) {
        // todo
        if (log.isDebugEnabled()) {
            List<MediaType> headMediaTypes = httpHeaders.getAccept();
            log.debug("headMediaTypes:");
            for (MediaType a: headMediaTypes) {
                log.debug(a.toString());
            }
            log.debug("Accept charset："+ httpHeaders.getAcceptCharset());
            log.debug("ContentType:" + httpHeaders.getContentType());
        }
    }

    private void doParseRequestJson(CommonRequest commonRequest) {
        if(commonRequest == null) {
            //公共数据的前置校验如果变得很复杂且很长，可以考虑建造者+责任链模式，简短几行就能写完则使用if else
            //error请求报文格式不正确，请求报文对象、报文体、报文头对象、用户、接口编码不能为空（必传字段校验）
        }
    }

    /**
     * 全局变量相关
     * @param commonRequest
     * @return
     */
    private void getRequestContext(CommonRequest commonRequest) {
        if(CURRENT_SESSION.get() != null) {
            CURRENT_SESSION.get().put("CommonHead", commonRequest.getCommonHead());
        }
    }
}
