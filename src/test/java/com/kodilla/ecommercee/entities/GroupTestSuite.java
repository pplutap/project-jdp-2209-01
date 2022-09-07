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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class GroupTestSuite {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    ProductRepository productRepository;

    @Test
    void shouldSaveGroupEntity(){
        //given
        Group group =  new Group(1L,"Test group");

        //when
        boolean preTest = groupRepository.existsById(1L);
        Long id = groupRepository.save(group).getId();
        boolean postTest = groupRepository.existsById(id);


        //then
        assertEquals(false, preTest);
        assertEquals(true, postTest);

        //cleanup
        groupRepository.delete(group);

    }




    @Test
    void shouldNotDelete(){
        //given
        Group group = groupRepository.save(new Group(1L,"Test group"));
        Product product =  productRepository.save(new Product(1L,
                                                "Test product",
                                            "super",
                                                      new BigDecimal(5),
                                                      group,
                                                1 ));

        //when
        int rowsAffected = groupRepository.safeDelete(group.getId());

        //then
        assertEquals(0, rowsAffected);

        //cleanup
        productRepository.deleteAll();
        groupRepository.deleteAll();

    }



}
