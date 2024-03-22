package com.pibd.orderwebapp.orders;

import com.pibd.orderwebapp.orders_products.OrdersProductsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<OrderDto,Long> {
}
