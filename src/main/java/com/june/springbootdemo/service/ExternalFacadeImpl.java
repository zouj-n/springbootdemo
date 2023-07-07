package com.june.springbootdemo.service;

import com.june.springbootdemo.request.CommonHead;
import com.june.springbootdemo.request.CommonRequest;
import com.june.springbootdemo.response.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.collections.CaseInsensitiveKeyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ExternalFacadeImpl implements ExternalFacade {
    private static Map<String, ExternalServiceHandler> handlerMap = new CaseInsensitiveKeyMap<>();

    @Autowired(required = false)
    public void initHandleMap(List<ExternalServiceHandler> services) {
        if (CollectionUtils.isEmpty(services)) {
            for (ExternalServiceHandler service : services) {
                if (handlerMap.get(service.getServiceCode()) != null) {
                    handlerMap.put(service.getServiceCode().getClass().getSimpleName(), service);
                }
                handlerMap.put(service.getServiceCode(), service);
            }
        }
    }

    /**
     * @param request
     * @return
     */
    @Override
    public CommonResponse excute(CommonRequest request) {
        CommonHead commonHead = request.getCommonHead();
        //获取接口服务编码 serviceCode
        String serviceCode = commonHead.getServiceCode();
        log.info("接收XXX业务servicecode：" + commonHead.getServiceCode());
        //接口用户
        String requestUser = commonHead.getRequestUser();
        //接口用户
        String requestId = commonHead.getRequestId();
        //TODO 校验用户权
        ExternalServiceHandler externalServiceHandler = handlerMap.get(serviceCode);
        CommonResponse response = null;
        if (externalServiceHandler != null) {
            response = externalServiceHandler.handle(request);
        } else {
            response = CommonResponse.error("业务处理异常，未找到对应业务模块！");
        }
        return response;
    }
}