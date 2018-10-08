package com.zhangyongbin.onlinestore.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Destination;
import javax.jms.Topic;

@Configuration
public class JmsTopicConfig {
    @Bean(name = "itemAddTopic")
    public Topic addItemTopic(){
        Topic bean = new ActiveMQTopic("itemAddTopic");
        return bean;
    }
    @Bean(name = "test-queue")
    public Destination testQueue(){
        Destination bean = new ActiveMQQueue("test-queue");
        return bean;
    }
    @Bean(name = "itemUpdateTopic")
    public Topic updateItemTopic(){
        Topic bean = new ActiveMQTopic("itemUpdateTopic");
        return bean;
    }
    @Bean(name = "itemDeleteTopic")
    public Topic deleteItemTopic(){
        Topic bean = new ActiveMQTopic("itemDeleteTopic");
        return bean;
    }
}
