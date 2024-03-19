package com.pibd.orderwebapp.products;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<ProductsDto,Long> {
}
