package com.example.sneakerShop.client;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public Client findById(Long id) {
        if (clientRepository.existsById(id)) {
            Optional<Client> client = clientRepository.findById(id);
            return client.orElse(null);
        } else {
            throw new NoSuchElementException(String.format("User with ID '%s' not found", id));
        }
    }


    @Override
    public Client createClient(Client client) {
        if (clientRepository.findByEmail(client.getEmail()) != null) {
            throw new NoSuchElementException(
                    String.format("User with Email '%s' already exists", client.getEmail()));
        } else {
            return clientRepository.save(client);
        }
    }

    @Override
    public String updateClient(Long id, Client client) {
        clientRepository.findById(id)
                .map(client1 -> {
                    client1.setFirstName(client.getFirstName());
                    client1.setEmail(client.getEmail());
                    client1.setLastName(client.getLastName());
                    client1.setAddress(client.getAddress());
                    client1.setCardBalance(client.getCardBalance());
                    client1.setPassword(client.getPassword());
                    client1.setPlz(client.getPlz());
                    client1.setCity(client.getCity());
                    clientRepository.save(client1);
                    return "Client got updated";
                }).orElseGet(() -> {
                    client.setId(id);
                    clientRepository.save(client);
                    return "Client got inserted";
                });
        return "Group is updated";
    }

    @Override
    public String deleteById(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return "Sneaker deleted successfully";
        } else {
            throw new NoSuchElementException(String.format("Sneaker with ID '%s' not found", id));
        }
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getByEmail(String email) {
        return clientRepository.findByEmail(email);
    }
}
