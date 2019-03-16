package com.luxoft.ivko.converter;

import com.luxoft.ivko.domain.Client;
import com.luxoft.ivko.web.dto.ClientCreateDto;
import com.luxoft.ivko.web.dto.ClientViewDto;

public class ClientConverter {

    public ClientViewDto asClientDto(Client client) {
        ClientViewDto dto = new ClientViewDto();
        setData(client, dto);
        return dto;
    }

    public Client asClient(ClientCreateDto createDto) {
        Client client = new Client();
        client.setId(createDto.getId());
        client.setName(createDto.getName());
        client.setSurname(createDto.getSurname());
        client.setEmail(createDto.getEmail());
        client.setPassword(createDto.getPassword());
        client.setPhone(createDto.getPhone());
        client.setAge(createDto.getAge());
        return client;
    }

    private void setData(Client client, ClientViewDto dto) {
        dto.setId(client.getId());
        dto.setName(client.getName());
        dto.setSurname(client.getSurname());
        dto.setEmail(client.getEmail());
        dto.setPhone(client.getPhone());
        dto.setAge(client.getAge());
    }
}
