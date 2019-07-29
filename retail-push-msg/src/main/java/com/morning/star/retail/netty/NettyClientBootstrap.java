package com.morning.star.retail.netty;

import com.morning.star.retail.netty.hander.NettyClientInboundHandler;
import com.retail.push.msg.api.info.ConnectRequestMsg;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Dell on 2018/7/17.
 */
public class NettyClientBootstrap {
	private static final Logger logger = LoggerFactory.getLogger(NettyClientBootstrap.class);
	private int port;
	private String host;
	private SocketChannel socketChannel;
	private String clientId;
	private static final EventExecutorGroup group = new DefaultEventExecutorGroup(20);

	public NettyClientBootstrap(int port, String host, String clientId) throws InterruptedException {
		this.port = port;
		this.host = host;
		this.clientId = clientId;
		start();
	}

	private void start() throws InterruptedException {
		EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
		Bootstrap bootstrap = new Bootstrap();
		bootstrap.channel(NioSocketChannel.class);
		bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
		bootstrap.group(eventLoopGroup);
		bootstrap.remoteAddress(host, port);
		bootstrap.handler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel socketChannel) throws Exception {
				socketChannel.pipeline().addLast(new IdleStateHandler(20, 10, 0));
				socketChannel.pipeline().addLast(new ObjectEncoder());
				socketChannel.pipeline().addLast(new ObjectDecoder(ClassResolvers.cacheDisabled(null)));

//				socketChannel.pipeline().addLast("http-codec",new HttpServerCodec());
//				socketChannel.pipeline().addLast("aggregator",new HttpObjectAggregator(65536));
//				socketChannel.pipeline().addLast("http-chunked",new ChunkedWriteHandler());
//				socketChannel.pipeline().addLast(new IdleStateHandler(60,30,60*30, TimeUnit.SECONDS));
				socketChannel.pipeline().addLast(new NettyClientInboundHandler(clientId));
			}
		});
		ChannelFuture future = bootstrap.connect(host, port).sync();
		if (future.isSuccess()) {
			socketChannel = (SocketChannel) future.channel();
			logger.info("connect server  成功---------" + clientId);
		}
	}

	public void login(ConnectRequestMsg connectRequestMsg) {
		this.socketChannel.writeAndFlush(connectRequestMsg);
	}

	public static void main(String[] args) throws InterruptedException {

		ConnectRequestMsg connectRequestMsg = new ConnectRequestMsg();
		connectRequestMsg.setClientId("123456789");
		connectRequestMsg.setPassword("123456");
		connectRequestMsg.setUserName("zyh111");
		connectRequestMsg.setToken("GG7q6bPk");
		connectRequestMsg.setClientId("123456789");

		NettyClientBootstrap bootstrap = new NettyClientBootstrap(9100, "119.29.66.230", connectRequestMsg.getClientId());
//		NettyClientBootstrap bootstrap = new NettyClientBootstrap(9999, "127.0.0.1", connectRequestMsg.getClientId());
		bootstrap.socketChannel.writeAndFlush(connectRequestMsg);
	}
}