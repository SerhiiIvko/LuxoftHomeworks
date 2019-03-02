package com.luxoft.ivko.dao;

import com.luxoft.ivko.domain.Client;

import java.math.BigDecimal;
import java.util.List;

public interface ClientDao {

    /**
     * Save client into storage
     *
     * @param client object client for saving as a data access object
     */
    boolean saveClient(Client client);

    /**
     * Modify client credentials and update credentials in storage
     *
     * @param client object client for modifying as a data access object
     */
    boolean modifyClientCredentials(Client client);

    /**
     * Get client from storage by id
     *
     * @param id client as object from storage
     */
    Client getClientById(Long id);

    /**
     * Get all clients from storage
     */
    List<Client> getAllClients();

    /**
     * Remove client from storage by id
     *
     * @param id client's id for correctly removing
     */
    boolean removeClient(Long id);
}
