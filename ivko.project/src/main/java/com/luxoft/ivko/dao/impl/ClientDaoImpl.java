package com.luxoft.ivko.dao.impl;

import com.luxoft.ivko.dao.ClientDao;
import com.luxoft.ivko.domain.Client;

import java.math.BigDecimal;
import java.util.List;

public class ClientDaoImpl implements ClientDao {

    @Override
    public boolean saveClient(Client client) {
        return false;
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
        return null;
    }
}