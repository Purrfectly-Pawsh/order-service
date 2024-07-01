package de.htw.ordermicroservice.port.consumer;

import de.htw.ordermicroservice.config.RabbitMQConfig;
import de.htw.ordermicroservice.core.domain.model.Order;
import de.htw.ordermicroservice.core.domain.service.interfaces.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderConsumer {

    private final IOrderService orderService;

    public OrderConsumer(IOrderService orderService) {
        this.orderService = orderService;
    }

    @RabbitListener(queues = RabbitMQConfig.CREATE_ORDER_QUEUE)

    public void receiveOrderEvent(OrderMessage message) {
        try{
            Order order = CheckoutMapper.toOrder(message);
            orderService.addOrder(order);
        } catch ( Exception e ) {
            log.info(e.getMessage());
        }
    }

}
