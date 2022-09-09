package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "CARTS")
public class Cart {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "CART_ID", unique = true)
    private Long id;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    @NotNull
    private User user;

    @OneToOne
    @JoinColumn(name = "REQUEST_PRODUCT_ID")
    private RequestProduct requestProduct;
}
