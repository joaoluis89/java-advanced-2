package com.example.demo.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {


    @Bean
    public Queue myQueue() {
        return QueueBuilder.durable("a-queue").build();
    }

    @Bean
    public Exchange myExchange() {
        return ExchangeBuilder.directExchange("myExchange").build();
    }

    @Bean
    public Binding myBinding(Queue myQueue, Exchange myExchange) {
        return BindingBuilder.bind(myQueue).to(myExchange).with("routingKey").noargs();
    }


}
