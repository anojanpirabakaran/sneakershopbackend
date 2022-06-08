package com.example.sneakerShop.sneaker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SneakerRepository extends JpaRepository<Sneaker, Long> {

    Sneaker findByName(String name);
}
