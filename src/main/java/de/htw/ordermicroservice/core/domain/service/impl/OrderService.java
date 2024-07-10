package de.htw.ordermicroservice.core.domain.service.impl;

import de.htw.ordermicroservice.core.domain.model.Order;
import de.htw.ordermicroservice.core.domain.service.interfaces.IOrderRepository;
import de.htw.ordermicroservice.core.domain.service.interfaces.IOrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService implements IOrderService {

    private final IOrderRepository orderRepository;

    public OrderService(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrdersOfOneUser(UUID userId) {
        return orderRepository.findAllByUserId(userId);
    }

    @Override
    public void addOrder(Order order) {
        orderRepository.save(order);
    }

}
