package com.pibd.orderwebapp.products;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsService {

    private final ProductsRepository productsRepository;

    public List<ProductsDto> getAllProducts() {
        return productsRepository.findAll();
    }

    public ProductsDto getProductById(Long id) {
        return productsRepository.findById(id).orElseThrow(()-> new RuntimeException("Product with the id" + id +" doesn't exists!"));
    }

    public void addProduct(ProductsDto productsDto) {
        productsRepository.save(productsDto);
    }

    public void deleteProductById(Long id) {
        productsRepository.deleteById(id);
    }

    public void updateProductById(Long id, ProductsDto request) {
        ProductsDto tmp = productsRepository.findById(id).orElseThrow(()-> new RuntimeException("Product with id: " + id +" doesn't exists!"));
        tmp.setDescription(request.getDescription());
        tmp.setPrice(request.getPrice());
        tmp.setTitle(request.getTitle());
        tmp.setStock(request.getStock());
        productsRepository.save(tmp);
    }
}
