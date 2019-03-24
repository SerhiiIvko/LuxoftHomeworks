package com.luxoft.ivko.appProperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {
    private static final String PROPERTY_FILE_NAME = "application.properties";
    private static PropertiesManager Instance;
    private Properties properties;

    private PropertiesManager() {
    }

    public static PropertiesManager getInstance() {
        if (Instance == null) {
            Instance = new PropertiesManager();
        }
        return Instance;
    }

    public Properties getApplicationProperties() {
        if (properties == null) {
            properties = new Properties();
            try (InputStream stream = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream(PROPERTY_FILE_NAME)) {
                properties.load(stream);
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to load file", e);
            }
        }
        return properties;
    }
}
