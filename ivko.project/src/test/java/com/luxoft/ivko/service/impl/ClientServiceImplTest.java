package com.luxoft.ivko.service.impl;

import com.luxoft.ivko.dao.ClientDao;
import com.luxoft.ivko.dao.impl.ClientDaoDBImpl;
import com.luxoft.ivko.dao.impl.DBManager;
import com.luxoft.ivko.domain.Client;
import com.luxoft.ivko.service.ClientService;
import com.luxoft.ivko.web.dto.ClientCreateDto;
import com.luxoft.ivko.web.dto.ClientViewDto;
import org.h2.tools.DeleteDbFiles;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientServiceImplTest {

    private ClientService clientService;
    private Client client;
    private Statement statement;
    private ResultSet resultSet;

    @BeforeClass
    public static void init() throws SQLException {
        org.h2.tools.Server.createTcpServer().start();
        DBManager.initialize(DBManager.getTestH2DataSource());
    }

    @Before
    public void resetDb() {
        Connection connection;
        try {
            DeleteDbFiles.execute("~", "test", true);
            connection = DBManager.getConnection();
            statement = connection.createStatement();
            statement.execute("DROP TABLE if exists client");
            statement.execute("CREATE TABLE client (\n" +
                    "id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "name VARCHAR(28),\n" +
                    "surname VARCHAR(28),\n" +
                    "email VARCHAR(28),\n" +
                    "password VARCHAR(28),\n" +
                    "phone VARCHAR(28),\n" +
                    "age INT);");
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Test
    public void createClient() throws SQLException {
        //GIVEN:
        clientService = new ClientServiceImpl();
        String clientName = "Jimm";
        String clientSurname = "Carry";
        String clientEmail = "jimm@co.uk";
        String clientPassword = "123456789";
        String clientPhone = "+380954447744";
        String clientAge = "25";

        //WHEN:
        ClientCreateDto clientCreateDto = new ClientCreateDto(clientName, clientSurname, clientEmail, clientPassword,
                clientPhone, clientAge);

        //THEN:
        clientService.registerClient(clientCreateDto);

        Assert.assertNotNull(clientCreateDto);
    }

    @Test
    public void modifyClient() {
        //GIVEN:
        clientService = new ClientServiceImpl();
        String clientName = "Jimm";
        String clientSurname = "Carry";
        String clientEmail = "jimm@co.uk";
        String clientPassword = "123456789";
        String clientPhone = "+380954447744";
        String clientAge = "25";


        //WHEN:
        String newClientName = "John";
        String newClientSurname = "Snow";
        String newClientEmail = "snow@co.uk";
        String newClientPassword = "123456780";
        String newClientPhone = "+380954447755";
        String newClientAge = "45";
        client = new Client(clientName, clientSurname, clientEmail, clientPassword, clientPhone, clientAge);
        ClientCreateDto clientCreateDto = new ClientCreateDto(clientName, clientSurname, clientEmail, clientPassword,
                clientPhone, clientAge);
        clientService.registerClient(clientCreateDto);
        ClientViewDto clientCreateDto1;

        //THEN:
//        clientCreateDto1=clientService.updateClient(clientCreateDto);
    }

    @Test
    public void deleteClient() {

    }

    @Test
    public void showAllClients() {

    }
}