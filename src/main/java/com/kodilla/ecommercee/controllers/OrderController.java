package com.kodilla.ecommercee.controllers;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    private final OrderMapper orderMapper;
    private static final List<Order> orderList = Arrays.asList(
            new Order(1L,"Order1", "Description1"),
            new Order(2L,"Order2", "Description3"),
            new Order(3L,"Order3", "Description4")
    );

    @Autowired
    public OrderController(OrderMapper taskMapper) {
        this.orderMapper = taskMapper;
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return ResponseEntity.ok(orderMapper.mapToTaskDtoList(orderList));
    }

    @GetMapping(value = "{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderMapper.mapToOrderDto(orderList.get(0)));
    }

    @DeleteMapping(value = "{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderList.remove(0); //next: get method from DBservice
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<OrderDto> updateOrder(@RequestBody OrderDto orderDto) {
        Order order = orderMapper.mapToOrder(orderDto);
        Order savedOrder = order; //next: get method from DBservice
        return ResponseEntity.ok(orderMapper.mapToOrderDto(savedOrder));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createOrder(@RequestBody OrderDto orderDto) {
        Order order = orderMapper.mapToOrder(orderDto);
        //next: get method from DBservice
        return ResponseEntity.ok().build();
    }
}
