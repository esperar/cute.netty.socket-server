package com.example.nettyexample.socket;

import com.example.nettyexample.decoder.TestDecoder;
import com.example.nettyexample.handler.TestHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NettyChannelInitializer extends ChannelInitializer<SocketChannel> {

    private final TestHandler testHandler;

    @Override
    protected void initChannel(SocketChannel ch) {
        ChannelPipeline pipeline = ch.pipeline();

        TestDecoder testDecoder = new TestDecoder();

        pipeline.addLast(testDecoder);
        pipeline.addLast(testHandler);
    }
}
