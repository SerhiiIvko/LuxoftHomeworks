package com.luxoft.ivko.dao.impl;

import com.luxoft.ivko.appProperties.ClientConstants;
import com.luxoft.ivko.dao.ClientDao;
import com.luxoft.ivko.domain.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoDBImpl implements ClientDao {

    public ClientDaoDBImpl() {
    }

    @Override
    public Client getClientById(Long id) {
        return getClientByQuery(String.format(ClientConstants.CLIENT_BY_ID_QUERY, id),
                String.format(ClientConstants.ERROR_MESSAGE_PATTERN, "id", id));
    }

    @Override
    public Client saveClient(Client client) {
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(ClientConstants.INSERT_CLIENT_QUERY,
                     Statement.RETURN_GENERATED_KEYS)) {
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
            throw new IllegalArgumentException(ClientConstants.FAILED_TO_INSERT_CLIENT_INTO_DB, e);
        }
        return client;
    }

    @Override
    public Client modifyClientCredentials(Client client) {
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(ClientConstants.UPDATE_CLIENT_QUERY)) {
            int parameterCounter = 1;
            statement.setString(parameterCounter++, client.getName());
            statement.setString(parameterCounter++, client.getSurname());
            statement.setString(parameterCounter++, client.getEmail());
            statement.setLong(parameterCounter, client.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ClientConstants.FAILED_TO_UPDATE_CLIENT, e);
        }
        return client;
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = retrieveConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(ClientConstants.ALL_CLIENTS_QUERY);
            while (resultSet.next()) {
                Client client = new Client();
                setData(resultSet, client);
                clients.add(client);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(ClientConstants.FAILED_TO_LOAD_CLIENT_FROM_DB, e);
        }
        return clients;
    }

    @Override
    public void removeClient(Long id) {
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(ClientConstants.DELETE_CLIENT_QUERY)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(ClientConstants.FAILED_TO_DELETE_CLIENT, e);
        }
    }

    @Override
    public void update(List<Client> clients) {
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(String.format(ClientConstants.UPDATE_CLIENT_QUERY, ""))) {
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
            throw new IllegalArgumentException(ClientConstants.FAILED_TO_UPDATE_CLIENT, e);
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
            throw new IllegalArgumentException(ClientConstants.FAILED_TO_LOAD_CLIENT_FROM_DB, e);
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
