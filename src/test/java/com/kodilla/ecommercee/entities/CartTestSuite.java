package com.kodilla.ecommercee.entities;

import com.kodilla.ecommercee.EcommerceeApplication;
import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.repositories.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EcommerceeApplication.class)
public class CartTestSuite {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RequestProductRepository requestProductRepository;

    @Autowired
    private CartRepository cartRepository;

    private Group group;
    private Product product;
    private RequestProduct requestProduct;
    private User user;
    private Order order;
    private Cart cart;

    @BeforeEach
    void setObjects() {
        group = new Group();
        product = new Product();
        requestProduct = new RequestProduct();
        user = new User();
        order = new Order();
        cart = new Cart();

        group.setName("First group");
        product.setName("First product");
        product.setDescription("Product description");
        product.setPrice(new BigDecimal(200.00));
        product.setGroup(group);
        product.setVersion(1);
        requestProduct.setQuantity(22.00);
        requestProduct.setProduct(product);
        user.setName("John");
        user.setStatus("Active");
        user.setUserKey(1);
        user.setLoginInfo(Login.LOGGED);
        order.setName("First order");
        order.setComment("Order description");
        order.setPaid(true);
        order.setStatus(Status.SENT);
        order.setCreationDate(new Date());
        order.setUser(user);
        order.setRequestProduct(requestProduct);
        cart.setUser(user);
        cart.setRequestProduct(requestProduct);
        userRepository.save(user);
        groupRepository.save(group);
        productRepository.save(product);
        requestProductRepository.save(requestProduct);
        cartRepository.save(cart);
        orderRepository.save(order);
        requestProduct.setCart(cart);
        requestProduct.setProduct(product);
        requestProductRepository.save(requestProduct);
    }

    @Test
    public void shouldSaveCart() {
        //When
        boolean cartTest = cartRepository.existsById(7L);
        Long cartId = cartRepository.save(cart).getId();
        boolean cartActual = cartRepository.existsById(cartId);

        //Then
        assertEquals(false, cartTest);
        assertEquals(true, cartActual);
    }

}
