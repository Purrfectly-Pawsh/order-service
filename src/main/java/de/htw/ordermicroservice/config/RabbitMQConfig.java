package de.htw.ordermicroservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String CREATE_ORDER_QUEUE = "create_order_queue";
    public static final String ORDER_EXCHANGE = "order_exchange";

    @Bean
    public Queue createOrderQueue() {return new Queue(CREATE_ORDER_QUEUE, false);
    }

    @Bean
    public FanoutExchange orderTopicExchange() {
        return new FanoutExchange(ORDER_EXCHANGE);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Binding bindCreateOrderQueue() {
        return BindingBuilder.bind(createOrderQueue()).to(orderTopicExchange());
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }

}
