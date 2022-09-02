package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "USERS")
public class User {

    @NotNull
    @Id
    @GeneratedValue
    @Column(name = "USER_ID", unique = true)
    private Long id;

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "USER_STATUS")
    private String status;

    @Column(name = "USER_KEY")
    private long userKey;

    @Column(name = "LOGIN_INFO")
    private Login loginInfo;

    @OneToOne
    @JoinColumn(name = "USER_CART")
    private Cart cart;

    @OneToMany
    private List<Order> orders;
}