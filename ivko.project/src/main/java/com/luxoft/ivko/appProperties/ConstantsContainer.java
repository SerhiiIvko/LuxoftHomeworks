package com.luxoft.ivko.appProperties;

public class ConstantsContainer {
    public static final String EXIT_MESSAGE = "You successfully quit program";
    public static final String DEFAULT_ERROR_MESSAGE = "Incorrect input";
    public static final String BACK_TO_MAIN_MENU = "Back to main menu";
    public static final String VALIDATION_EXCEPTION_MESSAGE = "Invalid credentials! Check input and try again!";
    public static final String EMPTY_LIST_EXCEPTION_MESSAGE = "Sorry, but list is empty!";
    public static final String EMAIL_VALIDATOR_PATTERN = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
    public static final String PHONE_VALIDATOR_PATTERN = "^(?:[+][0-9]{2}\\s?[0-9]{3}[-]?[0-9]{3,}|(?:[(][0-9]{3}[)]|" +
            "[0-9]{3})\\s*[-]?\\s*[0-9]{3}[-][0-9]{4})(?:\\s*x\\s*[0-9]+)?";

}
