package com.hello;

import com.hello.dto.User;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.apache.log4j.Logger;

@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("hello, host"+ instance.getHost()+" "+ instance.getPort() +" "+ instance.getServiceId());
        return "hello world";
    }

    @RequestMapping(value = "hello1", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return "hello " + name;
    }

    @RequestMapping(value = "hello2", method = RequestMethod.GET)
    public User hello(@RequestParam String name, @RequestParam int age) {
        return new User(name, age);
    }

    @RequestMapping(value = "hello3", method = RequestMethod.GET)
    public String hello(@RequestParam User user) {
        return user.toString();
    }

}
