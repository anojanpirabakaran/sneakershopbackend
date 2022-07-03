package com.example.sneakerShop.reservation;

import java.util.List;

/**
 * The Service Interface for the Reservation.
 */
public interface ReservationService {

    Reservation findById(Long id);

    Reservation saveReservation(Reservation reservation);

    String deleteReservation(Long id) throws Exception;

    List<Reservation> getAll();

    String updateReservation(Long id, Reservation reservation);
}
