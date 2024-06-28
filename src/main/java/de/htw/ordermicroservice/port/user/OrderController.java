package de.htw.ordermicroservice.port.user;

import de.htw.ordermicroservice.core.domain.model.Order;
import de.htw.ordermicroservice.core.domain.service.impl.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.UUID;

@ResponseStatus
@RequestMapping("/v1")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/{userId}")
    public List<Order> getAllOrdersOfOneUser(@PathVariable UUID userId) {
        return orderService.getAllOrdersOfOneUser(userId);
    }

}
