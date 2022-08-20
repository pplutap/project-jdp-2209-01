package com.kodilla.ecommercee.api.controllers;

import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private static final List<ProductDto> products = Arrays.asList(
            new ProductDto(1L, "test name 1", "test description 1", 123.45, 1L),
            new ProductDto(2L, "test name 2", "test description 2", 543.21, 1L),
            new ProductDto(3L, "test name 3", "test description 3", 111.11, 1L)
    );

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        return ResponseEntity.ok(products);
    }

    @GetMapping(value = "{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long productId) {
        ProductDto product = new ProductDto(1L, "test name", "test description", 123.45, 1L);
        return ResponseEntity.ok(product);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(new ProductDto(1L, "Edited test name", "Edited test description", 100.00, 1L));
    }

    @DeleteMapping(value = "{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        return ResponseEntity.ok().build();
    }
}
