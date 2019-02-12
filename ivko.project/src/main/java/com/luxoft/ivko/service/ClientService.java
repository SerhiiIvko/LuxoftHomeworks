package com.luxoft.ivko.service;

import com.luxoft.ivko.domain.Client;

public interface ClientService {

    //TODO javadocs for methods

    void createClient(String name, String surname, String phone);
    void deleteClient(Client client);


}