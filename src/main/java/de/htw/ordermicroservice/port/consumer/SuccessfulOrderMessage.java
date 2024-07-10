package de.htw.ordermicroservice.port.consumer;

import de.htw.ordermicroservice.core.domain.model.OrderItem;
import lombok.Data;

import java.util.List;

@Data
public class SuccessfulOrderMessage {

    private String userId;
    private String email;
    private String address;
    private String invoiceUrl;
    private String totalCost;
    private List<OrderItem> items;

}
