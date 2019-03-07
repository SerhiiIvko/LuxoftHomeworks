package com.luxoft.ivko.dao.impl;

import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.Server;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DBManagerTest {

    @BeforeClass
    public static void init() throws SQLException {
        org.h2.tools.Server.createTcpServer().start();
        Server.createTcpServer("-tcpPort", "9082", "-tcpAllowOthers").start();
        DBManager.initialize(DBManager.getTestH2DataSource());
    }

    @Test
    public void getConnection() throws SQLException {
        Connection connection = DBManager.getConnection();
        Assert.assertNotNull(connection);
    }

    @Test
    public void getH2DataSource() throws SQLException {
        //GIVEN:
        String expectedUser = "sa";
        String expectedURL = "jdbc:h2:tcp://localhost/~/test";
        String actualUser;
        String actualURL;

        //WHEN:
        JdbcDataSource dataSource = (JdbcDataSource) DBManager.getH2DataSource();
        actualURL = dataSource.getURL();
        actualUser = dataSource.getUser();

        //THEN:
        Assert.assertEquals(expectedURL, actualURL);
        Assert.assertEquals(expectedUser, actualUser);
    }
}
