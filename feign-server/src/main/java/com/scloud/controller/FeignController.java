package com.scloud.controller;

import com.scloud.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "feign-consumer", method = RequestMethod.GET)
    public String helloFeign() {
        return helloService.hello();
    }

    @RequestMapping(value = "feign-consumer1", method = RequestMethod.GET)
    public String helloFeign(@RequestParam("name") String name) {
        return helloService.hello(name);
    }
}
