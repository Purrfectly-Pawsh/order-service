package de.htw.ordermicroservice.port.user;

import de.htw.ordermicroservice.core.domain.model.Order;
import de.htw.ordermicroservice.core.domain.service.impl.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders/{userId}")
    public List<Order> getAllOrdersOfOneUser(@PathVariable UUID userId) {
        log.info("order");
        return orderService.getAllOrdersOfOneUser(userId);
    }

}
