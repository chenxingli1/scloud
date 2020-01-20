package com.scloud.ribbon.server;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloServer {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand
    public String helloService() {
        return restTemplate.getForEntity("http://HELLO-SERVER/hello", String.class).getBody();
    }

    public String failCallBack() {
        return "hei, error";
    }
}
