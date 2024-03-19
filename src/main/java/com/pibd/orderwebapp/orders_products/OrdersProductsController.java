package com.pibd.orderwebapp.orders_products;


import com.pibd.orderwebapp.orders.OrderDto;
import com.pibd.orderwebapp.products.ProductsDto;
import com.pibd.orderwebapp.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(Constants.API_URL_PATH + "/products_orders")
@RequiredArgsConstructor
public class OrdersProductsController
{

    private final OrdersProductsService ordersProductsService;


    @GetMapping("/")
    public OrdersProductsDto getAllOrdersAndProducts(){
        return ordersProductsService.getAllOrdersAndProducts();
    }

    @PostMapping("/add_product/{orderId}")
    public ResponseEntity<String> addProductToOrder(@PathVariable Long orderId, @RequestBody ProductsDto requestBody){
        try {
            ordersProductsService.addProductToOrder(orderId,requestBody);
            return new ResponseEntity<>(HttpStatusCode.valueOf(200));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }
    @PostMapping("/add_order/{productId}")
    public ResponseEntity<String> addOrderToProduct(@PathVariable Long productId, @RequestBody OrderDto requestBody){
        try {
            ordersProductsService.addOrderToProduct(productId, requestBody);
            return new ResponseEntity<>(HttpStatusCode.valueOf(200));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }
}
