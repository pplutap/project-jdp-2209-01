package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String title;

    @Column(name = "description")
    private String content;

    @Column(name = "payment_status")
    private boolean isPaid;

    @Column(name = "date")
    public Date getOrderDate() {
        Date dateTime = new Date();
        return dateTime;
    }

//    TO DO: connect to Product
//    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "orders")
//    public List<Product> getProducts() {
//        List<Product> products = new ArrayList<>();
//        return products;
//    }

//    TO DO: connect to Cart
//    @OneToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "CART_ID")
//    public Cart getCart() {
//        return cart;
//    }
}
