package com.luxoft.ivko.service;

import com.luxoft.ivko.web.dto.ClientCreateDto;
import com.luxoft.ivko.web.dto.ClientViewDto;

import java.util.List;

public interface ClientService {

//    /**
//     * Create new client in Service
//     *
//     * @param client    client for creation
//     */
//    void createClient(Client client);
//
//    /**
//     * Modify client parameters
//     *
//     * @param client      client for modifying parameters
//     * @param newName     new name for replace old name
//     * @param newSurname  new surname for replace old surname
//     * @param newEmail    new email for replace old email
//     * @param newPassword new password for replace old password
//     * @param newPhone    new phone number for replace old phone number
//     * @param newAge      new age for replace old age
//     */
//    void modifyClient(Client client, String newName, String newSurname, String newEmail, String newPassword, String newPhone, String newAge);
//
//    /**
//     * Delete client
//     *
//     * @param id client's id for correctly deleting
//     */
//    void deleteClient(Long id);
//
//    /**
//     * Delete client
//     * <p>
//     * gel all clients from storage
//     */
//    void showAllClients();

    ClientViewDto registerClient(ClientCreateDto createDto);

    List<ClientViewDto> getAllClients();

    ClientViewDto getClientById(long id);

    ClientViewDto updateClient(ClientCreateDto createDto);

        void updateClients(List<ClientCreateDto> createDtoList);
    void deleteClient(ClientCreateDto createDto);
}
