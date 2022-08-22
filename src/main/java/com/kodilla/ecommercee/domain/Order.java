package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String comment;

    @Column(name = "payment_status")
    private boolean isPaid;

    @CreationTimestamp
    private Date creationDate;

//    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "orders")
//    public List<Product> getProducts() {
//        List<Product> products = new ArrayList<>();
//        return products;
//    }
}
