package com.luxoft.ivko.dao;

import com.luxoft.ivko.domain.Client;

import java.math.BigDecimal;
import java.util.List;

public interface ClientDao {
    boolean saveClient(Client client);
    Client getClientById(BigDecimal id);
    Client getClientByEmail(String email);
    List<Client> getAllClients();
}