package com.pibd.orderwebapp.orders;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "orders", schema = "pibd_orders_products")
@SequenceGenerator(sequenceName = "orders_sequence", allocationSize = 1, initialValue = 1, name = "orders_sequence")
public class OrderDto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orders_sequence")
    private Long id;
    private BigDecimal total_price;
    private Timestamp order_date;

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", total_price=" + total_price +
                ", order_date=" + order_date +
                '}';
    }
}
