package com.example.sneakerShop.sneaker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Repository for the Sneaker.
 */
@Repository
public interface SneakerRepository extends JpaRepository<Sneaker, Long> {

    Sneaker findByName(String name);
}



