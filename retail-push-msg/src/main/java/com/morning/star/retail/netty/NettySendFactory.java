package com.morning.star.retail.netty;

import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.enums.PushMsgStatus;
import com.morning.star.retail.enums.PushMsgType;
import com.morning.star.retail.kingdee.service.PushMsgService;
import com.retail.push.msg.api.info.BaseMsg;
import com.retail.push.msg.api.info.PushMsg;
import io.netty.channel.socket.SocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NettySendFactory {
	@Autowired
	private PushMsgService pushMsgService;

	public WebJsonBean sendMsg(List<PushMsg> pushMsgList) {
		pushMsgList.forEach(pushMsg -> {
			//获取客户端链接服务端时创建的NettyChannelMap
			SocketChannel channel = (SocketChannel) NettyChannelMap.get(pushMsg.getClientId());
			if (channel != null) {
				channel.writeAndFlush(pushMsg);
				if (pushMsg.getData().getMsgType().equals(PushMsgType.NORMAL.getCode())) {
					pushMsgService.updateStatus(pushMsg.getData().getMsgCode(), PushMsgStatus.SUCCESS);
				} else {
					pushMsgService.updateStatus(pushMsg.getData().getMsgCode(), PushMsgStatus.SEND);
				}
			}
		});

		return WebJsonBean.success();
	}

	public WebJsonBean sendBaseMsg(List<BaseMsg> msgList) {
		msgList.forEach(msg -> {
			//获取客户端链接服务端时创建的NettyChannelMap
			SocketChannel channel = (SocketChannel) NettyChannelMap.get(msg.getClientId());
			if (channel != null) {
				channel.writeAndFlush(msg);
			}
		});

		return WebJsonBean.success();
	}

}
