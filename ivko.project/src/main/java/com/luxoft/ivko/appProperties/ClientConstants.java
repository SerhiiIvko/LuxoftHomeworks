package com.luxoft.ivko.appProperties;

public class ClientConstants {

    public static final String CLIENT_BY_ID_QUERY = "select * from client where id = '%s'";
    public static final String ALL_CLIENTS_QUERY = "select * from client";
    public static final String ERROR_MESSAGE_PATTERN = "Client not found by %s: %s";
    public static final String INSERT_CLIENT_QUERY = "insert into client (name, surname, email, password, phone, age)"
            + "values (?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_CLIENT_QUERY = "update client set name=?, surname=?, email=? where id=?";
    public static final String DELETE_CLIENT_QUERY = "delete from client where id=?";

    public static final String FAILED_TO_LOAD_CLIENT_FROM_DB = "Failed to load client from DB";
    public static final String FAILED_TO_INSERT_CLIENT_INTO_DB = "Failed to insert client into DB";
    public static final String FAILED_TO_UPDATE_CLIENT = "Failed to update client";
    public static final String FAILED_TO_DELETE_CLIENT = "Failed to delete client";

}
