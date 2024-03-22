package com.pibd.orderwebapp.orders_products;

import com.pibd.orderwebapp.orders.OrderDto;
import com.pibd.orderwebapp.orders.OrderRepository;
import com.pibd.orderwebapp.orders.OrderService;
import com.pibd.orderwebapp.products.ProductsDto;
import com.pibd.orderwebapp.products.ProductsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrdersProductsService {

    private final OrderRepository orderRepository;
    private final ProductsRepository productsRepository;
    public OrdersProductsDto getAllOrdersAndProducts() {
        List<OrderDto> orders = orderRepository.findAll();
        List<ProductsDto> products = productsRepository.findAll();
        return new OrdersProductsDto(orders, products);
    }

    @Transactional
    public void addProductToOrder(Long orderId, ProductsDto requestBody) {
        OrderDto order = orderRepository.findById(orderId)
                .orElseThrow(
                        () -> new RuntimeException("Order with id: " + orderId + " doesn't exists!")
                );
        order.addProduct(requestBody);
        orderRepository.save(order);
    }

    @Transactional
    public void addOrderToProduct(Long productId, OrderDto requestBody) {

        ProductsDto product = productsRepository.findById(productId)
                .orElseThrow(
                        () -> new RuntimeException("Product with id: " + productId + " doesn't exists!")
                );
        product.addOrder(requestBody);
        productsRepository.save(product);
    }


}
