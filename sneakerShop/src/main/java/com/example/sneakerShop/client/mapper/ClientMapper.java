package com.example.sneakerShop.client.mapper;

import com.example.sneakerShop.client.Client;
import com.example.sneakerShop.client.ClientDTO;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client fromDTO(ClientDTO clientDTO);

    List<Client> fromDTOs(List<ClientDTO> clientDTOS);

    ClientDTO toDTO(Client client);

    List<ClientDTO> toDTOs(List<Client> clients);
}
