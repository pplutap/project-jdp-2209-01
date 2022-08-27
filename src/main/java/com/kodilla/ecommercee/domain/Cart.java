package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "CARTS")
public class Cart {

    private long id;
//    private User user;
//    private List<ProductRequest> productRequestList;

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "CART_ID", unique = true)
    public long getId() {
        return id;
    }

//    @OneToOne
//    @JoinColumn(name = "USER_ID")
//    @NotNull
//    public User getUser() {
//        return user;
//    }

//    @ManyToMany
//    @JoinTable(name = "JOIN_CART_PRODUCT_REQUEST",
//    joinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "CART_ID")},
//    inverseJoinColumns = {@JoinColumn(name = "PRODUCT_REQUEST_ID", referencedColumnName = "PRODUCT_REQUEST_ID")})
//    public List<ProductRequest> getProductRequestList() {
//        return productRequestList;
//    }

    public void setId(long id) {
        this.id = id;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public void setProductRequestList(List<ProductRequest> productRequestList) {
//        this.productRequestList = productRequestList;
//    }
}
