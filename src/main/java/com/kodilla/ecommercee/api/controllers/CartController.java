package com.kodilla.ecommercee.api.controllers;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.RequestProductDto;
import com.kodilla.ecommercee.exceptions.PriceOfProductChangedException;
import com.kodilla.ecommercee.exceptions.ProductInCartNotFoundException;
import com.kodilla.ecommercee.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping(value = "{productId}")
    public ResponseEntity<RequestProductDto> getProductFromCart(@PathVariable Long productId) throws ProductInCartNotFoundException {
        return ResponseEntity.ok(cartService.getRequestProduct(productId));
    }

    @GetMapping
    public ResponseEntity<List<RequestProductDto>> getAllProductsFromCart() {
        return ResponseEntity.ok(cartService.getAllProducts());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createPositionInCart(@RequestBody RequestProductDto requestProductDto) {
        cartService.saveElementInCart(requestProductDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{requestProductId}")
    public ResponseEntity<Void> deleteProductFromCart(@PathVariable Long requestProductId) throws ProductInCartNotFoundException {
        cartService.deleteElementFromCart(requestProductId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteAllProductsFromCart() {
        cartService.deleteAllProductsFromCart();
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<CartDto> updateElementInCart(@RequestBody CartDto cartDto) {
        return ResponseEntity.ok(cartService.editElementInCart(cartDto));
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody List<Cart> cardList) throws PriceOfProductChangedException {
        cartService.createOrder(cardList);
        return ResponseEntity.ok().build();
    }
}
