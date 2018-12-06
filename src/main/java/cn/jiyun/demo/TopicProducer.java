package cn.jiyun.demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author lhp
 * @create 2018-11-15 15:47
 * 发布订阅模式：生产者
 */
public class TopicProducer {

    public static void main(String[] args) throws Exception {

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.129:61616");

        Connection connection = connectionFactory.createConnection();

        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic("test-topic");

        MessageProducer producer = session.createProducer(topic);

        TextMessage textMessage = session.createTextMessage("发布订阅模式测试！！！");

        producer.send(textMessage);

        producer.close();
        session.close();
        connection.close();
    }

}
