package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserDto {

    private long id;
    private String name;
    private String status;
    private long userKey;
    private Login loginInfo;
    private Cart cart;
    private List<Order> orders;

}