package de.htw.ordermicroservice.core.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "previous_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID userId;
    private String email;
    private String address;
    @Column(length = 2000)
    private String invoiceUrl;
    private String totalCost;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> products;

}
