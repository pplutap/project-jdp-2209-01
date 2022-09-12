//package com.kodilla.ecommercee.mapper;
//
//import com.kodilla.ecommercee.domain.Order;
//import com.kodilla.ecommercee.domain.OrderDto;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class OrderMapper {
//
//    public Order mapToOrder(final OrderDto orderDto) {
//        return new Order(
//                orderDto.getId(),
//                orderDto.getTitle(),
//                orderDto.getContent()
//        );
//    }
//
//    public OrderDto mapToOrderDto(final Order order) {
//        return new OrderDto(
//                order.getId(),
//                order.getTitle(),
//                order.getContent()
//        );
//    }
//
//    public List<OrderDto> mapToTaskDtoList(final List<Order> orderList) {
//        return orderList.stream()
//                .map(this::mapToOrderDto)
//                .collect(Collectors.toList());
//    }
//}
