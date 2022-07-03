package com.example.sneakerShop.sneaker;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The implementation of the interface {@link SneakerService}
 */
@Service
public class SneakerServiceImpl implements SneakerService {

    /**
     * the repository used to execute the CRUD actions
     */
    @Autowired
    private final SneakerRepository sneakerRepository;

    public SneakerServiceImpl(SneakerRepository sneakerRepository) {
        this.sneakerRepository = sneakerRepository;
    }

    /**
     * find sneaker by id
     *
     * @param id id from sneaker
     * @return sneaker, which has the given id
     */
    @Override
    public Sneaker findById(Long id) {
        Optional<Sneaker> sneaker = sneakerRepository.findById(id);
        return sneaker.orElse(null);
    }

    /**
     * find by sneaker name
     *
     * @param name the sneaker name
     * @return the new sneaker
     */
    @Override
    public Sneaker findByName(String name) {
        if (sneakerRepository.findByName(name) != null) {
            return sneakerRepository.findByName(name);
        } else {
            return null;
        }
    }

    /**
     * create sneaker
     *
     * @param sneaker the sneaker
     * @return the new sneaker
     */
    @Override
    public Sneaker saveSneaker(Sneaker sneaker) {
        if (sneakerRepository.findByName(sneaker.getName()) != null) {
            return null;
        } else {
            return sneakerRepository.save(sneaker);
        }
    }

    /**
     * delete sneaker by id
     *
     * @param id the chosen sneaker id
     * @return String, which confirms action
     */
    @Override
    public String deleteSneaker(Long id) {
        if (sneakerRepository.existsById(id)) {
            sneakerRepository.deleteById(id);
            return "Sneaker deleted successfully";
        } else {
            return "Sneaker not found";
        }
    }

    /**
     * get all sneaker from the db
     *
     * @return all sneaker from db
     */
    @Override
    public List<Sneaker> getAll() {
        return sneakerRepository.findAll();
    }

    /**
     * update sneaker by sneaker
     *
     * @param id      the chosen sneaker id
     * @param sneaker the sneaker
     * @return the updated sneaker
     */
    @Override
    public String updateSneaker(Long id, Sneaker sneaker) {
        sneakerRepository.findById(id)
                .map(sneaker1 -> {
                    sneaker1.setName(sneaker.getName());
                    sneaker1.setDescription(sneaker.getDescription());
                    sneaker1.setBrand(sneaker.getBrand());
                    sneaker1.setImage(sneaker.getImage());
                    sneaker1.setPrice(sneaker.getPrice());
                    sneakerRepository.save(sneaker1);
                    return "Sneaker got updated";
                }).orElseGet(() -> {
                    sneaker.setId(id);
                    sneakerRepository.save(sneaker);
                    return "Sneaker got inserted";
                });
        return "Sneaker got updated";
    }
}