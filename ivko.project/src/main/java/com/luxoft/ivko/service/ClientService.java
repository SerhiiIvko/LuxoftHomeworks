package com.luxoft.ivko.service;

import com.luxoft.ivko.domain.Client;

import java.math.BigDecimal;

public interface ClientService {

    /**
     * Create new client in Service
     *
     * @param name    client's name
     * @param surname client's surname
     * @param phone   client's phone number
     * @return new Client
     */
    Client createClient(String name, String password, String surname, String phone, String email, int age);

    /**
     * Modify client parameters
     *
     * @param client     client for modifying parameters
     * @param newName    new name for replace old name
     * @param newSurname new surname for replace old surname
     * @param newPhone   new phone number for replace old phone number
     */
    void modifyClient(Client client, String newName, String newSurname, String newPhone);

    /**
     * Delete client
     *
     * @param id client's id for correctly deleting
     */
    void deleteClient(BigDecimal id);

    void showAllClients();
}