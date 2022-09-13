package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private String title;
    private String content;
    private boolean isPaid;
    private Status status;
    private Date creationDate;
    private User user;
    private RequestProduct requestProduct;
}
