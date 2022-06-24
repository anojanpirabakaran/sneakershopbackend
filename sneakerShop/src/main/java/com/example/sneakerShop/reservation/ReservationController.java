package com.example.sneakerShop.reservation;

import com.example.sneakerShop.client.ClientDTO;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("http://localhost:3000")
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<Reservation> findById(@PathVariable Long id) {
        Reservation reservation = reservationService.findById(id);
        return new ResponseEntity<>(reservation, HttpStatus.FOUND);
    }

    @GetMapping({"", "/"})
    public ResponseEntity<Collection<Reservation>> findAll() {
        List<Reservation> clients = reservationService.getAll();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @DeleteMapping({"/{id}/", "/{id}"})
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping({"/", ""})
    public ResponseEntity<Reservation> create(@RequestBody Reservation reservation)
            throws Exception {
        Reservation reservation1 = reservationService.saveReservation(reservation);
        return new ResponseEntity<>(reservation1, HttpStatus.CREATED);
    }

    @PutMapping({"/{id}", "/{id}/"})
    public ResponseEntity<ClientDTO> updateById(@PathVariable Long id,
                                                @RequestBody Reservation reservation)
            throws Exception {
        reservationService.updateReservation(id, reservation);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
