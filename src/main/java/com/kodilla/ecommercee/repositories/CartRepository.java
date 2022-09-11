package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.RequestProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

    @Override
    List<Cart> findAll();

    Optional<Cart> findCartByRequestProduct_Id(Long id);

    Optional<Cart> deleteCartByRequestProduct_Id(Long id);
}
