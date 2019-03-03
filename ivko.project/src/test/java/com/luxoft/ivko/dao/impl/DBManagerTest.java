package com.luxoft.ivko.dao.impl;

import org.h2.tools.DeleteDbFiles;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManagerTest {
    Connection connection;
    @BeforeClass
    public static void init() throws SQLException {
        org.h2.tools.Server.createTcpServer().start();
        DBManager.initialize(DBManager.getH2DataSource());
    }

//    @Before
//    public void resetDb() {
//        Connection connection;
//        try {
//            DeleteDbFiles.execute("~", "test", true);
//            connection = DBManager.getConnection();
//            Statement statement = connection.createStatement();
//            statement.execute("DROP TABLE IF EXISTS client, product;");
//            statement.execute("CREATE TABLE client (\n" +
//                    "id INT PRIMARY KEY AUTO_INCREMENT,\n" +
//                    "name VARCHAR(28),\n" +
//                    "surname VARCHAR(28),\n" +
//                    "email VARCHAR(28),\n" +
//                    "password VARCHAR(28),\n" +
//                    "phone VARCHAR(28),\n" +
//                    "age INT);");
//            statement.execute("insert into client values(1, 'John', 'Connor', 't1000@gmail.com', 'helloworld', '+380504556622', '24')");
////            statement.execute("insert into contacts values(2, 'Sarah Connor')");
////            statement.execute("insert into contacts values(3, 'Bill Clinton')");
////            statement.execute("insert into contacts values(4, 'Barak Obama')");
////            statement.execute("insert into contacts values(5, 'Bill Gates')");
////            statement.execute("insert into contacts values(6, 'Linus Torvalds')");
////            statement.execute("insert into contacts values(7, 'Steeve Jobs')");
////            statement.execute("insert into contacts values(8, 'Alice Cooper')");
////            statement.execute("insert into contacts values(9, 'Kenny McCormick')");
////            statement.execute("insert into contacts values(10, 'Eric Cartmann')");
//        } catch (SQLException e) {
//           e.getMessage();
//        }
//    }

//    @Test
//    public void initialize() {
//    }

    @Test
    public void getConnection() throws SQLException {
        connection = DBManager.getConnection();
        Assert.assertNotNull(connection);
    }

    @Test
    public void getH2DataSource() {

    }

    @Test
    public void stopDb() throws SQLException {
//        DBManager.initialize(DBManager.getH2DataSource());
        connection = DBManager.getConnection();
        DBManager.stopDb();
        Assert.assertNotNull(connection);
    }
}
