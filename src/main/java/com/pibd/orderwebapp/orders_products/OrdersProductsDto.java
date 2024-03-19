package com.pibd.orderwebapp.orders_products;

import com.pibd.orderwebapp.orders.OrderDto;
import com.pibd.orderwebapp.products.ProductsDto;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class OrdersProductsDto {

    private List<OrderDto> order;
    private List<ProductsDto> product;

    @Override
    public String toString() {
        return "OrdersProductsDto{" +
                "order=" + order +
                ", product=" + product +
                '}';
    }
}
