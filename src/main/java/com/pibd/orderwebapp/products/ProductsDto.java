package com.pibd.orderwebapp.products;

import com.pibd.orderwebapp.orders.OrderDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(schema = "pibd_orders_products", name = "products")
@SequenceGenerator(sequenceName = "products_sequence", name = "products_sequence", allocationSize = 1)
public class ProductsDto {

    @Id
    @GeneratedValue(generator = "products_sequence",strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;
    private String description;
    private int stock;
    private BigDecimal price;

    @ManyToMany(mappedBy = "products")
    private Set<OrderDto> orders;
    public void addOrder(OrderDto order){
        this.getOrders().add(order);
//        order.getProducts().add(this);
    }
    @Override
    public String toString() {
        return "ProductsDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}
