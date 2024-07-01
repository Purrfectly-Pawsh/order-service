package de.htw.ordermicroservice.port.consumer;

import de.htw.ordermicroservice.core.domain.model.Order;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class CheckoutMapper {
    public static Order toOrder(OrderMessage message) {
        Order order = Order.builder()
                .userId(UUID.fromString(message.getUserId()))
                .email(message.getEmail())
                .address(message.getAddress())
                .invoiceUrl(message.getInvoiceUrl())
                .totalCost(message.getTotalCost())
                .products(message.getItems())
                .build();
        return order;
    }
}
