package com.morning.star.retail.stock.mq;

//import com.morning.star.rabbitmq.MsgHandler;
//import com.morning.star.rabbitmq.Producer;
//import com.morning.star.rabbitmq.QueueConsumer;

/**
 * 
 * @author jiangyf
 * @date 2017年9月15日 上午10:20:36
 */
public class MQTest {
//
//	public static void main(String[] args) throws IOException {
//		test();
//	}
//
//	public static void test() throws IOException {
//		// 创建一个消息处理器
//		MsgHandler handler = new MsgHandler() {
//			public boolean handler(Object obj) {
//				System.out.println("消息回调==>" + obj);
//				return false;
//			}
//		};
//		// 创建一个顺序消费者线程 --》自动消费
//		QueueConsumer consumer = new QueueConsumer("test", handler, true);
//		Thread thread = new Thread(consumer);
//		thread.start();
//
//		// 创建一个以test为消息标识的生产者，发送10条消息
//		Producer producer = new Producer("test");
//		for (int i = 0; i < 100; i++) {
//			producer.sendMessage(i);
//			System.out.println("send msg:" + i);
//		}
//	}

}
