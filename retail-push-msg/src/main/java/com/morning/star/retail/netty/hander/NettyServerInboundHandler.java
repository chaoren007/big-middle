package com.morning.star.retail.netty.hander;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.morning.star.retail.dao.EquipmentRepository;
import com.morning.star.retail.entity.EquipmentEntity;
import com.morning.star.retail.enums.EquipmentStatus;
import com.morning.star.retail.enums.PushMsgStatus;
import com.morning.star.retail.netty.NettyChannelMap;
import com.morning.star.retail.kingdee.service.impl.PushMsgServiceImpl;
import com.morning.star.retail.util.Context;
import com.retail.push.msg.api.dto.PushMsgDTO;
import com.retail.push.msg.api.info.*;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.AttributeKey;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;


/**
 * Created by Dell on 2018/7/17.
 */
public class NettyServerInboundHandler extends SimpleChannelInboundHandler<Object> {

	private static final Logger logger = LoggerFactory.getLogger(NettyServerInboundHandler.class);

	private static final String URI = "websocket";

	private WebSocketServerHandshaker handshaker;

	@Override
	public void channelInactive(ChannelHandlerContext ctx) {
		//channel失效，从Map中移除
		NettyChannelMap.remove((SocketChannel) ctx.channel());
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) {
		logger.info("【handlerRemoved】====>" + ctx.channel().id());
		NettyChannelMap.remove((SocketChannel) ctx.channel());
	}

	@Override
	protected void messageReceived(ChannelHandlerContext channelHandlerContext, Object msg) {
		if (msg instanceof FullHttpRequest) {
			doHandlerHttpRequest(channelHandlerContext, ((FullHttpRequest) msg));
		} else if (msg instanceof WebSocketFrame) {
			logger.info("handshaker.uri------" + handshaker.uri());
			doHandlerWebSocketFrame(channelHandlerContext, (WebSocketFrame) msg);
		} else {
			BaseMsg baseMsg = (BaseMsg) msg;
			switch (baseMsg.getType()) {
				case CONNECT_REQ: {
					//客户端需要链接的时候先发一个LOGIN类型的消息创建clientId对应的NettyChannelMap
					ConnectRequestMsg connectRequestMsg = (ConnectRequestMsg) baseMsg;
					EquipmentEntity equipmentEntity = Context.getBean(EquipmentRepository.class).getByEquipmentId(connectRequestMsg.getClientId());
					if (equipmentEntity != null && equipmentEntity.getStatus() != EquipmentStatus.CLOSE) {
						NettyChannelMap.add(connectRequestMsg.getClientId(), (SocketChannel) channelHandlerContext.channel());
						logger.info(connectRequestMsg.getClientId() + ":创建socket通道成功");
						channelHandlerContext.channel().writeAndFlush(new ConnectSuccessMsg(connectRequestMsg.getClientId()));

						//连接成功后发送以前未推送的消息
						if (equipmentEntity.getUin() != null && equipmentEntity.getUin() > 0) {
							List<PushMsgDTO> msgList = Context.getBean(PushMsgServiceImpl.class).getUserMsg(equipmentEntity.getUin(), PushMsgStatus.INIT);
							msgList.forEach(pushMsh -> channelHandlerContext.channel().writeAndFlush(pushMsh.toPushMsg()));
						}
					} else {
						logger.info(connectRequestMsg.getClientId() + ":创建socket通道失败");
						ConnectFailMsg failMsg;
						if (equipmentEntity == null) {
							failMsg = new ConnectFailMsg(connectRequestMsg.getClientId(), "token不存在");
						} else {
							failMsg = new ConnectFailMsg(connectRequestMsg.getClientId(), "token已关闭");
						}
						channelHandlerContext.channel().writeAndFlush(failMsg);
					}
				}
				break;
				case HEARTBEAT_REQ: {
					logger.info(LocalDateTime.now() + ":接收客户端ping");
					HeartbeatRequestMsg requestMsg = (HeartbeatRequestMsg) baseMsg;
					Channel channel = NettyChannelMap.get(requestMsg.getClientId());
					if (channel != null) {
						HeartbeatResponseMsg responseMsg = new HeartbeatResponseMsg(requestMsg.getClientId());
						channel.writeAndFlush(responseMsg);
					}
				}
				break;
				case MSG_PUSH_ASK: {
					logger.info(LocalDateTime.now() + ":接收客户端推送确认---" + JSON.toJSONString(baseMsg));
					PushAskMsg pushAskMsg = (PushAskMsg) baseMsg;
					Context.getBean(PushMsgServiceImpl.class).successMsg(pushAskMsg.getData().getMsgCode(), pushAskMsg.getClientId());
				}
				break;
				default:
					break;
			}
			ReferenceCountUtil.release(baseMsg);

		}
	}

	/**
	 * websocket消息处理
	 */
	private void doHandlerWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame msg) {
		//判断msg 是哪一种类型  分别做出不同的反应
		if (msg instanceof CloseWebSocketFrame) {
			logger.info("【关闭】");
			handshaker.close(ctx.channel(), (CloseWebSocketFrame) msg);
			return;
		}
		if (msg instanceof PingWebSocketFrame) {
			logger.info("【ping】");
			PongWebSocketFrame pong = new PongWebSocketFrame(msg.content().retain());
			ctx.channel().writeAndFlush(pong);
			return;
		}
		if (msg instanceof PongWebSocketFrame) {
			logger.info("【pong】");
			PingWebSocketFrame ping = new PingWebSocketFrame(msg.content().retain());
			ctx.channel().writeAndFlush(ping);
			return;
		}
		if (!(msg instanceof TextWebSocketFrame)) {
			logger.info("【不支持二进制】");
			throw new UnsupportedOperationException("不支持二进制");
		}
		//可以对消息进行处理
		//群发
		JSONObject jsonObject = JSON.parseObject(((TextWebSocketFrame) msg).text());
		String clientId = jsonObject.getString("clientId");
		Channel channel = NettyChannelMap.get(clientId);
		channel.writeAndFlush(new TextWebSocketFrame(((TextWebSocketFrame) msg).text()));

	}


	/**
	 * wetsocket第一次连接握手
	 */
	private void doHandlerHttpRequest(ChannelHandlerContext ctx, HttpRequest msg) {
		// http 解码失败
		if (!msg.getDecoderResult().isSuccess() || (!"websocket".equals(msg.headers().get("Upgrade")))) {
			sendHttpResponse(ctx, (FullHttpRequest) msg, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
		}
		//可以获取msg的uri来判断
		String uri = msg.getUri();
		if (!uri.substring(1).equals(URI)) {
			ctx.close();
		}
		ctx.attr(AttributeKey.valueOf("type")).set(uri);
		//可以通过url获取其他参数
		WebSocketServerHandshakerFactory factory = new WebSocketServerHandshakerFactory(
			"ws://" + msg.headers().get("Host") + "/" + URI + "", null, false
		);
		handshaker = factory.newHandshaker(msg);
		if (handshaker == null) {
			WebSocketServerHandshakerFactory.sendUnsupportedWebSocketVersionResponse(ctx.channel());
		}
		//进行连接
		handshaker.handshake(ctx.channel(), (FullHttpRequest) msg);
		//可以做其他处理
	}

	private static void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req, DefaultFullHttpResponse res) {
		// 返回应答给客户端
		if (res.getStatus().code() != 200) {
			ByteBuf buf = Unpooled.copiedBuffer(res.getStatus().toString(), CharsetUtil.UTF_8);
			res.content().writeBytes(buf);
			buf.release();
		}
		// 如果是非Keep-Alive，关闭连接
		ChannelFuture f = ctx.channel().writeAndFlush(res);
		if (!HttpHeaders.isKeepAlive(req) || res.getStatus().code() != 200) {
			f.addListener(ChannelFutureListener.CLOSE);
		}
	}
}