package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    @JoinTable(name = "JOIN_CART_PRODUCT_REQUEST",
            joinColumns = {@JoinColumn(name = "PRODUCT_REQUEST_ID", referencedColumnName = "PRODUCT_REQUEST_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "CART_ID")})
    private List<Cart> carts = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "JOIN_ORDER_PRODUCT_REQUEST",
            joinColumns = {@JoinColumn(name = "PRODUCT_REQUEST_ID", referencedColumnName = "PRODUCT_REQUEST_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")})
    private List<Order> orders = new ArrayList<>();
}
