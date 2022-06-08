package com.example.sneakerShop.sneaker;

import java.util.List;

public interface SneakerService {

    Sneaker findById(Long id);

    Sneaker findByName(String name);

    Sneaker saveSneaker(Sneaker sneaker);

    String deleteSneaker(Long id);

    List<Sneaker> getAll();

    String updateSneaker(Long id, Sneaker sneaker);


}
