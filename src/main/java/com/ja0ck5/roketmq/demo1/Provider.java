package com.ja0ck5.roketmq.demo1;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * Created by Jack on 2017/6/12.
 */
public class Provider {

	public static void main(String[] args)
			throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
		DefaultMQProducer producer = new DefaultMQProducer("first_producer");

		producer.setNamesrvAddr("192.168.72.137:9876;192.168.72.138:9876");

		producer.start();

		for (int i = 0; i < 100; i++) {
			Message message = new Message("TopicDemo1", "TagA", ("first demo of rocketmq " + i).getBytes());
			SendResult result = producer.send(message);
			System.out.println(result);
		}
		producer.shutdown();
	}
}
