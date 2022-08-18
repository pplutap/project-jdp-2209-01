package com.kodilla.ecommercee;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    @GetMapping
    public ResponseEntity<String> getAllOrders() {
        return ResponseEntity.ok("Return list of orders");
    }

    @GetMapping(value = "{orderId}")
    public ResponseEntity<String> getOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok("Return order ID: " + orderId);
    }

    @DeleteMapping(value = "{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok("Delete order: " + orderId);
    }

    @PutMapping
    public ResponseEntity<String> updateOrder(@RequestBody String order) {
        return ResponseEntity.ok("Update order: " + order);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createOrder(@RequestBody String order) {
        return ResponseEntity.ok("Create new order: " + order);
    }
}
