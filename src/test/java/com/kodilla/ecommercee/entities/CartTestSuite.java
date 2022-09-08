package com.kodilla.ecommercee.entities;

import com.kodilla.ecommercee.EcommerceeApplication;
import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.repositories.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
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
    public void shouldSaveCartEntity() {
        //Given
        group.setName("First group");

        order.setName("First order");
        order.setComment("Order description");
        order.setPaid(true);
        order.setStatus(Status.SENT);
        order.setCreationDate(new Date());
        order.setUser(user);
        order.setRequestProduct(requestProduct);

        user.setName("John");
        user.setStatus("Active");
        user.setUserKey(1);
        user.setLoginInfo(Login.LOGGED);

        product.setName("First product");
        product.setDescription("Product description");
        product.setPrice(new BigDecimal(200.00));
        product.setGroup(group);
        product.setVersion(1);

        requestProduct.setQuantity(22.00);
        requestProduct.setProduct(product);
        requestProduct.setCart(cart);
        requestProduct.setOrder(order);

        cart.setUser(user);
        cart.setRequestProduct(requestProduct);

        //When
        groupRepository.save(group);
        orderRepository.save(order);
        userRepository.save(user);
        productRepository.save(product);
        requestProductRepository.save(requestProduct);
        cartRepository.save(cart);

        boolean cartTest = cartRepository.existsById(7L);
        Long cartId = cartRepository.save(cart).getId();
        boolean cartActual = cartRepository.existsById(cartId);

        //Then
        assertEquals(false, cartTest);
        assertEquals(true, cartActual);
    }

}
