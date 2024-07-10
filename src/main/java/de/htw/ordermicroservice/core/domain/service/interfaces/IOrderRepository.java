package de.htw.ordermicroservice.core.domain.service.interfaces;

import de.htw.ordermicroservice.core.domain.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface IOrderRepository extends CrudRepository<Order, UUID> {
    List<Order> findAllByUserId(UUID userId);
}
