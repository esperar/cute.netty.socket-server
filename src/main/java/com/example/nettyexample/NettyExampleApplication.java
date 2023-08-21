package com.example.nettyexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class NettyExampleApplication implements ApplicationListener<ApplicationReadyEvent> {

    // private final NettyServerSocket nettyServerSocket;

    public static void main(String[] args) {
        SpringApplication.run(NettyExampleApplication.class, args);
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // nettyServerSocket.start()
    }
}
