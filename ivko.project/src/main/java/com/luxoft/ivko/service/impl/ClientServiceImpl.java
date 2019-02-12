package com.luxoft.ivko.service.impl;

import com.luxoft.ivko.dao.ClientDao;
import com.luxoft.ivko.dao.impl.ClientDaoImpl;
import com.luxoft.ivko.domain.Client;
import com.luxoft.ivko.service.ClientService;

public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao = new ClientDaoImpl();

    @Override
    public void createClient(String name, String surname, String phone) {
        Client client = new Client(name, surname, phone);
        boolean res = clientDao.saveClient(client);
        if (res){
            System.out.println("created successfully");
        }
    }

    @Override
    public void deleteClient(Client client) {

    }
}