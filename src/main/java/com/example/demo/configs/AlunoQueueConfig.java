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
public class AlunoQueueConfig {

    public static final String ALUNO_EXCHANGE = "alunoExchange";
    public static final String ALUNO_RK = "alunoRK";

    @Bean
    public Queue alunoQueue() {
        return QueueBuilder.durable("alunoQueue").build();
    }

    @Bean
    public Exchange alunoExchange() {
        return ExchangeBuilder.topicExchange(ALUNO_EXCHANGE).durable(true).build();
    }


    @Bean
    public Binding alunoBinding(Queue alunoQueue, Exchange alunoExchange) {
        return BindingBuilder.bind(alunoQueue).to(alunoExchange).with(ALUNO_RK).noargs();
    }



}
