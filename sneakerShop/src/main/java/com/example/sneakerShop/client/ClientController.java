package com.example.sneakerShop.client;

import com.example.sneakerShop.client.mapper.ClientMapper;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
@CrossOrigin("http://localhost:3000")
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @Autowired
    public ClientController(ClientService clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<Collection<ClientDTO>> findAll() {
        List<Client> clients = clientService.getAllClients();
        return new ResponseEntity<>(clientMapper.toDTOs(clients), HttpStatus.OK);
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
        Client client = clientService.findById(id);
        return new ResponseEntity<>(clientMapper.toDTO(client), HttpStatus.FOUND);
    }

    @DeleteMapping({"/{id}/", "/{id}"})
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        clientService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping({"/", ""})
    public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO clientDTO)
            throws Exception {
        Client client = clientService.createClient(clientMapper.fromDTO(clientDTO));
        return new ResponseEntity<>(clientMapper.toDTO(client), HttpStatus.CREATED);
    }

    @PutMapping({"/{id}", "/{id}/"})
    public ResponseEntity<ClientDTO> updateById(@PathVariable Long id,
                                                @RequestBody ClientDTO clientDTO)
            throws Exception {
        Client client = clientMapper.fromDTO(clientDTO);
        clientService.updateClient(id, client);
        return new ResponseEntity<>(clientMapper.toDTO(client), HttpStatus.OK);
    }

    @GetMapping({"/{email}", "/{email}/"})
    public ResponseEntity<ClientDTO> findByEmail(@PathVariable String email) {
        Client client = clientService.getByEmail(email);
        return new ResponseEntity<>(clientMapper.toDTO(client), HttpStatus.FOUND);
    }

}
