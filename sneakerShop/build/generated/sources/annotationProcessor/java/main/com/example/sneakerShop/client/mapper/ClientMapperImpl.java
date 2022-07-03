package com.example.sneakerShop.client.mapper;

import com.example.sneakerShop.client.Client;
import com.example.sneakerShop.client.ClientDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-03T22:03:18+0200",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 11 (Oracle Corporation)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client fromDTO(ClientDTO clientDTO) {
        if ( clientDTO == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( clientDTO.getId() );
        client.setLastName( clientDTO.getLastName() );
        client.setFirstName( clientDTO.getFirstName() );
        client.setEmail( clientDTO.getEmail() );
        client.setPassword( clientDTO.getPassword() );

        return client;
    }

    @Override
    public List<Client> fromDTOs(List<ClientDTO> clientDTOS) {
        if ( clientDTOS == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( clientDTOS.size() );
        for ( ClientDTO clientDTO : clientDTOS ) {
            list.add( fromDTO( clientDTO ) );
        }

        return list;
    }

    @Override
    public ClientDTO toDTO(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId( client.getId() );
        clientDTO.setLastName( client.getLastName() );
        clientDTO.setFirstName( client.getFirstName() );
        clientDTO.setEmail( client.getEmail() );
        clientDTO.setPassword( client.getPassword() );

        return clientDTO;
    }

    @Override
    public List<ClientDTO> toDTOs(List<Client> clients) {
        if ( clients == null ) {
            return null;
        }

        List<ClientDTO> list = new ArrayList<ClientDTO>( clients.size() );
        for ( Client client : clients ) {
            list.add( toDTO( client ) );
        }

        return list;
    }
}
