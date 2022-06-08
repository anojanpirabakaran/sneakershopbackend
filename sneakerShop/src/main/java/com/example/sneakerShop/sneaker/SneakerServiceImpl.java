package com.example.sneakerShop.sneaker;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class SneakerServiceImpl implements SneakerService {

    @Autowired
    private final SneakerRepository sneakerRepository;

    public SneakerServiceImpl(SneakerRepository sneakerRepository) {
        this.sneakerRepository = sneakerRepository;
    }


    @Override
    public Sneaker findById(Long id) {
        Optional<Sneaker> sneaker = sneakerRepository.findById(id);
        return sneaker.orElse(null);
    }

    @Override
    public Sneaker findByName(String name) {
        return null;
    }

    @Override
    public Sneaker saveSneaker(Sneaker sneaker) {
        return null;
    }

    @Override
    public String deleteSneaker(Long id) {
        return null;
    }

    @Override
    public List<Sneaker> getAll() {
        return null;
    }

    @Override
    public String updateSneaker(Long id, Sneaker sneaker) {
        return null;
    }
}

