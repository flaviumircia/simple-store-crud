package com.pibd.orderwebapp.products;

import com.pibd.orderwebapp.orders_products.OrdersProductsDto;
import com.pibd.orderwebapp.orders.OrderService;
import com.pibd.orderwebapp.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.API_URL_PATH + "/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductsService productsService;
    @GetMapping("/")
    public List<ProductsDto> getAllProducts() {
        return productsService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> gerProductById(@PathVariable Long id) {
        try {
            ProductsDto productsDto = productsService.getProductById(id);
            return ResponseEntity.ok(productsDto.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody ProductsDto productsDto) {
        productsService.addProduct(productsDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id) {
        try {
            productsService.deleteProductById(id);
            return ResponseEntity.ok("Delete operation was successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProductById(@PathVariable Long id, @RequestBody ProductsDto request) {
        try {
            productsService.updateProductById(id, request);
            return ResponseEntity.ok("Update operation was successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }
}

