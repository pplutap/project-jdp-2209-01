package com.kodilla.ecommercee.mappers;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;

public class OrderMapper {
    public static OrderDto mapToOrderDto (Order order) {
        return new OrderDto(
                order.getId(), order.getName(), order.getComment(), order.isPaid(),
                order.getStatus(), order.getCreationDate(), order.getUser(), order.getRequestProduct());
    }

    public static Order mapToOrder (OrderDto orderDto) {
        return new Order(
                orderDto.getId(), orderDto.getTitle(), orderDto.getContent(), orderDto.isPaid(),
                orderDto.getStatus(), orderDto.getCreationDate(), orderDto.getUser(), orderDto.getRequestProduct());
    }
}
