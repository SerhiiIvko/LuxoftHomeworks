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
import com.luxoft.ivko.web.dto.ClientCreateDto;
import com.luxoft.ivko.web.dto.ClientViewDto;

import java.util.List;

public class ClientServiceImpl implements ClientService {
    @Override
    public ClientViewDto registerClient(ClientCreateDto createDto) {
        return null;
    }

    @Override
    public List<ClientViewDto> getAllClients() {
        return null;
    }

    @Override
    public ClientViewDto getClientById(long id) {
        return null;
    }

    @Override
    public ClientViewDto updateClient(ClientCreateDto createDto) {
        return null;
    }

    @Override
    public void updateClients(List<ClientCreateDto> createDtoList) {

    }

    @Override
    public void deleteClient(ClientCreateDto createDto) {

    }

//    private ClientDao clientDao = new ClientDaoDBImpl();
//    private ClientValidatorService validator = new ClientValidatorServiceImpl();
//
//    @Override
//    public void createClient(Client client) {
//        if (!(validator.validateName(client.getName())
//                || validator.validateSurname(client.getSurname())
//                || validator.validateEmail(client.getEmail())
//                || validator.validatePassword(client.getPassword())
//                || validator.validatePhone(client.getPhone())
//                || validator.validateAge(client.getAge()))) {
//            throw new ValidationException(ConstantsContainer.VALIDATION_EXCEPTION_MESSAGE);
//        } else {
//            clientDao.saveClient(client);
//        }
//    }
//
//    @Override
//    public void modifyClient(Client client, String name, String surname, String email, String password, String phone, String age) {
//        if (!(validator.validateName(name)
//                || validator.validateSurname(surname)
//                || validator.validateEmail(email)
//                || validator.validatePassword(password)
//                || validator.validatePhone(phone)
//                || validator.validateAge(age))) {
//            throw new ValidationException(ConstantsContainer.VALIDATION_EXCEPTION_MESSAGE);
//        } else {
//            client.setName(name);
//            client.setSurname(surname);
//            client.setPhone(phone);
//        }
//    }
//
//    @Override
//    public void deleteClient(Long id) {
//        clientDao.removeClient(id);
//        AppUtilMethods.printMessage("Client deleted");
//    }
//
//    @Override
//    public void showAllClients() {
//        List<Client> clients = clientDao.getAllClients();
//        if (clients.size() == 0) {
//            AppUtilMethods.printMessage(ConstantsContainer.EMPTY_LIST_EXCEPTION_MESSAGE);
//        } else {
//            clients.forEach(System.out::println);
//        }
//    }
}
