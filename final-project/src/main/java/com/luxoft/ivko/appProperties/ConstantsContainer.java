package com.luxoft.ivko.appProperties;

public class ConstantsContainer {
    public static final int MAX_INPUT_DATA_LENGTH = 28;

    public static final String PRODUCT_BY_ID = "SELECT u FROM product u where u.id = :id ORDER BY u.id";
    public static final String PRODUCTS_AS_LIST = "SELECT u FROM product u ORDER BY u.id";

    public static final String CLIENT_BY_ID = "SELECT u FROM client u where u.id = :id ORDER BY u.id";
    public static final String CLIENTS_AS_LIST = "SELECT u FROM client u ORDER BY u.id";

    public static final String EMAIL_VALIDATOR_PATTERN = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
    public static final String PHONE_VALIDATOR_PATTERN = "^(?:[+][0-9]{2}\\s?[0-9]{3}[-]?[0-9]{3,}|(?:[(][0-9]{3}[)]|" +
            "[0-9]{3})\\s*[-]?\\s*[0-9]{3}[-][0-9]{4})(?:\\s*x\\s*[0-9]+)?";
}
