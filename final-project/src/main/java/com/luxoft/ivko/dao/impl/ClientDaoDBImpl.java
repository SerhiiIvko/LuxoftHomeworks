package com.luxoft.ivko.dao.impl;

import com.luxoft.ivko.appProperties.ConstantsContainer;
import com.luxoft.ivko.dao.ClientDao;
import com.luxoft.ivko.model.Client;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ClientDaoDBImpl implements ClientDao {

    @PersistenceContext
    private EntityManager entityManager;

    public ClientDaoDBImpl() {
    }

    @Override
    public Client getClientById(Long id) {
        TypedQuery<Client> query = entityManager.createQuery(ConstantsContainer.CLIENT_BY_ID, Client.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void saveClient(Client entity) {
        entityManager.persist(entity);
    }

    @Override
    public Client modifyClientCredentials(Client entity) {
        return entityManager.merge(entity);
    }

    @Override
    public List<Client> getAllClients() {
        TypedQuery<Client> query = entityManager.createQuery(ConstantsContainer.CLIENTS_AS_LIST, Client.class);
        return query.getResultList();
    }

    @Override
    public void removeClient(Long id) {
        Client entity = entityManager.getReference(Client.class, id);
        entityManager.remove(entity);
    }
}
