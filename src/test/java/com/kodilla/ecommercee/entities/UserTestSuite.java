package com.kodilla.ecommercee.entities;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.repositories.CartRepository;
import com.kodilla.ecommercee.repositories.OrderRepository;
import com.kodilla.ecommercee.repositories.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserTestSuite {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

//    @Test
//    public void testUserSaveNoCart() {
//        //given
//        //User user = new User(123L, "John Smith", "status", 14523L, Login.LOGGED,null);
//
//        //when
//        userRepository.save(user);
//        long userId = user.getId();
//
//        //then
//        Assert.assertNotEquals(0, userId);
//        Assert.assertEquals(123L, userId);
//
//        //cleanUp
//        userRepository.delete(user);
//    }
//
//    @Test
//    public void testUserSaveWithCart() {
//        //given
//        //User user = new User(12L, "John Smith", "status", 14523L, Login.LOGGED,null);
//        Cart cart = new Cart(145L, user, null);
//
//        //when
//        userRepository.save(user);
//        cartRepository.save(cart);
//        long userId = user.getId();
//        long cartId = cart.getId();
//
//        //then
//        Assert.assertNotEquals(0, userId);
//        Assert.assertNotEquals(0, cartId);
//        Assert.assertEquals(12L, userId);
//        Assert.assertEquals(145L, cartId);
//
//        //cleanUp
//        userRepository.delete(user);
//        cartRepository.delete(cart);
//    }
//
//    @Test
//    public void testUserSaveWithOrders() {
//        //given
//        List<Order> orders = new ArrayList<>();
//        User user = new User(12L, "John Smith", "status", 14523L, Login.LOGGED, orders);
//        Cart cart = new Cart(145L, user, null);
//        Order order1 = new Order(56L, "order1", "comment1", true, Status.IN_PROGRESS, Date.valueOf(LocalDate.now()), user);
//        Order order2 = new Order(57L, "order2", "comment2", true, Status.DELIVERED, Date.valueOf(LocalDate.now()), user);
//        orders.add(order1);
//        orders.add(order2);
//
//        //when
//        userRepository.save(user);
//        cartRepository.save(cart);
//        orderRepository.save(order1);
//        orderRepository.save(order2);
//        long userId = user.getId();
//        long cartId = cart.getId();
//        long order1Id = order1.getId();
//        long order2Id = order2.getId();
//
//
//        //then
//        Assert.assertEquals(12L, userId);
//        Assert.assertEquals(145L, cartId);
//        Assert.assertEquals(56L, order1Id);
//        Assert.assertEquals(57L, order2Id);
//
//        //cleanUp
//        userRepository.delete(user);
//        cartRepository.delete(cart);
//        orderRepository.delete(order1);
//        orderRepository.delete(order2);
//    }
}
