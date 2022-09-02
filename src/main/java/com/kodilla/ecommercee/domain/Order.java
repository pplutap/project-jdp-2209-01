package com.kodilla.ecommercee.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "ORDERS")
public class Order {

    @NotNull
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
    @Column(name = "DATE")
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne
    @JoinColumn(name = "REQUEST_PRODUCT_ID")
    private RequestProduct requestProduct;
}

