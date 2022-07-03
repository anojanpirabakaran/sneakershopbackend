package com.example.sneakerShop.reservation;

import com.example.sneakerShop.client.ClientService;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The implementation of the interface {@link ReservationService}
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    /**
     * the repository used to execute the CRUD actions
     */
    @Autowired
    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    /**
     * find reservation by id
     *
     * @param id id from reservation
     * @return reservation, which has the given id
     */
    @Override
    public Reservation findById(Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        return reservation.orElse(null);
    }

    /**
     * create reservation
     *
     * @param reservation the reservation
     * @return the new reservation
     */
    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    /**
     * delete reservation by id
     *
     * @param id the chosen reservation id
     * @return String, which confirms action
     */
    @Override
    public String deleteReservation(Long id) throws Exception {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
            return "Reservation deleted successfully";
        } else {
            throw new FileNotFoundException("Reservation not found");
        }
    }

    /**
     * get all reservation from the db
     *
     * @return all reservation from db
     */
    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    /**
     * update reservation by reservation
     *
     * @param id          the chosen reservation id
     * @param reservation the reservation
     * @return the updated reservation
     */
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
