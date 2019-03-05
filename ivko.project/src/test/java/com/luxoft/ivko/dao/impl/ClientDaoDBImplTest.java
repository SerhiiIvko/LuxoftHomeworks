package com.luxoft.ivko.dao.impl;

import com.luxoft.ivko.dao.ClientDao;
import com.luxoft.ivko.domain.Client;
import org.h2.tools.DeleteDbFiles;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ClientDaoDBImplTest {
    private ClientDao clientDao;
    private Client client;
    private List<Client> clients;

    @BeforeClass
    public static void init() throws SQLException {
        org.h2.tools.Server.createTcpServer().start();
        DBManager.initialize(DBManager.getTestH2DataSource());
    }

    @Before
    public void resetDb() {
        Connection connection;
        try {
            DeleteDbFiles.execute("~", "test1", true);
            connection = DBManager.getConnection();
            Statement statement = connection.createStatement();
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
    public void saveClient() {
        // GIVEN:
        clientDao = new ClientDaoDBImpl();
        Client expectedClient;
        String expectedName = "hello";
        String expectedSurname = "world";
        String expectedEmail = "hello@gmail.com";
        String expectedPassword = "hellohello";
        String expectedPhone = "+380509995577";
        String expectedAge = "45";
        String actualName;
        String actualSurname;
        String actualEmail;
        String actualPassword;
        String actualPhone;
        String actualAge;
        int expectedSize = 1;
        int actualSize;
        client = new Client(expectedName, expectedSurname, expectedEmail, expectedPassword, expectedPhone, expectedAge);

        // WHEN:
        clientDao.saveClient(client);

        // THEN
        clients = clientDao.getAllClients();
        expectedClient = clients.get(0);
        actualName = expectedClient.getName();
        actualSurname = expectedClient.getSurname();
        actualEmail = expectedClient.getEmail();
        actualPassword = expectedClient.getPassword();
        actualPhone = expectedClient.getPhone();
        actualAge = expectedClient.getAge();
        actualSize = clients.size();
        Assert.assertNotNull(expectedClient);
        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedSurname, actualSurname);
        Assert.assertEquals(expectedEmail, actualEmail);
        Assert.assertEquals(expectedPassword, actualPassword);
        Assert.assertEquals(expectedPhone, actualPhone);
        Assert.assertEquals(expectedAge, actualAge);
    }

    @Test
    public void modifyClientCredentials() {
        // GIVEN:
        clientDao = new ClientDaoDBImpl();
        String name = "hello";
        String surname = "world";
        String email = "hello@gmail.com";
        String password = "hellohello";
        String phone = "+380509995577";
        String age = "45";
        String expectedNewName = "elon";
        String expectedNewSurname = "musk";
        String expectedNewEmail = "musk@gmail.com";
        boolean isModified;
        client = new Client(name, surname, email, password, phone, age);
        clientDao.saveClient(client);

        // WHEN:
        isModified = clientDao.modifyClientCredentials(client, expectedNewName, expectedNewSurname, expectedNewEmail);

        // THEN
        Assert.assertTrue(isModified);
    }

    @Test
    public void getClientById() {
        // GIVEN:
        Client expectedClient;
        clientDao = new ClientDaoDBImpl();
        Long clientId = 1L;
        String expectedName = "hello";
        String expectedSurname = "world";
        String expectedEmail = "hello@gmail.com";
        String expectedPassword = "hellohello";
        String expectedPhone = "+380509995577";
        String expectedAge = "45";
        client = new Client(expectedName, expectedSurname, expectedEmail, expectedPassword, expectedPhone, expectedAge);
        clientDao.saveClient(client);

        // WHEN:
        expectedClient = clientDao.getClientById(clientId);

        // THEN
        Assert.assertEquals(expectedClient, client);
    }

    @Test
    public void getAllClients() {
        // GIVEN:
        clientDao = new ClientDaoDBImpl();
        Client expectedClient;
        String expectedName = "hello";
        String expectedSurname = "world";
        String expectedEmail = "hello@gmail.com";
        String expectedPassword = "hellohello";
        String expectedPhone = "+380509995577";
        String expectedAge = "45";
        int expectedSize = 1;
        int actualSize;
        client = new Client(expectedName, expectedSurname, expectedEmail, expectedPassword, expectedPhone, expectedAge);

        // WHEN:
        clientDao.saveClient(client);

        // THEN
        clients = clientDao.getAllClients();
        expectedClient = clients.get(0);
        actualSize = clients.size();
        Assert.assertNotNull(clients);
        Assert.assertEquals(client, expectedClient);
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void removeClient() {
        // GIVEN:
        clientDao = new ClientDaoDBImpl();
        Long clientId = 1L;
        String expectedName = "hello";
        String expectedSurname = "world";
        String expectedEmail = "hello@gmail.com";
        String expectedPassword = "hellohello";
        String expectedPhone = "+380509995577";
        String expectedAge = "45";
        int expectedSize = 0;
        int actualSize;
        client = new Client(expectedName, expectedSurname, expectedEmail, expectedPassword, expectedPhone, expectedAge);
        clientDao.saveClient(client);

        // WHEN:
        clientDao.removeClient(clientId);

        // THEN
        clients = clientDao.getAllClients();
        actualSize = clients.size();
        Assert.assertEquals(expectedSize, actualSize);
    }
}