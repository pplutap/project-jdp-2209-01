package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestProductDto {

    private Long id;
    private Double quantity;
    private Product product;
}
