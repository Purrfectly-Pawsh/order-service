package de.htw.ordermicroservice.port.consumer;

import de.htw.ordermicroservice.core.domain.model.Order;

public class CheckoutMapper {
    public static Order toOrder(OrderMessage message) {
        Order order = new Order();
        // do some mapping stuff
        return order;
    }
}
