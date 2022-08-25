package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID", unique = true)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "PAYMENT")
    private boolean isPaid;

    @NotNull
    @Column(name = "STATUS")
    private Status status;

    @NotNull
    @CreationTimestamp
    private Date creationDate;

//
//    @ManyToOne
//    @JoinColumn(name = "USER_ID")
//    private User user;

//    @ManyToMany
//    @JoinTable(
//            name= "JOIN_ORDERS_PRODUCTS",
//            joinColumns = {@JoinColumn (name = "ORDER_ID", referencedColumnName = "ORDER_ID")},
//            inverseJoinColumns = {@JoinColumn (name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")}
//    )
//    private List<ProductRequest> productRequest = new ArrayList<>();
}

