package com.luxoft.ivko.service.impl;

import com.luxoft.ivko.dao.ClientDao;
import com.luxoft.ivko.appProperties.ConsoleOutputContainer;
import com.luxoft.ivko.dao.impl.ClientDaoImpl;
import com.luxoft.ivko.domain.Client;
import com.luxoft.ivko.service.ClientService;

public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao = new ClientDaoImpl();

    @Override
    public Client createClient(String name, String surname, String phone) {
        Client client = new Client(name, surname, phone);
        boolean res = clientDao.saveClient(client);
        if (res){
            System.out.println("Client created successfully");
        }
        return client;
    }

    @Override
    public void modifyClient(Client client, String name, String surname, String phone){
        client.setName(name);
        client.setSurname(surname);
        client.setPhone(phone);
    }

    @Override
    public void deleteClient(Client client) {
        ConsoleOutputContainer.printMessage("Client deleted");
    }
}