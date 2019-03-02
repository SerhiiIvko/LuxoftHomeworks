package com.luxoft.ivko.dao.impl;

import com.luxoft.ivko.dao.ClientDao;
import com.luxoft.ivko.domain.Client;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoDBImpl implements ClientDao {
    private static final String CLIENT_BY_ID_QUERY = "select * from client where id = '%s'";
    private static final String ALL_CLIENTS_QUERY = "select * from client";
    private static final String ERROR_MESSAGE_PATTERN = "Client not found by %s: %s";
    private static final String INSERT_CLIENT_QUERY = "insert into client (name, surname, email, password, phone, age) values (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_CLIENT_QUERY = "update client set name=?, surname=?, phone=?, email=?%s where id=?, age=?";
    private static final String UPDATE_PASSWORD_PART = ", password=?";
    private static final String DELETE_CLIENT_QUERY = "delete from client where id=?";

//    public ClientDaoDBImpl() {
//        Connection connection = null;
//        Statement statement = null;
//        try {
//            connection = DBManager.getConnection();
//            statement = connection.createStatement();
//            statement.executeQuery("DROP TABLE IF EXISTS client, product;");
//            statement.executeQuery("CREATE TABLE client (\n" +
//                    "id INT PRIMARY KEY AUTO_INCREMENT,\n" +
//                    "name VARCHAR(28),\n" +
//                    "surname VARCHAR(28),\n" +
//                    "email VARCHAR(28),\n" +
//                    "password VARCHAR(28),\n" +
//                    "phone VARCHAR(28),\n" +
//                    "age INT);");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    e.getMessage();
//                }
//            }
//            if (statement != null){
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                    e.getMessage();
//                }
//            }
//        }
//    }

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
            throw new IllegalArgumentException("Failed to insert manager into DB", e);
        }
//        return client;
        return false;
    }

    @Override
    public boolean modifyClientCredentials(Client client) {
        boolean needUpdatePassword = StringUtils.isNotEmpty(client.getPassword());
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(String.format(UPDATE_CLIENT_QUERY,
                     needUpdatePassword ? UPDATE_PASSWORD_PART : ""))) {
            int parameterCounter = 1;
            statement.setString(parameterCounter++, client.getName());
            statement.setString(parameterCounter++, client.getSurname());
            statement.setString(parameterCounter++, client.getEmail());
            statement.setInt(parameterCounter++, Integer.parseInt(client.getAge()));
            if (needUpdatePassword) {
                statement.setString(parameterCounter++, client.getPassword());
            }
            statement.setLong(parameterCounter, client.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException("Failed to update manager", e);
        }
//        return client;
        return false;
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
                client.setPassword(resultSet.getString("password"));
                client.setAge(resultSet.getString("age"));
                clients.add(client);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Failed to load manager from DB", e);
        }
        return clients;
    }

    @Override
    public boolean removeClient(Long id) {
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CLIENT_QUERY)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException("Failed to delete manager", e);
        }
        return false;
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
                client.setAge(resultSet.getString("age"));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to load manager from DB", e);
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
