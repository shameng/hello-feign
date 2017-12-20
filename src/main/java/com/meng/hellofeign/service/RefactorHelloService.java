package com.meng.hellofeign.service;

import com.meng.api.service.HelloService;
import com.meng.hellofeign.config.FullLogConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;

//设置配置类
@FeignClient(value = "hello-service", configuration = FullLogConfiguration.class)
public interface RefactorHelloService extends HelloService {
}
