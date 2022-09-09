package com.kodilla.ecommercee.services;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.exceptions.CartNotFoundException;
import com.kodilla.ecommercee.mappers.CartMapper;
import com.kodilla.ecommercee.repositories.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    public List<CartDto> getAllCarts() {
        List<Cart> cartList = cartRepository.findAll();
        List<CartDto> cartDtoList = cartMapper.mapToCardDtoList(cartList);
        return cartDtoList;
    }

    public CartDto getCart(final Long cartId) throws CartNotFoundException {
        Cart cart = cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new);
        CartDto cartDto = cartMapper.mapToCartDto(cart);
        return cartDto;
    }

    public Cart saveCart(final CartDto cartDto) {
        Cart cart = cartMapper.mapToCart(cartDto);
        return cartRepository.save(cart);
    }

    public CartDto editCart(final CartDto cartDto) {
        Cart cart = cartMapper.mapToCart(cartDto);
        Cart savedCart = cartRepository.save(cart);
        return cartMapper.mapToCartDto(savedCart);
    }

    public void deleteCart(final Long cartId) {
        cartRepository.deleteById(cartId);
    }
}
