package com.example.sneakerShop.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Repository for the Reservation.
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
