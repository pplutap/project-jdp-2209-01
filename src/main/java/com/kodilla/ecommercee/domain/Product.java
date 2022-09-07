package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.EcommerceeApplication;
import com.kodilla.ecommercee.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PRODUCTS")
public class Product {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "PRODUCT_ID", unique = true)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    @Column(name = "VERSION")
    private Integer version;

    @PreRemove
    private void checkRelations(){



    }

}
