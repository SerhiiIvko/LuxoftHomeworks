package com.luxoft.ivko.dao.impl;

import com.luxoft.ivko.dao.ClientDao;
import com.luxoft.ivko.domain.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoDBImpl implements ClientDao {
    private static final String CLIENT_BY_ID_QUERY = "select * from client where id = '%s'";
    private static final String ALL_CLIENTS_QUERY = "select * from client";
    private static final String ERROR_MESSAGE_PATTERN = "Client not found by %s: %s";
    private static final String INSERT_CLIENT_QUERY = "insert into client (name, surname, email, password, phone, age) "
            + "values (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_CLIENT_QUERY = "update client set name=?, surname=?, email=? where id=?";
    private static final String DELETE_CLIENT_QUERY = "delete from client where id=?";

    @Override
    public boolean saveClient(Client client) {
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
            throw new IllegalArgumentException("Failed to insert client into DB", e);
        }
        return true;
    }

    @Override
    public boolean modifyClientCredentials(Client client, String newName, String newSurname, String newEmail) {
        int isUpdated;
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CLIENT_QUERY)) {
            int parameterCounter = 1;
            statement.setString(parameterCounter++, newName);
            statement.setString(parameterCounter++, newSurname);
            statement.setString(parameterCounter++, newEmail);
            statement.setLong(parameterCounter, client.getId());
            statement.executeUpdate();
            isUpdated = statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException("Failed to update client", e);
        }
        return isUpdated > 0;
    }

    @Override
    public Client getClientById(Long id) {
        return getClientByQuery(String.format(CLIENT_BY_ID_QUERY, id),
                String.format(ERROR_MESSAGE_PATTERN, "id", id));
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = retrieveConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(ALL_CLIENTS_QUERY);
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getLong("id"));
                client.setName(resultSet.getString("name"));
                client.setSurname(resultSet.getString("surname"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getString("phone"));
                client.setPassword(resultSet.getString("password"));
                client.setAge(resultSet.getString("age"));
                clients.add(client);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Failed to load client from DB", e);
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
            throw new IllegalArgumentException("Failed to delete client", e);
        }
    }

    private Client getClientByQuery(String query, String errorMessage) {
        Client client = null;
        try (Connection connection = retrieveConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                client = new Client();
                client.setId(resultSet.getLong("id"));
                client.setName(resultSet.getString("name"));
                client.setSurname(resultSet.getString("surname"));
                client.setEmail(resultSet.getString("email"));
                client.setPassword(resultSet.getString("password"));
                client.setPhone(resultSet.getString("phone"));
                client.setAge(resultSet.getString("age"));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to load client from DB", e);
        }
        if (client == null) {
            throw new IllegalArgumentException(errorMessage);
        }
        return client;
    }

    private Connection retrieveConnection() throws SQLException {
        return DBManager.getConnection();
    }
}
