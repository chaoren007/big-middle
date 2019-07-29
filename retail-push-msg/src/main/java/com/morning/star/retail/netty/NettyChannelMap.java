package com.morning.star.retail.netty;


import com.morning.star.retail.kingdee.service.impl.EquipmentServiceImpl;
import com.morning.star.retail.util.Context;
import io.netty.channel.Channel;
import io.netty.channel.socket.SocketChannel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dell on 2018/7/17.
 */
public class NettyChannelMap {
	private static Map<String, SocketChannel> map = new ConcurrentHashMap<String, SocketChannel>();

	public static void add(String clientId, SocketChannel socketChannel) {
		map.put(clientId, socketChannel);
		Context.getBean(EquipmentServiceImpl.class).activeByEquipmentId(clientId);
	}

	public static Channel get(String clientId) {
		return map.get(clientId);
	}

	public static String remove(SocketChannel socketChannel) {
		String clientId = null;
		for (Map.Entry<String, SocketChannel> entry : map.entrySet()) {
			if (entry.getValue() == socketChannel) {
				map.remove(entry.getKey());
				clientId = entry.getKey();
				break;
			}
		}
		if (clientId != null) {
			Context.getBean(EquipmentServiceImpl.class).closeByEquipmentId(clientId);
		}
		return clientId;
	}

}