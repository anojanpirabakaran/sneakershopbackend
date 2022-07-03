package com.example.sneakerShop.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for the Client.
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByEmail(String email);


}
