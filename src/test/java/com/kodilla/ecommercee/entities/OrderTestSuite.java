package com.kodilla.ecommercee.entities;

import com.kodilla.ecommercee.EcommerceeApplication;
import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.repositories.*;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EcommerceeApplication.class)
public class OrderTestSuite {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RequestProductRepository requestProductRepository;

    @Autowired
    private UserRepository userRepository;

    private Group group;
    private Product product;
    private RequestProduct requestProduct;
    private Cart cart;
    private User user;
    private Order order;

    @BeforeEach
    void setObjects() {
        group = new Group();
        product = new Product();
        requestProduct = new RequestProduct();
        cart = new Cart();
        user = new User();
        order = new Order();

        group.setName("Clothes");
        groupRepository.save(group);

        product.setName("T-shirt");
        product.setDescription("Cloth recommended to use during summer");
        product.setPrice(new BigDecimal(100.00));
        product.setVersion(1);
        product.setGroup(group);
        productRepository.save(product);

        requestProduct.setProduct(product);
        requestProduct.setQuantity(3.00);
        requestProductRepository.save(requestProduct);

        user.setName("Piotr Lecicki");
        user.setStatus("Fan of T-shirts");
        user.setUserKey(0000000000001);
        user.setLoginInfo(Login.LOGGED);
        userRepository.save(user);

        order.setPaid(true);
        order.setCreationDate(new Date(2022, 4, 12));
        order.setName("Fast delivery");
        order.setComment("Very important order");
        order.setStatus(Status.SENT);
        order.setRequestProduct(requestProduct);
        order.setUser(user);
    }

    @AfterEach
    void cleanUpData() {
        userRepository.delete(user);
        requestProductRepository.delete(requestProduct);
        productRepository.delete(product);
        groupRepository.delete(group);
    }

    @Test
    void createOrderTest() {
        //Given @BeforeEach
        //When
        orderRepository.save(order);
        //Then
        Assertions.assertNotEquals(order.getId(), null);
        //CleanUp
        orderRepository.delete(order);
        //@AfterEach
    }

    @Test
    void deleteOrderTest() {
        //Given @BeforeEach
        orderRepository.save(order);
        //When
        orderRepository.delete(order);
        //Then
        Assertions.assertEquals(Optional.empty(), orderRepository.findById(order.getId()));
        //CleanUp
        //@AfterEach
    }

    @Test
    void readOrderTest() {
        //Given @BeforeEach
        orderRepository.save(order);
        //When
        Order testOrder = orderRepository.findById(order.getId()).get();
        //Then
        Assertions.assertEquals("Very important order", testOrder.getComment());
        Assertions.assertEquals(true, testOrder.isPaid());
        Assertions.assertEquals("Fast delivery", testOrder.getName());
        Assertions.assertEquals(Status.SENT, testOrder.getStatus());
        Assertions.assertEquals(order.getRequestProduct().getId(), testOrder.getRequestProduct().getId());
        Assertions.assertEquals(order.getUser().getId(), testOrder.getUser().getId());
        //CleanUp
        orderRepository.delete(order);
        //@AfterEach
    }

    @Test
    void editOrderTest() {
        //Given @BeforeEach
        //When
        orderRepository.save(order);

        Order testOrderBefore = orderRepository.findById(order.getId()).get();
        //Then
        Order orderFromDB = orderRepository.findById(order.getId()).get();
        orderFromDB.setName("Slow delivery");
        orderFromDB.setStatus(Status.PREPARED);
        orderRepository.save(orderFromDB);

        Order testOrderAfter = orderRepository.findById(order.getId()).get();

        Assertions.assertEquals("Very important order", testOrderBefore.getComment());
        Assertions.assertEquals(true, testOrderBefore.isPaid());
        Assertions.assertEquals("Fast delivery", testOrderBefore.getName());
        Assertions.assertEquals(Status.SENT, testOrderBefore.getStatus());
        Assertions.assertEquals(order.getRequestProduct().getId(), testOrderBefore.getRequestProduct().getId());
        Assertions.assertEquals(order.getUser().getId(), testOrderBefore.getUser().getId());

        Assertions.assertEquals("Very important order", testOrderAfter.getComment());
        Assertions.assertEquals(true, testOrderAfter.isPaid());
        Assertions.asser ctEquals("Slow delivery", testOrderAfter.getName());
        Assertions.assertEquals(Status.PREPARED, testOrderAfter.getStatus());
        Assertions.assertEquals(order.getRequestProduct().getId(), testOrderAfter.getRequestProduct().getId());
        Assertions.assertEquals(order.getUser().getId(), testOrderAfter.getUser().getId());
        //CleanUp
        orderRepository.delete(order);
        //@AfterEach
    }
}
