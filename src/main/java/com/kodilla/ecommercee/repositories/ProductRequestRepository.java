package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domain.ProductRequest;
import org.springframework.data.repository.CrudRepository;

public interface ProductRequestRepository extends CrudRepository<ProductRequest, Long> {
}
