package com.luxoft.ivko.service.impl;

import com.luxoft.ivko.converter.ClientConverter;
import com.luxoft.ivko.dao.ClientDao;
import com.luxoft.ivko.model.Client;
import com.luxoft.ivko.service.ClientService;
import com.luxoft.ivko.validator.ClientValidatorService;
import com.luxoft.ivko.web.dto.ClientCreateDto;
import com.luxoft.ivko.web.dto.ClientViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private ClientValidatorService validatorService;

    @Autowired
    private ClientConverter clientConverter;

    public ClientServiceImpl(){
    }

    @Override
    @Transactional
    public ClientViewDto registerClient(ClientCreateDto createDto) {
        validatorService.validateClient(createDto, true);
        Client client = clientConverter.asClient(createDto);
        clientDao.saveClient(client);
        return clientConverter.asClientDto(client);
    }

    @Override
    @Transactional
    public List<ClientViewDto> getAllClients() {
        List<Client> clients = clientDao.getAllClients();
        return clients
                .stream()
                .map(client -> clientConverter.asClientDto(client))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ClientViewDto getClientById(long id) {
        Client client = clientDao.getClientById(id);
        return clientConverter.asClientDto(client);
    }

    @Override
    @Transactional
    public ClientViewDto updateClient(ClientCreateDto createDto) {
        validatorService.validateClient(createDto, false);
        Client client = clientConverter.asClient(createDto);
        client = clientDao.modifyClientCredentials(client);
        return clientConverter.asClientDto(client);
    }

    public void updateClients(List<ClientCreateDto> createDtoList) {
        createDtoList.forEach(clientCreateDto -> validatorService.validateClient(clientCreateDto, false));
        List<Client> clients = createDtoList
                .stream()
                .map(clientCreateDto -> clientConverter.asClient(clientCreateDto))
                .collect(Collectors.toList());
//        clientDao.update(clients);
    }

    @Override
    public void deleteClient(ClientCreateDto createDto) {
        Client client = clientConverter.asClient(createDto);
        clientDao.removeClient(client.getId());
    }
}
