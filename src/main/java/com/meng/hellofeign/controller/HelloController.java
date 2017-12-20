package com.meng.hellofeign.controller;

import com.meng.hellofeign.entity.User;
import com.meng.hellofeign.service.HelloService;
import com.meng.hellofeign.service.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xindemeng
 * @datetime 2017/12/19 23:29
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private RefactorHelloService refactorHelloService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder("");
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello1("xindemeng")).append("\n");
        sb.append(helloService.hello2("xindemeng", 1)).append("\n");
        sb.append(helloService.hello3(new User(1, "xindemeng"))).append("\n");
        return sb.toString();
    }

    @RequestMapping(value = "/feign-consumer3", method = RequestMethod.GET)
    public String helloConsumer3() {
        StringBuilder sb = new StringBuilder("");
        sb.append(refactorHelloService.hello4("xindemeng")).append("\n");
        sb.append(refactorHelloService.hello5("xindemeng", 1)).append("\n");
        sb.append(refactorHelloService.hello6(new com.meng.dto.User(1, "xindemeng"))).append("\n");
        return sb.toString();
    }

}
