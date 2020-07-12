package com.pedro.ratelimit.basic;

import com.pedro.ratelimiter.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BasicApplication {

    @Autowired
    public RateLimiter rateLimiter;

    @GetMapping("/")
    public String hello() {
        boolean ok = rateLimiter.limit("GET /");
        if (ok) {
            return "ok";
        }
        return "door";
    }

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }

}
