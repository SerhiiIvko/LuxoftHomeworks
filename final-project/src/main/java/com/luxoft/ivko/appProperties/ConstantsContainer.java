package com.luxoft.ivko.appProperties;

public class ConstantsContainer {
    public static final int MAX_INPUT_DATA_LENGTH = 28;

    public static final String PRODUCT_BY_ID = "from Product u where u.id = :id order by u.id";
    public static final String PRODUCTS_AS_LIST = "from Product";
    public static final String CLIENT_BY_ID = "from Client u where u.id = :id order by u.id";
    public static final String CLIENTS_AS_LIST = "from Client";

    static final String FAILED_TO_LOAD_FILE = "Failed to load file";

    static final String PROPERTY_NAME_DATABASE_DRIVER = "DB_DRIVER_CLASS";
    static final String PROPERTY_NAME_DATABASE_URL = "DB_URL";
    static final String PROPERTY_NAME_DATABASE_USERNAME = "DB_USERNAME";
    static final String PROPERTY_NAME_DATABASE_PASSWORD = "DB_PASSWORD";

    static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    static final String PROPERTY_NAME_HIBERNATE_DLL = "hibernate.hbm2ddl.auto";

    static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";

    static final String PROPERTY_FILE_NAME = "application.properties";

    public static final String EMAIL_VALIDATOR_PATTERN = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
    public static final String PHONE_VALIDATOR_PATTERN = "^(?:[+][0-9]{2}\\s?[0-9]{3}[-]?[0-9]{3,}|(?:[(][0-9]{3}[)]|" +
            "[0-9]{3})\\s*[-]?\\s*[0-9]{3}[-][0-9]{4})(?:\\s*x\\s*[0-9]+)?";
}