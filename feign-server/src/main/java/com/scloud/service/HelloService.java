package com.scloud.service;

import com.scloud.dto.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("hello-server")
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping("/hello1")
    String hello(@RequestParam("name") String name);

    @RequestMapping("/hello2")
    User hello(@RequestParam("name") String name, @RequestParam("age") int age);

    @RequestMapping("/hello3")
    String hello(@RequestParam("user") User user);
}
