package com.kodilla.ecommercee.domain;

public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long groupId;

    public ProductDto(Long id, String name, String description, Double price, Long groupId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.groupId = groupId;
    }
}
