package com.kodilla.ecommercee.mappers;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;

public class UserMapper {

    public static UserDto mapToDto(User user){
        return new UserDto(user.getId(),
                user.getName(),
                user.getStatus(),
                user.getUserKey(),
                user.getLoginInfo(),
                user.getCart(),
                user.getOrders());

    }

    public static User mapToUser(UserDto userDto){
        return new User(userDto.getId(),
                userDto.getName(),
                userDto.getStatus(),
                userDto.getUserKey(),
                userDto.getLoginInfo(),
                userDto.getCart(),
                userDto.getOrders());
    }
}