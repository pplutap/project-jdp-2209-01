package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findAllById(Long id);
    List<Product> findAll();
    void deleteById(Long id);

}
