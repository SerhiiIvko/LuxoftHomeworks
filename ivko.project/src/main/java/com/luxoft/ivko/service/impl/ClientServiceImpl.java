package com.luxoft.ivko.service.impl;

import com.luxoft.ivko.appProperties.*;
import com.luxoft.ivko.dao.ClientDao;
import com.luxoft.ivko.dao.impl.ClientDaoImpl;
import com.luxoft.ivko.domain.Client;
import com.luxoft.ivko.exception.ValidationException;
import com.luxoft.ivko.service.ClientService;
import com.luxoft.ivko.validator.ClientValidatorService;
import com.luxoft.ivko.validator.impl.ClientValidatorServiceImpl;

import java.math.BigDecimal;
import java.util.List;

public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao = new ClientDaoImpl();
    private ClientValidatorService validator = new ClientValidatorServiceImpl();

    @Override
    public Client createClient(String name, String surname, String email, String password, String phone, int age) {
        if (!validator.validateNewClientCredentials(name, surname, email, password, phone, age)) {
            throw new ValidationException(ConstantsContainer.VALIDATION_EXCEPTION_MESSAGE);
        } else {
            Client client = new Client(name, surname, phone);
            boolean res = clientDao.saveClient(client);
            if (res) {
                System.out.println("Client created successfully! " + client.toString());
            }
            return client;
        }
    }

    @Override
    public void modifyClient(Client client, String name, String surname, String phone) {
        client.setName(name);
        client.setSurname(surname);
        client.setPhone(phone);
        boolean res = clientDao.modifyClientCredentials(client);
        if (res) {
            System.out.println("Client modified successfully! " + client.toString());
        }
    }

    @Override
    public void deleteClient(BigDecimal id) {
        ConstantsContainer.printMessage("Client deleted");
    }

    @Override
    public void showAllClients() {
        List<Client> clients = clientDao.getAllClients();
        clients.forEach(System.out::println);
    }
}