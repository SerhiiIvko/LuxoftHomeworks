package com.luxoft.ivko.dao.impl;

import com.luxoft.ivko.dao.ClientDao;
import com.luxoft.ivko.domain.Client;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class ClientDaoImpl implements ClientDao {
    private Map<BigDecimal, Client> clients = new HashMap<>();
    private static BigDecimal generator = new BigDecimal(0);

    @Override
    public boolean saveClient(Client client) {
        generator = generator.add(new BigDecimal(1));
        client.setId(generator);
        clients.put(generator, client);
        return clients.containsKey(generator);
    }

    @Override
    public boolean modifyClientCredentials(Client client) {

        return true;
    }

    @Override
    public Client getClientById(BigDecimal id) {
        return null;
    }

    @Override
    public Client getClientByEmail(String email) {
        return null;
    }

    @Override
    public List<Client> getAllClients() {
        return clients.values().stream().collect(Collectors.toList());
    }

    @Override
    public boolean removeClient(BigDecimal id) {
        System.out.println("Client was removed");
        return true;
    }
}