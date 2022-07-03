package com.example.sneakerShop.sneaker;

import java.util.Collection;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for the Sneaker.
 */
@Controller
@RequestMapping("/sneakers")
@CrossOrigin("http://localhost:3000")
public class SneakerController {

    private final SneakerService sneakerService;

    public SneakerController(SneakerService sneakerService) {
        this.sneakerService = sneakerService;
    }

    /**
     * get all Sneaker
     *
     * @return all Sneaker from db, HttpStatus 200
     */
    @GetMapping({"", "/"})
    public ResponseEntity<Collection<Sneaker>> findAll() {
        List<Sneaker> sneakers = sneakerService.getAll();
        return new ResponseEntity<>(sneakers, HttpStatus.OK);
    }

    /**
     * find Sneaker by id
     *
     * @param id id  id from Sneaker
     * @return Sneaker, which has the given id, HttpStatus 302
     */
    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<Sneaker> findById(@PathVariable Long id) {
        Sneaker sneaker = sneakerService.findById(id);
        return new ResponseEntity<>(sneaker, HttpStatus.FOUND);
    }

    /**
     * delete Sneaker by id
     *
     * @param id the chosen Sneaker id
     * @return Httpstatus 204
     */
    @DeleteMapping({"/{id}", "/{id}/"})
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        sneakerService.deleteSneaker(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * create Sneaker by Sneaker
     *
     * @param sneaker the Sneaker
     * @return the new Sneaker, HttpStatus 201
     */
    @PostMapping({"/", ""})
    public ResponseEntity<Sneaker> create(@RequestBody Sneaker sneaker)
            throws Exception {
        Sneaker sneaker1 = sneakerService.saveSneaker(sneaker);
        return new ResponseEntity<>(sneaker1, HttpStatus.CREATED);
    }

    /**
     * update sneaker by sneaker
     *
     * @param id the chosen sneaker id
     * @param sneaker the sneaker
     * @return the updated sneaker, HttpStatus 200
     */
    @PutMapping({"/{id}", "/{id}/"})
    public ResponseEntity<Sneaker> updateById(@PathVariable Long id, @RequestBody Sneaker sneaker)
            throws Exception {
        sneakerService.updateSneaker(id, sneaker);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
