package com.kodilla.ecommercee.controllers;

import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    List<ProductDto> cart;

    @PostMapping
    public void createCart() {
        cart = new ArrayList<>();
    }

    @GetMapping
    public List<ProductDto> getProducts() {
        return new ArrayList<>();
    }

    @PostMapping(value = "{productId}")
    public void addProduct(@PathVariable Long productId) {

    }

    @DeleteMapping(value = "{productId}")
    public void deleteProduct(@PathVariable Long productId) {

    }

    @PostMapping(value = "{cartId}")
    public void createOrder(@PathVariable Long cartId) {

    }
}
