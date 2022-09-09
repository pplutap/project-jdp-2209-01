package com.kodilla.ecommercee.entities;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.repositories.*;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserTestSuite {

    private Order order1;
    private User user;
    private Group group;
    private RequestProduct requestProduct;
    private Product product;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private RequestProductRepository requestProductRepository;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setObjects() {
        order1 = new Order();
        user = new User();
        group = new Group();
        product = new Product();
        requestProduct = new RequestProduct();

        group.setName("Accessories");
        groupRepository.save(group);

        product.setName("red bag");
        product.setDescription("Gucci brand");
        product.setPrice(new BigDecimal(600));
        product.setGroup(group);
        product.setVersion(1);
        productRepository.save(product);

        requestProduct.setProduct(product);
        requestProduct.setQuantity(1.00);
        requestProductRepository.save(requestProduct);

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        order1.setCreationDate(new Date(2021, 12,15));
        order1.setStatus(Status.IN_PROGRESS);
        order1.setComment("Send asap please");
        order1.setName("Christmas order");
        order1.setPaid(true);
        order1.setRequestProduct(requestProduct);
        orderRepository.save(order1);

        user.setUserKey(14523L);
        user.setName("John Smith");
        user.setStatus("status");
        user.setLoginInfo(Login.LOGGED);
        user.setOrders(orders);
        userRepository.save(user);

        order1.setUser(user);
    }

    @AfterEach
    void cleanUp() {
//        productRepository.delete(product);
//        groupRepository.delete(group);
//        requestProductRepository.delete(requestProduct);
//        orderRepository.delete(order1);
//        userRepository.delete(user);
    }

    @Test
    public void testUserSave() {
        //given

        //when
        long userId = user.getId();
        boolean isExist = userRepository.existsById(userId);

        //then
        Assert.assertNotEquals(0, userId);
        Assert.assertEquals(true, isExist);
    }

    @Test
    public void testUserDelete() {
        //given

        //when
        long userId = user.getId();
        userRepository.deleteById(userId);
        boolean isExist = userRepository.existsById(userId);

        //then
        Assert.assertNotEquals(0, userId);
        Assert.assertEquals(false, isExist);
    }
}
