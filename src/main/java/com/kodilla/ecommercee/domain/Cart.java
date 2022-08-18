package com.kodilla.ecommercee.domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> cart;
    private Long cartId;

    public Cart(Long cartId) {
        cartId = this.cartId;
        cart = new ArrayList<>();
    }

    public List<Product> getCart() {
        return cart;
    }

    public Long getCartId() {
        return cartId;
    }
}
