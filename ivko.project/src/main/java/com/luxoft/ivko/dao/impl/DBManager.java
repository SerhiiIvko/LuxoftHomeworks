package com.luxoft.ivko.dao.impl;

import com.luxoft.ivko.appProperties.PropertiesManager;
import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {
    private static DataSource DataSource;
    private static boolean isInitialize = false;

    private DBManager() {
    }

    public static void initialize(DataSource dataSource) {
        DataSource = dataSource;
        isInitialize = true;
    }

    public static Connection getConnection() throws SQLException {
        if (!isInitialize) {
            throw new IllegalStateException("DB is not initialized yet");
        }
        return DataSource.getConnection();
    }

    public static DataSource getH2DataSource() {
        JdbcDataSource h2Source = null;
        try {
            Properties properties = loadProperties();
            h2Source = new JdbcDataSource();
            h2Source.setURL(properties.getProperty("DB_URL"));
            h2Source.setUser(properties.getProperty("DB_USERNAME"));
            h2Source.setPassword(properties.getProperty("DB_PASSWORD"));
        } catch (IOException e) {
            e.getMessage();
        }
        return h2Source;
    }

    public static DataSource getTestH2DataSource() {
        JdbcDataSource h2Source = null;
        try {
            Properties properties = loadProperties();
            h2Source = new JdbcDataSource();
            h2Source.setURL(properties.getProperty("TEST_H2_URL"));
            h2Source.setUser(properties.getProperty("TEST_H2_USERNAME"));
            h2Source.setPassword(properties.getProperty("TEST_H2_PASSWORD"));
        } catch (IOException e) {
            e.getMessage();
        }
        return h2Source;
    }

    public static void stopDb() {
        if (DataSource != null) {
            try {
                DataSource.getConnection().close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Properties loadProperties() throws IOException {
        PropertiesManager propertiesManager = PropertiesManager.getInstance();
        return propertiesManager.getApplicationProperties();
    }
}
