package de.htw.ordermicroservice.core.domain.service.interfaces;

import de.htw.ordermicroservice.core.domain.model.Order;

import java.util.UUID;

public interface IOrderService {

    Iterable<Order> getAllOrdersOfOneUser(UUID userId);

    void addOrder(Order order);

}
