package com.example.sneakerShop.reservation;


import java.util.List;

public interface ReservationService {

    Reservation findById(Long id);

    Reservation findByName(String name);

    Reservation saveReservation(Reservation reservation);

    String deleteReservation(Long id);

    List<Reservation> getAll();

    String updateReservation(Long id, Reservation reservation);
}
