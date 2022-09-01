package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domain.ProductRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRequestRepository extends CrudRepository<ProductRequest, Long> {
}
