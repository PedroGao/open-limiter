package com.pedro.ratelimit.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BasicApplication {

    @GetMapping("/")
    public String hello() {
        return "hello, plimit";
    }

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }

}
