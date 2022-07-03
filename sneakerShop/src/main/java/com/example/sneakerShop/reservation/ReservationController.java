package com.example.sneakerShop.reservation;

import com.example.sneakerShop.client.ClientDTO;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for the Reservation.
 */
@Controller
@CrossOrigin("http://localhost:3000")
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /**
     * find reservation by id
     *
     * @param id id  id from reservation
     * @return reservation, which has the given id, HttpStatus 302
     */
    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<Reservation> findById(@PathVariable Long id) {
        Reservation reservation = reservationService.findById(id);
        return new ResponseEntity<>(reservation, HttpStatus.FOUND);
    }

    /**
     * get all reservations
     *
     * @return all reservations from db, HttpStatus 200
     */
    @GetMapping({"", "/"})
    public ResponseEntity<Collection<Reservation>> findAll() {
        List<Reservation> reservations = reservationService.getAll();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    /**
     * delete reservation by id
     *
     * @param id the chosen reservation id
     * @return Httpstatus 204
     */
    @DeleteMapping({"/{id}/", "/{id}"})
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * create reservation by reservation
     *
     * @param reservation the reservation
     * @return the new reservation, HttpStatus 201
     */
    @PostMapping({"/", ""})
    public ResponseEntity<Reservation> create(@RequestBody Reservation reservation)
            throws Exception {
        Reservation reservation1 = reservationService.saveReservation(reservation);
        return new ResponseEntity<>(reservation1, HttpStatus.CREATED);
    }

    /**
     * update reservation by reservation
     *
     * @param id          the chosen reservation id
     * @param reservation the reservation
     * @return the updated reservation, HttpStatus 200
     */
    @PutMapping({"/{id}", "/{id}/"})
    public ResponseEntity<ClientDTO> updateById(@PathVariable Long id,
                                                @RequestBody Reservation reservation)
            throws Exception {
        reservationService.updateReservation(id, reservation);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
