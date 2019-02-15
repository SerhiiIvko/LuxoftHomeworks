package com.luxoft.ivko.service.impl;

import com.luxoft.ivko.appProperties.*;
import com.luxoft.ivko.dao.ClientDao;
import com.luxoft.ivko.dao.impl.ClientDaoImpl;
import com.luxoft.ivko.domain.Client;
import com.luxoft.ivko.service.ClientService;

import java.math.BigDecimal;
import java.util.List;

public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao = new ClientDaoImpl();

    @Override
    public Client createClient(String name, String surname, String phone) {
        Client client = new Client(name, surname, phone);
        boolean res = clientDao.saveClient(client);
        if (res) {
            System.out.println("Client created successfully! " + client.toString());
        }
        return client;
    }

    @Override
    public void modifyClient(Client client, String name, String surname, String phone) {
        client.setName(name);
        client.setSurname(surname);
        client.setPhone(phone);
        boolean res = clientDao.modifyClientCredentials(client);
        if (res){
            System.out.println("Client modified successfully! " + client.toString());
        }
    }

    @Override
    public void deleteClient(BigDecimal id) {
        ConsoleOutputContainer.printMessage("Client deleted");
    }

    @Override
    public void showAllClients(){
        List<Client> clients= clientDao.getAllClients();
        clients.forEach(System.out::println);
    }
}