package com.luxoft.ivko.service.impl;

import com.luxoft.ivko.converter.ClientConverter;
import com.luxoft.ivko.dao.ClientDao;
import com.luxoft.ivko.dao.impl.ClientDaoDBImpl;
import com.luxoft.ivko.domain.Client;
import com.luxoft.ivko.service.ClientService;
import com.luxoft.ivko.validator.ClientValidatorService;
import com.luxoft.ivko.validator.impl.ClientValidatorServiceImpl;
import com.luxoft.ivko.web.dto.ClientCreateDto;
import com.luxoft.ivko.web.dto.ClientViewDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao = new ClientDaoDBImpl();
    private ClientValidatorService validatorService = new ClientValidatorServiceImpl();
    private ClientConverter clientConverter = new ClientConverter();

    @Override
    public ClientViewDto registerClient(ClientCreateDto createDto) {
        validatorService.validateClient(createDto, true);
        Client client = clientConverter.asClient(createDto);
        client = clientDao.saveClient(client);
        return clientConverter.asClientDto(client);
    }

    @Override
    public List<ClientViewDto> getAllClients() {
        List<Client> clients = clientDao.getAllClients();
        return clients
                .stream()
                .map(client -> clientConverter.asClientDto(client))
                .collect(Collectors.toList());
    }

    @Override
    public ClientViewDto getClientById(long id) {
        Client client = clientDao.getClientById(id);
        return clientConverter.asClientDto(client);
    }

    @Override
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
        clientDao.update(clients);
    }

    @Override
    public void deleteClient(ClientCreateDto createDto) {
        Client client = clientConverter.asClient(createDto);
        clientDao.removeClient(client.getId());
    }
}
