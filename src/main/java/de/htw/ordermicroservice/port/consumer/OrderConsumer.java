package de.htw.ordermicroservice.port.consumer;

import de.htw.ordermicroservice.config.RabbitMQConfig;
import de.htw.ordermicroservice.core.domain.model.Order;
import de.htw.ordermicroservice.core.domain.service.interfaces.IOrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    private final IOrderService orderService;

    public OrderConsumer(IOrderService orderService) {
        this.orderService = orderService;
    }

    @RabbitListener(queues = RabbitMQConfig.CREATE_ORDER_QUEUE)
    public void receiveOrderEvent(OrderMessage message) {
        Order order = CheckoutMapper.toOrder(message);
        orderService.addOrder(order);
    }

}
