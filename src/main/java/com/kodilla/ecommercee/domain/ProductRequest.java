package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PRODUCT_REQUESTS")
public class ProductRequest {

    @NotNull
    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_REQUEST_ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "QUANTITY")
    private Double quantity;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @OneToOne
    @JoinColumn(name = "CART_ID")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;
}
