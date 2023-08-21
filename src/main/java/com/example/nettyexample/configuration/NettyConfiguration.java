package com.example.nettyexample.configuration;

import com.example.nettyexample.socket.NettyChannelInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;

@Configuration
@RequiredArgsConstructor
public class NettyConfiguration {

    @Value("${server.host}")
    private String host;
    @Value("${server.port}")
    private int port;
    @Value("${server.netty.boss-count}")
    private int bossCount;
    @Value("${server.netty.worker-count}")
    private int workerCount;
    @Value("${server.netty.keep-alive}")
    private boolean keepAlive;
    @Value("${server.netty.backlog}")
    private int backlog;

    @Bean ServerBootstrap serverBootstrap(NettyChannelInitializer nettyChannelInitializer) {
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup(), workerGroup())
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.DEBUG))
                .childHandler(nettyChannelInitializer);
        b.option(ChannelOption.SO_BACKLOG, backlog);

        return b;
    }

    @Bean(destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup bossGroup() {
        return new NioEventLoopGroup(bossCount);
    }

    // worker: boss가 수락한 연결의 트래픽 관리
    @Bean(destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup workerGroup() {
        return new NioEventLoopGroup(workerCount);
    }

    // IP 소켓 주소(IP 주소, Port 번호)를 구현
    // 도메인 이름으로 객체 생성 가능
    @Bean
    public InetSocketAddress inetSocketAddress() {
        return new InetSocketAddress(host, port);
    }

}
