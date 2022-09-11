package com.kodilla.ecommercee.services;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.exceptions.PriceOfProductChangedException;
import com.kodilla.ecommercee.exceptions.ProductInCartNotFoundException;
import com.kodilla.ecommercee.mappers.CartMapper;
import com.kodilla.ecommercee.repositories.CartRepository;
import com.kodilla.ecommercee.repositories.OrderRepository;
import com.kodilla.ecommercee.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final CartMapper cartMapper;

    public List<RequestProductDto> getAllProducts() {
        List<Cart> cartList = cartRepository.findAll();
        List<RequestProduct> requestProductList = new ArrayList<>();
        for (Cart cart: cartList) {
            requestProductList.add(cart.getRequestProduct());
        }
        List<RequestProductDto> requestProductDtoList = cartMapper.mapToRequestProductDtoList(requestProductList);
        return requestProductDtoList;
    }

    public RequestProductDto getRequestProduct(final Long productID) throws ProductInCartNotFoundException {
        Cart cart = cartRepository.findCartByRequestProduct_Id(productID).orElseThrow(ProductInCartNotFoundException::new);
        RequestProduct requestProduct = cart.getRequestProduct();
        RequestProductDto requestProductDto = cartMapper.mapToRequestProductDto(requestProduct);
        return requestProductDto;
    }

    public Cart saveElementInCart(final RequestProductDto requestProductDto) {
        RequestProduct requestProduct = cartMapper.mapToRequestProduct(requestProductDto);
        Cart cart = requestProduct.getCart();
        return cartRepository.save(cart);
    }

    public CartDto editElementInCart(final CartDto cartDto) {
        Cart cart = cartMapper.mapToCart(cartDto);
        Cart savedCart = cartRepository.save(cart);
        return cartMapper.mapToCartDto(savedCart);
    }

    public void deleteElementFromCart(final Long requestProductId) throws ProductInCartNotFoundException {
        cartRepository.deleteCartByRequestProduct_Id(requestProductId).orElseThrow(ProductInCartNotFoundException::new);
    }

    public void deleteAllProductsFromCart() {
        cartRepository.deleteAll();
    }

    public void createOrder(final List<Cart> cartList) throws PriceOfProductChangedException {
        boolean priceChanged = false;
        for (Cart cart: cartList) {
            if ((cart.getRequestProduct().getProduct().getVersion() !=
            productRepository.findById(cart.getRequestProduct().getProduct().getId()).get().getVersion()) &&
            !priceChanged) {
                priceChanged = true;
            }
        }
        if(!priceChanged) {
            for (Cart cart: cartList) {
                Order order = new Order();
                order.setId(0L);
                order.setName("Order from CartController");
                order.setComment("Order from CartController");
                order.setPaid(false);
                order.setStatus(Status.IN_PROGRESS);
                order.setCreationDate(new Date(System.currentTimeMillis()));
                order.setUser(cart.getUser());
                order.setRequestProduct(cart.getRequestProduct());
                orderRepository.save(order);
            }
        } else {
            deleteAllProductsFromCart();
            throw new PriceOfProductChangedException();
        }
    }
}
