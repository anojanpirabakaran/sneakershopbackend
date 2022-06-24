package com.example.sneakerShop.sneaker;

import java.util.Collection;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sneakers")
@CrossOrigin("http://localhost:3000")
public class SneakerController {

    private final SneakerService sneakerService;

    public SneakerController(SneakerService sneakerService) {
        this.sneakerService = sneakerService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<Collection<Sneaker>> findAll() {
        List<Sneaker> sneakers = sneakerService.getAll();
        return new ResponseEntity<>(sneakers, HttpStatus.OK);
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<Sneaker> findById(@PathVariable Long id) {
        Sneaker sneaker = sneakerService.findById(id);
        return new ResponseEntity<>(sneaker, HttpStatus.FOUND);
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        sneakerService.deleteSneaker(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping({"/", ""})
    public ResponseEntity<Sneaker> create(@RequestBody Sneaker sneaker)
            throws Exception {
        Sneaker sneaker1 = sneakerService.saveSneaker(sneaker);
        return new ResponseEntity<>(sneaker1, HttpStatus.CREATED);
    }

    @PutMapping({"/{id}", "/{id}/"})
    public ResponseEntity<Sneaker> updateById(@PathVariable Long id, @RequestBody Sneaker sneaker)
            throws Exception {
        sneakerService.updateSneaker(id, sneaker);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
