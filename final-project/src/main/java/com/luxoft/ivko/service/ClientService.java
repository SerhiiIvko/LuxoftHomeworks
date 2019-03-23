package com.luxoft.ivko.service;

import com.luxoft.ivko.web.dto.ClientCreateDto;
import com.luxoft.ivko.web.dto.ClientViewDto;

import java.util.List;

public interface ClientService {

    /**
     * Register new client in Service
     *
     * @param createDto object ClientCreateDto for creation
     */
    ClientViewDto registerClient(ClientCreateDto createDto);

    /**
     * Get all clients
     * <p>
     * return all clients from storage
     */
    List<ClientViewDto> getAllClients();

    /**
     * Get client by id
     *
     * @param id client's id for return from storage
     */
    ClientViewDto getClientById(long id);

    /**
     * Modify client parameters
     *
     * @param createDto object ClientCreateDto for modifying parameters
     */
    ClientViewDto updateClient(ClientCreateDto createDto);

    /**
     * Update all clients
     * <p>
     * return all clients from storage for transfer it's on view
     */
    void updateClients(List<ClientCreateDto> createDtoList);

    /**
     * Delete client
     *
     * @param createDto object ClientCreateDto for correctly deleting
     */
    void deleteClient(ClientCreateDto createDto);
}
