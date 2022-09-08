package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domain.Group;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM GROUP_ENTITY g WHERE " +
            "((SELECT COUNT(p) FROM PRODUCTS p WHERE p.group.id=:id) = 0) " +
            "AND (g.id =:id) ")
    int safeDelete(@Param("id") Long id);
}

