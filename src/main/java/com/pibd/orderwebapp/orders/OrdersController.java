package com.pibd.orderwebapp.orders;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrdersController {

    private final OrderService orderService;
    @GetMapping("/")
    public List<OrderDto> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderDto getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @PostMapping("/add")
    public void addOrder(@RequestBody OrderDto orderDto){
        orderService.addOrder(orderDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrderById(id);
    }
    @PutMapping("/update/{id}")
    public void updateOrder(@PathVariable Long id,@RequestBody OrderDto request){
        orderService.updateOrderById(id,request);
    }
}
