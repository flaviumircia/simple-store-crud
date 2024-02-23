package com.pibd.orderwebapp.orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderDto,Long> {
}
