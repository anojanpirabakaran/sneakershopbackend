package com.example.sneakerShop.reservation;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation findById(Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        return reservation.orElse(null);
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public String deleteReservation(Long id) throws Exception {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
            return "Reservation deleted successfully";
        } else {
            throw new FileNotFoundException("Reservation not found");
        }
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public String updateReservation(Long id, Reservation reservation) {
        reservationRepository.findById(id)
                .map(reservation1 -> {
                    reservation1.setClient(reservation.getClient());
                    reservation1.setCount(reservation.getCount());
                    reservation1.setSneaker(reservation.getSneaker());
                    reservationRepository.save(reservation1);
                    return "Reservation got updated";
                }).orElseGet(() -> {
                    reservation.setId(id);
                    reservationRepository.save(reservation);
                    return "Reservation got inserted";
                });
        return "Reservation got updated";
    }
}
