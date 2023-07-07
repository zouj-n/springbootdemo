package com.june.springbootdemo.handler.spi;


import com.june.springbootdemo.request.CommonRequest;
import com.june.springbootdemo.response.CommonResponse;
import com.june.springbootdemo.service.ExternalServiceHandler;

public abstract class AbstractExternalSpiHandler<V, T> implements ExternalServiceHandler {

    @Override
    public CommonResponse handle(CommonRequest request) {
        //查找数据库中用户配置，加密公钥私钥签名开关
        //检查访问权限
        CommonResponse response = null;

        //拆出具体数据对象
        request = parseRequestParam(request);
        //具体业务处理    todo 预留业务配置的一个对象，比如业务中一些开关渠道的配置，可能会根据用户信息查询拆分出来塞到公共的对象
        response = bizHandle(request, "");
        return response;
    }

    public abstract CommonResponse<T> bizHandle(CommonRequest<V> request, String s);

    protected abstract CommonRequest<T> parseRequestParam(CommonRequest<V> request);

    //TODO 加解密方法
}

