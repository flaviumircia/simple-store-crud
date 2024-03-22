package com.pibd.orderwebapp.orders;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pibd.orderwebapp.products.ProductsDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "orders", schema = "pibd_orders_products")
@SequenceGenerator(sequenceName = "orders_sequence", allocationSize = 1, name = "orders_sequence")
public class OrderDto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orders_sequence")
    private Long id;
    private BigDecimal total_price;
    private Timestamp order_date;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @JsonManagedReference
    private Set<ProductsDto> products;

    public void addProduct(ProductsDto product){
        this.getProducts().add(product);
    }
    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", total_price=" + total_price +
                ", order_date=" + order_date +
                '}';
    }
}
