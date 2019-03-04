package com.luxoft.ivko.dao.impl;

import org.h2.tools.DeleteDbFiles;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientDaoDBImplTest {

    @BeforeClass
    public static void init() throws SQLException {
        org.h2.tools.Server.createTcpServer().start();
        DBManager.initialize(DBManager.getH2DataSource());
    }

    @Before
    public void resetDb() {
        Connection connection;
        try {
            DeleteDbFiles.execute("~", "test", true);
            connection = DBManager.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS client, product;");
            statement.execute("CREATE TABLE client (\n" +
                    "id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "name VARCHAR(28),\n" +
                    "surname VARCHAR(28),\n" +
                    "email VARCHAR(28),\n" +
                    "password VARCHAR(28),\n" +
                    "phone VARCHAR(28),\n" +
                    "age INT);");
            statement.execute("insert into client values(1, 'John', 'Connor', 't1000@gmail.com', 'helloworld', '+380504556622', '24')");
        } catch (SQLException e) {
            e.getMessage();
        }
    }


    @Test
    public void saveClient() {
        // GIVEN:


        // WHEN:


        // THEN

    }

    @Test
    public void modifyClientCredentials() {
        // GIVEN:


        // WHEN:


        // THEN

    }

    @Test
    public void getClientById() {
        // GIVEN:


        // WHEN:


        // THEN

    }

    @Test
    public void getAllClients() {
        // GIVEN:


        // WHEN:


        // THEN

    }

    @Test
    public void removeClient() {
        // GIVEN:


        // WHEN:


        // THEN

    }
}