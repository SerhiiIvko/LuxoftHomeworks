package com.luxoft.ivko.service.impl;

import com.luxoft.ivko.appProperties.AppUtilMethods;
import com.luxoft.ivko.appProperties.ConstantsContainer;
import com.luxoft.ivko.dao.ClientDao;
import com.luxoft.ivko.dao.impl.ClientDaoDBImpl;
import com.luxoft.ivko.domain.Client;
import com.luxoft.ivko.exception.ValidationException;
import com.luxoft.ivko.service.ClientService;
import com.luxoft.ivko.validator.ClientValidatorService;
import com.luxoft.ivko.validator.impl.ClientValidatorServiceImpl;

import java.util.List;

public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao = new ClientDaoDBImpl();
    private ClientValidatorService validator = new ClientValidatorServiceImpl();

    @Override
    public Client createClient(String name, String surname, String email, String password, String phone, String age) {
        if (!(validator.validateName(name)
                || validator.validateSurname(surname)
                || validator.validateEmail(email)
                || validator.validatePassword(password)
                || validator.validatePhone(phone)
                || validator.validateAge(age))) {
            throw new ValidationException(ConstantsContainer.VALIDATION_EXCEPTION_MESSAGE);
        } else {
            Client client = new Client(name, surname, email, password, phone, age);
            boolean res = clientDao.saveClient(client);
            if (res) {
                System.out.println("Client created successfully! " + client.toString());
            }
            return client;
        }
    }

    @Override
    public void modifyClient(Client client, String name, String surname, String email, String password, String phone, String age) {
        if (!(validator.validateName(name)
                || validator.validateSurname(surname)
                || validator.validateEmail(email)
                || validator.validatePassword(password)
                || validator.validatePhone(phone)
                || validator.validateAge(age))) {
            throw new ValidationException(ConstantsContainer.VALIDATION_EXCEPTION_MESSAGE);
        } else {
            client.setName(name);
            client.setSurname(surname);
            client.setPhone(phone);
//            boolean res = clientDao.modifyClientCredentials(client);
//            if (res) {
//                System.out.println("Client modified successfully! " + client.toString());
//            }
        }
    }

    @Override
    public void deleteClient(Long id) {
        clientDao.removeClient(id);
        AppUtilMethods.printMessage("Client deleted");
    }

    @Override
    public void showAllClients() {
        List<Client> clients = clientDao.getAllClients();
        if (clients.size() == 0) {
            AppUtilMethods.printMessage(ConstantsContainer.EMPTY_LIST_EXCEPTION_MESSAGE);
        } else {
            clients.forEach(System.out::println);
        }
    }
}
