package com.morning.star.retail.netty.hander;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.enums.PushMsgType;
import com.retail.push.msg.api.info.BaseMsg;
import com.retail.push.msg.api.info.HeartbeatRequestMsg;
import com.retail.push.msg.api.info.PushAskMsg;
import com.retail.push.msg.api.info.PushMsg;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Dell on 2018/7/17.
 */
public class NettyClientInboundHandler extends SimpleChannelInboundHandler<BaseMsg> {

	private static final Logger logger = LoggerFactory.getLogger(NettyClientInboundHandler.class);
	private String clientId;

	public NettyClientInboundHandler(String clientId) {
		this.clientId = clientId;
	}

	//利用写空闲发送心跳检测消息
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent e = (IdleStateEvent) evt;
			switch (e.state()) {
				case WRITER_IDLE:
					HeartbeatRequestMsg heartbeatRequestMsg = new HeartbeatRequestMsg(clientId);
					ctx.writeAndFlush(heartbeatRequestMsg);
					logger.info("send ping to server----------");
					break;
				default:
					break;
			}
		}
	}

	@Override
	protected void messageReceived(ChannelHandlerContext channelHandlerContext, BaseMsg baseMsg) {
		switch (baseMsg.getType()) {
			case CONNECT_FAIL: {
				logger.info("connect service fail----------" + JSON.toJSON(baseMsg));
				channelHandlerContext.close();
			}
			break;
			case CONNECT_SUCCESS: {
				logger.info("connect service success----------" + JSON.toJSON(baseMsg));
			}
			break;
			case HEARTBEAT_REQ: {
				logger.info("receive heartbeat req----------" + JSON.toJSONString(baseMsg));
			}
			break;
			case HEARTBEAT_RESP: {
				logger.info("receive heartbeat resp----------" + JSON.toJSONString(baseMsg));
			}
			break;
			case MSG_PUSH: {
				PushMsg pushMsg = (PushMsg) baseMsg;
				logger.info("receive service msg----------" + JSON.toJSON(pushMsg));
				PushAskMsg pushAskMsg = new PushAskMsg(pushMsg);
				if (pushMsg.getData().getMsgType().equals(PushMsgType.CONFIRM.getCode())) {
					channelHandlerContext.channel().writeAndFlush(pushAskMsg);
				}
			}
			break;
			case OFF_LINE: {
				logger.info("connect offline----------" + JSON.toJSONString(baseMsg));
				channelHandlerContext.close();
			}
			break;
			default:
				break;
		}
		ReferenceCountUtil.release(baseMsg);
	}
}
