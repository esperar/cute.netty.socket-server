package com.example.nettyexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class NettyExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(NettyExampleApplication.class, args);
    }

}
