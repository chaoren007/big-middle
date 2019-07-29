package com.morning.star.retail.netty;

import com.morning.star.retail.netty.hander.NettyServerInboundHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Dell on 2018/7/17.
 */
@Component
public class NettyServerBootstrap {

	private static final Logger logger = LoggerFactory.getLogger(NettyServerBootstrap.class);

	@Value("${netty.post}")
	private int port;

	private void startServer() throws InterruptedException {
		// Boss线程：由这个线程池提供的线程是boss种类的，用于创建、连接、绑定socket， （有点像门卫）然后把这些socket传给worker线程池。
		// 在服务器端每个监听的socket都有一个boss线程来处理。在客户端，只有一个boss线程来处理所有的socket
		EventLoopGroup boss = new NioEventLoopGroup();
		// Worker线程：Worker线程执行所有的异步I/O，即处理操作
		EventLoopGroup worker = new NioEventLoopGroup();
		try {
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(boss, worker);
			bootstrap.channel(NioServerSocketChannel.class);
			bootstrap.option(ChannelOption.SO_BACKLOG, 128);
			//通过NoDelay禁用Nagle,使消息立即发出去，不用等待到一定的数据量才发出去
			bootstrap.option(ChannelOption.TCP_NODELAY, true);
			//保持长连接状态
			bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
			bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel socketChannel) {
					ChannelPipeline p = socketChannel.pipeline();
					p.addLast(new ObjectEncoder());
					p.addLast(new ObjectDecoder(ClassResolvers.cacheDisabled(null)));
					p.addLast(new NettyServerInboundHandler());

					/*
					// HttpServerCodec：将请求和应答消息解码为HTTP消息
					p.addLast("http-codec",new HttpServerCodec());
					// HttpObjectAggregator：将HTTP消息的多个部分合成一条完整的HTTP消息
					p.addLast("aggregator",new HttpObjectAggregator(65536));
					// ChunkedWriteHandler：向客户端发送HTML5文件
					p.addLast("http-chunked",new ChunkedWriteHandler());
					// 进行设置心跳检测
					p.addLast(new IdleStateHandler(60,30,60*30, TimeUnit.SECONDS));
					// 配置通道处理  来进行业务处理
					p.addLast(new NettyServerInboundHandler());
*/
				}
			});
			ChannelFuture f = bootstrap.bind(port).sync();
			if (f.isSuccess()) {
				logger.info("socket server start");
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@PostConstruct()
	public void init(){
		//需要开启一个新的线程来执行netty server 服务器
		new Thread(() -> {
			try {
				startServer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}