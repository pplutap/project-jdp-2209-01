package com.kodilla.ecommercee.entities;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repositories.GroupRepository;
import com.kodilla.ecommercee.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;


@SpringBootTest
public class ProductTestSuite {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    GroupRepository groupRepository;

    @Test
    void savingProductTest () {
        //Given
        Group group = groupRepository.save(new Group(1L, "Jackets"));
        productRepository.save(new Product(1L,
                    "Jacket",
                "Nice jacket",
                           BigDecimal.valueOf(150.00),
                           group,
                    1 ));

        //When
        List<Product> productSaved = productRepository.findAll();

        //Then
        Assertions.assertEquals(1, productSaved.size());
        Assertions.assertEquals("Jackets", productSaved.get(0).getGroup().getName());

        //CleanUp
        productRepository.deleteAll();
        groupRepository.deleteAll();
    }

    @Test
    void deleteProductTest () {
        //Given
        Group group = new Group(1L,"Jackets");
        Product product = new Product(1L,"Jacket", "Nice jacket", BigDecimal.valueOf(150.00), group, 1 );

        //When
        groupRepository.save(group);
        productRepository.save(product);

        List<Product> productsBeforeDelete = productRepository.findAll();
        Long id = productsBeforeDelete.get(0).getId();

        productRepository.deleteById(id);
        List<Product> productsAfterDelete = productRepository.findAll();

        //Then
        Assertions.assertEquals(0, productsAfterDelete.size());

        //CleanUp
        productRepository.deleteAll();
        groupRepository.deleteAll();
    }

}
