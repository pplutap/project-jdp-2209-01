package com.kodilla.ecommercee.controllers;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    private static final List<OrderDto> orders = Arrays.asList(
            new OrderDto(1L,"Order1", "Description1"),
            new OrderDto(2L,"Order2", "Description3"),
            new OrderDto(3L,"Order3", "Description4")
    );

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return ResponseEntity.ok(orders);
    }

    @GetMapping(value = "{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(orders.get(0));
    }

    @DeleteMapping(value = "{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<OrderDto> updateOrder(@RequestBody OrderDto orderDto) {
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createOrder(@RequestBody OrderDto orderDto) {
        return ResponseEntity.ok().build();
    }
}
