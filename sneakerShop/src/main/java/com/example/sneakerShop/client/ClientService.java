package com.example.sneakerShop.client;

import java.util.List;

public interface ClientService {

    Client findById(Long id);

    Client createClient(Client client);

    String updateClient(Long id, Client client);

    String deleteById(Long id);

    List<Client> getAllClients();

    Client getByEmail(String email);


}
