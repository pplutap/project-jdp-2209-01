package com.kodilla.ecommercee.services;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.exceptions.OrderNotFoundException;
import com.kodilla.ecommercee.mappers.OrderMapper;
import com.kodilla.ecommercee.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<OrderDto> getAllOrders () {
        return orderRepository.findAll().stream()
                .map(OrderMapper::mapToOrderDto)
                .collect(Collectors.toList());
    }

    public OrderDto getOrderById (Long id) throws OrderNotFoundException {
        Order order = orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
        return OrderMapper.mapToOrderDto(order);
    }

    public OrderDto createOrder (OrderDto orderDto) {
        Order newOrder = orderRepository.save(OrderMapper.mapToOrder(orderDto));
        return OrderMapper.mapToOrderDto(newOrder);
    }

    public OrderDto updateOrder (OrderDto orderDto) throws OrderNotFoundException {
        if(!orderRepository.existsById(orderDto.getId()))
            throw new OrderNotFoundException();
        Order updatedOrder = orderRepository.save(OrderMapper.mapToOrder(orderDto));
        return OrderMapper.mapToOrderDto(updatedOrder);
    }

    public void deleteOrder (OrderDto orderDto) throws OrderNotFoundException {
        if(!orderRepository.existsById(orderDto.getId()))
            throw new OrderNotFoundException();
        orderRepository.deleteById(orderDto.getId());
    }


}
