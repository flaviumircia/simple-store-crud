package com.pibd.orderwebapp.orders;


import com.pibd.orderwebapp.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.API_URL_PATH +"/orders")
public class OrdersController {

    private final OrderService orderService;
    @GetMapping("/")
    public List<OrderDto> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getOrderById(@PathVariable Long id){
        try{
            OrderDto orderDto = orderService.getOrderById(id);
            return ResponseEntity.ok(orderDto.toString());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }

    @PostMapping("/add")
    public void addOrder(@RequestBody OrderDto orderDto){
        orderService.addOrder(orderDto);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id){
        try{
            orderService.deleteOrderById(id);
            return ResponseEntity.ok("Delete operation was successful");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable Long id,@RequestBody OrderDto request){
        try{
            orderService.updateOrderById(id,request);
            return ResponseEntity.ok("Update operation was successful");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }
}
