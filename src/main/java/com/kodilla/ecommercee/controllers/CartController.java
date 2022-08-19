package com.kodilla.ecommercee.controllers;

import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    private List<ProductDto> cart;

    @GetMapping(value = "/cart/")
    public void createCart() {
        cart = new ArrayList<>();
    }

    @GetMapping
    public List<ProductDto> getProducts() {
        return new ArrayList<>();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addProduct(@RequestBody ProductDto productDto) {
        cart.add(productDto);
    }

    @DeleteMapping(value = "{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        cart.remove(productId);
    }

    @PostMapping(value = "/order/")
    public void createOrder(@RequestBody List<ProductDto> cart) {

    }
}
