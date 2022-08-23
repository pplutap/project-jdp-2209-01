package com.kodilla.ecommercee.api.controllers;

import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    private List<ProductDto> cart;

    @GetMapping(value = "/cart/")
    public ResponseEntity<Void> createCart() {
        cart = new ArrayList<>();
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/order/")
    public ResponseEntity<Void> createOrder(@RequestBody List<ProductDto> cart) {
        return ResponseEntity.ok().build();
    }
}
