package com.pibd.orderwebapp.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderDto getOrderById(Long id) {
        Optional<OrderDto> order = orderRepository.findById(id);
        return order.orElseThrow(()->new RuntimeException("Order with id: " + id +" doesn't exists"));
    }

    public void addOrder(OrderDto orderDto) {
        orderRepository.save(orderDto);
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }

    public void updateOrderById(Long id, OrderDto request) {
        Optional<OrderDto> order = orderRepository.findById(id);
        if(order.isPresent()){
            order.get().setTotal_price(request.getTotal_price());
            order.get().setOrder_date(request.getOrder_date());
            orderRepository.save(order.get());
        }else{
            throw new RuntimeException("Order with id: " + id +" doesn't exists");
        }
    }
}
