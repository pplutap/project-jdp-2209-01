package com.kodilla.ecommercee.domain;

import java.util.ArrayList;
import java.util.List;

public class CartDto {
    private List<ProductDto> cartDto;
    private Long cartDtoId;

    public CartDto(Long cartDtoId) {
        cartDtoId = this.cartDtoId;
        cartDto = new ArrayList<>();
    }

    public List<ProductDto> getCartDto() {
        return cartDto;
    }

    public Long getCartDtoId() {
        return cartDtoId;
    }
}
