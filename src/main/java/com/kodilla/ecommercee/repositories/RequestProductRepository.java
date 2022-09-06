package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domain.RequestProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestProductRepository extends CrudRepository<RequestProduct, Long> {
}
