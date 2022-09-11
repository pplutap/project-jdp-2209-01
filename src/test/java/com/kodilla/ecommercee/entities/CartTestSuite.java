package com.kodilla.ecommercee.entities;

import com.kodilla.ecommercee.EcommerceeApplication;
import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.repositories.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EcommerceeApplication.class)
public class CartTestSuite {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    RequestProductRepository requestProductRepository;

    @Autowired
    CartRepository cartRepository;

    Group group = new Group();
    Order order = new Order();
    User user = new User();
    Product product = new Product();
    RequestProduct requestProduct = new RequestProduct();
    Cart cart = new Cart();

    @Test
    public void saveCartTest() {
        //Given
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

        //When
        boolean cartTest = cartRepository.existsById(7L);
        Long cartId = cartRepository.save(cart).getId();
        boolean cartActual = cartRepository.existsById(cartId);

        //Then
        assertEquals(false, cartTest);
        assertEquals(true, cartActual);
    }

    @Test
    public void deleteCartTest() {
        //Given
        group.setName("Second group");
        product.setName("Second product");
        product.setDescription("Second Product description");
        product.setPrice(new BigDecimal(200.00));
        product.setGroup(group);
        product.setVersion(1);
        requestProduct.setQuantity(22.00);
        requestProduct.setProduct(product);
        user.setName("Adam");
        user.setStatus("Active");
        user.setUserKey(1);
        user.setLoginInfo(Login.LOGGED);
        order.setName("Second order");
        order.setComment("Second Order description");
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

        //When
        order.setRequestProduct(null);
        requestProduct.setCart(null);
        cart.setRequestProduct(null);

        orderRepository.save(order);
        requestProductRepository.save(requestProduct);
        cartRepository.save(cart);

        orderRepository.deleteAll();
        requestProductRepository.deleteAll();
        cartRepository.deleteAll();

        //Then
        assertEquals(Optional.empty(), cartRepository.findById(cart.getId()));
    }
}
