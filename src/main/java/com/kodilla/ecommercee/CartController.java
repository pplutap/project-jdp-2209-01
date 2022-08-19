package com.kodilla.ecommercee;

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

    @PostMapping
    public void addProduct(ProductDto productDto) {
        cart.add(productDto);
    }

    @DeleteMapping
    public void deleteProduct(ProductDto productDto) {
        cart.remove(productDto);
    }

    @PostMapping
    public void createOrder(List<ProductDto> cart) {

    }
}
