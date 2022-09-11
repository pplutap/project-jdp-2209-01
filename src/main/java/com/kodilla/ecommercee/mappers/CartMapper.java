package com.kodilla.ecommercee.mappers;

import com.kodilla.ecommercee.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartMapper {

    public Cart mapToCart(final CartDto cartDto) {
        return new Cart(
                cartDto.getId(),
                cartDto.getUser(),
                cartDto.getRequestProduct()
        );
    }

    public RequestProduct mapToRequestProduct(final RequestProductDto requestProductDto) {
        return new RequestProduct(
                requestProductDto.getId(),
                requestProductDto.getQuantity(),
                requestProductDto.getProduct(),
                new Cart(),
                new Order()
        );
    }

    public CartDto mapToCartDto(final Cart cart) {
        return new CartDto(
                cart.getId(),
                cart.getUser(),
                cart.getRequestProduct()
        );
    }

    public RequestProductDto mapToRequestProductDto(final RequestProduct requestProduct) {
        return new RequestProductDto(
                requestProduct.getId(),
                requestProduct.getQuantity(),
                requestProduct.getProduct()
        );
    }

    public List<CartDto> mapToCardDtoList(final List<Cart> cartList) {
        return cartList.stream()
                .map(this::mapToCartDto)
                .collect(Collectors.toList());
    }

    public List<RequestProductDto> mapToRequestProductDtoList(final List<RequestProduct> requestProductList) {
        return requestProductList.stream()
                .map(this::mapToRequestProductDto)
                .collect(Collectors.toList());
    }
}
