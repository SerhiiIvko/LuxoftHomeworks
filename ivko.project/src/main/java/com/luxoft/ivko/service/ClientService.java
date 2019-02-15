package com.luxoft.ivko.service;

import com.luxoft.ivko.domain.Client;

public interface ClientService {

    //TODO javadocs for methods

    Client createClient(String name, String surname, String phone);
    void modifyClient(Client client, String name, String surname, String phone);
    void deleteClient(Client client);


}