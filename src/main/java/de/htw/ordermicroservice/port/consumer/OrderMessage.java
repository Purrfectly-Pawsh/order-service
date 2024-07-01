package de.htw.ordermicroservice.port.consumer;

import de.htw.ordermicroservice.core.domain.model.OrderItem;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class OrderMessage {

    private String userId;
    private String email;
    private String address;
    private String invoiceUrl;
    private String totalCost;
    private List<OrderItem> items;

}
