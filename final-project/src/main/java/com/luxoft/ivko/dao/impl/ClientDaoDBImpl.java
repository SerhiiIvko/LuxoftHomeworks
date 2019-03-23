package com.luxoft.ivko.dao.impl;

import com.luxoft.ivko.dao.ClientDao;
import com.luxoft.ivko.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoDBImpl implements ClientDao {
    @PersistenceContext
    private EntityManager entityManager;

    public ClientDaoDBImpl() {
    }

    @Override
    public Client getClientById(Long id) {
        TypedQuery<Client> query = entityManager.createQuery(ClientConstants.CLIENT_BY_ID, Client.class);
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
        TypedQuery<Client> query = entityManager.createQuery(ClientConstants.CLIENTS_AS_LIST, Client.class);
        return query.getResultList();
    }

    @Override
    public void removeClient(Long id) {
        Client entity = entityManager.getReference(Client.class, id);
        entityManager.remove(entity);
    }


    @PersistenceContext
    EntityManager em;

    private static final String CLIENT_BY_ID_QUERY = "select * from client where id = '%s'";
    private static final String ALL_CLIENTS_QUERY = "select * from client";
    private static final String ERROR_MESSAGE_PATTERN = "Client not found by %s: %s";
    private static final String INSERT_CLIENT_QUERY = "insert into client (name, surname, email, password, phone, age)"
            + "values (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_CLIENT_QUERY = "update client set name=?, surname=?, email=? where id=?";
    private static final String DELETE_CLIENT_QUERY = "delete from client where id=?";

    public ClientDaoDBImpl() {
    }

    @Override
    public Client getClientById(Long id) {
        return getClientByQuery(String.format(CLIENT_BY_ID_QUERY, id),
                String.format(ERROR_MESSAGE_PATTERN, "id", id));
    }

    @Override
    public Client saveClient(Client client) {
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_CLIENT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, client.getName());
            statement.setString(2, client.getSurname());
            statement.setString(3, client.getEmail());
            statement.setString(4, client.getPassword());
            statement.setString(5, client.getPhone());
            statement.setInt(6, Integer.parseInt(client.getAge()));
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                client.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return client;
    }

    @Override
    public Client modifyClientCredentials(Client client) {
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CLIENT_QUERY)) {
            int parameterCounter = 1;
            statement.setString(parameterCounter++, client.getName());
            statement.setString(parameterCounter++, client.getSurname());
            statement.setString(parameterCounter++, client.getEmail());
            statement.setLong(parameterCounter, client.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return client;
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = retrieveConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(ALL_CLIENTS_QUERY);
            while (resultSet.next()) {
                Client client = new Client();
                setData(resultSet, client);
                clients.add(client);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return clients;
    }

    @Override
    public void removeClient(Long id) {
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CLIENT_QUERY)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public void update(List<Client> clients) {
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(String.format(UPDATE_CLIENT_QUERY, ""))) {
            for (Client client : clients) {
                statement.setString(1, client.getName());
                statement.setString(2, client.getSurname());
                statement.setString(3, client.getEmail());
                statement.setString(4, client.getPhone());
                statement.setString(5, client.getAge());
                statement.setLong(6, client.getId());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private Client getClientByQuery(String query, String errorMessage) {
        Client client = null;
        try (Connection connection = retrieveConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                client = new Client();
                setData(resultSet, client);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        if (client == null) {
            throw new IllegalArgumentException(errorMessage);
        }
        return client;
    }

    private Connection retrieveConnection() throws SQLException {
        return DBManager.getConnection();
    }

    private void setData(ResultSet resultSet, Client client) throws SQLException {
        client.setId(resultSet.getLong("id"));
        client.setName(resultSet.getString("name"));
        client.setSurname(resultSet.getString("surname"));
        client.setEmail(resultSet.getString("email"));
        client.setPassword(resultSet.getString("password"));
        client.setPhone(resultSet.getString("phone"));
        client.setAge(resultSet.getString("age"));
    }
}
